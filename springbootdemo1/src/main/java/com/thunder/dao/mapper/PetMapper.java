package com.thunder.dao.mapper;

import com.thunder.pojo.Pet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface PetMapper {

    int deleteByPrimaryKey(Long petid);

    int insert(Pet record);

    int insertSelective(Pet record);

    Pet selectByPrimaryKey(Long petid);

    int updateByPrimaryKeySelective(Pet record);

    int updateByPrimaryKey(Pet record);

    List<Pet> selectAllPet();
}