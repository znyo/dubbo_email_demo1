package com.qf.service;

import com.qf.entity.User;

public interface IUserService {
    public int addUser();
    public User selectName(String name);
}
