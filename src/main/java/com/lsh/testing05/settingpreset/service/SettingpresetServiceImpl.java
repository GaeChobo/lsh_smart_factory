package com.lsh.testing05.settingpreset.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.lsh.testing05.settingpreset.dao.SettingpresetDAO;
import com.lsh.testing05.settingpreset.vo.SettingpresetVO;

@Service
public class SettingpresetServiceImpl implements SettingpresetService{
	
	@Inject
	SettingpresetDAO dao;
	
	@Override
	public List<SettingpresetVO> SelectPresetUniquess(SettingpresetVO vo) throws Exception {
		
		List<SettingpresetVO> result = dao.SelectPresetUniquess(vo);
		return result;
	}
	
	@Override
	public String OneFindFileDirectory(SettingpresetVO vo) throws Exception {
		
		String result = dao.OneFindFileDirectory(vo);
		return result;
	}
	
	@Override
	public String SamePresetNameIDChk(SettingpresetVO vo) throws Exception {
		
		String result= dao.SamePresetNameIDChk(vo);
		return result;
	}
	
	@Override
	public String FindProcessName(SettingpresetVO vo) throws Exception {
		
		String result = dao.FindProcessName(vo);
		return result;
	}
	
	@Override
	public List<SettingpresetVO> PresetListViewTest(SettingpresetVO vo) throws Exception {
		
		List<SettingpresetVO> result = dao.PresetListViewTest(vo);
		return result;
		
	}
	
	@Override
	public List<SettingpresetVO> PresetProcessList(SettingpresetVO vo) throws Exception {
		
		List<SettingpresetVO> result = dao.PresetProcessList(vo);
		return result;
	}
	
	@Override
	public List<SettingpresetVO> FindFileDirectory(SettingpresetVO vo) throws Exception {
		
		List<SettingpresetVO> result = dao.FindFileDirectory(vo);
		return result;
	}
	
	@Override
	public List<SettingpresetVO> CopySettingProcess(SettingpresetVO vo) throws Exception {
		
		List<SettingpresetVO> result = dao.CopySettingProcess(vo);
		return result;
	}
	
	//카피 세팅 프로세스 인덱스 가져오기
	@Override
	public List<SettingpresetVO> CopySettingProcessIndex(@RequestBody SettingpresetVO vo) throws Exception {		
		List<SettingpresetVO> result = dao.CopySettingProcessIndex(vo);
		return result;
	}
	
	@Override
	public List<SettingpresetVO> CopySettingProcessId(SettingpresetVO vo) throws Exception {
		List<SettingpresetVO> result = dao.CopySettingProcessId(vo);
		return result;
	}

	@Override
	public void RegisterSettingPreset(SettingpresetVO vo) throws Exception {
		
		dao.RegisterSettingPreset(vo);
	}
	
	@Override
	public void RegisterSettingPresetProcess(SettingpresetVO vo) throws Exception {
		
		dao.RegisterSettingPresetProcess(vo);
	}
	
	@Override
	public int PresetNameChk(SettingpresetVO vo) throws Exception {
		
		int result = dao.PresetNameChk(vo);
		return result;
	}
	
	@Override
	public int FindSettingPresetID(SettingpresetVO vo) throws Exception {
		
		int result = dao.FindSettingPresetID(vo);
		return result;
	}
	
	@Override
	public String ComparePreset(SettingpresetVO vo) throws Exception {
		
		String result = dao.ComparePreset(vo);
		return result;
	}
	
	@Override
	public List<SettingpresetVO> PresetListView(SettingpresetVO vo) throws Exception {
		
		return dao.PresetListView(vo);
	}
	
	@Override
	public List<SettingpresetVO> SearchSettingPreset(SettingpresetVO vo) throws Exception {
		
		return dao.SearchSettingPreset(vo);
	}
	
	@Override
	public List<SettingpresetVO> OriginProcessSelect(SettingpresetVO vo) throws Exception {
		
		return dao.OriginProcessSelect(vo);
	}
	
	@Override
	public void DeleteProcessIndex(SettingpresetVO vo) throws Exception  {
		
		dao.DeleteProcessIndex(vo);
	}
	
	@Override
	public void DeleteSettingPreset(SettingpresetVO vo /*int SETTING_PRESET_ID*/) throws Exception {
		
		dao.DeleteSettingPreset(vo);
	}
	
	@Override
	public void DeletePresetProcessUniquess(SettingpresetVO vo) throws Exception {
		
		dao.DeletePresetProcessUniquess(vo);
	}

	@Override
	public void DeletePresetProcessWorktime(SettingpresetVO vo) throws Exception {
		
		dao.DeletePresetProcessWorktime(vo);
	}
	
	@Override
	public void DeletePresetFile2(SettingpresetVO vo) throws Exception {
		
		dao.DeletePresetFile2(vo);
	}
	
	@Override
	public void DeletePresetProcess(SettingpresetVO vo) throws Exception {
		
		dao.DeletePresetProcess(vo);
	}
	
	@Override
	public void DeleteMultiUniquess(SettingpresetVO vo) throws Exception {
		
		dao.DeleteMultiUniquess(vo);
	}
	
	@Override
	public void DeleteAllUniquess(SettingpresetVO vo) throws Exception {
		
		dao.DeleteAllUniquess(vo);
	}
	
	@Override
	public void UpdatePresetFileRegister(SettingpresetVO vo) throws Exception {
		
		dao.UpdatePresetFileRegister(vo);
	}
	
	@Override
	public void UpdateSettingPreset(SettingpresetVO vo) throws Exception {
		
		dao.UpdateSettingPreset(vo);
	}
	
	@Override
	public void UpdatePresetProcessTimeandInspection(SettingpresetVO vo) throws Exception {
		
		dao.UpdatePresetProcessTimeandInspection(vo);
	}
	
	@Override
	public void UpdatePresetProcessSelfinspection(SettingpresetVO vo) throws Exception {
		
		dao.UpdatePresetProcessSelfinspection(vo);
	}
	
	@Override
	public int AdminChk(SettingpresetVO vo) throws Exception {
		
		int result = dao.AdminChk(vo);
		return result;
	}
	
	@Override
	public int IdEmpStatusChk(SettingpresetVO vo) throws Exception {
		
		int result = dao.IdEmpStatusChk(vo);
		return result;
	}

	public List<SettingpresetVO> MultiPresetSelect(SettingpresetVO vo) throws Exception {
		
		return dao.MultiPresetSelect(vo);
	}
	
	@Override
	public void CopySettingPreset(SettingpresetVO vo) throws Exception {
		
		dao.CopySettingPreset(vo);
	}
	
	@Override
	public String CopySettingPresetNameLoad(SettingpresetVO vo) throws Exception {
		
		String result = dao.CopySettingPresetNameLoad(vo);
		return result;
	}
	
	@Override
	public void CopySettingPresetProcess(SettingpresetVO vo) throws Exception {
		
		dao.CopySettingPresetProcess(vo);
	}
	
	@Override
	public void PresetFileUpload(SettingpresetVO vo) throws Exception {
		dao.PresetFileUpload(vo);
	}
	
	@Override
	public List<SettingpresetVO> SelectPresetFile(SettingpresetVO vo) throws Exception {
		List<SettingpresetVO> result = dao.SelectPresetFile(vo);
		return result;
	}
	
	@Override
	public void DeletePresetFile(SettingpresetVO vo) throws Exception {
		dao.DeletePresetFile(vo);
	}
	
	@Override
	public void AllDeletePresetFile(SettingpresetVO vo) throws Exception {
		dao.AllDeletePresetFile(vo);
	}
	
	@Override
	public int RecentlyValue(SettingpresetVO vo) throws Exception {
		int result = dao.RecentlyValue(vo);
		return result;
	}
	
	@Override
	public void RegisterSettingPresetUniquess(SettingpresetVO vo) throws Exception {
		
		dao.RegisterSettingPresetUniquess(vo);
	}
	
	@Override
	public void RegisterSettingPresetWorktime(SettingpresetVO vo) throws Exception {
		
		dao.RegisterSettingPresetWorktime(vo);
	}
	
	@Override
	public List<SettingpresetVO> DetailPresetView(SettingpresetVO vo) throws Exception {
		
		List<SettingpresetVO> result = dao.DetailPresetView(vo);
		return result;
	}
	
	@Override
	public List<SettingpresetVO> DetailPresetWorktimeView(SettingpresetVO vo) throws Exception {
		
		List<SettingpresetVO> result = dao.DetailPresetWorktimeView(vo);
		return result;
	}
	
	@Override
	public List<SettingpresetVO> DetailPresetUniquessView1(SettingpresetVO vo) throws Exception {
		
		List<SettingpresetVO> result = dao.DetailPresetUniquessView1(vo);
		return result;
	}
	
	@Override
	public List<SettingpresetVO> DetailPresetUniquessView2(SettingpresetVO vo) throws Exception {
		
		List<SettingpresetVO> result = dao.DetailPresetUniquessView2(vo);
		return result;
 	}
	
	@Override
	public List<SettingpresetVO> DetailPresetUseView(SettingpresetVO vo) throws Exception {
		
		List<SettingpresetVO> result= dao.DetailPresetUseView(vo);
		return result;
	}
}
