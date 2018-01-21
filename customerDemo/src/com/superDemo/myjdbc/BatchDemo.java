package com.superDemo.myjdbc;

import com.superDemo.util.JdbcUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class BatchDemo {

    @Test
    public void test1()throws Exception{
        Connection conn = JdbcUtil.getConnection();
        Statement stmt = conn.createStatement();
        String sql1 = "insert into t1 values(1,'aaa1')";
        String sql2 = "insert into t1 values(2,'aaa2')";
        String sql3 = "delete from t1 where id=1";
        stmt.addBatch(sql1);//Statement实例内部有一个List，sql语句加到List中了
        stmt.addBatch(sql2);
        stmt.addBatch(sql3);

        int[] ii = stmt.executeBatch();//返回值是一个数组，数组的元素为每条语句影响到的行数
        for(int i:ii)
            System.out.println(i);

        JdbcUtil.release(null, stmt, conn);
    }

    //插入10条记录。PreparedStatement 适合语句相同，只是参数不通的情况
    @Test
    public void test2() throws Exception{
        Connection conn = JdbcUtil.getConnection();
        PreparedStatement stmt = conn.prepareStatement("insert into t1 values (?,?)");
        for(int i=0;i<10;i++){
            stmt.setInt(1, i+1);
            stmt.setString(2, "aaaa"+(i+1));
            stmt.addBatch();
        }

        stmt.executeBatch();
        JdbcUtil.release(null, stmt, conn);
    }

    //插入1000001条记录。PreparedStatement 适合语句相同，只是参数不通的情况
    @Test
    public void test3() throws Exception{
        Connection conn = JdbcUtil.getConnection();
        PreparedStatement stmt = conn.prepareStatement("insert into t1 values (?,?)");
        for(int i=0;i<1000001;i++){
            stmt.setInt(1, i+1);
            stmt.setString(2, "aaaa"+(i+1));
            stmt.addBatch();
            if(i%1000==0){
                stmt.executeBatch();
                stmt.clearBatch();//清理缓存
            }
        }

        stmt.executeBatch();
        JdbcUtil.release(null, stmt, conn);
    }
}
