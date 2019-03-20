package com.yollweb.looport.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yollweb.looport.content.CodeState;
import com.yollweb.looport.content.ResultModel;
import com.yollweb.looport.entity.AcctUserEntity;
import com.yollweb.looport.process.request.UserModel;
import com.yollweb.looport.service.AcctUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LoginController {

    @Autowired
    AcctUserService acctUserService;

    @RequestMapping("all")
    //@HystrixCommand(fallbackMethod = "getErrorBack") //一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    public ResultModel getAll(){
        return acctUserService.getAll();
    }

    @RequestMapping("login")
    @HystrixCommand(fallbackMethod = "getErrorBack")
    public ResultModel login(@RequestBody UserModel model){
        return acctUserService.login(model);
    }

    public ResultModel getErrorBack(){
        ResultModel resultModel = new ResultModel();
        resultModel.setMsg("服务出错，请稍后重试").setCode(CodeState.MANAGE_ERROR);
        return resultModel;
    }

}
