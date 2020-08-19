package com.thunder.dao;

import com.thunder.pojo.Pet;

public interface PetMapper {
    int deleteByPrimaryKey(Long petid);

    int insert(Pet record);

    int insertSelective(Pet record);

    Pet selectByPrimaryKey(Long petid);

    int updateByPrimaryKeySelective(Pet record);

    int updateByPrimaryKey(Pet record);
}