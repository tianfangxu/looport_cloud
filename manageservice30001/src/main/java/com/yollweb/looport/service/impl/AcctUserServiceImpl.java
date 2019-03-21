package com.yollweb.looport.service.impl;

import com.google.gson.Gson;
import com.yollweb.looport.content.CodeState;
import com.yollweb.looport.content.ResultModel;
import com.yollweb.looport.dao.AcctUserMapper;
import com.yollweb.looport.entity.AcctUserEntity;
import com.yollweb.looport.process.request.LoginUserModel;
import com.yollweb.looport.process.request.SaveUserModel;
import com.yollweb.looport.redis.RedisUtil;
import com.yollweb.looport.service.AcctUserService;
import com.yollweb.looport.utils.DateUnit;
import com.yollweb.looport.utils.Md5Util;
import com.yollweb.looport.utils.StringUnit;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class AcctUserServiceImpl implements AcctUserService {

    @Autowired
    AcctUserMapper userMapper;

    @Autowired
    RedisUtil redisUtil;

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
    public ResultModel login(LoginUserModel model) {
        ResultModel rm = new ResultModel();
        List<AcctUserEntity> list = userMapper.login(model.getName(), model.getPassword());
        if (list != null && list.size() == 1){
            String sessionId = Md5Util.encode(DateUnit.getTime14());
            AcctUserEntity entity = list.get(0);
            redisUtil.setCache(sessionId, new Gson().toJson(entity));
            HashMap<String,Object> map = new HashMap<>();
            map.put("sessionId",sessionId);
            map.put("user",entity.getNike());
            rm.setSuccess(true);
            rm.setCode(CodeState.MANAGE_SUCCESS);
            rm.setResult(map);
            rm.setMsg("操作成功");
            return rm;
        }
        rm.setMsg("该用户不存在");
        return rm;
    }

    @Override
    public ResultModel saveUser(SaveUserModel model) {
        ResultModel rm = new ResultModel();
        if (model.getUserEntity() == null){
            rm.setMsg("登陆过期啦，快去登陆哟~").setCode(CodeState.MANAGE_ERROR);
            return rm;
        }
        List<AcctUserEntity> exist = userMapper.queryByname(model.getName());
        if(exist != null && exist.size() > 0){
            rm.setMsg("用户已经存在啦，换一个~").setCode(CodeState.MANAGE_ERROR);
            return rm;
        }
        AcctUserEntity entity = new AcctUserEntity();
        BeanUtils.copyProperties(model,entity);
        entity.createMethod(model.getUserEntity());
        entity.setId(StringUnit.creatUUID());
        userMapper.saveUser(entity);
        rm.setSuccess(true);
        rm.setCode(CodeState.MANAGE_SUCCESS);
        rm.setResult(entity.getId());
        rm.setMsg("操作成功");
        return rm;
    }
}
