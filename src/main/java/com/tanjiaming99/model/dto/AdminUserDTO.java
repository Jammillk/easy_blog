package com.tanjiaming99.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author tanjiaming99
 * @version 1.0
 * @date 2021/11/12 16:19
 * @description
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@ApiModel(description = "用户登录请求参数")
public class AdminUserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("管理员登陆名称")
    @NotBlank(message = "登陆名不能为空")
    private String loginUserName;

    @ApiModelProperty("管理员登陆密码")
    @NotBlank(message = "登陆密码不能为空")
    private String loginPassword;

    @ApiModelProperty("登陆验证码")
    @NotBlank(message = "验证码不能为空")
    private String verifyCode;


}
