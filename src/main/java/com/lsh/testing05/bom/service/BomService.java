package com.lsh.testing05.bom.service;

import java.util.List;

import com.lsh.testing05.bom.vo.BomVO;

public interface BomService {

	public List<BomVO> SearchJobNumBomDetail(BomVO vo) throws Exception;
	
	public List<BomVO> FindBomJobNum(BomVO vo) throws Exception;
	
	public List<BomVO> SearchBomDetail(BomVO vo) throws Exception;

	public List<BomVO> ViewBomDetailA(BomVO vo) throws Exception;
	
	public int BomNullChk(BomVO vo) throws Exception;
	
	public int BomDelChk(BomVO vo) throws Exception;
	
	public void RegisterBomlist(BomVO vo) throws Exception;
	
	public void UploadBomFile(BomVO vo) throws Exception;
	
	public void RegisterBomDetailA(BomVO vo) throws Exception;
	
	public void RegisterBomDetailB(BomVO vo) throws Exception;
	
	public List<BomVO> ViewBomList(BomVO vo) throws Exception;
	
	public List<BomVO> ViewBomDetail(BomVO vo) throws Exception;

	public List<BomVO> CreateDayFindView(BomVO vo) throws Exception;

	public List<BomVO> SearchBomListFindView(BomVO vo) throws Exception;
	
	public List<BomVO> AllListFindView(BomVO vo) throws Exception;
	
	public String BomfileDriectoryFind(BomVO vo) throws Exception;
	
	public void DeleteBomDetail(BomVO vo) throws Exception;

	public void DeleteBomFile(BomVO vo) throws Exception;

	public void DeleteBomlist(BomVO vo) throws Exception;
}
