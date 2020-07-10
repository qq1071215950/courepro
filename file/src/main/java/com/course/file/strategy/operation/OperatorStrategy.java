package com.course.file.strategy.operation;

import com.course.file.query.Query;

/**
 * 计算策略
 * @author jiange
 * @date 2020/7/10 13:58
 */
public interface OperatorStrategy {

    int doOperation(Query query);

    boolean suport(Query query);
}
