package com.tanjiaming99.service.impl;

import com.tanjiaming99.model.dto.BlogCommentDTO;
import com.tanjiaming99.model.entity.BlogComment;
import com.tanjiaming99.mapper.BlogCommentMapper;
import com.tanjiaming99.service.IBlogCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author tanjiaming99
 * @since 2021-11-12 10:28:40
 */
@Service
public class BlogCommentServiceImpl extends ServiceImpl<BlogCommentMapper, BlogComment> implements IBlogCommentService {

    @Autowired
    private BlogCommentMapper blogCommentMapper;

    @Override
    public Boolean createComment(BlogCommentDTO dto) {
        // 校验码的校验，暂时先不做
        String kaptcha = dto.getKaptcha();

        // 复制参数。是否有点多余？
        BlogComment blogComment = new BlogComment();
        BeanUtils.copyProperties(dto, blogComment);
        return blogCommentMapper.insert(blogComment) > 0;
    }
}
