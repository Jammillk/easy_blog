package com.tanjiaming99.service;

import com.tanjiaming99.common.model.Page;
import com.tanjiaming99.model.dto.BlogDTO;
import com.tanjiaming99.model.entity.Blog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tanjiaming99.model.param.PageBlogParam;
import com.tanjiaming99.model.vo.BlogVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tanjiaming99
 * @since 2021-11-12 10:28:40
 */
public interface IBlogService extends IService<Blog> {

    Boolean createBlog(Blog dto);

    Page<BlogVO> queryPage(Page<BlogVO> page, PageBlogParam param);
}
