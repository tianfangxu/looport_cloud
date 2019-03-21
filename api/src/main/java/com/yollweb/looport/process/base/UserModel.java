package com.yollweb.looport.process.base;

import com.yollweb.looport.entity.AcctUserEntity;

import java.io.Serializable;

public class UserModel implements Serializable {

    private AcctUserEntity userEntity;

    public AcctUserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(AcctUserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
