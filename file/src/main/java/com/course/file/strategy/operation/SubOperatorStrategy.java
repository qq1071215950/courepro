package com.course.file.strategy.operation;

import com.course.file.query.Query;
import com.course.file.strategy.operation.OperatorStrategy;
import org.springframework.stereotype.Component;

/**
 * @author jiange
 * @date 2020/7/10 14:03
 */
@Component
public class SubOperatorStrategy implements OperatorStrategy {

    @Override
    public int doOperation(Query query) {
        return query.getNumber1() - query.getNumber2();
    }

    @Override
    public boolean suport(Query query) {
        return "sub".equals(query.getOperatorType());
    }
}
