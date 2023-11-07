package com.lsh.testing05.joborder.service;

import java.util.Date;
import java.util.List;

import com.lsh.testing05.joborder.vo.JoborderVO;

public interface JoborderService {

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
	
	public List<JoborderVO> Home2_1(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> EquipNowList1_1(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SelectEquipID(JoborderVO vo) throws Exception;
	
	public void DeleteListProcessWorkerFile(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> TestCountDetail(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> FindProcessStatus(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> FindJBFileDir(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SelectJobStopList(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SearchJbList1_1_1(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SearchJbList1_2_1(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SearchJbList2_1_1(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SearchJbList2_2_1(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SearchJbList3_1_1(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SearchJbList3_2_1(JoborderVO vo) throws Exception;
	
	public int ReturnProcessValue(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> EquipNowList3(JoborderVO vo) throws Exception;
	
	public Integer EquipNowList2(JoborderVO vo) throws Exception;

	public List<JoborderVO> EquipNowList1(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> JobNotest(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> OutSourcingOutEndList(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SearchOutSourcingOutEndList1(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SearchOutSourcingOutEndList2(JoborderVO vo) throws Exception;

	public List<JoborderVO> OutSourcingOutList(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SearchOutSourcingOutList1(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SearchOutSourcingOutList2(JoborderVO vo) throws Exception;
	
	public void UpdateWorkOut(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> MonitoringPage4(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SearchMonitoringPage3_1(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SearchMonitoringPage3(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> MonitoringPage3(JoborderVO vo) throws Exception;

	public List<JoborderVO> MonitoringPage2(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SearchJbList3_1(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SearchJbList3_2(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> MonitoringPage1(JoborderVO vo) throws Exception;
	
	public void UpdateJbWorkInspection(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> Search1ProjectJobNo3(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> Search1ProjectJobNo2(JoborderVO vo) throws Exception;

	public List<JoborderVO> Search1ProjectJobNo1(JoborderVO vo) throws Exception;

	public List<JoborderVO> ProjectJobNo3_2(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> ProjectJobNo1(JoborderVO vo) throws Exception;

	public List<JoborderVO> ProjectJobNo2(JoborderVO vo) throws Exception;

	public List<JoborderVO> ProjectJobNo3_1(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> Home4(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> Home3(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> Home2(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> Home1(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> FindSelectLog1(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> FindPlanProductionList1(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> FindPlanProductionList(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SelectPlanProductionList(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> FindSelectLog(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SelectLog(JoborderVO vo) throws Exception;
	
	public void UpdateNextJbProcess2(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> FindJobProcessEquipandResult(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SelectEndCancelEquip(JoborderVO vo) throws Exception;
	
	public void UpdateEndCancelJbProcessEquip(JoborderVO vo) throws Exception;
	
	public void UpdateEndCancelJbProcess(JoborderVO vo) throws Exception;
	
	public void UpdateLastEndJb(JoborderVO vo) throws Exception;
	
	public void UpdateEndJbProcess(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> ChkJbProcess(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> ChkNextIdx(JoborderVO vo) throws Exception;
	
	public void UpdateNextJbProcess(JoborderVO vo) throws Exception;
	
	public void UpdateEndJbProcessResult(JoborderVO vo) throws Exception;
	
	public void UpdateJbInspection(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> WorkerInspectionView(JoborderVO vo) throws Exception;
	
	public void UpdateRestartJbEquip(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SelectJbProcessReivseLast(JoborderVO vo) throws Exception;
	
	public void UpdateRestartJbProcess(JoborderVO vo) throws Exception;
	
	public void DeleteJbEquip(JoborderVO vo) throws Exception;
	
	public int SelectSubDvision(JoborderVO vo) throws Exception;
	
	public void UpdateJoborderCode(JoborderVO vo) throws Exception;
	
	public void DeleteJbProcessStopTime(JoborderVO vo) throws Exception;
	
	public void DeleteJobStopTime(JoborderVO vo) throws Exception;
	
	public void DeleteJbProcessRevise(JoborderVO vo) throws Exception;
	
	public void UpdateStopAssign(JoborderVO vo) throws Exception;
	
	public void RegisterJobStopTime(JoborderVO vo) throws Exception;
	
	public void UpdateJobCode(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> DetectActiveStart(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> WorkerJobView1(JoborderVO vo) throws Exception;
	
	public void DeleteFirstCancelJbEquip(JoborderVO vo) throws Exception;
	
	public void DeleteFirstCancelLog(JoborderVO vo) throws Exception;
	
	public void UpdateFirstCancelJoborder(JoborderVO vo) throws Exception;
	
	public void DeleteFirstCancelJbPrcoessResult(JoborderVO vo) throws Exception;
	
	public void UpdateFirstCancelJbProcess(JoborderVO vo) throws Exception;
	
	public void UpdateJobEquipStop(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SelectJoborderID(JoborderVO vo) throws Exception;
	
	public void UpdateStopJbProcessResult(JoborderVO vo) throws Exception;
	
	public Date SelectStartTimeGet(JoborderVO vo) throws Exception;
	
	public void StartJbProcessResult(JoborderVO vo) throws Exception;
	
	public void UpdateStartJoborder(JoborderVO vo) throws Exception;

	public void UpdateStartJbProcess(JoborderVO vo) throws Exception;

	public void StartLogRegister(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> DetectActiveOn(JoborderVO vo) throws Exception;
	
	public void UpdateReceiveOn1(JoborderVO vo) throws Exception;
	
	public void UpdateReceiveCancel(JoborderVO vo) throws Exception;
	
	public void UpdateAssignOn1(JoborderVO vo) throws Exception;
	
	public void UpdateAssignCancel(JoborderVO vo) throws Exception;
	
	public void UpdateAssignWorker(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> AssignWorkerList(JoborderVO vo) throws Exception;
	
	public void UpdateJbContext(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SelectPresetFile(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SelectJbProcessUniquess(JoborderVO vo) throws Exception;

	public List<JoborderVO> FindJbProcessId(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> WorkerAllJbList(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> WorkerPrcoessList(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SelectJoborderSubtitle(JoborderVO vo) throws Exception;

	public List<JoborderVO> SelectOneJoborder(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SelectFindQRCode(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SelectJbProcessFile(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SelectJbList(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SearchJbList1_1(JoborderVO vo) throws Exception;

	public List<JoborderVO> SearchJbList1_2(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SearchJbList2_1(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SearchJbList2_2(JoborderVO vo) throws Exception;
	
	public void DeleteAllJoborderDetail(JoborderVO vo) throws Exception;
	
	public void DeleteAllJoborderFile(JoborderVO vo) throws Exception;
	
	public void DeleteAllJbProcess(JoborderVO vo) throws Exception;
	
	public int SelectJoborderDetailForm(JoborderVO vo) throws Exception;
	
	public int FindDetailJbId(JoborderVO vo) throws Exception;
	
	public void RegisterProcessResult(JoborderVO vo) throws Exception;
		
	public void UpdateFocusOn1(JoborderVO vo) throws Exception;
	
	public void UpdateFocusOn2(JoborderVO vo) throws Exception;
	
	public void UpdateJbProcessLobby1(JoborderVO vo) throws Exception;
	
	public void UpdateJbProcessLobby2(JoborderVO vo) throws Exception;
	
	public void UpdateJBProcessFocus(JoborderVO vo) throws Exception;
	
	public void UpdateJbLobbyStatus(JoborderVO vo) throws Exception;
	
	public String OneFindJBFileDirectory(JoborderVO vo) throws Exception;
	
	public void DeleteJoborderFile(JoborderVO vo) throws Exception;

	public void DeleteAllJbUniquess(JoborderVO vo) throws Exception;
	
	public void DeleteJbUniquess(JoborderVO vo) throws Exception;
	
	public void DeleteJoborderQRCode(JoborderVO vo) throws Exception;
	
	public void RegisterJoborderFile(JoborderVO vo) throws Exception;
	
	public void RegisterJoborderDetail(JoborderVO vo) throws Exception;

	public void RegisterJoborderUniquess(JoborderVO vo) throws Exception;
	
	public void RegisterJoborderEquipment(JoborderVO vo) throws Exception;
	
	public void RegisterQRCode(JoborderVO vo) throws Exception;
		
	public void UpdateJoborderDetail(JoborderVO vo) throws Exception;
	
	public void UpdatePublishJoborder(JoborderVO vo) throws Exception;
	
	public void CancelPublishJoborder(JoborderVO vo) throws Exception;
	
	public void UpdateEmergencyJoborder(JoborderVO vo) throws Exception;
	
	public void UpdateJoborderFileRegister(JoborderVO vo) throws Exception;
	
	public void UpdateJoborderEquipmentStart(JoborderVO vo) throws Exception;
	
	public void UpdateJoborderEquipmentEnd(JoborderVO vo) throws Exception;
	
	public void DeleteJoborderDetail(JoborderVO vo) throws Exception;
	
	public void DeleteJoborder(JoborderVO vo) throws Exception;

	public void RegisterJoborder(JoborderVO vo) throws Exception;
	
	public void DeleteJoborderProcess(JoborderVO vo) throws Exception;
	
	public void RegisterJoborderProcess(JoborderVO vo) throws Exception;
	
	public void UpdateJBProcessSelfInspection(JoborderVO vo) throws Exception;

	public void UpdateJBProcessWorkTime(JoborderVO vo) throws Exception;
	
	public void RegisterJoborderStopTime(JoborderVO vo) throws Exception;

	public void RegisterJbProcessRevise(JoborderVO vo) throws Exception;
	
	public void UpdateJbProcessRevise(JoborderVO vo) throws Exception;
	
	public void RegisterProcessResultValue(JoborderVO vo) throws Exception;
	
	public void RegisterProcessStartResult(JoborderVO vo) throws Exception;
	
	public void ReigsterProcessWorkerFile(JoborderVO vo) throws Exception;

	public List<JoborderVO> FindWorkerFileDir(JoborderVO vo) throws Exception;
	
	public void DeleteProcessWorkerFile(JoborderVO vo) throws Exception;
	
	public void UpdateJBRestartTime(JoborderVO vo) throws Exception;

	public List<JoborderVO> SelectJoborderDetail(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SelectJoborder(JoborderVO vo) throws Exception;

	public List<JoborderVO> SelectJbProcessIndexChk(JoborderVO vo) throws Exception;

	public List<JoborderVO> SelectJoborderIDProcess(JoborderVO vo) throws Exception;
	
	public List<JoborderVO> SelectJbProcessRevise(JoborderVO vo) throws Exception;
	
	public int IdChkJob(JoborderVO vo) throws Exception;

	public List<JoborderVO> JbProcessUniquess(JoborderVO vo) throws Exception;
	
	public void UpdateJbProcessIndex(JoborderVO vo) throws Exception;

	public void UpdateJbProcessAll(JoborderVO vo) throws Exception;
	
}
