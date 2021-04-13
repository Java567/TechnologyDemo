//package com.lj.core.util;
//
//import com.lj.core.constant.Constants;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Random;
//
///**
// * @Description: 文件工具类
// * @author: ZYQ
// * @date: 2021/3/16 21:28
// */
//public class FileUtil {
//
//    /**
//     * 按照规则生成新的文件名（不重复
//     */
//    public static String newFileName(MultipartFile file) {
//        String fileName = file.getOriginalFilename();
//        String suffixName = fileName.substring(fileName.lastIndexOf("."));
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
//        Random r = new Random();
//        StringBuilder tempName = new StringBuilder();
//        tempName.append(sdf.format(new Date())).append(r.nextInt(100)).append(suffixName);
//        String newFileName = tempName.toString();
//        return newFileName;
//    }
//
//    /**
//     * 上传图片至服务器，并返回文件名字
//     */
//    public static String uploadImage(MultipartFile file) {
//        try {
//            File filePath = new File(Constants.IMAGE_UPLOAD);
//            if (!filePath.exists()) {
//                if (!filePath.mkdir()) {
//                    throw new IOException("目录创建失败,路径为: " + Constants.IMAGE_UPLOAD);
//                }
//            }
//            String newFileName = newFileName(file);
//            File dest = new File(Constants.IMAGE_UPLOAD + newFileName);
//            file.transferTo(dest);
//            return newFileName;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//}
