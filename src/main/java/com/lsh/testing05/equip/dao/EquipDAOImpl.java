package com.lsh.testing05.equip.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.lsh.testing05.equip.vo.EquipVO;


@Repository
public class EquipDAOImpl implements EquipDAO {
	
	@Inject
	private SqlSession sqlsession;
	
	public static final String namespace = "mapper.equipMapper";
	
	@Override
	public List<EquipVO> EquipMatchingList(EquipVO vo) throws Exception {
		
		List<EquipVO> result = sqlsession.selectList(namespace+".EquipMatchingList", vo);
		return result;
	}
	
	@Override
	public void EquipSensorMatching(EquipVO vo) throws Exception {
		
		sqlsession.update(namespace+".EquipSensorMatching", vo);

	}
	
	@Override
	public void EquipSensorMatchingDelete(EquipVO vo) throws Exception {
		
		sqlsession.update(namespace+".EquipSensorMatchingDelete", vo);

	}
	
	@Override
	public List<EquipVO> EquipSensorList(EquipVO vo) throws Exception {
		
		List<EquipVO> result = sqlsession.selectList(namespace+".EquipSensorList", vo);
		return result;
	}
	
	@Override
	public List<EquipVO> EquipIndexList(EquipVO vo) throws Exception {
		
		List<EquipVO> result = sqlsession.selectList(namespace+".EquipIndexList", vo);
		return result;
	}
	
	@Override
	public List<EquipVO> SelectEquipList(EquipVO vo) throws Exception {
		
		List<EquipVO> result = sqlsession.selectList(namespace+".SelectEquipList", vo);
		return result;
	}
	
	@Override
	public List<EquipVO> SelectWorkerEquip(EquipVO vo) throws Exception {
		
		List<EquipVO> result = sqlsession.selectList(namespace+".SelectWorkerEquip", vo);
		return result;
	}
	
	@Override
	public void RegisterEquip(EquipVO vo) throws Exception {
		sqlsession.insert(namespace+".RegisterEquip", vo);
	}
	
	@Override
	public List<EquipVO> AllselectEquip() throws Exception  {
		List<EquipVO> equiplist = sqlsession.selectList(namespace+".AllselectEquip");
		return equiplist;
	}
	
	@Override
	public void UpdateEquip(EquipVO vo) throws Exception {
		sqlsession.update(namespace+".UpdateEquip", vo);
	}
	
	@Override
	public void DeleteEquip(EquipVO vo) throws Exception {
		sqlsession.delete(namespace+".DeleteEquip", vo);
	}
	
	@Override
	public int ProcessIdChk(EquipVO vo) throws Exception {
		int result = sqlsession.selectOne(namespace+".ProcessIdChk", vo);
		return result;
	}
	
	@Override
	public List<EquipVO> SearchEquip(EquipVO vo) throws Exception {
		List<EquipVO> equiplist = sqlsession.selectList(namespace+".SearchEquip", vo);
		return equiplist;
	}
	
	@Override
	public int EquipIdCheck(EquipVO vo) throws Exception {
		int result = sqlsession.selectOne(namespace+".EquipIdCheck", vo);
		return result;
	}
	
	@Override
	public List<EquipVO> SelectProcessEquip(EquipVO vo) throws Exception {
		List<EquipVO> equiplist = sqlsession.selectList(namespace+".SelectProcessEquip", vo);
		return equiplist;
	}
}
