package com.wj.bike.service;

import com.wj.bike.bean.User;

public interface UserService {
    void register(User user);

    void deposit(User user);

    void identify(User user);

    boolean recharge(String params);
}
