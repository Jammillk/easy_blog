package com.tanjiaming99.mapper;

import com.tanjiaming99.common.model.Page;
import com.tanjiaming99.model.dto.BlogDTO;
import com.tanjiaming99.model.entity.Blog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tanjiaming99.model.param.PageBlogParam;
import com.tanjiaming99.model.vo.BlogVO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tanjiaming99
 * @since 2021-11-12 10:28:40
 */
public interface BlogMapper extends BaseMapper<Blog> {

    Boolean createBlog(@Param("dto") BlogDTO dto);

    Page<BlogVO> queryPage(@Param("page") Page<BlogVO> page,@Param("param") PageBlogParam param);
}
