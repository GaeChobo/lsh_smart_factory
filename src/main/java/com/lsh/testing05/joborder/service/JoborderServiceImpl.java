package com.lsh.testing05.joborder.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.lsh.testing05.joborder.dao.JoborderDAO;
import com.lsh.testing05.joborder.vo.JoborderVO;

@Service
public class JoborderServiceImpl implements JoborderService{

	@Inject
	JoborderDAO dao;
	
	@Override
	public List<JoborderVO> LabelExport(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.LabelExport(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> BomnDetailValue(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.BomnDetailValue(vo);
		return result;
	}
	
	@Override
	public int CreateJoborderBOM(JoborderVO vo) throws Exception {
		
		int result = dao.CreateJoborderBOM(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> FindSameJobNum(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.FindSameJobNum(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> EquipWorkerList(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.EquipWorkerList(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> MonitoringStatusPage(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.MonitoringStatusPage(vo);
		return result;
	}
	
	@Override
	public String FindJobProcessName(JoborderVO vo) throws Exception {
		
		String result = dao.FindJobProcessName(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> AccountIdAssignJob(JoborderVO vo) throws Exception {
	
		List<JoborderVO> result = dao.AccountIdAssignJob(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> AccountIdAssignCount(JoborderVO vo) throws Exception {

		List<JoborderVO> result = dao.AccountIdAssignCount(vo);
		return result;
	}
	
	@Override
	public String FinidProcessOriginName(JoborderVO vo) throws Exception {
		
		String result = dao.FinidProcessOriginName(vo);
		return result;
	}
	
	@Override
	public Integer FindProcessOriginid(JoborderVO vo) throws Exception {
		
		Integer result = dao.FindProcessOriginid(vo);
		return result;
	}
	
	
	@Override
	public Integer FindRunEquipName(JoborderVO vo) throws Exception {
		
		Integer result = dao.FindRunEquipName(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> CategoryOriginEquipSelect(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.CategoryOriginEquipSelect(vo);
		return result;
	}
	
	@Override
	public void AllDeleteProcessResult(JoborderVO vo) throws Exception {
		
		dao.AllDeleteProcessResult(vo);
	}
	
	@Override
	public List<JoborderVO> FindJobDetail(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.FindJobDetail(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> FindJobID(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.FindJobID(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> FindJobRun(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.FindJobRun(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> FindProcessTemplateID(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.FindProcessTemplateID(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> FindProcessResultID(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.FindProcessResultID(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> FindJobEquipName(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.FindJobEquipName(vo);
		return result;
	}
	
	
	@Override
	public List<JoborderVO> SelectOriginEquipName(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SelectOriginEquipName(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectIndex1OriginID(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SelectIndex1OriginID(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectIndex2OriginID(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SelectIndex2OriginID(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectIndex3OriginID(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SelectIndex3OriginID(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectIndex4OriginID(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SelectIndex4OriginID(vo);
		return result;
	}	
	
	@Override
	public List<JoborderVO> Home2_1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.Home2_1(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> EquipNowList1_1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.EquipNowList1_1(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectEquipID(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SelectEquipID(vo);
		return result;
	}
	
	@Override
	public void DeleteListProcessWorkerFile(JoborderVO vo) throws Exception {
		
		dao.DeleteListProcessWorkerFile(vo);
	}
	
	@Override
	public List<JoborderVO> TestCountDetail(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.TestCountDetail(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> FindProcessStatus(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.FindProcessStatus(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> FindJBFileDir(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.FindJBFileDir(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectJobStopList(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SelectJobStopList(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SearchJbList1_1_1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SearchJbList1_1_1(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SearchJbList1_2_1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SearchJbList1_2_1(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SearchJbList2_1_1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SearchJbList2_1_1(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SearchJbList2_2_1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SearchJbList2_2_1(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SearchJbList3_1_1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SearchJbList3_1_1(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SearchJbList3_2_1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SearchJbList3_2_1(vo);
		return result;
	}
	
	@Override
	public int ReturnProcessValue(JoborderVO vo) throws Exception {
		
		int result = dao.ReturnProcessValue(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> EquipNowList3(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.EquipNowList3(vo);
		return result;
	}
	
	@Override
	public Integer EquipNowList2(JoborderVO vo) throws Exception {
		
		Integer result = dao.EquipNowList2(vo);
		return result;
	}

	@Override
	public List<JoborderVO> EquipNowList1(JoborderVO vo) throws Exception {
	
		List<JoborderVO> result = dao.EquipNowList1(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> JobNotest(JoborderVO vo) throws Exception {

		List<JoborderVO> result = dao.JobNotest(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SearchOutSourcingOutList1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SearchOutSourcingOutList1(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SearchOutSourcingOutList2(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SearchOutSourcingOutList2(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SearchOutSourcingOutEndList1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SearchOutSourcingOutEndList1(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SearchOutSourcingOutEndList2(JoborderVO vo) throws Exception {
	
		List<JoborderVO> result = dao.SearchOutSourcingOutEndList2(vo);
		return result;
	}

	@Override
	public List<JoborderVO> OutSourcingOutEndList(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.OutSourcingOutEndList(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> OutSourcingOutList(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.OutSourcingOutList(vo);
		return result;
	}
	
	@Override
	public void UpdateWorkOut(JoborderVO vo) throws Exception {
		
		dao.UpdateWorkOut(vo);
	}
	
	@Override
	public List<JoborderVO> MonitoringPage4(JoborderVO vo) throws Exception {
	
		List<JoborderVO> result = dao.MonitoringPage4(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SearchMonitoringPage3_1(JoborderVO vo) throws Exception {
	
		List<JoborderVO> result = dao.SearchMonitoringPage3_1(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SearchMonitoringPage3(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SearchMonitoringPage3(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> MonitoringPage3(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.MonitoringPage3(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> MonitoringPage2(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.MonitoringPage2(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SearchJbList3_1(JoborderVO vo) throws Exception{
		
		List<JoborderVO> result = dao.SearchJbList3_1(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SearchJbList3_2(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SearchJbList3_2(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> MonitoringPage1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.MonitoringPage1(vo);
		return result;
	}
	
	@Override
	public void UpdateJbWorkInspection(JoborderVO vo) throws Exception {
		
		dao.UpdateJbWorkInspection(vo);
	}
	
	public List<JoborderVO> Search1ProjectJobNo3(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.Search1ProjectJobNo3(vo);
		return result;
	}

	
	@Override
	public List<JoborderVO> Search1ProjectJobNo2(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.Search1ProjectJobNo2(vo);
		return result;
	}

	@Override
	public List<JoborderVO> Search1ProjectJobNo1(JoborderVO vo) throws Exception{
		
		List<JoborderVO> result = dao.Search1ProjectJobNo1(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> ProjectJobNo3_2(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.ProjectJobNo3_2(vo);
		return result;
	}

	@Override
	public List<JoborderVO> ProjectJobNo1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.ProjectJobNo1(vo);
		return result;
	}

	@Override
	public List<JoborderVO> ProjectJobNo2(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.ProjectJobNo2(vo);
		return result;
	}

	@Override
	public List<JoborderVO> ProjectJobNo3_1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.ProjectJobNo3_1(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> Home4(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.Home4(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> Home3(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.Home3(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> Home2(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.Home2(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> Home1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.Home1(vo);
		return result;
	}

	
	@Override
	public List<JoborderVO> FindSelectLog1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.FindSelectLog1(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> FindPlanProductionList1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.FindPlanProductionList1(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> FindPlanProductionList(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.FindPlanProductionList(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectPlanProductionList(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SelectPlanProductionList(vo);
		return result;
	}

	
	@Override
	public List<JoborderVO> FindSelectLog(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.FindSelectLog(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectLog(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SelectLog(vo);
		return result;
	}
	
	@Override
	public void UpdateNextJbProcess2(JoborderVO vo) throws Exception {
		
		dao.UpdateNextJbProcess2(vo);
	}
	
	@Override
	public List<JoborderVO> FindJobProcessEquipandResult(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.FindJobProcessEquipandResult(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectEndCancelEquip(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SelectEndCancelEquip(vo);
		return result;
	}
	
	@Override
	public void UpdateEndCancelJbProcessEquip(JoborderVO vo) throws Exception {
		
		dao.UpdateEndCancelJbProcess(vo);
	}
	
	@Override
	public void UpdateEndCancelJbProcess(JoborderVO vo) throws Exception {
		
		dao.UpdateEndCancelJbProcess(vo);
	}
	
	@Override
	public void UpdateLastEndJb(JoborderVO vo) throws Exception {
		
		dao.UpdateLastEndJb(vo);
	}
	
	@Override
	public void UpdateEndJbProcess(JoborderVO vo) throws Exception {
		
		dao.UpdateEndJbProcess(vo);
	}
	
	@Override
	public List<JoborderVO> ChkJbProcess(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.ChkJbProcess(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> ChkNextIdx(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.ChkNextIdx(vo);
		return result;
	}
	
	@Override
	public void UpdateNextJbProcess(JoborderVO vo) throws Exception {
		
		dao.UpdateNextJbProcess(vo);
	}
	
	@Override
	public void UpdateEndJbProcessResult(JoborderVO vo) throws Exception {
		
		dao.UpdateEndJbProcessResult(vo);
	}
	
	@Override
	public void UpdateJbInspection(JoborderVO vo) throws Exception {
		
		dao.UpdateJbInspection(vo);
	}
	
	@Override
	public List<JoborderVO> WorkerInspectionView(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.WorkerInspectionView(vo);
		return result;
	}
	
	@Override
	public void UpdateRestartJbEquip(JoborderVO vo) throws Exception {
		
		dao.UpdateRestartJbEquip(vo);
	}
	
	@Override
	public List<JoborderVO> SelectJbProcessReivseLast(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SelectJbProcessReivseLast(vo);
		return result;
	}
	
	@Override
	public void UpdateRestartJbProcess(JoborderVO vo) throws Exception {
		
		dao.UpdateRestartJbProcess(vo);
	}
	
	@Override
	public void DeleteJbEquip(JoborderVO vo) throws Exception {
		
		dao.DeleteJbEquip(vo);
	}
	
	@Override
	public int SelectSubDvision(JoborderVO vo) throws Exception {
		
		int result = dao.SelectSubDvision(vo);
		return result;
	}
	
	@Override
	public void UpdateJoborderCode(JoborderVO vo) throws Exception {
		
		dao.UpdateJoborderCode(vo);
	}
	
	@Override
	public void DeleteJbProcessStopTime(JoborderVO vo) throws Exception {
		
		dao.DeleteJbProcessStopTime(vo);
	}
	
	@Override
	public void DeleteJobStopTime(JoborderVO vo) throws Exception {
		
		dao.DeleteJobStopTime(vo);
	}
	
	@Override
	public void DeleteJbProcessRevise(JoborderVO vo) throws Exception {
		
		dao.DeleteJbProcessRevise(vo);
	}
	
	@Override
	public void UpdateStopAssign(JoborderVO vo) throws Exception {
		
		dao.UpdateStopAssign(vo);
	}
	
	@Override
	public void RegisterJobStopTime(JoborderVO vo) throws Exception {
		
		dao.RegisterJobStopTime(vo);
	}
	
	@Override
	public void UpdateJobCode(JoborderVO vo) throws Exception {
		
		dao.UpdateJobCode(vo);
	}
	
	@Override
	public List<JoborderVO> DetectActiveStart(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.DetectActiveStart(vo);
		return result;
	}

	@Override
	public List<JoborderVO> WorkerJobView1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.WorkerJobView1(vo);
		return result;
	}
	
	@Override
	public void DeleteFirstCancelJbEquip(JoborderVO vo) throws Exception {
		
		dao.DeleteFirstCancelJbEquip(vo);
	}
	
	@Override
	public void DeleteFirstCancelLog(JoborderVO vo) throws Exception {
		
		dao.DeleteFirstCancelLog(vo);
	}
	
	@Override
	public void UpdateFirstCancelJoborder(JoborderVO vo) throws Exception {
		
		dao.UpdateFirstCancelJoborder(vo);
	}
	
	@Override
	public void DeleteFirstCancelJbPrcoessResult(JoborderVO vo) throws Exception {
		
		dao.DeleteFirstCancelJbPrcoessResult(vo);
	}

	
	@Override
	public void UpdateFirstCancelJbProcess(JoborderVO vo) throws Exception {
		
		dao.UpdateFirstCancelJbProcess(vo);
	}
	
	@Override
	public void UpdateJobEquipStop(JoborderVO vo) throws Exception {
		
		dao.UpdateJobEquipStop(vo);
	}
	
	@Override
	public List<JoborderVO> SelectJoborderID(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SelectJoborderID(vo);
		return result;
	}
	
	@Override
	public void UpdateStopJbProcessResult(JoborderVO vo) throws Exception {
		
		dao.UpdateStopJbProcessResult(vo);
	}
	
	@Override
	public Date SelectStartTimeGet(JoborderVO vo) throws Exception {
		
		Date result = dao.SelectStartTimeGet(vo);
		return result;
	}
	
	@Override
	public void StartJbProcessResult(JoborderVO vo) throws Exception {
		
		dao.StartJbProcessResult(vo);
	}
	
	@Override
	public void UpdateStartJoborder(JoborderVO vo) throws Exception {
		
		dao.UpdateStartJoborder(vo);
	}
	
	@Override
	public void UpdateStartJbProcess(JoborderVO vo) throws Exception {
		
		dao.UpdateStartJbProcess(vo);
	}
	
	@Override
	public void StartLogRegister(JoborderVO vo) throws Exception {
		
		dao.StartLogRegister(vo);
	}
	
	@Override
	public List<JoborderVO> SelectPresetFile(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SelectPresetFile(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectJbProcessUniquess(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SelectJbProcessUniquess(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> FindJbProcessId(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.FindJbProcessId(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> WorkerAllJbList(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.WorkerAllJbList(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> WorkerPrcoessList(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.WorkerPrcoessList(vo);
		return result;
	}

	
	@Override
	public List<JoborderVO> SelectJoborderSubtitle(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SelectJoborderSubtitle(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectJbProcessFile(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SelectJbProcessFile(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectOneJoborder(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SelectOneJoborder(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectFindQRCode(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SelectFindQRCode(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectJbList(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SelectJbList(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SearchJbList1_1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SearchJbList1_1(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SearchJbList1_2(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SearchJbList1_2(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SearchJbList2_1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SearchJbList2_1(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SearchJbList2_2(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SearchJbList2_2(vo);
		return result;
	}
	
	@Override
	public int SelectJoborderDetailForm(JoborderVO vo) throws Exception {
		
		int result = dao.SelectJoborderDetailForm(vo);
		return result;
	}
	
	@Override
	public int FindDetailJbId(JoborderVO vo) throws Exception {
		
		int result = dao.FindDetailJbId(vo);
		return result;
	}
	
	@Override
	public String OneFindJBFileDirectory(JoborderVO vo) throws Exception {
		
		String result = dao.OneFindJBFileDirectory(vo);
		return result;
	}
	
	@Override
	public void DeleteAllJoborderFile(JoborderVO vo) throws Exception {
		
		dao.DeleteAllJoborderFile(vo);
	}
	
	@Override
	public void DeleteAllJoborderDetail(JoborderVO vo) throws Exception {
		
		dao.DeleteAllJoborderDetail(vo);
	}
	
	@Override
	public void DeleteAllJbProcess(JoborderVO vo) throws Exception {
		
		dao.DeleteAllJbProcess(vo);
	}
	
	@Override
	public void DeleteAllJbUniquess(JoborderVO vo) throws Exception {
		
		dao.DeleteAllJbUniquess(vo);
	}
	
	@Override
	public void DeleteJbUniquess(JoborderVO vo) throws Exception {
		
		dao.DeleteJbUniquess(vo);
	}
	
	@Override
	public void DeleteJoborderFile(JoborderVO vo) throws Exception {
		
		dao.DeleteJoborderFile(vo);
	}
	
	@Override
	public void DeleteJoborderQRCode(JoborderVO vo) throws Exception {
		
		dao.DeleteJoborderQRCode(vo);
	}
	
	@Override
	public void RegisterJoborderDetail(JoborderVO vo) throws Exception {
		
		dao.RegisterJoborderDetail(vo);
	}
	
	@Override
	public void RegisterJoborderUniquess(JoborderVO vo) throws Exception {
		
		dao.RegisterJoborderUniquess(vo);
	}
	
	@Override
	public void RegisterJoborderEquipment(JoborderVO vo) throws Exception {
		
		dao.RegisterJoborderEquipment(vo);
	}
	
	@Override
	public void RegisterJoborderFile(JoborderVO vo) throws Exception {
		
		dao.RegisterJoborderFile(vo);
	}
	
	@Override
	public void RegisterQRCode(JoborderVO vo) throws Exception {
		
		dao.RegisterQRCode(vo);
	}
	
	@Override
	public void RegisterProcessResult(JoborderVO vo) throws Exception {
		
		dao.RegisterProcessResult(vo);
	}
	
	@Override
	public void UpdateFocusOn1(JoborderVO vo) throws Exception {
		
		dao.UpdateFocusOn1(vo);
	}
	
	@Override
	public void UpdateFocusOn2(JoborderVO vo) throws Exception {
		
		dao.UpdateFocusOn2(vo);
	}
	
	@Override
	public void UpdateJbProcessLobby1(JoborderVO vo) throws Exception {
		
		dao.UpdateJbProcessLobby1(vo);
	}
	
	@Override
	public void UpdateJbProcessLobby2(JoborderVO vo) throws Exception {
		
		dao.UpdateJbProcessLobby2(vo);
	}
	
	@Override
	public void UpdateJoborderFileRegister(JoborderVO vo) throws Exception {
		
		dao.UpdateJoborderFileRegister(vo);
	}
	
	@Override
	public void UpdateJoborderDetail(JoborderVO vo) throws Exception {
		
		dao.UpdateJoborderDetail(vo);
	}
	
	@Override
	public void UpdatePublishJoborder(JoborderVO vo) throws Exception {
		
		dao.UpdatePublishJoborder(vo);
	}
	
	@Override
	public void CancelPublishJoborder(JoborderVO vo) throws Exception {
		
		dao.CancelPublishJoborder(vo);
	}
	
	@Override
	public void UpdateEmergencyJoborder(JoborderVO vo) throws Exception {
		
		dao.UpdateEmergencyJoborder(vo);
	}
	
	@Override
	public void UpdateJbLobbyStatus(JoborderVO vo) throws Exception {
		
		dao.UpdateJbLobbyStatus(vo);
	}
	
	@Override
	public void UpdateJBProcessFocus(JoborderVO vo) throws Exception {
		
		dao.UpdateJBProcessFocus(vo);
	}
	
	@Override
	public void UpdateJoborderEquipmentStart(JoborderVO vo) throws Exception {
		
		dao.UpdateJoborderEquipmentStart(vo);
	}
	
	@Override
	public void UpdateJoborderEquipmentEnd(JoborderVO vo) throws Exception {
		
		dao.UpdateJoborderEquipmentEnd(vo);
	}
	
	@Override
	public void DeleteJoborderDetail(JoborderVO vo) throws Exception {
		
		dao.DeleteJoborderDetail(vo);
	}
	
	@Override
	public void DeleteJoborder(JoborderVO vo) throws Exception {
		
		dao.DeleteJoborder(vo);
	}
	
	@Override
	public void RegisterJoborder(JoborderVO vo) throws Exception {
		
		dao.RegisterJoborder(vo);
	}
	
	@Override
	public void DeleteJoborderProcess(JoborderVO vo) throws Exception {
		
		dao.DeleteJoborderProcess(vo);
	}
	
	@Override
	public void RegisterJoborderProcess(JoborderVO vo) throws Exception {
		
		dao.RegisterJoborderProcess(vo);
	}
	
	@Override
	public void UpdateJBProcessSelfInspection(JoborderVO vo) throws Exception {
		
		dao.UpdateJBProcessSelfInspection(vo);
	}
	
	@Override
	public void UpdateJBProcessWorkTime(JoborderVO vo) throws Exception {
		
		dao.UpdateJBProcessWorkTime(vo);
	}
	
	@Override
	public void RegisterJoborderStopTime(JoborderVO vo) throws Exception {
		
		dao.RegisterJoborderStopTime(vo);
	}
	
	@Override
	public void RegisterJbProcessRevise(JoborderVO vo) throws Exception {
		
		dao.RegisterJbProcessRevise(vo);
	}
	
	@Override
	public void UpdateJbProcessRevise(JoborderVO vo) throws Exception {
		
		dao.UpdateJbProcessRevise(vo);
	}
	
	@Override
	public List<JoborderVO> DetectActiveOn(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.DetectActiveOn(vo);
		return result;
	}
	
	@Override
	public void UpdateReceiveOn1(JoborderVO vo) throws Exception {
		
		dao.UpdateReceiveOn1(vo);
	}
	
	@Override
	public void UpdateReceiveCancel(JoborderVO vo) throws Exception {
		
		dao.UpdateReceiveCancel(vo);
	}
	
	@Override	
	public void UpdateAssignOn1(JoborderVO vo) throws Exception {
		
		dao.UpdateAssignOn1(vo);
	}
	
	@Override
	public void UpdateAssignCancel(JoborderVO vo) throws Exception {
		
		dao.UpdateAssignCancel(vo);
	}

	@Override
	public void UpdateAssignWorker(JoborderVO vo) throws Exception {
		
		dao.UpdateAssignWorker(vo);
	}
	
	@Override
	public List<JoborderVO> AssignWorkerList(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.AssignWorkerList(vo);
		return result;
	}
	
	@Override
	public void UpdateJbContext(JoborderVO vo) throws Exception {
		
		dao.UpdateJbContext(vo);
	}
	
	@Override
	public void RegisterProcessResultValue(JoborderVO vo) throws Exception {
		
		dao.RegisterProcessResultValue(vo);
		
	}
	
	@Override
	public void RegisterProcessStartResult(JoborderVO vo) throws Exception {
		
		dao.RegisterProcessStartResult(vo);
	}
	
	@Override
	public void ReigsterProcessWorkerFile(JoborderVO vo) throws Exception {
		
		dao.ReigsterProcessWorkerFile(vo);
	}
	
	@Override
	public void DeleteProcessWorkerFile(JoborderVO vo) throws Exception {
		
		dao.DeleteProcessWorkerFile(vo);
	}
	
	@Override
	public List<JoborderVO> FindWorkerFileDir(JoborderVO vo) throws Exception {
		
		List<JoborderVO> resultlist = dao.FindWorkerFileDir(vo);
		return resultlist;
	}

	
	@Override
	public void UpdateJBRestartTime(JoborderVO vo) throws Exception {
		
		dao.UpdateJBRestartTime(vo);
	}
	
	@Override
	public List<JoborderVO> SelectJoborderDetail(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SelectJoborderDetail(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectJoborder(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SelectJoborder(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectJbProcessIndexChk(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SelectJbProcessIndexChk(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectJoborderIDProcess(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SelectJoborderIDProcess(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectJbProcessRevise(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.SelectJbProcessRevise(vo);
		return result;
	}
	
	@Override
	public int IdChkJob(JoborderVO vo) throws Exception {
		
		int result =dao.IdChkJob(vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> JbProcessUniquess(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = dao.JbProcessUniquess(vo);
		return result;
	}
	
	@Override
	public void UpdateJbProcessIndex(JoborderVO vo) throws Exception {
		
		dao.UpdateJbProcessIndex(vo);
	}
	
	@Override
	public void UpdateJbProcessAll(JoborderVO vo) throws Exception {
		
		dao.UpdateJbProcessAll(vo);
	}
}
