package dao.impl;

import dao.FriendDao;
import domain.Friend;
import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.DBCPUtil;

import java.sql.SQLException;
import java.util.List;

public class FriendDaoImpl implements FriendDao {
    private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());

    @Override
    public List findAllFriends(User user) {
        try {
            return qr.query("select * from friends where userid=?",
                    new BeanListHandler<>(Friend.class),
                    user.getUserid());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List findAllFriends(User user, String friendName) {
        try {
            return qr.query("select * from friends where name like '%"+friendName+"%' and userid='"+user.getUserid()+"'",
                    new BeanListHandler<>(Friend.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addFriend(User user, Friend friend) {
        try {
            qr.update("insert into friends (id,userid,name,sex,age,qq,telphone,email,address) values(?,?,?,?,?,?,?,?,?)",
                    friend.getId(),
                    user.getUserid(),
                    friend.getName(),
                    friend.getSex(),
                    friend.getAge(),
                    friend.getQq(),
                    friend.getTelphone(),
                    friend.getEmail(),
                    friend.getAddress());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeFriend(User user, Friend friend) {
        try{
            qr.update("delete from friends where id=? and userid=?",
                    friend.getId(),
                    user.getUserid());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void changeFriend(User user, Friend friend) {
        try {
            qr.update("update friends set name=?,sex=?,age=?,qq=?,telphone=?,email=?,address=? where id=? and userid=?",
                    friend.getName(),
                    friend.getSex(),
                    friend.getAge(),
                    friend.getQq(),
                    friend.getTelphone(),
                    friend.getEmail(),
                    friend.getAddress(),
                    friend.getId(),
                    user.getUserid());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
