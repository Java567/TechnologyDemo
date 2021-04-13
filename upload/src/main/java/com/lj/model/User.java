package com.lj.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @description:
 * @author: LiJun
 * @date: Created in 2021/4/12 14:39
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "User", description = "测试模型")
public class User implements Serializable {

    @ApiModelProperty("用户主键")
    private Integer id;

    @ApiModelProperty("用户姓名")
    private String username;


    @ApiModelProperty("用户密码")
    private String password;

    @ApiModelProperty("用户上传服务器图片")
    private String photo;
}
