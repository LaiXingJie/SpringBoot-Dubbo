package com.thunder.pojo;

import java.io.Serializable;
import java.util.Date;

public class Pet implements Serializable {
    private Long petid;

    private String petname;

    private Integer petbreed;

    private Integer petsex;

    private Date birthday;

    private String description;

    public Long getPetid() {
        return petid;
    }

    public void setPetid(Long petid) {
        this.petid = petid;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname == null ? null : petname.trim();
    }

    public Integer getPetbreed() {
        return petbreed;
    }

    public void setPetbreed(Integer petbreed) {
        this.petbreed = petbreed;
    }

    public Integer getPetsex() {
        return petsex;
    }

    public void setPetsex(Integer petsex) {
        this.petsex = petsex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}