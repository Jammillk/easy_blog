package com.tanjiaming99.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * <p>
 *
 * </p>
 *
 * @author tanjiaming99
 * @since 2021-11-12 10:28:40
 */
@TableName("tb_link")
@ApiModel(value = "Link对象", description = "")
public class Link implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("友链表主键id")
    @TableId(value = "link_id", type = IdType.AUTO)
    private Integer linkId;

    @ApiModelProperty("友链类别 0-友链 1-推荐 2-个人网站")
    @Range(min = 0, max = 2, message = "请根据文档定义选择友链类别")
    private Integer linkType;

    @ApiModelProperty("网站名称")
    @NotBlank
    private String linkName;

    @ApiModelProperty("网站链接")
    @URL(message = "请输入正确的网站链接")
    private String linkUrl;

    @ApiModelProperty("网站描述")
    private String linkDescription;

    @ApiModelProperty("用于列表排序")
    private Integer linkRank;

    @ApiModelProperty("是否删除 0-未删除 1-已删除")
    @TableLogic
    private Integer isDeleted;

    @ApiModelProperty(value = "添加时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }
    public Integer getLinkType() {
        return linkType;
    }

    public void setLinkType(Integer linkType) {
        this.linkType = linkType;
    }
    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }
    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }
    public String getLinkDescription() {
        return linkDescription;
    }

    public void setLinkDescription(String linkDescription) {
        this.linkDescription = linkDescription;
    }
    public Integer getLinkRank() {
        return linkRank;
    }

    public void setLinkRank(Integer linkRank) {
        this.linkRank = linkRank;
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
        return "Link{" +
            "linkId=" + linkId +
            ", linkType=" + linkType +
            ", linkName=" + linkName +
            ", linkUrl=" + linkUrl +
            ", linkDescription=" + linkDescription +
            ", linkRank=" + linkRank +
            ", isDeleted=" + isDeleted +
            ", createTime=" + createTime +
        "}";
    }
}
