package com.training.onlineeduplatform.util;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

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
     * @param group
     * @param path
     */
    public void delete(String group,String path) {
        fastFileStorageClient.deleteFile(group,path);
    }
}
