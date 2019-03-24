package com.yollweb.looport.entity;

import com.yollweb.looport.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor  //无参构造
@AllArgsConstructor //有参构造
@Data               //get\set
@Accessors(chain=true)  //链式
public class AcctUserEntity extends BaseEntity {

    private String id;
    private String nike;
    private String name;
    private String password;

    private String roleid;  //权限id

}
