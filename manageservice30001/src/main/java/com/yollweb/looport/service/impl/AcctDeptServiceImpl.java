package com.yollweb.looport.service.impl;

import com.yollweb.looport.content.CodeState;
import com.yollweb.looport.content.ResultModel;
import com.yollweb.looport.dao.AcctDeptMapper;
import com.yollweb.looport.entity.AcctDeptEntity;
import com.yollweb.looport.process.request.QueryDeptModel;
import com.yollweb.looport.service.AcctDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AcctDeptServiceImpl implements AcctDeptService {

    @Autowired
    AcctDeptMapper acctDeptMapper;

    @Override
    public ResultModel deptall(QueryDeptModel model) {
        ResultModel rm = new ResultModel();
        List<AcctDeptEntity> res = acctDeptMapper.queryAll(model);
        rm.setSuccess(true);
        rm.setCode(CodeState.MANAGE_SUCCESS);
        rm.setResult(res);
        Integer count = acctDeptMapper.queryCount(model);
        rm.setTotal(count);
        return rm;
    }

    @Override
    public ResultModel addDept(QueryDeptModel model) {
        ResultModel rm = new ResultModel();
        acctDeptMapper.saveDept(model);
        rm.setSuccess(true);
        rm.setCode(CodeState.MANAGE_SUCCESS);
        return rm;
    }
}
