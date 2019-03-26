package com.yollweb.looport.dao;

import com.yollweb.looport.entity.AcctMenuEntity;
import com.yollweb.looport.process.request.QueryMenuModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AcctMenuMapper {

    List<AcctMenuEntity> queryAll(@Param("model") QueryMenuModel model);

    List<AcctMenuEntity> menuforData(@Param("model") QueryMenuModel model);

    Integer queryAllCount(@Param("model") QueryMenuModel model);

    Integer updateMethods(@Param("model") QueryMenuModel model);

    Integer addMenu(@Param("model") QueryMenuModel model);

    Integer deleteMenuById(@Param("model") QueryMenuModel model);

    Integer deleteMenuByPid(@Param("model") QueryMenuModel model);
}
