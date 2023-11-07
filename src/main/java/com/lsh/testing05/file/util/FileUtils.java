package com.lsh.testing05.file.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class FileUtils {
	
	private static final String filePath = "D:\\2020-12-07_17-21-07\\";
	
	public List<Map<String, Object>> parseInsertFileInfo(MultipartHttpServletRequest mpRequest) throws Exception {
		
		System.out.println(mpRequest.getFileNames());
		
		Iterator<String> iterator = mpRequest.getFileNames();
		
		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;

		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> listMap = null;
		
		File file = new File(filePath);
		
		if(file.exists() == false) {
			file.mkdirs();
		}
		
		while (iterator.hasNext()) {
			
			multipartFile = mpRequest.getFile(iterator.next());
			if(multipartFile.isEmpty() == false) {
				originalFileName = multipartFile.getOriginalFilename();
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
				
				file = new File(filePath + originalFileName);
				multipartFile.transferTo(file);
				listMap = new HashMap<String, Object>();
			
				listMap.put("ORG_FILE_NAME", originalFileName);
				listMap.put("FILE_SIZE", multipartFile.getSize());
				list.add(listMap);
			}
		}
		return list;
	}
}
