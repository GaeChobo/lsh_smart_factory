package com.lsh.testing05.settingpresetprocess.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.lsh.testing05.settingpresetprocess.dao.SettingpresetprocessDAO;
import com.lsh.testing05.settingpresetprocess.vo.SettingpresetprocessVO;

@Service
public class SettingpresetprocessServiceImpl implements SettingpresetprocessService  {

	@Inject
	SettingpresetprocessDAO dao;
	
	@Override
	public void RegisterSettingPresetProcess(SettingpresetprocessVO vo) throws Exception {
		
		dao.RegisterSettingPresetProcess(vo);
	}
	
	@Override
	public List<SettingpresetprocessVO> SelectSettingPresetProcess(SettingpresetprocessVO vo) throws Exception {
		
		return dao.SelectSettingPresetProcess(vo);
	}
	
	@Override
	public List<SettingpresetprocessVO> SettingPresetProcessSelect(SettingpresetprocessVO vo) throws Exception {
		
		return dao.SettingPresetProcessSelect(vo);
	}
	
	@Override
	public void DeleteSettingPresetProcess(SettingpresetprocessVO vo) throws Exception {
		
		dao.DeleteSettingPresetProcess(vo);
	}
	
	@Override
	public void DeleteProcessIndex(SettingpresetprocessVO vo) throws Exception {
		
		dao.DeleteProcessIndex(vo);
	}

	@Override
	public void UpdateSettingPresetProcess(SettingpresetprocessVO vo) throws Exception {
		
		dao.UpdateSettingPresetProcess(vo);
	}
	
	@Override
	public int SettingPresetIdChk(SettingpresetprocessVO vo) throws Exception {
		
		int result = dao.SettingPresetIdChk(vo);
		return result;
	}
	
	public List<SettingpresetprocessVO> DetailSettingPresetProcess(SettingpresetprocessVO vo) throws Exception{
		
		return dao.DetailSettingPresetProcess(vo);
	}
	/*
	public int SettingPresetIndexChk(SettingpresetprocessVO vo) throws Exception {
		
		int result = dao.SettingPresetIndexChk(vo);
		return result;
	}*/
	
	@Override
	public int SettingPresetIndexChk(SettingpresetprocessVO vo) throws Exception {
		
		int result = dao.SettingPresetIndexChk(vo);
		return result;
	}

}
