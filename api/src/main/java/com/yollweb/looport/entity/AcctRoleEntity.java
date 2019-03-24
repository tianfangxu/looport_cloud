package com.yollweb.looport.entity;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@NoArgsConstructor  //无参构造
@AllArgsConstructor //有参构造
@Data
@Accessors(chain=true)  //链式
public class AcctRoleEntity {

    private String id;
    private String name;
    private String menuid;

    //[
    //    {
    //        "id": "0001",
    //        "name": "系统",
    //        "methods": [
    //            {
    //                "name": "查询",
    //                "code": "query",
    //                "enable": true
    //            },
    //            {
    //                "name": "删除",
    //                "code": "delete",
    //                "enable": false
    //            }
    //        ]
    //    }
    //]
}
