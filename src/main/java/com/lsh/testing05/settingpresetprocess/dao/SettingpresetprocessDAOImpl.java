package com.lsh.testing05.settingpresetprocess.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.lsh.testing05.settingpresetprocess.vo.SettingpresetprocessVO;

@Repository
public class SettingpresetprocessDAOImpl implements SettingpresetprocessDAO  {
	
	@Inject
	SqlSession sqlsession;
	
	private static final String namespace = "mapper.settingpresetprocessMapper";
	
	@Override
	public void RegisterSettingPresetProcess(SettingpresetprocessVO vo) throws Exception {
		sqlsession.insert(namespace+".RegisterSettingPresetProcess", vo);
	}
	
	@Override
	public List<SettingpresetprocessVO> SelectSettingPresetProcess(SettingpresetprocessVO vo) throws Exception {
		List<SettingpresetprocessVO> presetprocesslist = sqlsession.selectList(namespace+".SelectSettingPresetProcess", vo);
		return presetprocesslist;
	}
	
	@Override
	public List<SettingpresetprocessVO> SettingPresetProcessSelect(SettingpresetprocessVO vo) throws Exception {
		List<SettingpresetprocessVO> presetprocesslist = sqlsession.selectList(namespace+".SettingPresetProcessSelect");
		return presetprocesslist;
	}
	
	@Override
	public void DeleteSettingPresetProcess(SettingpresetprocessVO vo) throws Exception {
		sqlsession.delete(namespace+".DeleteSettingPresetProcess", vo);
	}
	
	@Override
	public void DeleteProcessIndex(SettingpresetprocessVO vo) throws Exception {
		sqlsession.delete(namespace+".DeleteProcessIndex", vo);
	}
	
	@Override
	public void UpdateSettingPresetProcess(SettingpresetprocessVO vo) throws Exception {
		sqlsession.update(namespace+".UpdateSettingPresetProcess", vo);
	}
	
	@Override
	public int SettingPresetIdChk(SettingpresetprocessVO vo) throws Exception {
		int result = sqlsession.selectOne(namespace+".SettingPresetIdChk", vo);
		return result;
	}
	
	@Override
	public List<SettingpresetprocessVO> DetailSettingPresetProcess(SettingpresetprocessVO vo) throws Exception {
		List<SettingpresetprocessVO> presetprocesslist = sqlsession.selectList(namespace+".DetailSettingPresetProcess", vo);
		return presetprocesslist;
	}
	
	/*
	@Override
	public int SettingPresetIndexChk(SettingpresetprocessVO vo) throws Exception {
		int result = sqlsession.selectOne(namespace+".SettingPresetIndexChk", vo);
		return result;
	}*/
	
	@Override
	public int SettingPresetIndexChk(SettingpresetprocessVO vo) throws Exception {
		int result = sqlsession.selectOne(namespace+".SettingPresetIndexChk", vo);
		return result;
	}
}
