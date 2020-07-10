package com.course.file.responsibility.impl;

/**
 * @author jiange
 * @date 2020/7/10 15:55
 */
public class TreeIResponsibility implements IResponsibility{
    @Override
    public String doSome(String params) {
        System.out.println("tree"+params);
        return params+"tree";
    }
}
