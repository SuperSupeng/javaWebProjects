import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisFirstTest {

    @Test
    public void testMybatis() throws IOException {
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = sqlSession.selectOne("test.findUserById", 10);

        System.out.println(user);
    }

    @Test
    public void testFindUserByUsername() throws IOException {
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> list = sqlSession.selectList("test.findUserByUserName", "五");

        for (User user : list){
            System.out.println(user);
        }
    }

    @Test
    public void testInsertUser() throws IOException {
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setSex("男");
        user.setAddress("asdasasf");
        user.setUsername("bbb");
        user.setBirthday(new Date());
        sqlSession.insert("test.insertUser", user);
        sqlSession.commit();
        System.out.println(user.getId());
    }

    @Test
    public void testUpdateUserByID() throws IOException {
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setId(28);
        user.setSex("女");
        user.setAddress("111111");
        user.setUsername("22222");
        user.setBirthday(new Date());
        sqlSession.update("test.updateUserByID", user);
        sqlSession.commit();
        System.out.println(user.getId());
    }

    @Test
    public void testDeleteUser() throws IOException {
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setId(26);
        sqlSession.delete("test.deleteUserByID", user);
        sqlSession.commit();
    }
}
