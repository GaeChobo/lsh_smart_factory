package com.lsh.testing05.file.service;

import java.util.List;

import com.lsh.testing05.file.vo.FileVO;

public interface FileService {

	public void PresetFileUpload(FileVO vo) throws Exception;

	public List<FileVO> SelectPresetFile(FileVO vo) throws Exception;
	
	public void DeletePresetFile(FileVO vo) throws Exception;

	public void AllDeletePresetFile(FileVO vo) throws Exception;


}
