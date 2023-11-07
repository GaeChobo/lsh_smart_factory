package com.lsh.testing05.file.service;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;


import com.lsh.testing05.file.dao.FileDAO;
import com.lsh.testing05.file.vo.FileVO;

@Service
public class FileServiceImpl implements FileService {

	@Inject
	FileDAO dao;
	
	@Override
	public void PresetFileUpload(FileVO vo) throws Exception {
		dao.PresetFileUpload(vo);
	}
	
	@Override
	public List<FileVO> SelectPresetFile(FileVO vo) throws Exception {
		List<FileVO> result = dao.SelectPresetFile(vo);
		return result;
	}
	
	@Override
	public void DeletePresetFile(FileVO vo) throws Exception {
		dao.DeletePresetFile(vo);
	}
	
	@Override
	public void AllDeletePresetFile(FileVO vo) throws Exception {
		dao.AllDeletePresetFile(vo);
	}
	
}
