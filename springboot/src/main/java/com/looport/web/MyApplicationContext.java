package com.looport.web;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class MyApplicationContext {

    public static void run() throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(9090);
        tomcat.addWebapp("/","F:\\AppProject");
        tomcat.start();
        tomcat.getServer().await();
    }
}
