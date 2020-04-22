import com.itheima.dao.UserDao;
import com.itheima.domain.Users;
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

public class Dao2Test {

    public InputStream rs;
    public SqlSession session;
    public UserDao userDao;
    @Before
    public void init() throws IOException {
        rs = Resources.getResourceAsStream("Sql_mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(rs);
        session = factory.openSession(true);
        userDao = session.getMapper(UserDao.class);
    }

    @After
    public void destroy() throws IOException {
        session.close();
        rs.close();
    }

    @Test
    public void findAll(){
        List<Users> all = userDao.findAll();
        for(Users u : all){
            System.out.println(u);
        }
    }

    @Test
    public void saveUser(){
        Users users = new Users();
        users.setName("张华");
        users.setAge(19);
        userDao.saveUser(users);
    }
}
