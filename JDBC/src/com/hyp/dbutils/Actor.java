package com.hyp.dbutils;

import java.util.Date;

/**
 * 演员
 *
 * @author Han
 * @date 2023/01/11
 */
public class Actor {
    private int id;
    private String name;
    private String sex;
    private Date date;
    private String phone;
    public Actor(){}//无参构造器

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Actor(int id, String name, String sex, Date date, String phone) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.date = date;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "\nActor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", date=" + date +
                ", phone='" + phone + '\'' +
                '}';
    }
}
