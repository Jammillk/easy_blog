package com.tanjiaming99.service;

import com.tanjiaming99.model.dto.BlogDTO;
import com.tanjiaming99.model.entity.Blog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tanjiaming99
 * @since 2021-11-12 10:28:40
 */
public interface IBlogService extends IService<Blog> {

    Boolean createBlog(BlogDTO dto);
}
