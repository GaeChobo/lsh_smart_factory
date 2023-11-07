package com.lsh.testing05;

import java.io.File;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.JsonObject;
import com.lsh.testing05.equip.service.EquipService;
import com.lsh.testing05.handler.MyExceptionHandler;
import com.lsh.testing05.process.exception.ProcessDeleteException;
import com.lsh.testing05.process.exception.ProcessNameCheckException;
import com.lsh.testing05.process.exception.ProcessRegisterException;
import com.lsh.testing05.process.exception.ProcessSearchException;
import com.lsh.testing05.process.exception.ProcessSelectException;
import com.lsh.testing05.process.exception.ProcessUpdateException;
import com.lsh.testing05.process.service.ProcessService;
import com.lsh.testing05.process.vo.ProcessVO;


@RestController
public class ProcessController extends MyExceptionHandler{
	
	private static final Logger logger = LoggerFactory.getLogger(ProcessController.class);
	
	@Inject
	ProcessService service;
	
	@Inject
	EquipService service2;
	
	@RequestMapping(value = "/AllselectProcess", method = RequestMethod.GET, produces="application/json;charset=utf-8")
	@ResponseBody
	public List<ProcessVO> AllSelectProcess() throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");
		
		Date time = new Date();
				
		String time1 = format1.format(time);
		
		logger.info(time + "Get Process List");
		try {
			return service.AllselectProcess();
		}catch (Exception e) {
			throw new ProcessSelectException();
		}
	}
	
	@RequestMapping(value = "/SelectMatchingProcess", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public List<ProcessVO> SelectMatchingProcess(@RequestBody ProcessVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");
		
		Date time = new Date();
				
		String time1 = format1.format(time);
		
		logger.info(time + "SelectMatchingProcess");
		
		return service.SelectMatchingProcess(vo);
	}

	
	@RequestMapping(value = "/MainProcessList", method = RequestMethod.GET, produces="application/json;charset=utf-8")
	public List<ProcessVO> MainProcessList(ProcessVO vo) throws Exception {
		
		logger.info("Get MainProcess List");
		
		return service.MainProcessList(vo);

	}

	@RequestMapping(value = "/MainCategoryRegister", method = RequestMethod.POST, produces="application/json;charset=utf-8") 
	public String MainCategoryRegister(@RequestBody ProcessVO vo) throws Exception {
		
		logger.info("Register MainCategoryRegister");
		
		int result = service.MainProcessChk(vo);
		
		if(result >= 1) {
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("MainCategoryRegister", 0);
			
			return obj.toString();
			
		}else {
			
			service.MainCategoryRegister(vo);
			
			int PROCESS_MAIN_CATEGORY_ID = vo.PROCESS_MAIN_CATEGORY_ID;
			
			vo.setPROCESS_MAIN_CATEGORY_ID(PROCESS_MAIN_CATEGORY_ID);
			
			vo.setORIGIN_EQUIPMENT_NAME("해당없음");
			vo.setORIGIN_EQUIPMENT_MODELNAME("해당없음");
			vo.setORIGIN_EQUIPMENT_CONTEXT("해당없음");
			
			service.NewEquipRegister(vo);
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("MainCategoryRegister", 1);
			
			return obj.toString();
		}
		
		
		
	}

	@RequestMapping(value = "NameChkProcess", method = RequestMethod.POST, produces="application/json;charset=utf-8") 
	@ResponseBody
	public int NameChkProcess(@RequestBody ProcessVO vo) throws Exception {
		int result = service.NameChkProcess(vo);
		return result;
	}
	
	@RequestMapping(value = "IdChkProcess", method = RequestMethod.POST, produces="application/json;charset=utf-8") 
	@ResponseBody
	public int IdChkProcess(ProcessVO vo) throws Exception {
		int result = service.IdChkProcess(vo);
		return result;
	}
	
	/*
	@RequestMapping(value = "/AllRegister", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public void AllRegister(@RequestBody ProcessVO vo) throws Exception {
		
		logger.info("All Register");
		
		int MAINCATEGORY = vo.getPROCESS_MAIN_CATEGORY_ID();
		
		
		service.RegisterProcess(vo);
		
		
		
		int PROCESS_ID = vo.ORIGIN_PROCESS_ID;
		
		if(vo.get)
		
		//설비 등록
		vo.setPROCESS_MAIN_CATEGORY_ID(MAINCATEGORY);
		service.ALLRegisterEquip(vo);
		
		//작업특이사항 등록
		
		
		
	}
	
	*/
	
	@RequestMapping(value = "/RegisterProcess", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public String RegisterProcess(@RequestBody ProcessVO vo) throws Exception {
		logger.info("Register Process");
		

		int result = service.NameChkProcess(vo);
		int result2 = service.CodeCkhProcess(vo);
		
		
		try {
			
			if (result >= 1 || result2 >= 1) {
				
				logger.info("[중복] 공정 생성  실패");
				
				JsonObject obj = new JsonObject();
				
				obj.addProperty("ProcessRegisterON", 0);
				
				return obj.toString();
				
			} else if(result == 0)  {
				
				vo.setORIGIN_PROCESS_SELF_INSPECTION_REPORT_REGISTER(0);
				
				service.RegisterProcess(vo);
				
				int NewProcessID = vo.ORIGIN_PROCESS_ID;
				
				vo.setORIGIN_PROCESS_ID(NewProcessID);
				
				service.AutoBellowsMatchingID(vo);
				
				//필요없음
				//service.AutoTotalMatchingID(vo);
				
				JsonObject obj = new JsonObject();
				
				obj.addProperty("ProcessRegisterON", 1);
				
				return obj.toString();
			}
	}	catch(Exception e) {
			

	}
		return null;
	}
	
	
	
	@RequestMapping(value = "/UpdateProcess", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public String UpdateProcess(ProcessVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");
	
		Date time = new Date();
		
		String time1 = format1.format(time);
		
		logger.info(time1 + "Update Process");
		
		System.out.println("원본공정ID"+vo.getORIGIN_PROCESS_ID());
		System.out.println("공정대분류식별키"+ vo.getPROCESS_MAIN_CATEGORY_ID());
		System.out.println("원본공정명"+ vo.getORIGIN_PROCESS_NAME());
		System.out.println("원본 공정코드" + vo.getORIGIN_PROCESS_NAME());
		System.out.println("공정 외주 허용키" + vo.getORIGIN_PROCESS_OUTSOURCING_REGISTER());
		System.out.println("공정 자주검사 허용키" + vo.getORIGIN_PROCESS_SELF_INSPECTION_REPORT_REGISTER());
		System.out.println("공정 자주검사 HTML 코드" + vo.getORIGIN_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY());
		System.out.println("공정 거래처명" + vo.getORIGIN_PROCESS_CUSTOMER_NAME());
		System.out.println("공정 거래처번호" + vo.getORIGIN_PROCESS_CUSTOMER_NUMBER());
		
		
		
		//자주검사 파일 허용 O + 외주 공정 사용 X
		if(vo.getORIGIN_PROCESS_OUTSOURCING_REGISTER() == 0) {
					
			//인코딩 공정명
			String IncodingORIGIN_PROCESS_NAME = new String(vo.getORIGIN_PROCESS_NAME().getBytes("8859_1"), "UTF-8");
			
			vo.setORIGIN_PROCESS_NAME(IncodingORIGIN_PROCESS_NAME);
			//vo.setORIGIN_PROCESS_NAME(vo.getORIGIN_PROCESS_NAME());	
			
			//인코딩 공정코드
			String IncodingORIGIN_PROCESS_CODE = new String(vo.getORIGIN_PROCESS_CODE().getBytes("8859_1"), "UTF-8");
			
			vo.setORIGIN_PROCESS_CODE(IncodingORIGIN_PROCESS_CODE);
			//vo.setORIGIN_PROCESS_CODE(vo.getORIGIN_PROCESS_CODE());
			
			
			//인코딩 자주검사 HTML코드
			String IncodingORIGIN_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY = new String(vo.getORIGIN_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY().getBytes("8859_1"), "UTF-8");
			
			vo.setORIGIN_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY(IncodingORIGIN_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY);
			//vo.setORIGIN_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY(vo.getORIGIN_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY());
			
			vo.setORIGIN_PROCESS_CUSTOMER_NAME(null);
			vo.setORIGIN_PROCESS_CUSTOMER_NUMBER(null);	
					
		//자주검사 파일 허용 O + 외주 공정 사용 O
		}else {
					
			//인코딩 공정명
			String IncodingORIGIN_PROCESS_NAME = new String(vo.getORIGIN_PROCESS_NAME().getBytes("8859_1"), "UTF-8");
			
			//vo.setORIGIN_PROCESS_NAME(vo.getORIGIN_PROCESS_NAME());	
			vo.setORIGIN_PROCESS_NAME(IncodingORIGIN_PROCESS_NAME);
					
			//인코딩 공정코드
			String IncodingORIGIN_PROCESS_CODE = new String(vo.getORIGIN_PROCESS_CODE().getBytes("8859_1"), "UTF-8");
			
			//vo.setORIGIN_PROCESS_CODE(vo.getORIGIN_PROCESS_CODE());
			vo.setORIGIN_PROCESS_CODE(IncodingORIGIN_PROCESS_CODE);
					
			//인코딩 거래처명
			String IncodingORIGIN_PROCESS_CUSTOMER_NAME = new String(vo.getORIGIN_PROCESS_CUSTOMER_NAME().getBytes("8859_1"), "UTF-8");
		
			//vo.setORIGIN_PROCESS_CUSTOMER_NAME(vo.getORIGIN_PROCESS_CUSTOMER_NAME());
			vo.setORIGIN_PROCESS_CUSTOMER_NAME(IncodingORIGIN_PROCESS_CUSTOMER_NAME);
					
			//인코딩 사업자번호
			String IncodingORIGIN_PROCESS_CUSTOMER_NUMBER = new String(vo.getORIGIN_PROCESS_CUSTOMER_NUMBER().getBytes("8859_1"), "UTF-8");
			
			//vo.setORIGIN_PROCESS_CUSTOMER_NUMBER(vo.getORIGIN_PROCESS_CUSTOMER_NUMBER());
			vo.setORIGIN_PROCESS_CUSTOMER_NUMBER(IncodingORIGIN_PROCESS_CUSTOMER_NUMBER);
			
			//인코딩 자주검사 HTML코드
			String IncodingORIGIN_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY = new String(vo.getORIGIN_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY().getBytes("8859_1"), "UTF-8");
			
			//vo.setORIGIN_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY(vo.getORIGIN_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY());
			vo.setORIGIN_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY(IncodingORIGIN_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY);
		}
				
		service.UpdateProcess(vo);
				
		JsonObject obj = new JsonObject();
				
		obj.addProperty("ProcessUpdateOn", 1);
				
		return obj.toString();
			
	}
	@RequestMapping(value = "/DeleteProcess", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public String DeleteProcess(@RequestBody ProcessVO vo) throws Exception {
		
		logger.info("Delete Process");

		try {
			
			if(vo.getORIGIN_PROCESS_ID() == 17) {
				JsonObject obj = new JsonObject();
				obj.addProperty("AllDeleteProcess", 3);
				
				return obj.toString();
			}
			else if(vo.getORIGIN_PROCESS_ID() == 18) {
				JsonObject obj = new JsonObject();
				obj.addProperty("AllDeleteProcess", 3);
				
				return obj.toString();
			}
			else if(vo.getORIGIN_PROCESS_ID() == 20) {
				JsonObject obj = new JsonObject();
				obj.addProperty("AllDeleteProcess", 3);
				
				return obj.toString();
			}
			else if(vo.getORIGIN_PROCESS_ID() == 21) {
				JsonObject obj = new JsonObject();
				obj.addProperty("AllDeleteProcess", 3);
				
				return obj.toString();
			}
			else if(vo.getORIGIN_PROCESS_ID() == 22) {
				JsonObject obj = new JsonObject();
				obj.addProperty("AllDeleteProcess", 3);
				
				return obj.toString();
			}
			else if(vo.getORIGIN_PROCESS_ID() == 23) {
				JsonObject obj = new JsonObject();
				obj.addProperty("AllDeleteProcess", 3);
				
				return obj.toString();
			}
			else if(vo.getORIGIN_PROCESS_ID() == 24) {
				JsonObject obj = new JsonObject();
				obj.addProperty("AllDeleteProcess", 3);
				
				return obj.toString();
			}
			else if(vo.getORIGIN_PROCESS_ID() == 25) {
				JsonObject obj = new JsonObject();
				obj.addProperty("AllDeleteProcess", 3);
				
				return obj.toString();
			}
			else if(vo.getORIGIN_PROCESS_ID() == 26) {
				JsonObject obj = new JsonObject();
				obj.addProperty("AllDeleteProcess", 3);
				
				return obj.toString();
			}
			else if(vo.getORIGIN_PROCESS_ID() == 27) {
				JsonObject obj = new JsonObject();
				obj.addProperty("AllDeleteProcess", 3);
				
				return obj.toString();
			}
			else if(vo.getORIGIN_PROCESS_ID() == 28) {
				JsonObject obj = new JsonObject();
				obj.addProperty("AllDeleteProcess", 3);
				
				return obj.toString();
			} else {
				
				int PROCESS_ID = vo.getORIGIN_PROCESS_ID();
				
				vo.setORIGIN_PROCESS_ID(PROCESS_ID);
				
				service.DeleteMatchingID(vo);
				
				service.DeleteProcess(vo);
				JsonObject obj = new JsonObject();
				obj.addProperty("DeleteProcess", 1);
				
				return obj.toString();
			}
					
		}catch (Exception e) {
			JsonObject obj = new JsonObject();
			obj.addProperty("DeleteProcess", 0);
			
			return obj.toString();
		}
	}
	
	@RequestMapping(value = "/AllDeleteProcess", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public String AllDeleteProcess(@RequestBody ProcessVO vo) throws Exception {
		
		logger.info("Delete All About Process");
		
		try {
			
			int result = service.PresetChkProcess(vo);
			
			if(vo.getORIGIN_PROCESS_ID() == 17) {
				JsonObject obj = new JsonObject();
				obj.addProperty("AllDeleteProcess", 3);
				
				return obj.toString();
			}
			else if(vo.getORIGIN_PROCESS_ID() == 18) {
				JsonObject obj = new JsonObject();
				obj.addProperty("AllDeleteProcess", 3);
				
				return obj.toString();
			}
			else if(vo.getORIGIN_PROCESS_ID() == 20) {
				JsonObject obj = new JsonObject();
				obj.addProperty("AllDeleteProcess", 3);
				
				return obj.toString();
			}
			else if(vo.getORIGIN_PROCESS_ID() == 21) {
				JsonObject obj = new JsonObject();
				obj.addProperty("AllDeleteProcess", 3);
				
				return obj.toString();
			}
			else if(vo.getORIGIN_PROCESS_ID() == 22) {
				JsonObject obj = new JsonObject();
				obj.addProperty("AllDeleteProcess", 3);
				
				return obj.toString();
			}
			else if(vo.getORIGIN_PROCESS_ID() == 23) {
				JsonObject obj = new JsonObject();
				obj.addProperty("AllDeleteProcess", 3);
				
				return obj.toString();
			}
			else if(vo.getORIGIN_PROCESS_ID() == 24) {
				JsonObject obj = new JsonObject();
				obj.addProperty("AllDeleteProcess", 3);
				
				return obj.toString();
			}
			else if(vo.getORIGIN_PROCESS_ID() == 25) {
				JsonObject obj = new JsonObject();
				obj.addProperty("AllDeleteProcess", 3);
				
				return obj.toString();
			}
			else if(vo.getORIGIN_PROCESS_ID() == 26) {
				JsonObject obj = new JsonObject();
				obj.addProperty("AllDeleteProcess", 3);
				
				return obj.toString();
			}
			else if(vo.getORIGIN_PROCESS_ID() == 27) {
				JsonObject obj = new JsonObject();
				obj.addProperty("AllDeleteProcess", 3);
				
				return obj.toString();
			}
			else if(vo.getORIGIN_PROCESS_ID() == 28) {
				JsonObject obj = new JsonObject();
				obj.addProperty("AllDeleteProcess", 3);
				
				return obj.toString();
			}
			
			else if(result >= 1) {
				
				System.out.println(result);
				
				JsonObject obj = new JsonObject();
				obj.addProperty("AllDeleteProcess", 2);
				
				return obj.toString();
				
			}
			else {
				
				int PROCESS_ID = vo.getORIGIN_PROCESS_ID();
				
				vo.setORIGIN_PROCESS_ID(PROCESS_ID);
				
				service.AllDeleteUniquess(vo);
				
				vo.setORIGIN_PROCESS_ID(PROCESS_ID);
				
				service.DeleteMatchingID(vo);
				
				vo.setORIGIN_PROCESS_ID(PROCESS_ID);
				
				service.DeleteProcess(vo);
				
				
				
				JsonObject obj = new JsonObject();
				obj.addProperty("AllDeleteProcess", 1);
				
				return obj.toString();
				
			}


		}catch(Exception e) {
			
			JsonObject obj = new JsonObject();
			obj.addProperty("AllDeleteProcess", 0);
			
			return obj.toString();
		}
		

	}
	
	@RequestMapping(value = "/SearchProcess", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public List<ProcessVO> SearchProcess(@RequestBody ProcessVO vo) throws Exception {
		
		
		
		logger.info("Search ProcessName");
		
	
		try {
			return service.SearchProcess(vo);
		} catch (Exception e) {
			throw new ProcessSearchException();
		}
		
	}
}
