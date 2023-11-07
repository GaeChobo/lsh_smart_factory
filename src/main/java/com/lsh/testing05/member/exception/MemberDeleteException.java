package com.lsh.testing05.member.exception;

@SuppressWarnings("serial")
public class MemberDeleteException extends RuntimeException {
	public MemberDeleteException() {
		super("Error code = 007");
	}
}
