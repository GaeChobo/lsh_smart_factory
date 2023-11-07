package com.lsh.testing05.process.exception;

@SuppressWarnings("serial")
public class ProcessRegisterException extends RuntimeException {
	public ProcessRegisterException() {
		super("Error Code = 008");
	}
}
