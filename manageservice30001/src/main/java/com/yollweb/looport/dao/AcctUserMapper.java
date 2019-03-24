package com.yollweb.looport.dao;

import com.yollweb.looport.entity.AcctUserEntity;
import com.yollweb.looport.process.request.LoginUserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AcctUserMapper {

    List<AcctUserEntity> queryAll(@Param("model")LoginUserModel model);

    Integer queryCount (@Param("model")LoginUserModel model);

    List<AcctUserEntity> login(@Param("name")String name,@Param("password")String password);

    List<AcctUserEntity> queryByname(@Param("name")String name);

    int saveUser(@Param("model")AcctUserEntity entity);

}
