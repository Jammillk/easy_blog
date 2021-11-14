package com.tanjiaming99.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @Author tanjiaming99.com
 * @Date 2021/11/14 20:21
 **/
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@ApiModel(description = "修改博客评论状态参数")
public class CommentStatusDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    private Long commentId;

    @ApiModelProperty("是否审核通过 0-未审核 1-审核通过")
    @Size(min = 0, max = 1, message = "审核状态数值只能为0或1")
    private Integer commentStatus;
}
