package com.course.file.strategy.impl;

import com.course.file.query.Query;
import com.course.file.strategy.operation.DefaultDelOperatorStrategy;
import com.course.file.strategy.operation.OperatorStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jiange
 * @date 2020/7/10 14:13
 */
@Component
public class DoOperation {

    @Autowired
    private List<OperatorStrategy> operatorStrategies;

    @Resource
    private DefaultDelOperatorStrategy defaultDelOperatorStrategy;

    public void calculation(Query query){
        // 1 获取对应的策略
        OperatorStrategy operatorStrategy = getOperatorStrategy(query);
        // 2 计算
        int i = operatorStrategy.doOperation(query);
        // 3 结果处理
        System.out.println("计算结果为:"+i);
    }

    private OperatorStrategy getOperatorStrategy(Query query){
        List<OperatorStrategy> collect = operatorStrategies.stream().filter(
                operatorStrategy -> operatorStrategy.suport(query)).collect(Collectors.toList());
        if (collect.size() == 0){
            return defaultDelOperatorStrategy;
        }else if (collect.size() == 1){
            return collect.get(0);
        }else {
            throw new IllegalArgumentException("有多个策略符合，请检查相关策略带代码");
        }
    }
}
