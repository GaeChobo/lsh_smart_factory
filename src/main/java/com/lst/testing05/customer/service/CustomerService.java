package com.lst.testing05.customer.service;

import java.util.List;

import com.lst.testing05.customer.vo.CustomerVO;

public interface CustomerService {
	
	//거래처 검색1
	public List<CustomerVO> SearchCustomerAll(CustomerVO vo) throws Exception;
	
	//거래처 검색2 (외주업체)
	public List<CustomerVO> SearchCustomer_1(CustomerVO vo) throws Exception;
	
	//거래처 검색3 (납품처)
	public List<CustomerVO> SearchCustomer_2(CustomerVO vo) throws Exception;
	
	//거래처 등록
	public void RegisterCustomer(CustomerVO vo) throws Exception;
	
	//모든 거래처 조회
	public List<CustomerVO> AllSelectCustomer() throws Exception;
	
	//거래처 검색
	public List<CustomerVO> SearchCustomer(CustomerVO vo) throws Exception;
	
	//거래처 삭제
	public void DeleteCustomer(CustomerVO vo) throws Exception;
	
	//거래처 수정
	public void UpdateCustomer(CustomerVO vo) throws Exception;
}
