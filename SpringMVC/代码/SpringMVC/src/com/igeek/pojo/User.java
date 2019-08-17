package com.igeek.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 60915
 * \* Date: 2019/8/14
 * \* Time: 23:01
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class User {
    private String no;
    private String name;
    private int age;
    private String sex;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    public User() {
    }

    public User(String no, String name, int age, String sex) {
        this.no = no;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public User(String no, String name, int age, String sex, Date birthday) {
        this.no = no;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}