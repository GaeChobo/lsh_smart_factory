package com.lsh.testing05.process.dao;

import java.util.List;


import com.lsh.testing05.process.vo.ProcessVO;

public interface ProcessDAO {
	
	//공정 대분류 생성시 해당없음 설비 자동 생성
	public void NewEquipRegister(ProcessVO vo) throws Exception;
	
	//공정 코드 중복 체크
	public int CodeCkhProcess(ProcessVO vo) throws Exception;
	
	//프리셋안에 원본 공정이 있는지 체크
	public int PresetChkProcess(ProcessVO vo) throws Exception;
	
	//원본 공정 전체목록 조회
	public List<ProcessVO> AllselectProcess() throws Exception;	
	
	//공정 매칭 조회 작업용
	public List<ProcessVO> SelectMatchingProcess(ProcessVO vo) throws Exception;
	
	//원본 공정 서식 매칭1
	public void AutoBellowsMatchingID(ProcessVO vo) throws Exception;
	
	//원본 공정 서식 매칭2
	//public void AutoTotalMatchingID(ProcessVO vo) throws Exception;
	
	//원본 공정 정보 수정
	public void UpdateProcess(ProcessVO vo) throws Exception;
	
	//원본 공정 삭제
	public void DeleteProcess(ProcessVO vo) throws Exception;
	
	//원본 공정 매칭 삭제
	public void DeleteMatchingID(ProcessVO vo) throws Exception; 
	
	//공정 삭제 시 작업 특이사항도 삭제
	public void AllDeleteUniquess(ProcessVO vo) throws Exception;
	
	//원본 공정 추가
	public void RegisterProcess(ProcessVO vo) throws Exception;
	
	//공정 대분류 등록
	public void MainCategoryRegister(ProcessVO vo) throws Exception;
	
	//공정 대분류 중복 체크
	public int MainProcessChk(ProcessVO vo) throws Exception;
	
	//만들 때 전부 다 설비 넣기
	public void ALLRegisterEquip(ProcessVO vo) throws Exception;
	
	//만들 때 전부 다 특이사항 넣기
	public void ALLRegisterUniquess(ProcessVO vo) throws Exception;
	
	//원본 네임 중복 체크
	public int NameChkProcess(ProcessVO vo) throws Exception;
	
	//원본 공정 목록 검색 조회
	public List<ProcessVO> SearchProcess(ProcessVO vo) throws Exception; 
	
	//대분류 공정 목록 전체 조회
	public List<ProcessVO> MainProcessList(ProcessVO vo) throws Exception; 
	
	//원본 공정 INDEX 체크
	public int IdChkProcess(ProcessVO vo) throws Exception;
}
