package com.tanjiaming99.service;

import com.tanjiaming99.model.entity.Config;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tanjiaming99
 * @since 2021-11-12 10:28:40
 */
public interface IConfigService extends IService<Config> {

    Boolean createConfig(Config config);

    Boolean updateConfig(Config config);

}
