package com.lsh.testing05.uniquess.service;

import java.util.List;

import com.lsh.testing05.uniquess.vo.UniquessVO;

public interface UniquessService {

	public List<UniquessVO> SearchUniquessWord(UniquessVO vo) throws Exception;
	
	public List<UniquessVO> FindUniquess(UniquessVO vo) throws Exception;
	
	public List<UniquessVO> SearchUniquess(UniquessVO vo) throws Exception;
	
	public void RegisterUniquess(UniquessVO vo) throws Exception;
	
	public void UpdateUniquess(UniquessVO vo) throws Exception;
	
	public void DeleteUniquess(UniquessVO vo) throws Exception;
	
	public int UniquessIdChk(UniquessVO vo) throws Exception;
}
