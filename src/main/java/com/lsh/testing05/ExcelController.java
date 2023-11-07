package com.lsh.testing05;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lsh.testing.exceltest.vo.ExcelTestVO;

@RestController
public class ExcelController {

	@PostMapping("/excel/read")
	public String readExcel(@RequestParam("file") MultipartFile file, Model model) throws IOException {
		
		
		
		
		
		
		//case 2
		/*
		FileInputStream file = new FileInputStream("d:\\excelread.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = null;

		for(int i=0 ; i<workbook.length ; i++){
			sheet = workbook.getSheetAt(i);
			int rows = sheet.getPhysicalNumberOfRows();

			for(int j=0 ; j<rows ;j++){
				XSSFRow row = sheet.getRow(j);
				int cells = row.getPhysicalNumberOfCells();

				for(int k=0 ; k<cells ;j++){
					XSSFCell cell = row.getCell(k);
 
					switch (cell.getCellType()){
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
					}
					System.out.println(i + "번 시트 : " + j + "행의 " + k + "열 = " + value);
				}
			}
		}*/
		
		
		
		//Case 1 
		List<ExcelTestVO> dataList = new ArrayList<>();
		 
		String extension = FilenameUtils.getExtension(file.getOriginalFilename());
		
		if (!extension.equals("xlsx") && !extension.equals("xls")) {
			throw new IOException("엑셀 파일만 업로드 해야함");
		}
		
		Workbook workbook = null;
		
		if (!extension.equals("xlsx")) {
			workbook = new XSSFWorkbook(file.getInputStream());
		}else if (!extension.equals("xls")) {
			workbook = new HSSFWorkbook(file.getInputStream());
		}
		
		Sheet worksheet = workbook.getSheetAt(0);
		
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			
			Row row = worksheet.getRow(i);
			
			ExcelTestVO vo = new ExcelTestVO();
			
			vo.setNum((int)row.getCell(0).getNumericCellValue());
			vo.setName(row.getCell(1).getStringCellValue());
			vo.setEmail(row.getCell(2).getStringCellValue());
			
			dataList.add(vo);
			
			
		}
		
		for (Object object : dataList) {
			String element = (String) object;
			System.out.println(element);
		}
		
		return null;
		
		
		
	}
	
	
}
