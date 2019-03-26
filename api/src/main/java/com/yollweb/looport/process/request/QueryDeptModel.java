package com.yollweb.looport.process.request;

import com.yollweb.looport.entity.AcctUserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor  //无参构造
@AllArgsConstructor //有参构造
@Data               //get\set
@Accessors(chain=true)  //链式
public class QueryDeptModel {

    private String id;
    private String name;    //部门名称
    private String content; //内容
    private String parent;  //父部门
    private String roleid;  //权限

    private int page;
    private int rows;
    private AcctUserEntity userEntity;
}
