package com.yollweb.looport.controller;

import com.yollweb.looport.content.ResultModel;
import com.yollweb.looport.process.request.QueryMenuModel;
import com.yollweb.looport.service.AcctMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

    @Autowired
    AcctMenuService acctMenuService;

    @RequestMapping("menuall")
    public ResultModel getAll(@RequestBody QueryMenuModel model){
        return acctMenuService.getAll(model);
    }

    @RequestMapping("addMenu")
    public ResultModel addMenu(@RequestBody QueryMenuModel model){
        return acctMenuService.addMenu(model);
    }

    @RequestMapping("updateMenuMethod")
    public ResultModel updateMenuMethod(@RequestBody QueryMenuModel model){
        return acctMenuService.updateMenuMethod(model);
    }

    @RequestMapping("deleteMenu")
    public ResultModel deleteMenu(@RequestBody QueryMenuModel model){
        return acctMenuService.deleteMenu(model);
    }

}
