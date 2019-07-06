package com.yollweb.looport.controller;

import com.yollweb.looport.content.CodeState;
import com.yollweb.looport.content.ResultModel;
import com.yollweb.looport.process.request.QueryDeptModel;
import com.yollweb.looport.redis.RedisUtil;
import com.yollweb.looport.service.AcctDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DeptController {

    @Autowired
    AcctDeptService acctDeptService;

    @Autowired
    RedisUtil redisUtil;

    @RequestMapping("deptall")
    public ResultModel deptall(@RequestBody QueryDeptModel model, HttpServletRequest request){
        redisUtil.setIntoParam(request.getHeader(CodeState.SESSIONID),model);
        return acctDeptService.deptall(model);
    }

    @RequestMapping("addDept")
    public ResultModel addDept(@RequestBody QueryDeptModel model, HttpServletRequest request){
        redisUtil.setIntoParam(request.getHeader(CodeState.SESSIONID),model);
        return acctDeptService.addDept(model);
    }

}
