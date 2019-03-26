package com.supeng.service.impl;

import com.supeng.dao.ABusUserMapper;
import com.supeng.model.ABusUser;
import com.supeng.service.ABusUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ABusUserServiceImpl implements ABusUserService {

    private ABusUserMapper aBusUserMapper;

    @Autowired
    public ABusUserServiceImpl(ABusUserMapper aBusUserMapper) {
        this.aBusUserMapper = aBusUserMapper;
    }

    @Override
    public List<ABusUser> selectUserList() {
        return aBusUserMapper.selectUserList();
    }

    @Override
    public void deleteUser(int id) {
        ABusUser aBusUser = aBusUserMapper.selectUserById(id);
        aBusUserMapper.deleteUser(aBusUser);
    }

    @Override
    public ABusUser selectUserById(int id) {
        return aBusUserMapper.selectUserById(id);
    }

    @Override
    public int insert(ABusUser record) {
        return aBusUserMapper.insert(record);
    }

    @Override
    public void updateUser(ABusUser user) {
        aBusUserMapper.updateUser(user);
    }


}
