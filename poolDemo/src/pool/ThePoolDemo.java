package pool;

import util.JdbcUtil;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ThePoolDemo {
    private static List<Connection> pool = new ArrayList<>();

    static{
        for(int i = 0; i<10; i++){
            Connection connection = null;
            try {
                connection = JdbcUtil.getConnection();
                pool.add(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized static Connection getConnection(){
        if(pool.size()>0){
            Connection connection = pool.remove(0);
            return connection;
        }else{
            throw new RuntimeException("服务器忙");
        }
    }

    public static void release(Connection connection){
        pool.add(connection);
    }
}
