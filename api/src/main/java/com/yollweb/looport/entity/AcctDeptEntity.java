package com.yollweb.looport.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor  //无参构造
@AllArgsConstructor //有参构造
@Data
@Accessors(chain=true)  //链式
public class AcctDeptEntity {

    private String id;
    private String name;    //部门名称
    private String content; //内容
    private String parent;  //父部门
    private String roleid;  //权限
}
