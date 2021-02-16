package com.lj.model;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 报告厅基本信息实体类
 * @author: LiJun
 * @date: Created in 2021/2/15 20:42
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Auditorium", description = "报告厅模型")
public class Auditorium implements Serializable {

    @ExcelIgnore
    @ApiModelProperty("报告厅主键")
    private Integer auditoriumId;


    @ExcelProperty("报告厅名称")
    @ApiModelProperty("报告厅名称")
    private String auditoriumName;


    @ExcelProperty("正在使用者")
    @ApiModelProperty("正在使用者")
    private String username;


    @ExcelProperty("所属楼层编号")
    @ApiModelProperty("所属楼层编号")
    private Integer floorId;


    @ExcelProperty("所属楼栋编号")
    @ApiModelProperty("所属楼栋编号")
    private Integer buildId;


    @ExcelProperty("所属校区编号")
    @ApiModelProperty("所属校区编号")
    private Integer campusId;


    @ExcelProperty("报告厅面积")
    @ApiModelProperty("报告厅面积")
    private Integer auditoriumArea;


    @ExcelProperty("可容纳人数")
    @ApiModelProperty("可容纳人数")
    private Integer auditoriumCapacity;


    @ExcelProperty("状态(是否空闲)")
    @ApiModelProperty("状态(是否空闲)")
    private String auditoriumState;


    @ExcelProperty("详情介绍")
    @ApiModelProperty("详情介绍")
    private String auditoriumDetail;


    @ExcelProperty("报告厅添加时间")
    @ApiModelProperty("报告厅添加时间")
    @JsonProperty("auditorium_create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM+8")
    private Date auditoriumCreateTime;
}
