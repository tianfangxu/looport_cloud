package com.yollweb.looport.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yollweb.looport.content.CodeState;
import com.yollweb.looport.content.ResultModel;
import com.yollweb.looport.process.request.LoginUserModel;
import com.yollweb.looport.process.request.SaveUserModel;
import com.yollweb.looport.redis.RedisUtil;
import com.yollweb.looport.service.AcctUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {

    @Autowired
    AcctUserService acctUserService;

    @Autowired
    RedisUtil redisUtil;

    @RequestMapping("all")
    @HystrixCommand(defaultFallback = "getErrorBack")
    public ResultModel getAll(){
        return acctUserService.getAll();
    }

    @RequestMapping("login")
    @HystrixCommand(defaultFallback = "getErrorBack")//一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    public ResultModel login(HttpServletRequest request, @RequestBody LoginUserModel model){
        System.out.println(request.getAttribute("user"));
        return acctUserService.login(model);
    }

    @RequestMapping("save")
    @HystrixCommand(defaultFallback = "getErrorBack")
    public ResultModel save(HttpServletRequest request, @RequestBody SaveUserModel model){
        redisUtil.setIntoParam(request.getHeader(CodeState.SESSIONID),model);
        return acctUserService.saveUser(model);
    }

    public ResultModel getErrorBack(){
        ResultModel resultModel = new ResultModel();
        resultModel.setMsg("服务出错，请稍后重试").setCode(CodeState.MANAGE_ERROR);
        return resultModel;
    }

}
