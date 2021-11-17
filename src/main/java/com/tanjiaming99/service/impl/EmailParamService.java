package com.tanjiaming99.service.impl;

import com.tanjiaming99.mapper.BlogCommentMapper;
import com.tanjiaming99.mapper.BlogMapper;
import com.tanjiaming99.model.entity.Blog;
import com.tanjiaming99.model.entity.BlogComment;
import com.tanjiaming99.model.entity.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tanjiaming99
 * @version 1.0
 * @date 2021/11/17 10:48
 * @description
 */
@Service
public class EmailParamService  {

    @Autowired
    private BlogCommentMapper blogCommentMapper;

    @Autowired
    private BlogMapper blogMapper;

    @Value("${mail.fromMail.nickname}")
    private String nickname;

    @Value("${mail.fromMail.author}")
    private String author;

    @Value("${mail.fromMail.url}")
    private String url;

    public Map<String, String> noticeParam(Email email) {
        Blog blog = blogMapper.selectById(email.getBlogId());
        BlogComment comment = blogCommentMapper.selectById(email.getCommentId());
        Map<String, String> map = new HashMap<>();
        map.put("nickname", nickname);
        map.put("author", comment.getCommentator());
        map.put("pageTitle", blog.getBlogTitle());
        map.put("content", email.getContext());
        map.put("pageFullPath", comment.getWebsiteUrl());
        return map;
    }

    public Map<String, String> replyParam(Email email) {
        Blog blog = blogMapper.selectById(email.getBlogId());
        BlogComment comment = blogCommentMapper.selectById(email.getCommentId());
        Map<String, String> map = new HashMap<>();
        map.put("blog_title", blog.getBlogTitle());
        map.put("baseAuthor", comment.getCommentator());
        map.put("pageTitle", email.getSubject());
        map.put("baseContent",  comment.getCommentBody());
        map.put("replyAuthor", author);
        map.put("replyContent",email.getContext());
        map.put("pageFullPath", comment.getWebsiteUrl());
        map.put("blog_url", url);
        return map;
    }
}
