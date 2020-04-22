import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DaoTest {
    public SqlSessionFactory factory;
    public InputStream in;
    public UserDaoImpl userDao;


    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("Sql_mybatis.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        userDao = new UserDaoImpl(factory);
    }

    @After
    public void destroy() throws IOException {

        in.close();
    }

    @Test
    public void findAll(){
        List<Users> all = userDao.findAll();
        for (Users u : all){
            System.out.println(u);
        }

    }

    @Test
    public void saveUser(){
        Users users = new Users();
        users.setName("huling");
        users.setSex("female");
        users.setAge(18);
        userDao.saveUser(users);

    }

    @Test
    public void updateUser(){
        Users users = new Users();
        users.setName("zhangyishan");
        users.setSex("male");
        users.setAge(24);
        users.setId(8);
        userDao.updateUser(users);

    }

    @Test
    public void deleteUser(){
        userDao.deleteUser(11);
    }

    @Test
    public void findOne(){
        Users one = userDao.findOne(10);
        System.out.println(one);
    }
}
