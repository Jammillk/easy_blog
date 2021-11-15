package com.tanjiaming99.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tanjiaming99.exception.ApplicationException;
import com.tanjiaming99.exception.CommonErrorCode;
import com.tanjiaming99.model.dto.BlogCategoryDTO;
import com.tanjiaming99.model.entity.BlogCategory;
import com.tanjiaming99.mapper.BlogCategoryMapper;
import com.tanjiaming99.service.IBlogCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author tanjiaming99
 * @since 2021-11-12 10:28:40
 */
@Service
public class BlogCategoryServiceImpl extends ServiceImpl<BlogCategoryMapper, BlogCategory> implements IBlogCategoryService {

    @Autowired
    private BlogCategoryMapper blogCategoryMapper;

    @Override
    public Boolean createCategory(BlogCategoryDTO dto) {
        if (Objects.nonNull(blogCategoryMapper.selectOne(new QueryWrapper<BlogCategory>()
                .eq("category_name", dto.getCategoryName())))) {
            throw new ApplicationException(CommonErrorCode.DUPLICATE_WRITE, "分类名称不能相同");
        }
        BlogCategory entity = new BlogCategory();
        BeanUtils.copyProperties(dto, entity);
        return blogCategoryMapper.insert(entity) > 0;
    }
}
