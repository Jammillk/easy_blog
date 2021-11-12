package com.tanjiaming99.service.impl;

import com.tanjiaming99.model.entity.Config;
import com.tanjiaming99.mapper.ConfigMapper;
import com.tanjiaming99.service.IConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tanjiaming99
 * @since 2021-11-12 10:28:40
 */
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config> implements IConfigService {

}
