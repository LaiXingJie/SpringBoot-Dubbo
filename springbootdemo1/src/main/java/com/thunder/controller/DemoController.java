package com.thunder.controller;

import com.thunder.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

/**
 * @author Think
 */
@RestController
public class DemoController {

    @Autowired
    private PetService petService;

    @GetMapping("/hello")
    public Object getUser() {

        //线程，该线程调用底层查询所有学生的方法
        Runnable runnable =new Runnable() {
            @Override
            public void run() {
                petService.getAllPet();
            }
        };

        //模拟多线程测试并发缓存穿透的问题
        ExecutorService executorService = Executors.newFixedThreadPool(15);

        for (int i = 0; i < 1000; i++) {
            executorService.submit(runnable);
        }

        return petService.getAllPet();
    }

    @GetMapping("/update")
    public Object update() {
        return petService.update();
    }
}
