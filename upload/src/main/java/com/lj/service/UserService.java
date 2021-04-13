package com.lj.service;

import com.lj.model.User;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: LiJun
 * @date: Created in 2021/4/12 14:44
 */
public interface UserService {

    int updatePhotoById(User user);
}
