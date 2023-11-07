package com.lsh.testing05.uniquess.dao;

import java.util.List;

import com.lsh.testing05.uniquess.vo.UniquessVO;

public interface UniquessDAO {

	//작업 특이사항 검색 프리셋 조회
	public List<UniquessVO> SearchUniquessWord(UniquessVO vo) throws Exception;
	
	//작업 특이사항 검색 조회
	public List<UniquessVO> FindUniquess(UniquessVO vo) throws Exception;
	
	//작업 특이사항 매칭 조회
	public List<UniquessVO> SearchUniquess(UniquessVO vo) throws Exception;
	
	//작업 특이사항 등록
	public void RegisterUniquess(UniquessVO vo) throws Exception;
	
	//작업 특이사항 수정
	public void UpdateUniquess(UniquessVO vo) throws Exception;
	
	//작업 특이사항 삭제
	public void DeleteUniquess(UniquessVO vo) throws Exception;
	
	//작업 특이사항 ID 유무 체크
	public int UniquessIdChk(UniquessVO vo) throws Exception;
}
