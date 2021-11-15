package com.tanjiaming99.service;

import com.tanjiaming99.model.dto.BlogCategoryDTO;
import com.tanjiaming99.model.entity.BlogCategory;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tanjiaming99
 * @since 2021-11-12 10:28:40
 */
public interface IBlogCategoryService extends IService<BlogCategory> {

    Boolean createCategory(BlogCategoryDTO dto);
}
