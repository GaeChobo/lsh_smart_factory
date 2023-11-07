package com.lst.testing05.customer.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.lst.testing05.customer.dao.CustomerDAO;
import com.lst.testing05.customer.vo.CustomerVO;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Inject
	CustomerDAO dao;
	
	
	//거래처 검색1
	public List<CustomerVO> SearchCustomerAll(CustomerVO vo) throws Exception {
		List<CustomerVO> result = dao.SearchCustomerAll(vo);
		return result;
	}
	
	//거래처 검색2 (외주업체)
	public List<CustomerVO> SearchCustomer_1(CustomerVO vo) throws Exception {
		List<CustomerVO> result = dao.SearchCustomer_1(vo);
		return result;
	}
	
	//거래처 검색3 (납품처)
	public List<CustomerVO> SearchCustomer_2(CustomerVO vo) throws Exception {
		List<CustomerVO> result = dao.SearchCustomer_2(vo);
		return result;
	}
	
	//거래처 등록
		@Override
		public void RegisterCustomer(CustomerVO vo) throws Exception {
			dao.RegisterCustomer(vo);
		}
		
		//모든 거래처 조회
		@Override
		public List<CustomerVO> AllSelectCustomer() throws Exception {
			List<CustomerVO> result = dao.AllSelectCustomer();
			return result;
		}
		
		//거래처 검색
		@Override
		public List<CustomerVO> SearchCustomer(CustomerVO vo) throws Exception {
			List<CustomerVO> result = dao.SearchCustomer(vo);
			return result;
		}
		
		//거래처 삭제
		@Override
		public void DeleteCustomer(CustomerVO vo) throws Exception {
			dao.DeleteCustomer(vo);
		}
		
		//거래처 수정
		@Override
		public void UpdateCustomer(CustomerVO vo) throws Exception {
			dao.UpdateCustomer(vo);
		}
}
