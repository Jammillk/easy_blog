package com.tanjiaming99.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author tanjiaming99.com
 * @Date 2021/11/14 19:31
 **/
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@ApiModel(description = "博客评论请求参数")
public class BlogCommentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("关联的blog主键")
    @NotNull(message = "关联博文不能为空")
    private Long blogId;

    @ApiModelProperty("评论者名称")
    private String commentator;

    @ApiModelProperty("评论人的邮箱")
    @NotBlank(message = "邮箱不能为空")
    private String email;

    @ApiModelProperty("网址")
    private String websiteUrl;

    @ApiModelProperty("评论内容")
    @NotBlank(message = "评论内容不能为空")
    private String commentBody;

    @ApiModelProperty("验证码")
    private String kaptcha;

}
