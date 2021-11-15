/*设置一些值为null，原表全是not null，影响mybatis plus的一些自动填充功能*/
alter table tb_blog_category modify category_icon varchar(50) null COMMENT '分类的图标';
alter table tb_blog_category modify category_rank int null default 0 COMMENT '分类的排序值 被使用的越多数值越大';


