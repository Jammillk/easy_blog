package com.tanjiaming99.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 *
 * </p>
 *
 * @author tanjiaming99
 * @since 2021-11-12 10:28:40
 */
@TableName("tb_blog_category")
@ApiModel(value = "BlogCategory对象", description = "")
public class BlogCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("分类表主键")
    @TableId(value = "category_id", type = IdType.AUTO)
    private Integer categoryId;

    @ApiModelProperty("分类的名称")
    private String categoryName;

    @ApiModelProperty("分类的图标")
    private String categoryIcon;

    @ApiModelProperty("分类的排序值 被使用的越多数值越大")
    private Integer categoryRank;

    @ApiModelProperty("是否删除 0=否 1=是")
    @TableLogic
    private Integer isDeleted;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public String getCategoryIcon() {
        return categoryIcon;
    }

    public void setCategoryIcon(String categoryIcon) {
        this.categoryIcon = categoryIcon;
    }
    public Integer getCategoryRank() {
        return categoryRank;
    }

    public void setCategoryRank(Integer categoryRank) {
        this.categoryRank = categoryRank;
    }
    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BlogCategory{" +
            "categoryId=" + categoryId +
            ", categoryName=" + categoryName +
            ", categoryIcon=" + categoryIcon +
            ", categoryRank=" + categoryRank +
            ", isDeleted=" + isDeleted +
            ", createTime=" + createTime +
        "}";
    }
}
