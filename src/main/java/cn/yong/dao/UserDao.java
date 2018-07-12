package cn.yong.dao;

import cn.yong.entity.User;

import java.util.List;

public interface UserDao {
    void save(User user);

    List<User> getUserByName(String name);
}
