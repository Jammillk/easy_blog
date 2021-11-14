package com.tanjiaming99.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author tanjiaming99.com
 * @Date 2021/11/14 20:11
 **/
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@ApiModel(description = "博客评论回复参数")
public class BlogReplyDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    private Long commentId;

    @ApiModelProperty("回复内容")
    private String replyBody;

}
