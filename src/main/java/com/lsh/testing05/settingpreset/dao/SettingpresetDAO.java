package com.lsh.testing05.settingpreset.dao;

import java.util.List;

import com.lsh.testing05.settingpreset.vo.SettingpresetVO;

public interface SettingpresetDAO {
	
	//프리셋 공정 식별 키로 프리셋 작업특이사항 목록만 보기
	public List<SettingpresetVO> SelectPresetUniquess(SettingpresetVO vo) throws Exception;
	
	//Find One Directory
	public String OneFindFileDirectory(SettingpresetVO vo) throws Exception;
	
	//Test용 아이디로 공정명 찾기
	public String FindProcessName(SettingpresetVO vo) throws Exception;
	
	//상단 수정을 위한 체크
	public String SamePresetNameIDChk(SettingpresetVO vo) throws Exception;
	
	//프레싯 공정 test
	public List<SettingpresetVO> PresetListViewTest(SettingpresetVO vo) throws Exception;
	
	//세팅 프리셋 공정 조회 -> 프리셋 키로
	public List<SettingpresetVO> PresetProcessList(SettingpresetVO vo) throws Exception;
	
	//파일 디렉토리 가져오기
	public List<SettingpresetVO> FindFileDirectory(SettingpresetVO vo) throws Exception;
	
	//세팅프리셋 등록
	public void RegisterSettingPreset(SettingpresetVO vo) throws Exception;
	
	//세팅프리셋 Detail(공정 Index 관련 등록)
	public void RegisterSettingPresetProcess(SettingpresetVO vo) throws Exception;
	
	//카피 세팅프리셋 등록
	public void CopySettingPreset(SettingpresetVO vo) throws Exception;
	
	//카피 세팅프리셋 공정 순서 등록
	public void CopySettingPresetProcess(SettingpresetVO vo) throws Exception;
	
	//카피 세팅 프로세스 id 가져오기 
	public List<SettingpresetVO> CopySettingProcess(SettingpresetVO vo) throws Exception;
	
	//카피 세팅 프로세스 인덱스 가져오기
	public List<SettingpresetVO> CopySettingProcessIndex(SettingpresetVO vo) throws Exception;
	
	//카피 세팅 ID 가져오기
	public List<SettingpresetVO> CopySettingProcessId(SettingpresetVO vo) throws Exception;
	
	//세팅프리셋 카피네임 로드
	public String CopySettingPresetNameLoad(SettingpresetVO vo) throws Exception;
	
	//프리셋 명칭 유무 조회 복사를 위한 라인
	public int PresetNameChk(SettingpresetVO vo) throws Exception;
	
	//세팅 프리셋 명칭으로 ID얻기 위한 클래스 공정 순서 복사를 위해 필요
	public int FindSettingPresetID(SettingpresetVO vo) throws Exception;
	
	//이게 진짜 조회단 일단 되는지 테스팅 해보기
	public List<SettingpresetVO> PresetListView(SettingpresetVO vo) throws Exception;
	
	//프리셋 공정 업데이트
	public void UpdatePresetProcessSelfinspection(SettingpresetVO vo) throws Exception;
	
	//프리셋 비교 조회
	public String ComparePreset(SettingpresetVO vo) throws Exception;
	
	//프리셋 검색 조회
	public List<SettingpresetVO> SearchSettingPreset(SettingpresetVO vo) throws Exception;
	
	//프리셋 만들 때 공정 조회 목록 보여주기
	public List<SettingpresetVO> OriginProcessSelect(SettingpresetVO vo) throws Exception;
	
	//프리셋 삭제
	public void DeleteSettingPreset(SettingpresetVO vo) throws Exception;
	
	//프리셋 삭제 시 특이사항도 같이 삭제
	public void DeletePresetProcessUniquess(SettingpresetVO vo) throws Exception;
	
	//프리셋 삭제 시 작업기준시간도 같이 삭제
	public void DeletePresetProcessWorktime(SettingpresetVO vo) throws Exception;
	
	//프리셋 삭제 시 공정 및 순서도 같이 삭제
	public void DeletePresetProcess(SettingpresetVO vo) throws Exception;
	
	//세팅 프리셋 안에서 부분 삭제
	public void DeletePresetFile2(SettingpresetVO vo) throws Exception;
	
	//프리셋 삭제 시 파일도 같이 삭제
	public void DeletePresetFile(SettingpresetVO vo) throws Exception;
	
	//프리셋들어가서 작업 특이사항 수정 시 써야하는 삭제
	public void DeleteMultiUniquess(SettingpresetVO vo) throws Exception;
	
	//프리셋 공정 ID 입력해서 관련 작특 다 삭제
	public void DeleteAllUniquess(SettingpresetVO vo) throws Exception;
	
	//프리셋 공정 순서 임의 삭제
	public void DeleteProcessIndex(SettingpresetVO vo) throws Exception;
	
	//프리셋 수정
	public void UpdateSettingPreset(SettingpresetVO vo) throws Exception;
	
	//프리셋 공정 작업기준시간 수정
	public void UpdatePresetProcessTimeandInspection(SettingpresetVO vo) throws Exception;
	
	//프리셋 파일허용 수정
	public void UpdatePresetFileRegister(SettingpresetVO vo) throws Exception;
	
	//멤버 관리자 유무 조회
	public int AdminChk(SettingpresetVO vo) throws Exception;
	
	//멤버 관리자 재직 유무 조회
	public int IdEmpStatusChk(SettingpresetVO vo) throws Exception;
	
	//임의 선택 프리셋 셀렉트 복사하기 위해 필요
	public List<SettingpresetVO>  MultiPresetSelect(SettingpresetVO vo) throws Exception;
	
	//세팅 프리셋 파일 관련 업로드
	public void PresetFileUpload(SettingpresetVO vo) throws Exception;
	
	//세팅 프리셋 선택 시 파일 조회	
	public List<SettingpresetVO> SelectPresetFile(SettingpresetVO vo) throws Exception;
	

	//프레싯 삭제할 때 다같이 삭제할 용도
	public void AllDeletePresetFile(SettingpresetVO vo) throws Exception;

	//만들어진거 찾기 위한 목적
	public int RecentlyValue(SettingpresetVO vo) throws Exception;
	
	//프리셋 작업 특이사항 등록
	public void RegisterSettingPresetUniquess(SettingpresetVO vo) throws Exception;
	
	//프리셋 작업 기준시간 등록
	public void RegisterSettingPresetWorktime(SettingpresetVO vo) throws Exception;
	
	//프리셋 디테일 View 상단
	public List<SettingpresetVO> DetailPresetView(SettingpresetVO vo) throws Exception;
	
	//프리셋 디테일 View 상단 구분용 조회
	public List<SettingpresetVO> DetailPresetUseView(SettingpresetVO vo) throws Exception;
	
	//프리셋 디테일 작업기준시간 View
	public List<SettingpresetVO> DetailPresetWorktimeView(SettingpresetVO vo) throws Exception;
	
	//프리셋 디테일 작업특이사항 View1
	public List<SettingpresetVO> DetailPresetUniquessView1(SettingpresetVO vo) throws Exception;
	
	//프리셋 디테일 작업특이사항 View2
	public List<SettingpresetVO> DetailPresetUniquessView2(SettingpresetVO vo) throws Exception;
	
	
}
