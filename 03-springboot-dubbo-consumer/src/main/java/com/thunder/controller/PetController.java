package com.thunder.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.thunder.service.PetService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Name;

/**
 * @author Think
 */
@RestController
public class PetController {

    @Reference//这里的注解是Dubbo的
    private PetService petService;

    @RequestMapping("/pet")
    public Object getPet(@RequestParam("id") Long id){
        return petService.getPet(id);
    }

    @RequestMapping("/pet/{id}/{name}")
    public Object user1(@PathVariable("id") Long id,@PathVariable("name") String name){


        String name1 = id + name;

        return name1;
    }
}
