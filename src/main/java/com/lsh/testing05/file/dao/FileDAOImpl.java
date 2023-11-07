package com.lsh.testing05.file.dao;



import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


import com.lsh.testing05.file.vo.FileVO;

@Repository
public class FileDAOImpl implements FileDAO {
	
	@Inject
	private SqlSession sqlsession;
	
	private static final String namespace = "mapper.fileMapper";
	
	@Override
	public void PresetFileUpload(FileVO vo) throws Exception {
		
		sqlsession.insert(namespace+".PresetFileUpload", vo);
	}
	
	@Override
	public List<FileVO> SelectPresetFile(FileVO vo) throws Exception {
		
		List<FileVO> result = sqlsession.selectList(namespace+".SelectPresetFile", vo);
		return result;
	}
	
	@Override
	public void DeletePresetFile(FileVO vo) throws Exception {
		sqlsession.delete(namespace+".DeletePresetFile" , vo);
	}
	
	@Override
	public void AllDeletePresetFile(FileVO vo) throws Exception {
		sqlsession.delete(namespace+".AllDeletePresetFile", vo);
	}
	
}
