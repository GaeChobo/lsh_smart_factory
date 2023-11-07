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
import com.lsh.testing05.equip.exception.EquipDeleteException;
import com.lsh.testing05.equip.exception.EquipRegisterException;
import com.lsh.testing05.equip.exception.EquipSearchException;
import com.lsh.testing05.equip.exception.EquipSelectException;
import com.lsh.testing05.equip.exception.EquipUpdateException;
import com.lsh.testing05.equip.exception.ProcessIdkCheckException;
import com.lsh.testing05.equip.service.EquipService;
import com.lsh.testing05.equip.vo.EquipVO;
import com.lsh.testing05.handler.MyExceptionHandler;


@RestController
public class EquipController extends MyExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(EquipController.class);
	
	
	
	@Inject
	EquipService service;
	
	@RequestMapping(value = "/EquipMatchingList", method = RequestMethod.GET, produces="application/json;charset=utf-8")
	public List<EquipVO> EquipMatchingList(EquipVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");
		
		Date time = new Date();
				
		String time1 = format1.format(time);
		
		logger.info(time1 + "EquipMatchingList");
		
		return service.EquipMatchingList(vo);
	}

	@RequestMapping(value = "/EquipSensorMatching", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public String EquipSensorMatching(@RequestBody EquipVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");
		
		Date time = new Date();
				
		String time1 = format1.format(time);
		
		logger.info(time1 + "EquipSensorMatching");
		
		try {
			
			int MATCHING_ID = vo.getEQUIPMENT_SENSOR_MATCHING_ID();
			
			service.EquipSensorMatching(vo);
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("MATCHING_ID", MATCHING_ID);
			obj.addProperty("EquipSensorMatching", 1);
			
			return obj.toString(); 
		
		} catch(Exception e) {
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("EquipSensorMatching", 0);
			
			return obj.toString(); 
		}
		
	}
	
	@RequestMapping(value = "/EquipSensorMatchingDelete", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public String EquipSensorMatchingDelete(@RequestBody EquipVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");
		
		Date time = new Date();
				
		String time1 = format1.format(time);
		
		logger.info(time1 + "EquipSensorMatchingDelete");
		
		try {
			
			service.EquipSensorMatchingDelete(vo);
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("EquipSensorMatchingDelete", 1);
			
			return obj.toString(); 
		
		} catch(Exception e) {
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("EquipSensorMatchingDelete", 0);
			
			return obj.toString(); 
		}
		
	}
	
	@RequestMapping(value = "/EquipSensorList", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public List<EquipVO> EquipSensorList(@RequestBody EquipVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");
		
		Date time = new Date();
				
		String time1 = format1.format(time);
		
		logger.info(time1 + "EquipSensorList");
		
		return service.EquipSensorList(vo);
	}
	
	@RequestMapping(value = "/EquipIndexList", method = RequestMethod.GET, produces="application/json;charset=utf-8")
	public List<EquipVO> EquipIndexList(EquipVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");
		
		Date time = new Date();
				
		String time1 = format1.format(time);
		
		logger.info(time1 + "EquipIndexList");
		
		return service.EquipIndexList(vo);
	}

	
	
	@RequestMapping(value = "/SelectEquipList", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	@ResponseBody
	public List<EquipVO> SelectEquipList(@RequestBody EquipVO vo) throws Exception {
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");
		
		Date time = new Date();
				
		String time1 = format1.format(time);
		
		logger.info(time1 + "SelectEquipList");
		
		return service.SelectEquipList(vo);
	}
	
	@RequestMapping(value = "/SelectProcessEquip", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	@ResponseBody
	public List<EquipVO> SelectProcessEquip(@RequestBody EquipVO vo) throws Exception {
		logger.info("Get Process about Equipments");
		
		return service.SelectProcessEquip(vo);
	}
	
	@RequestMapping(value = "/AllselectEquip", method = RequestMethod.GET, produces="application/json;charset=utf-8")
	@ResponseBody
	public List<EquipVO> selectAllEquip() throws Exception {
		
		logger.info("Get Equipments");
		try {
			return service.AllselectEquip();
		}catch(Exception e) {
			throw new EquipSelectException();
		}
	}
	
	
	@RequestMapping(value ="/SelectWorkerEquip", method = RequestMethod.POST,  produces="application/json;charset=utf-8")
	public List<EquipVO> SelectWorkerEquip(@RequestBody EquipVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");
		
		Date time = new Date();
				
		String time1 = format1.format(time);
		
		logger.info(time1 + "SelectWorkerEquip");
		
		return service.SelectWorkerEquip(vo);

	}

	
	@RequestMapping(value ="ProcessIdChk", method = RequestMethod.POST,  produces="application/json;charset=utf-8")
	@ResponseBody
	public int ProcessIdkChk(@RequestBody EquipVO vo) throws Exception {
		
		int result = service.ProcessIdChk(vo);
		return result;
	}
	
	@RequestMapping(value ="EquipIdCheck", method = RequestMethod.POST,  produces="application/json;charset=utf-8")
	@ResponseBody
	public int EquipIdCheck(@RequestBody EquipVO vo) throws Exception {
		int result = service.EquipIdCheck(vo);
		return result;
	}
	
	@RequestMapping(value ="/RegisterEquip", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public String RegisterEquip(@RequestBody EquipVO vo) throws Exception {
		
		logger.info("Register Equipment");

		try {
			
			service.RegisterEquip(vo);
			JsonObject obj = new JsonObject();
			obj.addProperty("RegisterEquip", 1);
			
			return obj.toString();
			
		} catch (Exception e) {
			JsonObject obj = new JsonObject();
			obj.addProperty("RegisterEquip", 0);
			
			return obj.toString();
		}
		
	}
	@RequestMapping(value ="/UpdateEquip", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public String UpdateEquip(@RequestBody EquipVO vo) throws Exception {
		
		logger.info("Update Equipment");
		
		try {
			
			service.UpdateEquip(vo);
			
			JsonObject obj = new JsonObject();
			obj.addProperty("UpdateEquip", 1);
			
			return obj.toString();
			
			
		} catch (Exception e) {
			
			JsonObject obj = new JsonObject();
			obj.addProperty("UpdateEquip", 0);
			
			return obj.toString();
		}

	
	}
	
	@RequestMapping(value ="/DeleteEquip", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public String DeleteEquip(@RequestBody EquipVO vo) throws Exception {
		logger.info("Delete Equipment");
		
		int result = service.EquipIdCheck(vo);
		
		try {
			
			service.DeleteEquip(vo);
			
			JsonObject obj = new JsonObject();
			obj.addProperty("DeleteEquip", 1);
			
			return obj.toString();
			
		}catch(Exception e) {
		
			JsonObject obj = new JsonObject();
			obj.addProperty("DeleteEquip", 0);
			
			return obj.toString();
		}
	}
	
	@RequestMapping(value = "/SearchEquip", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public List<EquipVO> SearchEquip(@RequestBody EquipVO vo) throws Exception {
		
		logger.info("Search EquipName");
		
		
		
		try {
			return service.SearchEquip(vo);
		} catch (Exception e) {
			throw new EquipSearchException();
		}
		
	}
	
	
	
}