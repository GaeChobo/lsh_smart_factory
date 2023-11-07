package com.lsh.testing05.member.exception;

@SuppressWarnings("serial")
public class MemberSelectException extends RuntimeException{
	public MemberSelectException() {
		super("Error Code = 005");
	}
}
