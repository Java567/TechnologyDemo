package com.lj.controller;

import com.lj.core.util.FileUploadUtil;
import com.lj.model.User;
import com.lj.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @description:
 * @author: LiJun
 * @date: Created in 2021/4/12 14:49
 */
@RestController
@RequestMapping("user")
@Api(tags = "User测试demo相关的API接口")
public class UserController {

    @Resource
    private UserService userService;


    @PostMapping("/uploadImage")
    @ApiOperation(value="文件上传接口", notes = "测试图片上传")
    public Map<String,Object> uploadFile(@RequestParam("file") MultipartFile file,
                          HttpServletRequest request) throws Exception {
        Integer id=1;
        FileUploadUtil fileUploadUtil=new FileUploadUtil();
        Map<String, Object> map = fileUploadUtil.categoryImageUpload(file, request);
        String newFileName = (String) map.get("imageName");
        User user=new User(id,"","",newFileName);
        int i = userService.updatePhotoById(user);
        map.put("SQLisTrue",i);
        return map;
    }

}
