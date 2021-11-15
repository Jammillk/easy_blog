package com.tanjiaming99.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.tanjiaming99.mapper.BlogTagRelationMapper;
import com.tanjiaming99.model.entity.BlogTag;
import com.tanjiaming99.mapper.BlogTagMapper;
import com.tanjiaming99.model.entity.BlogTagRelation;
import com.tanjiaming99.service.IBlogTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tanjiaming99
 * @since 2021-11-12 10:28:40
 */
@Service
public class BlogTagServiceImpl extends ServiceImpl<BlogTagMapper, BlogTag> implements IBlogTagService {

    @Autowired
    private BlogTagMapper blogTagMapper;

    @Autowired
    private BlogTagRelationMapper blogTagRelationMapper;

    @Transactional
    @Override
    public Boolean deleteTag(Integer tagId) {
        int tag = blogTagMapper.deleteById(tagId);
        int relation = blogTagRelationMapper.delete(new QueryWrapper<BlogTagRelation>().eq("tag_id", tagId));
        return tag > 0 && relation > 0;
    }

    @Override
    public List<BlogTag> findTagByBlogId(Integer blogId) {
        return blogTagMapper.selectByBlogId(blogId);
    }
}
