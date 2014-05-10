package com.springapp.mvc.SocialAuth.Models;

import DataEntities.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "simple_auth_user")
public class SimpleAuthUser extends User {
    @Column(name = "password", length = 40, nullable = false)
    private String password;

    @ Column(name = "uuid", length = 36, nullable = false)
    private String uuid;

    @ Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    //getters/setters
}