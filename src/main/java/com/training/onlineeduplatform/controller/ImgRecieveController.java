package com.training.onlineeduplatform.controller;

import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    private String IMAGES_LOCALHOST_URL =  "D:\\Postman\\";
    private String path = "/usr/local/tomcat/apache-tomcat-8.0.39/webapps/";
    //获取分隔符（不同系统不同）
    String sep = System.getProperty("file.separator");

    public ImgRecieveController() throws FileNotFoundException {
    }


    @RequestMapping(value = "/tfrRecieve",method = RequestMethod.POST)
    public String upLoadImg(@RequestParam("imgPath") String imgBaseUrl, @RequestParam("file") MultipartFile file) throws IOException {
        String originalFileName = file.getOriginalFilename();// 获取到上传文件的名字
        // file.getSize();获取到上传文件的大小
        String newFileName = UUID.randomUUID()+originalFileName;
        File dir = new File(path+"static/images/"+imgBaseUrl, newFileName);
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

    @RequestMapping(value = "/imgGive",method = RequestMethod.POST)
    public String downLoadImg(int id) {
        System.out.println("获取图片资源来了--------");
        try {
            String path = " ";
            path = ResourceUtils.getURL("classpath:").getPath();
            System.out.println(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "toelfman/1a9fd00c26c4494976197b232fd62d00d54794bf_raw.jpg";
    }
}
