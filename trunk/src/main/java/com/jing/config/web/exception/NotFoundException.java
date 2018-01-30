package com.jing.config.web.exception;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	/**
	 * @Fields message : 异常信息 
	 */
	private String message;

	public NotFoundException() {
		super();
	}
	/***
	 * 带message参数的构造函数
	 */
	public NotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
