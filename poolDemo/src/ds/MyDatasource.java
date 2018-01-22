package ds;

import util.JdbcUtil;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class MyDatasource implements DataSource {
    private static List<Connection> pool = Collections.synchronizedList(new ArrayList<Connection>());

    static{
        try {
            Connection conn = JdbcUtil.getConnection();//创建的新连接
            for(int i=0;i<10;i++){
                pool.add(conn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        if(pool.size()>0){
            Connection connection = pool.remove(0);
            Connection connProxy = (Connection)Proxy.newProxyInstance(connection.getClass().getClassLoader(),
                    connection.getClass().getInterfaces(),
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            if("close".equals(method.getName())){
                                return pool.add(connection);
                            }else{
                                return method.invoke(connection, args);
                            }
                        }
                    });
            return connProxy;
        }else{
            throw new RuntimeException("服务器忙");
        }
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
