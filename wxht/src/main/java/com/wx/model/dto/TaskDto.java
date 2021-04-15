package com.wx.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "TaskDto", description = "任务传输模型")
public class TaskDto implements Serializable {

    @ApiModelProperty("任务标题")
    private String title;
    @ApiModelProperty("详细内容")
    private String content;
    @ApiModelProperty("过期时间")
    private Date expiration; // 过期，截止

}
