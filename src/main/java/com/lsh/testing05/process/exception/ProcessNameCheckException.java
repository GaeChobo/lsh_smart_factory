package com.lsh.testing05.process.exception;

@SuppressWarnings("serial")
public class ProcessNameCheckException extends RuntimeException{
	public ProcessNameCheckException() {
		super("Error Code = 012");
	}
}
