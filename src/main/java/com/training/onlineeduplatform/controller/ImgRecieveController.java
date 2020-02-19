package com.training.onlineeduplatform.controller;

import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;


/**
 * Created on 2020/2/10.
 *
 * @author Hongwe Xiong
 */

@RestController
@RequestMapping(value = "/img")
public class ImgRecieveController {

    private String IMAGES_DOMAIN_URL;
    private String IMAGES_LOCALHOST_URL =  "D:\\Postman\\online-edu-platform\\src\\main\\resources\\static\\img\\toelfman";

    //获取分隔符（不同系统不同）
    String sep = System.getProperty("file.separator");

    public ImgRecieveController() throws FileNotFoundException {
    }


    @RequestMapping(value = "/tfrRecieve",method = RequestMethod.POST)
    public String upLoadImg(MultipartFile file) throws IOException {
        String originalFileName = file.getOriginalFilename();// 获取到上传文件的名字
        // file.getSize();获取到上传文件的大小
        String newFileName = UUID.randomUUID()+originalFileName;
        File dir = new File(IMAGES_LOCALHOST_URL, newFileName);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            // MultipartFile自带的解析方法
            file.transferTo(dir);
        }catch (Exception e){
            e.printStackTrace();
        }
        String directory = dir.getCanonicalPath();
        System.out.println("directory:" + directory);

        return newFileName;
    }

    @RequestMapping(value = "/tfrGive",method = RequestMethod.GET)
    public String downLoadImg() {
        System.out.println("获取图片资源来了--------");
        try {
            String path = " ";
            path = ResourceUtils.getURL("classpath:").getPath();
            System.out.println(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "toelfman/f73b9529-89dd-4d2d-a8ea-a8be4bee5c7f1483BF0FB5CCFD0680CB90E9D1735779.jpg";
    }
}
