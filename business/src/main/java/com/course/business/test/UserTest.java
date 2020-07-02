package com.course.business.test;

import java.lang.reflect.Method;

/**
 * @author jiange
 * @date 2020/7/1 10:45
 */
public class UserTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class classs = Class.forName("com.course.business.test.User");
        User user =(User) classs.newInstance();
        Method[] methods = classs.getMethods();
        //遍历所有方法
        for (Method method : methods) {
            //设置可见性
            method.setAccessible(true);
            System.out.println(method.getName());
            //获得方法的参数
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                //获得构造函数中参数类型
                System.out.println(parameterTypes[i].getName()+",");
            }
        }
    }
}
