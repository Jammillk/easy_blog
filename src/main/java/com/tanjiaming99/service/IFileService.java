package com.tanjiaming99.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author tanjiaming99.com
 * @Date 2021/11/16 13:36
 **/
public interface IFileService {
    void uploadFile(MultipartFile file);

    ResponseEntity download();

}
