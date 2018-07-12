package cn.yong.dao.impl;

import cn.yong.dao.UserDao;
import cn.yong.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private HibernateTemplate template;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.template = new HibernateTemplate(sessionFactory);
    }

    @Override
    public void save(User user) {
        template.save(user);
    }

    @Override
    public List<User> getUserByName(String name) {
        return (List<User>)template.find("from User where name = ?",name);
    }
}
