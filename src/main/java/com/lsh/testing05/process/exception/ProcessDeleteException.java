package com.lsh.testing05.process.exception;

@SuppressWarnings("serial")
public class ProcessDeleteException extends RuntimeException{
	public ProcessDeleteException() {
		super("Error Code = 011");
	}
}
