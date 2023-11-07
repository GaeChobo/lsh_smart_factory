package com.lsh.testing05.graph.service;

import java.util.List;

import com.lsh.testing05.graph.vo.GraphVO;

public interface GraphService {

	//검색용
	public List<GraphVO> SearchGraph(GraphVO vo) throws Exception;
	
	//리스트용
	public List<GraphVO> ProcessList(GraphVO vo) throws Exception;
	
	public List<GraphVO> EquipmentList(GraphVO vo) throws Exception;
	
	public List<GraphVO> MaterialList(GraphVO vo) throws Exception;
	
	public List<GraphVO> ODRangeList(GraphVO vo) throws Exception;
	
	public List<GraphVO> ThicknessList(GraphVO vo) throws Exception;
	
}
