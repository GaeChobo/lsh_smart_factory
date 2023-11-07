package com.lsh.testing05.member.dao;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.lsh.testing05.member.vo.MemberVO;


public interface MemberDAO { 
	
	public int FindMemberID(MemberVO vo) throws Exception;
	
	public Integer PassFinding01(MemberVO vo) throws Exception;

	public Integer PassFinding02(MemberVO vo) throws Exception;
	
	//로그인 테스트
	public List<MemberVO> LoginReturntest(MemberVO vo) throws Exception;
	
	//메인카테고리에 맞춰서 작업자 조회
	public List<MemberVO> SelectWorkerPropertyMain(MemberVO vo) throws Exception;
	//회원가입
	public void RegisterMember(MemberVO vo) throws Exception;
	
	//작업자 설비 공정 속성 설정
	public void Registerworkerproperty(MemberVO vo) throws Exception;
	
	//작업자 속성 수정
	public void Updateworkerproperty(MemberVO vo) throws Exception;
	
	//작업자 속성 조회
	public List<MemberVO> SelectWorkerProperty(MemberVO vo) throws Exception;
	
	//작업자 속성 삭제
	public void DeleteWorkerProperty(MemberVO vo) throws Exception;
	
	//작업자 속성 조건 조회
	public int SelectDivisionId(MemberVO vo) throws Exception;
	
	//회원 전체 조회
	public List<MemberVO> AllselectMember() throws Exception;
	
	//작업자 조회
	public List<MemberVO> WorketMemberSelect(MemberVO vo) throws Exception;
	
	//관리자 조회
	public List<MemberVO> AdminMemberSelect(MemberVO vo) throws Exception;
	
	//test용
	public List<MemberVO> CreateDayFind(MemberVO vo) throws Exception;
	
	//로그인 리턴값
	public MemberVO LoginReturn(MemberVO vo) throws Exception;
	
	 //이미지 디렉토리 찾기
	public String FindImgDirectory(MemberVO vo) throws Exception;
	 
	//이미지 삭제
	public void WorkerImgDelete(MemberVO vo) throws Exception;
	 
	//회원 서명이미지
	public void WorkerImgUpdate(MemberVO vo) throws Exception;
	 
	//회원 로그인
	public MemberVO login(MemberVO vo) throws Exception;
	
	//회원 정보 수정
	public void UpdateMember(MemberVO vo) throws Exception; 
	
	//회원 탈퇴
	public void DeleteMember(MemberVO vo) throws Exception;
	
	//패스워드 체크
	public int PassChkMember(MemberVO vo) throws Exception;
	
	//회원가입 중복 체크
	public int IdChkMember(MemberVO vo) throws Exception;
	
	//비밀번호 찾기
	public MemberVO PassFinding(MemberVO vo) throws Exception;
	
	//멤버 리스트 체크
	public int CheckMember(MemberVO vo) throws Exception;
}
