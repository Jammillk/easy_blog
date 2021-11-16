package com.tanjiaming99.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author tanjiaming99.com
 * @Date 2021/11/16 17:08
 **/

@ToString
@Data
@ApiModel(description = "邮件服务相关参数")
public class Email {

    @ApiModelProperty("发送者")
    private String from;

    @ApiModelProperty("接收者")
    private  String to;

    @ApiModelProperty("邮件内容")
    private String context;

    @ApiModelProperty("标题")
    private String subject;

    @ApiModelProperty("邮件类型。0为")
    private Integer mailType;

}
