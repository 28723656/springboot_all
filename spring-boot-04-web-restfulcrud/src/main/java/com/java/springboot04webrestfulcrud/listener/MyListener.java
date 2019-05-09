package com.java.springboot04webrestfulcrud.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("监听启动.....");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("监听停止.....");
    }
}
