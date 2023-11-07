package com.lsh.testing05.settingpresetprocess.service;

import java.util.List;

import com.lsh.testing05.settingpresetprocess.vo.SettingpresetprocessVO;

public interface SettingpresetprocessService {

		public void RegisterSettingPresetProcess(SettingpresetprocessVO vo) throws Exception;

		public List<SettingpresetprocessVO> SelectSettingPresetProcess(SettingpresetprocessVO vo) throws Exception;

		public List<SettingpresetprocessVO> SettingPresetProcessSelect(SettingpresetprocessVO vo) throws Exception;

		public void DeleteSettingPresetProcess(SettingpresetprocessVO vo) throws Exception;

		public void DeleteProcessIndex(SettingpresetprocessVO vo) throws Exception;

		public void UpdateSettingPresetProcess(SettingpresetprocessVO vo) throws Exception;
		
		public int SettingPresetIdChk(SettingpresetprocessVO vo) throws Exception; 

		public List<SettingpresetprocessVO> DetailSettingPresetProcess(SettingpresetprocessVO vo) throws Exception;
		
		//public int SettingPresetIndexChk(SettingpresetprocessVO vo) throws Exception;

		public int SettingPresetIndexChk(SettingpresetprocessVO vo) throws Exception;

}
