package com.tanjiaming99.service;

import com.tanjiaming99.model.entity.BlogTag;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tanjiaming99
 * @since 2021-11-12 10:28:40
 */
public interface IBlogTagService extends IService<BlogTag> {

    Boolean deleteTag(Integer tagId);

    List<BlogTag> findTagByBlogId(Integer blogId);
}
