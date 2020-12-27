package com.example.demo.model;

import org.apache.ibatis.annotations.Param;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "store")
public class Store {
    @Id
    private String fid;
    private String name;
    private String phone;
    private String address;
    private String introduce;
    private String picture;

    public String getFid() {
        return fid;
    }

    public Store setFid(String fid) {
        this.fid = fid;
        return this;
    }

    public String getName() {
        return name;
    }

    public Store setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Store setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Store setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getIntroduce() {
        return introduce;
    }

    public Store setIntroduce(String introduce) {
        this.introduce = introduce;
        return this;
    }

    public String getPicture() {
        return picture;
    }

    public Store setPicture(String picture) {
        this.picture = picture;
        return this;
    }

    @Override
    public String toString(){
        return fid+" "+name+" "+phone+" "+address+" "+introduce+" "+picture;
    }
}
