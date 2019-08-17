package com.igeek.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author Administrator
 * @create 2019/05/10
 */
public class User {
    private String name;
    private Integer age;
    private String address;
    private String telPhone;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") //解决json格式输出问题
    private Date birthday;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public User(String name, Integer age, String address, String telPhone) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.telPhone = telPhone;
    }


    public User(String name, Integer age, String address, String telPhone, Date birthday) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.telPhone = telPhone;
        this.birthday = birthday;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", telPhone='" + telPhone + '\'' +
                '}';
    }
}
