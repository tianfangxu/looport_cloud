package com.yollweb.looport.base;

import com.yollweb.looport.entity.AcctUserEntity;
import com.yollweb.looport.utils.DateUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor  //无参构造
@AllArgsConstructor //有参构造
@Data               //get\set
@Accessors(chain=true)  //链式
public class BaseEntity {

    private String createtime;
    private String createuser;
    private String createname;

    private String modifytime;
    private String modifyuser;
    private String modifyname;

    private String deletetime;
    private String deleteuser;
    private String deletename;

    private String flag;

    public void createMethod(AcctUserEntity entity){
        this.createname = entity.getNike();
        this.createuser = entity.getId();
        this.createtime = DateUnit.getTime14();
        this.flag = "0";
    }

    public void updateMethod(AcctUserEntity entity){
        this.modifyname = entity.getNike();
        this.modifyuser = entity.getId();
        this.modifytime = DateUnit.getTime14();
        this.flag = "0";
    }

    public void deleteMethod(AcctUserEntity entity){
        this.deletename = entity.getNike();
        this.deleteuser = entity.getId();
        this.deletetime = DateUnit.getTime14();
        this.flag = "1";
    }
}
