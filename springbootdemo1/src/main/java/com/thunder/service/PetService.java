package com.thunder.service;

import com.thunder.pojo.Pet;

import java.util.List;

/**
 * @author Think
 */
public interface PetService {

    /**
     * 查询所有的宠物
     * @return
     */
    List<Pet> getAllPet();

    /**
     * 修改
     * @param pet
     * @return
     */
    int update();
}
