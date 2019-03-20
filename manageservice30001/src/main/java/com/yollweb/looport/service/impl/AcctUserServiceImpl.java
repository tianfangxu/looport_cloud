package com.yollweb.looport.service.impl;

import com.yollweb.looport.content.CodeState;
import com.yollweb.looport.content.ResultModel;
import com.yollweb.looport.dao.AcctUserMapper;
import com.yollweb.looport.entity.AcctUserEntity;
import com.yollweb.looport.process.request.UserModel;
import com.yollweb.looport.service.AcctUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AcctUserServiceImpl implements AcctUserService {

    @Autowired
    AcctUserMapper userMapper;

    @Override
    public ResultModel getAll() {
        List<AcctUserEntity> acctUserEntities = userMapper.queryAll();
        ResultModel rm = new ResultModel();
        rm.setSuccess(true);
        rm.setCode(CodeState.MANAGE_SUCCESS);
        rm.setResult(acctUserEntities);
        rm.setMsg("操作成功");
        return rm;
    }

    @Override
    public ResultModel login(UserModel model) {
        ResultModel rm = new ResultModel();
        List<AcctUserEntity> list = userMapper.login(model.getName(), model.getPassword());
        if (list != null && list.size() == 1){
            rm.setSuccess(true);
            rm.setCode(CodeState.MANAGE_SUCCESS);
            rm.setResult(list.get(0));
            rm.setMsg("操作成功");
            return rm;
        }
        rm.setMsg("该用户不存在");
        return rm;
    }
}
