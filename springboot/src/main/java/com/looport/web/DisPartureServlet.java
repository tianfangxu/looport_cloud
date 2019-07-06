package com.looport.web;

import com.looport.service.IndexService;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class DisPartureServlet implements ServletInterface{

    @Override
    public void onStartUp(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(MyConfig.class);
        //ac.refresh();
        DispatcherServlet dispatcherServlet = new DispatcherServlet(ac);
        ServletRegistration.Dynamic app = servletContext.addServlet("app", dispatcherServlet);
        app.setLoadOnStartup(1);
        app.addMapping("*.do");
    }
}
