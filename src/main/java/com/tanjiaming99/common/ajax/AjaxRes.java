package com.tanjiaming99.common.ajax;

import com.tanjiaming99.constant.ResponseConst;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @description: Ajax封装类
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "返回数据实体", description = "返回数据")
public class AjaxRes<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 返回码值,默认值ResponseConst.SUCCESS
	 */
	@ApiModelProperty(value = "返回码值，0：失败，1：成功", required = true)
	private int res = ResponseConst.SUCCESS;

	/**
	 * 返回消息
	 */
	@ApiModelProperty(value = "返回消息")
	private String resMsg;

	/**
	 * 返回对象
	 */
	@ApiModelProperty(value = "返回对象")
	private T result;

	/**
	 * 错误堆栈
	 */
	@ApiModelProperty(value = "错误堆栈")
	private String stackTrace;

	/**
	 * 返回成功值
	 *
	 * @param obj 设置对象
	 */
	public static <T> AjaxRes<T> success(T obj) {
		return success(obj, ResponseConst.SUCCESS_MSG);
	}

	/**
	 * 返回成功
	 *
	 * @return
	 */
	public static <T> AjaxRes<T> success() {
		return success(null, ResponseConst.SUCCESS_MSG);
	}

	/**
	 * 返回成功值
	 *
	 * @param resMsg 返回码值解析
	 */
	public static <T> AjaxRes<T> successMsg(String resMsg) {
		return success(null, resMsg);
	}

	/**
	 * 返回成功值
	 *
	 * @param resMsg 返回码值解析
	 */
	public static <T> AjaxRes<T> success(T obj, String resMsg) {
		AjaxRes<T> ajaxRes = new AjaxRes<>();
		ajaxRes.setResMsg(resMsg);
		ajaxRes.setResult(obj);
		ajaxRes.setRes(ResponseConst.SUCCESS);
		return ajaxRes;
	}

	/**
	 * 返回失败值
	 */
	public static <T> AjaxRes<T> fail() {
		return fail(null, ResponseConst.FAIL_MSG);
	}

	/**
	 * 返回失败值
	 *
	 * @param obj 设置对象
	 */
	public static <T> AjaxRes<T> fail(T obj) {
		return fail(obj, ResponseConst.FAIL_MSG);
	}

	/**
	 * 返回失败值
	 *
	 * @param resMsg 返回码值解析
	 */
	public static <T> AjaxRes<T> failMsg(String resMsg) {
		return fail(null, resMsg);
	}

	/**
	 * 返回失败值
	 *
	 * @param resMsg 返回码值解析
	 */
	public static <T> AjaxRes<T> fail(T obj, String resMsg) {
		AjaxRes<T> ajaxRes = new AjaxRes<>();
		ajaxRes.setResMsg(resMsg);
		ajaxRes.setResult(obj);
		ajaxRes.setRes(ResponseConst.FAIL);
		return ajaxRes;
	}

}
