package com.yollweb.looport.service;

import com.yollweb.looport.content.ResultModel;
import com.yollweb.looport.process.request.QueryMenuModel;

public interface AcctMenuService {
    ResultModel getAll(QueryMenuModel model);

    ResultModel updateMenuMethod(QueryMenuModel model);

    ResultModel addMenu(QueryMenuModel model);

    ResultModel deleteMenu(QueryMenuModel model);
}
