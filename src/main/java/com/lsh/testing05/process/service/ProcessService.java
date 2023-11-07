package com.lsh.testing05.process.service;

import java.util.List;

import com.lsh.testing05.process.vo.ProcessVO;

public interface ProcessService {
	
	public void NewEquipRegister(ProcessVO vo) throws Exception;
	
	public int CodeCkhProcess(ProcessVO vo) throws Exception;
	
	public int PresetChkProcess(ProcessVO vo) throws Exception;
	
	public List<ProcessVO> SelectMatchingProcess(ProcessVO vo) throws Exception;
	
	public void RegisterProcess(ProcessVO vo) throws Exception;
	
	public void AutoBellowsMatchingID(ProcessVO vo) throws Exception;

	//public void AutoTotalMatchingID(ProcessVO vo) throws Exception;

	public void MainCategoryRegister(ProcessVO vo) throws Exception;
	
	public int MainProcessChk(ProcessVO vo) throws Exception;
	
	public void ALLRegisterEquip(ProcessVO vo) throws Exception;

	public void ALLRegisterUniquess(ProcessVO vo) throws Exception;
	
	public List<ProcessVO> AllselectProcess() throws Exception;
	
	public void UpdateProcess(ProcessVO vo) throws Exception;
	
	public void DeleteProcess(ProcessVO vo) throws Exception;

	public void DeleteMatchingID(ProcessVO vo) throws Exception;
	
	public void AllDeleteUniquess(ProcessVO vo) throws Exception;
	
	public int NameChkProcess(ProcessVO vo) throws Exception;
	
	public List<ProcessVO> SearchProcess(ProcessVO vo) throws Exception;
	
	public List<ProcessVO> MainProcessList(ProcessVO vo) throws Exception;

	public int IdChkProcess(ProcessVO vo) throws Exception;
}
