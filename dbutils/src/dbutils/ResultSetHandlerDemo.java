package dbutils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;
import util.DBCPUtil;

import java.util.List;
import java.util.Map;

public class ResultSetHandlerDemo {
    private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());

    //ArrayHandler:适合结果只有一条的情况。把第一条记录的每列的值封装到一个Object[]数组中
    @Test
    public void test1() throws Exception{
        Object[] objs = qr.query("select * from student", new ArrayHandler());
        for(Object o : objs){
            System.out.println(o);
        }
    }

    //ArrayListHandler:适合结果有多条的情况。把每列的值封装到Object[]数组中，把Object[]放到List中
    @Test
    public void test2() throws Exception{
        List<Object[]> list = qr.query("select * from student", new ArrayListHandler());
        for(Object[] l : list){
            System.out.println("-------------------");
            for(Object o : l){
                System.out.println(o);
            }
        }
    }

    //ColumnListHandler:适合取某列的值。把取到值封装到List中
    @Test
    public void test3() throws Exception{
        List<Object> list = qr.query("select * from student", new ColumnListHandler("name"));
        for(Object o : list){
            System.out.println(o);
        }
    }

    //KeyedHandler:查询多条记录。每条记录封装到一个Map中，key：字段名，value：字段值。再把Map作为value放到另外一个Map中，该Map的key为指定的列值作为key。
    @Test
    public void test4() throws Exception{
        Map<Object, Map<String, Object>> bmap = qr.query("select * from student", new KeyedHandler("id"));
        for(Map.Entry<Object, Map<String, Object>> bme: bmap.entrySet()){
            System.out.println("---------------");
            for(Map.Entry<String, Object> m : bme.getValue().entrySet()){
                System.out.println(m.getKey() + ":" + m.getValue());
            }
        }
    }

    //MapHandler:适合一条结果。封装到一个Map中，key：字段名，value：字段值
    @Test
    public void test5() throws Exception{
        Map<String, Object> bmap = qr.query("select * from student", new MapHandler());
        for(Map.Entry<String, Object> m : bmap.entrySet()){
            System.out.println(m.getKey() + ":" + m.getValue());
        }
    }

    //MapListHandler:适合多条结果。把每条封装到一个Map中，key：字段名，value：字段值，在把Map封装到List中
    @Test
    public void test6() throws Exception{
        List<Map<String, Object>> list = qr.query("select * from student", new MapListHandler());
        for(Map<String, Object> m : list){
            System.out.println("----------------");
            for(Map.Entry<String, Object> lem : m.entrySet()){
                System.out.println(lem.getKey() + ":" + lem.getValue());
            }
        }
    }

    //ScalarHandler:适合取结果只有一行和一列的情况。
    @Test
    public void test7() throws Exception{
        Object obj = qr.query("select count(*) from student", new ScalarHandler(1));
//		System.out.println(obj.getClass().getName());
        Long l = (Long)obj;
        System.out.println(l.intValue());
        System.out.println(obj);
    }

}
