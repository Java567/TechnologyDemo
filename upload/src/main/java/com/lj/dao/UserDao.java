package com.lj.dao;

import com.lj.model.User;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: LiJun
 * @date: Created in 2021/4/12 14:45
 */
@Repository
public interface UserDao {

    int updatePhotoById(User user);
}
