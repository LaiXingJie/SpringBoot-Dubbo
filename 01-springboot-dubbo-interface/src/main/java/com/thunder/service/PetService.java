package com.thunder.service;

import com.thunder.pojo.Pet;

/**
 * @author Think
 */
public interface PetService {


     String sayHi(String name);

     Pet getPet(Long id);
}
