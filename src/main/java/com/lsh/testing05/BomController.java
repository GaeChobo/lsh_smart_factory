
package com.lsh.testing05;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.JsonObject;
import com.lsh.testing05.bom.exception.BomTemplateException;
import com.lsh.testing05.bom.service.BomService;
import com.lsh.testing05.bom.vo.BomVO;
import com.lsh.testing05.handler.MyExceptionHandler;

@RestController
public class BomController extends MyExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(BomController.class);

	@Inject
	BomService service;
	
	@RequestMapping(value = "/SearchJobNumBomDetail", method = RequestMethod.POST, produces = "application/json;charset=utf-8")	
	public List<BomVO> SearchJobNumBomDetail(@RequestBody BomVO vo) throws Exception {
	
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "SearchJobNumBomDetail");
		
		return service.SearchJobNumBomDetail(vo);
	}

	
	
	//이게 BOM 디테일로 찾는거
	@RequestMapping(value = "/FindBomJobNum", method = RequestMethod.POST, produces = "application/json;charset=utf-8")	
	public List<BomVO> FindBomJobNum(@RequestBody BomVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "FindBomJobNum");
		
		return service.FindBomJobNum(vo);
		
	}

	
	@RequestMapping(value = "/SearchBomDetail", method = RequestMethod.POST, produces = "application/json;charset=utf-8")	
	public List<BomVO> SearchBomDetail(@RequestBody BomVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "SearchBomDetail");
		
		vo.setBOM_DETAIL_PRODUCTCODE(vo.getSEARCH_WORD());
		vo.setBOM_DETAIL_PRODUCTNAME(vo.getSEARCH_WORD());
		
		return service.SearchBomDetail(vo);

	}
	
	
	@RequestMapping(value = "/AllDeleteBom", method = RequestMethod.POST, produces = "application/json;charset=utf-8")	
	public String AllDeleteBom(@RequestBody BomVO vo) throws Exception {
		
		logger.info("Bom All Delete");
	
		try {

			
			
			for(int i = 0; i < vo.getBOM_LIST_ID2().length; i++) {
				
				System.out.println(vo.getBOM_LIST_ID2()[i]);
				
				vo.setBOM_LIST_ID(vo.getBOM_LIST_ID2()[i]);
				
				int BomChk = service.BomDelChk(vo);
				
				if(BomChk > 0) {
					
					JsonObject obj = new JsonObject();
					
					obj.addProperty("AllDeleteBom", 2);
					
					return obj.toString();
					
				}else {
					
					continue;
				}

			}
			
			for(int i = 0; i < vo.getBOM_LIST_ID2().length; i++) {
				
				vo.setBOM_LIST_ID(vo.getBOM_LIST_ID2()[i]);
				
				System.out.println("실제 들어온 ID 키"+vo.getBOM_LIST_ID2()[i]);
				
				System.out.println("여기까지는 온듯");
				
				String result = service.BomfileDriectoryFind(vo);
				
				System.out.println(result);
				
				/*
				File file = new File(result);
				
				//파일 존재여부 확인
				if(file.exists()) {
					if(file.delete()) {
						System.out.println("파일삭제 성공");
					}else {
						System.out.println("파일삭제 실패");
					}
				}else {
					System.out.println("파일이 존재하지 않습니다.");
				}
				*/
				
				//DB 파일 삭제
				vo.setBOM_LIST_ID(vo.getBOM_LIST_ID2()[i]);
				
				service.DeleteBomFile(vo);
				
				vo.setBOM_LIST_ID(vo.getBOM_LIST_ID2()[i]);
				
				service.DeleteBomDetail(vo);
				
				vo.setBOM_LIST_ID(vo.getBOM_LIST_ID2()[i]);
				
				service.DeleteBomlist(vo);
				
			}
		
			JsonObject obj = new JsonObject();
			
			obj.addProperty("AllDeleteBom", 1);
			
			return obj.toString();

			
		} catch(Exception e ) {
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("AllDeleteBom", 0);
			
			return obj.toString();
		}
		

	}
	
	
	
	@RequestMapping(value = "/BomfileDriectoryFind", method = RequestMethod.GET, produces = "application/json;charset=utf-8")	
	public String BomfileDriectoryFind(@RequestBody BomVO vo) throws Exception {
		
		return service.BomfileDriectoryFind(vo);
	}

	
	@RequestMapping(value = "/CreateDayFindView", method = RequestMethod.POST, produces = "application/json;charset=utf-8")	
	public List<BomVO> CreateDayFindView(@RequestBody BomVO vo) throws Exception {
		
		logger.info("CreateDayFindView");
		
		return service.CreateDayFindView(vo);
	}
	
	@RequestMapping(value = "/SearchBomListFindView", method = RequestMethod.POST, produces = "application/json;charset=utf-8")	
	public List<BomVO> SearchBomListFindView(@RequestBody BomVO vo) throws Exception {
		
		logger.info("SearchBomListFindView");
		
		return service.SearchBomListFindView(vo);
	}

	@RequestMapping(value = "/AllListFindView", method = RequestMethod.POST, produces = "application/json;charset=utf-8")	
	public List<BomVO> AllListFindView(@RequestBody BomVO vo) throws Exception {
		
		logger.info("All List Find View");
		
		return service.AllListFindView(vo);
	}

	
	@RequestMapping(value = "/ViewBomDetail", method = RequestMethod.POST, produces = "application/json;charset=utf-8")	
	public List<BomVO> ViewBomDetail(@RequestBody BomVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "ViewBomDetail");
		
		int result = service.BomNullChk(vo);
		
		System.out.println(result);
		
		if(result > 0) {
			
			
			//통합서식용
			
			return service.ViewBomDetailA(vo);
			
		}else {
			
			//벨로우즈서식용
			return service.ViewBomDetail(vo);
			
		}
		
		
		
	}

	
	@RequestMapping(value = "/ViewBomList", method = RequestMethod.GET, produces = "application/json;charset=utf-8")	
	public List<BomVO> ViewBomList(BomVO vo) throws Exception {
		
		logger.info("View Bom list");
	
		return service.ViewBomList(vo);
	}

	@RequestMapping(value = "/BomFileUploadTest", method = RequestMethod.POST, produces = "application/json;charset=utf-8")	
	public void BomFileUploadTest(MultipartHttpServletRequest request, BomVO vo) throws Exception {
	
		logger.info("file_read");
		
		MultipartFile filelist = request.getFile("bom file");
		
		System.out.println(filelist.getOriginalFilename());
		

		//바로 읽어오기
		InputStream inputStream = new ByteArrayInputStream(filelist.getBytes());

		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		
		int rowindex = 0;
		int colindex = 0;
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		//전체 행이 몇게 인지 알아내고
		int rows = sheet.getPhysicalNumberOfRows();
		
		for(rowindex = 0; rowindex < rows; rowindex++) {
			
			XSSFRow row = sheet.getRow(rowindex);
			
			if(row != null) {
				
				int cells = row.getPhysicalNumberOfCells();
				
				for(colindex = 0; colindex < cells; colindex++) {
					
					XSSFCell cell = row.getCell(colindex);
					
					String value = "";
					
					if(cell == null) {
						continue;
					} else {
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
					
					
					System.out.println(value);
					

					
				}
			}
		}
		
		
	}
	
	@RequestMapping(value = "/BomFileUpload", method = RequestMethod.POST, produces = "application/json;charset=utf-8")	
	public void BomFileUpload(MultipartHttpServletRequest request, BomVO vo) throws Exception {
		
		logger.info("file_read");
		
		MultipartFile filelist = request.getFile("bom file");
		
		System.out.println(filelist.getOriginalFilename());
		

		//바로 읽어오기
		InputStream inputStream = new ByteArrayInputStream(filelist.getBytes());

		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		
		int rowindex = 0;
		int colindex = 0;
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		//전체 행이 몇게 인지 알아내고
		int rows = sheet.getPhysicalNumberOfRows();
		
		for(rowindex = 0; rowindex < rows; rowindex++) {
			
			XSSFRow row = sheet.getRow(rowindex);
			
			if(row != null) {
				
				int cells = row.getPhysicalNumberOfCells();
				
				for(colindex = 0; colindex < cells; colindex++) {
					
					XSSFCell cell = row.getCell(colindex);
					
					String value = "";
					
					if(cell == null) {
						continue;
					} else {
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
					
					//리스트 구분
					if(rowindex == 1 && colindex == 0) {
						
						System.out.println(value.getClass().getName());
						System.out.println(value);
						vo.setBOM_LIST_DIVISION(value);
						
					}
					
					//리스트 품번
					if(rowindex == 1 && colindex == 2) {
						
						System.out.println(value.getClass().getName());
						System.out.println(value);
						vo.setBOM_LIST_MAIN_NAME(value);
						
					}
					
					//리스트 품명
					if(rowindex == 1 && colindex == 3) {
						
						System.out.println(value.getClass().getName());
						System.out.println(value);
						vo.setBOM_LIST_MAIN_PRODUCTCODE(value);
						
						System.out.println(vo.getORIGIN_ACCOUNT_ID());
						vo.setORIGIN_ACCOUNT_ID(vo.getORIGIN_ACCOUNT_ID());
						
					}
					
					
				}
			}
		}
		
		
	}
	


	
	@RequestMapping(value = "/RegisterBomlist", method = RequestMethod.POST, produces = "application/json;charset=utf-8")	
	public String RegisterBomlist(BomVO vo, MultipartHttpServletRequest request) throws Exception {
		

		logger.info("file read and Upload");
		
		//형식 안맞는거 들어갔을 때 문제네
		
		try {
			
			MultipartFile filelist = request.getFile("bom file");
			
			String Original_bom_Filename = filelist.getOriginalFilename();
			
			//형식자 .xlsx 조건문
			if (Original_bom_Filename.contains(".xlsx")) {
				
				//엑셀 읽어들여서 DB 저장 부분임
				
				//바로 읽어오기
				InputStream inputStream = new ByteArrayInputStream(filelist.getBytes());				
				
				XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
				
				int rowindex = 0;
				int colindex = 0;
				
				XSSFSheet sheet = workbook.getSheetAt(0);
				
				//전체 행이 몇게 인지 알아내고
				int rows = sheet.getPhysicalNumberOfRows();

				//실제 DB구간
				
				//BOM 넣기용
				for(rowindex = 0; rowindex < rows; rowindex++) {
					
					XSSFRow row = sheet.getRow(rowindex);
					
					if(row != null) {
						
						int cells = row.getPhysicalNumberOfCells();
						
						System.out.println("위에 컬럼 갯수 : " + cells);
						
						
						System.out.println("여기까지는 오는거임?");
						
						//여기서 2가지 디테일 구분 해야함
						
						if (cells == 6) {
							
							for(colindex = 0; colindex < cells; colindex++) {
								
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
								

								//구분
								if(rowindex >= 1 && colindex == 0) {
									
			
									System.out.println(value.getClass().getName());
									System.out.println(value);
									
									if(rowindex == 1) {
										//리스트 DB
										vo.setBOM_LIST_DIVISION(value);
									}
									
									//디테일 DB
									vo.setBOM_DETAIL_DIVISION(value);
								}
								
								//순번
								if(rowindex >= 1 && colindex == 1) {
									

									//int로 형변환
									
									System.out.println(value.getClass().getName());
									int index = (int) Double.parseDouble(value);
									
									vo.setBOM_DETAIL_INDEX(index);
									
								}
								//레벨
								if(rowindex >= 1 && colindex == 2) {
									
									int level = (int) Double.parseDouble(value);

									vo.setBOM_DETAIL_LEVERL(level);
								}
								
								//품번
								if(rowindex >= 1 && colindex == 3) {
									
									if(rowindex == 1) {
										//리스트 DB
										vo.setBOM_LIST_MAIN_PRODUCTCODE(value);
										
									}
									
									vo.setBOM_DETAIL_PRODUCTCODE(value);
									
								}
								
								//리스트 품명
								if(rowindex >= 1 && colindex == 4) {
									
									if(rowindex == 1) {
										
										vo.setBOM_LIST_MAIN_NAME(value);
									}
									
									vo.setBOM_DETAIL_PRODUCTNAME(value);
									
									
									
									vo.setBOM_LIST_ID(vo.BOM_LIST_ID);
								}
								
								if(rowindex >= 1 && colindex == 5) {
								
									int quantity = (int) Double.parseDouble(value);
									
									
									vo.setBOM_DETAIL_QUANTITY(quantity);
									
									
									
									if(rowindex == 1) {
										
										vo.setBOM_LIST_QUANTITY(quantity);
										
										vo.setORIGIN_ACCOUNT_ID(vo.getORIGIN_ACCOUNT_ID());
										
										
									}
									
								}
							}
							
							
						}
						
						//16개 짜리 항목 이제 작성해야함
						else if (cells == 16) {
							
								for(colindex = 0; colindex < cells; colindex++) {
								
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
								
								
								
								//리스트, 디테일 구분
								if(rowindex >= 1 && colindex == 0) {
									
									if(rowindex == 1) {
										//리스트 DB
										vo.setBOM_LIST_DIVISION(value);
									}
									
									//디테일 DB
									vo.setBOM_DETAIL_DIVISION(value);
								}
								
								//디테일 순번
								if(rowindex >= 1 && colindex == 1) {
									
									//int로 형변환
									int index = (int) Double.parseDouble(value);
									
									
									vo.setBOM_DETAIL_INDEX(index);
									
								}
								//리스트, 디테일 레벨
								if(rowindex >= 1 && colindex == 2) {
									
									int level = (int) Double.parseDouble(value);
									
									
									vo.setBOM_DETAIL_LEVERL(level);
								}
								
								//리스트, 디테일 품번
								if(rowindex >= 1 && colindex == 3) {
									

									if(rowindex == 1) {
										//리스트 DB
										vo.setBOM_LIST_MAIN_PRODUCTCODE(value);
										
									}
									
									vo.setBOM_DETAIL_PRODUCTCODE(value);
									
								}
								
								//리스트, 디테일 품명
								if(rowindex >= 1 && colindex == 4) {
									
									
									
									if(rowindex == 1) {
										
										vo.setBOM_LIST_MAIN_NAME(value);
										
									}
									
									vo.setBOM_DETAIL_PRODUCTNAME(value);
									
									
									
									vo.setBOM_LIST_ID(vo.BOM_LIST_ID);
								}
								//디테일 수량
								if(rowindex >= 1 && colindex == 5) {
									

									int quantity = (int) Double.parseDouble(value);
									
									
									vo.setBOM_DETAIL_QUANTITY(quantity);
									
									//service.RegisterBomDetailA(vo);
									
									if(rowindex == 1) {
										
										vo.setBOM_LIST_QUANTITY(quantity);
									
										vo.setORIGIN_ACCOUNT_ID(vo.getORIGIN_ACCOUNT_ID());
										
									}
									
								}
								//디테일 벨로우즈코드
								if(rowindex >= 1 && colindex == 6) {
									
									
									vo.setBOM_DETAIL_BELLOWSCODE(value);
								}
								
								//디테일 금형타입
								if(rowindex >= 1 && colindex == 7) {
									
									vo.setBOM_DETAIL_MOLDTYPE(value);
								}
								
								//디테일  금형번호
								if(rowindex >= 1 && colindex == 8) {
									
									vo.setBOM_DETAIL_MOLDNUMBER(value);
								}
								
								//디테일 OD
								if(rowindex >= 1 && colindex == 9) {
									
									double OD = Double.parseDouble(value);

									
									vo.setBOM_DETAIL_OD(OD);
								}
								
								//디테일 ID
								if(rowindex >= 1 && colindex == 10) {
								

									double CID = Double.parseDouble(value);
									
									vo.setBOM_DETAIL_C_ID(CID);

								}
								
								//디테일 소재코드
								if(rowindex >= 1 && colindex == 11) {
									
									
									vo.setBOM_DETAIL_MATERIALCODE(value);
									
								}
								
								//디테일 소재
								if(rowindex >= 1 && colindex == 12) {
									
									
									vo.setBOM_DETAIL_MATERIAL(value);
								}
								
								
								//디테일 소재크기
								if(rowindex >= 1 && colindex == 13) {
									
									int MaterialSize = (int) Double.parseDouble(value);
									
									
									
									vo.setBOM_DETAIL_MATERIALSIZE(MaterialSize);
								}
								
								//디테일 소재두께
								if(rowindex >= 1 && colindex == 14) {
									
									double MaterialThick = Double.parseDouble(value);
									
									
									vo.setBOM_DETAIL_MATERIALTHICK(MaterialThick);
								}
								
								//디테일 W/D
								if(rowindex >= 1 && colindex == 15) {
									
									double WD = Double.parseDouble(value);
									
									
									vo.setBOM_DETAIL_WD(WD);
									
								}
								
							}
						}else {
							
							JsonObject obj = new JsonObject();
							
							obj.addProperty("RegisterBomlist", 0);
							
							return obj.toString();
						}

					}
				}
				

			} else {
				
				//예외처리 들어갈 부분
				JsonObject obj = new JsonObject();
				
				obj.addProperty("RegisterBomlist", 0);
				
				return obj.toString();
				
			}
		}catch (Exception e) {
			
			//예외처리 들어갈 부분
			JsonObject obj = new JsonObject();
			
			obj.addProperty("RegisterBomlist", 0);
			
			return obj.toString();
		}
		
		

		
		
		
		
		try {
			
			MultipartFile filelist = request.getFile("bom file");
			
			String Original_bom_Filename = filelist.getOriginalFilename();
			
			//형식자 .xlsx 조건문
			if (Original_bom_Filename.contains(".xlsx")) {
				
				//엑셀 읽어들여서 DB 저장 부분임
				
				//바로 읽어오기
				InputStream inputStream = new ByteArrayInputStream(filelist.getBytes());				
				
				XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
				
				int rowindex = 0;
				int colindex = 0;
				
				XSSFSheet sheet = workbook.getSheetAt(0);
				
				//전체 행이 몇게 인지 알아내고
				int rows = sheet.getPhysicalNumberOfRows();

				//실제 DB구간
				
				//BOM 넣기용
				for(rowindex = 0; rowindex < rows; rowindex++) {
					
					XSSFRow row = sheet.getRow(rowindex);
					
					if(row != null) {
						
						int cells = row.getPhysicalNumberOfCells();
						
						System.out.println("위에 컬럼 갯수 : " + cells);
						
						//여기서 2가지 디테일 구분 해야함
						
						
						
						if (cells == 6) {
							
							for(colindex = 0; colindex < cells; colindex++) {
								
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
								

								//구분
								if(rowindex >= 1 && colindex == 0) {
									
			
									System.out.println(value.getClass().getName());
									System.out.println(value);
									
									if(rowindex == 1) {
										//리스트 DB
										vo.setBOM_LIST_DIVISION(value);
									}
									
									//디테일 DB
									vo.setBOM_DETAIL_DIVISION(value);
								}
								
								//순번
								if(rowindex >= 1 && colindex == 1) {
									

									//int로 형변환
									int index = (int) Double.parseDouble(value);
									
									
									
									System.out.println(index);
									
									vo.setBOM_DETAIL_INDEX(index);
									
								}
								//레벨
								if(rowindex >= 1 && colindex == 2) {
									
									int level = (int) Double.parseDouble(value);
									
									System.out.println(level);
									
									vo.setBOM_DETAIL_LEVERL(level);
								}
								
								//품번
								if(rowindex >= 1 && colindex == 3) {
									
									System.out.println(value.getClass().getName());
									System.out.println(value);
									
									if(rowindex == 1) {
										//리스트 DB
										vo.setBOM_LIST_MAIN_PRODUCTCODE(value);
										
									}
									
									vo.setBOM_DETAIL_PRODUCTCODE(value);
									
								}
								
								//리스트 품명
								if(rowindex >= 1 && colindex == 4) {
									
									
									System.out.println(value.getClass().getName());
									System.out.println(value);
									
									if(rowindex == 1) {
										
										vo.setBOM_LIST_MAIN_NAME(value);
										

										

										
										System.out.println(vo.BOM_LIST_ID);
									}
									
									vo.setBOM_DETAIL_PRODUCTNAME(value);
									
									
									
									vo.setBOM_LIST_ID(vo.BOM_LIST_ID);
								}
								
								if(rowindex >= 1 && colindex == 5) {
								
									int quantity = (int) Double.parseDouble(value);
									
									System.out.println(quantity);
									
									vo.setBOM_DETAIL_QUANTITY(quantity);
									
									
									
									if(rowindex == 1) {
										
										vo.setBOM_LIST_QUANTITY(quantity);
										
										vo.setORIGIN_ACCOUNT_ID(vo.getORIGIN_ACCOUNT_ID());
										
										//얻은 값들로 List insert
										service.RegisterBomlist(vo);
										
									}
									
									service.RegisterBomDetailA(vo);
								}
							}
							
							
						}
						
						//16개 짜리 항목 이제 작성해야함
						else if (cells == 16) {
							
								for(colindex = 0; colindex < cells; colindex++) {
								
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
								
								
								
								//리스트, 디테일 구분
								if(rowindex >= 1 && colindex == 0) {
									
									System.out.println(value.getClass().getName());
									System.out.println(value);
									if(rowindex == 1) {
										//리스트 DB
										vo.setBOM_LIST_DIVISION(value);
									}
									
									//디테일 DB
									vo.setBOM_DETAIL_DIVISION(value);
								}
								
								//디테일 순번
								if(rowindex >= 1 && colindex == 1) {
									
									//int로 형변환
									int index = (int) Double.parseDouble(value);
									
									System.out.println(index);
									
									vo.setBOM_DETAIL_INDEX(index);
									
								}
								//리스트, 디테일 레벨
								if(rowindex >= 1 && colindex == 2) {
									
									int level = (int) Double.parseDouble(value);
									
									System.out.println(level);
									
									vo.setBOM_DETAIL_LEVERL(level);
								}
								
								//리스트, 디테일 품번
								if(rowindex >= 1 && colindex == 3) {
									
									System.out.println(value.getClass().getName());
									System.out.println(value);
									
									if(rowindex == 1) {
										//리스트 DB
										vo.setBOM_LIST_MAIN_PRODUCTCODE(value);
										
									}
									
									vo.setBOM_DETAIL_PRODUCTCODE(value);
									
								}
								
								//리스트, 디테일 품명
								if(rowindex >= 1 && colindex == 4) {
									
									
									System.out.println(value.getClass().getName());
									System.out.println(value);
									
									if(rowindex == 1) {
										
										vo.setBOM_LIST_MAIN_NAME(value);
										
									}
									
									vo.setBOM_DETAIL_PRODUCTNAME(value);
									
									
									
									vo.setBOM_LIST_ID(vo.BOM_LIST_ID);
								}
								//디테일 수량
								if(rowindex >= 1 && colindex == 5) {
									

									int quantity = (int) Double.parseDouble(value);
									
									System.out.println(quantity);
									
									vo.setBOM_DETAIL_QUANTITY(quantity);
									
									//service.RegisterBomDetailA(vo);
									
									if(rowindex == 1) {
										
										vo.setBOM_LIST_QUANTITY(quantity);
									
										vo.setORIGIN_ACCOUNT_ID(vo.getORIGIN_ACCOUNT_ID());
										
										//얻은 값들로 List insert
										service.RegisterBomlist(vo);
									}
									
								}
								//디테일 벨로우즈코드
								if(rowindex >= 1 && colindex == 6) {
									
									System.out.println(value);
									
									vo.setBOM_DETAIL_BELLOWSCODE(value);
								}
								
								//디테일 금형타입
								if(rowindex >= 1 && colindex == 7) {
									
									System.out.println(value);
									vo.setBOM_DETAIL_MOLDTYPE(value);
								}
								
								//디테일  금형번호
								if(rowindex >= 1 && colindex == 8) {
									
									System.out.println(value);
									vo.setBOM_DETAIL_MOLDNUMBER(value);
								}
								
								//디테일 OD
								if(rowindex >= 1 && colindex == 9) {
									
									double OD = Double.parseDouble(value);

									System.out.println(OD);
									
									vo.setBOM_DETAIL_OD(OD);
								}
								
								//디테일 ID
								if(rowindex >= 1 && colindex == 10) {
								

									double CID = Double.parseDouble(value);
									
									vo.setBOM_DETAIL_C_ID(CID);

								}
								
								//디테일 소재코드
								if(rowindex >= 1 && colindex == 11) {
									
									System.out.println(value);
									
									vo.setBOM_DETAIL_MATERIALCODE(value);
									
								}
								
								//디테일 소재
								if(rowindex >= 1 && colindex == 12) {
									
									System.out.println(value);
									
									vo.setBOM_DETAIL_MATERIAL(value);
								}
								
								
								//디테일 소재크기
								if(rowindex >= 1 && colindex == 13) {
									
									int MaterialSize = (int) Double.parseDouble(value);
									
									System.out.println(MaterialSize);
									
									
									vo.setBOM_DETAIL_MATERIALSIZE(MaterialSize);
								}
								
								//디테일 소재두께
								if(rowindex >= 1 && colindex == 14) {
									
									double MaterialThick = Double.parseDouble(value);
									
									System.out.println(MaterialThick);
									
									vo.setBOM_DETAIL_MATERIALTHICK(MaterialThick);
								}
								
								//디테일 W/D
								if(rowindex >= 1 && colindex == 15) {
									
									double WD = Double.parseDouble(value);
									
									System.out.println(WD);
									
									vo.setBOM_DETAIL_WD(WD);
									
									service.RegisterBomDetailB(vo);
								}
								
							}
						}else {
							
							JsonObject obj = new JsonObject();
							
							obj.addProperty("RegisterBomlist", 0);
							
							return obj.toString();
						}

					}
				}
				
				
				SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");
				
				Date time = new Date();				
				
				String time1 = format1.format(time);

				//C로 디렉 변경
				
				String path = ("C:\\factory\\admin\\bom\\");

				String realpath = path+time1;
				
				File Folder = new File(realpath);
				
				Folder.mkdirs();
				
				File savefile = new File(realpath+"\\"+filelist.getOriginalFilename());
				
				String OriginName = filelist.getOriginalFilename().toString();
				
				String directory = savefile.toString();
				
				System.out.println(OriginName);
				
				System.out.println(directory);
				
				filelist.transferTo(savefile);
				
				String InCodingOriginName = new String(OriginName.getBytes("8859_1"), "UTF-8");
				String Incodingdirectory = new String(directory.getBytes("8859_1"), "UTF-8");
				
				System.out.println("만들어져서 나온 봄 List ID : " + vo.BOM_LIST_ID);
				
				vo.setBOM_LIST_ID(vo.BOM_LIST_ID);
				vo.setBOM_FILE_MANAGEMENT_NAME(InCodingOriginName);
				vo.setBOM_FILE_MANAGEMENT_DIRECTORY(Incodingdirectory);
				
				service.UploadBomFile(vo);
				
			} else {
				
				//예외처리 들어갈 부분
				JsonObject obj = new JsonObject();
				
				obj.addProperty("RegisterBomlist", 0);
				
				return obj.toString();
				
			}
			
			
		} catch(Exception e) {
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("RegisterBomlist", 0);
			
			return obj.toString();
		}
		
		JsonObject obj = new JsonObject();
		
		obj.addProperty("RegisterBomlist", 1);
		
		return obj.toString();
		
	}
}
