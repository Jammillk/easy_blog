package com.tanjiaming99.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * mybatis-plus自动填充策略配置
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        this.strictInsertFill(metaObject, "createTime",()->LocalDateTime.now().withNano(0) , LocalDateTime.class);
        this.strictUpdateFill(metaObject, "updateTime", ()->LocalDateTime.now().withNano(0), LocalDateTime.class);
    }


    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.strictUpdateFill(metaObject, "updateTime",()->LocalDateTime.now().withNano(0), LocalDateTime.class);
    }
}
