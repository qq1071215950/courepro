package com.course.file;

import com.course.file.query.Query;
import com.course.file.responsibility.impl.FilterIResponsibility;
import com.course.file.responsibility.impl.SortResponsibility;
import com.course.file.responsibility.impl.TreeIResponsibility;
import com.course.file.responsibility.operation.FormCapacityPipeline;
import com.course.file.strategy.impl.DoOperation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author jiange
 * @date 2020/7/10 14:30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {FileApplication.class, BaseFileApplicationTest.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseFileApplicationTest {

    @Autowired
    private DoOperation operation;

    /**
     * 策略模式测试
     */
    public void test1(){
        Query query = new Query();
        query.setNumber1(10);
        query.setNumber2(20);
        query.setOperatorType("mul");
        operation.calculation(query);
    }

    /**
     * 责任链测试
     */
    @Test
    public void test2(){
        String string = FormCapacityPipeline.createInstance()
                .add(new SortResponsibility())
                .add(new TreeIResponsibility())
                .add(new FilterIResponsibility()).excution("测试");
        System.out.println("/////////");
        System.out.println(string);
    }
}
