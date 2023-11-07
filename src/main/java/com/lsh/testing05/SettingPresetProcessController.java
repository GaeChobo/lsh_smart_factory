package com.lsh.testing05;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.lsh.testing05.handler.MyExceptionHandler;
import com.lsh.testing05.settingpresetprocess.exception.SettingPresetProcessAllDeleteException;
import com.lsh.testing05.settingpresetprocess.exception.SettingPresetProcessIndexDeleteException;
import com.lsh.testing05.settingpresetprocess.exception.SettingPresetProcessIndexUpdateException;
import com.lsh.testing05.settingpresetprocess.exception.SettingPresetProcessRegisterException;
import com.lsh.testing05.settingpresetprocess.exception.SettingPresetProcessSelectException;
import com.lsh.testing05.settingpresetprocess.service.SettingpresetprocessService;
import com.lsh.testing05.settingpresetprocess.vo.SettingpresetprocessVO;

@RestController
public class SettingPresetProcessController extends MyExceptionHandler{

	private static final Logger logger = LoggerFactory.getLogger(SettingPresetProcessController.class);
	
	@Inject
	SettingpresetprocessService service;
	
	
	
	@RequestMapping(value = "/RegisterSettingPresetProcess2", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public void RegisterSettingPresetProcess(@RequestBody SettingpresetprocessVO vo) throws Exception {
		
		logger.info("Register Testing");
		
		try {
			for (int i = 0; i < vo.getSETTING_PRESET_PROCESS_INDEX2().length; i++) {
				
				
				
				vo.setORIGIN_PROCESS_ID(vo.getORIGIN_PROCESS_ID2()[i]);
				vo.setSETTING_PRESET_ID(vo.getSETTING_PRESET_ID2()[i]);
				vo.setSETTING_PRESET_PROCESS_INDEX(vo.getSETTING_PRESET_PROCESS_INDEX2()[i]);
				
				int result = service.SettingPresetIndexChk(vo);
				
				if(result > 0) {
					throw new SettingPresetProcessRegisterException();
				}else {
				
					vo.setORIGIN_PROCESS_ID(vo.getORIGIN_PROCESS_ID2()[i]);
					vo.setSETTING_PRESET_ID(vo.getSETTING_PRESET_ID2()[i]);
					vo.setSETTING_PRESET_PROCESS_INDEX(vo.getSETTING_PRESET_PROCESS_INDEX2()[i]);
					
					service.RegisterSettingPresetProcess(vo);
				}
				
			}
		} catch (Exception e) {
			throw new SettingPresetProcessRegisterException();
		}
	}
	
	
	/*
	@RequestMapping(value = "/SettingPresetIndexChk", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public int SettingPresetIndexChk(@RequestBody SettingpresetprocessVO vo) throws Exception {

		int result = service.SettingPresetIndexChk(vo);
		return result;
	}*/
	public static void main(String[] args) {
		
		try {
			FileInputStream file = new FileInputStream("C:\\Users\\simsreality_LSH\\Downloads\\개발BOM 공정 샘플_RCS_BOM_ref_0511.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			
			int rowindex = 0;
			int colindex = 0;
			
			XSSFSheet sheet = workbook.getSheetAt(0);
			 
			int rows = sheet.getPhysicalNumberOfRows();
			
			for(rowindex = 0; rowindex<rows; rowindex++) {
				
				XSSFRow row = sheet.getRow(rowindex);
				
				if(row != null) {
					
					int cells = row.getPhysicalNumberOfCells();
					
					for(colindex = 0; colindex <= cells; colindex++) {
						
						XSSFCell cell = row.getCell(colindex);
						
						String value = "";
						
						if(cell == null) {
							continue;
						}else {
							switch(cell.getCellType()) {
							 case XSSFCell.CELL_TYPE_FORMULA:
	                                value=cell.getCellFormula();
	                                break;
	                            case XSSFCell.CELL_TYPE_NUMERIC:
	                                value=cell.getNumericCellValue()+"";
	                                break;
	                            case XSSFCell.CELL_TYPE_STRING:
	                                value=cell.getStringCellValue()+"";
	                                break;
	                            case XSSFCell.CELL_TYPE_BLANK:
	                                value=cell.getBooleanCellValue()+"";
	                                break;
	                            case XSSFCell.CELL_TYPE_ERROR:
	                                value=cell.getErrorCellValue()+"";
	                                break;
	                            case XSSFCell.CELL_TYPE_BOOLEAN:
	                            	value=cell.getBooleanCellValue()+"";
	                   
							}
						}
						System.out.println(rowindex+"번 행 : "+colindex+"번 열 값은: "+value);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@RequestMapping(value = "/SettingPresetIdChk", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public int SettingPresetIdChk(@RequestBody SettingpresetprocessVO vo) throws Exception {
		
		int result = service.SettingPresetIdChk(vo);
		return result;
	}
	
	@RequestMapping(value = "/SelectSettingPresetProcess", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<SettingpresetprocessVO> SelectSettingPresetProcess(@RequestBody SettingpresetprocessVO vo) throws Exception {
	
		logger.info("View SettingPresetProcess");
		
		int result = service.SettingPresetIdChk(vo);
		
		if (result == 0) {
			throw new SettingPresetProcessSelectException();
		} else {
			return service.SelectSettingPresetProcess(vo);
		}
		
	}
	
	@RequestMapping(value = "/SettingPresetProcessSelect", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<SettingpresetprocessVO> SettingPresetProcessSelect(SettingpresetprocessVO vo) throws Exception {
		
		logger.info("Process List View");
		
		return service.SettingPresetProcessSelect(vo);
	}

	@RequestMapping(value = "/DetailSettingPresetProcess", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<SettingpresetprocessVO> DetailSettingPresetProcess(@RequestBody SettingpresetprocessVO vo) throws Exception{
		
		logger.info("View DetailSettingPresetProcess");
		
		int result = service.SettingPresetIdChk(vo);
		
		if (result == 0) {
			throw new SettingPresetProcessSelectException();
		} else {
			
			return service.DetailSettingPresetProcess(vo);
		}
	}
	
	//ppt 40p 공정 프리셋 삭제할때 다같이 삭제되는 부분
	@RequestMapping(value = "/DeleteSettingPresetProcess", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public void DeleteSettingPresetProcess(@RequestBody SettingpresetprocessVO vo) throws Exception {
		
		logger.info("View DeleteSettingPresetProcess");
		
		try {
			for (int i = 0; i < vo.getSETTING_PRESET_ID2().length; i++) {
				
				vo.setSETTING_PRESET_ID(vo.getSETTING_PRESET_ID2()[i]);
				
				service.DeleteSettingPresetProcess(vo);
			}
		} catch (Exception e) {
			throw new SettingPresetProcessAllDeleteException();
		}
		
		

	}
	
	
	


	@RequestMapping(value = "/UpdateSettingPresetProcess", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String UpdateSettingPresetProcess(@RequestBody SettingpresetprocessVO vo) throws Exception{
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "UpdateSettingPresetProcess");
		
		//업데이트 전에 이미 순서가 있는 공정 존재하는 지 유무 체크하고
		/*
		for (int i = 0; i < vo.getSETTING_PRESET_ID2().length; i++) {
			vo.setSETTING_PRESET_ID(vo.getSETTING_PRESET_ID2()[i]);
			vo.setSETTING_PRESET_PROCESS_ID(vo.getSETTING_PRESET_PROCESS_ID2()[i]);
			
			int result = service.SettingPresetIndexChk(vo);
			
			if (result >= 1) {
				System.out.println("순서 중복됨");
			}
			
		}*/
		//업데이트
		try {
			for (int i = 0; i < vo.getSETTING_PRESET_PROCESS_INDEX2().length; i++) {
				
				vo.setSETTING_PRESET_PROCESS_INDEX(vo.getSETTING_PRESET_PROCESS_INDEX2()[i]);
				vo.setSETTING_PRESET_PROCESS_ID(vo.getSETTING_PRESET_PROCESS_ID2()[i]);

				service.UpdateSettingPresetProcess(vo);
			}
			
			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateSettingPresetProcess", 1);

			return obj.toString();
			
		} catch(Exception e) {
			
			JsonObject obj = new JsonObject();

			obj.addProperty("UpdateSettingPresetProcess", 0);

			return obj.toString();
		}
		
		
		

	}
}
