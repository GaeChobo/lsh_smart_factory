package com.lsh.testing05.settingpresetprocess.dao;

import java.util.List;

import com.lsh.testing05.settingpresetprocess.vo.SettingpresetprocessVO;

public interface SettingpresetprocessDAO {
	
	//세팅프리셋 공정 등록
	public void RegisterSettingPresetProcess(SettingpresetprocessVO vo) throws Exception;
	
	//세팅프리셋 공정 조회
	public List<SettingpresetprocessVO> SelectSettingPresetProcess(SettingpresetprocessVO vo) throws Exception;
	
	//세팅프리셋 원본 공정 목록 조회
	public List<SettingpresetprocessVO> SettingPresetProcessSelect(SettingpresetprocessVO vo) throws Exception;
	
	//세팅프리셋 공정 전체 삭제
	public void DeleteSettingPresetProcess(SettingpresetprocessVO vo) throws Exception;
	
	//세팅프리셋 공정 Index 삭제
	public void DeleteProcessIndex(SettingpresetprocessVO vo) throws Exception;
	
	//세팅프리셋 공정 수정 일단 1차 수정만 인덱스 수정은 좀더 생각
	public void UpdateSettingPresetProcess(SettingpresetprocessVO vo) throws Exception;
	
	//세팅프리셋 ID 체크
	public int SettingPresetIdChk(SettingpresetprocessVO vo) throws Exception;
	
	//세팅프리셋 순서대로 보기 조회
	public List<SettingpresetprocessVO> DetailSettingPresetProcess(SettingpresetprocessVO vo) throws Exception;
	
	//세팅프리셋 순서가 있는지 조회 있으면 업데이트 못하게 끔
	//public int SettingPresetIndexChk(SettingpresetprocessVO vo) throws Exception;
	
	//세팅프리셋 공정 인덱스 중복을 막기위한 selet
	public int SettingPresetIndexChk(SettingpresetprocessVO vo) throws Exception;
	
 }
