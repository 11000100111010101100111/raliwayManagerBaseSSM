package com.yakeManager.myListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        String path = servletContext.getContextPath();
        servletContext.setAttribute("httpPath",path);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
