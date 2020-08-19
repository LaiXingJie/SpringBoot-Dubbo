package com.thunder.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.thunder.mapper.PetMapper;
import com.thunder.pojo.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Think
 */
@Component //注入到容器中
@Service(interfaceClass = PetService.class)//这里的service是Dubbo的注解
public class PerServiceImpl implements PetService{

    @Autowired
    private PetMapper petMapper;

    @Override
    public String sayHi(String name) {
        return "hi,springboot:"+name;
    }

    @Override
    public Pet getPet(Long id) {
        //查询数据库
        Pet pet = petMapper.selectByPrimaryKey(id);
        return pet;
    }
}
