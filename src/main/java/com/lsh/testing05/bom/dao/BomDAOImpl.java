package com.lsh.testing05.bom.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.lsh.testing05.bom.vo.BomVO;

@Repository
public class BomDAOImpl implements BomDAO {

	@Inject
	private SqlSession sqlsession;
	
	public static final String namespace = "mapper.bomMapper";
	
	
	@Override
	public List<BomVO> SearchJobNumBomDetail(BomVO vo) throws Exception {
		
		List<BomVO> Bomlist = sqlsession.selectList(namespace+".SearchJobNumBomDetail", vo);
		return Bomlist;
	}
	
	@Override
	public List<BomVO> FindBomJobNum(BomVO vo) throws Exception {
		
		List<BomVO> Bomlist = sqlsession.selectList(namespace+".FindBomJobNum", vo);
		return Bomlist;
	}
	
	@Override
	public List<BomVO> SearchBomDetail(BomVO vo) throws Exception {
		
		List<BomVO> Bomlist = sqlsession.selectList(namespace+".SearchBomDetail", vo);
		return Bomlist;
	}
	
	@Override
	public List<BomVO> ViewBomDetailA(BomVO vo) throws Exception {
		
		List<BomVO> Bomlist = sqlsession.selectList(namespace+".ViewBomDetailA", vo);
		return Bomlist;
	}
	
	@Override
	public int BomNullChk(BomVO vo) throws Exception {
		
		int result = sqlsession.selectOne(namespace+".BomNullChk", vo);
		return result;
		
	}
	
	@Override
	public int BomDelChk(BomVO vo) throws Exception {
		
		int result = sqlsession.selectOne(namespace+".BomDelChk", vo);
		return result;
	}
	
	@Override
	public void RegisterBomlist(BomVO vo) throws Exception {
		sqlsession.insert(namespace+".RegisterBomlist", vo);
	}
	
	@Override
	public void UploadBomFile(BomVO vo) throws Exception {
		sqlsession.insert(namespace+".UploadBomFile", vo);
	}
	
	@Override
	public void RegisterBomDetailA(BomVO vo) throws Exception {
		sqlsession.insert(namespace+".RegisterBomDetailA", vo);
	}
	
	@Override
	public void RegisterBomDetailB(BomVO vo) throws Exception {
		sqlsession.insert(namespace+".RegisterBomDetailB", vo);
	}
	
	@Override
	public List<BomVO> ViewBomList(BomVO vo) throws Exception {
		
		List<BomVO> Bomlist = sqlsession.selectList(namespace+".ViewBomList");
		return Bomlist;
	}
	
	@Override
	public List<BomVO> ViewBomDetail(BomVO vo) throws Exception {
		
		List<BomVO> Bomlist = sqlsession.selectList(namespace+".ViewBomDetail", vo);
		return Bomlist;
	}
	
	@Override
	public List<BomVO> CreateDayFindView(BomVO vo) throws Exception {
		
		List<BomVO> Bomlist = sqlsession.selectList(namespace+".CreateDayFindView", vo);
		return Bomlist;
	}
	
	@Override
	public List<BomVO> SearchBomListFindView(BomVO vo) throws Exception {
		
		List<BomVO> Bomlist = sqlsession.selectList(namespace+".SearchBomListFindView" , vo);
		return Bomlist;
	}
	
	@Override
	public List<BomVO> AllListFindView(BomVO vo) throws Exception {
		
		List<BomVO> Bomlist = sqlsession.selectList(namespace+".AllListFindView", vo);
		return Bomlist;
	}
	
	@Override
	public String BomfileDriectoryFind(BomVO vo) throws Exception {
		
		String Bomlist = sqlsession.selectOne(namespace+".BomfileDriectoryFind", vo);
		return Bomlist; 
	}

	public void DeleteBomDetail(BomVO vo) throws Exception {
		
		sqlsession.delete(namespace+".DeleteBomDetail", vo);
	}

	public void DeleteBomFile(BomVO vo) throws Exception {
		
		sqlsession.delete(namespace+".DeleteBomFile", vo);

	}
	
	public void DeleteBomlist(BomVO vo) throws Exception {
		
		sqlsession.delete(namespace+".DeleteBomlist", vo);

	}
}
