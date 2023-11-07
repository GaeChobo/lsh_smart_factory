package com.lsh.testing05;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.lsh.testing05.handler.MyExceptionHandler;
import com.lsh.testing05.uniquess.exception.UniquessDeleteException;
import com.lsh.testing05.uniquess.exception.UniquessRegisterException;
import com.lsh.testing05.uniquess.exception.UniquessSearchmatchException;
import com.lsh.testing05.uniquess.exception.UniquessUpdateException;
import com.lsh.testing05.uniquess.service.UniquessService;
import com.lsh.testing05.uniquess.vo.UniquessVO;

@RestController
public class UniquessController extends MyExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(UniquessController.class);
	
	@Inject
	UniquessService service;
	
	@RequestMapping(value = "/SearchUniquessWord", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public List<UniquessVO> SearchUniquessWord(@RequestBody UniquessVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);
		
		logger.info(time1+"SearchUniquessWord");
		
		return service.SearchUniquessWord(vo);
	}

	
	@RequestMapping(value = "/FindUniquess", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public List<UniquessVO> FindUniquess(@RequestBody UniquessVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);
		
		logger.info(time1+"FindUniquess");
		
		return service.SearchUniquess(vo);
		
	}

	
	
	@RequestMapping(value = "/SearchUniquess", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public List<UniquessVO> SearchUniquess(@RequestBody UniquessVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);
		
		logger.info(time1+"Search Uniquess");
		
		try {
			return service.SearchUniquess(vo);
		} catch (Exception e) {
			throw new UniquessSearchmatchException();
		}
	}
	
	@RequestMapping(value = "/RegisterUniquess", method =RequestMethod.POST, produces="application/json;charset=utf-8") 
	public String RegisterUniquess(@RequestBody UniquessVO vo) throws Exception {
		
		logger.info("Register Uniquess");
		
		try {
			service.RegisterUniquess(vo);
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("ORIGIN_UNIQUESS_ID", vo.ORIGIN_UNIQUESS_ID);
			obj.addProperty("RegisterUniquess", 1);
			
			return obj.toString();
			
		} catch (Exception e) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("RegisterUniquess", 0);
			
			return obj.toString();
		}
		
	}
	
	@RequestMapping(value = "/UpdateUniquess", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String UpdateUniquess(@RequestBody UniquessVO vo) throws Exception {
		
		logger.info("Update Uniquess");
			
		int result = service.UniquessIdChk(vo);
		if (result == 0) {
			
			JsonObject obj = new JsonObject();
			obj.addProperty("UpdateUniquess", 0);
			
			return obj.toString();
			
		}else {
			
			service.UpdateUniquess(vo);
			
			JsonObject obj = new JsonObject();
			obj.addProperty("UpdateUniquess", 1);
			
			return obj.toString();
		}
		
	}
	
	@RequestMapping(value = "/DeleteUniquess", method = RequestMethod.POST,produces = "application/json;charset=utf-8" )
	public String DeleteUniquess(@RequestBody UniquessVO vo) throws Exception {
		
		logger.info("DeleteUniquess");
		
		
		int result = service.UniquessIdChk(vo);
		if (result == 0) {
			
			JsonObject obj = new JsonObject();
			obj.addProperty("DeleteUniquess", 0);
			
			return obj.toString();
		}else {
			
			try {
				service.DeleteUniquess(vo);
				
				JsonObject obj = new JsonObject();
				obj.addProperty("DeleteUniquess", 1);
				
				return obj.toString();
				
			} catch(Exception e) {
				
				JsonObject obj = new JsonObject();
				obj.addProperty("DeleteUniquess", 0);
				
				return obj.toString();
			}

		}
		
	}
	
	@ResponseBody
	@RequestMapping(value = "UniquessIdChk", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
	public int UniquessIdChk(@RequestBody UniquessVO vo) throws Exception {
		int result = service.UniquessIdChk(vo);
		return result;
	}
	
}
