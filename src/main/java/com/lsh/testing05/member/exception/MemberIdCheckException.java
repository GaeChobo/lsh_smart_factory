package com.lsh.testing05.member.exception;

@SuppressWarnings("serial")
public class MemberIdCheckException extends RuntimeException{
	public MemberIdCheckException() {
		super("Error Code = 003");
	}
}
