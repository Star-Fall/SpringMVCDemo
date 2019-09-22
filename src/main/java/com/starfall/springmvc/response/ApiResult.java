package com.starfall.springmvc.response;

/**
 * @author StarFall
 * @project SpringMVCDemo
 * @package com.starfall.springmvc.response
 * @className ApiResult
 * @date 2019/8/17 16:43
 * @description ApiResult
 */
public enum ApiResult {
	/**
	 * 响应成功
	 */
	SUCCESS(200, "响应成功"),
	/**
	 * 系统错误
	 */
	ERROR(400, "系统错误");

	private final int code;

	private final String msg;

	private ApiResult(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	/**
	 * 获取返回结果Map
	 *
	 * @return ApiResultMap
	 */
	public ApiResultMap<String, Object> getMap() {
		return new ApiResultMap<String, Object>().add("code", this.getCode()).add("msg", this.getMsg());
	}

	/**
	 * 获取返回错误结果Map
	 * 
	 * @param errMsg
	 *            错误信息
	 * @return 结果Map
	 */
	public ApiResultMap<String, Object> getMap(String errMsg) {
		return new ApiResultMap<String, Object>().add("code", this.getCode()).add("msg", this.getMsg()).add("errMsg",
				errMsg);
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
