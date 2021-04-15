package com.wx.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
@RestController
@RequestMapping("login")
@Api(tags = "Task任务相关的API接口")
public class WxLoginController {


/**
 * 微信登录样板
 */
//    @PostMapping("/login/{phoneNum}")
//    @ApiOperation(value = "微信授权登录,根据电话号码和角色登入，如数据库没有输入的电话号码则登入失败", notes="微信授权登录,如果没有输入个人信息授权失败")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "code", value = "微信登录code", required = true, dataType = "string"),
//            @ApiImplicitParam(name = "phoneNum", value = "电话号码登录", required = true, dataType = "string")
//    })
//    public ResultInfo<?> login(@NotEmpty(message = "请选择一个微信号授权")
//                               @RequestParam("code") String  code,
//                               @PathVariable("phoneNum") String phoneNum){
//        ResultInfo<?> member = partyMemberService.getMemberByWechatId(code,phoneNum);
//        return member == null ? ResultInfoUtil.buildError(ApiConstant.ERROR_CODE, "授权失败") : ResultInfoUtil.buildSuccess(member);
//    }
}
