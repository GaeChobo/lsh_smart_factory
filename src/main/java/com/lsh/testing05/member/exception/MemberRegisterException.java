package com.lsh.testing05.member.exception;

@SuppressWarnings("serial")
public class MemberRegisterException extends RuntimeException{
	public MemberRegisterException() {
		super("Error Code = 001");
	}
}
