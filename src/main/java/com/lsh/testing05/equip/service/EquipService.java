package com.lsh.testing05.equip.service;

import java.util.List;

import com.lsh.testing05.equip.vo.EquipVO;


public interface EquipService {

	public List<EquipVO> EquipMatchingList(EquipVO vo) throws Exception;
	
	public void EquipSensorMatching(EquipVO vo) throws Exception;
	
	public void EquipSensorMatchingDelete(EquipVO vo) throws Exception;
	
	public List<EquipVO> EquipSensorList(EquipVO vo) throws Exception;
	
	public List<EquipVO> EquipIndexList(EquipVO vo) throws Exception;
	
	public List<EquipVO> SelectEquipList(EquipVO vo) throws Exception;
	
	public List<EquipVO> SelectWorkerEquip(EquipVO vo) throws Exception;
	
	public void RegisterEquip(EquipVO vo) throws Exception;

	public List<EquipVO> AllselectEquip() throws Exception;
	
	public void UpdateEquip(EquipVO vo) throws Exception;
	
	public void DeleteEquip(EquipVO vo) throws Exception;
	
	public int ProcessIdChk(EquipVO vo) throws Exception;
	
	public List<EquipVO> SearchEquip(EquipVO vo) throws Exception;
	
	public int EquipIdCheck(EquipVO vo) throws Exception;
	
	public List<EquipVO> SelectProcessEquip(EquipVO vo) throws Exception;
}
