package com.yollweb.looport.dao;

import com.yollweb.looport.entity.AcctRoleEntity;
import com.yollweb.looport.process.request.QueryRoleModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AcctRoleMapper {

    List<AcctRoleEntity> queryAll(@Param("model") QueryRoleModel model);

    int queryCount(@Param("model") QueryRoleModel model);

    int addRole(@Param("model") QueryRoleModel model);

}
