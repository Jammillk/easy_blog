package com.tanjiaming99.service;

import com.tanjiaming99.common.ajax.AjaxRes;
import com.tanjiaming99.model.dto.BlogCommentDTO;
import com.tanjiaming99.model.dto.BlogReplyDTO;
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

    Boolean createComment(BlogCommentDTO dto);

    Boolean replyComment(BlogReplyDTO dto);
}
