package com.lsh.testing05.member.exception;

@SuppressWarnings("serial")
public class MemberPwdCheckException extends RuntimeException {
	public MemberPwdCheckException() {
		super("Error Code = 004");
	}

}
