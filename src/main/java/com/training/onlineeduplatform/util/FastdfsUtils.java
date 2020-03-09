package com.training.onlineeduplatform.util;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * Created on 2020/3/3.
 *
 * FastDFS模块API接口
 *
 * @author Yue Wu
 */
@Component
public class FastdfsUtils {
    public static final String DEFAULT_CHARSET = "UTF-8";

    /**
     * 返回前端时可以用来拼接
     */
    public static final String BASE_URL = "http://120.27.241.26/";

    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    /**
     * 上传
     * @param file
     * @return
     * @throws IOException
     */
    public String upload(MultipartFile file) throws IOException {
        // 上传
        StorePath storePath = fastFileStorageClient.uploadFile(
                file.getInputStream(), file.getSize(),
                FilenameUtils.getExtension(file.getOriginalFilename()),
                null);
        return storePath.getFullPath();
    }

    /**
     * 删除
     * @param path storePath.getFullPath()
     */
    public void delete(String path) {
        fastFileStorageClient.deleteFile(path);
    }

    /**
     * 删除
     * @param group 所在组
     * @param path 所在组的全路径
     */
    public void delete(String group,String path) {
        fastFileStorageClient.deleteFile(group,path);
    }

    /**
     * 文件下载
     * @param url 路径 storePath.getFullPath()不包含ip及端口号
     */
    public void download(String url, HttpServletResponse response) throws IOException {
        String group = url.substring(0, url.indexOf("/"));
        String path = url.substring(url.indexOf("/") + 1);

        //文件后缀
        String substring = url.substring(url.lastIndexOf(".") + 1);
        byte[] bytes = fastFileStorageClient.downloadFile(group, path, new DownloadByteArray());

        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(UUID.randomUUID().toString()+"."+substring, "UTF-8"));

        // 写出
        ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.write(bytes, outputStream);
    }
}
