package cn.yong.service;

import cn.yong.entity.User;

public interface UserService {
    void save(User user);

    User login(String name,String password);
}
