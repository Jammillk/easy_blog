package com.tanjiaming99.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * @Author tanjiaming99.com
 * @Date 2021/11/14 12:45
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "登录返回对象")
public class LoginVO implements Serializable {
    @ApiModelProperty("token令牌")
    private String token;

    @ApiModelProperty("token头信息")
    private String tokenHead;
}
