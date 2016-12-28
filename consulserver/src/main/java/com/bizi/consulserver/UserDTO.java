package com.bizi.consulserver;

import java.util.Date;

/**
 * Created by guofangbi on 2016/12/28.
 */
public class UserDTO {
    private Integer id;
    private String username;
    private Date birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
