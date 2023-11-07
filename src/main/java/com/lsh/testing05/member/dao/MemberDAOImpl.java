package com.lsh.testing05.member.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.lsh.testing05.member.vo.MemberVO;


@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession sqlsession;
	
	private static final String namespace = "mapper.memberMapper";
	
	@Override
	public int FindMemberID(MemberVO vo) throws Exception {
		
		int result = sqlsession.selectOne(namespace+".FindMemberID", vo);
		return result;

	}
	
	@Override
	public List<MemberVO> LoginReturntest(MemberVO vo) throws Exception {
		
		List<MemberVO> memberlist = sqlsession.selectList(namespace+".LoginReturntest", vo);
		return memberlist;
	}

	
	@Override
	public List<MemberVO> SelectWorkerPropertyMain(MemberVO vo) throws Exception {
		
		List<MemberVO> memberlist = sqlsession.selectList(namespace+".SelectWorkerPropertyMain", vo);
		return memberlist;
	}
	
	@Override
	 public List<MemberVO> CreateDayFind(MemberVO vo) throws Exception {
		
		List<MemberVO> memberlist = sqlsession.selectList(namespace+".CreateDayFind", vo);
		return memberlist;
	}
	
	@Override 
	public void RegisterMember(MemberVO vo) throws Exception  {
		
		sqlsession.insert(namespace+".RegisterMember", vo);
	}
	
	@Override
	public void Registerworkerproperty(MemberVO vo) throws Exception {
		
		sqlsession.insert(namespace+".Registerworkerproperty", vo);
	}
	
	@Override
	public void DeleteWorkerProperty(MemberVO vo) throws Exception {
		
		sqlsession.delete(namespace+".DeleteWorkerProperty", vo);
	}
	
	//작업자 속성 조건 조회
	public int SelectDivisionId(MemberVO vo) throws Exception {
		
		int result = sqlsession.selectOne(namespace+".SelectDivisionId", vo);
		return result;
	}
	
	@Override
	public void Updateworkerproperty(MemberVO vo) throws Exception {
		
		sqlsession.update(namespace+".Updateworkerproperty", vo);
	}
	
	@Override
	public List<MemberVO> SelectWorkerProperty(MemberVO vo) throws Exception {
		
		List<MemberVO> result = sqlsession.selectList(namespace+".SelectWorkerProperty", vo);
		return result;
	}
	
	@Override
	 public String FindImgDirectory(MemberVO vo) throws Exception {
		String result = sqlsession.selectOne(namespace+".FindImgDirectory", vo);
		return result;
	}
	
	@Override
	public List<MemberVO> AllselectMember() {
		List<MemberVO> memberlist = sqlsession.selectList(namespace+".AllselectMember");
		return memberlist;
	}
	
	@Override
	public List<MemberVO> WorketMemberSelect(MemberVO vo) throws Exception {
		List<MemberVO> memberlist = sqlsession.selectList(namespace+".WorketMemberSelect");
		return memberlist;
	}
	
	@Override
	public List<MemberVO> AdminMemberSelect(MemberVO vo) throws Exception {
		List<MemberVO> memberlist = sqlsession.selectList(namespace+".AdminMemberSelect");
		return memberlist;
	}
	
	@Override
	public MemberVO LoginReturn(MemberVO vo) throws Exception {
		
		MemberVO memberlist = sqlsession.selectOne(namespace+".LoginReturn", vo);
		memberlist.setLogin_fail(1);
		return memberlist;
	}
	
	
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		
		return sqlsession.selectOne(namespace+".LoginMember", vo);
	}
	
	@Override
	 public void WorkerImgUpdate(MemberVO vo) throws Exception {
		
		sqlsession.update(namespace+".WorkerImgUpdate", vo);
	}
	
	@Override
	public void UpdateMember(MemberVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateMember", vo);
		
	}
	
	@Override
	public void DeleteMember(MemberVO vo) throws Exception {
		
		sqlsession.delete(namespace+".DeleteMember", vo);
	}
	
	@Override
	public void WorkerImgDelete(MemberVO vo) throws Exception {
		
		sqlsession.update(namespace+".WorkerImgDelete", vo);
	}
	
	@Override
	public Integer PassFinding01(MemberVO vo) throws Exception {
		
		Integer result = sqlsession.selectOne(namespace+".PassFinding01",vo);
		return result;
		
	}
	
	@Override
	public Integer PassFinding02(MemberVO vo) throws Exception {
		
		Integer result = sqlsession.selectOne(namespace+".PassFinding02",vo);
		return result;
	}
	
	@Override
	public int PassChkMember(MemberVO vo) throws Exception {
		
		int result = sqlsession.selectOne(namespace+".PassChkMember", vo);
		return result;
		
	}
	@Override
	public int IdChkMember(MemberVO vo) throws Exception {
		int result = sqlsession.selectOne(namespace+".IdChkMember", vo);
		return result;
	}
	
	@Override
	public MemberVO PassFinding(MemberVO vo) throws Exception {
		
		return sqlsession.selectOne(namespace+".PassFinding", vo);
	}
	
	@Override
	public int CheckMember(MemberVO vo) throws Exception {
		int result = sqlsession.selectOne(namespace+".CheckMember", vo);
		return result;
	}
	

}
