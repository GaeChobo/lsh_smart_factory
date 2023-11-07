package com.lsh.testing05.uniquess.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.lsh.testing05.uniquess.vo.UniquessVO;

@Repository
public class UniquessDAOImpl implements UniquessDAO {

	
	@Inject
	private SqlSession sqlsession;
	
	private static final String namespace = "mapper.uniquessMapper";
	
	@Override
	public List<UniquessVO> SearchUniquessWord(UniquessVO vo) throws Exception {
		
		List<UniquessVO> uniquesslist = sqlsession.selectList(namespace+".SearchUniquessWord", vo);
		return uniquesslist;
	}
	
	@Override
	public List<UniquessVO> FindUniquess(UniquessVO vo) throws Exception {
		
		List<UniquessVO> uniquesslist = sqlsession.selectList(namespace+".FindUniquess", vo);
		return uniquesslist;
	}
	
	@Override
	public List<UniquessVO> SearchUniquess(UniquessVO vo) throws Exception {
		List<UniquessVO> uniquesslist = sqlsession.selectList(namespace+".SearchUniquess", vo);
		return uniquesslist;
	}
	
	@Override
	public void RegisterUniquess(UniquessVO vo) throws Exception {
		
		sqlsession.insert(namespace+".RegisterUniquess", vo);
	}
	
	@Override
	public void UpdateUniquess(UniquessVO vo) throws Exception {
	
		sqlsession.update(namespace+".UpdateUniquess", vo);
	}
	
	@Override
	public void DeleteUniquess(UniquessVO vo) throws Exception {
		
		sqlsession.delete(namespace+".DeleteUniquess", vo);
	}
	
	@Override
	public int UniquessIdChk(UniquessVO vo) throws Exception {
		
		int result = sqlsession.selectOne(namespace+".UniquessIdChk", vo);
		return result;
	}
}
