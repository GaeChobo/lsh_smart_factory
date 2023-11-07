package com.lsh.testing05.uniquess.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.lsh.testing05.uniquess.dao.UniquessDAO;
import com.lsh.testing05.uniquess.vo.UniquessVO;

@Service
public class UniquessServiceImpl implements UniquessService {

	@Inject
	UniquessDAO dao;
	
	@Override
	public List<UniquessVO> SearchUniquessWord(UniquessVO vo) throws Exception {
		
		return dao.SearchUniquessWord(vo);
	}
	
	@Override
	public List<UniquessVO> FindUniquess(UniquessVO vo) throws Exception {
		
		return dao.FindUniquess(vo);
	}
	
	@Override
	public List<UniquessVO> SearchUniquess(UniquessVO vo) throws Exception {
		return dao.SearchUniquess(vo);
	}
	
	@Override
	public void RegisterUniquess(UniquessVO vo) throws Exception {
		dao.RegisterUniquess(vo);
	}
	
	@Override
	public void UpdateUniquess(UniquessVO vo) throws Exception {
		dao.UpdateUniquess(vo);
	}
	
	@Override
	public void DeleteUniquess(UniquessVO vo) throws Exception {
		dao.DeleteUniquess(vo);
	}
	
	@Override
	public int UniquessIdChk(UniquessVO vo) throws Exception {
		int result = dao.UniquessIdChk(vo);
		return result;
	}
}
