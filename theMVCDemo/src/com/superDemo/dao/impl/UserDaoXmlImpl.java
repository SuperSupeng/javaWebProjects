package com.superDemo.dao.impl;

import com.superDemo.dao.UserDao;
import com.superDemo.domain.User;
import com.superDemo.util.Dom4JUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

public class UserDaoXmlImpl implements UserDao {
    @Override
    public User finUserByUsername(String username) {
        try {
            Document doc = Dom4JUtil.getDocument();
            Node node = doc.selectSingleNode("//user[@username='"+username+"']");
            if(node==null)
                return null;

            String xmlBirthday = node.valueOf("@birthday");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date birthday = df.parse(xmlBirthday);

            User user = new User(node.valueOf("@username"), node.valueOf("@password"), node.valueOf("@email"), birthday);
            return user;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(User user) {
        try {
            Document doc = Dom4JUtil.getDocument();
            Element root = doc.getRootElement();
            root.addElement("user")
                    .addAttribute("username", user.getUsername())
                    .addAttribute("password", user.getPassword())
                    .addAttribute("email", user.getEmail())
                    .addAttribute("birthday", user.getBitrhday().toLocaleString());
            Dom4JUtil.write2xml(doc);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findUser(String username, String password) {
        try {
            Document doc = Dom4JUtil.getDocument();
//			List<Node> userNodes = doc.selectNodes("//user");
            Node node = doc.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");
            if(node==null)
                return null;

            String xmlBirthday = node.valueOf("@birthday");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date birthday = df.parse(xmlBirthday);

            User user = new User(node.valueOf("@username"), node.valueOf("@password"), node.valueOf("@email"), birthday);
            return user;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
