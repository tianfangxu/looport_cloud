package com.yollweb.looport.service;

import com.yollweb.looport.content.ResultModel;
import com.yollweb.looport.process.request.LoginUserModel;
import com.yollweb.looport.process.request.SaveUserModel;

public interface AcctUserService {
    ResultModel getAll();

    ResultModel login(LoginUserModel model);

    ResultModel saveUser(SaveUserModel model);
}
