package com.jing.config.web.exception;

public class ForeignKeyException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	/**
	 * @Fields message : 异常信息 
	 */
	private String message;

	public ForeignKeyException() {
		super();
	}
	/***
	 * 带message参数的构造函数
	 */
	public ForeignKeyException(String message) {
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
