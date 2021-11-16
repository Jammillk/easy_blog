package com.tanjiaming99.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author tanjiaming99.com
 * @Date 2021/11/16 13:36
 **/
public interface IUploadService {
    void uploadFile(MultipartFile file);

}
