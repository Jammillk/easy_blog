package com.tanjiaming99.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * @Author tanjiaming99.com
 * @Date 2021/11/14 20:35
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "博客评论分页查询返回对象")
public class CommentVO {
    @ApiModelProperty("关联的blog主键")
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

    @ApiModelProperty("评论提交时间")
    private LocalDateTime commentCreateTime;

    @ApiModelProperty("回复内容")
    private String replyBody;

    @ApiModelProperty("是否审核通过 0-未审核 1-审核通过")
    private Integer commentStatus;
}
