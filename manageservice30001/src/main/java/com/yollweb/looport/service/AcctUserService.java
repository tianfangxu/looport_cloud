package com.yollweb.looport.service;

import com.yollweb.looport.content.ResultModel;
import com.yollweb.looport.process.request.UserModel;

public interface AcctUserService {
    ResultModel getAll();

    ResultModel login(UserModel model);
}
