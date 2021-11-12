package com.tanjiaming99.service.impl;

import com.tanjiaming99.entity.BlogComment;
import com.tanjiaming99.mapper.BlogCommentMapper;
import com.tanjiaming99.service.IBlogCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tanjiaming99
 * @since 2021-11-12 10:28:40
 */
@Service
public class BlogCommentServiceImpl extends ServiceImpl<BlogCommentMapper, BlogComment> implements IBlogCommentService {

}
