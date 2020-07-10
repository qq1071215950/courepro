package com.course.file.responsibility.impl;

/**
 * @author jiange
 * @date 2020/7/10 15:54
 */
public class FilterIResponsibility implements IResponsibility {
    @Override
    public String doSome(String params) {
        System.out.println("fiter:"+params);
        return params+"filter";
    }
}
