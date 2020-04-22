package com.itheima.dao;

import com.itheima.domain.QueryVo;
import com.itheima.domain.Users;

import java.util.List;

public interface UserDao {

    public List<Users> findAll();

    public void saveUser(Users users);

    public void updateUser(Users users);

    public void deleteUser(Integer integer);

    public void deleteUser1(String string);

    public Users findOne(Integer id);

    public List<Users> findByName(String name);

    public Integer findTotalCount();

    public Integer findIdCount();

    public List<Users> findByVo(QueryVo vo);
}
