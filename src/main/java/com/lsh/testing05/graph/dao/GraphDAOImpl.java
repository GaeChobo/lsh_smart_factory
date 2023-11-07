package com.lsh.testing05.graph.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.lsh.testing05.graph.vo.GraphVO;

@Repository
public class GraphDAOImpl implements GraphDAO {

	@Inject
	private SqlSession sqlsession;
	
	public static final String namespace = "mapper.graphMapper";
	
	
	@Override
	public List<GraphVO> SearchGraph(GraphVO vo) throws Exception {
		
		List<GraphVO> resultList = sqlsession.selectList(namespace+".SearchGraph", vo);
		return resultList;
	}
	
	@Override
	public List<GraphVO> ProcessList(GraphVO vo) throws Exception {
		List<GraphVO> resultList = sqlsession.selectList(namespace+".ProcessList", vo);
		return resultList;
	}
	
	@Override
	public List<GraphVO> EquipmentList(GraphVO vo) throws Exception {
		List<GraphVO> resultList = sqlsession.selectList(namespace+".EquipmentList", vo);
		return resultList;
	}
	
	@Override
	public List<GraphVO> MaterialList(GraphVO vo) throws Exception {
		List<GraphVO> resultList = sqlsession.selectList(namespace+".MaterialList", vo);
		return resultList;
	}
	
	@Override
	public List<GraphVO> ODRangeList(GraphVO vo) throws Exception {
		List<GraphVO> resultList = sqlsession.selectList(namespace+".ODRangeList", vo);
		return resultList;
	}
	
	@Override
	public List<GraphVO> ThicknessList(GraphVO vo) throws Exception {
		List<GraphVO> resultList = sqlsession.selectList(namespace+".ThicknessList", vo);
		return resultList;
	}
}
