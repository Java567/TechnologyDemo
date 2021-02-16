package com.lj.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
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


    @ApiModelProperty("报告厅主键")
    private Integer auditoriumId;


    @Excel(name = "报告厅名称", width = 14.25)
    @ApiModelProperty("报告厅名称")
    private String auditoriumName;


    @Excel(name = "正在使用者", width = 14.25)
    @ApiModelProperty("正在使用者")
    private String username;


    @Excel(name = "所属楼层编号", width = 14.25)
    @ApiModelProperty("所属楼层编号")
    private Integer floorId;


    @Excel(name = "所属楼栋编号", width = 14.25)
    @ApiModelProperty("所属楼栋编号")
    private Integer buildId;


    @Excel(name = "所属校区编号", width = 14.25)
    @ApiModelProperty("所属校区编号")
    private Integer campusId;


    @Excel(name = "报告厅面积", width = 14.25)
    @ApiModelProperty("报告厅面积")
    private Integer auditoriumArea;


    @Excel(name = "可容纳人数", width = 14.25)
    @ApiModelProperty("可容纳人数")
    private Integer auditoriumCapacity;


    @Excel(name = "状态(是否空闲)", width = 14.25)
    @ApiModelProperty("状态(是否空闲)")
    private String auditoriumState;


    @Excel(name = "详情介绍", width = 14.25)
    @ApiModelProperty("详情介绍")
    private String auditoriumDetail;


    @Excel(name = "报告厅添加时间", width = 14.25)
    @ApiModelProperty("报告厅添加时间")
    @JsonProperty("auditorium_create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM+8")
    private Date auditoriumCreateTime;
}
