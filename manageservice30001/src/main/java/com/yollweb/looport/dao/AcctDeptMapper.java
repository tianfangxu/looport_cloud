package com.yollweb.looport.dao;

import com.yollweb.looport.entity.AcctDeptEntity;
import com.yollweb.looport.process.request.QueryDeptModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AcctDeptMapper {

    List<AcctDeptEntity> queryAll(@Param("model")QueryDeptModel model);

    Integer queryCount(@Param("model")QueryDeptModel model);

    Integer saveDept(@Param("model")QueryDeptModel model);
}
