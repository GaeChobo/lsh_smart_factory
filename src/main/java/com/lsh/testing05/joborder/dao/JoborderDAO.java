package com.lsh.testing05.joborder.dao;

import java.util.Date;
import java.util.List;

import com.lsh.testing05.joborder.vo.JoborderVO;

public interface JoborderDAO {

	public List<JoborderVO> LabelExport(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> BomnDetailValue(JoborderVO vo) throws Exception;
	
	public int CreateJoborderBOM(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> FindSameJobNum(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> EquipWorkerList(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> MonitoringStatusPage(JoborderVO vo) throws Exception;
	
	public String FindJobProcessName(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> AccountIdAssignJob(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> AccountIdAssignCount(JoborderVO vo) throws Exception;
	
	public String FinidProcessOriginName(JoborderVO vo) throws Exception;
	
	public Integer FindProcessOriginid(JoborderVO vo) throws Exception;
	
	public Integer FindRunEquipName(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> CategoryOriginEquipSelect(JoborderVO vo) throws Exception;
	
	public void AllDeleteProcessResult(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> FindJobDetail(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> FindJobID(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> FindJobRun(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> FindProcessTemplateID(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> FindProcessResultID(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> FindJobEquipName(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SelectOriginEquipName(JoborderVO vo) throws Exception;

	public List<JoborderVO> SelectIndex1OriginID(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SelectIndex2OriginID(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SelectIndex3OriginID(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SelectIndex4OriginID(JoborderVO vo) throws Exception;
	
	//불량품 문자열->숫자로 변환하기 위함
	public List<JoborderVO> Home2_1(JoborderVO vo) throws Exception;
		
	//작업 설비현황 메인 목록 조회
	public List<JoborderVO> EquipNowList1_1(JoborderVO vo) throws Exception;
	 
	//작업자 속성 ID조회로 등록된 설비 입력하기
	public List<JoborderVO> SelectEquipID(JoborderVO vo) throws Exception;
	
	//작업자 첨부파일 개별 삭제
	public void DeleteListProcessWorkerFile(JoborderVO vo) throws Exception;
	
	//테스트 디테일 통합인지, 벨로우즈 구분용 조회
	public List<JoborderVO> TestCountDetail(JoborderVO vo) throws Exception;
	
	//작업지시서 공정 상태값 조회
	public List<JoborderVO> FindProcessStatus(JoborderVO vo) throws Exception;
	
	//작업지시서 첨부파일 조회
	public List<JoborderVO> FindJBFileDir(JoborderVO vo) throws Exception;
	
	//작업중지 조회
	public List<JoborderVO> SelectJobStopList(JoborderVO vo) throws Exception;
	
	//검색조건_1_1_1
	public List<JoborderVO> SearchJbList1_1_1(JoborderVO vo) throws Exception;
	
	//검색조건_1_2_1
	public List<JoborderVO> SearchJbList1_2_1(JoborderVO vo) throws Exception;
	
	//검색조건_2_1_1
	public List<JoborderVO> SearchJbList2_1_1(JoborderVO vo) throws Exception;
	
	//검색조건_2_2_1
	public List<JoborderVO> SearchJbList2_2_1(JoborderVO vo) throws Exception;
	
	//검색조건_3_1_1
	public List<JoborderVO> SearchJbList3_1_1(JoborderVO vo) throws Exception;
	
	//검색조건_3_2_1
	public List<JoborderVO> SearchJbList3_2_1(JoborderVO vo) throws Exception;
	
	//ProcessValue 반환
	public int ReturnProcessValue(JoborderVO vo) throws Exception;
	
	//설비현황 작업할당 원형 그래프
	public List<JoborderVO> EquipNowList3(JoborderVO vo) throws Exception;
	
	//설비현황 리스트트 할당 건수 
	public Integer EquipNowList2(JoborderVO vo) throws Exception;
	
	//설비현황 리스트 할당 건수 제외한 목록
	public List<JoborderVO> EquipNowList1(JoborderVO vo) throws Exception;

	//JobNO 테스트
	public List<JoborderVO> JobNotest(JoborderVO vo) throws Exception;

	//발주입고대장 리스트
	public List<JoborderVO> OutSourcingOutEndList(JoborderVO vo) throws Exception;
	
	//발주입고대장 검색1
	public List<JoborderVO> SearchOutSourcingOutEndList1(JoborderVO vo) throws Exception;
	
	//발주입고대장 검색2
	public List<JoborderVO> SearchOutSourcingOutEndList2(JoborderVO vo) throws Exception;

	//외주발주현황 리스트
	public List<JoborderVO> OutSourcingOutList(JoborderVO vo) throws Exception;
	
	//외주발주현황검색1
	public List<JoborderVO> SearchOutSourcingOutList1(JoborderVO vo) throws Exception;
	
	//외주발주현황검색2
	public List<JoborderVO> SearchOutSourcingOutList2(JoborderVO vo) throws Exception;

	//작지 기준시간 아웃 업데이트
	public void UpdateWorkOut(JoborderVO vo) throws Exception;
	
	//모니터링 1page 공정정보창
	public List<JoborderVO> MonitoringPage4(JoborderVO vo) throws Exception;
	
	//모니터링 1page 검색 조회창2
	public List<JoborderVO> SearchMonitoringPage3_1(JoborderVO vo) throws Exception;
	
	//모니터링 1page 검색 조회창1
	public List<JoborderVO> SearchMonitoringPage3(JoborderVO vo) throws Exception;
		
	//모니터링 1page 조회창
	public List<JoborderVO> MonitoringPage3(JoborderVO vo) throws Exception;
	
	//모니터링 1page
	public List<JoborderVO> MonitoringPage2(JoborderVO vo) throws Exception;
	
	//모니터링 1page
	public List<JoborderVO> MonitoringPage1(JoborderVO vo) throws Exception;
	
	//자주검사 전체 코드 업데이트 (작업자 사용 컬럼)
	public void UpdateJbWorkInspection(JoborderVO vo) throws Exception;
	
	//프로젝트 Job/No 검색 3
	public List<JoborderVO> Search1ProjectJobNo3(JoborderVO vo) throws Exception;
	
	//프로잭트 Job/No 검색 2
	public List<JoborderVO> Search1ProjectJobNo2(JoborderVO vo) throws Exception;

	//프로잭트 Job/No 검색 1
	public List<JoborderVO> Search1ProjectJobNo1(JoborderVO vo) throws Exception;
	
	//프로젝트 Job/No1
	public List<JoborderVO> ProjectJobNo1(JoborderVO vo) throws Exception;
	
	//프로젝트 Job/No2
	public List<JoborderVO> ProjectJobNo2(JoborderVO vo) throws Exception;

	//프로젝트 Job/No3-1
	public List<JoborderVO> ProjectJobNo3_1(JoborderVO vo) throws Exception;

	//프로젝트 Job/No3-2
	public List<JoborderVO> ProjectJobNo3_2(JoborderVO vo) throws Exception;
	
	//메인4
	public List<JoborderVO> Home4(JoborderVO vo) throws Exception;
	
	//메인3
	public List<JoborderVO> Home3(JoborderVO vo) throws Exception;
	
	//메인2
	public List<JoborderVO> Home2(JoborderVO vo) throws Exception;
	
	//메인1
	public List<JoborderVO> Home1(JoborderVO vo) throws Exception;
	
	//작업지시서 생산계획현황 검색 조회2
	public List<JoborderVO> FindPlanProductionList1(JoborderVO vo) throws Exception;
	
	//작업지시서 생산계획현황 검색 조회
	public List<JoborderVO> FindPlanProductionList(JoborderVO vo) throws Exception;
	
	//작업지시서 생산계획현황 조회
	public List<JoborderVO> SelectPlanProductionList(JoborderVO vo) throws Exception;
	
	//작업지시서 로그 검색 조회2
	public List<JoborderVO> FindSelectLog1(JoborderVO vo) throws Exception;
	
	//작업지시서 로그 검색 조회
	public List<JoborderVO> FindSelectLog(JoborderVO vo) throws Exception;
	
	//작업지시서 로그 조회
	public List<JoborderVO> SelectLog(JoborderVO vo) throws Exception;

	//작업지시서 공정 번호로 설비랑 결과 조회
	public List<JoborderVO> FindJobProcessEquipandResult(JoborderVO vo) throws Exception;
	
	//작업지시서 출고 취소 시 다음 공정의 포커스 대기 상태로 돌리기
	public void UpdateNextJbProcess2(JoborderVO vo) throws Exception;
	
	//작업지시서 출고 취소 시  나중에 작업완료할 때 필요한 설비값 돌려주기 위한 조회문
	public List<JoborderVO> SelectEndCancelEquip(JoborderVO vo) throws Exception;
	
	//작업지시서 출고 취소 시 설비 재작동 업데이트 위험
	public void UpdateEndCancelJbProcessEquip(JoborderVO vo) throws Exception;
	
	//작업지시서 출고 취소 시 현재 공정 업데이트 위함
	public void UpdateEndCancelJbProcess(JoborderVO vo) throws Exception;
	
	//작업지시서 작업완료 시 맨마지막공정 인 경우 작업지시서 업데이트
	public void UpdateLastEndJb(JoborderVO vo) throws Exception;
	
	//작업지시서 작업완료 현재 공정 마무리
	public void UpdateEndJbProcess(JoborderVO vo) throws Exception;
	
	//작업지시서 아이디로 공정 리스트 체크
	public List<JoborderVO> ChkJbProcess(JoborderVO vo) throws Exception;
	
	//작업지시서 완료 후 다음 공정 넘어갈 때 있는지 조회 용도임
	public List<JoborderVO> ChkNextIdx(JoborderVO vo) throws Exception;
	
	//작업지시서 완료 후 다음 공정 상태 업데이트
	public void UpdateNextJbProcess(JoborderVO vo) throws Exception;
	
	//작업지시서 끝낼 때 넣는 공정서식
	public void UpdateEndJbProcessResult(JoborderVO vo) throws Exception;
	
	//작업지시서 넣을 전체 자주검사코드 업데이트
	public void UpdateJbInspection(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> WorkerInspectionView(JoborderVO vo) throws Exception;
	
	//작업자 작업 재개 시 설비 ON
	public void UpdateRestartJbEquip(JoborderVO vo) throws Exception;
	
	//공정 선택 시 최근껄로 수정이력 조회
	public List<JoborderVO> SelectJbProcessReivseLast(JoborderVO vo) throws Exception;
	
	//작업 재시작 시 공정 업데이트
	public void UpdateRestartJbProcess(JoborderVO vo) throws Exception;
	
	//작업 할당 변경 시 특이점 작지 설비 삭제
	public void DeleteJbEquip(JoborderVO vo) throws Exception;
	
	//작업지시서 서브타이틀  조회
	public int SelectSubDvision(JoborderVO vo) throws Exception;
	
	//작업지시서 코드 업데이트
	public void UpdateJoborderCode(JoborderVO vo) throws Exception;
	
	//작업지시서 공정 삭제 시 작업중지이력 삭제
	public void DeleteJbProcessStopTime(JoborderVO vo) throws Exception;
	
	//작업지시서 삭제 시 작업중지이력 삭제
	public void DeleteJobStopTime(JoborderVO vo) throws Exception;
	
	//작업지시서 공정수정이력 삭제
	public void DeleteJbProcessRevise(JoborderVO vo) throws Exception;
	
	//작업자 QRCODE 디렉과 작업지시서 코드 조회
	public List<JoborderVO> WorkerJobView1(JoborderVO vo) throws Exception;
	
	//작업 첫 공정 취소 시 설비 삭제
	public void DeleteFirstCancelJbEquip(JoborderVO vo) throws Exception;
	
	//작업 첫 공정 취소 시 로그 삭제
	public void DeleteFirstCancelLog(JoborderVO vo) throws Exception;
	
	//작업 첫 공정 취소 시 작지 업데이트
	public void UpdateFirstCancelJoborder(JoborderVO vo) throws Exception;
	
	//작업 첫 공정 취소 시 작지 공정 이력 삭제
	public void DeleteFirstCancelJbPrcoessResult(JoborderVO vo) throws Exception;
	
	//작업 첫 공정 취소 시 공정 업데이트
	public void UpdateFirstCancelJbProcess(JoborderVO vo) throws Exception;
	
	//작업 중지 시 공정로비상태 변경
	public void UpdateStopAssign(JoborderVO vo) throws Exception;
	
	//작업 중지 시 중지이력 등록
	public void RegisterJobStopTime(JoborderVO vo) throws Exception;
	
	//작업 중지 시 작업지시서 코드 업데이트
	public void UpdateJobCode(JoborderVO vo) throws Exception;
	
	//작업 중지 시 설비 실제 작동 여부 0
	public void UpdateJobEquipStop(JoborderVO vo) throws Exception;
	
	//작업 중지 시 작업지시서 테이블 아이로 반환 조회
	public List<JoborderVO> SelectJoborderID(JoborderVO vo) throws Exception;
	
	//작업 중지 시 작지공정이력 업데이트
	public void UpdateStopJbProcessResult(JoborderVO vo) throws Exception;
	
	//작업 중지 시 스타트시간 조회 가져오기
	public Date SelectStartTimeGet(JoborderVO vo) throws Exception;
	
	//작업 시작 시 작지공정이력 등록
	public void StartJbProcessResult(JoborderVO vo) throws Exception;
	
	//작업 시작 시 작업지시서 테이블 업데이트
	public void UpdateStartJoborder(JoborderVO vo) throws Exception;
	
	//작업 시작 시 작업지시서 공정 테이블 업데이트
	public void UpdateStartJbProcess(JoborderVO vo) throws Exception;
	
	//작업 시작 시 로그 등록
	public void StartLogRegister(JoborderVO vo) throws Exception;
	
	//작업자 입고 및 할당 (취소 포함)시 조회로 테스팅
	public List<JoborderVO> DetectActiveOn(JoborderVO vo) throws Exception;
	
	//작업자 시작 및 쥐소 등등 공정 ID로만 조회 테스팅
	public List<JoborderVO> DetectActiveStart(JoborderVO vo) throws Exception;
	
	//작업자 입고 버튼 클릭 시 업데이트
	public void UpdateReceiveOn1(JoborderVO vo) throws Exception;
	
	//작업자 입고 취소 버튼 클릭 시 업데이트
	public void UpdateReceiveCancel(JoborderVO vo) throws Exception;
	
	//작업자 할당 버튼 클릭 시 업데이트
	public void UpdateAssignOn1(JoborderVO vo) throws Exception;
	
	//작업자 할당 취소 버튼 클릭 시 업데이트
	public void UpdateAssignCancel(JoborderVO vo) throws Exception;
	
	//작업자 할당 변경
	public void UpdateAssignWorker(JoborderVO vo) throws Exception;
	
	//작업자 할당 변경 시 작업자 리스트
	public List<JoborderVO> AssignWorkerList(JoborderVO vo) throws Exception;
	
	//프리셋 파일 가져오기
	public List<JoborderVO> SelectPresetFile(JoborderVO vo) throws Exception;
	
	//작지공정 작업특이사항 조회
	public List<JoborderVO> SelectJbProcessUniquess(JoborderVO vo) throws Exception;
	
	//작지서 ID로 작지 공정 ID 찾아오기
	public List<JoborderVO> FindJbProcessId(JoborderVO vo) throws Exception;
	
	//작업자 전체 목록 조회
	public List<JoborderVO> WorkerAllJbList(JoborderVO vo) throws Exception;
	
	//작업자 공정 목록 조회
	public List<JoborderVO> WorkerPrcoessList(JoborderVO vo) throws Exception;
	
	//작업지시서 파일 조회
	public List<JoborderVO> SelectJbProcessFile(JoborderVO vo) throws Exception;
	
	//작업지시서 서브타이틀 조회
	public List<JoborderVO> SelectJoborderSubtitle(JoborderVO vo) throws Exception;
	
	//작업지시서 서식 상단 조회
	public List<JoborderVO> SelectJoborderDetail(JoborderVO vo) throws Exception;
	
	//작업지시서 서식 매칭폼 원본 공정으로 찾아오기
	public int SelectJoborderDetailForm(JoborderVO vo) throws Exception;
	
	//작지 ID로 작지 서식 ID 가져오기
	public int FindDetailJbId(JoborderVO vo) throws Exception;
	
	//작업지시서 조회
	public List<JoborderVO> SelectJoborder(JoborderVO vo) throws Exception;
	
	//특정 작지 찾기
	public List<JoborderVO> SelectOneJoborder(JoborderVO vo) throws Exception;
	
	//작지 목록 조회
	public List<JoborderVO> SelectJbList(JoborderVO vo) throws Exception;
	
	//작지 목록 검색1_1
	public List<JoborderVO> SearchJbList1_1(JoborderVO vo) throws Exception;
	
	//작지 목록 검색1_2
	public List<JoborderVO> SearchJbList1_2(JoborderVO vo) throws Exception;
	
	//작지 목록 검색2_1
	public List<JoborderVO> SearchJbList2_1(JoborderVO vo) throws Exception;

	//작지 목록 검색2_2
	public List<JoborderVO> SearchJbList2_2(JoborderVO vo) throws Exception;

	//작지 목록 검색3_1
	public List<JoborderVO> SearchJbList3_1(JoborderVO vo) throws Exception;
	
	//작지 목록 검색3_2
	public List<JoborderVO> SearchJbList3_2(JoborderVO vo) throws Exception;
	
	//QR Code 조회용 개발
	public List<JoborderVO> SelectFindQRCode(JoborderVO vo) throws Exception;
	
	//파일 삭제관련 조회
	public String OneFindJBFileDirectory(JoborderVO vo) throws Exception;
	
	//공정순서 조회용
	public List<JoborderVO> SelectJbProcessIndexChk(JoborderVO vo) throws Exception;
	
	//작업지시서 공정 조회
	public List<JoborderVO> SelectJoborderIDProcess(JoborderVO vo) throws Exception;
	
	//작업지시서 공정 이력 수정 조회
	public List<JoborderVO> SelectJbProcessRevise(JoborderVO vo) throws Exception;
	
	//작업지시서 ID 체크
	public int IdChkJob(JoborderVO vo) throws Exception;
	
	//작업지시서 공정 순서 변경
	public void UpdateJbProcessIndex(JoborderVO vo) throws Exception;
	
	//작업지시서 공정정보, 기준시간, 자주검사, 특이사항 수정
	public void UpdateJbProcessAll(JoborderVO vo) throws Exception;
	
	//작업지시서 내용 변경
	public void UpdateJbContext(JoborderVO vo) throws Exception;
	
	//작업지시서 로비 상태 변경(배포 시)
	public void UpdateJbProcessLobby1(JoborderVO vo) throws Exception;
	
	//작업지시서 로비 상태 변경(배포 취소)
	public void UpdateJbProcessLobby2(JoborderVO vo) throws Exception;
	
	//작업지시서 포커스 변경(배포 시)
	public void UpdateFocusOn1(JoborderVO vo) throws Exception;
	
	//작업지시서 포커스 변경(배포 취소)
	public void UpdateFocusOn2(JoborderVO vo) throws Exception;

	//작업지시서 시작 시 넣을 작업지시서 공정 이력 등록
	public void RegisterProcessResult(JoborderVO vo) throws Exception;
	
	//작업지시서 로비 상태 변경
	public void UpdateJbLobbyStatus(JoborderVO vo) throws Exception;
	
	//작저 첫 배포 시 첫 포커스 변경
	public void UpdateJBProcessFocus(JoborderVO vo) throws Exception;
	
	//작업지시서 파일 삭제
	public void DeleteJoborderFile(JoborderVO vo) throws Exception;
	
	//작업지시서 QR 삭제
	public void DeleteJoborderQRCode(JoborderVO vo) throws Exception;
	
	//작업지시서 서식 삭제
	public void DeleteAllJoborderDetail(JoborderVO vo) throws Exception;
	
	//작업지시서 파일 전체 삭제
	public void DeleteAllJoborderFile(JoborderVO vo) throws Exception;
	
	//작업지시서 공정 전체 삭제
	public void DeleteAllJbProcess(JoborderVO vo) throws Exception;
	
	//작지 공정 작업특이사항 전체 삭제용
	public void DeleteAllJbUniquess(JoborderVO vo) throws Exception;
	
	//작지 공정 작업특이사항 삭제
	public void DeleteJbUniquess(JoborderVO vo) throws Exception;
	
	//작업지시서 상단 등록
	public void RegisterJoborderDetail(JoborderVO vo) throws Exception;
	
	//작업지시서 파일 등록
	public void RegisterJoborderFile(JoborderVO vo) throws Exception;
	
	//작업지시서 특이사항 등록
	public void RegisterJoborderUniquess(JoborderVO vo) throws Exception;
	
	//작업지시서 설비 공정 등록
	public void RegisterJoborderEquipment(JoborderVO vo) throws Exception;
	
	//작업지시서 설비 작업 시작할 때 실제 사용여부 수정
	public void UpdateJoborderEquipmentStart(JoborderVO vo) throws Exception;
	
	//작업지시서 설비 작업 종료시 사용여부 수정
	public void UpdateJoborderEquipmentEnd(JoborderVO vo) throws Exception;
	
	//작업지시서 QR 등록
	public void RegisterQRCode(JoborderVO vo) throws Exception;
	
	//작업지시서 상단 수정
	public void UpdateJoborderDetail(JoborderVO vo) throws Exception;
	
	//작업지시서 배포 관련 업데이트
	public void UpdatePublishJoborder(JoborderVO vo) throws Exception;
	
	//작업지시서 배포 취소 업데이트
	public void CancelPublishJoborder(JoborderVO vo) throws Exception;
	
	//작업지시서 긴급, 우선 수정
	public void UpdateEmergencyJoborder(JoborderVO vo) throws Exception;
	
	//작업지시서 파일 허용 수정
	public void UpdateJoborderFileRegister(JoborderVO vo) throws Exception;
	
	//작업지시서 상단 삭제
	public void DeleteJoborderDetail(JoborderVO vo) throws Exception;
	
	//작업지시서 삭제
	public void DeleteJoborder(JoborderVO vo) throws Exception;
	
	//작업지시서 등록
	public void RegisterJoborder(JoborderVO vo) throws Exception;
	
	//작업지시서 공정 삭제
	public void DeleteJoborderProcess(JoborderVO vo) throws Exception;
	
	//작업지시서 공정 등록
	public void RegisterJoborderProcess(JoborderVO vo) throws Exception;
	
	//작업지시서 공정 자주검사 수정
	public void UpdateJBProcessSelfInspection(JoborderVO vo) throws Exception;
	
	//작업지시서 공정 수정이력 등록
	public void RegisterJbProcessRevise(JoborderVO vo) throws Exception;
	
	//작업지시서 공정 수정이력 수정
	public void UpdateJbProcessRevise(JoborderVO vo) throws Exception;
	
	//작업지시서 공정 작업기준시간 수정
	public void UpdateJBProcessWorkTime(JoborderVO vo) throws Exception;
	
	//작업지시서 공정 중지 시간,이력 등록
	public void RegisterJoborderStopTime(JoborderVO vo) throws Exception;
	
	//작업지시서 작업중 공정 정보 입력
	public void RegisterProcessResultValue(JoborderVO vo) throws Exception;
	
	//작업지시서 작업 공정 이력 입력
	public void RegisterProcessStartResult(JoborderVO vo) throws Exception;
	
	//작업지시서 작업자 첨부파일 등록
	public void ReigsterProcessWorkerFile(JoborderVO vo) throws Exception;
	
	//작업지시서 작업자 첨부파일 전체 삭제(작지 공정 삭제시 삭제 위함)
	public void DeleteProcessWorkerFile(JoborderVO vo) throws Exception;
	
	//작업지시서 작업자 첨부파일 디렉토리 찾기
	public List<JoborderVO> FindWorkerFileDir(JoborderVO vo) throws Exception;
	
	//JobProcessid으로 작업특이사항 셀렉트
	public List<JoborderVO> JbProcessUniquess(JoborderVO vo) throws Exception;
	
	//작업지시서 공정 중지 후 재시작
	public void UpdateJBRestartTime(JoborderVO vo) throws Exception;
	
}
