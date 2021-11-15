package com.tanjiaming99.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tanjiaming99.exception.ApplicationException;
import com.tanjiaming99.exception.CommonErrorCode;
import com.tanjiaming99.model.entity.Config;
import com.tanjiaming99.mapper.ConfigMapper;
import com.tanjiaming99.service.IConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
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
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config> implements IConfigService {

    @Autowired
    private ConfigMapper configMapper;

    @Override
    public Boolean createConfig(Config config) {
        if (configMapper.selectOne(new QueryWrapper<Config>()
                .eq("config_id", config.getConfigId())) != null) {
            throw new ApplicationException(CommonErrorCode.DUPLICATE_WRITE, "已存在该配置名称");
        }
        return configMapper.insert(config) > 0;
    }

    @Override
    public Boolean updateConfig(Config config) {
        if (Objects.nonNull(configMapper.selectOne(new QueryWrapper<Config>()
                .ne("config_id", config.getConfigId())
                .eq("config_name", config.getConfigName())))){
            throw new ApplicationException(CommonErrorCode.DUPLICATE_WRITE, "已存在该配置名称");
        }
        return configMapper.updateById(config) > 0;
    }

}
