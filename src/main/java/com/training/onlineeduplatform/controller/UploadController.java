package com.training.onlineeduplatform.controller;

import com.training.onlineeduplatform.model.FastDFSFile;
import com.training.onlineeduplatform.util.FastDFSClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * Created on 2020/2/28.
 *
 * @author Hongwe Xiong
 */
@Controller
public class UploadController {
    private static Logger logger = LoggerFactory.getLogger(UploadController.class);

    public String saveFile(MultipartFile multipartFile) throws IOException {
        String[] fileAbsolutePath = {};
        String fileName = UUID.randomUUID()+ multipartFile.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        byte[] file_buff = null;
        InputStream inputStream = multipartFile.getInputStream();
        if(inputStream != null ) {
            int len1 = inputStream.available();
            file_buff = new byte[len1];
            inputStream.read(file_buff);
        }
        inputStream.close();
        FastDFSFile file = new FastDFSFile(fileName, file_buff, ext);
        try {
            fileAbsolutePath = FastDFSClient.upload(file);
        } catch (Exception e) {
            logger.error("upload file Exception!",e);
        }
        if (fileAbsolutePath == null) {
            logger.error("upload file failed,please upload again!");
        }
        String path = FastDFSClient.getTrackerUrl() + fileAbsolutePath[0] + "/" + fileAbsolutePath[1];
        return path;
    }

    /**
     * 删除文件
     * @param groupName 组名 如：group1
     * @param remoteFileName 不带组名的路径名称 如：M00/00/00/wKgRsVjtwpSAXGwkAAAweEAzRjw471.jpg
     * @throws Exception
     */
    public boolean deleteFile(String groupName, String remoteFileName) throws Exception {
        FastDFSClient.deleteFile(groupName,remoteFileName);
        return true;
    }
}
