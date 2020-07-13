package com.course.file.thread;

/**
 * @author jiange
 * @date 2020/7/10 17:13
 */
public interface BussinessService {

    /**
     * 业务方法，如数据库查询等
     */
    String handleBussiness() throws InterruptedException;
}
