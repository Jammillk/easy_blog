package com.tanjiaming99.controller.common;

import com.tanjiaming99.service.IUploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author tanjiaming99.com
 * @Date 2021/11/16 13:29
 **/
@RestController
@Api(value = "上传相关模块", tags = "上传相关模块")
public class UploadController {
    @Autowired
    private IUploadService uploadService;

    @PostMapping("/upload")
    @ApiOperation(value = "上传文件")
    public void upload(@RequestParam("file")MultipartFile file){
        uploadService.uploadFile(file);
    }
}
