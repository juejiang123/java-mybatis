package com.itheima.domain;

import java.util.List;

public class Role {

    private int rid;
    private String role_name;
    private String role_desc;
    private List<User> users;
    private List<Role_User> role_users;

    public List<Role_User> getRole_users() {
        return role_users;
    }

    public void setRole_users(List<Role_User> role_users) {
        this.role_users = role_users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_desc() {
        return role_desc;
    }

    public void setRole_desc(String role_desc) {
        this.role_desc = role_desc;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rid=" + rid +
                ", role_name='" + role_name + '\'' +
                ", role_desc='" + role_desc + '\'' +
                '}';
    }
}
