package com.lj.common.config;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.lj.model.Auditorium;
import com.lj.service.AuditoriumService;

import java.util.ArrayList;
import java.util.List;

/**
 * 实体类报告厅数据监视器
 */
public class AuditoriumDataListener extends AnalysisEventListener<Auditorium> {

    private static final int BATCH_COUNT = 5;

    List<Auditorium> list = new ArrayList<Auditorium>();

    private AuditoriumService auditoriumService;

    public AuditoriumDataListener(AuditoriumService auditoriumService) {
        this.auditoriumService = auditoriumService;
    }

    /**
     * 这个每一条数据解析都会来调用
     */
    @Override
    public void invoke(Auditorium data, AnalysisContext context) {
//        System.out.println(JSON.toJSONString(data));
        list.add(data);
        if (list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();
        }
    }

    /**
     * 所有数据解析后
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        saveData();
    }

    /**
     * 存储到数据库
     */
    private void saveData() {
        auditoriumService.save(list);
    }
}