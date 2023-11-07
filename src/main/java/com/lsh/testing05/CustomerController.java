package com.lsh.testing05;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.lst.testing05.customer.service.CustomerService;
import com.lst.testing05.customer.vo.CustomerVO;


@RestController
public class CustomerController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Inject
	CustomerService service;
	
	@RequestMapping(value = "/TestCustomer", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public void TestCustomer(CustomerVO vo, @RequestParam("CUSTOMER_NAME") String CUSTOMER_NAME, @RequestParam("CUSTOMER_NUMBER") String CUSTOMER_NUMBER) throws Exception {
		
		logger.info("TestCustomer");
		
		String IncodingA = new String(CUSTOMER_NAME.getBytes("8859_1"), "UTF-8");
		
		System.out.println(IncodingA);
		
		String IncodingB = new String(CUSTOMER_NUMBER.getBytes("8859_1"), "UTF-8");
		
		System.out.println(IncodingB);
		
		vo.setCUSTOMER_NAME(IncodingA);
		vo.setCUSTOMER_NUMBER(IncodingB);
		
		service.RegisterCustomer(vo);
	}

	
	@RequestMapping(value = "/RegisterCustomer", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public String RegisterCustomer(@RequestBody CustomerVO vo) throws Exception {
		
		SimpleDateFormat format1 = new  SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "RegisterCustomer");
		
		try {
		
			service.RegisterCustomer(vo);          
		
			JsonObject obj = new JsonObject();
			
			obj.addProperty("RegisterCustomer", 1);
			
			return obj.toString();
			
			
		} catch(Exception e) {
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("RegisterCustomer", 0);
			
			return obj.toString();
		}
		
		
		
	}
	

	@RequestMapping(value = "/AllSelectCustomer", method = RequestMethod.GET, produces="application/json;charset=utf-8")
	public List<CustomerVO> AllSelectCustomer() throws Exception {
		
		
		logger.info("AllSelectCustomer");
		
		return service.AllSelectCustomer();
		
	}

	@RequestMapping(value = "/SearchCustomer", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public List<CustomerVO> SearchCustomer(@RequestBody CustomerVO vo) throws Exception {
		
		logger.info("SearchCustomer");
		
		System.out.println(vo.getCUSTOMER_INDEXNAME());
		
		if(vo.getCUSTOMER_INDEXNAME().equals("")) {
			System.out.println("전체로빠짐");
			return service.SearchCustomerAll(vo);
		}
		
		if(vo.getCUSTOMER_INDEXNAME().equals("외주업체")) {
			System.out.println("외주로빠짐");
			return service.SearchCustomer_1(vo);
		}

		if(vo.getCUSTOMER_INDEXNAME().equals("납품처")) {
			System.out.println("납품처로빠짐");
			return service.SearchCustomer_2(vo);
		}
		
		return null;
		
	}
	
	@RequestMapping(value = "/DeleteCustomer", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public String DeleteCustomer(@RequestBody CustomerVO vo) throws Exception {
		
		SimpleDateFormat format1 = new  SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "DeleteCustomer");
		
		try {
			
			service.DeleteCustomer(vo);
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("DeleteCustomer", 1);
			
			return obj.toString();
			
		} catch (Exception e) {
		
			JsonObject obj = new JsonObject();
			
			obj.addProperty("DeleteCustomer", 0);
			
			return obj.toString();
		}
		
	}
	
	@RequestMapping(value = "/UpdateCustomer", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public String UpdateCustomer(@RequestBody CustomerVO vo) throws Exception {
		
		SimpleDateFormat format1 = new  SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "UpdateCustomer");
		
		try {
			
			service.UpdateCustomer(vo);
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("UpdateCustomer", 1);
			
			return obj.toString();
			
		} catch(Exception e) {
				
			JsonObject obj = new JsonObject();
			
			obj.addProperty("UpdateCustomer", 0);
			
			return obj.toString();
		}
		
	}
}
