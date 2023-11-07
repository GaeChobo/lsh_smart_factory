package com.lst.testing05.customer.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.lst.testing05.customer.vo.CustomerVO;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Inject
	private SqlSession sqlsession;
	
	private static final String namespace = "mapper.customerMapper";
	
	//거래처 검색1
	public List<CustomerVO> SearchCustomerAll(CustomerVO vo) throws Exception {
		List<CustomerVO> result = sqlsession.selectList(namespace+".SearchCustomerAll", vo);
		return result;
	}
	
	//거래처 검색2 (외주업체)
	public List<CustomerVO> SearchCustomer_1(CustomerVO vo) throws Exception {
		List<CustomerVO> result = sqlsession.selectList(namespace+".SearchCustomer_1", vo);
		return result;
	}
	
	//거래처 검색3 (납품처)
	public List<CustomerVO> SearchCustomer_2(CustomerVO vo) throws Exception {
		List<CustomerVO> result = sqlsession.selectList(namespace+".SearchCustomer_2", vo);
		return result;
	}
	
	//거래처 등록
	@Override
	public void RegisterCustomer(CustomerVO vo) throws Exception {
		sqlsession.insert(namespace+".RegisterCustomer", vo);
	}
	
	//모든 거래처 조회
	@Override
	public List<CustomerVO> AllSelectCustomer() throws Exception {
		List<CustomerVO> result = sqlsession.selectList(namespace+".AllSelectCustomer");
		return result;
	}
	
	//거래처 검색
	@Override
	public List<CustomerVO> SearchCustomer(CustomerVO vo) throws Exception {
		List<CustomerVO> result = sqlsession.selectList(namespace+".SearchCustomer", vo);
		return result;
	}
	
	//거래처 삭제
	@Override
	public void DeleteCustomer(CustomerVO vo) throws Exception {
		sqlsession.delete(namespace+".DeleteCustomer", vo);
	}
	
	//거래처 수정
	@Override
	public void UpdateCustomer(CustomerVO vo) throws Exception {
		sqlsession.update(namespace+".UpdateCustomer", vo);
	}
}
