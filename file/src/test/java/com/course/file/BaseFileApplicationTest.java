package com.course.file;

import com.course.file.query.Query;
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

    @Test
    public void test1(){
        Query query = new Query();
        query.setNumber1(10);
        query.setNumber2(20);
        query.setOperatorType("mul");
        operation.calculation(query);
    }

}
