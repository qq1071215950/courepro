package com.course.file.thread;

/**
 * @author jiange
 * @date 2020/7/10 17:14
 */
public class BussinessServiceImpl implements BussinessService{
    @Override
    public String handleBussiness() {
        System.out.println("当前处理业务的线程"+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ceshi";
    }
}
