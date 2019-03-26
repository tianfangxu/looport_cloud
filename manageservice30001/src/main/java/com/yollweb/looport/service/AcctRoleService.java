package com.yollweb.looport.service;

import com.yollweb.looport.content.ResultModel;
import com.yollweb.looport.process.request.QueryRoleModel;

public interface AcctRoleService {
    ResultModel roleAll(QueryRoleModel model);

    ResultModel addRole(QueryRoleModel model);

    ResultModel updateRole(QueryRoleModel model);
}
