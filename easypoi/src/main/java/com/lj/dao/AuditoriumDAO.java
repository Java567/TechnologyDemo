package com.lj.dao;

import com.lj.model.Auditorium;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: LiJun
 * @date: Created in 2021/2/16 20:04
 */
@Repository
public interface AuditoriumDAO {

    /**
     * 得到表信息
     */
    List<Auditorium> getAllAuditorium();

    /**
     * 保存至数据库
     */
    void save(List<Auditorium> list);
}
