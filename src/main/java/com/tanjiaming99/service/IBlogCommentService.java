package com.tanjiaming99.service;

import com.tanjiaming99.model.dto.CommentDTO;
import com.tanjiaming99.model.dto.CommentReplyDTO;
import com.tanjiaming99.model.dto.CommentStatusDTO;
import com.tanjiaming99.model.entity.BlogComment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tanjiaming99
 * @since 2021-11-12 10:28:40
 */
public interface IBlogCommentService extends IService<BlogComment> {

    Boolean createComment(CommentDTO dto);

    Boolean replyComment(CommentReplyDTO dto);

    Boolean censorComment(CommentStatusDTO dto);
}
