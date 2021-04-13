package com.lj.core.util;

import com.lj.core.constant.Constants;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import static com.lj.core.util.GetHostUtil.getHost;

/**
 * @description:
 * @author: LiJun
 * @date: Created in 2021/3/10 15:05
 */
public class FileUploadUtil {

    public Map<String,Object> categoryImageUpload(MultipartFile file, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Random r = new Random();
        StringBuilder tempName = new StringBuilder();
        tempName.append(sdf.format(new Date())).append(r.nextInt(100)).append(suffixName);
        String newFileName = tempName.toString();
        File fileDirectory = new File(Constants.IMAGE_UPLOAD);
//        System.out.println(newFileName);
        File dest = new File(Constants.IMAGE_UPLOAD + newFileName);
        try {
            if (!fileDirectory.exists()) {
                if (!fileDirectory.mkdir()) {
                    throw new IOException("文件夹创建失败,路径为：" + fileDirectory);
                }
            }
            file.transferTo(dest);
            map.put("success", 1);
            map.put("imageName",newFileName);
            map.put("src", getHost(new URI(request.getRequestURL() + "")) + "/opt/fcglImage/" + newFileName);
//            System.out.println(getHost(new URI(request.getRequestURL() + "")) + "/upload/" + newFileName);
        } catch (IOException | URISyntaxException e) {
            map.put("error", 0);
            e.printStackTrace();
        }
        return map;
    }
}
