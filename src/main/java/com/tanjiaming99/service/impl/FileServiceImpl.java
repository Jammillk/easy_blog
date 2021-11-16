package com.tanjiaming99.service.impl;

import com.tanjiaming99.service.IFileService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 上传相关
 * @Author tanjiaming99.com
 * @Date 2021/11/16 13:36
 **/
@Service
public class FileServiceImpl implements IFileService {
    @Override
    public void uploadFile(MultipartFile file) {
        String filePath = file.getOriginalFilename();
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));){
            bos.write(file.getBytes());
            bos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ResponseEntity download() {
        return null;
    }
}
