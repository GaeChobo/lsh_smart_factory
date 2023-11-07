package com.lsh.testing05;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.lsh.testing05.qrcode.vo.QrcodeVO;
import com.lsh.testing05.sensor.service.sensorService;
import com.lsh.testing05.sensor.vo.sensorVO;

@RestController
public class SensorController {

	
	private static final Logger logger = LoggerFactory.getLogger(SensorController.class);
	
	@Inject
	sensorService service;
	
	
	
	@RequestMapping(value = "/InsertSensor", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public void InsertSensor(@RequestBody sensorVO vo) throws Exception {
		
		service.InsertSensor(vo);
	}
	
	@RequestMapping(value = "/Select_INDEX1", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<sensorVO> Select_INDEX1(sensorVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		logger.info(time + "Select_INDEX1");
		
		return service.Select_INDEX1(vo);
	}


	@RequestMapping(value = "/TestSensor", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String TestSensor(sensorVO vo) throws Exception {
		
		Date time = new Date();
		
		//MC_01
		JsonObject obj = new JsonObject();
		

		
		
		List<sensorVO> BS_04_POWER_RESULT = service.TestSensor(vo);
		int BS_04_POWER_TOTAL = 0;
		
		int BS_04_POWER_MAX = BS_04_POWER_RESULT.size();
		
		System.out.println(BS_04_POWER_MAX);
			
		System.out.println(BS_04_POWER_RESULT.get(0).BS_04_POWERON_TIME);

		if(BS_04_POWER_MAX == 0) {
			
			obj.addProperty("BS_04_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date BS_04_POWER_FIRST_TIME = BS_04_POWER_RESULT.get(0).BS_04_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String SP_WO_01_POWER_FIRST_STRING = format1.format(BS_04_POWER_FIRST_TIME);
			
			System.out.println(SP_WO_01_POWER_FIRST_STRING);
			
			obj.addProperty("BS_04_POWER_FIRST_TIME", SP_WO_01_POWER_FIRST_STRING);
		}
		
		
		
		for(int i = 0; i < BS_04_POWER_RESULT.size(); i++) {
			
			Date ONTIME = BS_04_POWER_RESULT.get(i).BS_04_POWERON_TIME;
			Date OFFTIME = BS_04_POWER_RESULT.get(i).BS_04_POWEROFF_TIME;
			
			System.out.println("아거1"+ONTIME);
			System.out.println("아거2"+OFFTIME);
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				System.out.println(Nowtime);
				
				System.out.println(STARTTIME);
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				BS_04_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				System.out.println(STARTTIME);
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				System.out.println(ENDTIME);
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				System.out.println(RUNTIME);
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				BS_04_POWER_TOTAL += min;
				
			}
		}
		
		System.out.println(BS_04_POWER_TOTAL);
		
		int BS_04_POWER_HOURS = BS_04_POWER_TOTAL / 60;
		int BS_04_POWER_MIN = BS_04_POWER_TOTAL % 60; 
	
		obj.addProperty("BS_04_POWER_HOURS", BS_04_POWER_HOURS);
		obj.addProperty("BS_04_POWER_MIN", BS_04_POWER_MIN);
	
		return obj.toString();
		
	}

	
	

	@RequestMapping(value = "/INDEX1_ALL_TIME", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String INDEX1_ALL_TIME(sensorVO vo) throws Exception {
		
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		Calendar c1 = Calendar.getInstance();
		
		Calendar c2 = Calendar.getInstance();
		
		c2.setTime(new Date());
		
		//c2.add(c2.DATE, -3);
		
		Date time = new Date();
		
		String strToday = sdf.format(c1.getTime());
		
		//String NotToday = sdf.format(c2.getTime());
		
		//vo.setDEL_DAY(NotToday);
		vo.setTODAY(strToday);
		
		/*
		//인덱스 1 문지동 오늘 기준으로 -3일전 데이터들 삭제
		service.MC_01_DELETE(vo);
		service.MC_02_DELETE(vo);
		service.MC_03_DELETE(vo);
		service.MC_04_DELETE(vo);
		service.MC_05_DELETE(vo);
		service.MC_06_DELETE(vo);
		service.MC_07_DELETE(vo);
		service.MC_08_DELETE(vo);
		service.MC_09_DELETE(vo);
		service.MC_10_DELETE(vo);
		service.MC_11_DELETE(vo);
		service.BM_01_DELETE(vo);
		service.BM_02_DELETE(vo);
		service.BS_01_DELETE(vo);
		service.BS_02_DELETE(vo);
		service.BS_03_DELETE(vo);
		service.TC_01_DELETE(vo);
		*/
		
		
		
		JsonObject obj = new JsonObject();

		
		//MC_01
		
		List<sensorVO> MC_01_POWER_RESULT = service.MC_01_TIME_POWER_ON(vo);
		int MC_01_POWER_TOTAL = 0;
		
		int MC_01_POWER_MAX = MC_01_POWER_RESULT.size();
		
		if(MC_01_POWER_MAX == 0) {
			
			obj.addProperty("MC_01_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date MC_01_POWER_FIRST_TIME = MC_01_POWER_RESULT.get(0).MC_01_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String MC_01_POWER_FIRST_STRING = format1.format(MC_01_POWER_FIRST_TIME);
			
			obj.addProperty("MC_01_POWER_FIRST_TIME", MC_01_POWER_FIRST_STRING);
		}
		
		
		
		for(int i = 0; i < MC_01_POWER_RESULT.size(); i++) {
			
			Date ONTIME = MC_01_POWER_RESULT.get(i).MC_01_POWERON_TIME;
			Date OFFTIME = MC_01_POWER_RESULT.get(i).MC_01_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_01_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_01_POWER_TOTAL += min;
				
			}
		}
		
		int MC_01_POWER_HOURS = MC_01_POWER_TOTAL / 60;
		int MC_01_POWER_MIN = MC_01_POWER_TOTAL % 60; 
		
		obj.addProperty("MC_01_POWER_HOURS", MC_01_POWER_HOURS);
		obj.addProperty("MC_01_POWER_MIN", MC_01_POWER_MIN);
	
		System.out.println("MC_01 여기까지1");
		
		List<sensorVO> MC_01_RUN_RESULT = service.MC_01_TIME_RUN_ON(vo);
		int MC_01_RUN_TOTAL = 0;
		
		for(int i = 0; i < MC_01_RUN_RESULT.size(); i++) {
			
			Date ONTIME = MC_01_RUN_RESULT.get(i).MC_01_RUNON_TIME;
			Date OFFTIME = MC_01_RUN_RESULT.get(i).MC_01_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_01_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_01_RUN_TOTAL += min;
				
			}
		}
		
		int MC_01_RUN_HOURS = MC_01_RUN_TOTAL / 60;
		int MC_01_RUN_MIN = MC_01_RUN_TOTAL % 60; 
	
		obj.addProperty("MC_01_RUN_HOURS", MC_01_RUN_HOURS);
		obj.addProperty("MC_01_RUN_MIN", MC_01_RUN_MIN);
		
		
		System.out.println("MC_01 여기까지2");
		
		List<sensorVO> MC_01_ALARM_RESULT = service.MC_01_TIME_ALARM_ON(vo);
		int MC_01_ALARM_TOTAL = 0;
		
		int MC_01_ALARM_MAX = MC_01_ALARM_RESULT.size();
		
		if(MC_01_ALARM_MAX == 0) {
			
			obj.addProperty("MC_01_ALARM_FIRST_TIME", 0);
			
		}else {
			
			
			Date MC_01_ALARM_FIRST_TIME = MC_01_ALARM_RESULT.get(0).MC_01_ALARMON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String MC_01_ALARM_FIRST_STRING = format1.format(MC_01_ALARM_FIRST_TIME);
			
			obj.addProperty("MC_01_POWER_FIRST_TIME", MC_01_ALARM_FIRST_STRING);
			
		}
		
		for(int i = 0; i < MC_01_ALARM_RESULT.size(); i++) {
			
			Date ONTIME = MC_01_ALARM_RESULT.get(i).MC_01_ALARMON_TIME;
			Date OFFTIME = MC_01_ALARM_RESULT.get(i).MC_01_ALARMOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_01_ALARM_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_01_ALARM_TOTAL += min;
				
			}
		}
		
		int MC_01_ALARM_HOURS = MC_01_ALARM_TOTAL / 60;
		int MC_01_ALARM_MIN = MC_01_ALARM_TOTAL % 60; 
	
		obj.addProperty("MC_01_ALARM_HOURS", MC_01_ALARM_HOURS);
		obj.addProperty("MC_01_ALARM_MIN", MC_01_ALARM_MIN);
		
		System.out.println("MC_01 여기까지3");
		
		//MC_02
		
		List<sensorVO> MC_02_POWER_RESULT = service.MC_02_TIME_POWER_ON(vo);
		int MC_02_POWER_TOTAL = 0;
		

		int MC_02_POWER_MAX = MC_02_POWER_RESULT.size();
		
		if(MC_02_POWER_MAX == 0) {
			
			obj.addProperty("MC_02_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date MC_02_POWER_FIRST_TIME = MC_02_POWER_RESULT.get(0).MC_02_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String MC_02_POWER_FIRST_STRING = format1.format(MC_02_POWER_FIRST_TIME);
			
			obj.addProperty("MC_02_POWER_FIRST_TIME", MC_02_POWER_FIRST_STRING);
		}
		
		for(int i = 0; i < MC_02_POWER_RESULT.size(); i++) {
			
			Date ONTIME = MC_02_POWER_RESULT.get(i).MC_02_POWERON_TIME;
			Date OFFTIME = MC_02_POWER_RESULT.get(i).MC_02_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_02_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_02_POWER_TOTAL += min;
				
			}
		}
		
		int MC_02_POWER_HOURS = MC_02_POWER_TOTAL / 60;
		int MC_02_POWER_MIN = MC_02_POWER_TOTAL % 60; 
	
		obj.addProperty("MC_02_POWER_HOURS", MC_02_POWER_HOURS);
		obj.addProperty("MC_02_POWER_MIN", MC_02_POWER_MIN);
		
		System.out.println("MC_02 여기까지1");
		
		List<sensorVO> MC_02_RUN_RESULT = service.MC_02_TIME_RUN_ON(vo);
		int MC_02_RUN_TOTAL = 0;
		
		for(int i = 0; i < MC_02_RUN_RESULT.size(); i++) {
			
			Date ONTIME = MC_02_RUN_RESULT.get(i).MC_02_RUNON_TIME;
			Date OFFTIME = MC_02_RUN_RESULT.get(i).MC_02_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_02_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_02_RUN_TOTAL += min;
				
			}
		}
		
		int MC_02_RUN_HOURS = MC_02_RUN_TOTAL / 60;
		int MC_02_RUN_MIN = MC_02_RUN_TOTAL % 60; 
	
		obj.addProperty("MC_02_RUN_HOURS", MC_02_RUN_HOURS);
		obj.addProperty("MC_02_RUN_MIN", MC_02_RUN_MIN);
		
		System.out.println("MC_02 여기까지2");
		
		List<sensorVO> MC_02_ALARM_RESULT = service.MC_02_TIME_ALARM_ON(vo);
		int MC_02_ALARM_TOTAL = 0;
		
		int MC_02_ALARM_MAX = MC_02_ALARM_RESULT.size();
		
		if(MC_02_ALARM_MAX == 0) {
			
			obj.addProperty("MC_02_ALARM_FIRST_TIME", 0);
			
		}else {
			
			Date MC_02_ALARM_FIRST_TIME = MC_02_ALARM_RESULT.get(0).MC_02_ALARMON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String MC_02_ALARM_FIRST_STRING = format1.format(MC_02_ALARM_FIRST_TIME);
			
			obj.addProperty("MC_02_ALARM_FIRST_TIME", MC_02_ALARM_FIRST_STRING);
		}
		
		
		for(int i = 0; i < MC_02_ALARM_RESULT.size(); i++) {
			
			Date ONTIME = MC_02_ALARM_RESULT.get(i).MC_02_ALARMON_TIME;
			Date OFFTIME = MC_02_ALARM_RESULT.get(i).MC_02_ALARMOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_02_ALARM_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_02_ALARM_TOTAL += min;
				
			}
		}
		
		int MC_02_ALARM_HOURS = MC_02_ALARM_TOTAL / 60;
		int MC_02_ALARM_MIN = MC_02_ALARM_TOTAL % 60; 
	
		obj.addProperty("MC_02_ALARM_HOURS", MC_02_ALARM_HOURS);
		obj.addProperty("MC_02_ALARM_MIN", MC_02_ALARM_MIN);
		
		System.out.println("MC_02 여기까지3");
		
		//MC_03
		
		List<sensorVO> MC_03_POWER_RESULT = service.MC_03_TIME_POWER_ON(vo);
		int MC_03_POWER_TOTAL = 0;
		
		int MC_03_POWER_MAX = MC_03_POWER_RESULT.size();
		
		if(MC_03_POWER_MAX == 0) {
			
			obj.addProperty("MC_03_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date MC_03_POWER_FIRST_TIME = MC_03_POWER_RESULT.get(0).MC_03_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String MC_03_POWER_FIRST_STRING = format1.format(MC_03_POWER_FIRST_TIME);
			
			
			obj.addProperty("MC_03_POWER_FIRST_TIME", MC_03_POWER_FIRST_STRING);
		}
		
		for(int i = 0; i < MC_03_POWER_RESULT.size(); i++) {
			
			Date ONTIME = MC_03_POWER_RESULT.get(i).MC_03_POWERON_TIME;
			Date OFFTIME = MC_03_POWER_RESULT.get(i).MC_03_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_03_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_03_POWER_TOTAL += min;
				
			}
		}
		
		int MC_03_POWER_HOURS = MC_03_POWER_TOTAL / 60;
		int MC_03_POWER_MIN = MC_03_POWER_TOTAL % 60; 
	
		obj.addProperty("MC_03_POWER_HOURS", MC_03_POWER_HOURS);
		obj.addProperty("MC_03_POWER_MIN", MC_03_POWER_MIN);
		
		System.out.println("MC_03 여기까지1");
		
		List<sensorVO> MC_03_RUN_RESULT = service.MC_03_TIME_RUN_ON(vo);
		int MC_03_RUN_TOTAL = 0;
		
		for(int i = 0; i < MC_03_RUN_RESULT.size(); i++) {
			
			Date ONTIME = MC_03_RUN_RESULT.get(i).MC_03_RUNON_TIME;
			Date OFFTIME = MC_03_RUN_RESULT.get(i).MC_03_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_03_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_03_RUN_TOTAL += min;
				
			}
		}
		
		int MC_03_RUN_HOURS = MC_03_RUN_TOTAL / 60;
		int MC_03_RUN_MIN = MC_03_RUN_TOTAL % 60; 
	
		obj.addProperty("MC_03_RUN_HOURS", MC_03_RUN_HOURS);
		obj.addProperty("MC_03_RUN_MIN", MC_03_RUN_MIN);
		
		System.out.println("MC_03 여기까지2");
		
		List<sensorVO> MC_03_ALARM_RESULT = service.MC_03_TIME_ALARM_ON(vo);
		int MC_03_ALARM_TOTAL = 0;
		
		int MC_03_ALARM_MAX = MC_03_ALARM_RESULT.size();
		
		if(MC_03_ALARM_MAX == 0) {
			
			obj.addProperty("MC_03_ALARM_FIRST_TIME", 0);
			
		}else {
			
			Date MC_03_ALARM_FIRST_TIME = MC_03_ALARM_RESULT.get(0).MC_03_ALARMON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String MC_03_ALARM_FIRST_STRING = format1.format(MC_03_ALARM_FIRST_TIME);
			
			obj.addProperty("MC_03_ALARM_FIRST_TIME", MC_03_ALARM_FIRST_STRING);
		}
		
		for(int i = 0; i < MC_03_ALARM_RESULT.size(); i++) {
			
			Date ONTIME = MC_03_ALARM_RESULT.get(i).MC_03_ALARMON_TIME;
			Date OFFTIME = MC_03_ALARM_RESULT.get(i).MC_03_ALARMOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_03_ALARM_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_03_ALARM_TOTAL += min;
				
			}
		}
		
		int MC_03_ALARM_HOURS = MC_03_ALARM_TOTAL / 60;
		int MC_03_ALARM_MIN = MC_03_ALARM_TOTAL % 60; 
	
		obj.addProperty("MC_03_ALARM_HOURS", MC_03_ALARM_HOURS);
		obj.addProperty("MC_03_ALARM_MIN", MC_03_ALARM_MIN);
		
		System.out.println("MC_03 여기까지3");
		
		//MC_04
		List<sensorVO> MC_04_POWER_RESULT = service.MC_04_TIME_POWER_ON(vo);
		int MC_04_POWER_TOTAL = 0;
		
		int MC_04_POWER_MAX = MC_04_POWER_RESULT.size();
		
		if(MC_04_POWER_MAX == 0) {
			
			obj.addProperty("MC_04_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date MC_04_POWER_FIRST_TIME = MC_04_POWER_RESULT.get(0).MC_04_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String MC_04_POWER_FIRST_STRING = format1.format(MC_04_POWER_FIRST_TIME);
			
			obj.addProperty("MC_04_POWER_FIRST_TIME", MC_04_POWER_FIRST_STRING);
		}
		
		
		for(int i = 0; i < MC_04_POWER_RESULT.size(); i++) {
			
			Date ONTIME = MC_04_POWER_RESULT.get(i).MC_04_POWERON_TIME;
			Date OFFTIME = MC_04_POWER_RESULT.get(i).MC_04_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_04_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_04_POWER_TOTAL += min;
				
			}
		}
		
		int MC_04_POWER_HOURS = MC_04_POWER_TOTAL / 60;
		int MC_04_POWER_MIN = MC_04_POWER_TOTAL % 60; 
	
		obj.addProperty("MC_04_POWER_HOURS", MC_04_POWER_HOURS);
		obj.addProperty("MC_04_POWER_MIN", MC_04_POWER_MIN);
		
		System.out.println("MC_04 여기까지1");
		
		List<sensorVO> MC_04_RUN_RESULT = service.MC_04_TIME_RUN_ON(vo);
		int MC_04_RUN_TOTAL = 0;
		
		for(int i = 0; i < MC_04_RUN_RESULT.size(); i++) {
			
			Date ONTIME = MC_04_RUN_RESULT.get(i).MC_04_RUNON_TIME;
			Date OFFTIME = MC_04_RUN_RESULT.get(i).MC_04_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_04_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_04_RUN_TOTAL += min;
				
			}
		}
		
		int MC_04_RUN_HOURS = MC_04_RUN_TOTAL / 60;
		int MC_04_RUN_MIN = MC_04_RUN_TOTAL % 60; 
	
		obj.addProperty("MC_04_RUN_HOURS", MC_04_RUN_HOURS);
		obj.addProperty("MC_04_RUN_MIN", MC_04_RUN_MIN);
		
		System.out.println("MC_04 여기까지2");
		
		List<sensorVO> MC_04_ALARM_RESULT = service.MC_04_TIME_ALARM_ON(vo);
		int MC_04_ALARM_TOTAL = 0;
		
		int MC_04_ALARM_MAX = MC_04_ALARM_RESULT.size();
		
		if(MC_04_ALARM_MAX == 0) {
			
			obj.addProperty("MC_04_ALARM_FIRST_TIME", 0);
			
		}else {
			
			Date MC_04_ALARM_FIRST_TIME = MC_04_ALARM_RESULT.get(0).MC_04_ALARMON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String MC_04_ALARM_FIRST_STRING = format1.format(MC_04_ALARM_FIRST_TIME);
			
			obj.addProperty("MC_04_ALARM_FIRST_TIME", MC_04_ALARM_FIRST_STRING);
		}
		
		for(int i = 0; i < MC_04_ALARM_RESULT.size(); i++) {
			
			Date ONTIME = MC_04_ALARM_RESULT.get(i).MC_04_ALARMON_TIME;
			Date OFFTIME = MC_04_ALARM_RESULT.get(i).MC_04_ALARMOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_04_ALARM_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_04_ALARM_TOTAL += min;
				
			}
		}
		
		int MC_04_ALARM_HOURS = MC_04_ALARM_TOTAL / 60;
		int MC_04_ALARM_MIN = MC_04_ALARM_TOTAL % 60; 
	
		obj.addProperty("MC_04_ALARM_HOURS", MC_04_ALARM_HOURS);
		obj.addProperty("MC_04_ALARM_MIN", MC_04_ALARM_MIN);
		
		System.out.println("MC_04 여기까지3");
		
		//MC_05
		
		List<sensorVO> MC_05_POWER_RESULT = service.MC_05_TIME_POWER_ON(vo);
		int MC_05_POWER_TOTAL = 0;
		
		int MC_05_POWER_MAX = MC_05_POWER_RESULT.size();
		
		if(MC_05_POWER_MAX == 0) {
			
			obj.addProperty("MC_05_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date MC_05_POWER_FIRST_TIME = MC_05_POWER_RESULT.get(0).MC_05_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String MC_05_POWER_FIRST_STRING = format1.format(MC_05_POWER_FIRST_TIME);
			
			obj.addProperty("MC_05_POWER_FIRST_TIME", MC_05_POWER_FIRST_STRING);
		}
		
		for(int i = 0; i < MC_05_POWER_RESULT.size(); i++) {
			
			Date ONTIME = MC_05_POWER_RESULT.get(i).MC_05_POWERON_TIME;
			Date OFFTIME = MC_05_POWER_RESULT.get(i).MC_05_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_05_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_05_POWER_TOTAL += min;
				
			}
		}
		
		int MC_05_POWER_HOURS = MC_05_POWER_TOTAL / 60;
		int MC_05_POWER_MIN = MC_05_POWER_TOTAL % 60; 
	
		obj.addProperty("MC_05_POWER_HOURS", MC_05_POWER_HOURS);
		obj.addProperty("MC_05_POWER_MIN", MC_05_POWER_MIN);
		
		List<sensorVO> MC_05_RUN_RESULT = service.MC_05_TIME_RUN_ON(vo);
		int MC_05_RUN_TOTAL = 0;
		
		for(int i = 0; i < MC_05_RUN_RESULT.size(); i++) {
			
			Date ONTIME = MC_05_RUN_RESULT.get(i).MC_05_RUNON_TIME;
			Date OFFTIME = MC_05_RUN_RESULT.get(i).MC_05_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_05_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_05_RUN_TOTAL += min;
				
			}
		}
		
		int MC_05_RUN_HOURS = MC_05_RUN_TOTAL / 60;
		int MC_05_RUN_MIN = MC_05_RUN_TOTAL % 60; 
	
		obj.addProperty("MC_05_RUN_HOURS", MC_05_RUN_HOURS);
		obj.addProperty("MC_05_RUN_MIN", MC_05_RUN_MIN);
		
		
		List<sensorVO> MC_05_ALARM_RESULT = service.MC_05_TIME_ALARM_ON(vo);
		int MC_05_ALARM_TOTAL = 0;
		
		int MC_05_ALARM_MAX = MC_05_ALARM_RESULT.size();
		
		if(MC_05_ALARM_MAX == 0) {
			
			obj.addProperty("MC_05_ALARM_FIRST_TIME", 0);
			
		}else {
			
			Date MC_05_ALARM_FIRST_TIME = MC_05_ALARM_RESULT.get(0).MC_05_ALARMON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String MC_05_ALARM_FIRST_STRING = format1.format(MC_05_ALARM_FIRST_TIME);
			
			obj.addProperty("MC_05_ALARM_FIRST_TIME", MC_05_ALARM_FIRST_STRING);
		}
		
		
		for(int i = 0; i < MC_05_ALARM_RESULT.size(); i++) {
			
			Date ONTIME = MC_05_ALARM_RESULT.get(i).MC_05_ALARMON_TIME;
			Date OFFTIME = MC_05_ALARM_RESULT.get(i).MC_05_ALARMOFF_TIME;
			
			if(OFFTIME == null) {

				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_05_ALARM_TOTAL += min;
				
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_05_ALARM_TOTAL += min;
				
			}
		}
		
		int MC_05_ALARM_HOURS = MC_05_ALARM_TOTAL / 60;
		int MC_05_ALARM_MIN = MC_05_ALARM_TOTAL % 60; 
	
		obj.addProperty("MC_05_ALARM_HOURS", MC_05_ALARM_HOURS);
		obj.addProperty("MC_05_ALARM_MIN", MC_05_ALARM_MIN);
		
		
		//MC_06
		
		List<sensorVO> MC_06_POWER_RESULT = service.MC_06_TIME_POWER_ON(vo);
		int MC_06_POWER_TOTAL = 0;
		
		int MC_06_POWER_MAX = MC_06_POWER_RESULT.size();
		
		if(MC_06_POWER_MAX == 0) {
			
			obj.addProperty("MC_06_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date MC_06_POWER_FIRST_TIME = MC_06_POWER_RESULT.get(0).MC_06_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String MC_06_POWER_FIRST_STRING = format1.format(MC_06_POWER_FIRST_TIME);
			
			obj.addProperty("MC_06_POWER_FIRST_TIME", MC_06_POWER_FIRST_STRING);
		}
		
		
		for(int i = 0; i < MC_06_POWER_RESULT.size(); i++) {
			
			Date ONTIME = MC_06_POWER_RESULT.get(i).MC_06_POWERON_TIME;
			Date OFFTIME = MC_06_POWER_RESULT.get(i).MC_06_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_06_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_06_POWER_TOTAL += min;
				
			}
		}
		
		int MC_06_POWER_HOURS = MC_06_POWER_TOTAL / 60;
		int MC_06_POWER_MIN = MC_06_POWER_TOTAL % 60; 
	
		obj.addProperty("MC_06_POWER_HOURS", MC_06_POWER_HOURS);
		obj.addProperty("MC_06_POWER_MIN", MC_06_POWER_MIN);
		
		List<sensorVO> MC_06_RUN_RESULT = service.MC_06_TIME_RUN_ON(vo);
		int MC_06_RUN_TOTAL = 0;
		
		for(int i = 0; i < MC_06_RUN_RESULT.size(); i++) {
			
			Date ONTIME = MC_06_RUN_RESULT.get(i).MC_06_RUNON_TIME;
			Date OFFTIME = MC_06_RUN_RESULT.get(i).MC_06_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_06_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_06_RUN_TOTAL += min;
				
			}
		}
		
		int MC_06_RUN_HOURS = MC_06_RUN_TOTAL / 60;
		int MC_06_RUN_MIN = MC_06_RUN_TOTAL % 60; 
	
		obj.addProperty("MC_06_RUN_HOURS", MC_06_RUN_HOURS);
		obj.addProperty("MC_06_RUN_MIN", MC_06_RUN_MIN);
		
		List<sensorVO> MC_06_ALARM_RESULT = service.MC_06_TIME_ALARM_ON(vo);
		int MC_06_ALARM_TOTAL = 0;
		
		int MC_06_ALARM_MAX = MC_06_ALARM_RESULT.size();
		
		if(MC_06_ALARM_MAX == 0) {
			
			obj.addProperty("MC_06_ALARM_FIRST_TIME", 0);
			
		}else {
			
			Date MC_06_ALARM_FIRST_TIME = MC_06_ALARM_RESULT.get(0).MC_06_ALARMON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String MC_06_ALARM_FIRST_STRING = format1.format(MC_06_ALARM_FIRST_TIME);
			
			obj.addProperty("MC_06_ALARM_FIRST_TIME", MC_06_ALARM_FIRST_STRING);
		}
		
		for(int i = 0; i < MC_06_ALARM_RESULT.size(); i++) {
			
			Date ONTIME = MC_06_ALARM_RESULT.get(i).MC_06_ALARMON_TIME;
			Date OFFTIME = MC_06_ALARM_RESULT.get(i).MC_06_ALARMOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_06_ALARM_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_06_ALARM_TOTAL += min;
				
			}
		}
		
		int MC_06_ALARM_HOURS = MC_06_ALARM_TOTAL / 60;
		int MC_06_ALARM_MIN = MC_06_ALARM_TOTAL % 60; 
	
		obj.addProperty("MC_06_ALARM_HOURS", MC_06_ALARM_HOURS);
		obj.addProperty("MC_06_ALARM_MIN", MC_06_ALARM_MIN);
		
		
		//MC_07
		
		List<sensorVO> MC_07_POWER_RESULT = service.MC_07_TIME_POWER_ON(vo);
		int MC_07_POWER_TOTAL = 0;
		
		int MC_07_POWER_MAX = MC_07_POWER_RESULT.size();
		
		if(MC_07_POWER_MAX == 0) {
			
			obj.addProperty("MC_07_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date MC_07_POWER_FIRST_TIME = MC_07_POWER_RESULT.get(0).MC_07_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String MC_07_POWER_FIRST_STRING = format1.format(MC_07_POWER_FIRST_TIME);
			
			obj.addProperty("MC_07_POWER_FIRST_TIME", MC_07_POWER_FIRST_STRING);
		}
		
		for(int i = 0; i < MC_07_POWER_RESULT.size(); i++) {
			
			Date ONTIME = MC_07_POWER_RESULT.get(i).MC_07_POWERON_TIME;
			Date OFFTIME = MC_07_POWER_RESULT.get(i).MC_07_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_07_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_07_POWER_TOTAL += min;
				
			}
		}
		
		int MC_07_POWER_HOURS = MC_07_POWER_TOTAL / 60;
		int MC_07_POWER_MIN = MC_07_POWER_TOTAL % 60; 
	
		obj.addProperty("MC_07_POWER_HOURS", MC_07_POWER_HOURS);
		obj.addProperty("MC_07_POWER_MIN", MC_07_POWER_MIN);
		
		List<sensorVO> MC_07_RUN_RESULT = service.MC_07_TIME_RUN_ON(vo);
		int MC_07_RUN_TOTAL = 0;
		
		for(int i = 0; i < MC_07_RUN_RESULT.size(); i++) {
			
			Date ONTIME = MC_07_RUN_RESULT.get(i).MC_07_RUNON_TIME;
			Date OFFTIME = MC_07_RUN_RESULT.get(i).MC_07_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_07_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_07_RUN_TOTAL += min;
				
			}
		}
		
		int MC_07_RUN_HOURS = MC_07_RUN_TOTAL / 60;
		int MC_07_RUN_MIN = MC_07_RUN_TOTAL % 60; 
	
		obj.addProperty("MC_07_RUN_HOURS", MC_07_RUN_HOURS);
		obj.addProperty("MC_07_RUN_MIN", MC_07_RUN_MIN);
		
		
		List<sensorVO> MC_07_ALARM_RESULT = service.MC_07_TIME_ALARM_ON(vo);
		int MC_07_ALARM_TOTAL = 0;
		
		int MC_07_ALARM_MAX = MC_07_ALARM_RESULT.size();
		
		if(MC_07_ALARM_MAX == 0) {
			
			obj.addProperty("MC_07_ALARM_FIRST_TIME", 0);
			
		}else {
			
			Date MC_07_ALARM_FIRST_TIME = MC_07_ALARM_RESULT.get(0).MC_07_ALARMON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String MC_07_ALARM_FIRST_STRING = format1.format(MC_07_ALARM_FIRST_TIME);
			
			obj.addProperty("MC_07_ALARM_FIRST_TIME", MC_07_ALARM_FIRST_STRING);
		}
		
		for(int i = 0; i < MC_07_ALARM_RESULT.size(); i++) {
			
			Date ONTIME = MC_07_ALARM_RESULT.get(i).MC_07_ALARMON_TIME;
			Date OFFTIME = MC_07_ALARM_RESULT.get(i).MC_07_ALARMOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_07_ALARM_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_07_ALARM_TOTAL += min;
				
			}
		}
		
		int MC_07_ALARM_HOURS = MC_07_ALARM_TOTAL / 60;
		int MC_07_ALARM_MIN = MC_07_ALARM_TOTAL % 60; 
	
		obj.addProperty("MC_07_ALARM_HOURS", MC_07_ALARM_HOURS);
		obj.addProperty("MC_07_ALARM_MIN", MC_07_ALARM_MIN);
	
		//MC_08
		
		List<sensorVO> MC_08_POWER_RESULT = service.MC_08_TIME_POWER_ON(vo);
		int MC_08_POWER_TOTAL = 0;
		
		
		int MC_08_POWER_MAX = MC_08_POWER_RESULT.size();
		
		if(MC_08_POWER_MAX == 0) {
			
			obj.addProperty("MC_08_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date MC_08_POWER_FIRST_TIME = MC_08_POWER_RESULT.get(0).MC_08_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String MC_08_POWER_FIRST_STRING = format1.format(MC_08_POWER_FIRST_TIME);
			
			obj.addProperty("MC_08_POWER_FIRST_TIME", MC_08_POWER_FIRST_STRING);
		}
		
		for(int i = 0; i < MC_08_POWER_RESULT.size(); i++) {
			
			Date ONTIME = MC_08_POWER_RESULT.get(i).MC_08_POWERON_TIME;
			Date OFFTIME = MC_08_POWER_RESULT.get(i).MC_08_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_08_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_08_POWER_TOTAL += min;
				
			}
		}
		
		int MC_08_POWER_HOURS = MC_08_POWER_TOTAL / 60;
		int MC_08_POWER_MIN = MC_08_POWER_TOTAL % 60; 
	
		obj.addProperty("MC_08_POWER_HOURS", MC_08_POWER_HOURS);
		obj.addProperty("MC_08_POWER_MIN", MC_08_POWER_MIN);
		
		List<sensorVO> MC_08_RUN_RESULT = service.MC_08_TIME_RUN_ON(vo);
		int MC_08_RUN_TOTAL = 0;
		
		for(int i = 0; i < MC_08_RUN_RESULT.size(); i++) {
			
			Date ONTIME = MC_08_RUN_RESULT.get(i).MC_08_RUNON_TIME;
			Date OFFTIME = MC_08_RUN_RESULT.get(i).MC_08_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_08_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_08_RUN_TOTAL += min;
				
			}
		}
		
		int MC_08_RUN_HOURS = MC_08_RUN_TOTAL / 60;
		int MC_08_RUN_MIN = MC_08_RUN_TOTAL % 60; 
	
		obj.addProperty("MC_08_RUN_HOURS", MC_08_RUN_HOURS);
		obj.addProperty("MC_08_RUN_MIN", MC_08_RUN_MIN);
		
		System.out.println("MC_08 여기까지2");
		
		List<sensorVO> MC_08_ALARM_RESULT = service.MC_08_TIME_ALARM_ON(vo);
		int MC_08_ALARM_TOTAL = 0;
		
		int MC_08_ALARM_MAX = MC_08_ALARM_RESULT.size();
		
		if(MC_08_ALARM_MAX == 0) {
			
			obj.addProperty("MC_08_ALARM_FIRST_TIME", 0);
			
		}else {
			
			Date MC_08_ALARM_FIRST_TIME = MC_08_ALARM_RESULT.get(0).MC_08_ALARMON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String MC_08_ALARM_FIRST_STRING = format1.format(MC_08_ALARM_FIRST_TIME);
			
			obj.addProperty("MC_08_ALARM_FIRST_TIME", MC_08_ALARM_FIRST_STRING);
		}
		
		for(int i = 0; i < MC_08_ALARM_RESULT.size(); i++) {
			
			Date ONTIME = MC_08_ALARM_RESULT.get(i).MC_08_ALARMON_TIME;
			Date OFFTIME = MC_08_ALARM_RESULT.get(i).MC_08_ALARMOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_08_ALARM_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_08_ALARM_TOTAL += min;
				
			}
		}
		
		int MC_08_ALARM_HOURS = MC_08_ALARM_TOTAL / 60;
		int MC_08_ALARM_MIN = MC_08_ALARM_TOTAL % 60; 
	
		obj.addProperty("MC_08_ALARM_HOURS", MC_08_ALARM_HOURS);
		obj.addProperty("MC_08_ALARM_MIN", MC_08_ALARM_MIN);
		
		
		//MC_09
		List<sensorVO> MC_09_POWER_RESULT = service.MC_09_TIME_POWER_ON(vo);
		int MC_09_POWER_TOTAL = 0;
		
		int MC_09_POWER_MAX = MC_09_POWER_RESULT.size();
		
		if(MC_09_POWER_MAX == 0) {
			
			obj.addProperty("MC_09_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date MC_09_POWER_FIRST_TIME = MC_09_POWER_RESULT.get(0).MC_09_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String MC_09_POWER_FIRST_STRING = format1.format(MC_09_POWER_FIRST_TIME);
			
			obj.addProperty("MC_09_POWER_FIRST_TIME", MC_09_POWER_FIRST_STRING);
		}
		
		
		for(int i = 0; i < MC_09_POWER_RESULT.size(); i++) {
			
			Date ONTIME = MC_09_POWER_RESULT.get(i).MC_09_POWERON_TIME;
			Date OFFTIME = MC_09_POWER_RESULT.get(i).MC_09_POWEROFF_TIME;
			
			if(OFFTIME == null) {

				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_09_POWER_TOTAL += min;
				
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_09_POWER_TOTAL += min;
				
			}
		}
		
		int MC_09_POWER_HOURS = MC_09_POWER_TOTAL / 60;
		int MC_09_POWER_MIN = MC_09_POWER_TOTAL % 60; 
	
		obj.addProperty("MC_09_POWER_HOURS", MC_09_POWER_HOURS);
		obj.addProperty("MC_09_POWER_MIN", MC_09_POWER_MIN);
		
		List<sensorVO> MC_09_RUN_RESULT = service.MC_09_TIME_RUN_ON(vo);
		int MC_09_RUN_TOTAL = 0;
		
		for(int i = 0; i < MC_09_RUN_RESULT.size(); i++) {
			
			Date ONTIME = MC_09_RUN_RESULT.get(i).MC_09_RUNON_TIME;
			Date OFFTIME = MC_09_RUN_RESULT.get(i).MC_09_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_09_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_09_RUN_TOTAL += min;
				
			}
		}
		
		int MC_09_RUN_HOURS = MC_09_RUN_TOTAL / 60;
		int MC_09_RUN_MIN = MC_09_RUN_TOTAL % 60; 
	
		obj.addProperty("MC_09_RUN_HOURS", MC_09_RUN_HOURS);
		obj.addProperty("MC_09_RUN_MIN", MC_09_RUN_MIN);
		
		
		List<sensorVO> MC_09_ALARM_RESULT = service.MC_09_TIME_ALARM_ON(vo);
		int MC_09_ALARM_TOTAL = 0;
		
		int MC_09_ALARM_MAX = MC_09_ALARM_RESULT.size();
		
		if(MC_09_ALARM_MAX == 0) {
			
			obj.addProperty("MC_09_ALARM_FIRST_TIME", 0);
			
		}else {
			
			Date MC_09_ALARM_FIRST_TIME = MC_09_ALARM_RESULT.get(0).MC_09_ALARMON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String MC_09_ALARM_FIRST_STRING = format1.format(MC_09_ALARM_FIRST_TIME);
			
			obj.addProperty("MC_09_ALARM_FIRST_TIME", MC_09_ALARM_FIRST_STRING);
		}
		
		
		for(int i = 0; i < MC_09_ALARM_RESULT.size(); i++) {
			
			Date ONTIME = MC_09_ALARM_RESULT.get(i).MC_09_ALARMON_TIME;
			Date OFFTIME = MC_09_ALARM_RESULT.get(i).MC_09_ALARMOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_09_ALARM_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_09_ALARM_TOTAL += min;
				
			}
		}
		
		int MC_09_ALARM_HOURS = MC_09_ALARM_TOTAL / 60;
		int MC_09_ALARM_MIN = MC_09_ALARM_TOTAL % 60; 
	
		obj.addProperty("MC_09_ALARM_HOURS", MC_09_ALARM_HOURS);
		obj.addProperty("MC_09_ALARM_MIN", MC_09_ALARM_MIN);
		
		System.out.println("MC_09 여기까지3");
		
		//MC_10
		List<sensorVO> MC_10_POWER_RESULT = service.MC_10_TIME_POWER_ON(vo);
		int MC_10_POWER_TOTAL = 0;
		
		int MC_10_POWER_MAX = MC_10_POWER_RESULT.size();
		
		if(MC_10_POWER_MAX == 0) {
			
			obj.addProperty("MC_10_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date MC_10_POWER_FIRST_TIME = MC_10_POWER_RESULT.get(0).MC_10_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String MC_10_POWER_FIRST_STRING = format1.format(MC_10_POWER_FIRST_TIME);
			
			obj.addProperty("MC_10_POWER_FIRST_TIME", MC_10_POWER_FIRST_STRING);
		}
		
		for(int i = 0; i < MC_10_POWER_RESULT.size(); i++) {
			
			Date ONTIME = MC_10_POWER_RESULT.get(i).MC_10_POWERON_TIME;
			Date OFFTIME = MC_10_POWER_RESULT.get(i).MC_10_POWEROFF_TIME;
			
			if(OFFTIME == null) {

				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_10_POWER_TOTAL += min;
				
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_10_POWER_TOTAL += min;
				
			}
		}
		
		int MC_10_POWER_HOURS = MC_10_POWER_TOTAL / 60;
		int MC_10_POWER_MIN = MC_10_POWER_TOTAL % 60; 
	
		obj.addProperty("MC_10_POWER_HOURS", MC_10_POWER_HOURS);
		obj.addProperty("MC_10_POWER_MIN", MC_10_POWER_MIN);
		
		List<sensorVO> MC_10_RUN_RESULT = service.MC_10_TIME_RUN_ON(vo);
		int MC_10_RUN_TOTAL = 0;
		
		for(int i = 0; i < MC_10_RUN_RESULT.size(); i++) {
			
			Date ONTIME = MC_10_RUN_RESULT.get(i).MC_10_RUNON_TIME;
			Date OFFTIME = MC_10_RUN_RESULT.get(i).MC_10_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_10_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_10_RUN_TOTAL += min;
				
			}
		}
		
		int MC_10_RUN_HOURS = MC_10_RUN_TOTAL / 60;
		int MC_10_RUN_MIN = MC_10_RUN_TOTAL % 60; 
	
		obj.addProperty("MC_10_RUN_HOURS", MC_10_RUN_HOURS);
		obj.addProperty("MC_10_RUN_MIN", MC_10_RUN_MIN);
		
		
		List<sensorVO> MC_10_ALARM_RESULT = service.MC_10_TIME_ALARM_ON(vo);
		int MC_10_ALARM_TOTAL = 0;
		
		int MC_10_ALARM_MAX = MC_10_ALARM_RESULT.size();
		
		if(MC_10_ALARM_MAX == 0) {
			
			obj.addProperty("MC_10_ALARM_FIRST_TIME", 0);
			
		}else {
			
			Date MC_10_ALARM_FIRST_TIME = MC_10_ALARM_RESULT.get(0).MC_10_ALARMON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String MC_10_ALARM_FIRST_STRING = format1.format(MC_10_ALARM_FIRST_TIME);
			
			obj.addProperty("MC_10_ALARM_FIRST_TIME", MC_10_ALARM_FIRST_STRING);
		}
		
		
		for(int i = 0; i < MC_10_ALARM_RESULT.size(); i++) {
			
			Date ONTIME = MC_10_ALARM_RESULT.get(i).MC_10_ALARMON_TIME;
			Date OFFTIME = MC_10_ALARM_RESULT.get(i).MC_10_ALARMOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_10_ALARM_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_10_ALARM_TOTAL += min;
				
			}
		}
		
		int MC_10_ALARM_HOURS = MC_10_ALARM_TOTAL / 60;
		int MC_10_ALARM_MIN = MC_10_ALARM_TOTAL % 60; 
	
		obj.addProperty("MC_10_ALARM_HOURS", MC_10_ALARM_HOURS);
		obj.addProperty("MC_10_ALARM_MIN", MC_10_ALARM_MIN);
		
		System.out.println("MC_10 여기까지3");
		
		//MC_11
		
		List<sensorVO> MC_11_POWER_RESULT = service.MC_11_TIME_POWER_ON(vo);
		int MC_11_POWER_TOTAL = 0;
		
		int MC_11_POWER_MAX = MC_11_POWER_RESULT.size();
		
		if(MC_11_POWER_MAX == 0) {
			
			obj.addProperty("MC_11_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date MC_11_POWER_FIRST_TIME = MC_11_POWER_RESULT.get(0).MC_11_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String MC_11_POWER_FIRST_STRING = format1.format(MC_11_POWER_FIRST_TIME);
			
			obj.addProperty("MC_11_POWER_FIRST_TIME", MC_11_POWER_FIRST_STRING);
		}
		
		for(int i = 0; i < MC_11_POWER_RESULT.size(); i++) {
			
			Date ONTIME = MC_11_POWER_RESULT.get(i).MC_11_POWERON_TIME;
			Date OFFTIME = MC_11_POWER_RESULT.get(i).MC_11_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_11_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_11_POWER_TOTAL += min;
				
			}
		}
		
		int MC_11_POWER_HOURS = MC_11_POWER_TOTAL / 60;
		int MC_11_POWER_MIN = MC_11_POWER_TOTAL % 60; 
	
		obj.addProperty("MC_11_POWER_HOURS", MC_11_POWER_HOURS);
		obj.addProperty("MC_11_POWER_MIN", MC_11_POWER_MIN);
		
		List<sensorVO> MC_11_RUN_RESULT = service.MC_11_TIME_RUN_ON(vo);
		int MC_11_RUN_TOTAL = 0;
		
		for(int i = 0; i < MC_11_RUN_RESULT.size(); i++) {
			
			Date ONTIME = MC_11_RUN_RESULT.get(i).MC_11_RUNON_TIME;
			Date OFFTIME = MC_11_RUN_RESULT.get(i).MC_11_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_11_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_11_RUN_TOTAL += min;
				
			}
		}
		
		int MC_11_RUN_HOURS = MC_11_RUN_TOTAL / 60;
		int MC_11_RUN_MIN = MC_11_RUN_TOTAL % 60; 
	
		obj.addProperty("MC_11_RUN_HOURS", MC_11_RUN_HOURS);
		obj.addProperty("MC_11_RUN_MIN", MC_11_RUN_MIN);
		
		
		List<sensorVO> MC_11_ALARM_RESULT = service.MC_11_TIME_ALARM_ON(vo);
		int MC_11_ALARM_TOTAL = 0;
		
		int MC_11_ALARM_MAX = MC_11_ALARM_RESULT.size();
		
		if(MC_11_ALARM_MAX == 0) {
			
			obj.addProperty("MC_11_ALARM_FIRST_TIME", 0);
			
		}else {
			
			Date MC_11_ALARM_FIRST_TIME = MC_11_ALARM_RESULT.get(0).MC_11_ALARMON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String MC_11_ALARM_FIRST_STRING = format1.format(MC_11_ALARM_FIRST_TIME);
			
			obj.addProperty("MC_11_ALARM_FIRST_TIME", MC_11_ALARM_FIRST_STRING);
		}
		
		for(int i = 0; i < MC_11_ALARM_RESULT.size(); i++) {
			
			Date ONTIME = MC_11_ALARM_RESULT.get(i).MC_11_ALARMON_TIME;
			Date OFFTIME = MC_11_ALARM_RESULT.get(i).MC_11_ALARMOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_11_ALARM_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				MC_11_ALARM_TOTAL += min;
				
			}
		}
		
		int MC_11_ALARM_HOURS = MC_11_ALARM_TOTAL / 60;
		int MC_11_ALARM_MIN = MC_11_ALARM_TOTAL % 60; 
	
		obj.addProperty("MC_11_ALARM_HOURS", MC_11_ALARM_HOURS);
		obj.addProperty("MC_11_ALARM_MIN", MC_11_ALARM_MIN);
		
		System.out.println("MC_11 여기까지3");
		
		//BM_01
		List<sensorVO> BM_01_POWER_RESULT = service.BM_01_TIME_POWER_ON(vo);
		int BM_01_POWER_TOTAL = 0;
		
		int BM_01_POWER_MAX = BM_01_POWER_RESULT.size();
		
		if(BM_01_POWER_MAX == 0) {
			
			obj.addProperty("BM_01_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date BM_01_POWER_FIRST_TIME = BM_01_POWER_RESULT.get(0).BM_01_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String BM_01_POWER_FIRST_STRING = format1.format(BM_01_POWER_FIRST_TIME);
			
			obj.addProperty("BM_01_POWER_FIRST_TIME", BM_01_POWER_FIRST_STRING);
		}

		
		for(int i = 0; i < BM_01_POWER_RESULT.size(); i++) {
			
			Date ONTIME = BM_01_POWER_RESULT.get(i).BM_01_POWERON_TIME;
			Date OFFTIME = BM_01_POWER_RESULT.get(i).BM_01_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				BM_01_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				BM_01_POWER_TOTAL += min;
				
			}
		}
		
		int BM_01_POWER_HOURS = BM_01_POWER_TOTAL / 60;
		int BM_01_POWER_MIN = BM_01_POWER_TOTAL % 60; 
	
		obj.addProperty("BM_01_POWER_HOURS", BM_01_POWER_HOURS);
		obj.addProperty("BM_01_POWER_MIN", BM_01_POWER_MIN);
		
		List<sensorVO> BM_01_RUN_RESULT = service.BM_01_TIME_RUN_ON(vo);
		int BM_01_RUN_TOTAL = 0;
		
		for(int i = 0; i < BM_01_RUN_RESULT.size(); i++) {
			
			Date ONTIME = BM_01_RUN_RESULT.get(i).BM_01_RUNON_TIME;
			Date OFFTIME = BM_01_RUN_RESULT.get(i).BM_01_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				BM_01_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				BM_01_RUN_TOTAL += min;
				
			}
		}
		
		int BM_01_RUN_HOURS = BM_01_RUN_TOTAL / 60;
		int BM_01_RUN_MIN = BM_01_RUN_TOTAL % 60; 
	
		obj.addProperty("BM_01_RUN_HOURS", BM_01_RUN_HOURS);
		obj.addProperty("BM_01_RUN_MIN", BM_01_RUN_MIN);

		
		//BM_02
		List<sensorVO> BM_02_POWER_RESULT = service.BM_02_TIME_POWER_ON(vo);
		int BM_02_POWER_TOTAL = 0;
		
		int BM_02_POWER_MAX = BM_02_POWER_RESULT.size();
		
		if(BM_02_POWER_MAX == 0) {
			
			obj.addProperty("BM_02_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date BM_02_POWER_FIRST_TIME = BM_02_POWER_RESULT.get(0).BM_02_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String BM_02_POWER_FIRST_STRING = format1.format(BM_02_POWER_FIRST_TIME);
			
			obj.addProperty("BM_02_POWER_FIRST_TIME", BM_02_POWER_FIRST_STRING);
		}
		
		
		for(int i = 0; i < BM_02_POWER_RESULT.size(); i++) {
			
			Date ONTIME = BM_02_POWER_RESULT.get(i).BM_02_POWERON_TIME;
			Date OFFTIME = BM_02_POWER_RESULT.get(i).BM_02_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				BM_02_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				BM_02_POWER_TOTAL += min;
				
			}
		}
		
		int BM_02_POWER_HOURS = BM_02_POWER_TOTAL / 60;
		int BM_02_POWER_MIN = BM_02_POWER_TOTAL % 60; 
	
		obj.addProperty("BM_02_POWER_HOURS", BM_02_POWER_HOURS);
		obj.addProperty("BM_02_POWER_MIN", BM_02_POWER_MIN);
		
		List<sensorVO> BM_02_RUN_RESULT = service.BM_02_TIME_RUN_ON(vo);
		int BM_02_RUN_TOTAL = 0;
		
		for(int i = 0; i < BM_02_RUN_RESULT.size(); i++) {
			
			Date ONTIME = BM_02_RUN_RESULT.get(i).BM_02_RUNON_TIME;
			Date OFFTIME = BM_02_RUN_RESULT.get(i).BM_02_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				BM_02_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				BM_02_RUN_TOTAL += min;
				
			}
		}
		
		int BM_02_RUN_HOURS = BM_02_RUN_TOTAL / 60;
		int BM_02_RUN_MIN = BM_02_RUN_TOTAL % 60; 
	
		obj.addProperty("BM_02_RUN_HOURS", BM_02_RUN_HOURS);
		obj.addProperty("BM_02_RUN_MIN", BM_02_RUN_MIN);
		
		
		//BS_01
		List<sensorVO> BS_01_POWER_RESULT = service.BS_01_TIME_POWER_ON(vo);
		int BS_01_POWER_TOTAL = 0;
		
		int BS_01_POWER_MAX = BS_01_POWER_RESULT.size();
		
		if(BS_01_POWER_MAX == 0) {
			
			obj.addProperty("BS_01_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date BS_01_POWER_FIRST_TIME = BS_01_POWER_RESULT.get(0).BS_01_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String BS_01_POWER_FIRST_STRING = format1.format(BS_01_POWER_FIRST_TIME);
			
			obj.addProperty("BS_01_POWER_FIRST_TIME", BS_01_POWER_FIRST_STRING);
		}
		
		
		for(int i = 0; i < BS_01_POWER_RESULT.size(); i++) {
			
			Date ONTIME = BS_01_POWER_RESULT.get(i).BS_01_POWERON_TIME;
			Date OFFTIME = BS_01_POWER_RESULT.get(i).BS_01_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				BS_01_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				BS_01_POWER_TOTAL += min;
				
			}
		}
		
		int BS_01_POWER_HOURS = BS_01_POWER_TOTAL / 60;
		int BS_01_POWER_MIN = BS_01_POWER_TOTAL % 60; 
	
		obj.addProperty("BS_01_POWER_HOURS", BS_01_POWER_HOURS);
		obj.addProperty("BS_01_POWER_MIN", BS_01_POWER_MIN);
		
		List<sensorVO> BS_01_RUN_RESULT = service.BS_01_TIME_RUN_ON(vo);
		int BS_01_RUN_TOTAL = 0;
		
		for(int i = 0; i < BS_01_RUN_RESULT.size(); i++) {
			
			Date ONTIME = BS_01_RUN_RESULT.get(i).BS_01_RUNON_TIME;
			Date OFFTIME = BS_01_RUN_RESULT.get(i).BS_01_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				BS_01_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				BS_01_RUN_TOTAL += min;
				
			}
		}
		
		int BS_01_RUN_HOURS = BS_01_RUN_TOTAL / 60;
		int BS_01_RUN_MIN = BS_01_RUN_TOTAL % 60; 
	
		obj.addProperty("BS_01_RUN_HOURS", BS_01_RUN_HOURS);
		obj.addProperty("BS_01_RUN_MIN", BS_01_RUN_MIN);
		
		//BS_02
		List<sensorVO> BS_02_POWER_RESULT = service.BS_02_TIME_POWER_ON(vo);
		int BS_02_POWER_TOTAL = 0;
		
		int BS_02_POWER_MAX = BS_02_POWER_RESULT.size();
		
		if(BS_02_POWER_MAX == 0) {
			
			obj.addProperty("BS_02_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date BS_02_POWER_FIRST_TIME = BS_02_POWER_RESULT.get(0).BS_02_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String BS_02_POWER_FIRST_STRING = format1.format(BS_02_POWER_FIRST_TIME);
			
			obj.addProperty("BS_02_POWER_FIRST_TIME", BS_02_POWER_FIRST_STRING);
		}
		
		
		for(int i = 0; i < BS_02_POWER_RESULT.size(); i++) {
			
			Date ONTIME = BS_02_POWER_RESULT.get(i).BS_02_POWERON_TIME;
			Date OFFTIME = BS_02_POWER_RESULT.get(i).BS_02_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				BS_02_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				BS_02_POWER_TOTAL += min;
				
			}
		}
		
		int BS_02_POWER_HOURS = BS_02_POWER_TOTAL / 60;
		int BS_02_POWER_MIN = BS_02_POWER_TOTAL % 60; 
	
		obj.addProperty("BS_02_POWER_HOURS", BS_02_POWER_HOURS);
		obj.addProperty("BS_02_POWER_MIN", BS_02_POWER_MIN);
		
		List<sensorVO> BS_02_RUN_RESULT = service.BS_02_TIME_RUN_ON(vo);
		int BS_02_RUN_TOTAL = 0;
		
		for(int i = 0; i < BS_02_RUN_RESULT.size(); i++) {
			
			Date ONTIME = BS_02_RUN_RESULT.get(i).BS_02_RUNON_TIME;
			Date OFFTIME = BS_02_RUN_RESULT.get(i).BS_02_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				BS_02_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				BS_02_RUN_TOTAL += min;
				
			}
		}
		
		int BS_02_RUN_HOURS = BS_02_RUN_TOTAL / 60;
		int BS_02_RUN_MIN = BS_02_RUN_TOTAL % 60; 
	
		obj.addProperty("BS_02_RUN_HOURS", BS_02_RUN_HOURS);
		obj.addProperty("BS_02_RUN_MIN", BS_02_RUN_MIN);
		
		
		//BS_03
		List<sensorVO> BS_03_POWER_RESULT = service.BS_03_TIME_POWER_ON(vo);
		int BS_03_POWER_TOTAL = 0;
		
		
		int BS_03_POWER_MAX = BS_03_POWER_RESULT.size();
		
		if(BS_03_POWER_MAX == 0) {
			
			obj.addProperty("BS_03_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date BS_03_POWER_FIRST_TIME = BS_03_POWER_RESULT.get(0).BS_03_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String BS_03_POWER_FIRST_STRING = format1.format(BS_03_POWER_FIRST_TIME);
			
			obj.addProperty("BS_03_POWER_FIRST_TIME", BS_03_POWER_FIRST_STRING);
		}
		
		for(int i = 0; i < BS_03_POWER_RESULT.size(); i++) {
			
			Date ONTIME = BS_03_POWER_RESULT.get(i).BS_03_POWERON_TIME;
			Date OFFTIME = BS_03_POWER_RESULT.get(i).BS_03_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				BS_03_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				BS_03_POWER_TOTAL += min;
				
			}
		}
		
		int BS_03_POWER_HOURS = BS_03_POWER_TOTAL / 60;
		int BS_03_POWER_MIN = BS_03_POWER_TOTAL % 60; 
	
		obj.addProperty("BS_03_POWER_HOURS", BS_03_POWER_HOURS);
		obj.addProperty("BS_03_POWER_MIN", BS_03_POWER_MIN);
		
		List<sensorVO> BS_03_RUN_RESULT = service.BS_03_TIME_RUN_ON(vo);
		int BS_03_RUN_TOTAL = 0;
		
		for(int i = 0; i < BS_03_RUN_RESULT.size(); i++) {
			
			Date ONTIME = BS_03_RUN_RESULT.get(i).BS_03_RUNON_TIME;
			Date OFFTIME = BS_03_RUN_RESULT.get(i).BS_03_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				BS_03_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				BS_03_RUN_TOTAL += min;
				
			}
		}
		
		int BS_03_RUN_HOURS = BS_03_RUN_TOTAL / 60;
		int BS_03_RUN_MIN = BS_03_RUN_TOTAL % 60; 
	
		obj.addProperty("BS_03_RUN_HOURS", BS_03_RUN_HOURS);
		obj.addProperty("BS_03_RUN_MIN", BS_03_RUN_MIN);
	
		System.out.println("BS_03 여기까지2");
		
		return obj.toString();
		
	}
	
	
	@RequestMapping(value = "/INDEX2_ALL_TIME", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String INDEX2_ALL_TIME(sensorVO vo) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		Calendar c1 = Calendar.getInstance();
		
		Calendar c2 = Calendar.getInstance();
		
		c2.setTime(new Date());
		
		//c2.add(c2.DATE, -3);
		
		String strToday = sdf.format(c1.getTime());
		
		//String NotToday = sdf.format(c2.getTime());
		
		//vo.setDEL_DAY(NotToday);
		vo.setTODAY(strToday);
		
		/*
		//인덱스 2 관평동 프레스실 오늘 기준으로 -3일전 데이터들 삭제
		service.PR_01_DELETE(vo);
		service.PR_02_DELETE(vo);
		service.PR_03_DELETE(vo);
		service.BS_04_DELETE(vo);
		service.PR_05_DELETE(vo);
		service.TC_02_DELETE(vo);
		*/

		JsonObject obj = new JsonObject();

		Date time = new Date();
		
		//MC_01
		
		List<sensorVO> PR_01_POWER_RESULT = service.PR_01_TIME_POWER_ON(vo);
		int PR_01_POWER_TOTAL = 0;
		
		int PR_01_POWER_MAX = PR_01_POWER_RESULT.size();
		
		if(PR_01_POWER_MAX == 0) {
			
			obj.addProperty("PR_01_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date PR_01_POWER_FIRST_TIME = PR_01_POWER_RESULT.get(0).PR_01_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String PR_01_POWER_FIRST_STRING = format1.format(PR_01_POWER_FIRST_TIME);
			
			obj.addProperty("PR_01_POWER_FIRST_TIME", PR_01_POWER_FIRST_STRING);
		}
		
		for(int i = 0; i < PR_01_POWER_RESULT.size(); i++) {
			
			Date ONTIME = PR_01_POWER_RESULT.get(i).PR_01_POWERON_TIME;
			Date OFFTIME = PR_01_POWER_RESULT.get(i).PR_01_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				PR_01_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				PR_01_POWER_TOTAL += min;
				
			}
		}
		
		int PR_01_POWER_HOURS = PR_01_POWER_TOTAL / 60;
		int PR_01_POWER_MIN = PR_01_POWER_TOTAL % 60; 
	
		obj.addProperty("PR_01_POWER_HOURS", PR_01_POWER_HOURS);
		obj.addProperty("PR_01_POWER_MIN", PR_01_POWER_MIN);		
		
		
		List<sensorVO> PR_01_RUN_RESULT = service.PR_01_TIME_RUN_ON(vo);
		int PR_01_RUN_TOTAL = 0;
		
		for(int i = 0; i < PR_01_RUN_RESULT.size(); i++) {
			
			Date ONTIME = PR_01_RUN_RESULT.get(i).PR_01_RUNON_TIME;
			Date OFFTIME = PR_01_RUN_RESULT.get(i).PR_01_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				PR_01_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				PR_01_RUN_TOTAL += min;
				
			}
		}
		
		int PR_01_RUN_HOURS = PR_01_RUN_TOTAL / 60;
		int PR_01_RUN_MIN = PR_01_RUN_TOTAL % 60; 
	
		obj.addProperty("PR_01_RUN_HOURS", PR_01_RUN_HOURS);
		obj.addProperty("PR_01_RUN_MIN", PR_01_RUN_MIN);
		
		
		//BS_03
		List<sensorVO> PR_02_POWER_RESULT = service.PR_02_TIME_POWER_ON(vo);
		int PR_02_POWER_TOTAL = 0;
		
		
		int PR_02_POWER_MAX = PR_02_POWER_RESULT.size();
		
		if(PR_02_POWER_MAX == 0) {
			
			obj.addProperty("PR_02_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date PR_02_POWER_FIRST_TIME = PR_02_POWER_RESULT.get(0).PR_02_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String PR_02_POWER_FIRST_STRING = format1.format(PR_02_POWER_FIRST_TIME);
			
			obj.addProperty("PR_02_POWER_FIRST_TIME", PR_02_POWER_FIRST_STRING);
		}
		
		for(int i = 0; i < PR_02_POWER_RESULT.size(); i++) {
			
			Date ONTIME = PR_02_POWER_RESULT.get(i).PR_02_POWERON_TIME;
			Date OFFTIME = PR_02_POWER_RESULT.get(i).PR_02_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				PR_02_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				PR_02_POWER_TOTAL += min;
				
			}
		}
		
		int PR_02_POWER_HOURS = PR_02_POWER_TOTAL / 60;
		int PR_02_POWER_MIN = PR_02_POWER_TOTAL % 60; 
	
		obj.addProperty("PR_02_POWER_HOURS", PR_02_POWER_HOURS);
		obj.addProperty("PR_02_POWER_MIN", PR_02_POWER_MIN);
		
		List<sensorVO> PR_02_RUN_RESULT = service.PR_02_TIME_RUN_ON(vo);
		int PR_02_RUN_TOTAL = 0;
		
		for(int i = 0; i < PR_02_RUN_RESULT.size(); i++) {
			
			Date ONTIME = PR_02_RUN_RESULT.get(i).PR_02_RUNON_TIME;
			Date OFFTIME = PR_02_RUN_RESULT.get(i).PR_02_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				PR_02_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				PR_02_RUN_TOTAL += min;
				
			}
		}
		
		int PR_02_RUN_HOURS = PR_02_RUN_TOTAL / 60;
		int PR_02_RUN_MIN = PR_02_RUN_TOTAL % 60; 
	
		obj.addProperty("PR_02_RUN_HOURS", PR_02_RUN_HOURS);
		obj.addProperty("PR_02_RUN_MIN", PR_02_RUN_MIN);
		
		//PR_03
		List<sensorVO> PR_03_POWER_RESULT = service.PR_03_TIME_POWER_ON(vo);
		int PR_03_POWER_TOTAL = 0;
		
		int PR_03_POWER_MAX = PR_03_POWER_RESULT.size();
		
		if(PR_03_POWER_MAX == 0) {
			
			obj.addProperty("PR_03_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date PR_03_POWER_FIRST_TIME = PR_03_POWER_RESULT.get(0).PR_03_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String PR_03_POWER_FIRST_STRING = format1.format(PR_03_POWER_FIRST_TIME);
			
			obj.addProperty("PR_03_POWER_FIRST_TIME", PR_03_POWER_FIRST_STRING);
		}
		
		for(int i = 0; i < PR_03_POWER_RESULT.size(); i++) {
			
			Date ONTIME = PR_03_POWER_RESULT.get(i).PR_03_POWERON_TIME;
			Date OFFTIME = PR_03_POWER_RESULT.get(i).PR_03_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				PR_03_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				PR_03_POWER_TOTAL += min;
				
			}
		}
		
		int PR_03_POWER_HOURS = PR_03_POWER_TOTAL / 60;
		int PR_03_POWER_MIN = PR_03_POWER_TOTAL % 60; 
	
		obj.addProperty("PR_03_POWER_HOURS", PR_03_POWER_HOURS);
		obj.addProperty("PR_03_POWER_MIN", PR_03_POWER_MIN);
		
		List<sensorVO> PR_03_RUN_RESULT = service.PR_03_TIME_RUN_ON(vo);
		int PR_03_RUN_TOTAL = 0;
		
		for(int i = 0; i < PR_03_RUN_RESULT.size(); i++) {
			
			Date ONTIME = PR_03_RUN_RESULT.get(i).PR_03_RUNON_TIME;
			Date OFFTIME = PR_03_RUN_RESULT.get(i).PR_03_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				PR_03_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				PR_03_RUN_TOTAL += min;
				
			}
		}
		
		int PR_03_RUN_HOURS = PR_03_RUN_TOTAL / 60;
		int PR_03_RUN_MIN = PR_03_RUN_TOTAL % 60; 
	
		obj.addProperty("PR_03_RUN_HOURS", PR_03_RUN_HOURS);
		obj.addProperty("PR_03_RUN_MIN", PR_03_RUN_MIN);
		
		//BS_04
		List<sensorVO> BS_04_POWER_RESULT = service.BS_04_TIME_POWER_ON(vo);
		int BS_04_POWER_TOTAL = 0;
		
		int BS_04_POWER_MAX = BS_04_POWER_RESULT.size();
		
		if(BS_04_POWER_MAX == 0) {
			
			obj.addProperty("BS_04_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date BS_04_POWER_FIRST_TIME = BS_04_POWER_RESULT.get(0).BS_04_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String BS_04_POWER_FIRST_STRING = format1.format(BS_04_POWER_FIRST_TIME);
			
			obj.addProperty("BS_04_POWER_FIRST_TIME", BS_04_POWER_FIRST_STRING);
		}
		
		for(int i = 0; i < BS_04_POWER_RESULT.size(); i++) {
			
			Date ONTIME = BS_04_POWER_RESULT.get(i).BS_04_POWERON_TIME;
			Date OFFTIME = BS_04_POWER_RESULT.get(i).BS_04_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				BS_04_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				BS_04_POWER_TOTAL += min;
				
			}
		}
		
		int BS_04_POWER_HOURS = BS_04_POWER_TOTAL / 60;
		int BS_04_POWER_MIN = BS_04_POWER_TOTAL % 60; 
	
		obj.addProperty("BS_04_POWER_HOURS", BS_04_POWER_HOURS);
		obj.addProperty("BS_04_POWER_MIN", BS_04_POWER_MIN);
		
		List<sensorVO> BS_04_RUN_RESULT = service.BS_04_TIME_RUN_ON(vo);
		int BS_04_RUN_TOTAL = 0;
		
		for(int i = 0; i < BS_04_RUN_RESULT.size(); i++) {
			
			Date ONTIME = BS_04_RUN_RESULT.get(i).BS_04_RUNON_TIME;
			Date OFFTIME = BS_04_RUN_RESULT.get(i).BS_04_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				BS_04_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				BS_04_RUN_TOTAL += min;
				
			}
		}
		
		int BS_04_RUN_HOURS = BS_04_RUN_TOTAL / 60;
		int BS_04_RUN_MIN = BS_04_RUN_TOTAL % 60; 
	
		obj.addProperty("BS_04_RUN_HOURS", BS_04_RUN_HOURS);
		obj.addProperty("BS_04_RUN_MIN", BS_04_RUN_MIN);
		
		
		//PR_05
		List<sensorVO> PR_05_POWER_RESULT = service.PR_05_TIME_POWER_ON(vo);
		int PR_05_POWER_TOTAL = 0;
		
		int PR_05_POWER_MAX = PR_05_POWER_RESULT.size();
		
		if(PR_05_POWER_MAX == 0) {
			
			obj.addProperty("PR_05_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date PR_05_POWER_FIRST_TIME = PR_05_POWER_RESULT.get(0).PR_05_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String PR_05_POWER_FIRST_STRING = format1.format(PR_05_POWER_FIRST_TIME);
			
			obj.addProperty("PR_05_POWER_FIRST_TIME", PR_05_POWER_FIRST_STRING);
		}
		
		for(int i = 0; i < PR_05_POWER_RESULT.size(); i++) {
			
			Date ONTIME = PR_05_POWER_RESULT.get(i).PR_05_POWERON_TIME;
			Date OFFTIME = PR_05_POWER_RESULT.get(i).PR_05_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				PR_05_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				PR_05_POWER_TOTAL += min;
				
			}
		}
		
		int PR_05_POWER_HOURS = PR_05_POWER_TOTAL / 60;
		int PR_05_POWER_MIN = PR_05_POWER_TOTAL % 60; 
	
		obj.addProperty("PR_05_POWER_HOURS", PR_05_POWER_HOURS);
		obj.addProperty("PR_05_POWER_MIN", PR_05_POWER_MIN);
		
		List<sensorVO> PR_05_RUN_RESULT = service.PR_05_TIME_RUN_ON(vo);
		int PR_05_RUN_TOTAL = 0;
		
		for(int i = 0; i < PR_05_RUN_RESULT.size(); i++) {
			
			Date ONTIME = PR_05_RUN_RESULT.get(i).PR_05_RUNON_TIME;
			Date OFFTIME = PR_05_RUN_RESULT.get(i).PR_05_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				PR_05_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				PR_05_RUN_TOTAL += min;
				
			}
		}
		
		int PR_05_RUN_HOURS = PR_05_RUN_TOTAL / 60;
		int PR_05_RUN_MIN = PR_05_RUN_TOTAL % 60; 
	
		obj.addProperty("PR_05_RUN_HOURS", PR_05_RUN_HOURS);
		obj.addProperty("PR_05_RUN_MIN", PR_05_RUN_MIN);
		
		return obj.toString();
		
	}
	
	
	@RequestMapping(value = "/Select_INDEX2", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<sensorVO> Select_INDEX2(sensorVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		logger.info(time + "Select_INDEX2");
		
		return service.Select_INDEX2(vo);
	}
	
	
	@RequestMapping(value = "/INDEX3_ALL_TIME", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String INDEX3_ALL_TIME(sensorVO vo) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		Calendar c1 = Calendar.getInstance();
		
		//Calendar c2 = Calendar.getInstance();
		
		//c2.setTime(new Date());
		
		//c2.add(c2.DATE, -3);
		
		String strToday = sdf.format(c1.getTime());
		
		//String NotToday = sdf.format(c2.getTime());
		
		//vo.setDEL_DAY(NotToday);
		vo.setTODAY(strToday);
		
		
		Date time = new Date();
		
		/*
		//인덱스 3
		service.SP_LW_01_DELETE(vo);
		service.SP_PW_02_DELETE(vo);
		service.SP_PW_03_DELETE(vo);
		service.SP_TW_04_DELETE(vo);
		service.SP_PW_05_DELETE(vo);
		service.SP_PW_06_DELETE(vo);
		service.SP_PW_07_DELETE(vo);
		service.TC_03_DELETE(vo);
		*/
		
		JsonObject obj = new JsonObject();

		
		//SP_LW_01
		List<sensorVO> SP_LW_01_POWER_RESULT = service.SP_LW_01_TIME_POWER_ON(vo);
		int SP_LW_01_POWER_TOTAL = 0;
		
		
		int SP_LW_01_POWER_MAX = SP_LW_01_POWER_RESULT.size();
		
		if(SP_LW_01_POWER_MAX == 0) {
			
			obj.addProperty("SP_LW_01_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date SP_LW_01_POWER_FIRST_TIME = SP_LW_01_POWER_RESULT.get(0).SP_LW_01_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String SP_LW_01_POWER_FIRST_STRING = format1.format(SP_LW_01_POWER_FIRST_TIME);
			
			obj.addProperty("SP_LW_01_POWER_FIRST_TIME", SP_LW_01_POWER_FIRST_STRING);
		}
		
		
		for(int i = 0; i < SP_LW_01_POWER_RESULT.size(); i++) {
			
			Date ONTIME = SP_LW_01_POWER_RESULT.get(i).SP_LW_01_POWERON_TIME;
			Date OFFTIME = SP_LW_01_POWER_RESULT.get(i).SP_LW_01_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_LW_01_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_LW_01_POWER_TOTAL += min;
				
			}
		}
		
		int SP_LW_01_POWER_HOURS = SP_LW_01_POWER_TOTAL / 60;
		int SP_LW_01_POWER_MIN = SP_LW_01_POWER_TOTAL % 60; 
	
		obj.addProperty("SP_LW_01_POWER_HOURS", SP_LW_01_POWER_HOURS);
		obj.addProperty("SP_LW_01_POWER_MIN", SP_LW_01_POWER_MIN);
		
		List<sensorVO> SP_LW_01_RUN_RESULT = service.SP_LW_01_TIME_RUN_ON(vo);
		int SP_LW_01_RUN_TOTAL = 0;
		
		for(int i = 0; i < SP_LW_01_RUN_RESULT.size(); i++) {
			
			Date ONTIME = SP_LW_01_RUN_RESULT.get(i).SP_LW_01_RUNON_TIME;
			Date OFFTIME = SP_LW_01_RUN_RESULT.get(i).SP_LW_01_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_LW_01_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_LW_01_RUN_TOTAL += min;
				
			}
		}
		
		int SP_LW_01_RUN_HOURS = SP_LW_01_RUN_TOTAL / 60;
		int SP_LW_01_RUN_MIN = SP_LW_01_RUN_TOTAL % 60; 
	
		obj.addProperty("SP_LW_01_RUN_HOURS", SP_LW_01_RUN_HOURS);
		obj.addProperty("SP_LW_01_RUN_MIN", SP_LW_01_RUN_MIN);
		

		//SP_PW_02
		List<sensorVO> SP_PW_02_POWER_RESULT = service.SP_PW_02_TIME_POWER_ON(vo);
		int SP_PW_02_POWER_TOTAL = 0;
		
		int SP_PW_02_POWER_MAX = SP_PW_02_POWER_RESULT.size();
		
	
		if(SP_PW_02_POWER_MAX == 0) {
			
			obj.addProperty("SP_PW_02_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date SP_PW_02_POWER_FIRST_TIME = SP_PW_02_POWER_RESULT.get(0).SP_PW_02_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String SP_PW_02_POWER_FIRST_STRING = format1.format(SP_PW_02_POWER_FIRST_TIME);
			
			obj.addProperty("SP_PW_02_POWER_FIRST_TIME", SP_PW_02_POWER_FIRST_STRING);
		}
		
		
		for(int i = 0; i < SP_PW_02_POWER_RESULT.size(); i++) {
			
			Date ONTIME = SP_PW_02_POWER_RESULT.get(i).SP_PW_02_POWERON_TIME;
			Date OFFTIME = SP_PW_02_POWER_RESULT.get(i).SP_PW_02_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_PW_02_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_PW_02_POWER_TOTAL += min;
				
			}
		}
		
		int SP_PW_02_POWER_HOURS = SP_PW_02_POWER_TOTAL / 60;
		int SP_PW_02_POWER_MIN = SP_PW_02_POWER_TOTAL % 60; 
	
		obj.addProperty("SP_PW_02_POWER_HOURS", SP_PW_02_POWER_HOURS);
		obj.addProperty("SP_PW_02_POWER_MIN", SP_PW_02_POWER_MIN);
		
		List<sensorVO> SP_PW_02_RUN_RESULT = service.SP_PW_02_TIME_RUN_ON(vo);
		int SP_PW_02_RUN_TOTAL = 0;
		
		for(int i = 0; i < SP_PW_02_RUN_RESULT.size(); i++) {
			
			Date ONTIME = SP_PW_02_RUN_RESULT.get(i).SP_PW_02_RUNON_TIME;
			Date OFFTIME = SP_PW_02_RUN_RESULT.get(i).SP_PW_02_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_PW_02_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_PW_02_RUN_TOTAL += min;
				
			}
		}
		
		int SP_PW_02_RUN_HOURS = SP_PW_02_RUN_TOTAL / 60;
		int SP_PW_02_RUN_MIN = SP_PW_02_RUN_TOTAL % 60; 
	
		obj.addProperty("SP_PW_02_RUN_HOURS", SP_PW_02_RUN_HOURS);
		obj.addProperty("SP_PW_02_RUN_MIN", SP_PW_02_RUN_MIN);
		
		
		//SP_PW_03
		List<sensorVO> SP_PW_03_POWER_RESULT = service.SP_PW_03_TIME_POWER_ON(vo);
		int SP_PW_03_POWER_TOTAL = 0;
		
		
		int SP_PW_03_POWER_MAX = SP_PW_03_POWER_RESULT.size();
		
		if(SP_PW_03_POWER_MAX == 0) {
			
			obj.addProperty("SP_PW_03_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date SP_PW_03_POWER_FIRST_TIME = SP_PW_03_POWER_RESULT.get(0).SP_PW_03_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String SP_PW_03_POWER_FIRST_STRING = format1.format(SP_PW_03_POWER_FIRST_TIME);
			
			obj.addProperty("SP_PW_03_POWER_FIRST_TIME", SP_PW_03_POWER_FIRST_STRING);
		}
		
		for(int i = 0; i < SP_PW_03_POWER_RESULT.size(); i++) {
			
			Date ONTIME = SP_PW_03_POWER_RESULT.get(i).SP_PW_03_POWERON_TIME;
			Date OFFTIME = SP_PW_03_POWER_RESULT.get(i).SP_PW_03_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_PW_03_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_PW_03_POWER_TOTAL += min;
				
			}
		}
		
		int SP_PW_03_POWER_HOURS = SP_PW_03_POWER_TOTAL / 60;
		int SP_PW_03_POWER_MIN = SP_PW_03_POWER_TOTAL % 60; 
	
		obj.addProperty("SP_PW_03_POWER_HOURS", SP_PW_03_POWER_HOURS);
		obj.addProperty("SP_PW_03_POWER_MIN", SP_PW_03_POWER_MIN);
		
		List<sensorVO> SP_PW_03_RUN_RESULT = service.SP_PW_03_TIME_RUN_ON(vo);
		int SP_PW_03_RUN_TOTAL = 0;
		
		for(int i = 0; i < SP_PW_03_RUN_RESULT.size(); i++) {
			
			Date ONTIME = SP_PW_03_RUN_RESULT.get(i).SP_PW_03_RUNON_TIME;
			Date OFFTIME = SP_PW_03_RUN_RESULT.get(i).SP_PW_03_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_PW_03_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_PW_03_RUN_TOTAL += min;
				
			}
		}
		
		int SP_PW_03_RUN_HOURS = SP_PW_03_RUN_TOTAL / 60;
		int SP_PW_03_RUN_MIN = SP_PW_03_RUN_TOTAL % 60; 
	
		obj.addProperty("SP_PW_03_RUN_HOURS", SP_PW_03_RUN_HOURS);
		obj.addProperty("SP_PW_03_RUN_MIN", SP_PW_03_RUN_MIN);
		
		
		//SP_TW_04
		List<sensorVO> SP_TW_04_POWER_RESULT = service.SP_TW_04_TIME_POWER_ON(vo);
		int SP_TW_04_POWER_TOTAL = 0;
		
		int SP_TW_04_POWER_MAX = SP_TW_04_POWER_RESULT.size();
		
		if(SP_TW_04_POWER_MAX == 0) {
			
			obj.addProperty("SP_TW_04_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date SP_TW_04_POWER_FIRST_TIME = SP_TW_04_POWER_RESULT.get(0).SP_TW_04_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String SP_TW_04_POWER_FIRST_STRING = format1.format(SP_TW_04_POWER_FIRST_TIME);
			
			obj.addProperty("SP_TW_04_POWER_FIRST_TIME", SP_TW_04_POWER_FIRST_STRING);
		}
		
		for(int i = 0; i < SP_TW_04_POWER_RESULT.size(); i++) {
			
			Date ONTIME = SP_TW_04_POWER_RESULT.get(i).SP_TW_04_POWERON_TIME;
			Date OFFTIME = SP_TW_04_POWER_RESULT.get(i).SP_TW_04_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_PW_03_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_TW_04_POWER_TOTAL += min;
				
			}
		}
		
		int SP_TW_04_POWER_HOURS = SP_TW_04_POWER_TOTAL / 60;
		int SP_TW_04_POWER_MIN = SP_TW_04_POWER_TOTAL % 60; 
	
		obj.addProperty("SP_TW_04_POWER_HOURS", SP_TW_04_POWER_HOURS);
		obj.addProperty("SP_TW_04_POWER_MIN", SP_TW_04_POWER_MIN);
		
		List<sensorVO> SP_TW_04_RUN_RESULT = service.SP_TW_04_TIME_RUN_ON(vo);
		int SP_TW_04_RUN_TOTAL = 0;
		
		for(int i = 0; i < SP_TW_04_RUN_RESULT.size(); i++) {
			
			Date ONTIME = SP_TW_04_RUN_RESULT.get(i).SP_TW_04_RUNON_TIME;
			Date OFFTIME = SP_TW_04_RUN_RESULT.get(i).SP_TW_04_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_TW_04_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_TW_04_RUN_TOTAL += min;
				
			}
		}
		
		int SP_TW_04_RUN_HOURS = SP_TW_04_RUN_TOTAL / 60;
		int SP_TW_04_RUN_MIN = SP_TW_04_RUN_TOTAL % 60; 
	
		obj.addProperty("SP_TW_04_RUN_HOURS", SP_TW_04_RUN_HOURS);
		obj.addProperty("SP_TW_04_RUN_MIN", SP_TW_04_RUN_MIN);
		
		
		//SP_PW_05
		List<sensorVO> SP_PW_05_POWER_RESULT = service.SP_PW_05_TIME_POWER_ON(vo);
		int SP_PW_05_POWER_TOTAL = 0;
		
		int SP_PW_05_POWER_MAX = SP_PW_05_POWER_RESULT.size();
		
		if(SP_PW_05_POWER_MAX == 0) {
			
			obj.addProperty("SP_PW_05_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date SP_PW_05_POWER_FIRST_TIME = SP_PW_05_POWER_RESULT.get(0).SP_PW_05_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String SP_PW_05_POWER_FIRST_STRING = format1.format(SP_PW_05_POWER_FIRST_TIME);
			
			obj.addProperty("SP_PW_05_POWER_FIRST_TIME", SP_PW_05_POWER_FIRST_STRING);
		}
		
		for(int i = 0; i < SP_PW_05_POWER_RESULT.size(); i++) {
			
			Date ONTIME = SP_PW_05_POWER_RESULT.get(i).SP_PW_05_POWERON_TIME;
			Date OFFTIME = SP_PW_05_POWER_RESULT.get(i).SP_PW_05_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_PW_05_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_PW_05_POWER_TOTAL += min;
				
			}
		}
		
		int SP_PW_05_POWER_HOURS = SP_PW_05_POWER_TOTAL / 60;
		int SP_PW_05_POWER_MIN = SP_PW_05_POWER_TOTAL % 60; 
	
		obj.addProperty("SP_PW_05_POWER_HOURS", SP_PW_05_POWER_HOURS);
		obj.addProperty("SP_PW_05_POWER_MIN", SP_PW_05_POWER_MIN);
		
		List<sensorVO> SP_PW_05_RUN_RESULT = service.SP_PW_05_TIME_RUN_ON(vo);
		int SP_PW_05_RUN_TOTAL = 0;
		
		for(int i = 0; i < SP_PW_05_RUN_RESULT.size(); i++) {
			
			Date ONTIME = SP_PW_05_RUN_RESULT.get(i).SP_PW_05_RUNON_TIME;
			Date OFFTIME = SP_PW_05_RUN_RESULT.get(i).SP_PW_05_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_PW_05_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_PW_05_RUN_TOTAL += min;
				
			}
		}
		
		int SP_PW_05_RUN_HOURS = SP_PW_05_RUN_TOTAL / 60;
		int SP_PW_05_RUN_MIN = SP_PW_05_RUN_TOTAL % 60; 
	
		obj.addProperty("SP_PW_05_RUN_HOURS", SP_PW_05_RUN_HOURS);
		obj.addProperty("SP_PW_05_RUN_MIN", SP_PW_05_RUN_MIN);
		
		//SP_PW_06
		List<sensorVO> SP_PW_06_POWER_RESULT = service.SP_PW_06_TIME_POWER_ON(vo);
		int SP_PW_06_POWER_TOTAL = 0;
		
		int SP_PW_06_POWER_MAX = SP_PW_06_POWER_RESULT.size();
		
		if(SP_PW_06_POWER_MAX == 0) {
			
			obj.addProperty("SP_PW_06_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date SP_PW_06_POWER_FIRST_TIME = SP_PW_06_POWER_RESULT.get(0).SP_PW_06_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String SP_PW_06_POWER_FIRST_STRING = format1.format(SP_PW_06_POWER_FIRST_TIME);
			
			obj.addProperty("SP_PW_06_POWER_FIRST_TIME", SP_PW_06_POWER_FIRST_STRING);
		}
		
		for(int i = 0; i < SP_PW_06_POWER_RESULT.size(); i++) {
			
			Date ONTIME = SP_PW_06_POWER_RESULT.get(i).SP_PW_06_POWERON_TIME;
			Date OFFTIME = SP_PW_06_POWER_RESULT.get(i).SP_PW_06_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_PW_06_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_PW_06_POWER_TOTAL += min;
				
			}
		}
		
		int SP_PW_06_POWER_HOURS = SP_PW_06_POWER_TOTAL / 60;
		int SP_PW_06_POWER_MIN = SP_PW_06_POWER_TOTAL % 60; 
	
		obj.addProperty("SP_PW_06_POWER_HOURS", SP_PW_06_POWER_HOURS);
		obj.addProperty("SP_PW_06_POWER_MIN", SP_PW_06_POWER_MIN);
		
		List<sensorVO> SP_PW_06_RUN_RESULT = service.SP_PW_06_TIME_RUN_ON(vo);
		int SP_PW_06_RUN_TOTAL = 0;
		
		for(int i = 0; i < SP_PW_06_RUN_RESULT.size(); i++) {
			
			Date ONTIME = SP_PW_06_RUN_RESULT.get(i).SP_PW_06_RUNON_TIME;
			Date OFFTIME = SP_PW_06_RUN_RESULT.get(i).SP_PW_06_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_PW_06_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_PW_06_RUN_TOTAL += min;
				
			}
		}
		
		int SP_PW_06_RUN_HOURS = SP_PW_06_RUN_TOTAL / 60;
		int SP_PW_06_RUN_MIN = SP_PW_06_RUN_TOTAL % 60; 
	
		obj.addProperty("SP_PW_06_RUN_HOURS", SP_PW_06_RUN_HOURS);
		obj.addProperty("SP_PW_06_RUN_MIN", SP_PW_06_RUN_MIN);
		
		//SP_PW_07
		List<sensorVO> SP_PW_07_POWER_RESULT = service.SP_PW_07_TIME_POWER_ON(vo);
		int SP_PW_07_POWER_TOTAL = 0;
		
		int SP_PW_07_POWER_MAX = SP_PW_07_POWER_RESULT.size();
		
		if(SP_PW_07_POWER_MAX == 0) {
			
			obj.addProperty("SP_PW_07_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date SP_PW_07_POWER_FIRST_TIME = SP_PW_07_POWER_RESULT.get(0).SP_PW_07_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String SP_PW_07_POWER_FIRST_STRING = format1.format(SP_PW_07_POWER_FIRST_TIME);
			
			obj.addProperty("SP_PW_07_POWER_FIRST_TIME", SP_PW_07_POWER_FIRST_STRING);
		}
		
		for(int i = 0; i < SP_PW_07_POWER_RESULT.size(); i++) {
			
			Date ONTIME = SP_PW_07_POWER_RESULT.get(i).SP_PW_07_POWERON_TIME;
			Date OFFTIME = SP_PW_07_POWER_RESULT.get(i).SP_PW_07_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_PW_07_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_PW_07_POWER_TOTAL += min;
				
			}
		}
		
		int SP_PW_07_POWER_HOURS = SP_PW_07_POWER_TOTAL / 60;
		int SP_PW_07_POWER_MIN = SP_PW_07_POWER_TOTAL % 60; 
	
		obj.addProperty("SP_PW_07_POWER_HOURS", SP_PW_07_POWER_HOURS);
		obj.addProperty("SP_PW_07_POWER_MIN", SP_PW_07_POWER_MIN);
		
		List<sensorVO> SP_PW_07_RUN_RESULT = service.SP_PW_07_TIME_RUN_ON(vo);
		int SP_PW_07_RUN_TOTAL = 0;
		
		for(int i = 0; i < SP_PW_07_RUN_RESULT.size(); i++) {
			
			Date ONTIME = SP_PW_07_RUN_RESULT.get(i).SP_PW_07_RUNON_TIME;
			Date OFFTIME = SP_PW_07_RUN_RESULT.get(i).SP_PW_07_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_PW_07_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_PW_07_RUN_TOTAL += min;
				
			}
		}
		
		int SP_PW_07_RUN_HOURS = SP_PW_07_RUN_TOTAL / 60;
		int SP_PW_07_RUN_MIN = SP_PW_07_RUN_TOTAL % 60; 
	
		obj.addProperty("SP_PW_07_RUN_HOURS", SP_PW_07_RUN_HOURS);
		obj.addProperty("SP_PW_07_RUN_MIN", SP_PW_07_RUN_MIN);
		
		return obj.toString();
	}
	
	@RequestMapping(value = "/Select_INDEX3", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<sensorVO> Select_INDEX3(sensorVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		logger.info(time + "Select_INDEX3");
		
		return service.Select_INDEX3(vo);
	}
	
	@RequestMapping(value = "/INDEX4_ALL_TIME", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String INDEX4_ALL_TIME(sensorVO vo) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		Calendar c1 = Calendar.getInstance();
		
		//Calendar c2 = Calendar.getInstance();
		
		//c2.setTime(new Date());
		
		//c2.add(c2.DATE, -3);
		
		String strToday = sdf.format(c1.getTime());
		
		//String NotToday = sdf.format(c2.getTime());
		
		//vo.setDEL_DAY(NotToday);
		vo.setTODAY(strToday);
		
		Date time = new Date();
		
		/*
		//인덱스 4
		service.SP_WI_02_DELETE(vo);
		service.SP_WI_04_DELETE(vo);
		service.SP_WI_01_DELETE(vo);
		service.SP_WI_06_DELETE(vo);
		service.SP_WO_01_DELETE(vo);
		service.SP_WO_05_DELETE(vo);
		service.SP_WO_04_DELETE(vo);
		service.SP_WO_06_DELETE(vo);
		service.SP_WI_07_DELETE(vo);
		service.SP_WI_08_DELETE(vo);
		service.SP_WO_03_DELETE(vo);
		service.SP_WI_03_DELETE(vo);
		service.TC_04_DELETE(vo);
		*/


		JsonObject obj = new JsonObject();
		
		//SP_WI_02
		List<sensorVO> SP_WI_02_POWER_RESULT = service.SP_WI_02_TIME_POWER_ON(vo);
		int SP_WI_02_POWER_TOTAL = 0;
		
		int SP_WI_02_POWER_MAX = SP_WI_02_POWER_RESULT.size();
		
		if(SP_WI_02_POWER_MAX == 0) {
			
			obj.addProperty("SP_WI_02_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date SP_WI_02_POWER_FIRST_TIME = SP_WI_02_POWER_RESULT.get(0).SP_WI_02_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String SP_WI_02_POWER_FIRST_STRING = format1.format(SP_WI_02_POWER_FIRST_TIME);
			
			obj.addProperty("SP_WI_02_POWER_FIRST_TIME", SP_WI_02_POWER_FIRST_STRING);
		}
		
		for(int i = 0; i < SP_WI_02_POWER_RESULT.size(); i++) {
			
			Date ONTIME = SP_WI_02_POWER_RESULT.get(i).SP_WI_02_POWERON_TIME;
			Date OFFTIME = SP_WI_02_POWER_RESULT.get(i).SP_WI_02_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WI_02_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WI_02_POWER_TOTAL += min;
				
			}
		}
		
		int SP_WI_02_POWER_HOURS = SP_WI_02_POWER_TOTAL / 60;
		int SP_WI_02_POWER_MIN = SP_WI_02_POWER_TOTAL % 60; 
	
		obj.addProperty("SP_WI_02_POWER_HOURS", SP_WI_02_POWER_HOURS);
		obj.addProperty("SP_WI_02_POWER_MIN", SP_WI_02_POWER_MIN);
		
		List<sensorVO> SP_WI_02_RUN_RESULT = service.SP_WI_02_TIME_RUN_ON(vo);
		int SP_WI_02_RUN_TOTAL = 0;
		
		for(int i = 0; i < SP_WI_02_RUN_RESULT.size(); i++) {
			
			Date ONTIME = SP_WI_02_RUN_RESULT.get(i).SP_WI_02_RUNON_TIME;
			Date OFFTIME = SP_WI_02_RUN_RESULT.get(i).SP_WI_02_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WI_02_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WI_02_RUN_TOTAL += min;
				
			}
		}
		
		int SP_WI_02_RUN_HOURS = SP_WI_02_RUN_TOTAL / 60;
		int SP_WI_02_RUN_MIN = SP_WI_02_RUN_TOTAL % 60; 
	
		obj.addProperty("SP_WI_02_RUN_HOURS", SP_WI_02_RUN_HOURS);
		obj.addProperty("SP_WI_02_RUN_MIN", SP_WI_02_RUN_MIN);
		

		//SP_WI_04
		List<sensorVO> SP_WI_04_POWER_RESULT = service.SP_WI_04_TIME_POWER_ON(vo);
		int SP_WI_04_POWER_TOTAL = 0;
		
		int SP_WI_04_POWER_MAX = SP_WI_04_POWER_RESULT.size();
		
		if(SP_WI_04_POWER_MAX == 0) {
			
			obj.addProperty("SP_WI_04_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date SP_WI_04_POWER_FIRST_TIME = SP_WI_04_POWER_RESULT.get(0).SP_WI_04_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String SP_WI_04_POWER_FIRST_STRING = format1.format(SP_WI_04_POWER_FIRST_TIME);
			
			obj.addProperty("SP_WI_04_POWER_FIRST_TIME", SP_WI_04_POWER_FIRST_STRING);
		}
		
		for(int i = 0; i < SP_WI_04_POWER_RESULT.size(); i++) {
			
			Date ONTIME = SP_WI_04_POWER_RESULT.get(i).SP_WI_04_POWERON_TIME;
			Date OFFTIME = SP_WI_04_POWER_RESULT.get(i).SP_WI_04_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WI_04_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WI_04_POWER_TOTAL += min;
				
			}
		}
		
		int SP_WI_04_POWER_HOURS = SP_WI_04_POWER_TOTAL / 60;
		int SP_WI_04_POWER_MIN = SP_WI_04_POWER_TOTAL % 60; 
	
		obj.addProperty("SP_WI_04_POWER_HOURS", SP_WI_04_POWER_HOURS);
		obj.addProperty("SP_WI_04_POWER_MIN", SP_WI_04_POWER_MIN);
		
		List<sensorVO> SP_WI_04_RUN_RESULT = service.SP_WI_04_TIME_RUN_ON(vo);
		int SP_WI_04_RUN_TOTAL = 0;
		
		for(int i = 0; i < SP_WI_04_RUN_RESULT.size(); i++) {
			
			Date ONTIME = SP_WI_04_RUN_RESULT.get(i).SP_WI_04_RUNON_TIME;
			Date OFFTIME = SP_WI_04_RUN_RESULT.get(i).SP_WI_04_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WI_04_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WI_04_RUN_TOTAL += min;
				
			}
		}
		
		int SP_WI_04_RUN_HOURS = SP_WI_04_RUN_TOTAL / 60;
		int SP_WI_04_RUN_MIN = SP_WI_04_RUN_TOTAL % 60; 
	
		obj.addProperty("SP_WI_04_RUN_HOURS", SP_WI_04_RUN_HOURS);
		obj.addProperty("SP_WI_04_RUN_MIN", SP_WI_04_RUN_MIN);
		
		//SP_WI_01
		List<sensorVO> SP_WI_01_POWER_RESULT = service.SP_WI_01_TIME_POWER_ON(vo);
		int SP_WI_01_POWER_TOTAL = 0;
		
		int SP_WI_01_POWER_MAX = SP_WI_01_POWER_RESULT.size();
		
		if(SP_WI_01_POWER_MAX == 0) {
			
			obj.addProperty("SP_WI_01_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date SP_WI_01_POWER_FIRST_TIME = SP_WI_01_POWER_RESULT.get(0).SP_WI_01_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String SP_WI_01_POWER_FIRST_STRING = format1.format(SP_WI_01_POWER_FIRST_TIME);
			
			obj.addProperty("SP_WI_01_POWER_FIRST_TIME", SP_WI_01_POWER_FIRST_STRING);
		}
		
		for(int i = 0; i < SP_WI_01_POWER_RESULT.size(); i++) {
			
			Date ONTIME = SP_WI_01_POWER_RESULT.get(i).SP_WI_01_POWERON_TIME;
			Date OFFTIME = SP_WI_01_POWER_RESULT.get(i).SP_WI_01_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WI_01_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WI_01_POWER_TOTAL += min;
				
			}
		}
		
		int SP_WI_01_POWER_HOURS = SP_WI_01_POWER_TOTAL / 60;
		int SP_WI_01_POWER_MIN = SP_WI_01_POWER_TOTAL % 60; 
	
		obj.addProperty("SP_WI_01_POWER_HOURS", SP_WI_01_POWER_HOURS);
		obj.addProperty("SP_WI_01_POWER_MIN", SP_WI_01_POWER_MIN);
		
		List<sensorVO> SP_WI_01_RUN_RESULT = service.SP_WI_01_TIME_RUN_ON(vo);
		int SP_WI_01_RUN_TOTAL = 0;
		
		for(int i = 0; i < SP_WI_01_RUN_RESULT.size(); i++) {
			
			Date ONTIME = SP_WI_01_RUN_RESULT.get(i).SP_WI_01_RUNON_TIME;
			Date OFFTIME = SP_WI_01_RUN_RESULT.get(i).SP_WI_01_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WI_01_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WI_01_RUN_TOTAL += min;
				
			}
		}
		
		int SP_WI_01_RUN_HOURS = SP_WI_01_RUN_TOTAL / 60;
		int SP_WI_01_RUN_MIN = SP_WI_01_RUN_TOTAL % 60; 
	
		obj.addProperty("SP_WI_01_RUN_HOURS", SP_WI_01_RUN_HOURS);
		obj.addProperty("SP_WI_01_RUN_MIN", SP_WI_01_RUN_MIN);
		
		//SP_WI_06
		List<sensorVO> SP_WI_06_POWER_RESULT = service.SP_WI_06_TIME_POWER_ON(vo);
		int SP_WI_06_POWER_TOTAL = 0;
		
		int SP_WI_06_POWER_MAX = SP_WI_06_POWER_RESULT.size();
		
		if(SP_WI_06_POWER_MAX == 0) {
			
			obj.addProperty("SP_WI_06_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date SP_WI_06_POWER_FIRST_TIME = SP_WI_06_POWER_RESULT.get(0).SP_WI_06_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String SP_WI_06_POWER_FIRST_STRING = format1.format(SP_WI_06_POWER_FIRST_TIME);
			
			obj.addProperty("SP_WI_06_POWER_FIRST_TIME", SP_WI_06_POWER_FIRST_STRING);
		}
		
		for(int i = 0; i < SP_WI_06_POWER_RESULT.size(); i++) {
			
			Date ONTIME = SP_WI_06_POWER_RESULT.get(i).SP_WI_06_POWERON_TIME;
			Date OFFTIME = SP_WI_06_POWER_RESULT.get(i).SP_WI_06_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WI_06_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WI_06_POWER_TOTAL += min;
				
			}
		}
		
		int SP_WI_06_POWER_HOURS = SP_WI_06_POWER_TOTAL / 60;
		int SP_WI_06_POWER_MIN = SP_WI_06_POWER_TOTAL % 60; 
	
		obj.addProperty("SP_WI_06_POWER_HOURS", SP_WI_06_POWER_HOURS);
		obj.addProperty("SP_WI_06_POWER_MIN", SP_WI_06_POWER_MIN);
		
		List<sensorVO> SP_WI_06_RUN_RESULT = service.SP_WI_06_TIME_RUN_ON(vo);
		int SP_WI_06_RUN_TOTAL = 0;
		
		for(int i = 0; i < SP_WI_06_RUN_RESULT.size(); i++) {
			
			Date ONTIME = SP_WI_06_RUN_RESULT.get(i).SP_WI_06_RUNON_TIME;
			Date OFFTIME = SP_WI_06_RUN_RESULT.get(i).SP_WI_06_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WI_06_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WI_06_RUN_TOTAL += min;
				
			}
		}
		
		int SP_WI_06_RUN_HOURS = SP_WI_06_RUN_TOTAL / 60;
		int SP_WI_06_RUN_MIN = SP_WI_06_RUN_TOTAL % 60; 
	
		obj.addProperty("SP_WI_06_RUN_HOURS", SP_WI_06_RUN_HOURS);
		obj.addProperty("SP_WI_06_RUN_MIN", SP_WI_06_RUN_MIN);
		
		//SP_WO_01
		List<sensorVO> SP_WO_01_POWER_RESULT = service.SP_WO_01_TIME_POWER_ON(vo);
		int SP_WO_01__POWER_TOTAL = 0;
		
		int SP_WO_01_POWER_MAX = SP_WO_01_POWER_RESULT.size();
		
		if(SP_WO_01_POWER_MAX == 0) {
			
			obj.addProperty("SP_WO_01_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date SP_WO_01_POWER_FIRST_TIME = SP_WO_01_POWER_RESULT.get(0).SP_WO_01_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String SP_WO_01_POWER_FIRST_STRING = format1.format(SP_WO_01_POWER_FIRST_TIME);
			
			obj.addProperty("SP_WO_01_POWER_FIRST_TIME", SP_WO_01_POWER_FIRST_STRING);
		}
		
		for(int i = 0; i < SP_WO_01_POWER_RESULT.size(); i++) {
			
			Date ONTIME = SP_WO_01_POWER_RESULT.get(i).SP_WO_01_POWERON_TIME;
			Date OFFTIME = SP_WO_01_POWER_RESULT.get(i).SP_WO_01_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WO_01__POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WO_01__POWER_TOTAL += min;
				
			}
		}
		
		int SP_WO_01_POWER_HOURS = SP_WO_01__POWER_TOTAL / 60;
		int SP_WO_01_POWER_MIN = SP_WO_01__POWER_TOTAL % 60; 
	
		obj.addProperty("SP_WO_01_POWER_HOURS", SP_WO_01_POWER_HOURS);
		obj.addProperty("SP_WO_01_POWER_MIN", SP_WO_01_POWER_MIN);
		
		List<sensorVO> SP_WO_01_RUN_RESULT = service.SP_WO_01_TIME_RUN_ON(vo);
		int SP_WO_01_RUN_TOTAL = 0;
		
		for(int i = 0; i < SP_WO_01_RUN_RESULT.size(); i++) {
			
			Date ONTIME = SP_WO_01_RUN_RESULT.get(i).SP_WO_01_RUNON_TIME;
			Date OFFTIME = SP_WO_01_RUN_RESULT.get(i).SP_WO_01_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WO_01_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WO_01_RUN_TOTAL += min;
				
			}
		}
		
		int SP_WO_01_RUN_HOURS = SP_WO_01_RUN_TOTAL / 60;
		int SP_WO_01_RUN_MIN = SP_WO_01_RUN_TOTAL % 60; 
	
		obj.addProperty("SP_WO_01_RUN_HOURS", SP_WO_01_RUN_HOURS);
		obj.addProperty("SP_WO_01_RUN_MIN", SP_WO_01_RUN_MIN);
		
		//SP_WO_05
		List<sensorVO> SP_WO_05_POWER_RESULT = service.SP_WO_05_TIME_POWER_ON(vo);
		int SP_WO_05_POWER_TOTAL = 0;
		
		int SP_WO_05_POWER_MAX = SP_WO_05_POWER_RESULT.size();
		
		if(SP_WO_05_POWER_MAX == 0) {
			
			obj.addProperty("SP_WO_05_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date SP_WO_05_POWER_FIRST_TIME = SP_WO_05_POWER_RESULT.get(0).SP_WO_05_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String SP_WO_05_POWER_FIRST_STRING = format1.format(SP_WO_05_POWER_FIRST_TIME);
			
			obj.addProperty("SP_WO_05_POWER_FIRST_TIME", SP_WO_05_POWER_FIRST_STRING);
		}
		
		for(int i = 0; i < SP_WO_05_POWER_RESULT.size(); i++) {
			
			Date ONTIME = SP_WO_05_POWER_RESULT.get(i).SP_WO_05_POWERON_TIME;
			Date OFFTIME = SP_WO_05_POWER_RESULT.get(i).SP_WO_05_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WO_05_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WO_05_POWER_TOTAL += min;
				
			}
		}
		
		int SP_WO_05_POWER_HOURS = SP_WO_05_POWER_TOTAL / 60;
		int SP_WO_05_POWER_MIN = SP_WO_05_POWER_TOTAL % 60; 
	
		obj.addProperty("SP_WO_05_POWER_HOURS", SP_WO_05_POWER_HOURS);
		obj.addProperty("SP_WO_05_POWER_MIN", SP_WO_05_POWER_MIN);
		
		List<sensorVO> SP_WO_05_RUN_RESULT = service.SP_WO_05_TIME_RUN_ON(vo);
		int SP_WO_05_RUN_TOTAL = 0;
		
		for(int i = 0; i < SP_WO_05_RUN_RESULT.size(); i++) {
			
			Date ONTIME = SP_WO_05_RUN_RESULT.get(i).SP_WO_05_RUNON_TIME;
			Date OFFTIME = SP_WO_05_RUN_RESULT.get(i).SP_WO_05_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WO_05_RUN_TOTAL += min;
				
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WO_05_RUN_TOTAL += min;
				
			}
		}
		
		int SP_WO_05_RUN_HOURS = SP_WO_05_RUN_TOTAL / 60;
		int SP_WO_05_RUN_MIN = SP_WO_05_RUN_TOTAL % 60; 
	
		obj.addProperty("SP_WO_05_RUN_HOURS", SP_WO_05_RUN_HOURS);
		obj.addProperty("SP_WO_05_RUN_MIN", SP_WO_05_RUN_MIN);
	
		
		//SP_WO_04
		List<sensorVO> SP_WO_04_POWER_RESULT = service.SP_WO_04_TIME_POWER_ON(vo);
		int SP_WO_04_POWER_TOTAL = 0;
		
		int SP_WO_04_POWER_MAX = SP_WO_04_POWER_RESULT.size();
		
		if(SP_WO_04_POWER_MAX == 0) {
			
			obj.addProperty("SP_WO_04_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date SP_WO_04_POWER_FIRST_TIME = SP_WO_04_POWER_RESULT.get(0).SP_WO_04_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String SP_WO_04_POWER_FIRST_STRING = format1.format(SP_WO_04_POWER_FIRST_TIME);
			
			obj.addProperty("SP_WO_04_POWER_FIRST_TIME", SP_WO_04_POWER_FIRST_STRING);
		}
		
		for(int i = 0; i < SP_WO_04_POWER_RESULT.size(); i++) {
			
			Date ONTIME = SP_WO_04_POWER_RESULT.get(i).SP_WO_04_POWERON_TIME;
			Date OFFTIME = SP_WO_04_POWER_RESULT.get(i).SP_WO_04_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WO_04_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WO_04_POWER_TOTAL += min;
				
			}
		}
		
		int SP_WO_04_POWER_HOURS = SP_WO_04_POWER_TOTAL / 60;
		int SP_WO_04_POWER_MIN = SP_WO_04_POWER_TOTAL % 60; 
	
		obj.addProperty("SP_WO_04_POWER_HOURS", SP_WO_04_POWER_HOURS);
		obj.addProperty("SP_WO_04_POWER_MIN", SP_WO_04_POWER_MIN);
		
		List<sensorVO> SP_WO_04_RUN_RESULT = service.SP_WO_04_TIME_RUN_ON(vo);
		int SP_WO_04_RUN_TOTAL = 0;
		
		for(int i = 0; i < SP_WO_04_RUN_RESULT.size(); i++) {
			
			Date ONTIME = SP_WO_04_RUN_RESULT.get(i).SP_WO_04_RUNON_TIME;
			Date OFFTIME = SP_WO_04_RUN_RESULT.get(i).SP_WO_04_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WO_04_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WO_04_RUN_TOTAL += min;
				
			}
		}
		
		int SP_WO_04_RUN_HOURS = SP_WO_04_RUN_TOTAL / 60;
		int SP_WO_04_RUN_MIN = SP_WO_04_RUN_TOTAL % 60; 
	
		obj.addProperty("SP_WO_04_RUN_HOURS", SP_WO_04_RUN_HOURS);
		obj.addProperty("SP_WO_04_RUN_MIN", SP_WO_04_RUN_MIN);
		
		//SP_WO_06
		List<sensorVO> SP_WO_06_POWER_RESULT = service.SP_WO_06_TIME_POWER_ON(vo);
		int SP_WO_06_POWER_TOTAL = 0;
		
		int SP_WO_06_POWER_MAX = SP_WO_06_POWER_RESULT.size();
		
		if(SP_WO_06_POWER_MAX == 0) {
			
			obj.addProperty("SP_WO_06_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date SP_WO_06_POWER_FIRST_TIME = SP_WO_06_POWER_RESULT.get(0).SP_WO_06_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String SP_WO_06_POWER_FIRST_STRING = format1.format(SP_WO_06_POWER_FIRST_TIME);
			
			obj.addProperty("SP_WO_06_POWER_FIRST_TIME", SP_WO_06_POWER_FIRST_STRING);
		}
		
		for(int i = 0; i < SP_WO_06_POWER_RESULT.size(); i++) {
			
			Date ONTIME = SP_WO_06_POWER_RESULT.get(i).SP_WO_06_POWERON_TIME;
			Date OFFTIME = SP_WO_06_POWER_RESULT.get(i).SP_WO_06_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WO_06_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WO_06_POWER_TOTAL += min;
				
			}
		}
		
		int SP_WO_06_POWER_HOURS = SP_WO_06_POWER_TOTAL / 60;
		int SP_WO_06_POWER_MIN = SP_WO_06_POWER_TOTAL % 60; 
	
		obj.addProperty("SP_WO_06_POWER_HOURS", SP_WO_06_POWER_HOURS);
		obj.addProperty("SP_WO_06_POWER_MIN", SP_WO_06_POWER_MIN);
		
		List<sensorVO> SP_WO_06_RUN_RESULT = service.SP_WO_06_TIME_RUN_ON(vo);
		int SP_WO_06_RUN_TOTAL = 0;
		
		for(int i = 0; i < SP_WO_06_RUN_RESULT.size(); i++) {
			
			Date ONTIME = SP_WO_06_RUN_RESULT.get(i).SP_WO_06_RUNON_TIME;
			Date OFFTIME = SP_WO_06_RUN_RESULT.get(i).SP_WO_06_RUNOFF_TIME;
			
			if(OFFTIME == null) {

				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WO_06_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WO_06_RUN_TOTAL += min;
				
			}
		}
		
		int SP_WO_06_RUN_HOURS = SP_WO_06_RUN_TOTAL / 60;
		int SP_WO_06_RUN_MIN = SP_WO_06_RUN_TOTAL % 60; 
	
		obj.addProperty("SP_WO_06_RUN_HOURS", SP_WO_06_RUN_HOURS);
		obj.addProperty("SP_WO_06_RUN_MIN", SP_WO_06_RUN_MIN);
		
		//SP_WI_07
		List<sensorVO> SP_WI_07_POWER_RESULT = service.SP_WI_07_TIME_POWER_ON(vo);
		int SP_WI_07_POWER_TOTAL = 0;
		
		int SP_WI_07_POWER_MAX = SP_WI_07_POWER_RESULT.size();
		
		if(SP_WI_07_POWER_MAX == 0) {
			
			obj.addProperty("SP_WI_07_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date SP_WI_07_POWER_FIRST_TIME = SP_WI_07_POWER_RESULT.get(0).SP_WI_07_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String SP_WI_07_POWER_FIRST_STRING = format1.format(SP_WI_07_POWER_FIRST_TIME);
			
			obj.addProperty("SP_WI_07_POWER_FIRST_TIME", SP_WI_07_POWER_FIRST_STRING);
		}
		
		for(int i = 0; i < SP_WI_07_POWER_RESULT.size(); i++) {
			
			Date ONTIME = SP_WI_07_POWER_RESULT.get(i).SP_WI_07_POWERON_TIME;
			Date OFFTIME = SP_WI_07_POWER_RESULT.get(i).SP_WI_07_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WI_07_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WI_07_POWER_TOTAL += min;
				
			}
		}
		
		int SP_WI_07_POWER_HOURS = SP_WI_07_POWER_TOTAL / 60;
		int SP_WI_07_POWER_MIN = SP_WI_07_POWER_TOTAL % 60; 
	
		obj.addProperty("SP_WI_07_POWER_HOURS", SP_WI_07_POWER_HOURS);
		obj.addProperty("SP_WI_07_POWER_MIN", SP_WI_07_POWER_MIN);
		
		List<sensorVO> SP_WI_07_RUN_RESULT = service.SP_WI_07_TIME_RUN_ON(vo);
		int SP_WI_07_RUN_TOTAL = 0;
		
		for(int i = 0; i < SP_WI_07_RUN_RESULT.size(); i++) {
			
			Date ONTIME = SP_WI_07_RUN_RESULT.get(i).SP_WI_07_RUNON_TIME;
			Date OFFTIME = SP_WI_07_RUN_RESULT.get(i).SP_WI_07_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WI_07_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WI_07_RUN_TOTAL += min;
				
			}
		}
		
		int SP_WI_07_RUN_HOURS = SP_WI_07_RUN_TOTAL / 60;
		int SP_WI_07_RUN_MIN = SP_WI_07_RUN_TOTAL % 60; 
	
		obj.addProperty("SP_WI_07_RUN_HOURS", SP_WI_07_RUN_HOURS);
		obj.addProperty("SP_WI_07_RUN_MIN", SP_WI_07_RUN_MIN);
		
		//SP_WI_08
		List<sensorVO> SP_WI_08_POWER_RESULT = service.SP_WI_08_TIME_POWER_ON(vo);
		int SP_WI_08_POWER_TOTAL = 0;
		
		int SP_WI_08_POWER_MAX = SP_WI_08_POWER_RESULT.size();
		
		if(SP_WI_08_POWER_MAX == 0) {
			
			obj.addProperty("SP_WI_08_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date SP_WI_08_POWER_FIRST_TIME = SP_WI_08_POWER_RESULT.get(0).SP_WI_08_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String SP_WI_08_POWER_FIRST_STRING = format1.format(SP_WI_08_POWER_FIRST_TIME);
			
			obj.addProperty("SP_WI_08_POWER_FIRST_TIME", SP_WI_08_POWER_FIRST_STRING);
		}
		
		for(int i = 0; i < SP_WI_08_POWER_RESULT.size(); i++) {
			
			Date ONTIME = SP_WI_08_POWER_RESULT.get(i).SP_WI_08_POWERON_TIME;
			Date OFFTIME = SP_WI_08_POWER_RESULT.get(i).SP_WI_08_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WI_08_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WI_08_POWER_TOTAL += min;
				
			}
		}
		
		int SP_WI_08_POWER_HOURS = SP_WI_08_POWER_TOTAL / 60;
		int SP_WI_08_POWER_MIN = SP_WI_08_POWER_TOTAL % 60; 
	
		obj.addProperty("SP_WI_08_POWER_HOURS", SP_WI_08_POWER_HOURS);
		obj.addProperty("SP_WI_08_POWER_MIN", SP_WI_08_POWER_MIN);
		
		List<sensorVO> SP_WI_08_RUN_RESULT = service.SP_WI_08_TIME_RUN_ON(vo);
		int SP_WI_08_RUN_TOTAL = 0;
		
		for(int i = 0; i < SP_WI_08_RUN_RESULT.size(); i++) {
			
			Date ONTIME = SP_WI_08_RUN_RESULT.get(i).SP_WI_08_RUNON_TIME;
			Date OFFTIME = SP_WI_08_RUN_RESULT.get(i).SP_WI_08_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WI_08_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WI_08_RUN_TOTAL += min;
				
			}
		}
		
		int SP_WI_08_RUN_HOURS = SP_WI_08_RUN_TOTAL / 60;
		int SP_WI_08_RUN_MIN = SP_WI_08_RUN_TOTAL % 60; 
	
		obj.addProperty("SP_WI_08_RUN_HOURS", SP_WI_08_RUN_HOURS);
		obj.addProperty("SP_WI_08_RUN_MIN", SP_WI_08_RUN_MIN);
		
		//SP_WO_03
		List<sensorVO> SP_WO_03_POWER_RESULT = service.SP_WO_03_TIME_POWER_ON(vo);
		int SP_WO_03_POWER_TOTAL = 0;
		
		int SP_WO_03_POWER_MAX = SP_WO_03_POWER_RESULT.size();
		
		if(SP_WO_03_POWER_MAX == 0) {
			
			obj.addProperty("SP_WO_03_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date SP_WO_03_POWER_FIRST_TIME = SP_WO_03_POWER_RESULT.get(0).SP_WO_03_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String SP_WO_03_POWER_FIRST_STRING = format1.format(SP_WO_03_POWER_FIRST_TIME);
			
			obj.addProperty("SP_WO_03_POWER_FIRST_TIME", SP_WO_03_POWER_FIRST_STRING);
		}	
		
		
		for(int i = 0; i < SP_WO_03_POWER_RESULT.size(); i++) {
			
			Date ONTIME = SP_WO_03_POWER_RESULT.get(i).SP_WO_03_POWERON_TIME;
			Date OFFTIME = SP_WO_03_POWER_RESULT.get(i).SP_WO_03_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WO_03_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WO_03_POWER_TOTAL += min;
				
			}
		}
		
		int SP_WO_03_POWER_HOURS = SP_WO_03_POWER_TOTAL / 60;
		int SP_WO_03_POWER_MIN = SP_WO_03_POWER_TOTAL % 60; 
	
		obj.addProperty("SP_WO_03_POWER_HOURS", SP_WO_03_POWER_HOURS);
		obj.addProperty("SP_WO_03_POWER_MIN", SP_WO_03_POWER_MIN);
		
		List<sensorVO> SP_WO_03_RUN_RESULT = service.SP_WO_03_TIME_RUN_ON(vo);
		int SP_WO_03_RUN_TOTAL = 0;
		
		for(int i = 0; i < SP_WO_03_RUN_RESULT.size(); i++) {
			
			Date ONTIME = SP_WO_03_RUN_RESULT.get(i).SP_WO_03_RUNON_TIME;
			Date OFFTIME = SP_WO_03_RUN_RESULT.get(i).SP_WO_03_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WO_03_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WO_03_RUN_TOTAL += min;
				
			}
		}
		
		int SP_WO_03_RUN_HOURS = SP_WO_03_RUN_TOTAL / 60;
		int SP_WO_03_RUN_MIN = SP_WO_03_RUN_TOTAL % 60; 
	
		obj.addProperty("SP_WO_03_RUN_HOURS", SP_WO_03_RUN_HOURS);
		obj.addProperty("SP_WO_03_RUN_MIN", SP_WO_03_RUN_MIN);
		
		//SP_WI_03
		List<sensorVO> SP_WI_03_POWER_RESULT = service.SP_WI_03_TIME_POWER_ON(vo);
		int SP_WI_03_POWER_TOTAL = 0;
		
		int SP_WI_03_POWER_MAX = SP_WI_03_POWER_RESULT.size();
		
		if(SP_WI_03_POWER_MAX == 0) {
			
			obj.addProperty("SP_WI_03_POWER_FIRST_TIME", 0);
			
		}else {
			
			Date SP_WI_03_POWER_FIRST_TIME = SP_WI_03_POWER_RESULT.get(0).SP_WI_03_POWERON_TIME;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MMM d yyyy, HH:mm:ss aaa");
			
			String SP_WI_03_POWER_FIRST_STRING = format1.format(SP_WI_03_POWER_FIRST_TIME);
			
			obj.addProperty("SP_WI_03_POWER_FIRST_TIME", SP_WI_03_POWER_FIRST_STRING);
		}	
		
		for(int i = 0; i < SP_WI_03_POWER_RESULT.size(); i++) {
			
			Date ONTIME = SP_WI_03_POWER_RESULT.get(i).SP_WI_03_POWERON_TIME;
			Date OFFTIME = SP_WI_03_POWER_RESULT.get(i).SP_WI_03_POWEROFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WI_03_POWER_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WI_03_POWER_TOTAL += min;
				
			}
		}
		
		int SP_WI_03_POWER_HOURS = SP_WI_03_POWER_TOTAL / 60;
		int SP_WI_03_POWER_MIN = SP_WI_03_POWER_TOTAL % 60; 
	
		obj.addProperty("SP_WI_03_POWER_HOURS", SP_WI_03_POWER_HOURS);
		obj.addProperty("SP_WI_03_POWER_MIN", SP_WI_03_POWER_MIN);
		
		List<sensorVO> SP_WI_03_RUN_RESULT = service.SP_WI_03_TIME_RUN_ON(vo);
		int SP_WI_03_RUN_TOTAL = 0;
		
		for(int i = 0; i < SP_WI_03_RUN_RESULT.size(); i++) {
			
			Date ONTIME = SP_WI_03_RUN_RESULT.get(i).SP_WI_03_RUNON_TIME;
			Date OFFTIME = SP_WI_03_RUN_RESULT.get(i).SP_WI_03_RUNOFF_TIME;
			
			if(OFFTIME == null) {
				
				long Nowtime = time.getTime();
				
				long STARTTIME = ONTIME.getTime();
				
				long RUNTIME = (Nowtime - STARTTIME) / 60000;;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WI_03_RUN_TOTAL += min;
				
			}else {
				
				//시작 시간
				long STARTTIME = ONTIME.getTime();
				
				//끝난 시간
				long ENDTIME = OFFTIME.getTime();
				
				long RUNTIME =  (ENDTIME - STARTTIME) / 60000;
				
				int min = Long.valueOf(RUNTIME).intValue();
				
				SP_WI_03_RUN_TOTAL += min;
				
			}
		}
		
		int SP_WI_03_RUN_HOURS = SP_WI_03_RUN_TOTAL / 60;
		int SP_WI_03_RUN_MIN = SP_WI_03_RUN_TOTAL % 60; 
	
		obj.addProperty("SP_WI_03_RUN_HOURS", SP_WI_03_RUN_HOURS);
		obj.addProperty("SP_WI_03_RUN_MIN", SP_WI_03_RUN_MIN);
		
		return obj.toString();
	}
	
	@RequestMapping(value = "/Select_INDEX4", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<sensorVO> Select_INDEX4(sensorVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		logger.info(time + "Select_INDEX4");
		
		return service.Select_INDEX4(vo);
	}
	
}
