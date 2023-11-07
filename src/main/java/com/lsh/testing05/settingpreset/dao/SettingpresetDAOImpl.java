package com.lsh.testing05.settingpreset.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.lsh.testing05.settingpreset.vo.SettingpresetVO;

@Repository
public class SettingpresetDAOImpl implements SettingpresetDAO{
	
	@Inject 
	SqlSession sqlsession;
	
	private static final String namespace = "mapper.settingpresetMapper";
	
	@Override
	public List<SettingpresetVO> SelectPresetUniquess(SettingpresetVO vo) throws Exception {
		
		List<SettingpresetVO> result = sqlsession.selectList(namespace+".SelectPresetUniquess", vo);
		return result;
	}
	
	@Override
	public String OneFindFileDirectory(SettingpresetVO vo) throws Exception {
		
		String result = sqlsession.selectOne(namespace+".OneFindFileDirectory", vo);
		return result;
	}
	
	@Override
	public String FindProcessName(SettingpresetVO vo) throws Exception {
		
		String result = sqlsession.selectOne(namespace+".FindProcessName", vo);
		return result;
	}
	
	@Override
	public List<SettingpresetVO> PresetListViewTest(SettingpresetVO vo) throws Exception {
		
		List<SettingpresetVO> result = sqlsession.selectList(namespace+".PresetListViewTest", vo);
		return result;
	}
	
	@Override
	public List<SettingpresetVO> PresetProcessList(SettingpresetVO vo) throws Exception {
		
		List<SettingpresetVO> result = sqlsession.selectList(namespace+".PresetProcessList", vo);
		return result;
	}
	
	@Override
	public List<SettingpresetVO> FindFileDirectory(SettingpresetVO vo) throws Exception {
		
		List<SettingpresetVO> result = sqlsession.selectList(namespace+".FindFileDirectory", vo);
		return result;
	}
	
	@Override
	public void RegisterSettingPreset(SettingpresetVO vo) throws Exception {
		sqlsession.insert(namespace+".RegisterSettingPreset", vo);
	}
	
	@Override
	public void RegisterSettingPresetProcess(SettingpresetVO vo) throws Exception {
		sqlsession.insert(namespace+".RegisterSettingPresetProcess", vo);
	}
	
	@Override
	public int PresetNameChk(SettingpresetVO vo) throws Exception {
		int result = sqlsession.selectOne(namespace+".PresetNameChk", vo);
		return result;
	}
	
	@Override
	public int FindSettingPresetID(SettingpresetVO vo) throws Exception {
		int result = sqlsession.selectOne(namespace+".FindSettingPresetID", vo);
		return result;
	}
	
	@Override
	public String SamePresetNameIDChk(SettingpresetVO vo) throws Exception {
		
		String result = sqlsession.selectOne(namespace+".SamePresetNameIDChk", vo);
		return result;
	}
	
	public List<SettingpresetVO> PresetListView(SettingpresetVO vo) throws Exception {
		List<SettingpresetVO> PresetList = sqlsession.selectList(namespace+".PresetListView", vo);
		return PresetList;
	}
	
	@Override
	public String ComparePreset(SettingpresetVO vo) throws Exception {
		String result = sqlsession.selectOne(namespace+".ComparePreset", vo);
		return result;
	}
	
	@Override
	public List<SettingpresetVO> SearchSettingPreset(SettingpresetVO vo) throws Exception {
		List<SettingpresetVO> settingpresetlist = sqlsession.selectList(namespace+".SearchSettingPreset", vo);
		return settingpresetlist;
	}
	
	@Override
	public List<SettingpresetVO> OriginProcessSelect(SettingpresetVO vo) throws Exception {
		List<SettingpresetVO> processlist = sqlsession.selectList(namespace+".OriginProcessSelect");
		return processlist;
	}
	
	@Override
	public void DeleteProcessIndex(SettingpresetVO vo) throws Exception {
		sqlsession.delete(namespace+".DeleteProcessIndex", vo);
	}
	
	@Override
	public void DeleteSettingPreset(SettingpresetVO vo /*int SETTING_PRESET_ID*/) throws Exception {
		sqlsession.delete(namespace+".DeleteSettingPreset", vo);
	}
	
	@Override
	public void DeletePresetProcessUniquess(SettingpresetVO vo) throws Exception {
		sqlsession.delete(namespace+".DeletePresetProcessUniquess", vo);
	}
	
	@Override
	public void DeletePresetProcessWorktime(SettingpresetVO vo) throws Exception {
		sqlsession.delete(namespace+".DeletePresetProcessWorktime", vo);
	}
	
	@Override
	public void DeletePresetFile2(SettingpresetVO vo) throws Exception {
		sqlsession.delete(namespace+".DeletePresetFile2", vo);
	}
	
	@Override
	public void DeletePresetProcess(SettingpresetVO vo) throws Exception {
		sqlsession.delete(namespace+".DeletePresetProcess", vo);
	}
	
	@Override
	public void DeleteMultiUniquess(SettingpresetVO vo) throws Exception {
		sqlsession.delete(namespace+".DeleteMultiUniquess", vo);
	}
	
	@Override
	public void DeleteAllUniquess(SettingpresetVO vo) throws Exception {
		sqlsession.delete(namespace+".DeleteAllUniquess", vo);
	}
	
	@Override
	public void UpdatePresetFileRegister(SettingpresetVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdatePresetFileRegister", vo);
	}
	
	@Override
	public void UpdatePresetProcessSelfinspection(SettingpresetVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdatePresetProcessSelfinspection", vo);
	}
	
	@Override
	public void UpdateSettingPreset(SettingpresetVO vo) throws Exception {
		sqlsession.update(namespace+".UpdateSettingPreset", vo);
	}
	
	@Override
	public void UpdatePresetProcessTimeandInspection(SettingpresetVO vo) throws Exception {
		sqlsession.update(namespace+".UpdatePresetProcessTimeandInspection", vo);
	}
	
	@Override
	public int AdminChk(SettingpresetVO vo) throws Exception {
		int result = sqlsession.selectOne(namespace+".AdminChk", vo);
		return result;
	}
	
	@Override
	public int IdEmpStatusChk(SettingpresetVO vo) throws Exception {
		int result = sqlsession.selectOne(namespace+".IdEmpStatusChk", vo);
		return result;
	}
	
	@Override
	public List<SettingpresetVO> CopySettingProcess(SettingpresetVO vo) throws Exception {
		List<SettingpresetVO> result = sqlsession.selectList(namespace+".CopySettingProcess", vo);
		return result;
	}
	
	@Override
	public List<SettingpresetVO> CopySettingProcessIndex(SettingpresetVO vo) throws Exception {
		List<SettingpresetVO> result = sqlsession.selectList(namespace+".CopySettingProcessIndex", vo);
		return result;
	}
	
	@Override
	public List<SettingpresetVO> CopySettingProcessId(SettingpresetVO vo) throws Exception {
		
		List<SettingpresetVO> result = sqlsession.selectList(namespace+".CopySettingProcessId", vo);
		return result;
	}
	
	@Override
	public List<SettingpresetVO>  MultiPresetSelect(SettingpresetVO vo) throws Exception {
		List<SettingpresetVO> settingpresetlist = sqlsession.selectList(namespace+".MultiPresetSelect", vo);
		return settingpresetlist;
	}
	
	@Override
	public void CopySettingPreset(SettingpresetVO vo) throws Exception {
		sqlsession.insert(namespace+".CopySettingPreset", vo);
	}
	
	@Override
	public String CopySettingPresetNameLoad(SettingpresetVO vo) throws Exception {
		String result = sqlsession.selectOne(namespace+".CopySettingPresetNameLoad", vo);
		return result;
	}
	
	@Override
	public void CopySettingPresetProcess(SettingpresetVO vo) throws Exception {
		sqlsession.insert(namespace+".CopySettingPresetProcess", vo);
	}
	

	
	//프리셋 파일 관련
	@Override
	public void PresetFileUpload(SettingpresetVO vo) throws Exception {
		
		sqlsession.insert(namespace+".PresetFileUpload", vo);
	}
	
	@Override
	public List<SettingpresetVO> SelectPresetFile(SettingpresetVO vo) throws Exception {
		
		List<SettingpresetVO> result = sqlsession.selectList(namespace+".SelectPresetFile", vo);
		return result;
	}
	
	@Override
	public void DeletePresetFile(SettingpresetVO vo) throws Exception {
		sqlsession.delete(namespace+".DeletePresetFile" , vo);
	}
	
	@Override
	public void AllDeletePresetFile(SettingpresetVO vo) throws Exception {
		sqlsession.delete(namespace+".AllDeletePresetFile", vo);
	}
	
	@Override
	//만들어진거 찾기 위한 목적
	public int RecentlyValue(SettingpresetVO vo) throws Exception {
		int result = sqlsession.selectOne(namespace+".RecentlyValue");
		return result;
	}
	
	@Override
	public void RegisterSettingPresetUniquess(SettingpresetVO vo) throws Exception {
		
		sqlsession.insert(namespace+".RegisterSettingPresetUniquess", vo);
	}
	
	@Override
	public void RegisterSettingPresetWorktime(SettingpresetVO vo) throws Exception {
		
		sqlsession.insert(namespace+".RegisterSettingPresetWorktime", vo);
	}
	
	@Override
	public List<SettingpresetVO> DetailPresetView(SettingpresetVO vo) throws Exception {
		
		List<SettingpresetVO> result = sqlsession.selectList(namespace+".DetailPresetView", vo);
		return result;
	}
	
	@Override
	public List<SettingpresetVO> DetailPresetWorktimeView(SettingpresetVO vo) throws Exception {
		
		List<SettingpresetVO> result = sqlsession.selectList(namespace+".DetailPresetWorktimeView", vo);
		return result;
	}
	
	@Override
	public List<SettingpresetVO> DetailPresetUniquessView1(SettingpresetVO vo) throws Exception {
		
		List<SettingpresetVO> result = sqlsession.selectList(namespace+".DetailPresetUniquessView1", vo);
		return result;
	}
	
	@Override
	public List<SettingpresetVO> DetailPresetUniquessView2(SettingpresetVO vo) throws Exception {
		
		List<SettingpresetVO> result = sqlsession.selectList(namespace+".DetailPresetUniquessView2", vo);
		return result;
	}
	
	@Override
	public List<SettingpresetVO> DetailPresetUseView(SettingpresetVO vo) throws Exception {
		
		List<SettingpresetVO> result = sqlsession.selectList(namespace+".DetailPresetUseView");
		return result;
	}
	
}
