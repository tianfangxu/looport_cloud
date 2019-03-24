package com.yollweb.looport.service.impl;

import com.yollweb.looport.content.CodeState;
import com.yollweb.looport.content.ResultModel;
import com.yollweb.looport.dao.AcctMenuMapper;
import com.yollweb.looport.entity.AcctMenuEntity;
import com.yollweb.looport.process.request.QueryMenuModel;
import com.yollweb.looport.process.response.MenuResponseModel;
import com.yollweb.looport.service.AcctMenuService;
import com.yollweb.looport.utils.StringUnit;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AcctMenuServiceImpl implements AcctMenuService {

    @Autowired
    AcctMenuMapper acctMenuMapper;

    @Override
    public ResultModel getAll(QueryMenuModel model) {
        ResultModel resultModel = new ResultModel();
        model.setPage((model.getPage()-1) * model.getRows());
        ArrayList<MenuResponseModel> arrayList = new ArrayList<>();

        //先查出所有1级菜单
        model.setLevel("1");
        List<AcctMenuEntity> list = acctMenuMapper.queryAll(model);
        Integer count = acctMenuMapper.queryAllCount(model);

        //查出1级菜单下所有2级菜单
        QueryMenuModel queryMenuModel = new QueryMenuModel();
        queryMenuModel.setPage(0);
        queryMenuModel.setRows(10000);
        for (AcctMenuEntity entity:list) {
            MenuResponseModel menu = new MenuResponseModel();
            queryMenuModel.setPid(entity.getId());
            List<AcctMenuEntity> tempList = acctMenuMapper.queryAll(queryMenuModel);
            BeanUtils.copyProperties(entity,menu);
            menu.setList(tempList);
            arrayList.add(menu);
        }

        resultModel.setTotal(count);
        resultModel.setResult(arrayList);
        resultModel.setSuccess(true);
        resultModel.setCode(CodeState.MANAGE_SUCCESS);
        resultModel.setMsg("操作成功");
        return resultModel;
    }

    @Override
    public ResultModel updateMenuMethod(QueryMenuModel model) {
        ResultModel resultModel = new ResultModel();
        acctMenuMapper.updateMethods(model);
        resultModel.setSuccess(true);
        resultModel.setCode(CodeState.MANAGE_SUCCESS);
        resultModel.setMsg("操作成功");
        return resultModel;
    }

    @Override
    public ResultModel addMenu(QueryMenuModel model) {
        ResultModel resultModel = new ResultModel();
        acctMenuMapper.addMenu(model);
        resultModel.setSuccess(true);
        resultModel.setCode(CodeState.MANAGE_SUCCESS);
        resultModel.setMsg("操作成功");
        return resultModel;
    }

    @Override
    public ResultModel deleteMenu(QueryMenuModel model) {
        ResultModel resultModel = new ResultModel();
        if(StringUnit.isNullOrEmpty(model.getLevel())){
            resultModel.setMsg("信息不完整哦~").setCode(CodeState.MANAGE_ERROR);
            return resultModel;
        }
        if(StringUnit.isNullOrEmpty(model.getId())){
            resultModel.setMsg("信息不完整哦~").setCode(CodeState.MANAGE_ERROR);
            return resultModel;
        }
        if("2".equals(model.getLevel())){
            //删除当前菜单
            acctMenuMapper.deleteMenuById(model);
        }else if("1".equals(model.getLevel())){
            //删除当前及子菜单
            acctMenuMapper.deleteMenuById(model);
            acctMenuMapper.deleteMenuByPid(model);
        }
        resultModel.setSuccess(true);
        resultModel.setCode(CodeState.MANAGE_SUCCESS);
        resultModel.setMsg("操作成功");
        return resultModel;
    }
}
