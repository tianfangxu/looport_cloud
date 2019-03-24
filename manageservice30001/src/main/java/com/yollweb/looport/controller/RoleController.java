package com.yollweb.looport.controller;

import com.yollweb.looport.content.ResultModel;
import com.yollweb.looport.process.request.QueryRoleModel;
import com.yollweb.looport.service.AcctRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    AcctRoleService acctRoleService;

    @RequestMapping("roleAll")
    public ResultModel roleAll(@RequestBody QueryRoleModel model){
        return acctRoleService.roleAll(model);
    }

    @RequestMapping("addRole")
    public ResultModel roladdRoleeAll(@RequestBody QueryRoleModel model){
        return acctRoleService.addRole(model);
    }
}
