package com.lsh.testing05.process.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.lsh.testing05.process.dao.ProcessDAO;
import com.lsh.testing05.process.vo.ProcessVO;

@Service
public class ProcessServiceImpl implements ProcessService {

	@Inject
	ProcessDAO dao;
	
	@Override
	public void NewEquipRegister(ProcessVO vo) throws Exception {
		
		dao.NewEquipRegister(vo);
	}
	
	@Override
	public int CodeCkhProcess(ProcessVO vo) throws Exception {
		
		int result = dao.CodeCkhProcess(vo);
		return result;
	}
	
	@Override
	public int PresetChkProcess(ProcessVO vo) throws Exception {
		
		int result = dao.PresetChkProcess(vo);
		return result;
	}
	
	@Override
	public List<ProcessVO> SelectMatchingProcess(ProcessVO vo) throws Exception {
		
		List<ProcessVO> resultlist = dao.SelectMatchingProcess(vo);
		return resultlist;
	}
	
	@Override 
	public void RegisterProcess(ProcessVO vo) throws Exception {
		dao.RegisterProcess(vo);
	}
	
	@Override
	public void AutoBellowsMatchingID(ProcessVO vo) throws Exception {
		
		dao.AutoBellowsMatchingID(vo);
	}
	/*
	@Override
	public void AutoTotalMatchingID(ProcessVO vo) throws Exception {
		
		dao.AutoTotalMatchingID(vo);
	}
	*/
	@Override
	public void MainCategoryRegister(ProcessVO vo) throws Exception {
		dao.MainCategoryRegister(vo);
	}
	
	@Override
	public int MainProcessChk(ProcessVO vo) throws Exception {
		int result = dao.MainProcessChk(vo);
		return result;
	}
	
	@Override
	public void ALLRegisterEquip(ProcessVO vo) throws Exception {
		dao.ALLRegisterEquip(vo);
	}
	
	@Override
	public void ALLRegisterUniquess(ProcessVO vo) throws Exception {
		dao.ALLRegisterUniquess(vo);
	}
	
	@Override
	public List<ProcessVO> AllselectProcess() throws Exception {
		return dao.AllselectProcess();
	}
	
	@Override
	public void UpdateProcess(ProcessVO vo) throws Exception {
		dao.UpdateProcess(vo);
	}
	
	@Override
	public void DeleteProcess(ProcessVO vo) throws Exception {
		dao.DeleteProcess(vo);
	}
	
	@Override
	public void DeleteMatchingID(ProcessVO vo) throws Exception {
		dao.DeleteMatchingID(vo);
	}
	
	@Override
	public void AllDeleteUniquess(ProcessVO vo) throws Exception {
		dao.AllDeleteUniquess(vo);
	}
	
	@Override
	public int NameChkProcess(ProcessVO vo) throws Exception {
		int result = dao.NameChkProcess(vo);
		return result;
	}
	
	@Override
	public List<ProcessVO> SearchProcess(ProcessVO vo) throws Exception {
		
		return dao.SearchProcess(vo);
	}
	
	@Override
	public List<ProcessVO> MainProcessList(ProcessVO vo) throws Exception {
		
		return dao.MainProcessList(vo);
	}

	
	@Override
	public int IdChkProcess(ProcessVO vo) throws Exception {
		int result = dao.IdChkProcess(vo);
		return result;
	}

}
