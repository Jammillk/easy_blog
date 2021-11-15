package com.tanjiaming99.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tanjiaming99.mapper.BlogTagMapper;
import com.tanjiaming99.model.dto.BlogTagDTO;
import com.tanjiaming99.model.entity.BlogTagRelation;
import com.tanjiaming99.mapper.BlogTagRelationMapper;
import com.tanjiaming99.service.IBlogTagRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author tanjiaming99
 * @since 2021-11-12 10:28:40
 */
@Service
public class BlogTagRelationServiceImpl extends ServiceImpl<BlogTagRelationMapper, BlogTagRelation> implements IBlogTagRelationService {

    @Autowired
    private BlogTagRelationMapper blogTagRelationMapper;

    @Override
    public Boolean createTagFromBlog(BlogTagDTO dto) {
        final Long blogId = dto.getBlogId();
        ArrayList<BlogTagRelation> relations = new ArrayList<>();
        dto.getTags().forEach(tags -> {
            relations.add(
                    BlogTagRelation.builder()
                            .blogId(blogId)
                            .tagId(tags.getTagId())
                            .build()
            );
        });
        return saveBatch(relations);
    }

    @Override
    public Boolean updateTagForBlog(BlogTagDTO dto) {
        deleteTagRelationByBlogId(dto.getBlogId());
        return createTagFromBlog(dto);
    }

    private void deleteTagRelationByBlogId(Long blogId) {
        blogTagRelationMapper.delete(new QueryWrapper<BlogTagRelation>().eq("blog_id", blogId));
    }
}
