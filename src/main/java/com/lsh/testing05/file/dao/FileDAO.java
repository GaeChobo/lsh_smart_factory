package com.lsh.testing05.file.dao;

import java.util.List;



import com.lsh.testing05.file.vo.FileVO;

public interface FileDAO {

	//파일 업로드 
	public void PresetFileUpload(FileVO vo) throws Exception;
	//프리셋 선택 시 파일 조회
	public List<FileVO> SelectPresetFile(FileVO vo) throws Exception;
	//프리셋 안에서 부분 삭제
	public void DeletePresetFile(FileVO vo) throws Exception;
	//프레싯 삭제할 때 다같이 삭제할 용도
	public void AllDeletePresetFile(FileVO vo) throws Exception;
	
}
