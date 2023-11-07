package com.lsh.testing05.equip.dao;

import java.util.List;

import com.lsh.testing05.equip.vo.EquipVO;


public interface EquipDAO {

	//설비-센서 매칭 리스트
	public List<EquipVO> EquipMatchingList(EquipVO vo) throws Exception;
	
	//설비-센서 매칭 적용
	public void EquipSensorMatching(EquipVO vo) throws Exception;
	
	//설비-센서 매칭 삭제
	public void EquipSensorMatchingDelete(EquipVO vo) throws Exception;
	
	//설비-센서 센서 리스트
	public List<EquipVO> EquipSensorList(EquipVO vo) throws Exception;
	
	//설비-센서매칭 위치 리스트
	public List<EquipVO> EquipIndexList(EquipVO vo) throws Exception;
	
	//설비 보여주기 List
	public List<EquipVO> SelectEquipList(EquipVO vo) throws Exception;
	
	//작업자용 설비 조회
	public List<EquipVO> SelectWorkerEquip(EquipVO vo) throws Exception;
	
	//설비 등록
	public void RegisterEquip(EquipVO vo) throws Exception;
	
	//설비 전체 조회
	public List<EquipVO> AllselectEquip() throws Exception;
	
	//설비 정보 수정
	public void UpdateEquip(EquipVO vo) throws Exception;
	
	//설비 삭제
	public void DeleteEquip(EquipVO vo) throws Exception;
	
	//공정 번호 유무조회
	public int ProcessIdChk(EquipVO vo) throws Exception;
	
	//설비 검색조회
	public List<EquipVO> SearchEquip(EquipVO vo) throws Exception;
	
	//설비 index 조회
	public int EquipIdCheck(EquipVO vo) throws Exception;
	
	//설비 공정 코드 클릭 시 조회
	public List<EquipVO> SelectProcessEquip(EquipVO vo) throws Exception;
	
	
}
