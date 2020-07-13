package com.course.file.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author jiange
 * @date 2020/7/10 17:17
 */
public class ThreadPoolProduction {
    public static void main(String[] args) {
        BussinessService bussinessService = new BussinessServiceImpl();

        //新建一个线程池，池中有两个线程，注意这里使用的是fiexd 注意和cached的区别
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        //注意这里使用的是callable 而不是runable。
        ArrayList<Callable<Integer>> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tasks.add(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    String s = bussinessService.handleBussiness();
                    return 0;
                }
            });
        }

        try {
            //由于我们使用的是callable，所以在执行完成后，会拿到反馈信息，而runable不可以
            List<Future<Integer>> futures = executorService.invokeAll(tasks);
            for (Future<Integer> future : futures) {
                System.out.println(future.get());
            }
        } catch (ExecutionException e) {
            //这里生产环境不可以这么写，不要生吞(swallow)异常，处理的方式有很多种，比如可以向日志系统追加日志
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
