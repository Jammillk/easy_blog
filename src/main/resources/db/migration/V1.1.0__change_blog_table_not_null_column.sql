/*设置一些值为null，原表全是not null，影响mybatis plus的一些自动填充功能*/
alter table tb_blog modify create_time datetime null COMMENT '添加时间';
alter table tb_blog modify is_deleted tinyint(4) null default 0 COMMENT '是否删除 0=否 1=是';
alter table tb_blog modify blog_sub_url varchar(200) null  COMMENT '博客自定义路径url';
alter table tb_blog modify blog_cover_image varchar(200) null COMMENT '博客封面图';
alter table tb_blog modify blog_views bigint(20) null default 0 COMMENT '阅读量';


