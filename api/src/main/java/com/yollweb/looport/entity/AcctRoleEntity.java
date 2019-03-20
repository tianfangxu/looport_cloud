package com.yollweb.looport.entity;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@NoArgsConstructor  //无参构造
@AllArgsConstructor //有参构造
@Accessors(chain=true)  //链式
public class AcctRoleEntity {

    private String id;
    private String name;
    private String menuid;

    public void setMenuid(List list){
        Gson gson = new Gson();
        this.menuid= gson.toJson(list);
    }

    public void setMenuid(String menuid){
        this.menuid= menuid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMenuid() {
        return menuid;
    }
}
