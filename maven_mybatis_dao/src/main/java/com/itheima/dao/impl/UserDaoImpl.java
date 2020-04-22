package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.QueryVo;
import com.itheima.domain.Users;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }

    public List<Users> findAll() {

        SqlSession session = factory.openSession();
        List<Users> list = session.selectList("com.itheima.dao.UserDao.findAll");
        session.close();
        return list;
    }

    public void saveUser(Users users) {
        SqlSession sqlSession = factory.openSession();
        sqlSession.insert("com.itheima.dao.UserDao.saveUser",users);
        sqlSession.commit();
        sqlSession.close();

    }

    public void updateUser(Users users) {
        SqlSession session = factory.openSession();
        session.update("com.itheima.dao.UserDao.updateUser",users);
        session.commit();
        session.close();

    }

    public void deleteUser(Integer integer) {
        SqlSession session = factory.openSession();
        session.delete("com.itheima.dao.UserDao.deleteUser",integer);
        session.commit();
        session.close();

    }

    public void deleteUser1(String string) {

    }

    public Users findOne(Integer id) {
        SqlSession session = factory.openSession();
        Users one = session.selectOne("com.itheima.dao.UserDao.findOne", id);
        session.close();
        return one;
    }

    public List<Users> findByName(String name) {
        return null;
    }

    public Integer findTotalCount() {
        return null;
    }

    public Integer findIdCount() {
        return null;
    }

    public List<Users> findByVo(QueryVo vo) {
        return null;
    }
}
