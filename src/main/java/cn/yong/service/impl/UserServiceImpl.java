package cn.yong.service.impl;

import cn.yong.dao.UserDao;
import cn.yong.entity.User;
import cn.yong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User login(String name, String password) {
        User user = null;
        List<User> listUser = userDao.getUserByName(name);
        if (listUser!=null && listUser.size()>0){
            if (password.equals(listUser.get(0).getPassword())){
                user = listUser.get(0);
            }
        }
        return user;
    }
}
