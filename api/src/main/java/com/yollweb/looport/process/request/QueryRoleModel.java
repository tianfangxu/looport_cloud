package com.yollweb.looport.process.request;

import com.yollweb.looport.entity.AcctUserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor  //无参构造
@AllArgsConstructor //有参构造
@Data
@Accessors(chain=true)  //链式
public class QueryRoleModel {

    private String id;
    private String name;
    private String menuid;
    private int page;
    private int rows;
    private AcctUserEntity userEntity;
}
