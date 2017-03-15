package com.soecode.lyf.monitor;

import org.springframework.context.ApplicationContext;
/**
 * 
* @author  created by liujie
* @date    2017年3月10日 --- @上午11:06:06
*
 */
public class SpringHelper {

    private static ApplicationContext applicationContext;

    /**
     * @param applicationContext
     * @see ApplicationContextHelper
     */
    public static void setApplicationContext(ApplicationContext applicationContext) {
        SpringHelper.applicationContext = applicationContext;
    }

    public static <T> T popBean(Class<T> clazz) {
        if (applicationContext == null)
            return null;
        return applicationContext.getBean(clazz);
    }

    public static <T> T popBean(String name, Class<T> clazz) {
        if (applicationContext == null)
            return null;
        return applicationContext.getBean(name, clazz);
    }
}
