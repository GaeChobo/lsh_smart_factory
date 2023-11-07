package com.lsh.testing05.member.exception;

@SuppressWarnings("serial")
public class MemberLoginException extends RuntimeException {
	public MemberLoginException() {
		super("Error Code = 002");
	}
}
