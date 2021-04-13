package com.lj.service.impl;

import com.lj.dao.UserDao;
import com.lj.model.User;
import com.lj.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: LiJun
 * @date: Created in 2021/4/12 14:45
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public int updatePhotoById(User user) {
        return userDao.updatePhotoById(user);
    }
}
