package com.supeng.dao;

import com.supeng.model.ABusUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ABusUserMapper {
    int insert(ABusUser record);

    int insertSelective(ABusUser record);

    List<ABusUser> selectUserList();

    void deleteUser(ABusUser aBusUser);

    ABusUser selectUserById(int id);

    void updateUser(ABusUser user);
}