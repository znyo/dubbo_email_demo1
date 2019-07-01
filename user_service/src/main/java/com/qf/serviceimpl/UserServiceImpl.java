package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.entity.User;
import com.qf.mapper.UserMapper;
import com.qf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser() {

        return userMapper.insert(null);
    }

    @Override
    public User selectName(String name) {
        return userMapper.selectById(name);
    }
}
