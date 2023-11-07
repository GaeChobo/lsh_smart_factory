package com.lsh.testing05.bom.dao;

import java.util.List;

import com.lsh.testing05.bom.vo.BomVO;

public interface BomDAO {
	
	public List<BomVO> SearchJobNumBomDetail(BomVO vo) throws Exception;

	//BOM 디테일에 매칭된 작업지시서 번호 조회
	public List<BomVO> FindBomJobNum(BomVO vo) throws Exception;
	
	//BOM 디테일 검색
	public List<BomVO> SearchBomDetail(BomVO vo) throws Exception;
	
	//통합 서식 View
	public List<BomVO> ViewBomDetailA(BomVO vo) throws Exception;

	//BOM NULL 체크
	public int BomNullChk(BomVO vo) throws Exception;
	
	//BOM 리턴 조회
	public int BomDelChk(BomVO vo) throws Exception;
	
	//공통 BOM 리슻트 등록
	public void RegisterBomlist(BomVO vo) throws Exception;

	//BOM 파일 업로드
	public void UploadBomFile(BomVO vo) throws Exception;
	
	//BOM A 양식 엑셀 등록
	public void RegisterBomDetailA(BomVO vo) throws Exception;
	
	//BOM B 양식 엑셀 등록
	public void RegisterBomDetailB(BomVO vo) throws Exception;
	
	//BOM 리스트 조회
	public List<BomVO> ViewBomList(BomVO vo) throws Exception;
	
	//BOM 디테일 조회
	public List<BomVO> ViewBomDetail(BomVO vo) throws Exception;
	
	//BOM 등록일 기간 조회
	public List<BomVO> CreateDayFindView(BomVO vo) throws Exception;
	
	//BOM 품번, 품명, 담당자 조회
	public List<BomVO> SearchBomListFindView(BomVO vo) throws Exception;
	
	//BOM 통합 조회
	public List<BomVO> AllListFindView(BomVO vo) throws Exception;
	
	//BOM 파일 디렉토리 찾아오기
	public String BomfileDriectoryFind(BomVO vo) throws Exception;
	
	//BOM Detail 삭제
	public void DeleteBomDetail(BomVO vo) throws Exception;
	
	//Bom File 삭제
	public void DeleteBomFile(BomVO vo) throws Exception;
	
	//Bom list 삭제
	public void DeleteBomlist(BomVO vo) throws Exception;
	
}
