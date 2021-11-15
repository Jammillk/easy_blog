package com.tanjiaming99.model.dto;

import com.tanjiaming99.model.entity.BlogTag;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author tanjiaming99
 * @version 1.0
 * @date 2021/11/15 15:19
 * @description
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@ApiModel(description = "博客标签请求参数")
public class BlogTagDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("博客表主键id")
    private Long blogId;

    @ApiModelProperty("新增标签集合")
    private List<BlogTag> tags;
}
