package com.lj.controller;

import com.alibaba.excel.EasyExcel;
import com.lj.common.config.AuditoriumDataListener;
import com.lj.model.Auditorium;
import com.lj.service.AuditoriumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @description:
 * @author: LiJun
 * @date: Created in 2021/2/16 20:04
 */
@RestController
@RequestMapping("Auditorium")
@Api(tags = "Auditorium报告厅相关的API接口")
public class AuditoriumController {

    @Resource
    private AuditoriumService auditoriumService;

    /**
     * 数据导入
     */
    @ResponseBody
    @PostMapping("/loadIn")
    @ApiOperation(value="execl数据导入接口", notes = "execl数据导入到对应的报告厅数据库表")
    public void loadIn(@RequestParam("file") MultipartFile file) throws IOException {

        EasyExcel.read(file.getInputStream(),
                Auditorium.class,
                new AuditoriumDataListener(auditoriumService)).sheet().doRead();
    }



    /**
     * 导出house信息，需要用浏览器测试,"application/vnd.ms-excel;charset=utf-8"
     * @param response
     * @return
     * @throws IOException
     */
    @ResponseBody
    @GetMapping("/loadOut")
    @ApiOperation(value="execl导出Auditorium接口", notes = "导出Auditorium表里的数据并生成可以下载的execl表")
    public Integer loadOut(HttpServletResponse response) throws IOException{
        List<Auditorium> list = auditoriumService.getAllAuditorium();
        String fileName = new String("Auditorium.xlsx".getBytes("utf-8"), "ISO-8859-1");
        if (list.isEmpty()){
            return 0;
        } else {
            // 请求头
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.flushBuffer();
            response.setCharacterEncoding("UTF-8");
            //导出execl
            EasyExcel.write(response.getOutputStream(),Auditorium.class).sheet("Auditorium").doWrite(list);
            return 1;
        }
    }
}
