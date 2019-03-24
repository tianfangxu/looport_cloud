package com.yollweb.looport.service.impl;

import com.yollweb.looport.content.CodeState;
import com.yollweb.looport.content.ResultModel;
import com.yollweb.looport.dao.AcctRoleMapper;
import com.yollweb.looport.entity.AcctRoleEntity;
import com.yollweb.looport.process.request.QueryRoleModel;
import com.yollweb.looport.service.AcctRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AcctRoleServiceImpl implements AcctRoleService {

    @Autowired
    AcctRoleMapper acctRoleMapper;

    @Override
    public ResultModel roleAll(QueryRoleModel model) {
        ResultModel resultModel = new ResultModel();
        model.setPage((model.getPage()-1) * model.getRows());

        List<AcctRoleEntity> list = acctRoleMapper.queryAll(model);
        int count = acctRoleMapper.queryCount(model);

        resultModel.setTotal(count);
        resultModel.setResult(list);
        resultModel.setSuccess(true);
        resultModel.setCode(CodeState.MANAGE_SUCCESS);
        resultModel.setMsg("操作成功");
        return resultModel;
    }

    @Override
    public ResultModel addRole(QueryRoleModel model) {
        ResultModel resultModel = new ResultModel();
        acctRoleMapper.addRole(model);
        resultModel.setSuccess(true);
        resultModel.setCode(CodeState.MANAGE_SUCCESS);
        resultModel.setMsg("操作成功");
        return resultModel;
    }
}
