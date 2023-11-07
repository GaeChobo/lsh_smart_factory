package com.lsh.testing05.member.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.lsh.testing05.member.dao.MemberDAO;
import com.lsh.testing05.member.vo.MemberVO;


@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	MemberDAO dao;
	
	@Override
	public int FindMemberID(MemberVO vo) throws Exception {
		
		int result = dao.FindMemberID(vo);
		return result;
	}
	
	@Override
	public List<MemberVO> LoginReturntest(MemberVO vo) throws Exception {
		
		List<MemberVO> memberlist = dao.LoginReturntest(vo);
		return memberlist;
	}
	
	@Override
	public List<MemberVO> SelectWorkerPropertyMain(MemberVO vo) throws Exception {
		
		List<MemberVO> memberlist = dao.SelectWorkerPropertyMain(vo);
		return memberlist;

	}
	
	@Override
	public List<MemberVO> CreateDayFind(MemberVO vo) throws Exception {
		
		return dao.CreateDayFind(vo);
		
	}
	
	public String FindImgDirectory(MemberVO vo) throws Exception {
		
		String result = dao.FindImgDirectory(vo);
		return result;
	}
	
	@Override
	public void WorkerImgDelete(MemberVO vo) throws Exception {
		
		dao.WorkerImgDelete(vo);
	}
	
	@Override
	public void RegisterMember(MemberVO vo) throws Exception {
		
		dao.RegisterMember(vo);
	}
	
	@Override
	public void Registerworkerproperty(MemberVO vo) throws Exception {
		
		dao.Registerworkerproperty(vo);
	}
	
	@Override
	public void Updateworkerproperty(MemberVO vo) throws Exception {
		
		dao.Updateworkerproperty(vo);
	}
	
	@Override
	public void DeleteWorkerProperty(MemberVO vo) throws Exception {
		
		dao.DeleteWorkerProperty(vo);
	}
	
	@Override
	public int SelectDivisionId(MemberVO vo) throws Exception {
		
		int result = dao.SelectDivisionId(vo);
		return result;
	}
	
	public List<MemberVO> SelectWorkerProperty(MemberVO vo) throws Exception {
		
		List<MemberVO> result = dao.SelectWorkerProperty(vo);
		return result;
	}
	
	@Override
	public List<MemberVO> AllselectMember() throws Exception {
		
		return dao.AllselectMember();
	}
	
	@Override
	public List<MemberVO> WorketMemberSelect(MemberVO vo) throws Exception {
		
		return dao.WorketMemberSelect(vo);
	}
	
	@Override
	public List<MemberVO> AdminMemberSelect(MemberVO vo) throws Exception {
		
		return dao.AdminMemberSelect(vo);
	}
	
	@Override
	public MemberVO LoginReturn(MemberVO vo) throws Exception {
		
		return dao.LoginReturn(vo);
	}
	
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		
		return dao.login(vo);
	}
	
	@Override
	public void WorkerImgUpdate(MemberVO vo) throws Exception {
		dao.WorkerImgUpdate(vo);
	}
	
	@Override
	public void UpdateMember(MemberVO vo) throws Exception {
		dao.UpdateMember(vo);
	}
	
	@Override
	public void DeleteMember(MemberVO vo) throws Exception {
		dao.DeleteMember(vo);
	}
	
	public Integer PassFinding01(MemberVO vo) throws Exception {
		
		Integer result = dao.PassFinding01(vo);
		return result;
	}

	public Integer PassFinding02(MemberVO vo) throws Exception {
		
		Integer result = dao.PassFinding02(vo);
		return result;
	}

	
	@Override
	public int PassChkMember(MemberVO vo) throws Exception {
		int result = dao.PassChkMember(vo);
		return result;
	}
	
	@Override
	public int IdChkMember(MemberVO vo) throws Exception {
		int result = dao.IdChkMember(vo);
		return result;
	}
	
	@Override
	public MemberVO PassFinding(MemberVO vo) throws Exception{
		
		return dao.PassFinding(vo);
	}
	
	@Override
	public int CheckMember(MemberVO vo) throws Exception {
		int result = dao.CheckMember(vo);
		return result;
	}
}
