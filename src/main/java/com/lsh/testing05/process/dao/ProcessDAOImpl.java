package com.lsh.testing05.process.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


import com.lsh.testing05.process.vo.ProcessVO;

@Repository
public class ProcessDAOImpl implements ProcessDAO {

	@Inject
	private SqlSession sqlsession;
	
	private static final String namespace = "mapper.processMapper";
	
	@Override
	public void NewEquipRegister(ProcessVO vo) throws Exception {
		
		sqlsession.insert(namespace+".NewEquipRegister", vo);
	}
	
	@Override
	public int CodeCkhProcess(ProcessVO vo) throws Exception {
		
		int result = sqlsession.selectOne(namespace+".CodeCkhProcess", vo);
		return result;
	}
	
	@Override
	public int PresetChkProcess(ProcessVO vo) throws Exception {
		
		int result = sqlsession.selectOne(namespace+".PresetChkProcess", vo);
		return result;
	}
	
	@Override
	public List<ProcessVO> AllselectProcess() throws Exception {
		List<ProcessVO> processlist = sqlsession.selectList(namespace+".AllselectProcess");
		return processlist;
	}
	
	@Override
	public void AutoBellowsMatchingID(ProcessVO vo) throws Exception {
		
		sqlsession.insert(namespace+".AutoBellowsMatchingID",vo);
	}
	
	@Override
	public List<ProcessVO> SelectMatchingProcess(ProcessVO vo) throws Exception {
		
		List<ProcessVO> resultlist = sqlsession.selectList(namespace+".SelectMatchingProcess",vo);
		return resultlist;
		
	}
	
	/*
	@Override
	public void AutoTotalMatchingID(ProcessVO vo) throws Exception {
		
		sqlsession.insert(namespace+".AutoTotalMatchingID", vo);
	}
	*/
	
	@Override
	public int MainProcessChk(ProcessVO vo) throws Exception {
		int result = sqlsession.selectOne(namespace+".MainProcessChk",vo);
		return result;
	}
	
	@Override
	public void MainCategoryRegister(ProcessVO vo) throws Exception {
		sqlsession.insert(namespace+".MainCategoryRegister", vo);
	}
	
	@Override
	public void UpdateProcess(ProcessVO vo) throws Exception {
		sqlsession.update(namespace+".UpdateProcess", vo);
	}
	
	@Override
	public void DeleteProcess(ProcessVO vo) throws Exception {
		sqlsession.delete(namespace+".DeleteProcess", vo);
	}
	
	@Override
	public void DeleteMatchingID(ProcessVO vo) throws Exception {
		sqlsession.delete(namespace+".DeleteMatchingID", vo);
	}
	
	@Override
	public void AllDeleteUniquess(ProcessVO vo) throws Exception {
		sqlsession.delete(namespace+".AllDeleteUniquess", vo);
	}
	
	@Override
	public void RegisterProcess(ProcessVO vo) throws Exception {
		sqlsession.insert(namespace+".RegisterProcess", vo);
	}
	
	@Override
	public void ALLRegisterEquip(ProcessVO vo) throws Exception {
		sqlsession.insert(namespace+".ALLRegisterEquip", vo);
	}
	
	@Override
	public void ALLRegisterUniquess(ProcessVO vo) throws Exception {
		sqlsession.insert(namespace+".ALLRegisterUniquess", vo);
	}
	
	@Override
	public int NameChkProcess(ProcessVO vo) throws Exception {
		int result = sqlsession.selectOne(namespace+".NameChkProcess", vo);
		return result;
	}
	@Override
	public List<ProcessVO> SearchProcess(ProcessVO vo) throws Exception {
		List<ProcessVO> processlist = sqlsession.selectList(namespace+".SearchProcess", vo);
		return processlist;
		
	}
	
	@Override
	public List<ProcessVO> MainProcessList(ProcessVO vo) throws Exception {
		List<ProcessVO> processlist = sqlsession.selectList(namespace+".MainProcessList", vo);
		return processlist;
	}
	
	@Override
	public int IdChkProcess(ProcessVO vo) throws Exception {
		int result = sqlsession.selectOne(namespace+".IdChkProcess", vo);
		return result;
	}
	
}
