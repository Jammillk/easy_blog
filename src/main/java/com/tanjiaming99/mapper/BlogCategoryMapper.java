package com.tanjiaming99.mapper;

import com.tanjiaming99.model.dto.BlogCategoryDTO;
import com.tanjiaming99.model.entity.BlogCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tanjiaming99
 * @since 2021-11-12 10:28:40
 */
public interface BlogCategoryMapper extends BaseMapper<BlogCategory> {

    Boolean createCategory(@Param("dto") BlogCategoryDTO dto);
}
