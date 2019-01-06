package test;

import dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import pojo.User;

public class MybatisTest {
    @Test
    public void test1() throws IOException {
        //加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();


        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.findUserById(27);
        System.out.println(user);
    }
}
