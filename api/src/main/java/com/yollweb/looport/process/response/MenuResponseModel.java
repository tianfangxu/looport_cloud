package com.yollweb.looport.process.response;

import com.yollweb.looport.entity.AcctMenuEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@NoArgsConstructor  //无参构造
@AllArgsConstructor //有参构造
@Data
@Accessors(chain=true)  //链式
public class MenuResponseModel {

    private String id;
    private String name;
    private String order;
    private String pid;
    private String level;
    private String methods;
    private List<AcctMenuEntity> list;
}
