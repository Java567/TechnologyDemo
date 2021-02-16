package com.lj.service;

import com.lj.model.Auditorium;

import java.util.List;

/**
 * @description:
 * @author: LiJun
 * @date: Created in 2021/2/16 20:04
 */
public interface AuditoriumService {

    /**
     * 得到表信息
     */
    List<Auditorium> getAllAuditorium();

    /**
     * 将list列表保存到数据库中
     */
    void save(List<Auditorium> list);
}
