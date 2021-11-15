package com.tanjiaming99.mapper;

import com.tanjiaming99.model.entity.BlogTag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tanjiaming99
 * @since 2021-11-12 10:28:40
 */
public interface BlogTagMapper extends BaseMapper<BlogTag> {

    List<BlogTag> selectByBlogId(@Param("blogId") Integer blogId);
}
