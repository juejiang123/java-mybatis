package com.itheima.test;

import com.itheima.dao.RoleDao;
import com.itheima.dao.UserDao;
import com.itheima.domain.Role;
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

public class RoleTest {
    public InputStream in;
    public SqlSession sqlSession;
    public RoleDao roleDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("Sql_mybatis.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);
        sqlSession = build.openSession();
        roleDao = sqlSession.getMapper(RoleDao.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.close();
        in.close();
    }

    @Test
    public void roleFindAll(){
        List<Role> all = roleDao.findAll();
        for (Role r:all) {
            System.out.println(r);
            System.out.println(r.getUsers());
        }
    }
}
