package com.tanjiaming99.controller;


import com.tanjiaming99.entity.Blog;
import com.tanjiaming99.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tanjiaming99
 * @since 2021-11-12 10:28:40
 */
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
