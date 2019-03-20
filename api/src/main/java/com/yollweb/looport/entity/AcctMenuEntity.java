package com.yollweb.looport.entity;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor  //无参构造
@AllArgsConstructor //有参构造
@Accessors(chain=true)  //链式
public class AcctMenuEntity {

    private String id;
    private String name;
    private String order;
    private String pid;
    private String level;
    private String methods;

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

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMethods() {
        return methods;
    }

    public void setMethods(String methods) {
        this.methods = methods;
    }

    public void setMethods(Object methods) {
        Gson gson = new Gson();
        this.methods = gson.toJson(methods);
    }
}
