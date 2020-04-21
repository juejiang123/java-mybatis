package com.itheima.test;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {
    public InputStream in;
    public SqlSession sqlSession;
    public UserDao userDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("Sql_mybatis.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);
        sqlSession = build.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.close();
        in.close();
    }

    @Test
    public void userFindAll(){
        List<User> all = userDao.findAll();
        for (User u:all) {
            System.out.println(u);
            System.out.println(u.getRoles());
        }
    }
}
