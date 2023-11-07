package com.lsh.testing05;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


import javax.inject.Inject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lsh.testing05.file.vo.FileVO;
import com.lsh.testing05.handler.MyExceptionHandler;
import com.lsh.testing05.settingpreset.exception.SettingPresetCopyException;
import com.lsh.testing05.settingpreset.exception.SettingPresetDeleteException;
import com.lsh.testing05.settingpreset.exception.SettingPresetFileDeleteException;
import com.lsh.testing05.settingpreset.exception.SettingPresetFileUploadException;
import com.lsh.testing05.settingpreset.exception.SettingPresetPresetNameChkException;
import com.lsh.testing05.settingpreset.exception.SettingPresetProcessIndexDeleteException;
import com.lsh.testing05.settingpreset.exception.SettingPresetRegisterException;
import com.lsh.testing05.settingpreset.exception.SettingPresetSearchException;
import com.lsh.testing05.settingpreset.exception.SettingPresetUniquessMultiDeleteException;
import com.lsh.testing05.settingpreset.exception.SettingPresetUniquessRegisterException;
import com.lsh.testing05.settingpreset.exception.SettingPresetUniquessUpdateException;
import com.lsh.testing05.settingpreset.exception.SettingPresetUpdateException;
import com.lsh.testing05.settingpreset.exception.SettingPresetWorktimeUpdateException;
import com.lsh.testing05.settingpreset.service.SettingpresetService;
import com.lsh.testing05.settingpreset.vo.SettingpresetVO;

@RestController
public class SettingPresetController extends MyExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(SettingPresetController.class);
	
	@Inject
	SettingpresetService service;
	
	
	
	@RequestMapping(value = "PresetListViewTest", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String PresetListViewTest(SettingpresetVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);
		
		logger.info(time1 + "PresetListViewTest");
		
		List<SettingpresetVO> resulttest1 = new ArrayList();
		
		
		
		List<SettingpresetVO> result = null;
		
		result = service.PresetListViewTest(vo);
		
		
		
		JSONObject testjson = new JSONObject();
		
		JSONArray testjsonArray = new JSONArray();
		
		ArrayList<String> exportName = new ArrayList<String>();

		
		for(int i = 0; i < result.size(); i++) {
			
			String test1 = result.get(i).ORIGIN_PROCESS_ID_ARRAY;
			
			String[] testArray = test1.split(",");
			
			ArrayList<String> content = new ArrayList<String>();
			
			int[] intArray;
			
			for(int ii = 0; ii < testArray.length; ii++) {
				
				int a = Integer.parseInt(testArray[ii]);
				
				vo.setORIGIN_PROCESS_ID(a);
				
				String FindName = service.FindProcessName(vo);
				
				content.add(FindName);

				
			}
			
			testjson.put("ORIGIN_PROCESS_NAME["+i+"]", content);
			testjsonArray.add(content);
			
		}
		
		
		
		System.out.println(testjson);
		System.out.println(testjsonArray.toString());
		
		return testjson.toString();
		

	}

	
	@RequestMapping(value = "IdEmpStatusChk", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public int IdEmpStatusChk(@RequestBody SettingpresetVO vo) throws Exception {
		
		int result = service.IdEmpStatusChk(vo);
		return result;
	}
	
	
	@RequestMapping(value = "AdminChk", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public int AdminChk(@RequestBody SettingpresetVO vo) throws Exception {
		
		int result = service.AdminChk(vo);
		return result;
		
	}
	
	@RequestMapping(value = "FindSettingPresetID", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public int FindSettingPresetID(@RequestBody SettingpresetVO vo) throws Exception {
		
		int result = service.FindSettingPresetID(vo);
		return result;
	}
	
	@RequestMapping(value = "CopySettingProcess", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<SettingpresetVO> CopySettingProcess(@RequestBody SettingpresetVO vo) throws Exception {
		
		List<SettingpresetVO> result = service.CopySettingProcess(vo);
		return result;
	}
	
	@RequestMapping(value = "CopySettingProcessIndex", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<SettingpresetVO> CopySettingProcessIndex(@RequestBody SettingpresetVO vo) throws Exception {
	
		List<SettingpresetVO> result = service.CopySettingProcessIndex(vo);
		return result;
	}
	
	@RequestMapping(value = "CopySettingProcessId", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<SettingpresetVO> CopySettingProcessId(@RequestBody SettingpresetVO vo) throws Exception {
		
		List<SettingpresetVO> result = service.CopySettingProcessId(vo);
		return result;
	}
 
	@RequestMapping(value = "/UpdatePresetUniquess" , method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public void UpdatePresetUniquess(@RequestBody SettingpresetVO vo) throws Exception {
		
		logger.info("Uniquess re Register");
		
		try {
			for (int i = 0; i < vo.getSETTING_PRESET_PROCESS_ID2().length; i++ ) {
				
				vo.setSETTING_PRESET_PROCESS_ID(vo.getSETTING_PRESET_PROCESS_ID2()[i]);
				vo.setORIGIN_UNIQUESS_ID(vo.getORIGIN_UNIQUESS_ID2()[i]);
				  
				service.RegisterSettingPresetUniquess(vo);
			}
		} catch(Exception e) {
			throw new SettingPresetUniquessUpdateException();
		}
		
	}
	
	@RequestMapping(value = "/OriginProcessSelect", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<SettingpresetVO> OriginProcessSelect(SettingpresetVO vo) throws Exception {
		
		
		
		return service.OriginProcessSelect(vo);
	}

	
	@RequestMapping(value = "/PresetFileUpload", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String PresetFileUpload(SettingpresetVO vo, MultipartHttpServletRequest request) throws Exception {

		try {
			
			List<MultipartFile> fileList = request.getFiles("PresetFile");

			
			ArrayList<String> PresetFileDirList = new ArrayList<String>();
			
			ArrayList<String> PresetFileNameList = new ArrayList<String>();
			
			ArrayList<String> PresetFileDBDirList = new ArrayList<String>();
			
			for(MultipartFile mf : fileList) {
				
				//자주검사 파일 저장용 폴더 생성
				SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");
				
				Date time = new Date();
				
				String time1 = format1.format(time);
				
				//C로 디렉 변경
				
				String path = ("C:\\Html\\factory\\admin\\preset\\");
				
				String dbpath = ("http://182.208.252.210:5995/factory/admin/preset/");
				
				String dbrealpath = dbpath+time1;
				
				String realpath = path+time1;
				
				File Folder = new File(realpath);
				
				Folder.mkdirs();
				
				String Filename = new String(mf.getOriginalFilename().getBytes("8859_1"), "UTF-8");
				
				File saveFile = new File(realpath+"\\"+Filename);
				
				System.out.println(saveFile.toString());
				
				String dbsavepath = dbrealpath+"/"+Filename;
				
				mf.transferTo(saveFile);
				
				String directory = saveFile.toString();

				//실제 경로 담는 컬럼
				PresetFileDirList.add(directory);
				//파일명
				PresetFileNameList.add(Filename);
				//웹에서 사용될 파일 경로명
				PresetFileDBDirList.add(dbsavepath);
				
				
			}
			
			for(int i = 0; i < vo.getJOBORDER_FILE_TYPE_ID2().length; i++ ) {
				
				vo.setSETTING_PRESET_ID(vo.getSETTING_PRESET_ID2()[i]);
				vo.setJOBORDER_FILE_TYPE_ID(vo.getJOBORDER_FILE_TYPE_ID2()[i]);
				vo.setSETTING_PRESET_FILE_MANAGEMENT_NAME(PresetFileNameList.get(i));
				vo.setSETTING_PRESET_FILE_MANAGEMENT_DIRECTORY(PresetFileDirList.get(i));
				vo.setSETTING_PRESET_FILE_MANAGEMENT_DB_DIRECTORY(PresetFileDBDirList.get(i));
				
				service.PresetFileUpload(vo);
			}

			JsonObject obj = new JsonObject();
			
			obj.addProperty("PresetFileUpload", 1);
			
			return obj.toString();
			
		} catch(Exception e) {
		
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("PresetFileUpload", 0);
			
			return obj.toString();
		}
		
		
	}
	
	@RequestMapping(value = "/RegisterSettingPresetUniquess" , method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public void RegisterSettingPresetUniquess(@RequestBody SettingpresetVO vo) throws Exception {
		
		logger.info("RegisterSettingPresetUniquess");
		
		try {
			for(int i = 0; i < vo.getSETTING_PRESET_PROCESS_ID2().length; i++) {
				
				vo.setSETTING_PRESET_PROCESS_ID(vo.getSETTING_PRESET_PROCESS_ID2()[i]);
				vo.setORIGIN_UNIQUESS_ID(vo.getORIGIN_UNIQUESS_ID2()[i]);
				
				service.RegisterSettingPresetUniquess(vo);
			}	
		} catch (Exception e) {
			throw new SettingPresetUniquessRegisterException();
		}
		
		
		
	}
	
	@RequestMapping(value= "/InFileTest" , method = RequestMethod.POST, produces = "application/json;charset=utf-8") 
	public String InFileTest(MultipartHttpServletRequest request, SettingpresetVO vo) throws Exception {
		
		List<MultipartFile> fileList = request.getFiles("file");

		ArrayList<String> mflist = new ArrayList<String>();		
		
		for (MultipartFile mf : fileList) {
			
			String originalName = mf.getOriginalFilename();
			long filesize = mf.getSize();
			
			mflist.add(originalName);
			
		}
		
		for(int i = 0; i < vo.getORIGIN_ACCOUNT_DIVISION_ID2().length; i++) {
			
			System.out.println(vo.getORIGIN_ACCOUNT_DIVISION_ID2()[i]);
			if(mflist.get(i) == null) {
				System.out.println(i+"null 맞음");
			}else {
				System.out.println(mflist.get(i));
			}
			
		}
		

		return null;
		
		
	}
	
	@RequestMapping(value = "/TestReset", method = RequestMethod.POST, produces = "application/json;charset=utf-8")	
	public void TestReset(SettingpresetVO vo, @RequestParam("PROCESS_MAIN_CATEGORY_NAME") String PROCESS_MAIN_CATEGORY_NAME, @RequestParam("PROCESS_MAIN_CATEGORY_NAME_LIST") List<String> PROCESS_MAIN_CATEGORY_NAME_LIST) throws Exception {
		
		logger.info("Test");
	

		String IncodingA = new String(PROCESS_MAIN_CATEGORY_NAME.getBytes("8859_1"), "UTF-8");
		
		System.out.println(IncodingA);

		for(int i = 0; i < PROCESS_MAIN_CATEGORY_NAME_LIST.size(); i++) {
			
			System.out.println(i);
			String IncodingB = new String(PROCESS_MAIN_CATEGORY_NAME_LIST.get(i).getBytes("8859_1"), "UTF-8"); 
			System.out.println(IncodingB);
		}
		
	}
	
	@RequestMapping(value = "/PresetProcessList", method = RequestMethod.POST, produces = "application/json;charset=utf-8")	
	public List<SettingpresetVO> PresetProcessList(@RequestBody SettingpresetVO vo) throws Exception {
		
		logger.info("PresetProcessList");
		
		List<SettingpresetVO> result = service.PresetProcessList(vo);
		
		return result;
	}

	
	@RequestMapping(value = "/UniquessTest", method = RequestMethod.POST, produces = "application/json;charset=utf-8")	
	public void UniquessTest(SettingpresetVO vo) throws Exception {
		
		for(int i = 0; i < vo.getSETTING_PRESET_PROCESS_INDEX2().length; i++) {
			
			System.out.println("공정 순서 : "+vo.getSETTING_PRESET_PROCESS_INDEX2()[i]);
			
			for(int j = 0; j < vo.getORIGIN_UNIQUESS_ID3()[i].length; j++) {
				
				System.out.println("작업 특이사항 ID : "+vo.getORIGIN_UNIQUESS_ID3()[i][j]);
			}
		}

		
		
	}

	@RequestMapping(value = "/RegisterSettingPresetTest", method = RequestMethod.POST, produces = "application/json;charset=utf-8")	
	public String RegisterSettingPresetTest(SettingpresetVO vo, MultipartHttpServletRequest request) throws Exception {
	

		
		logger.info("Reigster SettingPreset");
		
		int NameChk = service.PresetNameChk(vo);
		
		//큰틀의 프리셋 명칭 중복 체크
		if(NameChk >= 1) {
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("Preset_overlap", 1);
			
			return obj.toString();

		}
		
		else {
			

			
			//한글화 인코딩
			String InCodingSETTING_PRESET_NAME = new String(vo.getSETTING_PRESET_NAME().getBytes("8859_1"), "UTF-8");
			vo.setSETTING_PRESET_NAME(InCodingSETTING_PRESET_NAME);
			
			//큰 거 프리셋 등록하는거
			service.RegisterSettingPreset(vo);
			

			//만들고 나온 키 값
			int preset_key = vo.SETTING_PRESET_ID;
			
			
			ArrayList<String> PresetFileDirList = new ArrayList<String>();
			
			ArrayList<String> PresetFileNameList = new ArrayList<String>();
			
			ArrayList<String> PrsetFileDBDirList = new ArrayList<String>();
			
			//List<MultipartFile> filelist = request.getFiles("SelfInspectionFile");
			
			List<MultipartFile> filelist2 = request.getFiles("PresetFile");
			
			/*
			for(MultipartFile mf : filelist) {
				
				//자주검사 파일 저장용 폴더 생성
				SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");
				
				Date time = new Date();
				
				String time1 = format1.format(time);
				
				String path = ("D:\\Inspection File\\");
				
				String realpath = path+time1;
				
				File Folder = new File(realpath);
				
				Folder.mkdirs();
				
				String Filename = new String(mf.getOriginalFilename().getBytes("8859_1"), "UTF-8");
				
				File saveFile = new File(realpath+"\\"+Filename);
				
				mf.transferTo(saveFile);
				
				String directory = saveFile.toString();
	
				DirectoryList.add(directory);
				
			}
			*/
			
			for(MultipartFile mf : filelist2) {
				
				SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");
				
				Date time = new Date();
				
				String time1 = format1.format(time);
				
				//C로 디렉 변경
				
				String path = ("C:\\Html\\factory\\admin\\preset\\");
				
				String dbpath = ("http://182.208.252.210:5995/factory/admin/preset/");
				
				String dbrealpath = dbpath+time1;
				
				String realpath = path+time1;
				
				File Folder = new File(realpath);
				
				Folder.mkdirs();
				
				String Filename = new String(mf.getOriginalFilename().getBytes("8859_1"), "UTF-8");
				
				File saveFile = new File(realpath+"\\"+Filename);
				
				String dbsavepath = dbrealpath+"/"+Filename;
				
				System.out.println(saveFile.toString());
				
				mf.transferTo(saveFile);
				
				String directory = saveFile.toString();
				
				//실제경로
				PresetFileDirList.add(directory);
				//파일명
				PresetFileNameList.add(Filename);
				//웹에서 사용될 경로명
				PrsetFileDBDirList.add(dbsavepath);
				
			}
			
			//프리셋 파일 넣기 위한 것들
			for(int i = 0; i < PresetFileDirList.size(); i++) {
				
				
				vo.setSETTING_PRESET_ID(preset_key);

				vo.setSETTING_PRESET_FILE_MANAGEMENT_NAME(PresetFileNameList.get(i));
				vo.setSETTING_PRESET_FILE_MANAGEMENT_DIRECTORY(PresetFileDirList.get(i));
				
				if(vo.getCT_FILE_REGISTER_ID() == 8) {
					Integer none = null;
					vo.setJOBORDER_FILE_TYPE_ID(none);
				}else {
					vo.setJOBORDER_FILE_TYPE_ID(vo.getJOBORDER_FILE_TYPE_ID2()[i]);
				}
				
				vo.setSETTING_PRESET_FILE_MANAGEMENT_DB_DIRECTORY(PrsetFileDBDirList.get(i));

				
				service.PresetFileUpload(vo);
			}
			

			//프리셋 공정 생성 반복문
			ArrayList<Integer> PresetProcessList = new ArrayList<Integer>();
			
			for(int i = 0; i < vo.getORIGIN_PROCESS_ID2().length; i++) {
				
				vo.setORIGIN_PROCESS_ID(vo.getORIGIN_PROCESS_ID2()[i]);
				vo.setSETTING_PRESET_ID(preset_key);
				vo.setSETTING_PRESET_PROCESS_INDEX(vo.getSETTING_PRESET_PROCESS_INDEX2()[i]);
				vo.setSETTING_PRESET_PROCESS_WORKTIME(vo.getSETTING_PRESET_PROCESS_WORKTIME2()[i]);
				
				vo.setSETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_REGISTER(vo.getSETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_REGISTER2()[i]);
				
				
				String InCodingSETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY = new String(vo.getSETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY2()[i].getBytes("8859_1"), "UTF-8");

				
				vo.setSETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY(InCodingSETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY);
				vo.setSETTING_PRESET_PROCESS_OUTSOURCING_REGISTER(vo.getSETTING_PRESET_PROCESS_OUTSOURCING_REGISTER2()[i]);

				//자주검사 전체 체크 추가
				vo.setSETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_CHECK(vo.getSETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_CHECK2()[i]);
				
				if(vo.getSETTING_PRESET_PROCESS_OUTSOURCING_REGISTER2()[i] == 0) {
					vo.setSETTING_PRESET_PROCESS_CUSTOMER_NAME(null);
					vo.setSETTING_PRESET_PROCESS_CUSTOMER_NUMBER(null);
				}else if(vo.getSETTING_PRESET_PROCESS_OUTSOURCING_REGISTER2()[i] == 1) {
					String InCodingSETTING_PRESET_PROCESS_CUSTOMER_NAME2 = new String(vo.getSETTING_PRESET_PROCESS_CUSTOMER_NAME2()[i].getBytes("8859_1"), "UTF-8");
					String InCodingSETTING_PRESET_PROCESS_CUSTOMER_NUMBER2 = new String(vo.getSETTING_PRESET_PROCESS_CUSTOMER_NUMBER2()[i].getBytes("8859_1"), "UTF-8");
					vo.setSETTING_PRESET_PROCESS_CUSTOMER_NAME(InCodingSETTING_PRESET_PROCESS_CUSTOMER_NAME2);
					vo.setSETTING_PRESET_PROCESS_CUSTOMER_NUMBER(InCodingSETTING_PRESET_PROCESS_CUSTOMER_NUMBER2);
				}

				service.RegisterSettingPresetProcess(vo);
				
	
				int preset_process_key = vo.SETTING_PRESET_PROCESS_ID;
	
				PresetProcessList.add(preset_process_key);
				
			}
			
			for(int i = 0; i< PresetProcessList.size(); i++) {
				
				for(int j = 0; j < vo.getORIGIN_UNIQUESS_ID3()[i].length; j++) {
					
					vo.setSETTING_PRESET_PROCESS_ID(PresetProcessList.get(i));
					vo.setORIGIN_UNIQUESS_ID(vo.getORIGIN_UNIQUESS_ID3()[i][j]);
					
					service.RegisterSettingPresetUniquess(vo);
				}
				
			}

			JsonObject obj = new JsonObject();
			
			obj.addProperty("Preset_overlap", 0);
			
			return obj.toString();
			
		}
		
	}
	
	/*
	@RequestMapping(value = "/RegisterSettingPreset", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public void RegisterSettingPreset(@RequestBody SettingpresetVO vo, @RequestParam("PROCESS_MAIN_CATEGORY_NAME") String PROCESS_MAIN_CATEGORY_NAME) throws Exception {
		
		logger.info("Register SettingPreset");
		
		int result1 = service.AdminChk(vo);
		int result2 = service.IdEmpStatusChk(vo);
		int result3 = service.PresetNameChk(vo);
		
		if (result3 >= 1) {
			throw new SettingPresetPresetNameChkException();
		} else {
			if (result1 == 2 && result2 == 1) {
				
				
				//1. 프리셋 큰거 먼저 만들고
				service.RegisterSettingPreset(vo);
				
				//만들어진 프리셋 ID
				int result = service.FindSettingPresetID(vo);
				
				
				ArrayList<Integer> recently = new ArrayList<Integer>();
				
				
				
				for (int i = 0; i < vo.getSETTING_PRESET_PROCESS_INDEX2().length; i++) {
					
					vo.setORIGIN_PROCESS_ID(vo.getORIGIN_PROCESS_ID2()[i]);
					vo.setSETTING_PRESET_ID(result);
					vo.setSETTING_PRESET_PROCESS_INDEX(vo.getSETTING_PRESET_PROCESS_INDEX2()[i]);
					
					service.RegisterSettingPresetProcess(vo);
					
					//System.out.println(vo.getSETTING_PRESET_PROCESS_ID());
					//System.out.println(vo.SETTING_PRESET_PROCESS_ID);
					
					//sql @@Identify 생성해서 만들어진 리스트에 추가 
					recently.add(vo.SETTING_PRESET_PROCESS_ID);
					//System.out.println(vo.SETTING_PRESET_PROCESS_ID);
					
					//여기서 만들어진거 찾아보고 2번째 컬럼에 처박고 3번째 컬럼에는 
					
				}
				
				//이 I는 프리셋 공정이 만들어진 키 갯수
				for (int i = 0; i < recently.size(); i++) {
					
					
					//프리셋 공정 당 작업 특이사항 입력 소스
					
					for (int jj = 0; jj < vo.getORIGIN_UNIQUESS_ID3()[i].length; jj++) {
							
							if (!(vo.getORIGIN_UNIQUESS_ID3()[i][jj] == null)) {
								

								vo.setSETTING_PRESET_PROCESS_ID(recently.get(i));
								vo.setORIGIN_UNIQUESS_ID(vo.getORIGIN_UNIQUESS_ID3()[i][jj]);
								service.RegisterSettingPresetUniquess(vo);
							} 
					}
					
					int a = vo.getSETTING_PRESET_PROCESS_WORKTIME_MIN2()[i];
					
					vo.setSETTING_PRESET_PROCESS_WORKTIME_MIN(a);
					vo.setSETTING_PRESET_PROCESS_ID(recently.get(i));
					
					//기준시간 서비스 부분
					service.RegisterSettingPresetWorktime(vo);
	
				}
				
			} else {
				throw new SettingPresetRegisterException();
			}
		}
		
	}
	*/
	
	@RequestMapping(value = "/RegisterSettingPresetProcess", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String RegisterSettingPresetProcess(SettingpresetVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "RegisterSettingPresetProcess");
		
		ArrayList<Integer> PresetProcessList = new ArrayList<Integer>();
		
		try {
			
			for(int i = 0; i < vo.getSETTING_PRESET_PROCESS_INDEX2().length; i++) {
				
				vo.setORIGIN_PROCESS_ID(vo.getORIGIN_PROCESS_ID2()[i]);
				vo.setSETTING_PRESET_ID(vo.getSETTING_PRESET_ID2()[i]);
				vo.setSETTING_PRESET_PROCESS_INDEX(vo.getSETTING_PRESET_PROCESS_INDEX2()[i]);
				vo.setSETTING_PRESET_PROCESS_WORKTIME(vo.getSETTING_PRESET_PROCESS_WORKTIME2()[i]);
				vo.setSETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_REGISTER(vo.getSETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_REGISTER2()[i]);
				
				String InCodingSETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY = new String(vo.getSETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY2()[i].getBytes("8859_1"), "UTF-8");
				
				vo.setSETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY(InCodingSETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY);
				
				vo.setSETTING_PRESET_PROCESS_OUTSOURCING_REGISTER(vo.getSETTING_PRESET_PROCESS_OUTSOURCING_REGISTER2()[i]);
				
				vo.setSETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_CHECK(vo.getSETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_CHECK2()[i]);
				
				if(vo.getSETTING_PRESET_PROCESS_OUTSOURCING_REGISTER2()[i] == 0) {
					vo.setSETTING_PRESET_PROCESS_CUSTOMER_NAME(null);
					vo.setSETTING_PRESET_PROCESS_CUSTOMER_NUMBER(null);
				}else {
					String InCodingSETTING_PRESET_PROCESS_CUSTOMER_NAME2 = new String(vo.getSETTING_PRESET_PROCESS_CUSTOMER_NAME2()[i].getBytes("8859_1"), "UTF-8");
					String InCodingSETTING_PRESET_PROCESS_CUSTOMER_NUMBER2 = new String(vo.getSETTING_PRESET_PROCESS_CUSTOMER_NUMBER2()[i].getBytes("8859_1"), "UTF-8");
					vo.setSETTING_PRESET_PROCESS_CUSTOMER_NAME(InCodingSETTING_PRESET_PROCESS_CUSTOMER_NAME2);
					vo.setSETTING_PRESET_PROCESS_CUSTOMER_NUMBER(InCodingSETTING_PRESET_PROCESS_CUSTOMER_NUMBER2);				
				}
				
				service.RegisterSettingPresetProcess(vo);
				
				int preset_process_key = vo.SETTING_PRESET_PROCESS_ID;
				
				PresetProcessList.add(preset_process_key);
				
			}
			
			for(int i = 0; i< PresetProcessList.size(); i++) {
				
				for(int j = 0; j < vo.getORIGIN_UNIQUESS_ID3()[i].length; j++) {
					
					vo.setSETTING_PRESET_PROCESS_ID(PresetProcessList.get(i));
					vo.setORIGIN_UNIQUESS_ID(vo.getORIGIN_UNIQUESS_ID3()[i][j]);
					
					service.RegisterSettingPresetUniquess(vo);
				}
			}
			
			JsonObject obj = new JsonObject();

			obj.addProperty("RegisterSettingPresetProcess", 1);

			return obj.toString();
			
		} catch(Exception e) {
			
			JsonObject obj = new JsonObject();

			obj.addProperty("RegisterSettingPresetProcess", 0);

			return obj.toString();
			
		}
		
		

		
	}
	
	@RequestMapping(value = "/MultiPresetSelect", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<SettingpresetVO> MultiPresetSelect(@RequestBody SettingpresetVO vo) throws Exception {

		List<SettingpresetVO> a = service.MultiPresetSelect(vo);
		
		System.out.println(a);
		
		return service.MultiPresetSelect(vo);
		
	}
	
	@RequestMapping(value = "/CopySettingPresetNameLoad", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String CopySettingPresetNameLoad(@RequestBody SettingpresetVO vo) throws Exception {
		
		String result = service.CopySettingPresetNameLoad(vo);
		return result;
	}
	
	//세팅 프리셋 파일 관련
	@RequestMapping(value = "/SelectPresetFile", method = RequestMethod.POST)
	public List<SettingpresetVO> SelectPresetFile(@RequestBody SettingpresetVO vo) throws Exception {
		
		List<SettingpresetVO> resultfileList = service.SelectPresetFile(vo);
		return resultfileList;
	}

	@RequestMapping(value = "/DeletePresetFile", method = RequestMethod.POST) 
	public String DeletePresetFile(@RequestBody SettingpresetVO vo) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "DeletePresetFile");
		
		try {
			
			for(int i = 0; i < vo.getSETTING_PRESET_ID2().length; i++) {
				
				vo.setSETTING_PRESET_ID(vo.getSETTING_PRESET_ID2()[i]);
				vo.setSETTING_PRESET_FILE_MANAGEMENT_ID(vo.getSETTING_PRESET_FILE_MANAGEMENT_ID2()[i]);
				
				String FindDirectory = service.OneFindFileDirectory(vo);
				
				File file = new File(FindDirectory);
				
				if(file.exists()) {
					if(file.isDirectory()) {
						
						File[] files = file.listFiles();
						
						for(int j = 0; j < files.length; j++) {
							
							if(files[j].delete()) {
								
								System.out.println(files[j].getName()+" 삭제성공"); 
								
							} else {
								
								System.out.println(files[j].getName()+" 삭제실패");
							}
						}
	 				}
					if(file.delete()) {
						
						System.out.println("파일 삭제 성공");
						
					}else {
						
						System.out.println("파일 삭제 실패");
						
					}
					
					System.out.println("파일이 존재하지 않음");
				}
				
				vo.setSETTING_PRESET_ID(vo.getSETTING_PRESET_ID2()[i]);
				
				service.DeletePresetFile(vo);
			}
			
			JsonObject obj = new JsonObject();

			obj.addProperty("DeletePresetFile", 1);

			return obj.toString();
			
		} catch (Exception e) {
			
			JsonObject obj = new JsonObject();

			obj.addProperty("DeletePresetFile", 0);

			return obj.toString();
		}
		

	}
	
	@RequestMapping(value = "/AllDeletePresetFile", method = RequestMethod.POST)
	public void AllDeletePresetFile(SettingpresetVO vo) throws Exception {
		
		service.AllDeletePresetFile(vo);
	}
	

	@RequestMapping(value = "/CopySettingPreset", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String CopySettingPreset(@RequestBody SettingpresetVO vo) throws Exception  {

		logger.info("CopySettingPreset");

		ArrayList<Integer> CopyPresetIdList = new ArrayList<Integer>();
		
		try {
			
			
			//원래 원본 복사할거 이름 가져오고
			String firstname = service.CopySettingPresetNameLoad(vo);

			//끝자리
			String endname = firstname.substring(firstname.length()-1, firstname.length());

			//복사 + 끝자리에 숫자가 동시에 있을 경우
			if(firstname.contains("_복사_") && endname.matches(".*[0-9].*")) {

				int i = 0;
				
				while (true) {
					
					i++;
					
					//끝자리를 제외한 나머지
					String firstline = firstname.substring(0, firstname.indexOf("_")+4);
					
					//끝자리
					String numline = firstname.substring(firstname.indexOf("_")+4, firstname.length());
					
					//끝자리 문자 -> 숫자 변환
					int lastline = Integer.parseInt(numline);
					
					//끝자리 숫자 더하고 문자로 변환
					int sum = lastline+i;
					
					//다시 숫자 변환
					String sum2 = Integer.toString(sum);
					
					
					//그리고 자른 앞자리랑 합친 숫자 증가 문자열
					String total = firstline + sum2;
					
					//세트시킴
					vo.setSETTING_PRESET_NAME(total);
					
					int result = service.PresetNameChk(vo);
					
					if(result > 0) {
						
						continue;
						
					}else {
						
						//복사 집어넣어서 아이디 생성완료 됬음 -> 명칭으로 아이디 찾았음 -> 처음에 입력한 SETTING기준으로 조회문을 돌렷고, 
						//복사 집어넣는거 실행하고
						//틀에 있는거부터 복사했고 만들었다. -> 
						
						service.CopySettingPreset(vo);
						
						int CopyPresetId = vo.CopyPresetId; 
						
						CopyPresetIdList.add(CopyPresetId);
											
						Thread.sleep(100);
						
						//명칭을 기준으로 복사하어 생겨진 프리셋ID
						int IdchkNum = service.FindSettingPresetID(vo);
					
						//복사하려고 한 프리셋 ID
						int origin_id = vo.getSETTING_PRESET_ID();
								
						//이게 실제 받은 복사해야할 참조 프리셋 아이디
						vo.setSETTING_PRESET_ID(vo.getSETTING_PRESET_ID());
						
						//복사 해야될 거
						List<SettingpresetVO> realList = service.PresetProcessList(vo);
						
						ArrayList<Integer> NewSSP_ID = new ArrayList<Integer>();
						
						for(int j = 0; j < realList.size(); j++) {
							
							int SPP_ID = realList.get(j).ORIGIN_PROCESS_ID;
							int SPP_INDEX = realList.get(j).SETTING_PRESET_PROCESS_INDEX;
							float SPP_WORKTIME = realList.get(j).SETTING_PRESET_PROCESS_WORKTIME;
							int SPP_INSPECTION_REPORT_REGISTER = realList.get(j).SETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_REGISTER;
							String SPP_SETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY = realList.get(j).SETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY;
							int SPP_SETTING_PRESET_PROCESS_OUTSOURCING_REGISTER = realList.get(j).SETTING_PRESET_PROCESS_OUTSOURCING_REGISTER;
							String SPP_SETTING_PRESET_PROCESS_CUSTOMER_NAME = realList.get(j).SETTING_PRESET_PROCESS_CUSTOMER_NAME;
							String SPP_SETTING_PRESET_PROCESS_CUSTOMER_NUMBER = realList.get(j).SETTING_PRESET_PROCESS_CUSTOMER_NUMBER;
							
							
							vo.setSETTING_PRESET_ID(IdchkNum);
							vo.setORIGIN_PROCESS_ID(SPP_ID);
							vo.setSETTING_PRESET_PROCESS_INDEX(SPP_INDEX);
							vo.setSETTING_PRESET_PROCESS_WORKTIME(SPP_WORKTIME);
							vo.setSETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_REGISTER(SPP_INSPECTION_REPORT_REGISTER);
							vo.setSETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY(SPP_SETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY);
							vo.setSETTING_PRESET_PROCESS_OUTSOURCING_REGISTER(SPP_SETTING_PRESET_PROCESS_OUTSOURCING_REGISTER);
							vo.setSETTING_PRESET_PROCESS_CUSTOMER_NAME(SPP_SETTING_PRESET_PROCESS_CUSTOMER_NAME);
							vo.setSETTING_PRESET_PROCESS_CUSTOMER_NUMBER(SPP_SETTING_PRESET_PROCESS_CUSTOMER_NUMBER);
							
							
							//새로 복사한걸 프리셋 공정 넣기
							service.RegisterSettingPresetProcess(vo);
							
							//새로 생긴 공정키
							int NEW_SSP_ID = vo.SETTING_PRESET_PROCESS_ID;
							
							int ORIGIN_SPP_ID = realList.get(j).SETTING_PRESET_PROCESS_ID;
							
							vo.setSETTING_PRESET_PROCESS_ID(ORIGIN_SPP_ID);
							
							List<SettingpresetVO> uniquesslist = service.DetailPresetUniquessView2(vo);
							
							for(int jj = 0; jj < uniquesslist.size(); jj++) {
								
								int ORG_U_ID = uniquesslist.get(jj).ORIGIN_UNIQUESS_ID;
								
								vo.setSETTING_PRESET_PROCESS_ID(NEW_SSP_ID);
								vo.setORIGIN_UNIQUESS_ID(ORG_U_ID);
								
								service.RegisterSettingPresetUniquess(vo);
								
							}
							
						}
						
						
						vo.setSETTING_PRESET_ID(origin_id);

						List<SettingpresetVO> resultfileList = service.SelectPresetFile(vo);

						for(int j = 0; j < resultfileList.size(); j++) {
							
							SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");
							
							Date time = new Date();

							String time1 = format1.format(time);
							
							//C로 디렉 변경
							
							String copyFilePath = ("C:\\Html\\factory\\admin\\preset\\");
							
							String dbpath = ("http://182.208.252.210:5995/factory/admin/preset/");
							
							String dbrealpath = dbpath+time1;
							
							int SPP_F_T_ID = resultfileList.get(j).JOBORDER_FILE_TYPE_ID;
							
							String originalFileName = resultfileList.get(j).SETTING_PRESET_FILE_MANAGEMENT_NAME;
							String originalFilePath = resultfileList.get(j).SETTING_PRESET_FILE_MANAGEMENT_DIRECTORY;
							
							String realpath = copyFilePath+time1;
							
							//시간폴더 생성
							File folder = new File(realpath);
							
							
							folder.mkdirs();
							
							String lastPath = realpath+"\\"+originalFileName;
							
							String dbsavepath = dbrealpath+"/"+originalFileName;
							
							System.out.println("실제 카피 저장될 경로 : "+lastPath);
							
							File oriFile = new File(originalFilePath);
							
							File copyFile = new File(lastPath);
							
							try {
								FileInputStream fis = new FileInputStream(oriFile);
								
								FileOutputStream fos = new FileOutputStream(lastPath);
								
								int fileByte = 0;
								
								while((fileByte = fis.read()) != -1) {
									fos.write(fileByte);
								}
								fis.close();
								fos.close();
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}
							
							vo.setSETTING_PRESET_ID(IdchkNum);
							vo.setJOBORDER_FILE_TYPE_ID(SPP_F_T_ID);
							vo.setSETTING_PRESET_FILE_MANAGEMENT_NAME(originalFileName);
							vo.setSETTING_PRESET_FILE_MANAGEMENT_DIRECTORY(lastPath);
							vo.setSETTING_PRESET_FILE_MANAGEMENT_DB_DIRECTORY(dbsavepath);
							
							service.PresetFileUpload(vo);

						}

						break;
					}
					
				}

			}

			//복사가 있고 끝자리가 숫자가 아닐 경우
			if (firstname.contains("_복사_") && !endname.matches(".*[0-9].*")) {
				
				int i = 0;
		
				while (true) {
					
					i++;
					
					String sum2 = Integer.toString(i);
					String copyname = firstname+sum2;

					vo.setSETTING_PRESET_NAME(copyname);
					
					int result = service.PresetNameChk(vo);
					
					if (result > 0) {
						continue;
					}else {
						
						//복사 집어넣어서 아이디 생성완료 됬음 -> 명칭으로 아이디 찾았음 -> 처음에 입력한 SETTING기준으로 조회문을 돌렷고, 
						//복사 집어넣는거 실행하고
						//틀에 있는거부터 복사했고 만들었다. -> 
						service.CopySettingPreset(vo);
						
						int CopyPresetId = vo.CopyPresetId; 
						
						CopyPresetIdList.add(CopyPresetId);
												
						Thread.sleep(100);
						
						//명칭을 기준으로 복사하어 생겨진 프리셋ID
						int IdchkNum = service.FindSettingPresetID(vo);
											
						int origin_id = vo.getSETTING_PRESET_ID();

						
						vo.setSETTING_PRESET_ID(vo.getSETTING_PRESET_ID());
						
						List<SettingpresetVO> realList = service.PresetProcessList(vo);
						
						ArrayList<Integer> NewSSP_ID = new ArrayList<Integer>();
						
						for(int j = 0; j < realList.size(); j++) {
							
							int SPP_ID = realList.get(j).ORIGIN_PROCESS_ID;
							int SPP_INDEX = realList.get(j).SETTING_PRESET_PROCESS_INDEX;
							float SPP_WORKTIME = realList.get(j).SETTING_PRESET_PROCESS_WORKTIME;
							int SPP_INSPECTION_REPORT_REGISTER = realList.get(j).SETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_REGISTER;
							String SPP_SETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY = realList.get(j).SETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY;
							int SPP_SETTING_PRESET_PROCESS_OUTSOURCING_REGISTER = realList.get(j).SETTING_PRESET_PROCESS_OUTSOURCING_REGISTER;
							String SPP_SETTING_PRESET_PROCESS_CUSTOMER_NAME = realList.get(j).SETTING_PRESET_PROCESS_CUSTOMER_NAME;
							String SPP_SETTING_PRESET_PROCESS_CUSTOMER_NUMBER = realList.get(j).SETTING_PRESET_PROCESS_CUSTOMER_NUMBER;
														
							vo.setSETTING_PRESET_ID(IdchkNum);
							vo.setORIGIN_PROCESS_ID(SPP_ID);
							vo.setSETTING_PRESET_PROCESS_INDEX(SPP_INDEX);
							vo.setSETTING_PRESET_PROCESS_WORKTIME(SPP_WORKTIME);
							vo.setSETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_REGISTER(SPP_INSPECTION_REPORT_REGISTER);
							vo.setSETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY(SPP_SETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY);
							vo.setSETTING_PRESET_PROCESS_OUTSOURCING_REGISTER(SPP_SETTING_PRESET_PROCESS_OUTSOURCING_REGISTER);
							vo.setSETTING_PRESET_PROCESS_CUSTOMER_NAME(SPP_SETTING_PRESET_PROCESS_CUSTOMER_NAME);
							vo.setSETTING_PRESET_PROCESS_CUSTOMER_NUMBER(SPP_SETTING_PRESET_PROCESS_CUSTOMER_NUMBER);
							

							//새로 복사한걸 프리셋 공정 넣기
							service.RegisterSettingPresetProcess(vo);
							
							//새로 생긴 공정키
							int NEW_SSP_ID = vo.SETTING_PRESET_PROCESS_ID;
							
							int ORIGIN_SPP_ID = realList.get(j).SETTING_PRESET_PROCESS_ID;
							
							vo.setSETTING_PRESET_PROCESS_ID(ORIGIN_SPP_ID);
							
							List<SettingpresetVO> uniquesslist = service.DetailPresetUniquessView2(vo);
							
							for(int jj = 0; jj < uniquesslist.size(); jj++) {
								
								int ORG_U_ID = uniquesslist.get(jj).ORIGIN_UNIQUESS_ID;
								
								vo.setSETTING_PRESET_PROCESS_ID(NEW_SSP_ID);
								vo.setORIGIN_UNIQUESS_ID(ORG_U_ID);
								
								service.RegisterSettingPresetUniquess(vo);
								
							}
							
						}

						vo.setSETTING_PRESET_ID(origin_id);
						
						List<SettingpresetVO> resultfileList = service.SelectPresetFile(vo);
						
						for(int j = 0; j < resultfileList.size(); j++) {
							
							SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");
							
							Date time = new Date();

							String time1 = format1.format(time);
							
							//C로 디렉 변경
							
							String copyFilePath = ("C:\\Html\\factory\\admin\\preset\\");
							
							String dbpath = ("http://182.208.252.210:5995/factory/admin/preset/");
							
							String dbrealpath = dbpath+time1;
							
							int SPP_F_T_ID = resultfileList.get(j).JOBORDER_FILE_TYPE_ID;
							
							String originalFileName = resultfileList.get(j).SETTING_PRESET_FILE_MANAGEMENT_NAME;
							String originalFilePath = resultfileList.get(j).SETTING_PRESET_FILE_MANAGEMENT_DIRECTORY;
							
							String realpath = copyFilePath+time1;
							
							//시간폴더 생성
							File folder = new File(realpath);
							
							
							folder.mkdirs();
							
							String lastPath = realpath+"\\"+originalFileName;
							
							String dbsavepath = dbrealpath+"/"+originalFileName; 
							
							//System.out.println("실제 카피 저장될 경로 : "+lastPath);
							
							File oriFile = new File(originalFilePath);
							
							File copyFile = new File(lastPath);
							
							try {
								FileInputStream fis = new FileInputStream(oriFile);
								
								FileOutputStream fos = new FileOutputStream(lastPath);
								
								int fileByte = 0;
								
								while((fileByte = fis.read()) != -1) {
									fos.write(fileByte);
								}
								fis.close();
								fos.close();
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}
							
							vo.setSETTING_PRESET_ID(IdchkNum);
							vo.setJOBORDER_FILE_TYPE_ID(SPP_F_T_ID);
							vo.setSETTING_PRESET_FILE_MANAGEMENT_NAME(originalFileName);
							vo.setSETTING_PRESET_FILE_MANAGEMENT_DIRECTORY(lastPath);
							vo.setSETTING_PRESET_FILE_MANAGEMENT_DB_DIRECTORY(dbsavepath);
							
							service.PresetFileUpload(vo);
						}
						
						break;
					}
				}

			}
				
				//복사도 이름에 포함안된 경우
			if (!firstname.contains("_복사_")) {
				
				String copyname = firstname+"_복사_";
					
				vo.setSETTING_PRESET_NAME(copyname);
				
				//이름이 같은지 중복을 체크하고
				int result = service.PresetNameChk(vo);
				
				
				if (result >= 1) {
					
					int i = 0;
					
					while (true) {
						
						i++;
						
						String sum2 = Integer.toString(i);
						
						String total = copyname+sum2;
						
						vo.setSETTING_PRESET_NAME(total);

						int result2 = service.PresetNameChk(vo);
						
						if(result2 > 0) {
							continue;
						}else {

							//복사 집어넣어서 아이디 생성완료 됬음 -> 명칭으로 아이디 찾았음 -> 처음에 입력한 SETTING기준으로 조회문을 돌렷고, 
							//복사 집어넣는거 실행하고
							//틀에 있는거부터 복사했고 만들었다. -> 
							service.CopySettingPreset(vo);
							
							int CopyPresetId = vo.CopyPresetId; 
							
							CopyPresetIdList.add(CopyPresetId);
							
							Thread.sleep(100);
			
							//명칭을 기준으로 복사하어 생겨진 프리셋ID
							int IdchkNum = service.FindSettingPresetID(vo);
							
							//원래 번호임 이게 복사하려던거
							int origin_id = vo.getSETTING_PRESET_ID();
							
							//원래 번호있던걸로 공정번호, 순서 카피위한 조회임
							
							vo.setSETTING_PRESET_ID(vo.getSETTING_PRESET_ID());

							//복사 해야될 거
							List<SettingpresetVO> realList = service.PresetProcessList(vo);
							
							ArrayList<Integer> NewSSP_ID = new ArrayList<Integer>();
							
							for(int j = 0; j < realList.size(); j++) {
								
								int SPP_ID = realList.get(j).ORIGIN_PROCESS_ID;
								int SPP_INDEX = realList.get(j).SETTING_PRESET_PROCESS_INDEX;
								float SPP_WORKTIME = realList.get(j).SETTING_PRESET_PROCESS_WORKTIME;
								int SPP_INSPECTION_REPORT_REGISTER = realList.get(j).SETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_REGISTER;
								String SPP_SETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY = realList.get(j).SETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY;
								int SPP_SETTING_PRESET_PROCESS_OUTSOURCING_REGISTER = realList.get(j).SETTING_PRESET_PROCESS_OUTSOURCING_REGISTER;
								String SPP_SETTING_PRESET_PROCESS_CUSTOMER_NAME = realList.get(j).SETTING_PRESET_PROCESS_CUSTOMER_NAME;
								String SPP_SETTING_PRESET_PROCESS_CUSTOMER_NUMBER = realList.get(j).SETTING_PRESET_PROCESS_CUSTOMER_NUMBER;
								
								
								vo.setSETTING_PRESET_ID(IdchkNum);
								vo.setORIGIN_PROCESS_ID(SPP_ID);
								vo.setSETTING_PRESET_PROCESS_INDEX(SPP_INDEX);
								vo.setSETTING_PRESET_PROCESS_WORKTIME(SPP_WORKTIME);
								vo.setSETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_REGISTER(SPP_INSPECTION_REPORT_REGISTER);
								vo.setSETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY(SPP_SETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY);
								vo.setSETTING_PRESET_PROCESS_OUTSOURCING_REGISTER(SPP_SETTING_PRESET_PROCESS_OUTSOURCING_REGISTER);
								vo.setSETTING_PRESET_PROCESS_CUSTOMER_NAME(SPP_SETTING_PRESET_PROCESS_CUSTOMER_NAME);
								vo.setSETTING_PRESET_PROCESS_CUSTOMER_NUMBER(SPP_SETTING_PRESET_PROCESS_CUSTOMER_NUMBER);
								

								//새로 복사한걸 프리셋 공정 넣기
								service.RegisterSettingPresetProcess(vo);
								
								//새로 생긴 공정키
								int NEW_SSP_ID = vo.SETTING_PRESET_PROCESS_ID;
								
								int ORIGIN_SPP_ID = realList.get(j).SETTING_PRESET_PROCESS_ID;
								
								vo.setSETTING_PRESET_PROCESS_ID(ORIGIN_SPP_ID);
								
								List<SettingpresetVO> uniquesslist = service.DetailPresetUniquessView2(vo);
								
								for(int jj = 0; jj < uniquesslist.size(); jj++) {
									
									int ORG_U_ID = uniquesslist.get(jj).ORIGIN_UNIQUESS_ID;
									
									vo.setSETTING_PRESET_PROCESS_ID(NEW_SSP_ID);
									vo.setORIGIN_UNIQUESS_ID(ORG_U_ID);
									
									service.RegisterSettingPresetUniquess(vo);
									
								}
								
							}
							
							vo.setSETTING_PRESET_ID(origin_id);
							
							List<SettingpresetVO> resultfileList = service.SelectPresetFile(vo);

							
							for(int j = 0; j < resultfileList.size(); j++) {
								
								SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");
								
								Date time = new Date();

								String time1 = format1.format(time);
								
								//C로 디렉 변경
								
								String copyFilePath = ("C:\\Html\\factory\\admin\\preset\\");
								
								String dbpath = ("http://182.208.252.210:5995/factory/admin/preset/");
								
								String dbrealpath = dbpath+time1;
								
								int SPP_F_T_ID = resultfileList.get(j).JOBORDER_FILE_TYPE_ID;
								
								String originalFileName = resultfileList.get(j).SETTING_PRESET_FILE_MANAGEMENT_NAME;
								String originalFilePath = resultfileList.get(j).SETTING_PRESET_FILE_MANAGEMENT_DIRECTORY;
								
								String realpath = copyFilePath+time1;
								
								//시간폴더 생성
								File folder = new File(realpath);
								
								
								folder.mkdirs();
								
								String lastPath = realpath+"\\"+originalFileName;
								
								String dbsavepath = dbrealpath+"/"+originalFileName;
								
								//System.out.println("실제 카피 저장될 경로 : "+lastPath);
								
								File oriFile = new File(originalFilePath);
								
								File copyFile = new File(lastPath);
								
								try {
									FileInputStream fis = new FileInputStream(oriFile);
									
									FileOutputStream fos = new FileOutputStream(lastPath);
									
									int fileByte = 0;
									
									while((fileByte = fis.read()) != -1) {
										fos.write(fileByte);
									}
									fis.close();
									fos.close();
								} catch (FileNotFoundException e) {
									e.printStackTrace();
								}
								
								vo.setSETTING_PRESET_ID(IdchkNum);
								vo.setJOBORDER_FILE_TYPE_ID(SPP_F_T_ID);
								vo.setSETTING_PRESET_FILE_MANAGEMENT_NAME(originalFileName);
								vo.setSETTING_PRESET_FILE_MANAGEMENT_DIRECTORY(lastPath);
								vo.setSETTING_PRESET_FILE_MANAGEMENT_DB_DIRECTORY(dbsavepath);
								
								service.PresetFileUpload(vo);

							}
							
							
							break;
							
						}
					}
				}else {
					
					service.CopySettingPreset(vo);
					
					int CopyPresetId = vo.CopyPresetId; 
					
					CopyPresetIdList.add(CopyPresetId);
					
					Thread.sleep(100);
					
					//명칭을 기준으로 복사하어 생겨진 프리셋ID
					int IdchkNum = service.FindSettingPresetID(vo);
					
					int origin_id = vo.getSETTING_PRESET_ID();
					
					vo.setSETTING_PRESET_ID(vo.getSETTING_PRESET_ID());
					
					//복사 해야될 거
					List<SettingpresetVO> realList = service.PresetProcessList(vo);
					
					ArrayList<Integer> NewSSP_ID = new ArrayList<Integer>();
					
					for(int j = 0; j < realList.size(); j++) {
						
						int SPP_ID = realList.get(j).ORIGIN_PROCESS_ID;
						int SPP_INDEX = realList.get(j).SETTING_PRESET_PROCESS_INDEX;
						float SPP_WORKTIME = realList.get(j).SETTING_PRESET_PROCESS_WORKTIME;
						int SPP_INSPECTION_REPORT_REGISTER = realList.get(j).SETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_REGISTER;
						String SPP_SETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY = realList.get(j).SETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY;
						int SPP_SETTING_PRESET_PROCESS_OUTSOURCING_REGISTER = realList.get(j).SETTING_PRESET_PROCESS_OUTSOURCING_REGISTER;
						String SPP_SETTING_PRESET_PROCESS_CUSTOMER_NAME = realList.get(j).SETTING_PRESET_PROCESS_CUSTOMER_NAME;
						String SPP_SETTING_PRESET_PROCESS_CUSTOMER_NUMBER = realList.get(j).SETTING_PRESET_PROCESS_CUSTOMER_NUMBER;
											
						vo.setSETTING_PRESET_ID(IdchkNum);
						vo.setORIGIN_PROCESS_ID(SPP_ID);
						vo.setSETTING_PRESET_PROCESS_INDEX(SPP_INDEX);
						vo.setSETTING_PRESET_PROCESS_WORKTIME(SPP_WORKTIME);
						vo.setSETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_REGISTER(SPP_INSPECTION_REPORT_REGISTER);
						vo.setSETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY(SPP_SETTING_PRESET_PROCESS_SELF_INSPECTION_REPORT_DIRECTORY);
						vo.setSETTING_PRESET_PROCESS_OUTSOURCING_REGISTER(SPP_SETTING_PRESET_PROCESS_OUTSOURCING_REGISTER);
						vo.setSETTING_PRESET_PROCESS_CUSTOMER_NAME(SPP_SETTING_PRESET_PROCESS_CUSTOMER_NAME);
						vo.setSETTING_PRESET_PROCESS_CUSTOMER_NUMBER(SPP_SETTING_PRESET_PROCESS_CUSTOMER_NUMBER);
						

						//새로 복사한걸 프리셋 공정 넣기
						service.RegisterSettingPresetProcess(vo);
						
						//새로 생긴 공정키
						int NEW_SSP_ID = vo.SETTING_PRESET_PROCESS_ID;
						
						int ORIGIN_SPP_ID = realList.get(j).SETTING_PRESET_PROCESS_ID;
						
						vo.setSETTING_PRESET_PROCESS_ID(ORIGIN_SPP_ID);
						
						List<SettingpresetVO> uniquesslist = service.DetailPresetUniquessView2(vo);
						
						for(int jj = 0; jj < uniquesslist.size(); jj++) {
							
							int ORG_U_ID = uniquesslist.get(jj).ORIGIN_UNIQUESS_ID;
							
							vo.setSETTING_PRESET_PROCESS_ID(NEW_SSP_ID);
							vo.setORIGIN_UNIQUESS_ID(ORG_U_ID);
							
							service.RegisterSettingPresetUniquess(vo);
							
						}
						
					}
					

					vo.setSETTING_PRESET_ID(origin_id);
					
					List<SettingpresetVO> resultfileList = service.SelectPresetFile(vo);
					
					for(int j = 0; j < resultfileList.size(); j++) {
						
						SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");
						
						Date time = new Date();

						String time1 = format1.format(time);
						
						//C로 디렉 변경
						
						String copyFilePath = ("C:\\Html\\factory\\admin\\preset\\");
						
						String dbpath = ("http://182.208.252.210:5995/factory/admin/preset/");
						
						String dbrealpath = dbpath+time1;
						
						int SPP_F_T_ID = resultfileList.get(j).JOBORDER_FILE_TYPE_ID;
						
						String originalFileName = resultfileList.get(j).SETTING_PRESET_FILE_MANAGEMENT_NAME;
						String originalFilePath = resultfileList.get(j).SETTING_PRESET_FILE_MANAGEMENT_DIRECTORY;
						
						String realpath = copyFilePath+time1;
						
						//시간폴더 생성
						File folder = new File(realpath);
						
						
						folder.mkdirs();
						
						String lastPath = realpath+"\\"+originalFileName;
						
						String dbsavepath = dbrealpath+"/"+originalFileName;
						
						//System.out.println("실제 카피 저장될 경로 : "+lastPath);
						
						File oriFile = new File(originalFilePath);
						
						File copyFile = new File(lastPath);
						
						try {
							FileInputStream fis = new FileInputStream(oriFile);
							
							FileOutputStream fos = new FileOutputStream(lastPath);
							
							int fileByte = 0;
							
							while((fileByte = fis.read()) != -1) {
								fos.write(fileByte);
							}
							fis.close();
							fos.close();
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
						
						vo.setSETTING_PRESET_ID(IdchkNum);
						vo.setJOBORDER_FILE_TYPE_ID(SPP_F_T_ID);
						vo.setSETTING_PRESET_FILE_MANAGEMENT_NAME(originalFileName);
						vo.setSETTING_PRESET_FILE_MANAGEMENT_DIRECTORY(lastPath);
						vo.setSETTING_PRESET_FILE_MANAGEMENT_DB_DIRECTORY(dbsavepath);
						
						
						service.PresetFileUpload(vo);
						

					}

				}
					
			} 
		} catch (Exception e) {
			throw new SettingPresetCopyException();
		}
		

		JsonObject obj = new JsonObject();
		
		obj.addProperty("CopyPresetId", CopyPresetIdList.get(0).toString());
		
		return obj.toString();
		
	}

	
	
	@RequestMapping(value = "PresetNameChk", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public int PresetNameChk(@RequestBody SettingpresetVO vo) throws Exception {
		
		int result = service.PresetNameChk(vo);
		
		return result;
	}
	
	@RequestMapping(value = "/DetailPresetWorktimeView", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<SettingpresetVO> DetailPresetWorktimeView(@RequestBody SettingpresetVO vo) throws Exception {
		
		return service.DetailPresetWorktimeView(vo);
	}

	@RequestMapping(value = "/DetailPresetUniquessView1", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<SettingpresetVO> DetailPresetUniquessView1(@RequestBody SettingpresetVO vo) throws Exception {

		return service.DetailPresetUniquessView1(vo);

	}

	@RequestMapping(value = "/DetailPresetUniquessView2", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<SettingpresetVO> DetailPresetUniquessView2(@RequestBody SettingpresetVO vo) throws Exception {
		
		return service.DetailPresetUniquessView2(vo);
	}

	@RequestMapping(value = "/PresetUniquessView", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public void PresetUniquessView(@RequestBody SettingpresetVO vo) throws Exception {
		
		service.DetailPresetUniquessView1(vo);
		
		service.DetailPresetUniquessView2(vo);
	}

	@RequestMapping(value = "/DetailPresetView", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String DetailPresetView(@RequestBody SettingpresetVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		
		Date time = new Date();
				
		String time1 = format1.format(time);
		
		logger.info(time1 + "DetailPresetView");
		
		List<SettingpresetVO> result = service.DetailPresetView(vo);
		
		Date Create = result.get(0).SETTING_PRESET_CREATEDATE;
					
		
		
		String SETTING_PRESET_NAME = result.get(0).SETTING_PRESET_NAME;
		int USE_DIVISION_ID = result.get(0).USE_DIVISION_ID;
		String USE_DIVISION_NAME = result.get(0).USE_DIVISION_NAME;
		String ORIGIN_ACCOUNT_MEMBERNAME = result.get(0).ORIGIN_ACCOUNT_MEMBERNAME;
		String time2 = format1.format(Create);
		
		JsonObject obj = new JsonObject();
		
		obj.addProperty("SETTING_PRESET_NAME", SETTING_PRESET_NAME);
		obj.addProperty("USE_DIVISION_ID", USE_DIVISION_ID);
		obj.addProperty("ORIGIN_ACCOUNT_MEMBERNAME", ORIGIN_ACCOUNT_MEMBERNAME);
		obj.addProperty("USE_DIVISION_NAME", USE_DIVISION_NAME);
		obj.addProperty("SETTING_PRESET_CREATEDATE", time2);
		
		return obj.toString();
	}

	
	@RequestMapping(value = "ComparePreset", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String ComparePreset(@RequestBody SettingpresetVO vo) throws Exception {
		
		String result = service.ComparePreset(vo);
		return result;
	}

	@RequestMapping(value = "/PresetListView", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<SettingpresetVO> PresetListView(SettingpresetVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);
		
		logger.info(time1 + "PresetListView");

		ArrayList<Integer> SETTING_PRESET_ID = new ArrayList<Integer>();
		ArrayList<Integer> USE_DIVISION_ID = new ArrayList<Integer>();
		ArrayList<Integer> ORIGIN_ACCOUNT_ID = new ArrayList<Integer>();
		ArrayList<String> SETTING_PRESET_NAME = new ArrayList<String>();
		ArrayList<Integer> SETTING_PRESET_PROCESS_ID = new ArrayList<Integer>();
		ArrayList<Integer> SETTING_PRESET_PROCESS_INDEX = new ArrayList<Integer>();
		ArrayList<String> USE_DIVISION_NAME = new ArrayList<String>();
		ArrayList<String> ORIGIN_ACCOUNT_MEMBERNAME = new ArrayList<String>();
		ArrayList<String> ORIGIN_PROCESS_NAME = new ArrayList<String>();

		JSONObject testobj = new JSONObject();
		
		


		
		List<SettingpresetVO> result = service.PresetListView(vo);

		//중복으로 제거 시킨 프리셋으로 찾으면 되잖아?
		
		
		for(int i = 0; i < result.size(); i++) {
			
			
			SETTING_PRESET_ID.add(result.get(i).SETTING_PRESET_ID);
			USE_DIVISION_ID.add(result.get(i).USE_DIVISION_ID);
			ORIGIN_ACCOUNT_ID.add(result.get(i).ORIGIN_ACCOUNT_ID);
			SETTING_PRESET_NAME.add(result.get(i).SETTING_PRESET_NAME);
			USE_DIVISION_NAME.add(result.get(i).USE_DIVISION_NAME);
			ORIGIN_ACCOUNT_MEMBERNAME.add(result.get(i).ORIGIN_ACCOUNT_MEMBERNAME);
			
			SETTING_PRESET_PROCESS_INDEX.add(result.get(i).SETTING_PRESET_PROCESS_INDEX);
			ORIGIN_PROCESS_NAME.add(result.get(i).ORIGIN_PROCESS_NAME);
			SETTING_PRESET_PROCESS_ID.add(result.get(i).SETTING_PRESET_PROCESS_ID);
			
		            
		}
		
		
		
		
		for(int i = 0; i < result.size(); i++) {

		
			/*
			if (result.get(i).SETTING_PRESET_ID == result.get(i+1).SETTING_PRESET_ID) {
				
				SETTING_PRESET_ID.add(result.get(i).SETTING_PRESET_ID);
				USE_DIVISION_ID.add(result.get(i).USE_DIVISION_ID);
				ORIGIN_ACCOUNT_ID.add(result.get(i).ORIGIN_ACCOUNT_ID);
				SETTING_PRESET_NAME.add(result.get(i).SETTING_PRESET_NAME);
				USE_DIVISION_NAME.add(result.get(i).USE_DIVISION_NAME);
				ORIGIN_ACCOUNT_MEMBERNAME.add(result.get(i).ORIGIN_ACCOUNT_MEMBERNAME);
			}
					
			*/
			
			SETTING_PRESET_ID.add(result.get(i).SETTING_PRESET_ID);
			USE_DIVISION_ID.add(result.get(i).USE_DIVISION_ID);
			ORIGIN_ACCOUNT_ID.add(result.get(i).ORIGIN_ACCOUNT_ID);
			SETTING_PRESET_NAME.add(result.get(i).SETTING_PRESET_NAME);
			USE_DIVISION_NAME.add(result.get(i).USE_DIVISION_NAME);
			ORIGIN_ACCOUNT_MEMBERNAME.add(result.get(i).ORIGIN_ACCOUNT_MEMBERNAME);
			
			SETTING_PRESET_PROCESS_INDEX.add(result.get(i).SETTING_PRESET_PROCESS_INDEX);
			ORIGIN_PROCESS_NAME.add(result.get(i).ORIGIN_PROCESS_NAME);
			SETTING_PRESET_PROCESS_ID.add(result.get(i).SETTING_PRESET_PROCESS_ID);

		}
		
		
		
		ArrayList<Integer> NEW_SETTING_PRESET_ID = new ArrayList<Integer>();
		ArrayList<Integer> NEW_USE_DIVISION_ID = new ArrayList<Integer>();
		ArrayList<Integer> NEW_ORIGIN_ACCOUNT_ID = new ArrayList<Integer>();
		ArrayList<String> NEW_SETTING_PRESET_NAME = new ArrayList<String>();
		ArrayList<String> NEW_USE_DIVISION_NAME = new ArrayList<String>();
		ArrayList<String> NEW_ORIGIN_ACCOUNT_MEMBERNAME = new ArrayList<String>();

		
		for(int item : SETTING_PRESET_ID) {
			if(!NEW_SETTING_PRESET_ID.contains(item))
				NEW_SETTING_PRESET_ID.add(item);
		}
		for(int item : USE_DIVISION_ID) {
			if(!NEW_USE_DIVISION_ID.contains(item))
				NEW_USE_DIVISION_ID.add(item);
		}
		for(int item : ORIGIN_ACCOUNT_ID) {
			if(!NEW_ORIGIN_ACCOUNT_ID.contains(item))
				NEW_ORIGIN_ACCOUNT_ID.add(item);
		}
		for(String item : SETTING_PRESET_NAME) {
			if(!NEW_SETTING_PRESET_NAME.contains(item))
				NEW_SETTING_PRESET_NAME.add(item);
		}
		for(String item : USE_DIVISION_NAME) {
			if(!NEW_USE_DIVISION_NAME.contains(item))
				NEW_USE_DIVISION_NAME.add(item);
		}
		for(String item : ORIGIN_ACCOUNT_MEMBERNAME) {
			
			if(!NEW_ORIGIN_ACCOUNT_MEMBERNAME.contains(item))
				NEW_ORIGIN_ACCOUNT_MEMBERNAME.add(item);
		}

		
		for(int a : NEW_SETTING_PRESET_ID) {

			if(result.contains(a)) {
				
			}
			
		}
		
		
		
		
		
		JSONObject Bigtest = new JSONObject();

		
		JSONArray test1 = new JSONArray();
		
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<Integer> B = new ArrayList<Integer>();
		ArrayList<String> C = new ArrayList<String>();
		
		
		
		//조회된 결과 값의 사이즈만큼 반복
		for(int i = 0; i < result.size(); i++) {

			//줄여진 프리셋 key들 54, 55 총 2개 남은거
			for(int j = 0; j < NEW_SETTING_PRESET_ID.size(); j++) {
				
				

			
				if(result.get(i).SETTING_PRESET_ID == NEW_SETTING_PRESET_ID.get(j)) {
					

					
					
				}
				

				
			}
			


		}
		

		
		
		/*
		JSONObject Nictest2 = new JSONObject();
		
		for(int i = 0; i < result.size(); i++) {
			
			JSONArray test1 = new JSONArray();
			JSONArray test2 = new JSONArray();
			JSONArray test3 = new JSONArray();

			
			for(int j = 0; j < NEW_SETTING_PRESET_ID.size(); j++) {
				
				

				
				if(result.get(i).SETTING_PRESET_ID == NEW_SETTING_PRESET_ID.get(j)) {
					
					test1.add(result.get(i).SETTING_PRESET_PROCESS_ID);
					test2.add(result.get(i).SETTING_PRESET_PROCESS_INDEX);
					test3.add(result.get(i).ORIGIN_PROCESS_NAME);

				}
				
				Nictest2.put("SETTING_PRESET_PROCESS_ID", test1);
				Nictest2.put("SETTING_PRESET_PROCESS_INDEX", test2);
				Nictest2.put("ORIGIN_PROCESS_NAME", test3);
			}
			
			
			
		}
		
		System.out.println(Nictest2.toString());
		*/
		
		/*
		
		jsonObject.put("SETTING_PRESET_ID", hashSet1);
		jsonObject.put("USE_DIVISION_ID" , hashSet2);
		jsonObject.put("ORIGIN_ACCOUNT_ID" , hashSet3);
		jsonObject.put("SETTING_PRESET_NAME", hashSet4);
		jsonObject.put("USE_DIVISION_NAME" , hashSet5);
		jsonObject.put("ORIGIN_ACCOUNT_MEMBERNAME", hashSet6);
		jsonObject.put("SETTING_PRESET_PROCESS_ID", SETTING_PRESET_PROCESS_ID);
		jsonObject.put("SETTING_PRESET_PROCESS_INDEX", SETTING_PRESET_PROCESS_INDEX);
		jsonObject.put("ORIGIN_PROCESS_NAME", ORIGIN_PROCESS_NAME);
		 */
		
		return result;
	}
	
	@RequestMapping(value = "SearchSettingPreset", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<SettingpresetVO> SearchSettingPreset(@RequestBody SettingpresetVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		logger.info(time + "SearchSettingPreset");
		
		try {
			return service.SearchSettingPreset(vo);
		} catch (Exception e){
			throw new SettingPresetSearchException();
		}
		
	}
	
	@RequestMapping(value = "/DeleteProcessIndex", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String DeleteProcessIndex(@RequestBody SettingpresetVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		logger.info(time + "DeleteProcessIndex");
		
		try {
			
			for(int i = 0; i < vo.getSETTING_PRESET_PROCESS_ID2().length; i++) {
				
				vo.setSETTING_PRESET_PROCESS_ID(vo.getSETTING_PRESET_PROCESS_ID2()[i]);
				
				service.DeletePresetProcessUniquess(vo);
				

				vo.setSETTING_PRESET_PROCESS_ID(vo.getSETTING_PRESET_PROCESS_ID2()[i]);
				
				service.DeleteProcessIndex(vo);
				
			}
			
			JsonObject obj = new JsonObject();

			obj.addProperty("DeleteProcessIndex", 1);

			return obj.toString();
			
		} catch(Exception e) {
			
			JsonObject obj = new JsonObject();

			obj.addProperty("DeleteProcessIndex", 0);

			return obj.toString();
		}

		
	}

	@RequestMapping(value = "/FindFileDirectory", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<SettingpresetVO> FindFileDirectory(@RequestBody SettingpresetVO vo) throws Exception {
		
		List<SettingpresetVO> result = service.FindFileDirectory(vo);
		
		return result;
		
	}

	
	@ResponseBody
	@RequestMapping(value = "/DeleteSettingPreset", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String DeleteSettingPreset(@RequestBody SettingpresetVO vo /*List<Integer> SETTING_PRESET_ID*/) throws Exception {
	
		logger.info("DeleteSettingPreset");
		/*
		for(int i = 0; i < vo.getSETTING_PRESET_ID2().length; i++) {
			
			int UseArrayID = vo.getSETTING_PRESET_ID2()[i];
			
			vo.setSETTING_PRESET_ID(UseArrayID);
			
			List<SettingpresetVO> Memberresult = service.MultiPresetSelect(vo);
			
			int MemberMatching = Memberresult.get(0).ORIGIN_ACCOUNT_ID;
			
			System.out.println(MemberMatching);
			
		}
		return null;
		*/
		
		try {
			
			for(int i = 0; i < vo.getSETTING_PRESET_ID2().length; i++) {
				
				int UseArrayID = vo.getSETTING_PRESET_ID2()[i];
				
				vo.setSETTING_PRESET_ID(UseArrayID);
				
				List<SettingpresetVO> Memberresult = service.MultiPresetSelect(vo);
					
				int MemberMatching = Memberresult.get(0).ORIGIN_ACCOUNT_ID;
				
					
				//매칭이 맞아서 삭제 시키는 경우
				if(MemberMatching == vo.getORIGIN_ACCOUNT_ID()) {
					
			
					vo.setSETTING_PRESET_ID(UseArrayID);
					
					List<SettingpresetVO> SPP_List = service.CopySettingProcessId(vo);
					
					//프리셋 특이사항 삭제
					for(int ii = 0; ii < SPP_List.size(); ii++) {
						
						int Finding_SPP_ID = SPP_List.get(ii).SETTING_PRESET_PROCESS_ID;
						
						vo.setSETTING_PRESET_PROCESS_ID(Finding_SPP_ID);
						
						service.DeletePresetProcessUniquess(vo);
					}
					
					service.PresetProcessList(vo);
					
					//프리셋 공정 삭제
					service.DeletePresetProcess(vo);
					
					vo.setSETTING_PRESET_ID(UseArrayID);
					
					//프리셋 파일 삭제
					List<SettingpresetVO> result = service.FindFileDirectory(vo);
					
					for(int jii = 0; jii < result.size(); jii++) {
						
						String FileDir = result.get(jii).getSETTING_PRESET_FILE_MANAGEMENT_DIRECTORY();
						
						File file = new File(FileDir);
						
						if(file.exists()) {
							
							if(file.isDirectory()) {
								
								File[] files = file.listFiles();
								
								for( int j=0; j<files.length; j++) {
									
									if(files[j].delete()) { 
										
										System.out.println(files[j].getName()+" 삭제성공"); 
										
									} else {
										
										System.out.println(files[j].getName()+" 삭제실패");

									}
								}
							}
							if (file.delete()) {
								System.out.println("파일 삭제 성공");
							}else {
								System.out.println("파일 삭제 실패");
							}
						} else {
							System.out.println("파일이 존재하지 않음");
						}
						
					}
					
					vo.setSETTING_PRESET_ID(UseArrayID);
					
					service.DeletePresetFile2(vo);
					
					vo.setSETTING_PRESET_ID(UseArrayID);
					
					service.DeleteSettingPreset(vo);
					

					
				}else {


				}

				
			}
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("DeleteSettingPreset", 1);
			
			return obj.toString(); 
			
		}catch (Exception e) {
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("DeleteSettingPreset", 0);
			
			return obj.toString(); 	
		}

			
		
			
			/*
			for(int i = 0; i < vo.getSETTING_PRESET_ID2().length; i++) {
				
				System.out.println("받아 들인 배열 ID : "+ vo.getSETTING_PRESET_ID2()[i]);
				
				vo.setSETTING_PRESET_ID(vo.getSETTING_PRESET_ID2()[i]);
				
				List<SettingpresetVO> a = service.CopySettingProcessId(vo);
				
				for(int ii = 0; ii < a.size(); ii++) {
					
					SettingpresetVO obj = a.get(ii);
					
					
					//작업 특이사항 삭제 시
					vo.setSETTING_PRESET_PROCESS_ID(obj.SETTING_PRESET_PROCESS_ID);
					
					service.DeletePresetProcessUniquess(vo);
					
					//작업 기준시간 삭제 시
					vo.setSETTING_PRESET_PROCESS_ID(obj.SETTING_PRESET_PROCESS_ID);
					
					service.DeletePresetProcessWorktime(vo);
					
					//프리셋에 붙은 기존 공정 및 순서 삭제 시
					vo.setSETTING_PRESET_PROCESS_ID(obj.SETTING_PRESET_PROCESS_ID);
					
					service.DeletePresetProcess(vo);
					
				}
				
				
				//이건 프리셋에 붙은 파일 삭제임
				vo.setSETTING_PRESET_ID(vo.getSETTING_PRESET_ID2()[i]);
				
				
				//실제 파일 삭제
				List<SettingpresetVO> result = service.FindFileDirectory(vo);
				
				for (int jj = 0; jj < result.size(); jj++) {
					
					SettingpresetVO obj2 = result.get(jj);

					System.out.println(obj2.SETTING_PRESET_FILE_MANAGEMENT_DIRECTORY);
					
					File file = new File(obj2.SETTING_PRESET_FILE_MANAGEMENT_DIRECTORY);
					
					if(file.exists()) {
						
						if(file.isDirectory()) {
							
							File[] files = file.listFiles();
							
							for( int j=0; j<files.length; j++) {
								
								if(files[i].delete()) { 
									
									System.out.println(files[i].getName()+" 삭제성공"); 
									
								} else {
									
									System.out.println(files[i].getName()+" 삭제실패");

								}
							}
						}
						if (file.delete()) {
							System.out.println("파일 삭제 성공");
						}else {
							System.out.println("파일 삭제 실패");
						}
					} else {
						System.out.println("파일이 존재하지 않음");
					}
				}
				
				vo.setSETTING_PRESET_ID(vo.getSETTING_PRESET_ID2()[i]);
				
				service.DeletePresetFile2(vo);
				
				//전체 큰틀의 프리셋 삭제임
				vo.setSETTING_PRESET_ID(vo.getSETTING_PRESET_ID2()[i]);
				
				service.DeleteSettingPreset(vo);
				
				System.out.println("Delete Complete");
				
			}
			*/

		
	
		//service.DeleteSettingPreset(vo);
		
		
		
		
		/*
		//case 1 : Gson값으로 해봣을 때 결과 : 실패긴한데 더 해봐야함
		Gson gson = new Gson();
		
		JsonParser jparser = new JsonParser();
		
		JsonElement elementId = jparser.parser(vo.get("SETTING_PRESET_ID"))
		
		List<Map<Integer, Object>> resultMap = new ArrayList<Map<Integer, Object>>();
		
		for (Map<String, Object> map : resultMap) {
			
		}
	
		 */
		/*
		//case 2 Parameter값으로 이용했을 때 : 성공
		for (int i = 0; i< SETTING_PRESET_ID.size(); i++) {
			System.out.println(SETTING_PRESET_ID.get(i));
			service.DeleteSettingPreset(SETTING_PRESET_ID.get(i));
		}
		*/
		/*
		for(int a = 0; a < vo.getList().size(); a++) {
			System.out.println(vo.getList());
		}
		
		System.out.println(vo.getList());
		System.out.println(vo.getSETTING_PRESET_ID());
		
		
		service.DeleteSettingPreset(vo);
		*/
		
		/*
		Gson gson = new Gson();
		
		SettingprestVo[] vo2 = gson.from(vo.getSETTING_PRESET_ID(), SettingpresetVO[].class);
		
		ModelAndView jsonModel = new ModelAndView("jsonView");
		
		jsonModel.addObject(vo.getSETTING_PRESET_ID());
		/*
		
		
		System.out.println(jsonModel);
		System.out.println(vo.getSETTING_PRESET_ID());
		System.out.println(vo.getList());
		
		/*
		HashMap<String,Object> hm = new HashMap<String, Object>();
		hm.put("list", vo.getList());
		service.DeleteSettingPreset(hm);
		
		
		
		
		for (SettingpresetVO str : vo.getList()) {
			System.out.println(str.getSETTING_PRESET_ID());
		}
		
		//service.DeleteSettingPreset(vo);
		 
		 */
		
		
	}
	
	
	
	@RequestMapping(value = "/DeleteMultiUniquess", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public void DeleteMultiUniquess(@RequestBody SettingpresetVO vo) throws Exception {
		
		logger.info("Delete Multi Uniquess");
		
		try {
			
			for(int i = 0; i < vo.getSETTING_PRESET_PROCESS_UNIQUESS_ID2().length; i++) {
				
				vo.setSETTING_PRESET_PROCESS_UNIQUESS_ID(vo.getSETTING_PRESET_PROCESS_UNIQUESS_ID2()[i]);
				
				service.DeleteMultiUniquess(vo);
			}
		} catch (Exception e) {
			
			throw new SettingPresetUniquessMultiDeleteException();
		}
		

		
	}

	@RequestMapping(value = "/UpdatePresetFileRegister", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String UpdatePresetFileRegister(@RequestBody SettingpresetVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");
		
		Date time = new Date();
				
		String time1 = format1.format(time);
		
		logger.info(time1 + "UpdatePresetFileRegister");
		
		try {

			service.UpdatePresetFileRegister(vo);
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("UpdatePresetFileRegister", 1);
			
			return obj.toString();
			
		} catch(Exception e) {
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("UpdatePresetFileRegister", 0);
			
			return obj.toString();
		}
	}

	
	@RequestMapping(value = "/UpdatePresetProcessTimeandInspection", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String UpdatePresetWorktime(@RequestBody SettingpresetVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");

		Date time = new Date();

		String time1 = format1.format(time);

		logger.info(time1 + "UpdatePresetProcessTimeandInspection");
		
		try {
			
			service.UpdatePresetProcessTimeandInspection(vo);
			
			vo.setSETTING_PRESET_PROCESS_ID(vo.getSETTING_PRESET_PROCESS_ID());
			
			service.DeleteAllUniquess(vo);
			
			
			if(vo.getORIGIN_UNIQUESS_ID2() == null) {
				
				
				
			}else {
				for(int i = 0; i < vo.getORIGIN_UNIQUESS_ID2().length; i++) {
					
					vo.setSETTING_PRESET_PROCESS_ID(vo.getSETTING_PRESET_PROCESS_ID());
					vo.setORIGIN_UNIQUESS_ID(vo.getORIGIN_UNIQUESS_ID2()[i]);
					
					service.RegisterSettingPresetUniquess(vo);
					
				}
			}
			JsonObject obj = new JsonObject();

			obj.addProperty("UpdatePresetProcessTimeandInspection", 1);

			return obj.toString();

		} catch(Exception e) {
			
			JsonObject obj = new JsonObject();

			obj.addProperty("UpdatePresetProcessTimeandInspection", 0);

			return obj.toString();
		}
	}

	
	@RequestMapping(value = "/DetailPresetUseView", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<SettingpresetVO> DetailPresetUseView(SettingpresetVO vo) throws Exception {
		
		return service.DetailPresetUseView(vo);
	}
	
	@RequestMapping(value = "/UpdatePresetProcessSelfinspection", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String UpdatePresetProcessSelfinspection(@RequestBody SettingpresetVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");
		
		Date time = new Date();
				
		String time1 = format1.format(time);
		
		logger.info(time1 + "UpdatePresetProcessSelfinspection");
		
		try {
			
			service.UpdatePresetProcessSelfinspection(vo);
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("UpdatePresetProcessSelfinspection", 1);
			
			return obj.toString();
			
		} catch(Exception e) {
		
			JsonObject obj = new JsonObject();
			
			obj.addProperty("UpdatePresetProcessSelfinspection", 0);
			
			return obj.toString();
			
		}
		
		
	}

	
	@RequestMapping(value = "/UpdateSettingPreset", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String UpdateSettingPreset(@RequestBody SettingpresetVO vo) throws Exception {
		

		logger.info("Update SettingPreset");
		try {
			
			
			//ID로 찾아온 원래의 세팅프리셋 명칭
			String chk = service.SamePresetNameIDChk(vo);
			
			int NameChk = service.PresetNameChk(vo);
			
			if(chk.equals(vo.getSETTING_PRESET_NAME())) {
				
				
				//ID로 찾아온거랑 수정값이랑 동일이니까 고대로 저장인거고
				
				SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
				
				Date time = new Date();
				
				String convtime = vo.getConvertSETTING_PRESET_CREATEDATE();
				
				Date Create = format1.parse(convtime);
				
				vo.setSETTING_PRESET_CREATEDATE(Create);
				
				service.UpdateSettingPreset(vo);
				
				JsonObject obj = new JsonObject();
				
				obj.addProperty("UpdateSettingPreset", 1);
				
				return obj.toString();
				
			}else {

				if(NameChk >= 1) {
				
					JsonObject obj = new JsonObject();
					
					obj.addProperty("Preset_overlap", 1);
					
					return obj.toString();

				}
				
				else {
					
					SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
					
					Date time = new Date();
					
					String convtime = vo.getConvertSETTING_PRESET_CREATEDATE();

					Date Create = format1.parse(convtime);
					
					vo.setSETTING_PRESET_CREATEDATE(Create);
					
					service.UpdateSettingPreset(vo);
					
					JsonObject obj = new JsonObject();
					
					obj.addProperty("UpdateSettingPreset", 1);
					
					return obj.toString();
				}
				
			}

		} catch (Exception e) {
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("UpdateSettingPreset", 0);
			
			return obj.toString();
		}
		
	}

	
	
}
