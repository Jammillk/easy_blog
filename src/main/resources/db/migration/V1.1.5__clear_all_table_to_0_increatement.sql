-- ----------------------------
-- Table structure for tb_admin_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin_user`;
CREATE TABLE `tb_admin_user`
(
    `admin_user_id`   int(0)                                                 NOT NULL AUTO_INCREMENT COMMENT '管理员id',
    `login_user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员登陆名称',
    `login_password`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员登陆密码',
    `nick_name`       varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员显示昵称',
    `locked`          tinyint(0)                                             NULL DEFAULT 0 COMMENT '是否锁定 0未锁定 1已锁定无法登陆',
    PRIMARY KEY (`admin_user_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_blog
-- ----------------------------
DROP TABLE IF EXISTS `tb_blog`;
CREATE TABLE `tb_blog`
(
    `blog_id`            bigint(0)                                               NOT NULL AUTO_INCREMENT COMMENT '博客表主键id',
    `blog_title`         varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博客标题',
    `blog_sub_url`       varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博客自定义路径url',
    `blog_cover_image`   varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博客封面图',
    `blog_content`       mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci   NOT NULL COMMENT '博客内容',
    `blog_category_id`   int(0)                                                  NOT NULL COMMENT '博客分类id',
    `blog_category_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '博客分类(冗余字段)',
    `blog_tags`          varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博客标签',
    `blog_status`        tinyint(0)                                              NOT NULL DEFAULT 0 COMMENT '0-草稿 1-发布',
    `blog_views`         bigint(0)                                               NOT NULL DEFAULT 0 COMMENT '阅读量',
    `enable_comment`     tinyint(0)                                              NOT NULL DEFAULT 0 COMMENT '0-允许评论 1-不允许评论',
    `is_deleted`         tinyint(0)                                              NOT NULL DEFAULT 0 COMMENT '是否删除 0=否 1=是',
    `create_time`        datetime(0)                                             NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
    `update_time`        datetime(0)                                             NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`blog_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_blog_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_blog_category`;
CREATE TABLE `tb_blog_category`
(
    `category_id`   int(0)                                                 NOT NULL AUTO_INCREMENT COMMENT '分类表主键',
    `category_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类的名称',
    `category_icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类的图标',
    `category_rank` int(0)                                                 NOT NULL DEFAULT 1 COMMENT '分类的排序值 被使用的越多数值越大',
    `is_deleted`    tinyint(0)                                             NOT NULL DEFAULT 0 COMMENT '是否删除 0=否 1=是',
    `create_time`   datetime(0)                                            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_blog_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_blog_comment`;
CREATE TABLE `tb_blog_comment`
(
    `comment_id`          bigint(0)                                               NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `blog_id`             bigint(0)                                               NOT NULL DEFAULT 0 COMMENT '关联的blog主键',
    `commentator`         varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL DEFAULT '' COMMENT '评论者名称',
    `email`               varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '评论人的邮箱',
    `website_url`         varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL DEFAULT '' COMMENT '网址',
    `comment_body`        varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '评论内容',
    `comment_create_time` datetime(0)                                             NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论提交时间',
    `commentator_ip`      varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL DEFAULT '' COMMENT '评论时的ip地址',
    `reply_body`          varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '回复内容',
    `reply_create_time`   datetime(0)                                             NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '回复时间',
    `comment_status`      tinyint(0)                                              NOT NULL DEFAULT 0 COMMENT '是否审核通过 0-未审核 1-审核通过',
    `is_deleted`          tinyint(0)                                              NULL     DEFAULT 0 COMMENT '是否删除 0-未删除 1-已删除',
    PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_blog_tag
-- ----------------------------
DROP TABLE IF EXISTS `tb_blog_tag`;
CREATE TABLE `tb_blog_tag`
(
    `tag_id`      int(0)                                                  NOT NULL AUTO_INCREMENT COMMENT '标签表主键id',
    `tag_name`    varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签名称',
    `is_deleted`  tinyint(0)                                              NOT NULL DEFAULT 0 COMMENT '是否删除 0=否 1=是',
    `create_time` datetime(0)                                             NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`tag_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_blog_tag_relation
-- ----------------------------
DROP TABLE IF EXISTS `tb_blog_tag_relation`;
CREATE TABLE `tb_blog_tag_relation`
(
    `relation_id` bigint(0)   NOT NULL AUTO_INCREMENT COMMENT '关系表id',
    `blog_id`     bigint(0)   NOT NULL COMMENT '博客id',
    `tag_id`      int(0)      NOT NULL COMMENT '标签id',
    `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
    PRIMARY KEY (`relation_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_config
-- ----------------------------
DROP TABLE IF EXISTS `tb_config`;
CREATE TABLE `tb_config`
(
    `config_name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '配置项的名称',
    `config_value` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '配置项的值',
    `create_time`  datetime(0)                                             NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`  datetime(0)                                             NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`config_name`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_link
-- ----------------------------
DROP TABLE IF EXISTS `tb_link`;
CREATE TABLE `tb_link`
(
    `link_id`          int(0)                                                  NOT NULL AUTO_INCREMENT COMMENT '友链表主键id',
    `link_type`        tinyint(0)                                              NOT NULL DEFAULT 0 COMMENT '友链类别 0-友链 1-推荐 2-个人网站',
    `link_name`        varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '网站名称',
    `link_url`         varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '网站链接',
    `link_description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '网站描述',
    `link_rank`        int(0)                                                  NOT NULL DEFAULT 0 COMMENT '用于列表排序',
    `is_deleted`       tinyint(0)                                              NOT NULL DEFAULT 0 COMMENT '是否删除 0-未删除 1-已删除',
    `create_time`      datetime(0)                                             NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
    PRIMARY KEY (`link_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

# SET FOREIGN_KEY_CHECKS = 1;

/*设置一些值为null，原表全是not null，影响mybatis plus的一些自动填充功能*/
alter table tb_blog modify create_time datetime null COMMENT '添加时间';
alter table tb_blog modify is_deleted tinyint(4) null default 0 COMMENT '是否删除 0=否 1=是';
alter table tb_blog modify blog_sub_url varchar(200) null  COMMENT '博客自定义路径url';
alter table tb_blog modify blog_cover_image varchar(200) null COMMENT '博客封面图';
alter table tb_blog modify blog_views bigint(20) null default 0 COMMENT '阅读量';

/*删掉ip那一列*/
alter table tb_blog_comment
    drop column commentator_ip;

/*设置一些值为null，原表全是not null，影响mybatis plus的一些自动填充功能*/
alter table tb_blog_category modify category_icon varchar(50) null COMMENT '分类的图标';
alter table tb_blog_category modify category_rank int null default 0 COMMENT '分类的排序值 被使用的越多数值越大';

alter table tb_config
    drop primary key;
alter table tb_config
    add config_id bigint not null primary key auto_increment first ;

alter table tb_blog
    drop column blog_tags;
