package com.tanjiaming99.constant;

/**
 * @description: 返回标志常量类
 */
public class ResponseConst {

	private ResponseConst() {
	}

	/**
	 * 请求成功标志码
	 */
	public static final int SUCCESS = 1;
	/**
	 * 请求失败标志码
	 */
	public static final int FAIL = 0;
	/**
	 * 请求成功默认返回消息
	 */
	public static final String SUCCESS_MSG = "操作成功";
	/**
	 * 请求失败默认返回消息
	 */
	public static final String FAIL_MSG = "操作失败，请联系管理员";

}
