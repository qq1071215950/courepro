package com.course.file.responsibility.impl;

/**
 * @author jiange
 * @date 2020/7/10 15:52
 */
public class SortResponsibility implements IResponsibility{
    @Override
    public String doSome(String params) {
        System.out.println("sort:"+params);
        return params+"sort";
    }
}
