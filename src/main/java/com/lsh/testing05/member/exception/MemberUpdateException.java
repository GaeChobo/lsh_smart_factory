package com.lsh.testing05.member.exception;

@SuppressWarnings("serial")
public class MemberUpdateException extends RuntimeException {
	public MemberUpdateException() {
		super("Error Code = 006");
	}
}
