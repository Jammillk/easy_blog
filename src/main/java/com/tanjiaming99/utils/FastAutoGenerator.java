package com.tanjiaming99.utils;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FastAutoGenerator {

    /**
     * 执行初始化数据库脚本
     */
    public static void before() throws SQLException {
        Connection conn = DATA_SOURCE_CONFIG.build().getConn();
        InputStream inputStream = FastAutoGenerator.class.getResourceAsStream("/sql/init.sql");
        ScriptRunner scriptRunner = new ScriptRunner(conn);
        scriptRunner.setAutoCommit(true);
        scriptRunner.runScript(new InputStreamReader(inputStream));
        conn.close();
    }

    /**
     * 数据源配置
     */
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
        .Builder("jdbc:mysql://localhost:3306/easy_blog?useUnicode=true&characterEncoding=utf8&autoReconnect=true&useSSL=false&serverTimezone=UTC",
            "root", "admin");

    public static void main(String[] args) {
        List<String> tables = Arrays.asList("tb_admin_user","tb_blog", "tb_blog_category", "tb_blog_comment", "tb_blog_tag", "tb_blog_tag_relation", "tb_config", "tb_link");

        com.baomidou.mybatisplus.generator.FastAutoGenerator.create("jdbc:mysql://localhost:3306/easy_blog?useUnicode=true&characterEncoding=utf8&autoReconnect=true&useSSL=false&serverTimezone=UTC", "root", "admin")
                .globalConfig(builder -> {
                    builder.author("tanjiaming99") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .commentDate("yyyy-MM-dd HH:mm:ss")
                            .outputDir("F:\\easy_blog\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.tanjiaming99") // 设置父包名
//                            .moduleName("system") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "F:\\easy_blog\\src\\main\\resources\\mapper\\xml")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables)  // 设置需要生成的表名
                            .addTablePrefix("tb_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
