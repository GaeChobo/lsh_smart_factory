package com.lsh.testing05.equip.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.lsh.testing05.equip.dao.EquipDAO;
import com.lsh.testing05.equip.vo.EquipVO;

@Service
public class EquipServiceImpl implements EquipService {

	@Inject
	EquipDAO dao;
	
	
	@Override
	public List<EquipVO> EquipMatchingList(EquipVO vo) throws Exception {
		
		List<EquipVO> result = dao.EquipMatchingList(vo);
		return result;
	}
	
	@Override
	public void EquipSensorMatching(EquipVO vo) throws Exception {
		
		dao.EquipSensorMatching(vo);
	}
	
	@Override
	public void EquipSensorMatchingDelete(EquipVO vo) throws Exception {
		
		dao.EquipSensorMatchingDelete(vo);
	}
	
	@Override
	public List<EquipVO> EquipSensorList(EquipVO vo) throws Exception {
		
		List<EquipVO> result = dao.EquipSensorList(vo);
		return result;
	}
	
	@Override
	public List<EquipVO> EquipIndexList(EquipVO vo) throws Exception {
		
		List<EquipVO> result = dao.EquipIndexList(vo);
		return result;
	}
	
	@Override
	public List<EquipVO> SelectEquipList(EquipVO vo) throws Exception {
		
		List<EquipVO> result = dao.SelectEquipList(vo);
		return result;
	}
	
	@Override
	public List<EquipVO> SelectWorkerEquip(EquipVO vo) throws Exception {
		
		List<EquipVO> result = dao.SelectWorkerEquip(vo);
		return result;
	}
	
	@Override
	public void RegisterEquip(EquipVO vo) throws Exception {
		
		dao.RegisterEquip(vo);
	}
	
	@Override
	public List<EquipVO> AllselectEquip() throws Exception {
		
		return dao.AllselectEquip();
	}
	
	@Override
	public void UpdateEquip(EquipVO vo) throws Exception {
		
		dao.UpdateEquip(vo);
	}
	
	@Override
	public void DeleteEquip(EquipVO vo) throws Exception {
		
		dao.DeleteEquip(vo);
	}
	
	@Override
	public int ProcessIdChk(EquipVO vo) throws Exception {
		
		int result =dao.ProcessIdChk(vo);
		return result;
	}
	
	@Override
	public List<EquipVO> SearchEquip(EquipVO vo) throws Exception {
		
		return dao.SearchEquip(vo);
	}
	
	@Override
	public int EquipIdCheck(EquipVO vo) throws Exception {
		
		int result = dao.EquipIdCheck(vo);
		return result;
	}
	
	public List<EquipVO> SelectProcessEquip(EquipVO vo) throws Exception {
		
		return dao.SelectProcessEquip(vo);
	}
}
