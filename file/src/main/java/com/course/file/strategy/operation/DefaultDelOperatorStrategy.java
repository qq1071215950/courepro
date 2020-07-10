package com.course.file.strategy.operation;

import com.course.file.query.Query;
import com.course.file.strategy.operation.OperatorStrategy;
import org.springframework.stereotype.Component;

/**
 * 默认进行除法运算
 * @author jiange
 * @date 2020/7/10 14:06
 */
@Component
public class DefaultDelOperatorStrategy implements OperatorStrategy {
    @Override
    public int doOperation(Query query) {
        return query.getNumber1()/query.getNumber2();
    }

    @Override
    public boolean suport(Query query) {
        return false;
    }
}
