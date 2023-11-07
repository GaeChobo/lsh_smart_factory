package com.lsh.testing05.process.exception;

@SuppressWarnings("serial")
public class ProcessSelectException extends RuntimeException {
	public ProcessSelectException() {
		super("Error Code = 009");
	}
}
