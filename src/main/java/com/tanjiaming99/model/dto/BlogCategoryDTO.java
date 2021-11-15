package com.tanjiaming99.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author tanjiaming99
 * @version 1.0
 * @date 2021/11/15 9:44
 * @description
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@ApiModel(description = "博客分类请求参数")
public class BlogCategoryDTO implements Serializable {
    @ApiModelProperty("分类的名称")
    private String categoryName;

}
