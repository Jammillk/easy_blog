package com.tanjiaming99.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.tanjiaming99.event.comment.NewCommentEvent;
import com.tanjiaming99.model.dto.CommentDTO;
import com.tanjiaming99.model.dto.CommentReplyDTO;
import com.tanjiaming99.model.dto.CommentStatusDTO;
import com.tanjiaming99.model.entity.BlogComment;
import com.tanjiaming99.mapper.BlogCommentMapper;
import com.tanjiaming99.service.IBlogCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public Boolean createComment(CommentDTO dto) {
        // 校验码的校验，暂时先不做
        String kaptcha = dto.getKaptcha();

        // 复制参数。是否有点多余？
        BlogComment blogComment = new BlogComment();
        BeanUtils.copyProperties(dto, blogComment);
        applicationEventPublisher.publishEvent(new NewCommentEvent(blogComment));
        return blogCommentMapper.insert(blogComment) > 0;
    }

    @Override
    public Boolean replyComment(CommentReplyDTO dto) {
        return blogCommentMapper.update(null, new UpdateWrapper<BlogComment>()
                .set("reply_body", dto.getReplyBody())
                .set("reply_create_time", LocalDateTime.now().withNano(0))
                .eq("comment_id", dto.getCommentId())) > 0;
    }

    @Override
    public Boolean censorComment(CommentStatusDTO dto) {
        return blogCommentMapper.update(null, new UpdateWrapper<BlogComment>()
                .set("comment_status", dto.getCommentStatus())
                .eq("comment_id", dto.getCommentId())) > 0;
    }
}
