package com.looport.web;

import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@HandlesTypes(ServletInterface.class)
public class MyIntiliazer implements ServletContainerInitializer {


    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("this is run");
        List<ServletInterface> initializers = new LinkedList();
        Iterator var4;
        if (set != null) {
            var4 = set.iterator();

            while(var4.hasNext()) {
                Class<?> waiClass = (Class)var4.next();
                if (!waiClass.isInterface() && !Modifier.isAbstract(waiClass.getModifiers()) && ServletInterface.class.isAssignableFrom(waiClass)) {
                    try {
                        initializers.add((ServletInterface)waiClass.newInstance());
                    } catch (Throwable var7) {
                        throw new ServletException("Failed to instantiate WebApplicationInitializer class", var7);
                    }
                }
            }
        }

        if (initializers.isEmpty()) {
            servletContext.log("No Spring WebApplicationInitializer types detected on classpath");
        } else {
            servletContext.log(initializers.size() + " Spring WebApplicationInitializers detected on classpath");
            AnnotationAwareOrderComparator.sort(initializers);
            var4 = initializers.iterator();

            while(var4.hasNext()) {
                ServletInterface initializer = (ServletInterface)var4.next();
                initializer.onStartUp(servletContext);
            }

        }
    }
}
