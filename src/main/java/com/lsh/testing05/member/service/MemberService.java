package com.lsh.testing05.member.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.lsh.testing05.member.vo.MemberVO;


public interface MemberService {
	
	public int FindMemberID(MemberVO vo) throws Exception;
	
	public Integer PassFinding01(MemberVO vo) throws Exception;

	public Integer PassFinding02(MemberVO vo) throws Exception;
	
	public List<MemberVO> LoginReturntest(MemberVO vo) throws Exception;
	
	public List<MemberVO> SelectWorkerPropertyMain(MemberVO vo) throws Exception;
	
	public List<MemberVO> CreateDayFind(MemberVO vo) throws Exception;

	public void RegisterMember(MemberVO vo) throws Exception;
	
	public void Registerworkerproperty(MemberVO vo) throws Exception;
	
	public void Updateworkerproperty(MemberVO vo) throws Exception;
	
	public List<MemberVO> SelectWorkerProperty(MemberVO vo) throws Exception;

	public void DeleteWorkerProperty(MemberVO vo) throws Exception;
	
	public int SelectDivisionId(MemberVO vo) throws Exception;
	
	public String FindImgDirectory(MemberVO vo) throws Exception;
	 
	public List<MemberVO> AllselectMember() throws Exception;
	
	public List<MemberVO> WorketMemberSelect(MemberVO vo) throws Exception;
	
	public List<MemberVO> AdminMemberSelect(MemberVO vo) throws Exception;
	
	public MemberVO LoginReturn(MemberVO vo) throws Exception;
	
	public MemberVO login(MemberVO vo) throws Exception;
	
	public void WorkerImgUpdate(MemberVO vo) throws Exception;
	
	public void WorkerImgDelete(MemberVO vo) throws Exception;
	
	public void UpdateMember(MemberVO vo) throws Exception;
	
	public void DeleteMember(MemberVO vo) throws Exception;

	public int PassChkMember(MemberVO vo) throws Exception;
	
	public int IdChkMember(MemberVO vo) throws Exception;
	
	public MemberVO PassFinding(MemberVO vo) throws Exception;
	
	public int CheckMember(MemberVO vo) throws Exception;
}
