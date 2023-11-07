package com.lsh.testing05.graph.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.lsh.testing05.graph.dao.GraphDAO;
import com.lsh.testing05.graph.vo.GraphVO;

@Service
public class GraphServiceImpl implements GraphService {

	@Inject
	GraphDAO dao;
	
	//검색용
	public List<GraphVO> SearchGraph(GraphVO vo) throws Exception {
		
		return dao.SearchGraph(vo);
	}
	
	//리스트용
	public List<GraphVO> ProcessList(GraphVO vo) throws Exception {
		
		return dao.ProcessList(vo);
		
	}
	
	public List<GraphVO> EquipmentList(GraphVO vo) throws Exception {
		
		return dao.EquipmentList(vo);
	}
	
	public List<GraphVO> MaterialList(GraphVO vo) throws Exception {
		
		return dao.MaterialList(vo);
		
	}
	
	public List<GraphVO> ODRangeList(GraphVO vo) throws Exception {
		
		return dao.ODRangeList(vo);
		
	}
	
	public List<GraphVO> ThicknessList(GraphVO vo) throws Exception {
		
		return dao.ThicknessList(vo);
	}
}
