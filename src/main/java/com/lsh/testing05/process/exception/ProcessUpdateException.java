package com.lsh.testing05.process.exception;

@SuppressWarnings("serial")
public class ProcessUpdateException extends RuntimeException {
	public ProcessUpdateException() {
		super("Error Code = 010");
	}
}
