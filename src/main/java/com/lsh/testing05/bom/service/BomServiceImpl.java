package com.lsh.testing05.bom.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.lsh.testing05.bom.dao.BomDAO;
import com.lsh.testing05.bom.vo.BomVO;

@Service
public class BomServiceImpl implements BomService{

	@Inject
	BomDAO dao;
	
	@Override
	public List<BomVO> SearchJobNumBomDetail(BomVO vo) throws Exception {
		
		return dao.SearchJobNumBomDetail(vo);
	}
	
	@Override
	public List<BomVO> FindBomJobNum(BomVO vo) throws Exception {
		
		return dao.FindBomJobNum(vo);
	}
	
	@Override
	public List<BomVO> SearchBomDetail(BomVO vo) throws Exception {
		
		return dao.SearchBomDetail(vo);
	}
	
	@Override
	public List<BomVO> ViewBomDetailA(BomVO vo) throws Exception {
		
		return dao.ViewBomDetailA(vo);
	}
	
	@Override
	public int BomNullChk(BomVO vo) throws Exception {
		
		return dao.BomNullChk(vo);
	}
	
	@Override
	public int BomDelChk(BomVO vo) throws Exception {
		
		return dao.BomDelChk(vo);
	}
	
	@Override
	public List<BomVO> ViewBomDetail(BomVO vo) throws Exception {
		
		return dao.ViewBomDetail(vo);
	}
	
	@Override
	public void RegisterBomlist(BomVO vo) throws Exception {
		
		dao.RegisterBomlist(vo);
	}
	
	@Override
	public void UploadBomFile(BomVO vo) throws Exception {
		
		dao.UploadBomFile(vo);
	}
	
	@Override
	public void RegisterBomDetailA(BomVO vo) throws Exception {
		
		dao.RegisterBomDetailA(vo);
	}

	@Override
	public void RegisterBomDetailB(BomVO vo) throws Exception {
		
		dao.RegisterBomDetailB(vo);
	}
	
	@Override
	public List<BomVO> ViewBomList(BomVO vo) throws Exception {
		
		return dao.ViewBomList(vo);
	}
	
	@Override
	public List<BomVO> CreateDayFindView(BomVO vo) throws Exception {
		
		return dao.CreateDayFindView(vo);
	}
	
	@Override
	public List<BomVO> SearchBomListFindView(BomVO vo) throws Exception {
		
		return dao.SearchBomListFindView(vo);
	}
	
	public List<BomVO> AllListFindView(BomVO vo) throws Exception {
		
		return dao.AllListFindView(vo);
	}
	
	@Override
	public String BomfileDriectoryFind(BomVO vo) throws Exception {
		
		return dao.BomfileDriectoryFind(vo);
	}
	
	@Override
	public void DeleteBomDetail(BomVO vo) throws Exception {
	
		dao.DeleteBomDetail(vo);
	}

	@Override
	public void DeleteBomFile(BomVO vo) throws Exception {
		
		dao.DeleteBomFile(vo);
		
	}
	
	@Override
	public void DeleteBomlist(BomVO vo) throws Exception {
		
		dao.DeleteBomlist(vo);

	}
}
