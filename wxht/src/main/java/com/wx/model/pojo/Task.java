package com.wx.model.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Task", description = "任务模型")
public class Task implements Serializable {

    @ApiModelProperty("任务主键")
    private Integer taskId;
    @ApiModelProperty("任务标题")
    private String title;
    @ApiModelProperty("详细内容")
    private String content;
    @ApiModelProperty("过期时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM+8")
    private Date expiration; // 过期，截止

}
