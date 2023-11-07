package com.lsh.testing05;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.lsh.testing05.handler.MyExceptionHandler;
import com.lsh.testing05.joborder.service.JoborderService;
import com.lsh.testing05.joborder.vo.JoborderVO;

@RestController
public class JoborderController extends MyExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(JoborderController.class);

	@Inject
	JoborderService service;

	@RequestMapping(value = "/LabelExport", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<JoborderVO> LabelExport(@RequestBody JoborderVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);
		
		logger.info(time1 + "LabelExport");
		
		return service.LabelExport(vo);
	}
	
	
	@RequestMapping(value = "/BomnDetailValue", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String BomnDetailValue(@RequestBody JoborderVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);
		
		logger.info(time1 + "BomnDetailValue");
		
		List<JoborderVO> result = service.BomnDetailValue(vo);
		
		JsonObject obj = new JsonObject();
		
		for(int i = 0; i < result.size(); i++) {
			
			
			if(result.get(i).BOM_DETAIL_ID == vo.getBOM_DETAIL_ID()) {
				
				obj.addProperty("MAX_VALUE", result.get(i).MAX_VALUE);
				obj.addProperty("JOBORDER_PROCESS_INDEX", result.get(i).JOBORDER_PROCESS_INDEX);
				
				return obj.toString();
			}
			
		}
		
		obj.addProperty("MAX_VALUE", "");
		obj.addProperty("JOBORDER_PROCESS_INDEX", "");
		
		
		return obj.toString();
		
	}

	
	@RequestMapping(value = "/CreateJoborderBOM", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String CreateJoborderBOM(@RequestBody JoborderVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);
		
		logger.info(time1 + "CreateJoborderBOM");
		
		Integer result = service.CreateJoborderBOM(vo);
		
		System.out.println(result);
		
		JsonObject obj = new JsonObject();
		
		if(result >= 1) {
			
			obj.addProperty("USE_ON", 1);
			
			
		}else {
			
			obj.addProperty("USE_ON", 0);
		}
		
		return obj.toString();
		
	}

	
	@RequestMapping(value = "/TestList", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<JoborderVO> TestList(JoborderVO vo) throws Exception {
		
		vo.setJOBORDER_EQUIPMENTNAME("");
		
		List<JoborderVO> result = service.FindJobEquipName(vo);
		
		int c = result.size();
		
		System.out.println(c);
		
		return null;
		
	}
	
	
	
	@RequestMapping(value = "/FindSameJobNum", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<JoborderVO> FindSameJobNum(@RequestBody JoborderVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);
		
		logger.info(time1 + "FindSameJobNum");
			
		return service.FindSameJobNum(vo);
		
	}
	
	
	//설비작업현황 작업자 목록
	
	@RequestMapping(value = "/EquipWorkerList", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<JoborderVO> EquipWorkerList(@RequestBody JoborderVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);
		
		logger.info(time1 + "EquipWorkerList");
		
		return service.EquipWorkerList(vo);
		
	}

	
	//설비작업현황 POST 1부분
	@RequestMapping(value = "/EquipJob", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String EquipJob (@RequestBody JoborderVO vo) throws Exception {
	
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);
		
		logger.info(time1 + "EquipJob");
		
		JsonObject obj = new JsonObject();
		
		try {
			
			List<JoborderVO> result1 = service.AccountIdAssignJob(vo);

			ArrayList<Integer> JOBORDER_ID_ARRAY = new ArrayList<Integer>();
			
			ArrayList<String> JOBORDER_DETAIL_JOBNUMBER_ARRAY = new ArrayList<String>();
			
			ArrayList<String> JOBORDER_DETAIL_PRODUCTNAME_ARRAY = new ArrayList<String>();
			
			ArrayList<String> BOM_LIST_MAIN_PRODUCTCODE_ARRAY = new ArrayList<String>();
			
			List<JoborderVO> result2 = service.AccountIdAssignCount(vo);

			int TOTAL_NOT_PROCEED = result2.get(0).TOTAL_NOT_PROCEED;
			int TOTAL_PROCEED = result2.get(0).TOTAL_PROCEED;
			int TOTAL_COMPLETE = result2.get(0).TOTAL_COMPLETE;
			
			
			for(int i = 0; i < result1.size(); i++) {
				
				Integer JOBORDER_ID = result1.get(i).JOBORDER_ID;
				String JOBORDER_DETAIL_JOBNUMBER = result1.get(i).JOBORDER_DETAIL_JOBNUMBER;
				String JOBORDER_DETAIL_PRODUCTNAME = result1.get(i).JOBORDER_DETAIL_PRODUCTNAME;
				String BOM_LIST_MAIN_PRODUCTCODE = result1.get(i).BOM_LIST_MAIN_PRODUCTCODE;
				
				JOBORDER_ID_ARRAY.add(JOBORDER_ID);
				JOBORDER_DETAIL_JOBNUMBER_ARRAY.add(JOBORDER_DETAIL_JOBNUMBER);
				JOBORDER_DETAIL_PRODUCTNAME_ARRAY.add(JOBORDER_DETAIL_PRODUCTNAME);
				BOM_LIST_MAIN_PRODUCTCODE_ARRAY.add(BOM_LIST_MAIN_PRODUCTCODE);
			}
			
			obj.addProperty("JOBORDER_ID_ARRAY", JOBORDER_ID_ARRAY.toString());
			obj.addProperty("JOBORDER_DETAIL_JOBNUMBER_ARRAY", JOBORDER_DETAIL_JOBNUMBER_ARRAY.toString());
			obj.addProperty("JOBORDER_DETAIL_PRODUCTNAME_ARRAY", JOBORDER_DETAIL_PRODUCTNAME_ARRAY.toString());
			obj.addProperty("BOM_LIST_MAIN_PRODUCTCODE_ARRAY", BOM_LIST_MAIN_PRODUCTCODE_ARRAY.toString());
			
			obj.addProperty("TOTAL_NOT_PROCEED", TOTAL_NOT_PROCEED);
			obj.addProperty("TOTAL_PROCEED", TOTAL_PROCEED);
			obj.addProperty("TOTAL_COMPLETE", TOTAL_COMPLETE);
			
			return obj.toString();
			
			
		} catch(Exception e) {
			
			obj.addProperty("EquipJob", 0);
			
			return obj.toString();
			
		}
		

	}
	
	//설비작업현황 POST 2부분
	@RequestMapping(value = "/EquipGraph", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<JoborderVO> EquipGraph (@RequestBody JoborderVO vo) throws Exception {
	
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);
		
		logger.info(time1 + "EquipGraph");
		
		return service.AccountIdAssignCount(vo);
	}
	
	
	
	//설비작업현황 다시 만들기;
	@RequestMapping(value = "/CategoryOriginEquipSelect", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String CategoryOriginEquipSelect(JoborderVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);
		
		logger.info(time1 + "CategoryOriginEquipSelect");
		
		JsonObject obj = new JsonObject();
		
		JsonArray JArray = new JsonArray();
		

		JArray.add(obj);
		
		//큰 JsonObject
		
		JsonObject big = new JsonObject();
		
		
		
		
		List<JoborderVO> result = service.CategoryOriginEquipSelect(vo);
		
		ArrayList<String> ORIGIN_EQUIP_ARRAY_NAME = new ArrayList<String>();
		
		ArrayList<String> PROCESS_MAIN_CATEGORY_ARRAY_NAME = new ArrayList<String>();
		
		ArrayList<Integer> PROCESS_ARRAY_ID = new ArrayList<Integer>();
		
		ArrayList<String> PROCESS_ARRAY_NAME = new ArrayList<String>();
		
		ArrayList<Integer> ORIGIN_ACCOUNT_ARRAY_ID = new ArrayList<Integer>();
		
		ArrayList<String> ORIGIN_ACCOUNT_ARRAY_NAME = new ArrayList<String>();
		
		ArrayList<Integer> ORIGIN_ASSIGN_ARRAY = new ArrayList<Integer>();

		for(int i = 0; i < result.size(); i++) {
			

			String ORIGIN_EQUIP_NAME = result.get(i).ORIGIN_EQUIPMENT_NAME;
			
			ORIGIN_EQUIP_ARRAY_NAME.add(ORIGIN_EQUIP_NAME);
			
			String PROCESS_MAIN_CATEGORY_NAME = result.get(i).PROCESS_MAIN_CATEGORY_NAME;
			
			PROCESS_MAIN_CATEGORY_ARRAY_NAME.add(PROCESS_MAIN_CATEGORY_NAME);
			
		}
		

		
		obj.addProperty("ORIGIN_EQUIP_ARRAY_NAME", ORIGIN_EQUIP_ARRAY_NAME.toString());
		
		obj.addProperty("PROCESS_MAIN_CATEGORY_ARRAY_NAME", PROCESS_MAIN_CATEGORY_ARRAY_NAME.toString());
		
		for(int i = 0; i < ORIGIN_EQUIP_ARRAY_NAME.size(); i++) {
		
			String ORIGIN_EQUIP_NAME = ORIGIN_EQUIP_ARRAY_NAME.get(i);
			
			String PROCESS_MAIN_CATEGORY_NAME = PROCESS_MAIN_CATEGORY_ARRAY_NAME.get(i);
		
			vo.setJOBORDER_EQUIPMENTNAME(ORIGIN_EQUIP_NAME);
			
			Integer JOB_EQUIP_LIST = service.FindRunEquipName(vo);
			
			if(JOB_EQUIP_LIST == null) {
				
				PROCESS_ARRAY_ID.add(null);
		
			} else {
				
				PROCESS_ARRAY_ID.add(JOB_EQUIP_LIST);
			}

		}
		
		obj.addProperty("PROCESS_ARRAY_ID", PROCESS_ARRAY_ID.toString());
		
		for(int i = 0; i < PROCESS_ARRAY_ID.size(); i++) {
			
			Integer PROCESS_ID = PROCESS_ARRAY_ID.get(i);
			
			if(PROCESS_ID == null) {
				
				ORIGIN_ACCOUNT_ARRAY_ID.add(null);
				
				ORIGIN_ACCOUNT_ARRAY_NAME.add(null);
				
				PROCESS_ARRAY_NAME.add(null);
				
			}else {
				
				vo.setJOBORDER_PROCESS_ID(PROCESS_ID);
				
				Integer ORIGIN_ACCOUNT_ID = service.FindProcessOriginid(vo);
				
				String ORIGIN_ACCOUNT_NAME = service.FinidProcessOriginName(vo);
				
				String PROCESS_NAME = service.FindJobProcessName(vo);
				
				ORIGIN_ACCOUNT_ARRAY_ID.add(ORIGIN_ACCOUNT_ID);
				
				ORIGIN_ACCOUNT_ARRAY_NAME.add(ORIGIN_ACCOUNT_NAME);
				
				PROCESS_ARRAY_NAME.add(PROCESS_NAME);
				
			}
		}
		
		obj.addProperty("ORIGIN_ACCOUNT_ARRAY_ID", ORIGIN_ACCOUNT_ARRAY_ID.toString());
		
		obj.addProperty("ORIGIN_ACCOUNT_ARRAY_NAME", ORIGIN_ACCOUNT_ARRAY_NAME.toString());
		
		obj.addProperty("PROCESS_ARRAY_NAME", PROCESS_ARRAY_NAME.toString());
		
		for(int i = 0; i < ORIGIN_ACCOUNT_ARRAY_ID.size(); i++) {
			
			Integer ORIGIN_ACCOUNT_ID = ORIGIN_ACCOUNT_ARRAY_ID.get(i);
			
			if(ORIGIN_ACCOUNT_ID == null) {
				
				ORIGIN_ASSIGN_ARRAY.add(null);
				
			}else {
				
				vo.setORIGIN_ACCOUNT_ID(ORIGIN_ACCOUNT_ID);
				
				Integer ORIGIN_ASSIGN = service.EquipNowList2(vo);
				
				ORIGIN_ASSIGN_ARRAY.add(ORIGIN_ASSIGN);
				
			}
		}
		
		obj.addProperty("ORIGIN_ASSIGN_ARRAY", ORIGIN_ASSIGN_ARRAY.toString());
		
		/*
		ArrayList<Integer> JOB_PROCESS_ARRAY_ID = new ArrayList<Integer>();
		
		for(int i = 0; i < result.size(); i++) {
			
			String ORIGIN_EQUIP_NAME = result.get(i).ORIGIN_EQUIPMENT_NAME;
		
			System.out.println(i + "번 째 설비명 : " + ORIGIN_EQUIP_NAME);
			
			ORIGIN_EQUIP_ARRAY_NAME.add(ORIGIN_EQUIP_NAME);
			
			vo.setJOBORDER_EQUIPMENTNAME(ORIGIN_EQUIP_NAME);
			
			List<JoborderVO> JOB_EQUIP_LIST = service.FindRunEquipName(vo);
			
			Integer JOB_PROCESS_ID = JOB_EQUIP_LIST.get(0).JOBORDER_PROCESS_ID;
			
			System.out.println(i + "번 째 공정명 : " + JOB_PROCESS_ID);
			
			vo.setJOBORDER_PROCESS_ID(JOB_PROCESS_ID);
			
			List<JoborderVO> JOB_PROCESS_LIST = service.FindJobID(vo);
			

			
		}
		*/
		
		return obj.toString();
		
	
		
	}

	
	
	//인덱스 4번 작업지시번호 관련
	@RequestMapping(value = "/SelectIndex4JobNo", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String SelectIndex4JobNo(JoborderVO vo) throws Exception {
		
		
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);
		
		logger.info(time1 + "SelectIndex4JobNo");
		
		JsonObject obj = new JsonObject();
		
		//등록된 설비만 검색
		
		//인덱스 2번에서 등록된 ORIGIN_EQUIPMENT_NAME 검색
		List<JoborderVO> result = service.SelectIndex4OriginID(vo);
		
		System.out.println(result.size());
		
		for(int i = 0; i < result.size(); i++) {
			
			String ORIGIN_EQUIPMENT_NAME = result.get(i).ORIGIN_EQUIPMENT_NAME;
			
			System.out.println(ORIGIN_EQUIPMENT_NAME);
			
			String EQUIPMENT_SENSOR_MATCHING_NUMBER = result.get(i).EQUIPMENT_SENSOR_MATCHING_NUMBER;
			
			System.out.println(EQUIPMENT_SENSOR_MATCHING_NUMBER);
			
			vo.setJOBORDER_EQUIPMENTNAME(ORIGIN_EQUIPMENT_NAME);
					
			List<JoborderVO> JOB_EQUIP_MAX_LIST = service.FindJobRun(vo);
			
			int size = JOB_EQUIP_MAX_LIST.size();

			System.out.println(size);
			
			if(size == 0) {
				
				obj.addProperty(EQUIPMENT_SENSOR_MATCHING_NUMBER, 0);
				
				continue;
			
			}else {
				
				int JOBORDER_PROCESS_ID = JOB_EQUIP_MAX_LIST.get(0).JOBORDER_PROCESS_ID;
				
				vo.setJOBORDER_PROCESS_ID(JOBORDER_PROCESS_ID);
						
				List<JoborderVO> JOBORDER_ID_LIST = service.FindJobID(vo);
								
				int JOBORDER_ID = JOBORDER_ID_LIST.get(0).JOBORDER_ID;
								
				vo.setJOBORDER_ID(JOBORDER_ID);
							
				List<JoborderVO> JOBORDER_DETAIL_ID_LIST = service.FindJobDetail(vo);
								
				int JOBORDER_DETAIL_ID = JOBORDER_DETAIL_ID_LIST.get(0).JOBORDER_DETAIL_ID;
								
				vo.setJOBORDER_DETAIL_ID(JOBORDER_DETAIL_ID);
								
				List<JoborderVO> JOBORDER_DETAIL_NO_LIST = service.TestCountDetail(vo);
								
				String JOBORDER_DETAIL_JOBNUMBER = JOBORDER_DETAIL_NO_LIST.get(0).JOBORDER_DETAIL_JOBNUMBER;
								
				obj.addProperty(EQUIPMENT_SENSOR_MATCHING_NUMBER, JOBORDER_DETAIL_JOBNUMBER);
			}

		}
				
		return obj.toString();
	}	
	
	//인덱스 3번 작업지시번호 관련
	@RequestMapping(value = "/SelectIndex3JobNo", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String SelectIndex3JobNo(JoborderVO vo) throws Exception {
		
		
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);
		
		logger.info(time1 + "SelectIndex3JobNo");
		
		JsonObject obj = new JsonObject();
		
		//등록된 설비만 검색
		
		//인덱스 2번에서 등록된 ORIGIN_EQUIPMENT_NAME 검색
		List<JoborderVO> result = service.SelectIndex3OriginID(vo);
		
		System.out.println(result.size());
		
		for(int i = 0; i < result.size(); i++) {
			
			String ORIGIN_EQUIPMENT_NAME = result.get(i).ORIGIN_EQUIPMENT_NAME;
			
			System.out.println(ORIGIN_EQUIPMENT_NAME);
			
			String EQUIPMENT_SENSOR_MATCHING_NUMBER = result.get(i).EQUIPMENT_SENSOR_MATCHING_NUMBER;
			
			System.out.println(EQUIPMENT_SENSOR_MATCHING_NUMBER);
			
			vo.setJOBORDER_EQUIPMENTNAME(ORIGIN_EQUIPMENT_NAME);
					
			List<JoborderVO> JOB_EQUIP_MAX_LIST = service.FindJobRun(vo);
			
			int size = JOB_EQUIP_MAX_LIST.size();

			System.out.println(size);
			
			if(size == 0) {
				
				obj.addProperty(EQUIPMENT_SENSOR_MATCHING_NUMBER, 0);
				
				continue;
			
			}else {
				
				int JOBORDER_PROCESS_ID = JOB_EQUIP_MAX_LIST.get(0).JOBORDER_PROCESS_ID;
				
				vo.setJOBORDER_PROCESS_ID(JOBORDER_PROCESS_ID);
						
				List<JoborderVO> JOBORDER_ID_LIST = service.FindJobID(vo);
								
				int JOBORDER_ID = JOBORDER_ID_LIST.get(0).JOBORDER_ID;
								
				vo.setJOBORDER_ID(JOBORDER_ID);
							
				List<JoborderVO> JOBORDER_DETAIL_ID_LIST = service.FindJobDetail(vo);
								
				int JOBORDER_DETAIL_ID = JOBORDER_DETAIL_ID_LIST.get(0).JOBORDER_DETAIL_ID;
								
				vo.setJOBORDER_DETAIL_ID(JOBORDER_DETAIL_ID);
								
				List<JoborderVO> JOBORDER_DETAIL_NO_LIST = service.TestCountDetail(vo);
								
				String JOBORDER_DETAIL_JOBNUMBER = JOBORDER_DETAIL_NO_LIST.get(0).JOBORDER_DETAIL_JOBNUMBER;
								
				obj.addProperty(EQUIPMENT_SENSOR_MATCHING_NUMBER, JOBORDER_DETAIL_JOBNUMBER);
			}

		}
				
		return obj.toString();
	}		
	
	//인덱스 2번 작업지시번호 관련
	@RequestMapping(value = "/SelectIndex2JobNo", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String SelectIndex2JobNo(JoborderVO vo) throws Exception {
		
		
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);
		
		logger.info(time1 + "SelectIndex2JobNo");
		
		JsonObject obj = new JsonObject();
		
		//등록된 설비만 검색
		
		//인덱스 2번에서 등록된 ORIGIN_EQUIPMENT_NAME 검색
		List<JoborderVO> result = service.SelectIndex2OriginID(vo);
		
		System.out.println(result.size());
		
		for(int i = 0; i < result.size(); i++) {
			
			String ORIGIN_EQUIPMENT_NAME = result.get(i).ORIGIN_EQUIPMENT_NAME;
			
			System.out.println(ORIGIN_EQUIPMENT_NAME);
			
			String EQUIPMENT_SENSOR_MATCHING_NUMBER = result.get(i).EQUIPMENT_SENSOR_MATCHING_NUMBER;
			
			System.out.println(EQUIPMENT_SENSOR_MATCHING_NUMBER);
			
			vo.setJOBORDER_EQUIPMENTNAME(ORIGIN_EQUIPMENT_NAME);
					
			List<JoborderVO> JOB_EQUIP_MAX_LIST = service.FindJobRun(vo);
			
			int size = JOB_EQUIP_MAX_LIST.size();

			System.out.println(size);
			
			if(size == 0) {
				
				obj.addProperty(EQUIPMENT_SENSOR_MATCHING_NUMBER, 0);
				
				continue;
			
			}else {
				
				int JOBORDER_PROCESS_ID = JOB_EQUIP_MAX_LIST.get(0).JOBORDER_PROCESS_ID;
				
				vo.setJOBORDER_PROCESS_ID(JOBORDER_PROCESS_ID);
						
				List<JoborderVO> JOBORDER_ID_LIST = service.FindJobID(vo);
								
				int JOBORDER_ID = JOBORDER_ID_LIST.get(0).JOBORDER_ID;
								
				vo.setJOBORDER_ID(JOBORDER_ID);
							
				List<JoborderVO> JOBORDER_DETAIL_ID_LIST = service.FindJobDetail(vo);
								
				int JOBORDER_DETAIL_ID = JOBORDER_DETAIL_ID_LIST.get(0).JOBORDER_DETAIL_ID;
								
				vo.setJOBORDER_DETAIL_ID(JOBORDER_DETAIL_ID);
								
				List<JoborderVO> JOBORDER_DETAIL_NO_LIST = service.TestCountDetail(vo);
								
				String JOBORDER_DETAIL_JOBNUMBER = JOBORDER_DETAIL_NO_LIST.get(0).JOBORDER_DETAIL_JOBNUMBER;
								
				obj.addProperty(EQUIPMENT_SENSOR_MATCHING_NUMBER, JOBORDER_DETAIL_JOBNUMBER);
			}

		}
				
		return obj.toString();
	}	
	

	
	//인덱스1 작업지시번호 관련
	@RequestMapping(value = "/SelectIndex1JobNo", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String SelectIndex1JobNo(JoborderVO vo) throws Exception {
		
		
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);
		
		logger.info(time1 + "SelectIndex1JobNo");
		
		JsonObject obj = new JsonObject();
		
		//등록된 설비만 검색
		
		//인덱스 1번에서 등록된 ORIGIN_EQUIPMENT_NAME 검색
		List<JoborderVO> result = service.SelectIndex1OriginID(vo);
		
		System.out.println(result.size());
		
		for(int i = 0; i < result.size(); i++) {
			
			String ORIGIN_EQUIPMENT_NAME = result.get(i).ORIGIN_EQUIPMENT_NAME;
			
			System.out.println(ORIGIN_EQUIPMENT_NAME);
			
			String EQUIPMENT_SENSOR_MATCHING_NUMBER = result.get(i).EQUIPMENT_SENSOR_MATCHING_NUMBER;
			
			System.out.println(EQUIPMENT_SENSOR_MATCHING_NUMBER);
			
			vo.setJOBORDER_EQUIPMENTNAME(ORIGIN_EQUIPMENT_NAME);
					
			List<JoborderVO> JOB_EQUIP_MAX_LIST = service.FindJobRun(vo);
			
			int size = JOB_EQUIP_MAX_LIST.size();

			System.out.println(size);
			
			if(size == 0) {
				
				obj.addProperty(EQUIPMENT_SENSOR_MATCHING_NUMBER, 0);
				
				continue;
			
			}else {
				
				int JOBORDER_PROCESS_ID = JOB_EQUIP_MAX_LIST.get(0).JOBORDER_PROCESS_ID;
				
				vo.setJOBORDER_PROCESS_ID(JOBORDER_PROCESS_ID);
						
				List<JoborderVO> JOBORDER_ID_LIST = service.FindJobID(vo);
								
				int JOBORDER_ID = JOBORDER_ID_LIST.get(0).JOBORDER_ID;
								
				vo.setJOBORDER_ID(JOBORDER_ID);
							
				List<JoborderVO> JOBORDER_DETAIL_ID_LIST = service.FindJobDetail(vo);
								
				int JOBORDER_DETAIL_ID = JOBORDER_DETAIL_ID_LIST.get(0).JOBORDER_DETAIL_ID;
								
				vo.setJOBORDER_DETAIL_ID(JOBORDER_DETAIL_ID);
								
				List<JoborderVO> JOBORDER_DETAIL_NO_LIST = service.TestCountDetail(vo);
								
				String JOBORDER_DETAIL_JOBNUMBER = JOBORDER_DETAIL_NO_LIST.get(0).JOBORDER_DETAIL_JOBNUMBER;
								
				obj.addProperty(EQUIPMENT_SENSOR_MATCHING_NUMBER, JOBORDER_DETAIL_JOBNUMBER);
			}

		}
				
		return obj.toString();
	}
	
	
	@RequestMapping(value = "/SelectIndex1OriginID", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String SelectIndex1OriginID(JoborderVO vo) throws Exception {
		
		
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);
		
		logger.info(time1 + "SelectIndex1OriginID");
		
		JsonObject obj = new JsonObject();
		
		//등록된 설비만 검색
		
		//인덱스 1번에서 등록된 ORIGIN_EQUIPMENT_NAME 검색
		List<JoborderVO> result = service.SelectIndex1OriginID(vo);
		
		/*
		
		for(int i = 0; i < result.size(); i++) {
			
			String ORIGIN_EQUIPMENT_NAME = result.get(i).ORIGIN_EQUIPMENT_NAME;
			
			String EQUIPMENT_SENSOR_MATCHING_NUMBER = result.get(i).EQUIPMENT_SENSOR_MATCHING_NUMBER;
			
			//obj.addProperty(EQUIPMENT_SENSOR_MATCHING_NUMBER, EQUIPMENT_SENSOR_MATCHING_NUMBER);
			
			vo.setJOBORDER_EQUIPMENTNAME(ORIGIN_EQUIPMENT_NAME);
			
			List<JoborderVO> JBEquipList = service.FindJobEquipName(vo);
			
			for(int j = 0; j < JBEquipList.size(); j++) {
				
				int JOBORDER_PROCESS_ID = JBEquipList.get(j).JOBORDER_PROCESS_ID;
				
				vo.setJOBORDER_PROCESS_ID(JOBORDER_PROCESS_ID);
				
				List<JoborderVO> ProcessResult_ID = service.FindProcessResultID(vo);
				
				int BADQUANTITY = 0;
				
				for(int jj = 0; jj < ProcessResult_ID.size(); jj++) {
					
					int PROCESS_RESULT_TEMPLATE_ID = ProcessResult_ID.get(jj).PROCESS_RESULT_TEMPLATE_ID;
					
					vo.setPROCESS_RESULT_TEMPLATE_ID(PROCESS_RESULT_TEMPLATE_ID);
					
					
					
					List<JoborderVO> TEMPLATE_LIST = service.FindProcessTemplateID(vo);
					
					String BAD_STRING = TEMPLATE_LIST.get(0).PROCESS_RESULT_TEMPLATE_BADQUANTITY;
					
					String settest;
					
					String resulttest;
					
					if(BAD_STRING == null) {
						
						continue;
						
					}else if (BAD_STRING.equals("")) {
						
						continue;
					}else {
						
						if(BAD_STRING.contains("(")) {
							
							settest = 
						}
					}

				}
			}
			
			
			
			
		
			int ORIGIN_EQUIPMENT_ID = result.get(i).ORIGIN_EQUIPMENT_ID;
			
			System.out.println(ORIGIN_EQUIPMENT_ID);

			vo.setORIGIN_EQUIPMENT_ID(ORIGIN_EQUIPMENT_ID);
			
			//원본 설비명 찾아옴
			List<JoborderVO> EquipNameList = service.SelectOriginEquipName(vo);
			
			String EquipName = EquipNameList.get(0).ORIGIN_EQUIPMENT_NAME;
			
			vo.setJOBORDER_EQUIPMENTNAME(EquipName);
			
			List<JoborderVO> JBEquipList = service.FindJobEquipName(vo);
			
			for(int j = 0; j < JBEquipList.size(); j++) {
				
				int JOBORDER_PROCESS_ID = JBEquipList.get(j).JOBORDER_PROCESS_ID;
				
				vo.setJOBORDER_PROCESS_ID(JOBORDER_PROCESS_ID);
				
				List<JoborderVO> ProcessResult_ID = service.FindProcessResultID(vo);
				
				for(int jj = 0; jj < ProcessResult_ID.size(); jj++) {
					
					int PROCESS_RESULT_TEMPLATE_ID = ProcessResult_ID.get(jj).PROCESS_RESULT_TEMPLATE_ID;
					
					vo.setPROCESS_RESULT_TEMPLATE_ID(PROCESS_RESULT_TEMPLATE_ID);
					
					List<JoborderVO> TEMPLATE_LIST = service.FindProcessTemplateID(vo);
					
					
	
				}
				
				
			}
			
			*/
			
		//}
		
		return null;
	}
	
	
	
	@RequestMapping(value = "/SelectEquipID", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<JoborderVO> SelectEquipID(@RequestBody JoborderVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "SelectEquipID");
		
		List<JoborderVO> result = service.SelectEquipID(vo);
		
		System.out.println(result.get(0).getORIGIN_EQUIPMENT_NAME());
		System.out.println(result.get(0).getORIGIN_EQUIPMENT_MODELNAME());
		System.out.println(result.get(0).getORIGIN_EQUIPMENT_CONTEXT());
		
		return result;
		
	}

	
	
	@RequestMapping(value = "/FindProcessStatus", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<JoborderVO> FindProcessStatus(@RequestBody JoborderVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "FindProcessStatus");
		
		
		List<JoborderVO> result = service.FindProcessStatus(vo);
		
		/*
		System.out.println(result.get(0).getJOBORDER_PROCESS_STATUS_ID());
		System.out.println(result.get(0).getJOBORDER_PROCESS_STATUS_NAME());
		System.out.println(result.get(0).getJOBORDER_PROCESS_OUTSOURCING());
		System.out.println(result.get(0).getJOBORDER_PROCESS_RESULT_ID());
		System.out.println(result.get(0).getJOBORDER_EQUIPMENT_ID());
		*/
		
		return result;
	}
	
	
	@RequestMapping(value = "/SelectJobStopList", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<JoborderVO> SelectJobStopList(@RequestBody JoborderVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "SelectJobStopList");
		
		return service.SelectJobStopList(vo);
	}

		

	
	
	@RequestMapping(value = "/EquipNowList1", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<JoborderVO> EquipNowList1(@RequestBody JoborderVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "EquipNowList1");
		
		return service.EquipNowList1(vo);
	}
	
	@RequestMapping(value = "/EquipNowList1_1", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<JoborderVO> EquipNowList1_1(@RequestBody JoborderVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "EquipNowList1_1");
		
		return service.EquipNowList1_1(vo);
	}
	
	@RequestMapping(value = "/EquipNowList2", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String EquipNowList2(@RequestBody JoborderVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "EquipNowList2");
		
		JsonObject obj = new JsonObject();
		
		obj.addProperty("MAX_VALUE", service.EquipNowList2(vo));
		
		return obj.toString();
	}
	
	@RequestMapping(value = "/EquipNowList3", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<JoborderVO> EquipNowList3(@RequestBody JoborderVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "EquipNowList2");
		
		return service.EquipNowList3(vo);
	}


	
	@RequestMapping(value = "/SearchOutSourcingOutList", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<JoborderVO> SearchOutSourcingOutList(@RequestBody JoborderVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "SearchOutSourcingOutList");
		
		if(vo.getPUB_firsday() == null && vo.getPUB_secondday() == null) {
			
			return service.SearchOutSourcingOutList2(vo);
			
		}else {
			
			return service.SearchOutSourcingOutList1(vo);

		}
		
	}

	
	@RequestMapping(value = "/SearchOutSourcingOutEndList", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<JoborderVO> SearchOutSourcingOutEndList(@RequestBody JoborderVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "SearchOutSourcingOutEndList");
		
		System.out.println(vo.getDEL_firstday());
		System.out.println(vo.getDEL_secondday());
		
		if(vo.getDEL_firstday() == null && vo.getDEL_secondday() == null) {
			
			return service.SearchOutSourcingOutEndList1(vo);
		}else {
			
			return service.SearchOutSourcingOutEndList2(vo);
		}
	}

	
	
	
	@RequestMapping(value = "/OutSourcingOutEndList", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<JoborderVO> OutSourcingOutEndList(JoborderVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "OutSourcingOutEndList");
		
		return service.OutSourcingOutEndList(vo);
		
	}

	
	
	@RequestMapping(value = "/OutSourcingOutList", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<JoborderVO> OutSourcingOutList(JoborderVO vo) throws Exception {
	
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "OutSourcingOutList");
		
		return service.OutSourcingOutList(vo);
		
	}
	
	
	

	
	@RequestMapping(value = "/UpdateWorkOut", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String UpdateWorkOut(@RequestBody JoborderVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "UpdateWorkOut");
		
		try {
		
			service.UpdateWorkOut(vo);
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("UpdateWorkOut", 1);
			
			return obj.toString();
			
		} catch(Exception e) {
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("UpdateWorkOut", 0);
			
			return obj.toString();
		}
		
		
	}

	
	@RequestMapping(value = "/MonitoringPage4", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<JoborderVO> MonitoringPage4(@RequestBody JoborderVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "MonitoringPage4");
		
		return service.MonitoringPage4(vo);
	}

	
	@RequestMapping(value = "/MonitoringStatusPage", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<JoborderVO> MonitoringStatusPage(@RequestBody JoborderVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "MonitoringStatusPage");
		
		return service.MonitoringStatusPage(vo);
		
	}
	
	@RequestMapping(value = "/SearchMonitoringPage3", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<JoborderVO> SearchMonitoringPage3(@RequestBody JoborderVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		System.out.println("vo.getPUB_firsday()"+ vo.getPUB_firsday());
		System.out.println("vo.getPUB_secondday()"+ vo.getPUB_secondday());
		
		if(vo.getPUB_firsday()== null && vo.getPUB_secondday() == null) {
			
			logger.info(time1 + "SearchMonitoringPage3");
			
			return service.SearchMonitoringPage3(vo);
			
		}else {
		
			logger.info(time1 + "SearchMonitoringPage3_1");
			
			return service.SearchMonitoringPage3_1(vo);
		}
		
		
	}

	
	@RequestMapping(value = "/MonitoringPage1_2", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<JoborderVO> MonitoringPage1_2(JoborderVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "MonitoringPage1_2");
		
		return service.MonitoringPage3(vo);
	}
	
	@RequestMapping(value = "/MonitoringPage1", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String MonitoringPage1(JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "MonitoringPage1");

		//총 작지, 진행중, 대기, 완료 건수
		List<JoborderVO> result1 = service.MonitoringPage1(vo);

		//불량 건 수
		//List<JoborderVO> result2 = service.Home2(vo);
		
		

		List<JoborderVO> result2_1 = service.Home2_1(vo);
		
		int BADQUANTITY = 0;
		
		
		for(int i = 0; i < result2_1.size(); i++) {
			
			String test = result2_1.get(i).PROCESS_RESULT_TEMPLATE_BADQUANTITY;
			

			String settest;
			
			String resultest;
			
			
			
			if(test == null) {
				
				continue;
				
			}else if (test.equals("")) {
				
				continue;
			}
			
			else {
				
				if(test.contains("(")) {
			
					settest = test.replaceFirst("[(]", "");
					String lasttest = settest.replaceAll("[)]", "");
									
					test = lasttest;
			
				}
					
				
				//정수변환 완료
				int c = Integer.parseInt(test);
				
				if(c > 0) {
					
					BADQUANTITY += 1;
				}
			
			}
			
			
			
		}
		
		
		
		
		
		//외주 건수
		List<JoborderVO> result3 = service.Home3(vo);
		
		//구분 건수
		List<JoborderVO> result4 = service.MonitoringPage2(vo);
		
		JsonObject obj = new JsonObject();
		
		obj.addProperty("TOTAL_JOBORDER", result1.get(0).TOTAL_JOBORDER);
		obj.addProperty("TOTAL_NOT_PROCEED", result1.get(0).TOTAL_NOT_PROCEED);
		obj.addProperty("TOTAL_PROCEED", result1.get(0).TOTAL_PROCEED);
		obj.addProperty("TOTAL_COMPLETE", result1.get(0).TOTAL_COMPLETE);
		
		obj.addProperty("BADQUANTITY", BADQUANTITY);
		
		obj.addProperty("OUTSOURCING", result3.get(0).OUTSOURCING);
		
		obj.addProperty("JOBORDER_SALES", result4.get(0).JOBORDER_SALES);
		obj.addProperty("JOBORDER_INDUSTRY", result4.get(0).JOBORDER_INDUSTRY);


		return obj.toString();
	}

	@RequestMapping(value = "/ReturnProcessValue", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String ReturnProcessValue(@RequestBody JoborderVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "ReturnProcessValue");

		int result = service.ReturnProcessValue(vo);

		JsonObject obj = new JsonObject();
		
		obj.addProperty("PROCESS_VALUES", result);
		
		return obj.toString();
		
	}

	
	@RequestMapping(value = "/ProjectJobNo1", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<JoborderVO> ProjectJobNo1(JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "ProjectJobNo1");

		List<JoborderVO> result = service.ProjectJobNo1(vo);

		return result;

	}

	@RequestMapping(value = "/SearchProjectJobNo1", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<JoborderVO> SearchProjectJobNo1(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "SearchProjectJobNo1");

		if(vo.getPUB_firsday() == null && vo.getPUB_secondday() == null && vo.getDEL_firstday() == null && vo.getDEL_secondday() == null) {
			
			System.out.println(" 1여기로 인가?");
			
			return service.Search1ProjectJobNo3(vo);
		}
		
		else if (vo.getPUB_firsday() == null && vo.getPUB_secondday() == null) {

			System.out.println(" 2여기로 인가?");
			
			return service.Search1ProjectJobNo2(vo);

		}

		else if (vo.getDEL_firstday() == null && vo.getDEL_secondday() == null) {

			System.out.println(" 3여기로 인가?");
			
			return service.Search1ProjectJobNo1(vo);
		}

		else {

			return null;
		}

	}

	@RequestMapping(value = "/ProjectJobNo2", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<JoborderVO> ProjectJobNo2(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "ProjectJobNo2");

		List<JoborderVO> result = service.ProjectJobNo2(vo);

		return result;
	}

	@RequestMapping(value = "/ProjectJobNo3", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String ProjectJobNo3(JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "ProjectJobNo3");

		// 작업지시서 발행 갯수
		List<JoborderVO> result1 = service.ProjectJobNo1(vo);

		int totalList = result1.size();

		// 전체 생산 품목
		List<JoborderVO> result2 = service.ProjectJobNo3_1(vo);

		int total = result2.size();

		// 생산 진행 현황
		List<JoborderVO> result3 = service.ProjectJobNo3_2(vo);

		// TOTAL_NOT_PROCEED
		int TOTAL_NOT_PROCEED = result3.get(0).TOTAL_NOT_PROCEED;

		// TOTAL_PROCEED
		int TOTAL_PROCEED = result3.get(0).TOTAL_PROCEED;

		// TOTAL_COMPLETE
		int TOTAL_COMPLETE = result3.get(0).TOTAL_COMPLETE;

		float sum = 0;

		for (int i = 0; i < result1.size(); i++) {

			int JOBORDER_ID = result1.get(i).JOBORDER_ID;
			
			vo.setJOBORDER_ID(JOBORDER_ID);
			
			float now_pr_index = (float) service.ReturnProcessValue(vo);
			
			float now_process_index = (float) result1.get(i).JOBORDER_PROCESS_INDEX;

			float max_process_index = (float) result1.get(i).MAX_VALUE;

			float test4 = now_pr_index / max_process_index;

			sum += test4;

		}

		float list = (float) totalList;

		double average = (sum / list) * 100;

		String s = String.format("%.0f", average);

		JsonObject obj = new JsonObject();

		// 작업지시서 발행 갯수
		obj.addProperty("TotalList", totalList);

		// 전체 생산 품목
		obj.addProperty("TotalProduction", total);

		// 평균생산진행률
		obj.addProperty("AverageProceed", s);

		// 미진행
		obj.addProperty("TOTAL_NOT_PROCEED", TOTAL_NOT_PROCEED);
		// 진행중
		obj.addProperty("TOTAL_PROCEED", TOTAL_PROCEED);
		// 완료
		obj.addProperty("TOTAL_COMPLETE", TOTAL_COMPLETE);

		return obj.toString();

	}

	@RequestMapping(value = "/test1", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public void test1(@RequestBody JoborderVO vo) throws Exception {

		List<JoborderVO> resultlist = service.SelectPresetFile(vo);

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		for (int i = 0; i < resultlist.size(); i++) {

			int JOBORDER_FILE_TYPE_ID = resultlist.get(i).JOBORDER_FILE_TYPE_ID;
			String SETTING_PRESET_FILE_MANAGEMENT_NAME = resultlist.get(i).SETTING_PRESET_FILE_MANAGEMENT_NAME;
			String SETTING_PRESET_FILE_MANAGEMENT_DIRECTORY = resultlist
					.get(i).SETTING_PRESET_FILE_MANAGEMENT_DIRECTORY;

			System.out.println(JOBORDER_FILE_TYPE_ID);
			System.out.println(SETTING_PRESET_FILE_MANAGEMENT_NAME);
			System.out.println(SETTING_PRESET_FILE_MANAGEMENT_DIRECTORY);

			File in = new File(SETTING_PRESET_FILE_MANAGEMENT_DIRECTORY);

			// C로 디렉 변경

			String path2 = ("C:\\factory\\admin\\joborder\\");

			String realpath2 = path2 + time1;

			File Folder2 = new File(realpath2);

			Folder2.mkdirs();

			String copyFile = realpath2 + "\\" + SETTING_PRESET_FILE_MANAGEMENT_NAME;

			File out = new File(copyFile);

			FileCopyUtils.copy(in, out);

			System.out.println("저장 될 경로 : " + copyFile);

		}

	}

	@RequestMapping(value = "/WorkerAllJbList", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<JoborderVO> WorkerAllJbList(JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "WorkerAllJbList");

		return service.WorkerAllJbList(vo);
	}

	@RequestMapping(value = "/WorkerPrcoessList", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<JoborderVO> WorkerPrcoessList(JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "WorkerPrcoessList");

		return service.WorkerPrcoessList(vo);
	}

	@RequestMapping(value = "/SelectJbProcessUniquess", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<JoborderVO> SelectJbProcessUniquess(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "SelectJbProcessUniquess");

		return service.SelectJbProcessUniquess(vo);

	}

	@RequestMapping(value = "/SelectJoborder", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<JoborderVO> SelectJoborder(JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "SelectJoborderDetail");

		return service.SelectJoborder(vo);
	}

	@RequestMapping(value = "/testlist", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String testlist(JoborderVO vo) throws Exception {
	
		SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");

		//Calendar c1 = Calendar.getInstance();
		
		Date time = new Date();
		
		String time1 = format1.format(time);

		logger.info(time1 + "SelectJbList");

		JsonObject obj =  new JsonObject();
		
		obj.addProperty(time1, time1);
				
		return obj.toString();
		
	}
	
	
	@RequestMapping(value = "/SelectJbList", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<JoborderVO> SelectJbList(JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Calendar c1 = Calendar.getInstance();
		
		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "SelectJbList");

		return service.SelectJbList(vo);

	}

	@RequestMapping(value = "/SearchJbList", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<JoborderVO> SearchJbList(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "SearchJbList");

		//3번째 _ 붙는건 BellowsCode 없는건지 잘 확인할 것
		
		//벨로우즈 코드가 없을때
		if(vo.getBOM_DETAIL_BELLOWSCODE() == null) {
			
			if(vo.getDEL_firstday() == null && vo.getDEL_secondday() == null && vo.getPUB_firsday() == null
					&& vo.getPUB_secondday() == null) {
				
				if (vo.getJOBORDER_PUBLISH() == null) {
					
					return service.SearchJbList3_2_1(vo);
					
				}else {
					
					return service.SearchJbList3_1_1(vo);
				}
				
			}
			else if (vo.getPUB_firsday() == null && vo.getPUB_secondday() == null) {
				
				if (vo.getJOBORDER_PUBLISH() == null) {
					
					return service.SearchJbList2_2_1(vo);
				} else {
					
					return service.SearchJbList2_1_1(vo);
				}
			}
			else if (vo.getDEL_firstday() == null && vo.getDEL_secondday() == null) {
				
				if (vo.getJOBORDER_PUBLISH() == null) {
				
					return service.SearchJbList1_2_1(vo);
					
				} else {
					
					return service.SearchJbList1_1_1(vo);
					
				}
				
			}
			
			
			
		}else {
			
			if (vo.getDEL_firstday() == null && vo.getDEL_secondday() == null && vo.getPUB_firsday() == null
					&& vo.getPUB_secondday() == null) {

				// 배포, 미배포 선택안했을 때
				if (vo.getJOBORDER_PUBLISH() == null) {



					return service.SearchJbList3_2(vo);

				} else {



					return service.SearchJbList3_1(vo);
				}
			} else if (vo.getPUB_firsday() == null && vo.getPUB_secondday() == null) {

				// 배포, 미배포 선택안했을 때
				if (vo.getJOBORDER_PUBLISH() == null) {



					return service.SearchJbList2_2(vo);

				} else {



					return service.SearchJbList2_1(vo);
				}

				// 납기일 null일때 결론 => 배포일 기준 검색
			} else if (vo.getDEL_firstday() == null && vo.getDEL_secondday() == null) {

				// 배포, 미배포 선택안했을 때
				if (vo.getJOBORDER_PUBLISH() == null) {


					return service.SearchJbList1_2(vo);

				} else {


					return service.SearchJbList1_1(vo);
					
					
				}

			} else {


				return null;

			}
			
		}
		return null;
			
	}

	@RequestMapping(value = "/SelectFindQRCode", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<JoborderVO> SelectFindQRCode(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "SelectQRCode");

		return service.SelectFindQRCode(vo);
	}

	@RequestMapping(value = "/SelectJbProcessFile", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<JoborderVO> SelectJbProcessFile(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "SelectJbProcessFile");

		return service.SelectJbProcessFile(vo);
	}

	@RequestMapping(value = "/SelectJoborderDetailForm", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String SelectJoborderDetailForm(@RequestBody JoborderVO vo) throws Exception {

		JsonObject obj = new JsonObject();

		int JOBORDER_FORM_DETAIL_ID = service.SelectJoborderDetailForm(vo);

		obj.addProperty("JOBORDER_FORM_DETAIL_ID", JOBORDER_FORM_DETAIL_ID);

		return obj.toString();
	}

	@RequestMapping(value = "/SelectJoborderDetail", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<JoborderVO> SelectJoborderDetail(JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "SelectJoborderDetail");

		return service.SelectJoborderDetail(vo);

	}

	@RequestMapping(value = "/SelectJoborderSubtitle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<JoborderVO> SelectJoborderSubtitle(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "SelectJoborderSubtitle");

		return service.SelectJoborderSubtitle(vo);

	}

	@RequestMapping(value = "/RegisterJoborderFile", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String RegisterJoborderFile(JoborderVO vo, MultipartHttpServletRequest request) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		ArrayList<String> JoborderFileDirList = new ArrayList<String>();
		ArrayList<String> JoborderFileNameList = new ArrayList<String>();

		logger.info(time1 + "RegisterJoborderFile");

		try {

			List<MultipartFile> filelist2 = request.getFiles("JoborderFile");

			for (MultipartFile mf : filelist2) {

				// C로 디렉 변경

				String path = ("C:\\Html\\factory\\worker\\worker\\pdfs\\");

				String dbpath = ("http://182.208.252.210:5995/factory/worker/worker/pdfs/");
				
				String realpath = path + time1;

				String dbrealpath = dbpath + time1;
				
				File Folder = new File(realpath);

				Folder.mkdirs();

				String Filename = new String(mf.getOriginalFilename().getBytes("8859_1"), "UTF-8");

				File saveFile = new File(realpath + "\\" + Filename);

				mf.transferTo(saveFile);

				String directory = saveFile.toString();

				String dbsavepath = dbrealpath + "/" + Filename;
				
				JoborderFileDirList.add(dbsavepath);
				JoborderFileNameList.add(Filename);

			}

			for (int i = 0; i < vo.getJOBORDER_FILE_TYPE_ID2().length; i++) {

				vo.setJOBORDER_ID(vo.getJOBORDER_ID());
				vo.setJOBORDER_FILE_TYPE_ID(vo.getJOBORDER_FILE_TYPE_ID2()[i]);
				vo.setJOBORDER_FILE_MANAGEMENT_NAME(JoborderFileNameList.get(i));
				vo.setJOBORDER_FILE_MANAGEMENT_DIRECTORY(JoborderFileDirList.get(i));

				service.RegisterJoborderFile(vo);
			}

			JsonObject obj = new JsonObject();

			obj.addProperty("RegisterJoborderFile", 1);

			return obj.toString();

		} catch (Exception e) {

			JsonObject obj = new JsonObject();

			obj.addProperty("RegisterJoborderFile", 0);

			return obj.toString();
		}

	}

	@RequestMapping(value = "/DeleteJbUniquess", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String DeleteJbUniquess(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "DeleteJbUniquess");

		try {

			service.DeleteJbUniquess(vo);

			JsonObject obj = new JsonObject();

			obj.addProperty("DeleteJbUniquess", 1);

			return obj.toString();

		} catch (Exception e) {

			JsonObject obj = new JsonObject();

			obj.addProperty("DeleteJbUniquess", 0);

			return obj.toString();
		}

	}

	@RequestMapping(value = "/WorkerJobView1", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<JoborderVO> WorkerJobView1(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "WorkerJobView1");

		List<JoborderVO> result = service.WorkerJobView1(vo);

		return result;

	}

	@RequestMapping(value = "/AllCreateJoborder", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String AllCreateJoborder(JoborderVO vo, MultipartHttpServletRequest request) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "AllCreateJoborder");

		try {

			String conv = new String(vo.getCONVERT_JOBORDER_DETAIL_DEILVERYDAY().getBytes("8859_1"), "UTF-8");
			String conv2 = new String(vo.getCONVERT_JOBORDER_DETAIL_PLANENDDAY().getBytes("8859_1"), "UTF-8");

			// 사업명 입력칸 인코딩
			String JOBORDER_DETAIL_BUSINESSNAME = new String(vo.getJOBORDER_DETAIL_BUSINESSNAME().getBytes("8859_1"),
					"UTF-8");
			// 품명 입력칸 인코딩
			String JOBORDER_DETAIL_PRODUCTNAME = new String(vo.getJOBORDER_DETAIL_PRODUCTNAME().getBytes("8859_1"),
					"UTF-8");
			// 납품처 입력칸 인코딩
			String JOBORDER_DETAIL_CLIENT = new String(vo.getJOBORDER_DETAIL_CLIENT().getBytes("8859_1"), "UTF-8");
			// 작업지시서 번호 입력칸 인코딩
			String JOBORDER_DETAIL_JOBNUMBER = new String(vo.getJOBORDER_DETAIL_JOBNUMBER().getBytes("8859_1"),
					"UTF-8");
			// 품번 입력칸
			String JOBORDER_DETAIL_PRODUCTNUMBER = new String(vo.getJOBORDER_DETAIL_PRODUCTNUMBER().getBytes("8859_1"),
					"UTF-8");
			// 코드 입력칸
			String JOBORDER_DETAIL_CODE = new String(vo.getJOBORDER_DETAIL_CODE().getBytes("8859_1"), "UTF-8");

			vo.setJOBORDER_DETAIL_BUSINESSNAME(JOBORDER_DETAIL_BUSINESSNAME);
			vo.setJOBORDER_DETAIL_PRODUCTNAME(JOBORDER_DETAIL_PRODUCTNAME);
			vo.setJOBORDER_DETAIL_CLIENT(JOBORDER_DETAIL_CLIENT);
			vo.setJOBORDER_DETAIL_JOBNUMBER(JOBORDER_DETAIL_JOBNUMBER);
			vo.setJOBORDER_DETAIL_PRODUCTNUMBER(JOBORDER_DETAIL_PRODUCTNUMBER);
			vo.setJOBORDER_DETAIL_CODE(JOBORDER_DETAIL_CODE);

			/*
			 * vo.setJOBORDER_DETAIL_BUSINESSNAME(vo.getJOBORDER_DETAIL_BUSINESSNAME());
			 * vo.setJOBORDER_DETAIL_PRODUCTNAME(vo.getJOBORDER_DETAIL_PRODUCTNAME());
			 * vo.setJOBORDER_DETAIL_CLIENT(vo.getJOBORDER_DETAIL_CLIENT());
			 * vo.setJOBORDER_DETAIL_JOBNUMBER(vo.getJOBORDER_DETAIL_JOBNUMBER());
			 * vo.setJOBORDER_DETAIL_PRODUCTNUMBER(vo.getJOBORDER_DETAIL_PRODUCTNUMBER());
			 * vo.setJOBORDER_DETAIL_CODE(vo.getJOBORDER_DETAIL_CODE());
			 */

			if (vo.getJOBORDER_DETAIL_SSCPARTNO() == null) {
				vo.setJOBORDER_DETAIL_SSCPARTNO(null);
			} else {

				String JOBORDER_DETAIL_SSCPARTNO = new String(vo.getJOBORDER_DETAIL_SSCPARTNO().getBytes("8859_1"),
						"UTF-8");
				vo.setJOBORDER_DETAIL_SSCPARTNO(JOBORDER_DETAIL_SSCPARTNO);

				// System.out.println(vo.getJOBORDER_DETAIL_SSCPARTNO());

				// vo.setJOBORDER_DETAIL_SSCPARTNO(vo.getJOBORDER_DETAIL_SSCPARTNO());

			}

			if (vo.getJOBORDER_DETAIL_REV() == null) {
				vo.setJOBORDER_DETAIL_REV(null);
			} else {

				String JOBORDER_DETAIL_REV = new String(vo.getJOBORDER_DETAIL_REV().getBytes("8859_1"), "UTF-8");
				vo.setJOBORDER_DETAIL_REV(JOBORDER_DETAIL_REV);

				// System.out.println(vo.getJOBORDER_DETAIL_REV());

				// vo.setJOBORDER_DETAIL_REV(vo.getJOBORDER_DETAIL_REV());

			}

			if (vo.getJOBORDER_DETAIL_SERIALNO() == null) {
				vo.setJOBORDER_DETAIL_SERIALNO(null);
			} else {

				String JOBORDER_DETAIL_SERIALNO = new String(vo.getJOBORDER_DETAIL_SERIALNO().getBytes("8859_1"),
						"UTF-8");
				vo.setJOBORDER_DETAIL_SERIALNO(JOBORDER_DETAIL_SERIALNO);

				// System.out.println(vo.getJOBORDER_DETAIL_SERIALNO());

				// vo.setJOBORDER_DETAIL_SERIALNO(vo.getJOBORDER_DETAIL_SERIALNO());

			}

			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");

			Date to = fm.parse(conv);
			Date to2 = fm.parse(conv2);

			vo.setJOBORDER_DETAIL_PLANENDDAY(to2);
			vo.setJOBORDER_DETAIL_DEILVERYDAY(to);

			service.RegisterJoborderDetail(vo);

			int ORG_JOBORDER_DETAIL_ID = vo.JOBORDER_DETAIL_ID;

			String JOBORDER_CODEFILE = new String(vo.getJOBORDER_CODEFILE().getBytes("8859_1"), "UTF-8");

			vo.setJOBORDER_CODEFILE(JOBORDER_CODEFILE);

			String JOBORDER_INSPECTIONFILE = new String(vo.getJOBORDER_INSPECTIONFILE().getBytes("8859_1"), "UTF-8");

			vo.setJOBORDER_INSPECTIONFILE(JOBORDER_INSPECTIONFILE);

			// vo.setJOBORDER_CODEFILE(vo.getJOBORDER_CODEFILE());

			vo.setJOBORDER_DETAIL_ID(ORG_JOBORDER_DETAIL_ID);

			// 로비 활성화는 변경점이 필요
			// vo.setJOBORDER_LOBBY_ACTIVITY_ID(4);

			// 작지 상태
			vo.setJOBORDER_STATUS_ID(1);
			// 작비 배포설정
			vo.setJOBORDER_PUBLISH(0);

			vo.setJOBORDER_WORKINSPECTIONFILE("");

			// 작지 생성 후
			service.RegisterJoborder(vo);

			int ORG_JOBORDER_ID = vo.JOBORDER_ID;

			System.out.println(ORG_JOBORDER_ID);

			// C로 디렉 변경

			String path = ("C:\\Html\\factory\\admin\\qrcode\\");

			String dbpath = ("http://182.208.252.210:5995/factory/admin/qrcode/");
			
			// String path = ("D:\\QR Test\\");

			String realpath = path + time1;

			String dbrealpath = dbpath+time1;
			
			File Folder = new File(realpath);

			Folder.mkdirs();

			JsonObject obj = new JsonObject();

			obj.addProperty("JOBORDER_ID", ORG_JOBORDER_ID);

			String cv = obj.toString();

			File saveQR = new File(realpath + "\\" + time1 + ".png");

			// QR코드인식 시 링크 걸 URL 주소
			String codeurl = new String(cv.getBytes("UTF-8"), "ISO-8859-1");

			System.out.println(saveQR);

			// QR코드 컬러
			int qrcodeColor = 0xFF2e4e96;

			// QR코드 배경색상값
			int backgroundColor = 0xFFFFFFFF;

			QRCodeWriter qrCodeWriter = new QRCodeWriter();

			// QR Code의 Width, Height 값
			BitMatrix bitMatrix = qrCodeWriter.encode(codeurl, BarcodeFormat.QR_CODE, 200, 200);

			MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig(qrcodeColor, backgroundColor);

			BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix, matrixToImageConfig);

			// ImageIO를 사용한 바코드 파일 쓰기
			ImageIO.write(bufferedImage, "png", saveQR);

			String saveDir = saveQR.toString();

			String saveDbDir = (dbrealpath + "/" + time1 + ".png");
			
			System.out.println(saveDir);

			System.out.println("DB 경로명 : " + saveDbDir);
			
			vo.setQRCODE_DIRECTORY(saveDbDir);
			vo.setJOBORDER_ID(ORG_JOBORDER_ID);

			// 작지 QR 생성
			service.RegisterQRCode(vo);

			ArrayList<Integer> JbProcessList = new ArrayList<Integer>();

			ArrayList<String> JoborderFileDirList = new ArrayList<String>();
			ArrayList<String> JoborderFileNameList = new ArrayList<String>();

			System.out.println("여기까지 못오는거지?");

			// 작지 공정 생성
			for (int i = 0; i < vo.getORIGIN_PROCESS_ID2().length; i++) {


				
				String JOBORDER_PROCESS_SELFINSPECT_FILE2 = new String(
				vo.getJOBORDER_PROCESS_SELFINSPECT_FILE2()[i].getBytes("8859_1"), "UTF-8");
				
				String ConvPlanEndDay = new String(vo.getCONVERT_JOBORDER_PROCESS_PLANENDDAY2()[i].getBytes("8859_1"), "UTF-8");
				
				
				String ConJOBORDER_PROCESS_CUSTOMERNAME = new String(vo.getJOBORDER_PROCESS_CUSTOMERNAME2()[i].getBytes("8859_1"), "UTF-8");
				
				Date to3 = fm.parse(ConvPlanEndDay);
				
				System.out.println("getORIGIN_PROCESS_ID2" + vo.getORIGIN_PROCESS_ID2()[i]);
				System.out.println("JOBORDER_ID" +  ORG_JOBORDER_ID);
				System.out.println("JOBORDER_PROCESS_INDEX" + vo.getJOBORDER_PROCESS_INDEX2()[i]);
				System.out.println("JOBORDER_PROCESS_WORKTIME" + vo.getJOBORDER_PROCESS_WORKTIME2()[i]);
				System.out.println("JOBORDER_PROCESS_SELFINSPECT_FILE" + JOBORDER_PROCESS_SELFINSPECT_FILE2);
				System.out.println("JOBORDER_PROCESS_SELFINSPECT_FILE_CHECK2" + vo.getJOBORDER_PROCESS_SELFINSPECT_FILE_CHECK2()[i]);
				System.out.println("JOBORDER_PROCESS_PLANENDDAY" + to3);
				System.out.println("JOBORDER_PROCESS_CUSTOMERNAME" + ConJOBORDER_PROCESS_CUSTOMERNAME);
				
				vo.setORIGIN_PROCESS_ID(vo.getORIGIN_PROCESS_ID2()[i]);
				vo.setJOBORDER_ID(ORG_JOBORDER_ID);
				vo.setJOBORDER_PROCESS_INDEX(vo.getJOBORDER_PROCESS_INDEX2()[i]);
				vo.setJOBORDER_PROCESS_WORKTIME(vo.getJOBORDER_PROCESS_WORKTIME2()[i]);

				// vo.setJOBORDER_PROCESS_SELFINSPECT_FILE(vo.getJOBORDER_PROCESS_SELFINSPECT_FILE2()[i]);

				vo.setJOBORDER_PROCESS_SELFINSPECT_FILE(JOBORDER_PROCESS_SELFINSPECT_FILE2);

				vo.setJOBORDER_PROCESS_SELFINSPECT_FILE_CHECK(vo.getJOBORDER_PROCESS_SELFINSPECT_FILE_CHECK2()[i]);
				
				vo.setJOBORDER_PROCESS_PLANENDDAY(to3);
				vo.setJOBORDER_PROCESS_CUSTOMERNAME(ConJOBORDER_PROCESS_CUSTOMERNAME);
				
				service.RegisterJoborderProcess(vo);

				int JOBORDER_PROCESS_ID = vo.JOBORDER_PROCESS_ID;

				System.out.println(JOBORDER_PROCESS_ID);
				
				JbProcessList.add(JOBORDER_PROCESS_ID);
			}

			ArrayList<Integer> JbFileTypeList = new ArrayList<Integer>();

			ArrayList<String> SPFileNameList = new ArrayList<String>();
			ArrayList<String> SPFileDirList = new ArrayList<String>();

			if (vo.getSETTING_PRESET_FILE_MANAGEMENT_ID2() == null) {

			} else {

				for (int i = 0; i < vo.getSETTING_PRESET_FILE_MANAGEMENT_ID2().length; i++) {

					vo.setSETTING_PRESET_FILE_MANAGEMENT_ID(vo.getSETTING_PRESET_FILE_MANAGEMENT_ID2()[i]);

					List<JoborderVO> resultlist = service.SelectPresetFile(vo);

					int JOBORDER_FILE_TYPE_ID = resultlist.get(0).JOBORDER_FILE_TYPE_ID;
					String SETTING_PRESET_FILE_MANAGEMENT_NAME = resultlist.get(0).SETTING_PRESET_FILE_MANAGEMENT_NAME;
					String SETTING_PRESET_FILE_MANAGEMENT_DIRECTORY = resultlist.get(0).SETTING_PRESET_FILE_MANAGEMENT_DIRECTORY;

					File in = new File(SETTING_PRESET_FILE_MANAGEMENT_DIRECTORY);

					// C로 디렉 변경

					String path2 = ("C:\\Html\\factory\\worker\\worker\\pdfs\\");

					String dbpath2 = ("http://182.208.252.210:5995/factory/worker/worker/pdfs/");
					
					String realpath2 = path2 + time1;

					String dbrealpath2 = dbpath2 + time1;
					
					File Folder2 = new File(realpath2);

					Folder2.mkdirs();

					String copyFile = realpath2 + "\\" + SETTING_PRESET_FILE_MANAGEMENT_NAME;

					String dbcopyFile = dbrealpath2 + '/' + SETTING_PRESET_FILE_MANAGEMENT_NAME;
					
					File out = new File(copyFile);

					FileCopyUtils.copy(in, out);

					JbFileTypeList.add(JOBORDER_FILE_TYPE_ID);
					SPFileNameList.add(SETTING_PRESET_FILE_MANAGEMENT_NAME);
					SPFileDirList.add(dbcopyFile);
				}

				for (int i = 0; i < JbFileTypeList.size(); i++) {

					vo.setJOBORDER_ID(ORG_JOBORDER_ID);
					vo.setJOBORDER_FILE_TYPE_ID(JbFileTypeList.get(i));
					vo.setJOBORDER_FILE_MANAGEMENT_NAME(SPFileNameList.get(i));
					vo.setJOBORDER_FILE_MANAGEMENT_DIRECTORY(SPFileDirList.get(i));

					service.RegisterJoborderFile(vo);
				}
			}

			/*
			 * if(vo.getSETTING_PRESET_ID() == null) {
			 * 
			 * }else {
			 * 
			 * //작지 파일(프리셋) List<JoborderVO> resultlist = service.SelectPresetFile(vo);
			 * 
			 * 
			 * for(int i = 0; i < resultlist.size(); i++) {
			 * 
			 * int JOBORDER_FILE_TYPE_ID = resultlist.get(i).JOBORDER_FILE_TYPE_ID; String
			 * SETTING_PRESET_FILE_MANAGEMENT_NAME =
			 * resultlist.get(i).SETTING_PRESET_FILE_MANAGEMENT_NAME; String
			 * SETTING_PRESET_FILE_MANAGEMENT_DIRECTORY =
			 * resultlist.get(i).SETTING_PRESET_FILE_MANAGEMENT_DIRECTORY;
			 * 
			 * File in = new File(SETTING_PRESET_FILE_MANAGEMENT_DIRECTORY);
			 * 
			 * String path2 = ("D:\\JoborderFile\\");
			 * 
			 * String realpath2 = path2+time1;
			 * 
			 * File Folder2 = new File(realpath2);
			 * 
			 * Folder2.mkdirs();
			 * 
			 * String copyFile = realpath2+"\\"+SETTING_PRESET_FILE_MANAGEMENT_NAME;
			 * 
			 * File out = new File(copyFile);
			 * 
			 * FileCopyUtils.copy(in, out);
			 * 
			 * JbFileTypeList.add(JOBORDER_FILE_TYPE_ID);
			 * SPFileNameList.add(SETTING_PRESET_FILE_MANAGEMENT_NAME);
			 * SPFileDirList.add(copyFile); }
			 * 
			 * for(int i = 0; i < JbFileTypeList.size(); i++) {
			 * 
			 * vo.setJOBORDER_ID(ORG_JOBORDER_ID);
			 * vo.setJOBORDER_FILE_TYPE_ID(JbFileTypeList.get(i));
			 * vo.setJOBORDER_FILE_MANAGEMENT_NAME(SPFileNameList.get(i));
			 * vo.setJOBORDER_FILE_MANAGEMENT_DIRECTORY(SPFileDirList.get(i));
			 * 
			 * service.RegisterJoborderFile(vo); } }
			 * 
			 * 
			 */

			// 작지 파일(직접 생성용)
			List<MultipartFile> filelist2 = request.getFiles("JoborderFile");

			for (MultipartFile mf : filelist2) {

				// C로 디렉 변경
				String path2 = ("C:\\Html\\factory\\worker\\worker\\pdfs\\");

				String dbpath2 = ("http://182.208.252.210:5995/factory/worker/worker/pdfs/");
				
				String realpath2 = path2 + time1;

				String dbrealpath2 = dbpath2 + time1;
				
				File Folder2 = new File(realpath2);

				Folder2.mkdirs();

				String Filename = new String(mf.getOriginalFilename().getBytes("8859_1"), "UTF-8");

				File saveFile = new File(realpath2 + "\\" + Filename);

				mf.transferTo(saveFile);

				String directory = saveFile.toString();

				String Dbdirc = dbrealpath2 + "/" + Filename;
				
				JoborderFileDirList.add(Dbdirc);
				JoborderFileNameList.add(Filename);

			}

			if (vo.getJOBORDER_FILE_TYPE_ID2() == null) {

			} else {

				for (int i = 0; i < vo.getJOBORDER_FILE_TYPE_ID2().length; i++) {

					vo.setJOBORDER_ID(ORG_JOBORDER_ID);
					vo.setJOBORDER_FILE_TYPE_ID(vo.getJOBORDER_FILE_TYPE_ID2()[i]);
					vo.setJOBORDER_FILE_MANAGEMENT_NAME(JoborderFileNameList.get(i));
					vo.setJOBORDER_FILE_MANAGEMENT_DIRECTORY(JoborderFileDirList.get(i));

					service.RegisterJoborderFile(vo);
				}
			}

			// 작지 특이사항
			for (int i = 0; i < JbProcessList.size(); i++) {

				for (int j = 0; j < vo.getJOBORDER_UNIQUESS_CONTEXT3()[i].length; j++) {

					vo.setJOBORDER_PROCESS_ID(JbProcessList.get(i));

					String JOBORDER_UNIQUESS_CONTEXT3 = new String(
							vo.getJOBORDER_UNIQUESS_CONTEXT3()[i][j].getBytes("8859_1"), "UTF-8");
					vo.setJOBORDER_UNIQUESS_CONTEXT(JOBORDER_UNIQUESS_CONTEXT3);

					service.RegisterJoborderUniquess(vo);
				}
			}

			vo.setJOBORDER_ID(ORG_JOBORDER_ID);

			List<JoborderVO> result1 = service.SelectJbProcessFile(vo);

			JsonObject obj2 = new JsonObject();

			obj2.addProperty("AllCreateJoborder", 1);

			return obj2.toString();

		} catch (Exception e) {

			JsonObject obj2 = new JsonObject();

			obj2.addProperty("AllCreateJoborder", 0);

			return obj2.toString();

		}
	}

	@RequestMapping(value = "/DetectActiveOn", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<JoborderVO> DetectActiveOn(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "DetectActiveOn");

		List<JoborderVO> result = service.DetectActiveOn(vo);

		if (result.get(0).JOBORDER_LOBBY_ACTIVITY_ID1 == 1 && result.get(0).JOBORDER_LOBBY_ACTIVITY_ID2 == 10
				&& result.get(0).JOBORDER_LOBBY_ACTIVITY_ID3 == 10) {

			System.out.println("현재 넣은 공정은 입고 상태");

		} else if (result.get(0).JOBORDER_LOBBY_ACTIVITY_ID1 == 2 && result.get(0).JOBORDER_LOBBY_ACTIVITY_ID2 == 4
				&& result.get(0).JOBORDER_LOBBY_ACTIVITY_ID3 == 10) {

			System.out.println("현재 넣은 공정은 할당 상태");

		} else if (result.get(0).JOBORDER_LOBBY_ACTIVITY_ID1 == 2 && result.get(0).JOBORDER_LOBBY_ACTIVITY_ID2 == 5
				&& result.get(0).JOBORDER_LOBBY_ACTIVITY_ID3 == 7) {

			System.out.println("현재 넣은 공정은 할당 상태");
		}

		return null;

	}

	@RequestMapping(value = "/UpdateReceiveOn1", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String UpdateReceiveOn1(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "UpdateReceiveOn1");

		System.out.println(vo.getJOBORDER_ID());
		System.out.println(vo.getJOBORDER_PROCESS_ID());
		System.out.println(vo.getPROCESS_MAIN_CATEGORY_ID());
		
		List<JoborderVO> result = service.DetectActiveOn(vo);

		// 1 , 10 , 10 일때만 당연히 입고되야함

		// 입고, 할당 하기전에 조건문 마련
		if (result.get(0).JOBORDER_LOBBY_ACTIVITY_ID1 == 1 && result.get(0).JOBORDER_LOBBY_ACTIVITY_ID2 == 10
				&& result.get(0).JOBORDER_LOBBY_ACTIVITY_ID3 == 10 && result.get(0).JOBORDER_PROCESS_FOCUSON == 1) {

			service.UpdateReceiveOn1(vo);

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateReceiveOn1", 1);

			return obj.toString();

		} else {

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateReceiveOn1", 0);

			return obj.toString();
		}

	}

	@RequestMapping(value = "/UpdateReceiveCancel", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String UpdateReceiveCancel(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "UpdateReceiveCancel");

		List<JoborderVO> result = service.DetectActiveOn(vo);

		// 2 , 4 , 10 일때만 당연히 입고취소되야함

		// 입고, 할당 하기전에 조건문 마련
		if (result.get(0).JOBORDER_LOBBY_ACTIVITY_ID1 == 2 && result.get(0).JOBORDER_LOBBY_ACTIVITY_ID2 == 4
				&& result.get(0).JOBORDER_LOBBY_ACTIVITY_ID3 == 10 && result.get(0).JOBORDER_PROCESS_FOCUSON == 1) {

			service.UpdateReceiveCancel(vo);

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateReceiveCancel", 1);

			return obj.toString();

		} else {

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateReceiveCancel", 0);

			return obj.toString();
		}

	}

	@RequestMapping(value = "/UpdateAssignOn1", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String UpdateAssignOn1(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "UpdateAssignOn1");

		List<JoborderVO> result = service.DetectActiveOn(vo);

		// 입고, 할당 하기전에 조건문 마련
		if (result.get(0).JOBORDER_LOBBY_ACTIVITY_ID1 == 2 && result.get(0).JOBORDER_LOBBY_ACTIVITY_ID2 == 4
				&& result.get(0).JOBORDER_LOBBY_ACTIVITY_ID3 == 10 && result.get(0).JOBORDER_PROCESS_FOCUSON == 1) {

			service.UpdateAssignOn1(vo);

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateAssignOn1", 1);

			return obj.toString();

		} else {

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateAssignOn1", 0);

			return obj.toString();
		}

	}

	@RequestMapping(value = "/UpdateAssignCancel", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String UpdateAssignCancel(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "UpdateAssignCancel");

		List<JoborderVO> result = service.DetectActiveOn(vo);

		// 입고, 할당 하기전에 조건문 마련
		if (result.get(0).JOBORDER_LOBBY_ACTIVITY_ID1 == 2 && result.get(0).JOBORDER_LOBBY_ACTIVITY_ID2 == 5
				&& result.get(0).JOBORDER_LOBBY_ACTIVITY_ID3 == 7 && result.get(0).JOBORDER_PROCESS_FOCUSON == 1) {

			service.UpdateAssignCancel(vo);

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateAssignCancel", 1);

			return obj.toString();

		} else {

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateAssignCancel", 0);

			return obj.toString();
		}

	}

	// 할당 변경 계정 넣기
	@RequestMapping(value = "/UpdateAssignWorker", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String UpdateAssignWorker(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "UpdateAssignWorker");

		List<JoborderVO> result = service.DetectActiveStart(vo);

		// 작업중지 상태 -> 할당이 되어있겠지? 이 상태에서 할당을 변경 할 때
		if (result.get(0).JOBORDER_LOBBY_ACTIVITY_ID1 == 2 && result.get(0).JOBORDER_LOBBY_ACTIVITY_ID2 == 5
				&& result.get(0).JOBORDER_LOBBY_ACTIVITY_ID3 == 7 && result.get(0).JOBORDER_PROCESS_FOCUSON == 4) {

			service.DeleteJbEquip(vo);

			service.UpdateAssignWorker(vo);

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateAssignWorker", 1);

			return obj.toString();

		}
		// 할당되어있는데 작업반장이 계정을 바꿀 때
		else if (result.get(0).JOBORDER_LOBBY_ACTIVITY_ID1 == 2 && result.get(0).JOBORDER_LOBBY_ACTIVITY_ID2 == 5
				&& result.get(0).JOBORDER_LOBBY_ACTIVITY_ID3 == 7 && result.get(0).JOBORDER_PROCESS_FOCUSON == 1) {

			service.DeleteJbEquip(vo);

			service.UpdateAssignWorker(vo);

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateAssignWorker", 1);

			return obj.toString();

			// 공정 목록에는 있는데 아무도 안가져가서 계정이 없는 상태 작언반장이 누군가한테 넣어서 강제적 할당 상태
		} else if (result.get(0).JOBORDER_LOBBY_ACTIVITY_ID1 == 2 && result.get(0).JOBORDER_LOBBY_ACTIVITY_ID2 == 4
				&& result.get(0).JOBORDER_LOBBY_ACTIVITY_ID3 == 10 && result.get(0).JOBORDER_PROCESS_FOCUSON == 1) {

			service.DeleteJbEquip(vo);

			service.UpdateAssignOn1(vo);

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateAssignCancel", 1);

			return obj.toString();

		} else {

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateAssignCancel", 0);

			return obj.toString();
		}

	}

	// 할당 변경 계정되는 리스트
	@RequestMapping(value = "/AssignWorkerList", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<JoborderVO> AssignWorkerList(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "AssignWorkerList");

		return service.AssignWorkerList(vo);

	}

	@RequestMapping(value = "/SelectJoborderID", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<JoborderVO> SelectJoborderID(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "SelectJoborderID");

		return service.SelectJoborderID(vo);

	}

	@RequestMapping(value = "/SelectJoborderIDProcess", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<JoborderVO> SelectJoborderIDProcess(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "SelectJoborderIDProcess");

		return service.SelectJoborderIDProcess(vo);

	}

	@RequestMapping(value = "/SelectJbProcessRevise", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<JoborderVO> SelectJbProcessRevise(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "SelectJbProcessRevise");

		return service.SelectJbProcessRevise(vo);

	}

	// 작지 공정 조회 수정이력 포함

	// 작업자 목록에서 작업지시서 선택했을 때 View

	// 작업지시서 첫 시작 시 Total적으로 이루어져야할 것들
	@RequestMapping(value = "/FirstStartJbWork", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String FirstStartJbWork(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "FirstStartJbWork");

		List<JoborderVO> result = service.DetectActiveStart(vo);

		List<JoborderVO> ChkIndexList = service.ChkJbProcess(vo);

		ArrayList<Integer> IndexList = new ArrayList<Integer>();

		for (int i = 0; i < ChkIndexList.size(); i++) {

			int INDEX = ChkIndexList.get(i).JOBORDER_PROCESS_INDEX;

			IndexList.add(INDEX);
		}

		int min = Collections.min(IndexList);
		int max = Collections.max(IndexList);

		// 첫 공정이 가장 작은 공정일 경우니까 첫번째
		if (result.get(0).JOBORDER_PROCESS_INDEX == min) {

			// 작업 시작 전에 조건문 마련
			if (result.get(0).JOBORDER_LOBBY_ACTIVITY_ID1 == 2 && result.get(0).JOBORDER_LOBBY_ACTIVITY_ID2 == 5
					&& result.get(0).JOBORDER_LOBBY_ACTIVITY_ID3 == 7 && result.get(0).JOBORDER_PROCESS_FOCUSON == 1) {

				// 작지 공정이력 등록
				vo.setJOBORDER_PROCESS_STATUS_ID1(1);
				vo.setJOBORDER_PROCESS_RESULT_STARTTIME(time);

				service.StartJbProcessResult(vo);

				int ORG_JOBORDER_PROCESS_RESULT_ID = vo.JOBORDER_PROCESS_RESULT_ID;

				// 작업지시서 첫 공정시작 시 업데이트
				// 첫 공정 작업시작만 포함되는 부분이다.
				// 생산진행중도
				vo.setJOBORDER_STARTDAY(time);

				service.UpdateStartJoborder(vo);

				// 작업지시서 공정 업데이트
				vo.setJOBORDER_PROCESS_STARTDAY(time);

				// 작지 공정 생성 시 나올 키 값으로 넣을 것 현재 1은 테스트용
				vo.setJOBORDER_PROCESS_RESULT_ID(ORG_JOBORDER_PROCESS_RESULT_ID);

				service.UpdateStartJbProcess(vo);

				// 로그 테이블 등록
				service.StartLogRegister(vo);

				// 공정 설비 지정
				service.RegisterJoborderEquipment(vo);

				int JOBORDER_EQUIPMENT_ID = vo.JOBORDER_EQUIPMENT_ID;

				JsonObject obj = new JsonObject();

				obj.addProperty("JOBORDER_PROCESS_RESULT_ID", ORG_JOBORDER_PROCESS_RESULT_ID);
				obj.addProperty("JOBORDER_EQUIPMENT_ID", JOBORDER_EQUIPMENT_ID);
				obj.addProperty("FirstStartJbWork", 1);
				
				return obj.toString();

			} else {

				JsonObject obj = new JsonObject();

				obj.addProperty("FirstStartJbWork", 0);

				return obj.toString();

			}

			// 그 외에 가장 큰 공정이 아님
		} else {

			if (result.get(0).JOBORDER_LOBBY_ACTIVITY_ID1 == 2 && result.get(0).JOBORDER_LOBBY_ACTIVITY_ID2 == 5
					&& result.get(0).JOBORDER_LOBBY_ACTIVITY_ID3 == 7 && result.get(0).JOBORDER_PROCESS_FOCUSON == 1) {

				// 작지 공정이력 등록
				vo.setJOBORDER_PROCESS_STATUS_ID1(1);
				vo.setJOBORDER_PROCESS_RESULT_STARTTIME(time);

				service.StartJbProcessResult(vo);

				int ORG_JOBORDER_PROCESS_RESULT_ID = vo.JOBORDER_PROCESS_RESULT_ID;

				// 작업지시서 공정 업데이트
				vo.setJOBORDER_PROCESS_STARTDAY(time);

				// 작지 공정 생성 시 나올 키 값으로 넣을 것 현재 1은 테스트용
				vo.setJOBORDER_PROCESS_RESULT_ID(ORG_JOBORDER_PROCESS_RESULT_ID);

				service.UpdateStartJbProcess(vo);

				// 로그 테이블 등록
				service.StartLogRegister(vo);

				// 공정 설비 지정
				service.RegisterJoborderEquipment(vo);

				int JOBORDER_EQUIPMENT_ID = vo.JOBORDER_EQUIPMENT_ID;

				JsonObject obj = new JsonObject();

				obj.addProperty("JOBORDER_PROCESS_RESULT_ID", ORG_JOBORDER_PROCESS_RESULT_ID);
				obj.addProperty("JOBORDER_EQUIPMENT_ID", JOBORDER_EQUIPMENT_ID);
				obj.addProperty("FirstStartJbWork", 1);
				
				return obj.toString();

			} else {

				JsonObject obj = new JsonObject();

				obj.addProperty("FirstStartJbWork", 0);

				return obj.toString();

			}

		}

	}

	// 작업지시서 취소 시 Total변경될 것들
	@RequestMapping(value = "/FirstCancelJbWork", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String FirstCancelJbWork(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "FirstCancelJbWork");

		
		
		
		System.out.println(vo.getJOBORDER_PROCESS_ID());
		System.out.println(vo.getJOBORDER_PROCESS_RESULT_ID());
		System.out.println(vo.getJOBORDER_EQUIPMENT_ID());
		System.out.println(vo.getJOBORDER_ID());
		
		// 공정 처음과 맨 마지막 알기위해 만든 코드
		List<JoborderVO> ChkIndexList = service.ChkJbProcess(vo);

		ArrayList<Integer> IndexList = new ArrayList<Integer>();

		for (int i = 0; i < ChkIndexList.size(); i++) {

			int INDEX = ChkIndexList.get(i).JOBORDER_PROCESS_INDEX;

			IndexList.add(INDEX);
		}

		int minl = Collections.min(IndexList);
		int maxl = Collections.max(IndexList);

		List<JoborderVO> result = service.DetectActiveStart(vo);

		// 첫번 째 공정일 때
		
		
		
		
		if (result.get(0).JOBORDER_PROCESS_INDEX == minl) {

			//정지상태에서 취소를 누를 경우
			if (result.get(0).JOBORDER_LOBBY_ACTIVITY_ID1 == 2 && result.get(0).JOBORDER_LOBBY_ACTIVITY_ID2 == 5
					&& result.get(0).JOBORDER_LOBBY_ACTIVITY_ID3 == 7 && result.get(0).JOBORDER_PROCESS_FOCUSON == 4) {
				
				if(vo.getJOBORDER_EQUIPMENT_ID() == 0) {
					
					// 로그 삭제
					// 키 값 : JOBORDER_ID, JOBORDER_PROCESS_ID
					service.DeleteFirstCancelLog(vo);

					// 공정 상태 되돌리기
					// 키 값 : JOBORDER_PROCESS_ID
					service.UpdateFirstCancelJbProcess(vo);

					// 공정 이력 삭제
					// 키 값 : JOBORDER_PROCESS_RESULT_ID
					service.DeleteFirstCancelJbPrcoessResult(vo);

					// 작업지시서 상태 되돌리기
					// 키 값 : JOBORDER_ID
					service.UpdateFirstCancelJoborder(vo);
					

					// 작업지시서 코드 업데이트
					// 키 값 : JOBORDER_ID
					service.UpdateJoborderCode(vo);

					
					// 작업지시서 자주검사 코드 업데이트
					service.UpdateJbInspection(vo);
					
					// 작업지시서 공정 첨부파일 삭제
					service.DeleteProcessWorkerFile(vo);
					
					JsonObject obj = new JsonObject();

					obj.addProperty("FirstCancelJbWork", 1);

					return obj.toString();
					
				}else {
					
					// 로그 삭제
					// 키 값 : JOBORDER_ID, JOBORDER_PROCESS_ID
					service.DeleteFirstCancelLog(vo);

					// 공정 상태 되돌리기
					// 키 값 : JOBORDER_PROCESS_ID
					service.UpdateFirstCancelJbProcess(vo);

					// 공정 이력 삭제
					// 키 값 : JOBORDER_PROCESS_RESULT_ID
					service.DeleteFirstCancelJbPrcoessResult(vo);

					// 작업지시서 상태 되돌리기
					// 키 값 : JOBORDER_ID
					service.UpdateFirstCancelJoborder(vo);
					
					// 설비 삭제
					// 키 값 : JOBORDER_EQUIPMENT_ID, JOBORDER_PROCESS_ID
					service.DeleteFirstCancelJbEquip(vo);


					// 작업지시서 코드 업데이트
					// 키 값 : JOBORDER_ID
					service.UpdateJoborderCode(vo);

					// 작업지시서 자주검사 코드 업데이트
					service.UpdateJbInspection(vo);
					
					// 작업지시서 공정 첨부파일 삭제
					service.DeleteProcessWorkerFile(vo);
					
					
					JsonObject obj = new JsonObject();

					obj.addProperty("FirstCancelJbWork", 1);

					return obj.toString();
					
				}
				
			}
			
			if (result.get(0).JOBORDER_LOBBY_ACTIVITY_ID1 == 3 && result.get(0).JOBORDER_LOBBY_ACTIVITY_ID2 == 6
					&& result.get(0).JOBORDER_LOBBY_ACTIVITY_ID3 == 9 && result.get(0).JOBORDER_PROCESS_FOCUSON == 2) {

				
				
				
				
				if(vo.getJOBORDER_EQUIPMENT_ID() == 0) {
				
					System.out.println("설비가 0 값이여서 들어온게 맞음");
					
					// 로그 삭제
					// 키 값 : JOBORDER_ID, JOBORDER_PROCESS_ID
					service.DeleteFirstCancelLog(vo);

					// 공정 상태 되돌리기
					// 키 값 : JOBORDER_PROCESS_ID
					service.UpdateFirstCancelJbProcess(vo);

					// 공정 이력 삭제
					// 키 값 : JOBORDER_PROCESS_RESULT_ID
					service.DeleteFirstCancelJbPrcoessResult(vo);

					// 작업지시서 상태 되돌리기
					// 키 값 : JOBORDER_ID
					service.UpdateFirstCancelJoborder(vo);
					

					// 작업지시서 코드 업데이트
					// 키 값 : JOBORDER_ID
					service.UpdateJoborderCode(vo);
				
					// 작업지시서 자주검사 코드 업데이트
					service.UpdateJbInspection(vo);
					
					// 작업지시서 공정 첨부파일 삭제
					service.DeleteProcessWorkerFile(vo);
					
					
					JsonObject obj = new JsonObject();

					obj.addProperty("FirstCancelJbWork", 1);

					return obj.toString();
					
				}else {
					
					// 로그 삭제
					// 키 값 : JOBORDER_ID, JOBORDER_PROCESS_ID
					service.DeleteFirstCancelLog(vo);

					// 공정 상태 되돌리기
					// 키 값 : JOBORDER_PROCESS_ID
					service.UpdateFirstCancelJbProcess(vo);

					// 공정 이력 삭제
					// 키 값 : JOBORDER_PROCESS_RESULT_ID
					service.DeleteFirstCancelJbPrcoessResult(vo);

					// 작업지시서 상태 되돌리기
					// 키 값 : JOBORDER_ID
					service.UpdateFirstCancelJoborder(vo);

					// 설비 삭제
					// 키 값 : JOBORDER_EQUIPMENT_ID, JOBORDER_PROCESS_ID
					service.DeleteFirstCancelJbEquip(vo);


					// 작업지시서 코드 업데이트
					// 키 값 : JOBORDER_ID
					service.UpdateJoborderCode(vo);
	
					// 작업지시서 자주검사 코드 업데이트
					service.UpdateJbInspection(vo);
					
					// 작업지시서 공정 첨부파일 삭제
					service.DeleteProcessWorkerFile(vo);
					
					
					JsonObject obj = new JsonObject();

					obj.addProperty("FirstCancelJbWork", 1);

					return obj.toString();
					
				}
				


			} else {

				JsonObject obj = new JsonObject();

				obj.addProperty("FirstCancelJbWork", 0);

				return obj.toString();
			}

		}
		// 첫 공정 취소가 아닐 때
		else {

			//정지상태에서 취소를 누를 경우
			if (result.get(0).JOBORDER_LOBBY_ACTIVITY_ID1 == 2 && result.get(0).JOBORDER_LOBBY_ACTIVITY_ID2 == 5
					&& result.get(0).JOBORDER_LOBBY_ACTIVITY_ID3 == 7 && result.get(0).JOBORDER_PROCESS_FOCUSON == 4) {
				
				if(vo.getJOBORDER_EQUIPMENT_ID() == 0) {
					
					System.out.println("설비가 0 값이여서 들어온게 맞음");
					
					// 로그 삭제
					// 키 값 : JOBORDER_ID, JOBORDER_PROCESS_ID
					service.DeleteFirstCancelLog(vo);

					// 공정 상태 되돌리기
					// 키 값 : JOBORDER_PROCESS_ID
					service.UpdateFirstCancelJbProcess(vo);

					// 공정 이력 삭제
					// 키 값 : JOBORDER_PROCESS_RESULT_ID
					service.DeleteFirstCancelJbPrcoessResult(vo);

					// 작업지시서 상태 되돌리기
					// 키 값 : JOBORDER_ID
					service.UpdateFirstCancelJoborder(vo);


					// 작업지시서 코드 업데이트
					// 키 값 : JOBORDER_ID
					service.UpdateJoborderCode(vo);
						
					// 작업지시서 자주검사 코드 업데이트
					service.UpdateJbInspection(vo);
					
					// 작업지시서 공정 첨부파일 삭제
					service.DeleteProcessWorkerFile(vo);
					
					JsonObject obj = new JsonObject();

					obj.addProperty("FirstCancelJbWork", 1);

					return obj.toString();
					
				}else {
					
					// 로그 삭제
					// 키 값 : JOBORDER_ID, JOBORDER_PROCESS_ID
					service.DeleteFirstCancelLog(vo);

					// 공정 상태 되돌리기
					// 키 값 : JOBORDER_PROCESS_ID
					service.UpdateFirstCancelJbProcess(vo);

					// 공정 이력 삭제
					// 키 값 : JOBORDER_PROCESS_RESULT_ID
					service.DeleteFirstCancelJbPrcoessResult(vo);

					// 작업지시서 상태 되돌리기
					// 키 값 : JOBORDER_ID
					service.UpdateFirstCancelJoborder(vo);

					// 설비 삭제
					// 키 값 : JOBORDER_EQUIPMENT_ID, JOBORDER_PROCESS_ID
					service.DeleteFirstCancelJbEquip(vo);


					// 작업지시서 코드 업데이트
					// 키 값 : JOBORDER_ID
					service.UpdateJoborderCode(vo);

					// 작업지시서 자주검사 코드 업데이트
					service.UpdateJbInspection(vo);
					
					// 작업지시서 공정 첨부파일 삭제
					service.DeleteProcessWorkerFile(vo);
					
					
					JsonObject obj = new JsonObject();

					obj.addProperty("FirstCancelJbWork", 1);

					return obj.toString();
					
				}
				
				
			}
			
			
			if (result.get(0).JOBORDER_LOBBY_ACTIVITY_ID1 == 3 && result.get(0).JOBORDER_LOBBY_ACTIVITY_ID2 == 6
					&& result.get(0).JOBORDER_LOBBY_ACTIVITY_ID3 == 9 && result.get(0).JOBORDER_PROCESS_FOCUSON == 2) {

				System.out.println(vo.getJOBORDER_EQUIPMENT_ID());
				
				if(vo.getJOBORDER_EQUIPMENT_ID() == 0) {
					
					System.out.println("설비가 0 값이여서 들어온게 맞음");
					
					// 로그 삭제
					// 키 값 : JOBORDER_ID, JOBORDER_PROCESS_ID
					service.DeleteFirstCancelLog(vo);

					// 공정 상태 되돌리기
					// 키 값 : JOBORDER_PROCESS_ID
					service.UpdateFirstCancelJbProcess(vo);

					// 공정 이력 삭제
					// 키 값 : JOBORDER_PROCESS_RESULT_ID
					service.DeleteFirstCancelJbPrcoessResult(vo);

					// 작업지시서 상태 되돌리기
					// 키 값 : JOBORDER_ID
					service.UpdateFirstCancelJoborder(vo);


					// 작업지시서 코드 업데이트
					// 키 값 : JOBORDER_ID
					service.UpdateJoborderCode(vo);

					// 작업지시서 자주검사 코드 업데이트
					service.UpdateJbInspection(vo);
					
					// 작업지시서 공정 첨부파일 삭제
					service.DeleteProcessWorkerFile(vo);
					
					
					
					JsonObject obj = new JsonObject();

					obj.addProperty("FirstCancelJbWork", 1);

					return obj.toString();
					
					
				}else {
					
					// 로그 삭제
					// 키 값 : JOBORDER_ID, JOBORDER_PROCESS_ID
					service.DeleteFirstCancelLog(vo);

					// 공정 상태 되돌리기
					// 키 값 : JOBORDER_PROCESS_ID
					service.UpdateFirstCancelJbProcess(vo);

					// 공정 이력 삭제
					// 키 값 : JOBORDER_PROCESS_RESULT_ID
					service.DeleteFirstCancelJbPrcoessResult(vo);

					// 작업지시서 상태 되돌리기
					// 키 값 : JOBORDER_ID
					service.UpdateFirstCancelJoborder(vo);

					// 설비 삭제
					// 키 값 : JOBORDER_EQUIPMENT_ID, JOBORDER_PROCESS_ID
					service.DeleteFirstCancelJbEquip(vo);


					// 작업지시서 코드 업데이트
					// 키 값 : JOBORDER_ID
					service.UpdateJoborderCode(vo);	
					
					// 작업지시서 자주검사 코드 업데이트
					service.UpdateJbInspection(vo);
					
					// 작업지시서 공정 첨부파일 삭제
					service.DeleteProcessWorkerFile(vo);
					
					
					JsonObject obj = new JsonObject();

					obj.addProperty("FirstCancelJbWork", 1);

					return obj.toString();
					
				}
				


			} else {

				JsonObject obj = new JsonObject();

				obj.addProperty("FirstCancelJbWork", 0);

				return obj.toString();
			}
		}

	}

	// 작업지시서 중지 종료 시 Total변경될 것들
	@RequestMapping(value = "/StopJbWork", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String StopJbWork(@RequestBody JoborderVO vo) throws Exception {

		Date result = service.SelectStartTimeGet(vo);

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		
		
		Date time = new Date();

		logger.info(time + "StopJbWork");

		try {

			// 처음 시작했던 시간
			long orgtime = result.getTime();

			// 현재 시간
			long sectime = time.getTime();

			long runtime = (sectime - orgtime) / 60000;

			// 빼기 (분)
			int min = Long.valueOf(runtime).intValue();

			System.out.println(runtime);
			System.out.println(min);

			vo.setJOBORDER_PROCESS_RESULT_ENDTIME(time);
			vo.setJOBORDER_PROCESS_RESULT_RUNTIME(min);

			// 1. 설비 종료 선언
			//service.UpdateJobEquipStop(vo);

			// 2. 중지 시 잇으면 수량, 불량수량, 불량코드, 양품수량
			service.RegisterProcessResultValue(vo);

			int ORG_PROCESS_RESULT_TEMPLATE_ID = vo.PROCESS_RESULT_TEMPLATE_ID;

			vo.setPROCESS_RESULT_TEMPLATE_ID(ORG_PROCESS_RESULT_TEMPLATE_ID);

			// 3. 작지 공정 이력에 결과 입력 Index 업데이트
			service.UpdateStopJbProcessResult(vo);

			// 4. JobCode 업데이트
			service.UpdateJobCode(vo);
			
			// 5. 중지사유 입력
			service.RegisterJobStopTime(vo);
			
			int JOBORDER_PROCESS_STOPRESULT_ID = vo.JOBORDER_PROCESS_STOPRESULT_ID;
			
			vo.setJOBORDER_PROCESS_ENDDAY(time);

			// 6. 중지 시 작업공정 할당 상태로 변경시켜야함
			service.UpdateStopAssign(vo);

			JsonObject obj = new JsonObject();

			obj.addProperty("JOBORDER_PROCESS_STOPRESULT_ID", JOBORDER_PROCESS_STOPRESULT_ID);
			obj.addProperty("StopJbWork", 1);

			return obj.toString();

		} catch (Exception e) {

			JsonObject obj = new JsonObject();

			obj.addProperty("StopJbWork", 0);

			return obj.toString();

		}

	}
	
	// 작업재개 시 변경될 것들 2 설비값이 날라가서 Null일 때
	@RequestMapping(value = "/RestartJbProcessNull", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String RestartJbProcessNull(@RequestBody JoborderVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "RestartJbProcessNull");
		
		List<JoborderVO> result = service.DetectActiveStart(vo);
		
		List<JoborderVO> FindResult = service.FindProcessStatus(vo);
		
		int JOBORDER_PROCESS_STOPRESULT_ID = FindResult.get(0).JOBORDER_PROCESS_STOPRESULT_ID;
		
		int MAIN_JOBORDER_ID = result.get(0).JOBORDER_ID;
		
		if (result.get(0).JOBORDER_PROCESS_STATUS_ID == 2) {
			
			// 작지 공정이력 등록
			vo.setJOBORDER_PROCESS_STATUS_ID1(1);
			vo.setJOBORDER_PROCESS_RESULT_STARTTIME(time);

			service.StartJbProcessResult(vo);
			
			int ORG_JOBORDER_PROCESS_RESULT_ID = vo.JOBORDER_PROCESS_RESULT_ID;
			
			vo.setJOBORDER_PROCESS_RESULT_ID(ORG_JOBORDER_PROCESS_RESULT_ID);

			vo.setJOBORDER_ID(MAIN_JOBORDER_ID);
			
			// 로그데이터등록
			service.StartLogRegister(vo);
			
			vo.setORIGIN_ACCOUNT_ID(vo.getORIGIN_ACCOUNT_ID());
			
			//작업자 속성에 등록된 설비데이터들
			
			List<JoborderVO> EquipData = service.SelectEquipID(vo);
			
			String ORIGIN_EQUIPMENT_NAME = EquipData.get(0).ORIGIN_EQUIPMENT_NAME;
			String ORIGIN_EQUIPMENT_MODELNAME = EquipData.get(0).ORIGIN_EQUIPMENT_MODELNAME;
			String ORIGIN_EQUIPMENT_CONTEXT = EquipData.get(0).ORIGIN_EQUIPMENT_CONTEXT;
			
			
			vo.setORIGIN_EQUIPMENT_NAME(ORIGIN_EQUIPMENT_NAME);
			vo.setORIGIN_EQUIPMENT_MODELNAME(ORIGIN_EQUIPMENT_MODELNAME);
			vo.setORIGIN_EQUIPMENT_CONTEXT(ORIGIN_EQUIPMENT_CONTEXT);
			
			service.RegisterJoborderEquipment(vo);
		
			int JOBORDER_EQUIPMENT_ID = vo.JOBORDER_EQUIPMENT_ID;
			
			
			System.out.println(vo.getJOBORDER_PROCESS_STOPRESULT_ID());
			
			//작업지시서 재시작 시 중지이력 리스타트값 기입
			vo.setJOBORDER_PROCESS_STOPRESULT_ID(JOBORDER_PROCESS_STOPRESULT_ID);
			vo.setJOBORDER_PROCESS_STOPRESULT_RESTARTTIME(time);
		
			service.UpdateJBRestartTime(vo);
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("JOBORDER_PROCESS_RESULT_ID", ORG_JOBORDER_PROCESS_RESULT_ID);
			obj.addProperty("JOBORDER_EQUIPMENT_ID" , JOBORDER_EQUIPMENT_ID);
			
			return obj.toString();
			
		}else {
			
			JsonObject obj = new JsonObject();

			obj.addProperty("RestartJbProcessNull", 0);

			return obj.toString();
			
		}
		
	}
	

	// 작업재개 시 변경될 것들 설비값이 있을 때
	@RequestMapping(value = "/RestartJbProcess", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String RestartJbProcess(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "RestartJbProcess");

		System.out.println("공정식별키"+vo.getJOBORDER_PROCESS_ID());
		System.out.println("설비식별키"+vo.getJOBORDER_EQUIPMENT_ID());
		System.out.println("작업중지 이력 식별키 "+vo.getJOBORDER_PROCESS_STOPRESULT_ID());
		
		
		
		
		List<JoborderVO> result = service.DetectActiveStart(vo);

		List<JoborderVO> FindResult = service.FindProcessStatus(vo);
		
		int JOBORDER_PROCESS_STOPRESULT_ID = FindResult.get(0).JOBORDER_PROCESS_STOPRESULT_ID;
		
		int MAIN_JOBORDER_ID = result.get(0).JOBORDER_ID;

		// 공정이 작업중지였을 때만 가능한거임
		if (result.get(0).JOBORDER_PROCESS_STATUS_ID == 2) {

			// 작지 공정이력 등록
			vo.setJOBORDER_PROCESS_STATUS_ID1(1);
			vo.setJOBORDER_PROCESS_RESULT_STARTTIME(time);

			service.StartJbProcessResult(vo);

			int ORG_JOBORDER_PROCESS_RESULT_ID = vo.JOBORDER_PROCESS_RESULT_ID;

			vo.setJOBORDER_PROCESS_RESULT_ID(ORG_JOBORDER_PROCESS_RESULT_ID);

			vo.setJOBORDER_ID(MAIN_JOBORDER_ID);

			// 로그데이터등록
			service.StartLogRegister(vo);

			// 설비 재작동 업데이트 // 설비 재등록으로 바꿔야함 재작동이 아님
			service.UpdateRestartJbEquip(vo);

			// 재시작 시 공정 업데이트
			service.UpdateRestartJbProcess(vo);

			
			
			//작업지시서 재시작 시 중지이력 리스타트값 기입
			System.out.println(time);
			
			vo.setJOBORDER_PROCESS_STOPRESULT_ID(JOBORDER_PROCESS_STOPRESULT_ID);
			vo.setJOBORDER_PROCESS_STOPRESULT_RESTARTTIME(time);
		
			service.UpdateJBRestartTime(vo);
			
			JsonObject obj = new JsonObject();

			obj.addProperty("JOBORDER_PROCESS_RESULT_ID", ORG_JOBORDER_PROCESS_RESULT_ID);

			return obj.toString();

		} else {

			JsonObject obj = new JsonObject();

			obj.addProperty("RestartJbProcess", 0);

			return obj.toString();
		}

	}

	@RequestMapping(value = "/ChkJbProcess", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<JoborderVO> ChkJbProcess(@RequestBody JoborderVO vo) throws Exception {

		List<JoborderVO> result = service.ChkJbProcess(vo);

		ArrayList<Integer> IndexList = new ArrayList<Integer>();

		for (int i = 0; i < result.size(); i++) {

			int INDEX = result.get(i).JOBORDER_PROCESS_INDEX;

			IndexList.add(INDEX);
		}

		int min = Collections.min(IndexList);
		int max = Collections.max(IndexList);

		System.out.println(min);
		System.out.println(max);

		System.out.println("인덱스 중 가장큰거하고 작은거 찾아서 다르게 시작과 끝앨 내기 위함의 테스트");

		return null;

	}

	// 작업지시서 작업 완료 시 변경될 것 들
	@RequestMapping(value = "/EndJbProcess", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String EndJbProcess(@RequestBody JoborderVO vo) throws Exception {

		// 작업완료시 필요한 거 -> JOBORDER_PROCESS_RESULT_ID
		Date result = service.SelectStartTimeGet(vo);

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "EndJbProcess");
		
		try {

			List<JoborderVO> ChkIndexList = service.ChkJbProcess(vo);

			ArrayList<Integer> IndexList = new ArrayList<Integer>();

			for (int i = 0; i < ChkIndexList.size(); i++) {

				int INDEX = ChkIndexList.get(i).JOBORDER_PROCESS_INDEX;

				IndexList.add(INDEX);
			}

			int minl = Collections.min(IndexList);
			int maxl = Collections.max(IndexList);

			List<JoborderVO> resultprocess = service.DetectActiveStart(vo);

			// 맨마지막꺼랑 인덱스 같을 경우 즉 맨 마지막임 이게
			if (resultprocess.get(0).JOBORDER_PROCESS_INDEX == maxl) {

				// 처음 시작했던 시간
				long orgtime = result.getTime();

				// 현재 시간
				long sectime = time.getTime();

				long runtime = (sectime - orgtime) / 60000;

				// 빼기 (분)
				int min = Long.valueOf(runtime).intValue();

				vo.setJOBORDER_PROCESS_RESULT_ENDTIME(time);
				vo.setJOBORDER_PROCESS_RESULT_RUNTIME(min);

				// 1. 설비 종료 선언
				service.UpdateJobEquipStop(vo);

				// 2 수량, 불량 수량
				service.RegisterProcessResultValue(vo);

				int ORG_PROCESS_RESULT_TEMPLATE_ID = vo.PROCESS_RESULT_TEMPLATE_ID;

				vo.setPROCESS_RESULT_TEMPLATE_ID(ORG_PROCESS_RESULT_TEMPLATE_ID);

				// 3 JobCode, 및 자주검사성적서 업데이트
				System.out.println(vo.getJOBORDER_INSPECTIONFILE());
				
				service.UpdateJbInspection(vo);

				System.out.println("자주검사 통과");
				
				service.UpdateJobCode(vo);

				vo.setJOBORDER_PROCESS_RESULT_ENDTIME(time);
				vo.setJOBORDER_PROCESS_RESULT_RUNTIME(min);
				vo.setJOBORDER_PROCESS_RESULT_ID(vo.getJOBORDER_PROCESS_RESULT_ID());

				// 4 작업지시서 공정 이력에 공정 결과 입력 업데이트
				service.UpdateEndJbProcessResult(vo);

				vo.setJOBORDER_PROCESS_ENDDAY(time);
				vo.setJOBORDER_PROCESS_ID(vo.getJOBORDER_PROCESS_ID());

				// 5 현재 공정 마무리
				service.UpdateEndJbProcess(vo);

				// 6. 작업지시서 최종 마무리
				vo.setJOBORDER_ENDDAY(time);

				service.UpdateLastEndJb(vo);

				JsonObject obj = new JsonObject();

				obj.addProperty("EndJbProcess", 1);

				return obj.toString();

			} else {

				int NEXT_PROCESS_ID_INDEX = resultprocess.get(0).JOBORDER_PROCESS_INDEX + 1;

				vo.setJOBORDER_PROCESS_INDEX(NEXT_PROCESS_ID_INDEX);

				// 다음 꺼 공정 아이디 존재하는지 (JOBORDER_ID랑 NEXT_PROCESS_ID_INDEX로 체크)
				List<JoborderVO> idlist = service.ChkNextIdx(vo);

				System.out.println(idlist.get(0).JOBORDER_PROCESS_NAME);

				if (idlist.get(0).JOBORDER_PROCESS_NAME == null) {

					JsonObject obj = new JsonObject();

					obj.addProperty("EndJbProcess", 0);

					return obj.toString();

				} else {

					// 처음 시작했던 시간
					long orgtime = result.getTime();

					// 현재 시간
					long sectime = time.getTime();

					long runtime = (sectime - orgtime) / 60000;

					// 빼기 (분)
					int min = Long.valueOf(runtime).intValue();

					vo.setJOBORDER_PROCESS_RESULT_ENDTIME(time);
					vo.setJOBORDER_PROCESS_RESULT_RUNTIME(min);

					// 1. 설비 종료 선언
					service.UpdateJobEquipStop(vo);

					// 2 수량, 불량 수량
					service.RegisterProcessResultValue(vo);

					int ORG_PROCESS_RESULT_TEMPLATE_ID = vo.PROCESS_RESULT_TEMPLATE_ID;

					vo.setPROCESS_RESULT_TEMPLATE_ID(ORG_PROCESS_RESULT_TEMPLATE_ID);

					// 3 JobCode, 및 자주검사성적서 업데이트
					System.out.println(vo.getJOBORDER_INSPECTIONFILE());
					
					service.UpdateJbInspection(vo);

					service.UpdateJobCode(vo);

					vo.setJOBORDER_PROCESS_RESULT_ENDTIME(time);
					vo.setJOBORDER_PROCESS_RESULT_RUNTIME(min);
					vo.setJOBORDER_PROCESS_RESULT_ID(vo.getJOBORDER_PROCESS_RESULT_ID());

					// 4 작업지시서 공정 이력에 공정 결과 입력 업데이트
					service.UpdateEndJbProcessResult(vo);

					vo.setJOBORDER_PROCESS_ENDDAY(time);
					vo.setJOBORDER_PROCESS_ID(vo.getJOBORDER_PROCESS_ID());

					// 5 현재 공정 마무리
					service.UpdateEndJbProcess(vo);

					vo.setJOBORDER_PROCESS_INDEX(NEXT_PROCESS_ID_INDEX);

					// 6 다음 공정 업데이트 시키기
					service.UpdateNextJbProcess(vo);

					JsonObject obj = new JsonObject();

					obj.addProperty("EndJbProcess", 1);

					return obj.toString();
				}
			}

		} catch (Exception e) {

			JsonObject obj = new JsonObject();

			obj.addProperty("EndJbProcess", 0);

			return obj.toString();
		}

	}

	// 작업지시서 출고 취소 시 변경
	@RequestMapping(value = "/test55", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String test555(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "test55");

		System.out.println(vo.getJOBORDER_ID());

		System.out.println(vo.getJOBORDER_PROCESS_ID());

		List<JoborderVO> result = service.DetectActiveStart(vo);

		System.out.println(result.get(0).JOBORDER_PROCESS_INDEX);

		int NEXT_PROCESS_ID_INDEX = result.get(0).JOBORDER_PROCESS_INDEX + 1;

		System.out.println(NEXT_PROCESS_ID_INDEX);

		vo.setJOBORDER_PROCESS_INDEX(NEXT_PROCESS_ID_INDEX);

		// 다음 꺼 공정 아이디 존재하는지 (JOBORDER_ID랑 NEXT_PROCESS_ID_INDEX로 체크)
		List<JoborderVO> idlist = service.ChkNextIdx(vo);

		System.out.println(idlist.get(0).JOBORDER_PROCESS_NAME);

		return null;
	}

	// 작업지시서 출고 취소 시 변경
	@RequestMapping(value = "/EndJbProcessCancel", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String EndJbProcessCancel(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "EndJbProcessCancel");

		int ORIGIN_JOB_PROCESS_ID = vo.getJOBORDER_PROCESS_ID();

		List<JoborderVO> result = service.DetectActiveStart(vo);

		int NEXT_PROCESS_ID_INDEX = result.get(0).JOBORDER_PROCESS_INDEX + 1;

		vo.setJOBORDER_PROCESS_INDEX(NEXT_PROCESS_ID_INDEX);

		// 다음 꺼 공정 아이디 존재하는지 (JOBORDER_ID랑 NEXT_PROCESS_ID_INDEX로 체크)
		List<JoborderVO> idlist = service.ChkNextIdx(vo);

		System.out.println(idlist.get(0).JOBORDER_PROCESS_NAME);

		// 다음 공정이 있는지 없는지 체크

		// 다음 공정이 없는 경우
		if (idlist.get(0).JOBORDER_PROCESS_NAME == null) {

			if (result.get(0).JOBORDER_LOBBY_ACTIVITY_ID1 == 2 && result.get(0).JOBORDER_LOBBY_ACTIVITY_ID2 == 5
					&& result.get(0).JOBORDER_LOBBY_ACTIVITY_ID3 == 11 && result.get(0).JOBORDER_PROCESS_FOCUSON == 3) {

				// 작지 공정 이력 등록
				vo.setJOBORDER_PROCESS_STATUS_ID1(5);
				vo.setJOBORDER_PROCESS_RESULT_STARTTIME(time);
				vo.setJOBORDER_PROCESS_ID(vo.getJOBORDER_PROCESS_ID());

				service.StartJbProcessResult(vo);

				int ORG_JOBORDER_PROCESS_RESULT_ID = vo.JOBORDER_PROCESS_RESULT_ID;

				// 작지 공정 생성 시 나올 키 값으로 넣을 것 현재 1은 테스트용
				vo.setJOBORDER_PROCESS_RESULT_ID(ORG_JOBORDER_PROCESS_RESULT_ID);
				vo.setJOBORDER_PROCESS_ID(ORIGIN_JOB_PROCESS_ID);

				// 출고취소 시키려고하는 작업지시서 공정 업데이트 (시작처럼 날짜를 업데이트를 하진 않음)
				service.UpdateEndCancelJbProcess(vo);

				// 로그 테이블 등록
				vo.setJOBORDER_PROCESS_ID(ORIGIN_JOB_PROCESS_ID);

				service.StartLogRegister(vo);

				// 공정 설비 다시 재시작
				vo.setJOBORDER_PROCESS_ID(ORIGIN_JOB_PROCESS_ID);

				service.UpdateEndCancelJbProcessEquip(vo);

				vo.setJOBORDER_PROCESS_ID(ORIGIN_JOB_PROCESS_ID);
				List<JoborderVO> EquipID = service.SelectEndCancelEquip(vo);

				int JobEquipID = EquipID.get(0).JOBORDER_EQUIPMENT_ID;

				JsonObject obj = new JsonObject();

				obj.addProperty("JOBORDER_PROCESS_RESULT_ID", ORG_JOBORDER_PROCESS_RESULT_ID);
				obj.addProperty("JOBORDER_EQUIPMENT_ID", JobEquipID);

				return obj.toString();

			} else {

				JsonObject obj = new JsonObject();

				obj.addProperty("EndJbProcessCancel", 0);

				return obj.toString();
			}

		}
		// 다음 공정이 있으면
		else {

			int nextJbProcessId = idlist.get(0).JOBORDER_PROCESS_ID;

			System.out.println("이게 다음에 해야 될 JOB_PROCESS_ID : " + nextJbProcessId);

			vo.setJOBORDER_PROCESS_ID(nextJbProcessId);

			List<JoborderVO> Nextresult = service.DetectActiveStart(vo);

			// 다음 공정이 해야될 거라면의 조건

			System.out.println("다음에 해야될 공정 Focusn ON : " + Nextresult.get(0).JOBORDER_PROCESS_FOCUSON);

			if (Nextresult.get(0).JOBORDER_PROCESS_FOCUSON == 1) {

				// 현재 공정이 2,5,11, 작업완료의 경우에서만 변경되어야함

				System.out.println("원상 복구하려는 공정 로비상태 ID1 : " + result.get(0).JOBORDER_LOBBY_ACTIVITY_ID1);
				System.out.println("원상 복구하려는 공정 로비상태 ID2 : " + result.get(0).JOBORDER_LOBBY_ACTIVITY_ID2);
				System.out.println("원상 복구하려는 공정 로비상태 ID3 : " + result.get(0).JOBORDER_LOBBY_ACTIVITY_ID3);
				System.out.println("원상 복구하려는 공정 FocusON : " + result.get(0).JOBORDER_PROCESS_FOCUSON);

				if (result.get(0).JOBORDER_LOBBY_ACTIVITY_ID1 == 2 && result.get(0).JOBORDER_LOBBY_ACTIVITY_ID2 == 5
						&& result.get(0).JOBORDER_LOBBY_ACTIVITY_ID3 == 11
						&& result.get(0).JOBORDER_PROCESS_FOCUSON == 3) {

					// 다음 공정 포커스 원래 상태로 되돌리기
					vo.setJOBORDER_PROCESS_ID(nextJbProcessId);
					service.UpdateNextJbProcess2(vo);

					// 작지 공정 이력 등록
					vo.setJOBORDER_PROCESS_STATUS_ID1(5);
					vo.setJOBORDER_PROCESS_RESULT_STARTTIME(time);

					vo.setJOBORDER_PROCESS_ID(ORIGIN_JOB_PROCESS_ID);

					service.StartJbProcessResult(vo);

					int ORG_JOBORDER_PROCESS_RESULT_ID = vo.JOBORDER_PROCESS_RESULT_ID;

					// 작지 공정 생성 시 나올 키 값으로 넣을 것 현재 1은 테스트용
					vo.setJOBORDER_PROCESS_ID(ORIGIN_JOB_PROCESS_ID);
					vo.setJOBORDER_PROCESS_RESULT_ID(ORG_JOBORDER_PROCESS_RESULT_ID);

					// 출고취소 시키려고하는 작업지시서 공정 업데이트 (시작처럼 날짜를 업데이트를 하진 않음)
					service.UpdateEndCancelJbProcess(vo);

					// 로그 테이블 등록
					vo.setJOBORDER_PROCESS_ID(ORIGIN_JOB_PROCESS_ID);

					service.StartLogRegister(vo);

					// 공정 설비 다시 재시작
					vo.setJOBORDER_PROCESS_ID(ORIGIN_JOB_PROCESS_ID);

					service.UpdateEndCancelJbProcessEquip(vo);

					System.out.println("여기까지는 온건가?");

					vo.setJOBORDER_PROCESS_ID(ORIGIN_JOB_PROCESS_ID);

					List<JoborderVO> EquipID = service.SelectEndCancelEquip(vo);

					int JobEquipID = EquipID.get(0).JOBORDER_EQUIPMENT_ID;

					System.out.println(JobEquipID);

					JsonObject obj = new JsonObject();

					obj.addProperty("JOBORDER_PROCESS_RESULT_ID", ORG_JOBORDER_PROCESS_RESULT_ID);
					obj.addProperty("JOBORDER_EQUIPMENT_ID", JobEquipID);

					return obj.toString();

				} else {

					JsonObject obj = new JsonObject();

					obj.addProperty("EndJbProcessCancel", 0);

					return obj.toString();
				}
			}

			else {

				// 다음 공정이 누군가 진행을 하고 있기때문에 취소 불가능
				JsonObject obj = new JsonObject();

				obj.addProperty("EndJbProcessCancel", 2);

				return obj.toString();
			}
		}

	}

	@RequestMapping(value = "/SelectLog", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<JoborderVO> SelectLog(JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "SelectLog");

		return service.SelectLog(vo);
	}

	@RequestMapping(value = "/FindSelectLog", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<JoborderVO> FindSelectLog(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "FindSelectLog");

		if (vo.getPUB_firsday() == null && vo.getPUB_secondday() == null) {

			return service.FindSelectLog1(vo);

		} else {

			return service.FindSelectLog(vo);
		}

	}

	@RequestMapping(value = "/SelectPlanProductionList", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<JoborderVO> SelectPlanProductionList(JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "SelectPlanProductionList");

		return service.SelectPlanProductionList(vo);
	}

	@RequestMapping(value = "/FindPlanProductionList", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<JoborderVO> FindPlanProductionList(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "FindPlanProductionList");

		if (vo.getPUB_firsday() == null && vo.getPUB_secondday() == null) {

			return service.FindPlanProductionList1(vo);

		} else {

			return service.FindPlanProductionList(vo);
		}

	}

	@RequestMapping(value = "/FindJobProcessEquipandResult", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<JoborderVO> FindJobProcessEquipandResult(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "StartJbProcessResult");

		return service.FindJobProcessEquipandResult(vo);
	}

	// 작업지시서 시작 시 변경될 것들1

	@RequestMapping(value = "/StartJbProcessResult", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public void StartJbProcessResult(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "StartJbProcessResult");

		vo.setJOBORDER_PROCESS_STATUS_ID1(1);
		vo.setJOBORDER_PROCESS_RESULT_STARTTIME(time);

		service.StartJbProcessResult(vo);

	}

	// 작업지시서 시작 시 변경될 것들2
	@RequestMapping(value = "/UpdateStartJoborder", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public void UpdateStartJoborder(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "UpdateStartJoborder");

		vo.setJOBORDER_STARTDAY(time);

		service.UpdateStartJoborder(vo);
	}

	// 작업지시서 시작 시 변경될 것들3
	@RequestMapping(value = "/UpdateStartJbProcess", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public void UpdateStartJbProcess(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "UpdateStartJbProcess");

		vo.setJOBORDER_PROCESS_STARTDAY(time);

		// 작지 공정 생성 시 나올 키 값으로 넣을 것 현재 1은 테스트용
		vo.setJOBORDER_PROCESS_RESULT_ID(1);

		service.UpdateStartJbProcess(vo);

	}

	// 작업지시서 시작 시 변경될 것들4
	@RequestMapping(value = "/StartLogRegister", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public void StartLogRegister(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "StartLogRegister");

		service.StartLogRegister(vo);

	}

	// 작업지시서 시작 시 변경될 것들5
	@RequestMapping(value = "/RegisterJoborderEquipment", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public void RegisterJoborderEquipment(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "RegisterJoborderEquipment");

		service.RegisterJoborderEquipment(vo);
	}

	//

	@RequestMapping(value = "/AllDeleteJoborder", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String AllDeleteJoborder(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "AllDeleteJoborder");

		List<JoborderVO> resulttest = service.SelectOneJoborder(vo);

		System.out.println(resulttest.get(0).JOBORDER_PUBLISH);

		if (resulttest.get(0).JOBORDER_PUBLISH == 0) {

			List<JoborderVO> JbProcessList = service.FindJbProcessId(vo);

			List<JoborderVO> JbFileList = service.SelectJbProcessFile(vo);

			// 작업중지이력 삭제
			service.DeleteJobStopTime(vo);

			// 작업지시서 공정 관련 특이사항 삭제
			for (int i = 0; i < JbProcessList.size(); i++) {

				int JBProcess_ID1 = JbProcessList.get(i).JOBORDER_PROCESS_ID;

				vo.setJOBORDER_PROCESS_ID(JBProcess_ID1);

				service.DeleteAllJbUniquess(vo);

				System.out.println("작업특이사항 통과");

			}

			// 공정수정이력
			for (int i = 0; i < JbProcessList.size(); i++) {

				int JBProcess_ID2 = JbProcessList.get(i).JOBORDER_PROCESS_ID;

				vo.setJOBORDER_PROCESS_ID(JBProcess_ID2);

				service.DeleteJbProcessRevise(vo);

				System.out.println("공정수정이력 통과");
			}
			
			// JOBORDER_PROCESS_RESULT
			for (int i = 0; i < JbProcessList.size(); i++) {
				
				int JBProcess_ID2 = JbProcessList.get(i).JOBORDER_PROCESS_ID;
				
				vo.setJOBORDER_PROCESS_ID(JBProcess_ID2);
				
				service.AllDeleteProcessResult(vo);
				
			}

			// 작업지시서 공정 삭제
			for (int i = 0; i < JbProcessList.size(); i++) {

				int JBProcess_ID2 = JbProcessList.get(i).JOBORDER_PROCESS_ID;

				vo.setJOBORDER_PROCESS_ID(JBProcess_ID2);

				service.DeleteAllJbProcess(vo);

				System.out.println("작업공정 통과");

			}

			for (int i = 0; i < JbFileList.size(); i++) {

				String FindDirectory = JbFileList.get(i).JOBORDER_FILE_MANAGEMENT_DIRECTORY;

				System.out.println(FindDirectory);

				File file = new File(FindDirectory);

				if (file.exists()) {
					if (file.isDirectory()) {

						File[] files = file.listFiles();

						for (int j = 0; j < files.length; j++) {

							if (files[j].delete()) {

								System.out.println(files[j].getName() + " 삭제성공");

							} else {

								System.out.println(files[j].getName() + " 삭제실패");
							}
						}
					}
					if (file.delete()) {

						System.out.println("파일 삭제 성공");

					} else {

						System.out.println("파일 삭제 실패");

					}

					System.out.println("파일이 존재하지 않음");
				}

				System.out.println("작업지시서 파일 통과");

				service.DeleteAllJoborderFile(vo);
			}

			// QR CODE 삭제
			List<JoborderVO> result = service.SelectFindQRCode(vo);

			String dir = result.get(0).QRCODE_DIRECTORY;

			File file = new File(dir);

			if (file.exists()) {
				if (file.isDirectory()) {

					File[] files = file.listFiles();

					for (int j = 0; j < files.length; j++) {

						if (files[j].delete()) {

							System.out.println(files[j].getName() + " 삭제성공");

						} else {

							System.out.println(files[j].getName() + " 삭제실패");
						}
					}
				}
				if (file.delete()) {

					System.out.println("파일 삭제 성공");

				} else {

					System.out.println("파일 삭제 실패");

				}

				System.out.println("파일이 존재하지 않음");
			}

			service.DeleteJoborderQRCode(vo);

			System.out.println("작업지시서 QR코드 통과");

			vo.setJOBORDER_ID(vo.getJOBORDER_ID());

			int JobDetail_Id = service.FindDetailJbId(vo);

			service.DeleteJoborder(vo);

			System.out.println("작업지시서 통과");

			System.out.println(JobDetail_Id);

			vo.setJOBORDER_DETAIL_ID(JobDetail_Id);

			service.DeleteAllJoborderDetail(vo);

			System.out.println("작업지시서 디테일 통과");

			JsonObject obj = new JsonObject();

			obj.addProperty("AllDeleteJoborder", 1);

			return obj.toString();

		} else {

			JsonObject obj = new JsonObject();

			obj.addProperty("AllDeleteJoborder", 0);

			return obj.toString();
		}

	}

	@RequestMapping(value = "/UpdateJbWorkInspection", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String UpdateJbWorkInspection(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "UpdateJbWorkInspection");

		try {

			service.UpdateJbWorkInspection(vo);

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateJbWorkInspection", 1);

			return obj.toString();

		} catch (Exception e) {

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateJbWorkInspection", 0);

			return obj.toString();
		}
	}

	@RequestMapping(value = "/UpdateJbInspection", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String UpdateJbInspection(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "UpdateJbInspection");

		try {

			System.out.println(vo.getJOBORDER_INSPECTIONFILE());
			
			service.UpdateJbInspection(vo);

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateJbInspection", 1);

			return obj.toString();

		} catch (Exception e) {

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateJbInspection", 0);

			return obj.toString();
		}
	}

	@RequestMapping(value = "/UpdateJobCode", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String UpdateJobCode(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "UpdateJobCode");

		try {

			service.UpdateJobCode(vo);

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateJobCode", 1);

			return obj.toString();

		} catch (Exception e) {

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateJobCode", 0);

			return obj.toString();
		}

	}

	@RequestMapping(value = "/SelfInspectionView/{JOBORDER_ID}", method = RequestMethod.GET)
	public ModelAndView SelfInspectionView(@PathVariable int JOBORDER_ID, HttpServletRequest request,
			HttpServletResponse response, JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "SelfInspectionView");

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

		ModelAndView mv = new ModelAndView();
		mv.setViewName("SelfInspection");

		return mv;

	}

	@RequestMapping(value = "/JoborderView/{JOBORDER_ID}/{JOBORDER_SUBTITLE_ID}", method = RequestMethod.GET)
	public ModelAndView JoborderView(@PathVariable int JOBORDER_ID, @PathVariable int JOBORDER_SUBTITLE_ID,
			HttpServletRequest request, HttpServletResponse response, JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "JoborderView");

		vo.setJOBORDER_SUBTITLE_ID(JOBORDER_SUBTITLE_ID);

		int JOBORDER_SUBTITLE_DIVISION = service.SelectSubDvision(vo);

		// 벨로우즈 서식
		if (JOBORDER_SUBTITLE_DIVISION == 1) {

			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");

			ModelAndView mv = new ModelAndView();
			mv.setViewName("test");

			return mv;

		} else if (JOBORDER_SUBTITLE_DIVISION == 2) {

			ModelAndView mv = new ModelAndView();
			mv.setViewName("fk");

			return mv;
		} else {

			return null;
		}

	}
	
	
	@RequestMapping(value = "/Hometest", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String Hometest(JoborderVO vo) throws Exception  {
	
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "Hometest");
		
		List<JoborderVO> result2_1 = service.Home2_1(vo);
		
		int BADQUANTITY = 0;
		
		
		for(int i = 0; i < result2_1.size(); i++) {
			
			String test = result2_1.get(i).PROCESS_RESULT_TEMPLATE_BADQUANTITY;
			
			String settest;
			
			String resultest;
			
			
			
			if(test == null) {
				
				continue;
				
			}else {
				
				if(test.contains("(")) {
			
					settest = test.replaceFirst("[(]", "");
					String lasttest = settest.replaceAll("[)]", "");
									
					test = lasttest;
			
				}
					
				
				//정수변환 완료
				int c = Integer.parseInt(test);
				
				System.out.println(c);
				
				if(c > 0) {
					
					BADQUANTITY += 1;
				}
			
			}
			
			
			
		}
		
		JsonObject obj = new JsonObject();
		
		obj.addProperty("BADQUANTITY", BADQUANTITY);
		
		return obj.toString();
		
	}
	

	
	
	

	@RequestMapping(value = "/Home", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String Home(JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "Home");

		List<JoborderVO> result1 = service.Home1(vo);

		//List<JoborderVO> result2 = service.Home2(vo);


		List<JoborderVO> result2_1 = service.Home2_1(vo);
		
		int BADQUANTITY = 0;
		
		
		for(int i = 0; i < result2_1.size(); i++) {
			
			String test = result2_1.get(i).PROCESS_RESULT_TEMPLATE_BADQUANTITY;
			
			String settest;
			
			String resultest;
			
			
			
			if(test == null) {
				
				continue;
				
			}else if (test.equals("")) {
				
				continue;
			}
			
			else {
				
				if(test.contains("(")) {
			
					settest = test.replaceFirst("[(]", "");
					String lasttest = settest.replaceAll("[)]", "");
									
					test = lasttest;
			
				}
					
				
				//정수변환 완료
				int c = Integer.parseInt(test);
				
				if(c > 0) {
					
					BADQUANTITY += 1;
				}
			
			}
			
			
			
		}
		
		
		List<JoborderVO> result3 = service.Home3(vo);

		JsonObject obj = new JsonObject();

		// result1
		obj.addProperty("TOTAL_JOBORDER", result1.get(0).TOTAL_JOBORDER);
		obj.addProperty("TOTAL_COMPLETE", result1.get(0).TOTAL_COMPLETE);
		obj.addProperty("TOTAL_PROCEED", result1.get(0).TOTAL_PROCEED);

		// result2_1
		obj.addProperty("BADQUANTITY", BADQUANTITY);
		// result3
		obj.addProperty("OUTSOURCING", result3.get(0).OUTSOURCING);

		return obj.toString();
	}

	@RequestMapping(value = "/Home2", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<JoborderVO> Home2(JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "Home2");

		List<JoborderVO> result4 = service.Home4(vo);

		return result4;
	}

	@RequestMapping(value = "/DeleteJoborderQRCode", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String DeleteJoborderQRCode(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "DeleteJoborderQRCode");

		try {

			List<JoborderVO> result = service.SelectFindQRCode(vo);

			String dir = result.get(0).QRCODE_DIRECTORY;

			File file = new File(dir);

			if (file.exists()) {
				if (file.isDirectory()) {

					File[] files = file.listFiles();

					for (int j = 0; j < files.length; j++) {

						if (files[j].delete()) {

							System.out.println(files[j].getName() + " 삭제성공");

						} else {

							System.out.println(files[j].getName() + " 삭제실패");
						}
					}
				}
				if (file.delete()) {

					System.out.println("파일 삭제 성공");

				} else {

					System.out.println("파일 삭제 실패");

				}

				System.out.println("파일이 존재하지 않음");
			}

			service.DeleteJoborderQRCode(vo);

			JsonObject obj = new JsonObject();

			obj.addProperty("DeleteJoborderQRCode", 1);

			return obj.toString();

		} catch (Exception e) {

			JsonObject obj = new JsonObject();

			obj.addProperty("DeleteJoborderQRCode", 0);

			return obj.toString();
		}

	}

	@RequestMapping(value = "/DeleteJoborderFile", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String DeleteJoborderFile(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "DeleteJoborderFile");

		List<JoborderVO> result = service.SelectOneJoborder(vo);

		if (result.get(0).JOBORDER_PUBLISH == 1) {

			JsonObject obj = new JsonObject();

			obj.addProperty("DeleteJoborderFile", 0);

			return obj.toString();

		} else {

			for (int i = 0; i < vo.getJOBORDER_FILE_MANAGEMENT_ID2().length; i++) {

				vo.setJOBORDER_ID(vo.getJOBORDER_ID());
				vo.setJOBORDER_FILE_MANAGEMENT_ID(vo.getJOBORDER_FILE_MANAGEMENT_ID2()[i]);

				String FindDirectory = service.OneFindJBFileDirectory(vo);

				service.DeleteJoborderFile(vo);

				System.out.println(FindDirectory);

				File file = new File(FindDirectory);

				if (file.exists()) {

					if (file.isDirectory()) {

						File[] files = file.listFiles();

						for (int j = 0; j < files.length; j++) {

							if (files[j].delete()) {

								System.out.println(files[j].getName() + " 삭제성공");

							} else {

								System.out.println(files[j].getName() + " 삭제실패");
							}

						}
					}
					if (file.delete()) {

						System.out.println("파일 삭제 성공");

					} else {

						System.out.println("파일 삭제 실패");

					}

					System.out.println("파일이 존재하지 않음");
				}

			}

			JsonObject obj = new JsonObject();

			obj.addProperty("DeleteJoborderFile", 1);

			return obj.toString();
		}

	}

	@RequestMapping(value = "/RegisterJoborderDetail", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String RegisterJoborderDetail(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "RegisterJoborderDetail");

		try {

			String conv = vo.getCONVERT_JOBORDER_DETAIL_DEILVERYDAY();

			String conv2 = vo.getCONVERT_JOBORDER_DETAIL_PLANENDDAY();

			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");

			Date to = fm.parse(conv);
			Date to2 = fm.parse(conv2);

			vo.setJOBORDER_DETAIL_PLANENDDAY(to2);
			vo.setJOBORDER_DETAIL_DEILVERYDAY(to);

			service.RegisterJoborderDetail(vo);

			JsonObject obj = new JsonObject();

			obj.addProperty("RegisterJoborderDetail", 1);

			return obj.toString();

		} catch (Exception e) {

			JsonObject obj = new JsonObject();

			obj.addProperty("RegisterJoborderDetail", 0);

			return obj.toString();
		}

	}

	@RequestMapping(value = "/UpdateJoborderFileRegister", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String UpdateJoborderFileRegister(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "UpdateJoborderFileRegister");

		try {

			service.UpdateJoborderFileRegister(vo);

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateJoborderFileRegister", 1);

			return obj.toString();

		} catch (Exception e) {

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateJoborderFileRegister", 0);

			return obj.toString();
		}
	}

	@RequestMapping(value = "/UpdatePublishJoborder", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String UpdatePublishJoborder(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "UpdatePublishJoborder");

		System.out.println(vo.getJOBORDER_ID());

		List<JoborderVO> result = service.SelectOneJoborder(vo);

		int PUBLISH_ON = result.get(0).JOBORDER_PUBLISH;

		int testresult = result.get(0).JOBORDER_ID;

		System.out.println(testresult);

		System.out.println(PUBLISH_ON);

		if (vo.getJOBORDER_PUBLISH() == 1) {

			// 배포하려는데 다시 배포하는거니까 방지 팝업
			if (PUBLISH_ON == 1) {

				// System.out.println("이미 배포된 상태인데 다시 배포하려하는거니까 리턴");

				JsonObject obj = new JsonObject();

				obj.addProperty("UpdatePublishJoborder", 2);

				return obj.toString();

			} else {

				vo.setJOBORDER_PUBLISHDAY(time);
				vo.setJOBORDER_STATUS_ID(2);

				service.UpdatePublishJoborder(vo);

				service.UpdateJbProcessLobby1(vo);

				service.UpdateFocusOn1(vo);

				JsonObject obj = new JsonObject();

				obj.addProperty("UpdatePublishJoborder", 1);

				return obj.toString();
			}

		} else if (vo.getJOBORDER_PUBLISH() == 0) {

			List<JoborderVO> jbprocesslist = service.ChkJbProcess(vo);

			for (int i = 0; i < jbprocesslist.size(); i++) {

				if (jbprocesslist.get(i).JOBORDER_LOBBY_ACTIVITY_ID1 == 1
						&& jbprocesslist.get(i).JOBORDER_LOBBY_ACTIVITY_ID2 == 10
						&& jbprocesslist.get(i).JOBORDER_LOBBY_ACTIVITY_ID3 == 10) {

					// System.out.println("1 , 10 , 10 이니까 통과");

				} else {

					System.out.println("여기 아님>?");
					
					// 해당 작업지시서는 작업중상태입니다.
					JsonObject obj = new JsonObject();

					obj.addProperty("UpdatePublishJoborder", 3);

					return obj.toString();
				}

			}

			vo.setJOBORDER_STATUS_ID(1);

			service.CancelPublishJoborder(vo);

			service.UpdateJbProcessLobby2(vo);

			service.UpdateFocusOn2(vo);

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdatePublishJoborder", 1);

			return obj.toString();
		} else {

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdatePublishJoborder", 0);

			return obj.toString();

		}

	}

	@RequestMapping(value = "/UpdateJoborderDetail", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String UpdateJoborderDetail(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "UpdateJoborderDetail");

		List<JoborderVO> result = service.SelectOneJoborder(vo);

		if (result.get(0).JOBORDER_PUBLISH == 0) {

			service.UpdateEmergencyJoborder(vo);

			String conv = vo.getCONVERT_JOBORDER_DETAIL_DEILVERYDAY();
			String conv2 = vo.getCONVERT_JOBORDER_DETAIL_PLANENDDAY();

			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");

			Date to = fm.parse(conv);
			Date to2 = fm.parse(conv2);

			vo.setJOBORDER_DETAIL_DEILVERYDAY(to);
			vo.setJOBORDER_DETAIL_PLANENDDAY(to2);

			service.UpdateJoborderDetail(vo);

			service.UpdateJoborderCode(vo);

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateJoborderDetail", 1);

			return obj.toString();

		} else {

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateJoborderDetail", 0);

			return obj.toString();
		}

	}

	@RequestMapping(value = "/UpdateJbLobbyStatus", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String UpdateJbLobbyStatus(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "UpdateJbLobbyStatus");

		try {

			service.UpdateJbLobbyStatus(vo);

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateJbLobbyStatus", 1);

			return obj.toString();

		} catch (Exception e) {

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateJbLobbyStatus", 0);

			return obj.toString();
		}

	}

	@RequestMapping(value = "/UpdateJbProcessAll", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String UpdateJbProcessAll(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		
		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "UpdateJbProcessAll");

		List<JoborderVO> result = service.SelectOneJoborder(vo);

		if (result.get(0).JOBORDER_PUBLISH == 1) {

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateJbProcessAll", 0);

			return obj.toString();

		} else {

			String ConvPlanEndDay = new String(vo.getCONVERT_JOBORDER_PROCESS_PLANENDDAY().getBytes("8859_1"), "UTF-8");
			
			Date to3 = fm.parse(ConvPlanEndDay);
			
			vo.setJOBORDER_PROCESS_PLANENDDAY(to3);
			
			service.UpdateJbProcessAll(vo);

			vo.setJOBORDER_PROCESS_ID(vo.getJOBORDER_PROCESS_ID());

			service.DeleteAllJbUniquess(vo);

			if (vo.getJOBORDER_UNIQUESS_CONTEXT2() == null) {

			} else {

				for (int i = 0; i < vo.getJOBORDER_UNIQUESS_CONTEXT2().length; i++) {

					vo.setJOBORDER_PROCESS_ID(vo.getJOBORDER_PROCESS_ID());
					vo.setJOBORDER_UNIQUESS_CONTEXT(vo.getJOBORDER_UNIQUESS_CONTEXT2()[i]);

					service.RegisterJoborderUniquess(vo);

				}

			}

			if (vo.getJOBORDER_PROCESS_REVISE_CONTEXT() == null) {

			} else {

				vo.setJOBORDER_PROCESS_REVISE_CONTEXT(vo.getJOBORDER_PROCESS_REVISE_CONTEXT());

				service.RegisterJbProcessRevise(vo);
			}

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateJbProcessAll", 1);

			return obj.toString();

		}

	}

	@RequestMapping(value = "/UpdateJbProcessIndex", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String UpdateJbProcessIndex(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "UpdateJbProcessIndex");

		List<JoborderVO> result = service.SelectOneJoborder(vo);

		if (result.get(0).JOBORDER_PUBLISH == 0) {

			for (int i = 0; i < vo.getJOBORDER_PROCESS_INDEX2().length; i++) {

				vo.setJOBORDER_PROCESS_INDEX(vo.getJOBORDER_PROCESS_INDEX2()[i]);
				vo.setJOBORDER_PROCESS_ID(vo.getJOBORDER_PROCESS_ID2()[i]);

				service.UpdateJbProcessIndex(vo);
			}

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateJbProcessIndex", 1);

			return obj.toString();

		} else {
			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateJbProcessIndex", 0);

			return obj.toString();
		}
	}

	@RequestMapping(value = "/UpdateEmergencyJoborder", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String UpdateEmergencyJoborder(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "UpdateEmergencyJoborder");

		List<JoborderVO> result = service.SelectOneJoborder(vo);

		if (result.get(0).JOBORDER_PUBLISH == 0) {

			service.UpdateEmergencyJoborder(vo);

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateEmergencyJoborder", 1);

			return obj.toString();

		} else {
			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateEmergencyJoborder", 0);

			return obj.toString();
		}

	}

	@RequestMapping(value = "/DeleteJoborder", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String DeleteJoborder(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "DeleteJoborder");

		try {

			service.DeleteJoborder(vo);

			JsonObject obj = new JsonObject();

			obj.addProperty("DeleteJoborder", 1);

			return obj.toString();

		} catch (Exception e) {

			JsonObject obj = new JsonObject();

			obj.addProperty("DeleteJoborder", 0);

			return obj.toString();
		}

	}

	@RequestMapping(value = "/DeleteJoborderDetail", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String DeleteJoborderDetail(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "DeleteJoborderDetail");

		try {

			service.DeleteJoborderDetail(vo);

			JsonObject obj = new JsonObject();

			obj.addProperty("DeleteJoborderDetail", 1);

			return obj.toString();

		} catch (Exception e) {

			JsonObject obj = new JsonObject();

			obj.addProperty("DeleteJoborderDetail", 0);

			return obj.toString();
		}
	}

	@RequestMapping(value = "/RegisterJoborder", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String RegisterJoborder(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "RegisterJoborder");

		try {

			vo.setJOBORDER_STATUS_ID(1);
			vo.setJOBORDER_PUBLISH(0);

			service.RegisterJoborder(vo);

			int newJbID = vo.JOBORDER_ID;

			String path = ("C:\\factory\\admin\\qrcode\\");

			String realpath = path + time1;

			File Folder = new File(realpath);

			Folder.mkdirs();

			JsonObject obj = new JsonObject();

			obj.addProperty("JOBORDER_ID", newJbID);

			String cv = obj.toString();

			File saveQR = new File(realpath + "\\" + time1 + ".png");

			// QR코드인식 시 링크 걸 URL 주소
			String codeurl = new String(cv.getBytes("UTF-8"), "ISO-8859-1");

			// QR코드 컬러
			int qrcodeColor = 0xFF2e4e96;

			// QR코드 배경색상값
			int backgroundColor = 0xFFFFFFFF;

			QRCodeWriter qrCodeWriter = new QRCodeWriter();

			// QR Code의 Width, Height 값
			BitMatrix bitMatrix = qrCodeWriter.encode(codeurl, BarcodeFormat.QR_CODE, 200, 200);

			MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig(qrcodeColor, backgroundColor);

			BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix, matrixToImageConfig);

			// ImageIO를 사용한 바코드 파일 쓰기

			ImageIO.write(bufferedImage, "png", saveQR);

			String saveDir = saveQR.toString();

			vo.setQRCODE_DIRECTORY(saveDir);
			vo.setJOBORDER_ID(newJbID);

			service.RegisterQRCode(vo);

			JsonObject obj2 = new JsonObject();

			obj2.addProperty("RegisterJoborder", 1);

			return obj2.toString();

		} catch (Exception e) {

			JsonObject obj2 = new JsonObject();

			obj2.addProperty("RegisterJoborder", 0);

			return obj2.toString();

		}
	}

	@RequestMapping(value = "/DeleteJoborderProcess", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String DeleteJoborderProcess(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "DeleteJoborderProcess");

		List<JoborderVO> result = service.SelectOneJoborder(vo);

		if (result.get(0).JOBORDER_PUBLISH == 1) {

			JsonObject obj = new JsonObject();

			obj.addProperty("DeleteJoborderProcess", 0);

			return obj.toString();

		} else {

			// 공정 삭제하기전에 특이사항도 삭제됨
			for (int i = 0; i < vo.getJOBORDER_PROCESS_ID2().length; i++) {

				vo.setJOBORDER_PROCESS_ID(vo.getJOBORDER_PROCESS_ID2()[i]);

				List<JoborderVO> resulttest = service.JbProcessUniquess(vo);

				for (int j = 0; j < resulttest.size(); j++) {

					int JobUniquess_ID = resulttest.get(j).JOBORDER_UNIQUESS_ID;

					vo.setJOBORDER_UNIQUESS_ID(JobUniquess_ID);

					service.DeleteJbUniquess(vo);
				}
			}

			// 공정수정이력 삭제
			for (int i = 0; i < vo.getJOBORDER_PROCESS_ID2().length; i++) {

				vo.setJOBORDER_PROCESS_ID(vo.getJOBORDER_PROCESS_ID2()[i]);

				service.DeleteJbProcessRevise(vo);
			}

			// 작업중지이력 삭제

			for (int i = 0; i < vo.getJOBORDER_PROCESS_ID2().length; i++) {

				vo.setJOBORDER_PROCESS_ID(vo.getJOBORDER_PROCESS_ID2()[i]);

				service.DeleteJbProcessStopTime(vo);
			}

			// 공정 삭제
			for (int i = 0; i < vo.getJOBORDER_PROCESS_ID2().length; i++) {

				vo.setJOBORDER_PROCESS_ID(vo.getJOBORDER_PROCESS_ID2()[i]);
				vo.setJOBORDER_ID(vo.getJOBORDER_ID());

				service.DeleteJoborderProcess(vo);
			}

			JsonObject obj = new JsonObject();

			obj.addProperty("DeleteJoborderProcess", 1);

			return obj.toString();

		}

	}

	@RequestMapping(value = "/RegisterJoborderProcess", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String RegisterJoborderProcess(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "RegisterJoborderProcess");

		ArrayList<Integer> JOBORDER_PROCESS_ID_LIST = new ArrayList<Integer>();

		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		
		for (int i = 0; i < vo.getORIGIN_PROCESS_ID2().length; i++) {

			String ConvPlanEndDay = new String(vo.getCONVERT_JOBORDER_PROCESS_PLANENDDAY2()[i].getBytes("8859_1"), "UTF-8");
			
			Date to3 = fm.parse(ConvPlanEndDay);
			
			System.out.println(vo.getORIGIN_PROCESS_ID2()[i]);
			System.out.println(vo.getJOBORDER_ID());
			System.out.println(vo.getJOBORDER_PROCESS_INDEX2()[i]);
			System.out.println(vo.getJOBORDER_PROCESS_WORKTIME2()[i]);
			System.out.println(vo.getJOBORDER_PROCESS_SELFINSPECT_FILE2()[i]);
			System.out.println(vo.getJOBORDER_PROCESS_SELFINSPECT_FILE_CHECK2()[i]);
			System.out.println("JOBORDER_PROCESS_PLANENDDAY" + to3);
			
			
			vo.setORIGIN_PROCESS_ID(vo.getORIGIN_PROCESS_ID2()[i]);
			vo.setJOBORDER_ID(vo.getJOBORDER_ID());
			vo.setJOBORDER_PROCESS_INDEX(vo.getJOBORDER_PROCESS_INDEX2()[i]);
			vo.setJOBORDER_PROCESS_WORKTIME(vo.getJOBORDER_PROCESS_WORKTIME2()[i]);
			vo.setJOBORDER_PROCESS_SELFINSPECT_FILE(vo.getJOBORDER_PROCESS_SELFINSPECT_FILE2()[i]);
			vo.setJOBORDER_PROCESS_SELFINSPECT_FILE_CHECK(vo.getJOBORDER_PROCESS_SELFINSPECT_FILE_CHECK2()[i]);
			
			vo.setJOBORDER_PROCESS_PLANENDDAY(to3);
			
			
			service.RegisterJoborderProcess(vo);

			int JOBORDER_PROCESS_ID = vo.JOBORDER_PROCESS_ID;

			JOBORDER_PROCESS_ID_LIST.add(JOBORDER_PROCESS_ID);
		}

		// 작업특이사항 등록
		if (vo.getJOBORDER_UNIQUESS_CONTEXT3() == null) {

		} else {

			for (int i = 0; i < JOBORDER_PROCESS_ID_LIST.size(); i++) {

				for (int j = 0; j < vo.getJOBORDER_UNIQUESS_CONTEXT3()[i].length; j++) {

					if (vo.getJOBORDER_UNIQUESS_CONTEXT3()[i][j] == null) {

					} else {
						vo.setJOBORDER_PROCESS_ID(JOBORDER_PROCESS_ID_LIST.get(i));
						vo.setJOBORDER_UNIQUESS_CONTEXT(vo.getJOBORDER_UNIQUESS_CONTEXT3()[i][j]);

						service.RegisterJoborderUniquess(vo);
					}

				}
			}
		}

		// 공정수정이력 입력
		if (vo.getJOBORDER_PROCESS_REVISE_CONTEXT2() == null) {

		} else {

			for (int i = 0; i < vo.getJOBORDER_PROCESS_REVISE_CONTEXT2().length; i++) {

				vo.setJOBORDER_ID(vo.getJOBORDER_ID());
				vo.setJOBORDER_PROCESS_ID(JOBORDER_PROCESS_ID_LIST.get(i));
				vo.setJOBORDER_PROCESS_REVISE_CONTEXT(vo.getJOBORDER_PROCESS_REVISE_CONTEXT2()[i]);

				service.RegisterJbProcessRevise(vo);

			}

		}

		JsonObject obj = new JsonObject();

		obj.addProperty("RegisterJoborderProcess", 1);

		return obj.toString();

	}

	@RequestMapping(value = "/UpdateJBProcessSelfInspection", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String UpdateJBProcessSelfInspection(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "UpdateJBProcessSelfInspection");

		try {

			service.UpdateJBProcessSelfInspection(vo);

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateJBProcessSelfInspection", 1);

			return obj.toString();

		} catch (Exception e) {

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateJBProcessSelfInspection", 0);

			return obj.toString();
		}
	}

	@RequestMapping(value = "/UpdateJBProcessWorkTime", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String UpdateJBProcessWorkTime(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "UpdateJBProcessWorkTime");

		try {

			service.UpdateJBProcessWorkTime(vo);

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateJBProcessWorkTime", 1);

			return obj.toString();

		} catch (Exception e) {

			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateJBProcessWorkTime", 0);

			return obj.toString();
		}
	}

	@RequestMapping(value = "/RegisterJoborderUniquess", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public void RegisterJoborderUniquess(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "RegisterJoborderUniquess");

		service.RegisterJoborderUniquess(vo);

	}

	@RequestMapping(value = "/UpdateJoborderEquipmentStart", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public void UpdateJoborderEquipmentStart(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "UpdateJoborderEquipmentStart");

		service.UpdateJoborderEquipmentStart(vo);

	}

	@RequestMapping(value = "/UpdateJoborderEquipmentEnd", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public void UpdateJoborderEquipmentEnd(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "UpdateJoborderEquipmentEnd");

		service.UpdateJoborderEquipmentEnd(vo);
	}

	@RequestMapping(value = "/RegisterJoborderStopTime", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public void RegisterJoborderStopTime(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "RegisterJoborderStopTime");

		service.RegisterJoborderStopTime(vo);
	}

	@RequestMapping(value = "/RegisterJbProcessRevise", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public void RegisterJbProcessRevise(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "RegisterJbProcessRevise");

		service.RegisterJbProcessRevise(vo);
	}

	@RequestMapping(value = "/UpdateJbProcessRevise", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public void UpdateJbProcessRevise(@RequestBody JoborderVO vo) throws Exception {

		// 이건 나중에 공정 상태 추가할 때 업데이트 막는거 생각해야함

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "UpdateJbProcessRevise");

		service.UpdateJbProcessRevise(vo);

	}

	@RequestMapping(value = "/RegisterProcessResult", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public void RegisterProcessResult(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

	}

	@RequestMapping(value = "/UpdateJbContext", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String UpdateJbContext(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "UpdateJbContext");

		int chk = service.IdChkJob(vo);

		if (chk >= 1) {

			service.UpdateJbContext(vo);

			JsonObject obj = new JsonObject();

			obj.addProperty("JOBORDER_CONTEXT_Fail", 1);

			return obj.toString();

		} else {

			JsonObject obj = new JsonObject();

			obj.addProperty("JOBORDER_CONTEXT_Fail", 0);

			return obj.toString();

		}

	}

	@RequestMapping(value = "/RegisterProcessResultValue", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public void RegisterProcessResultValue(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "RegisterProcessResultValue");

		service.RegisterProcessResultValue(vo);

	}

	@RequestMapping(value = "/DeleteListProcessWorkerFile", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String DeleteListProcessWorkerFile(@RequestBody JoborderVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("hh:mm:ss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "DeleteListProcessWorkerFile");
	
		try {
			
			for (int i = 0; i < vo.getJOBORDER_PROCESS_FILE_MANAGEMENT_ID2().length; i++) {
				
				vo.setJOBORDER_PROCESS_FILE_MANAGEMENT_ID(vo.getJOBORDER_PROCESS_FILE_MANAGEMENT_ID2()[i]);
				
				service.DeleteListProcessWorkerFile(vo);
				
			}
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("DeleteListProcessWorkerFile", 1);
			
			return obj.toString();
			
		}
		catch(Exception e) {
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("DeleteListProcessWorkerFile", 0);
			
			return obj.toString();
			
		}

		
	
		
	}
	
	
	@RequestMapping(value = "/RegisterProcessStartResult", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public void RegisterProcessStartResult(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("hh:mm:ss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "RegisterProcessStartResult");

		vo.setJOBORDER_PROCESS_RESULT_STARTTIME(time);

		service.RegisterProcessStartResult(vo);

	}

	@RequestMapping(value = "/UpdateJBRestartTime", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public void UpdateJBRestartTime(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "UpdateJBRestartTime");

		vo.setJOBORDER_PROCESS_STOPRESULT_RESTARTTIME(time);

		service.UpdateJBRestartTime(vo);

	}

	@RequestMapping(value = "/ReigsterProcessWorkerFile", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String ReigsterProcessWorkerFile(JoborderVO vo, MultipartHttpServletRequest request) throws Exception {

		List<MultipartFile> fileList = request.getFiles("WorkerRegisterFile");

		try {

			for (MultipartFile mf : fileList) {

				// 자주검사 파일 저장용 폴더 생성
				SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

				Date time = new Date();

				String time1 = format1.format(time);

				String path = ("C:\\Html\\factory\\worker\\joborder\\");

				String dbpath = ("http://182.208.252.210:5995/factory/worker/joborder/");
				
				String realpath = path + time1;

				String dbrealpath = dbpath + time1;
				
				File Folder = new File(realpath);

				Folder.mkdirs();

				String Filename = new String(mf.getOriginalFilename().getBytes("8859_1"), "UTF-8");

				File saveFile = new File(realpath + "\\" + Filename);

				mf.transferTo(saveFile);

				String directory = saveFile.toString();

				String dbsavepath = dbrealpath+"/"+Filename;
				
				vo.setJOBORDER_PROCESS_FILE_MANAGEMENT_FILENAME(Filename);
				vo.setJOBORDER_PROCESS_FILE_MANAGEMENT_FILEDIRECTORY(dbsavepath);

				service.ReigsterProcessWorkerFile(vo);

			}

		} catch (Exception e) {
			JsonObject obj = new JsonObject();

			obj.addProperty("ReigsterProcessWorkerFile", 0);

			return obj.toString();
		}

		JsonObject obj = new JsonObject();

		obj.addProperty("ReigsterProcessWorkerFile", 1);

		return obj.toString();

	}

	@RequestMapping(value = "/DeleteProcessWorkerFile", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public void DeleteProcessWorkerFile(@RequestBody JoborderVO vo) throws Exception {

		List<JoborderVO> resultlist = service.FindWorkerFileDir(vo);


		for (int i = 0; i < resultlist.size(); i++) {

			String FileDir = resultlist.get(i).JOBORDER_PROCESS_FILE_MANAGEMENT_FILEDIRECTORY;

			File file = new File(FileDir);

			if (file.exists()) {

				if (file.isDirectory()) {

					File[] files = file.listFiles();

					for (int j = 0; j < files.length; j++) {

						if (files[j].delete()) {

							System.out.println(files[j].getName() + " 삭제성공");

						} else {

							System.out.println(files[j].getName() + " 삭제실패");

						}
					}
				}
				if (file.delete()) {
					System.out.println("파일 삭제 성공");
				} else {
					System.out.println("파일 삭제 실패");
				}
			} else {
				System.out.println("파일이 존재하지 않음");
			}

		}

		service.DeleteProcessWorkerFile(vo);

	}

	
	
	@RequestMapping(value = "/FindWorkerFileDir", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<JoborderVO> FindWorkerFileDir(@RequestBody JoborderVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "FindWorkerFileDir");
		
		
		return service.FindWorkerFileDir(vo);
	}
}
