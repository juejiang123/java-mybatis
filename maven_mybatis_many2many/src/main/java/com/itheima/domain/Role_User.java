package com.itheima.domain;

public class Role_User {

    private int uid;
    private int rid;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "Role_User{" +
                "uid=" + uid +
                ", rid=" + rid +
                '}';
    }
}
