package com.usefultool.Util;

import org.springframework.context.ApplicationContext;

/**
 *  Spring 上下文获取工具类
 *  目的是为了在Springboot中随时获取ApplicationContext，得到想要的bean
 */


public class SpringContextUtil {

    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext context){
        applicationContext = context;
    }

    public static Object getBean(String beanId){
        return applicationContext.getBean(beanId);
    }


}
