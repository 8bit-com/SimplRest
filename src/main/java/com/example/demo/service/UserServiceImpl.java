package com.example.demo.service;

import com.example.demo.dao.RoleDao;
import com.example.demo.dao.UserDao;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class UserServiceImpl implements UserService{
    private final UserDao userDao;
    private final RoleDao roleDao;

    public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }


    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    @PostConstruct
    public void addDefaultUser() {
        List<Role> roles1 = new ArrayList<>();
        roles1.add(roleDao.findById(1L).orElse(null));
        List<Role> roles2 = new ArrayList<>();
        roles2.add(roleDao.findById(1L).orElse(null));
        roles2.add(roleDao.findById(2L).orElse(null));
        User user1 = new User("Steve", "root", roles1);
        User user2 = new User("Garry", "root", roles2);
        save(user1);
        save(user2);
    }


}
