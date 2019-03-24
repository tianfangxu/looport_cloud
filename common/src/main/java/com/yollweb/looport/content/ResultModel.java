package com.yollweb.looport.content;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor  //无参构造
@AllArgsConstructor //有参构造
@Data               //get\set
@Accessors(chain=true)  //链式
public class ResultModel {

    private int code;
    private boolean success = false;
    private String msg;
    private Object result;
    private int total;
}
