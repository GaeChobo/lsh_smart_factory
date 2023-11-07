package com.lsh.testing05.settingpreset.service;

import java.util.List;

import com.lsh.testing05.settingpreset.vo.SettingpresetVO;

public interface SettingpresetService {

	public List<SettingpresetVO> SelectPresetUniquess(SettingpresetVO vo) throws Exception;
	
	public String OneFindFileDirectory(SettingpresetVO vo) throws Exception;

	public String FindProcessName(SettingpresetVO vo) throws Exception;
	
	public List<SettingpresetVO> PresetListViewTest(SettingpresetVO vo) throws Exception;
	
	public List<SettingpresetVO> PresetProcessList(SettingpresetVO vo) throws Exception;

	public List<SettingpresetVO> FindFileDirectory(SettingpresetVO vo) throws Exception;
	
	public void RegisterSettingPreset(SettingpresetVO vo) throws Exception;
		
	public void RegisterSettingPresetProcess(SettingpresetVO vo) throws Exception;
		
	public void CopySettingPreset(SettingpresetVO vo) throws Exception;
		
	public void CopySettingPresetProcess(SettingpresetVO vo) throws Exception;

	public List<SettingpresetVO> CopySettingProcess(SettingpresetVO vo) throws Exception;
		
	public List<SettingpresetVO> CopySettingProcessIndex(SettingpresetVO vo) throws Exception;
		
	public List<SettingpresetVO> CopySettingProcessId(SettingpresetVO vo) throws Exception;
	
	public int PresetNameChk(SettingpresetVO vo) throws Exception;
		
	public int FindSettingPresetID(SettingpresetVO vo) throws Exception;
		
	public String SamePresetNameIDChk(SettingpresetVO vo) throws Exception;
	
	public String ComparePreset(SettingpresetVO vo) throws Exception;
		
	public List<SettingpresetVO> PresetListView(SettingpresetVO vo) throws Exception;
		
	public List<SettingpresetVO> SearchSettingPreset(SettingpresetVO vo) throws Exception;

	public List<SettingpresetVO> OriginProcessSelect(SettingpresetVO vo) throws Exception;

	public void DeleteSettingPreset(SettingpresetVO vo) throws Exception;

	public void DeletePresetProcessUniquess(SettingpresetVO vo) throws Exception;
	
	public void DeletePresetProcessWorktime(SettingpresetVO vo) throws Exception;

	public void DeletePresetFile2(SettingpresetVO vo) throws Exception;
		
	public void DeletePresetProcess(SettingpresetVO vo) throws Exception;

	public void DeleteMultiUniquess(SettingpresetVO vo) throws Exception;
	
	public void DeleteAllUniquess(SettingpresetVO vo) throws Exception;
	
	public void DeleteProcessIndex(SettingpresetVO vo) throws Exception;
	
	public void UpdatePresetFileRegister(SettingpresetVO vo) throws Exception; 
	
	public void UpdateSettingPreset(SettingpresetVO vo) throws Exception;
		
	public void UpdatePresetProcessTimeandInspection(SettingpresetVO vo) throws Exception; 

	public void UpdatePresetProcessSelfinspection(SettingpresetVO vo) throws Exception;

	public int AdminChk(SettingpresetVO vo) throws Exception;

	public int IdEmpStatusChk(SettingpresetVO vo) throws Exception;

	public List<SettingpresetVO> MultiPresetSelect(SettingpresetVO vo) throws Exception;
		
	public String CopySettingPresetNameLoad(SettingpresetVO vo) throws Exception;

		
	//세팅프리셋 파일 업로드 관련
	public void PresetFileUpload(SettingpresetVO vo) throws Exception;

	public List<SettingpresetVO> SelectPresetFile(SettingpresetVO vo) throws Exception;

	public void DeletePresetFile(SettingpresetVO vo) throws Exception;

	public void AllDeletePresetFile(SettingpresetVO vo) throws Exception;
		
	public int RecentlyValue(SettingpresetVO vo) throws Exception;
		
	public void RegisterSettingPresetUniquess(SettingpresetVO vo) throws Exception;
		
	public void RegisterSettingPresetWorktime(SettingpresetVO vo) throws Exception;

	public List<SettingpresetVO> DetailPresetView(SettingpresetVO vo) throws Exception;
		
	public List<SettingpresetVO> DetailPresetWorktimeView(SettingpresetVO vo) throws Exception;

	public List<SettingpresetVO> DetailPresetUniquessView1(SettingpresetVO vo) throws Exception;

	public List<SettingpresetVO> DetailPresetUniquessView2(SettingpresetVO vo) throws Exception;

	public List<SettingpresetVO> DetailPresetUseView(SettingpresetVO vo) throws Exception;

}
