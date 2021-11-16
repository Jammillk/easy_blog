package com.tanjiaming99.controller.common;

import com.tanjiaming99.exception.ApplicationException;
import com.tanjiaming99.exception.CommonErrorCode;
import com.tanjiaming99.service.IFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author tanjiaming99.com
 * @Date 2021/11/16 13:29
 **/
@RestController
@Api(value = "文件操作相关模块", tags = "文件操作相关模块")
public class FileController {
    @Autowired
    private IFileService fileService;

    @PostMapping("/upload")
    @ApiOperation(value = "上传文件")
    public void upload(@RequestParam("file") MultipartFile file) {
        fileService.uploadFile(file);
    }

    @GetMapping("/download")
    public ResponseEntity uploaded() throws Exception {
        if (true){
            throw new ApplicationException(CommonErrorCode.DEVELOPMENT_ERROR, "开发中...");
        }
        FileSystemResource file = new FileSystemResource("");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename = xxx");
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(file.getInputStream()));
    }


}
