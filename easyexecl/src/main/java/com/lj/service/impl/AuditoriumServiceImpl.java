package com.lj.service.impl;

import com.lj.dao.AuditoriumDAO;
import com.lj.model.Auditorium;
import com.lj.service.AuditoriumService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: LiJun
 * @date: Created in 2021/2/16 20:04
 */
@Service
public class AuditoriumServiceImpl implements AuditoriumService {

    @Resource
    private AuditoriumDAO auditoriumDAO;

    @Override
    public List<Auditorium> getAllAuditorium() {
        return auditoriumDAO.getAllAuditorium();
    }

    @Override
    public void save(List<Auditorium> list) {
        auditoriumDAO.save(list);
    }
}
