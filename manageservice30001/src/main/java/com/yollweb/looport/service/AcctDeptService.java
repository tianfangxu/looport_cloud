package com.yollweb.looport.service;

import com.yollweb.looport.content.ResultModel;
import com.yollweb.looport.process.request.QueryDeptModel;

public interface AcctDeptService {
    ResultModel deptall(QueryDeptModel model);

    ResultModel addDept(QueryDeptModel model);
}
