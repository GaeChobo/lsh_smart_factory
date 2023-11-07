package com.lsh.testing05.joborder.dao;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.lsh.testing05.joborder.vo.JoborderVO;

@Repository
public class JoborderDAOImpl implements JoborderDAO {

	@Inject
	private SqlSession sqlsession;
	
	private static final String namespace = "mapper.joborderMapper";

	
	@Override
	public List<JoborderVO> LabelExport(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".LabelExport", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> BomnDetailValue(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".BomnDetailValue", vo);
		return result;
	}
	
	@Override
	public int CreateJoborderBOM(JoborderVO vo) throws Exception {
		
		int result = sqlsession.selectOne(namespace+".CreateJoborderBOM", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> FindSameJobNum(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".FindSameJobNum", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> EquipWorkerList(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".EquipWorkerList", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> MonitoringStatusPage(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".MonitoringStatusPage", vo);
		return result;
	}
	
	@Override
	public String FindJobProcessName(JoborderVO vo) throws Exception {
		
		String result = sqlsession.selectOne(namespace+".FindJobProcessName", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> AccountIdAssignJob(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".AccountIdAssignJob", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> AccountIdAssignCount(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".AccountIdAssignCount", vo);
		return result;
	}
	
	@Override
	public String FinidProcessOriginName(JoborderVO vo) throws Exception {
		
		String result = sqlsession.selectOne(namespace+".FinidProcessOriginName", vo);
		return result;
	}
	
	@Override
	public Integer FindProcessOriginid(JoborderVO vo) throws Exception {
		
		Integer result = sqlsession.selectOne(namespace+".FindProcessOriginid", vo);
		return result;
	}
	
	@Override
	public Integer FindRunEquipName(JoborderVO vo) throws Exception {
		
		Integer result = sqlsession.selectOne(namespace+".FindRunEquipName", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> CategoryOriginEquipSelect(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".CategoryOriginEquipSelect", vo);
		return result;
	}
	
	@Override
	public void AllDeleteProcessResult(JoborderVO vo) throws Exception {
		
		sqlsession.delete(namespace+".AllDeleteProcessResult", vo);
		
	}
	
	@Override
	public List<JoborderVO> FindJobDetail(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".FindJobDetail", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> FindJobID(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".FindJobID", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> FindJobRun(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".FindJobRun", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> FindProcessTemplateID(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".FindProcessTemplateID", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> FindProcessResultID(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".FindJobEquipName", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> FindJobEquipName(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".FindJobEquipName", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectOriginEquipName(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SelectOriginEquipName", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectIndex1OriginID(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SelectIndex1OriginID", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectIndex2OriginID(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SelectIndex2OriginID", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectIndex3OriginID(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SelectIndex3OriginID", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectIndex4OriginID(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SelectIndex4OriginID", vo);
		return result;
	}
	
	
	@Override
	public List<JoborderVO> Home2_1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".Home2_1", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> EquipNowList1_1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".EquipNowList1_1", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectEquipID(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SelectEquipID", vo);
		return result;
	}
	
	@Override
	public void DeleteListProcessWorkerFile(JoborderVO vo) throws Exception {
		
		sqlsession.delete(namespace+".DeleteListProcessWorkerFile", vo);
	}
	
	@Override
	public List<JoborderVO> TestCountDetail(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".TestCountDetail", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> FindProcessStatus(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".FindProcessStatus", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> FindJBFileDir(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".FindJBFileDir", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectJobStopList(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SelectJobStopList", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SearchJbList1_1_1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SearchJbList1_1_1", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SearchJbList1_2_1(JoborderVO vo) throws Exception {
	
		List<JoborderVO> result = sqlsession.selectList(namespace+".SearchJbList1_2_1", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SearchJbList2_1_1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SearchJbList2_1_1", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SearchJbList2_2_1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SearchJbList2_2_1", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SearchJbList3_1_1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SearchJbList3_1_1", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SearchJbList3_2_1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SearchJbList3_2_1", vo);
		return result;
	}
	
	@Override
	public int ReturnProcessValue(JoborderVO vo) throws Exception {
		
		int result = sqlsession.selectOne(namespace+".ReturnProcessValue", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> EquipNowList3(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".EquipNowList3", vo);
		return result;
	}
	@Override
	public Integer EquipNowList2(JoborderVO vo) throws Exception {
		
		Integer result = sqlsession.selectOne(namespace+".EquipNowList2", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> EquipNowList1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".EquipNowList1", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> JobNotest(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".JobNotest", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SearchOutSourcingOutList1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SearchOutSourcingOutList1", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SearchOutSourcingOutList2(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SearchOutSourcingOutList2", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SearchOutSourcingOutEndList1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SearchOutSourcingOutEndList1", vo);
		return result;

	}
	
	@Override
	public List<JoborderVO> SearchOutSourcingOutEndList2(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SearchOutSourcingOutEndList2", vo);
		return result;

	}
	
	@Override
	public List<JoborderVO> OutSourcingOutEndList(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".OutSourcingOutEndList", vo);
		return result;

	}
	
	@Override
	public List<JoborderVO> OutSourcingOutList(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".OutSourcingOutList", vo);
		return result;
	}
	
	@Override
	public void UpdateWorkOut(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateWorkOut", vo);
	}
	

	
	@Override
	public List<JoborderVO> MonitoringPage4(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".MonitoringPage4", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SearchMonitoringPage3_1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SearchMonitoringPage3_1", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SearchMonitoringPage3(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SearchMonitoringPage3", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> MonitoringPage3(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".MonitoringPage3", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> MonitoringPage2(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".MonitoringPage2", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SearchJbList3_1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SearchJbList3_1", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SearchJbList3_2(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SearchJbList3_2", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> MonitoringPage1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".MonitoringPage1", vo);
		return result;
	}
	
	@Override
	public void UpdateJbWorkInspection(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateJbWorkInspection", vo);
	}
	
	@Override
	public List<JoborderVO> Search1ProjectJobNo3(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".Search1ProjectJobNo3", vo);
		return result;
	}
	
	@Override	
	public List<JoborderVO> Search1ProjectJobNo2(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".Search1ProjectJobNo2", vo);
		return result;

	}

	@Override	
	public List<JoborderVO> Search1ProjectJobNo1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".Search1ProjectJobNo1", vo);
		return result;

	}
	
	@Override
	public List<JoborderVO> ProjectJobNo3_2(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".ProjectJobNo3_2", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> ProjectJobNo1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".ProjectJobNo1", vo);
		return result;
	}
		
	@Override
	public List<JoborderVO> ProjectJobNo2(JoborderVO vo) throws Exception{
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".ProjectJobNo2", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> ProjectJobNo3_1(JoborderVO vo) throws Exception{
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".ProjectJobNo3_1", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> Home4(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".Home4", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> Home3(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".Home3", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> Home2(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".Home2", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> Home1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".Home1", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> FindSelectLog1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".FindSelectLog1", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> FindPlanProductionList1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".FindPlanProductionList1", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> FindPlanProductionList(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".FindPlanProductionList", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectPlanProductionList(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SelectPlanProductionList", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> FindSelectLog(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".FindSelectLog", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectLog(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SelectLog", vo);
		return result;
	}
	
	@Override
	public void UpdateNextJbProcess2(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateNextJbProcess2", vo);
	}
	
	@Override
	public List<JoborderVO> FindJobProcessEquipandResult(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".FindJobProcessEquipandResult", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectEndCancelEquip(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SelectEndCancelEquip", vo);
		return result;
	}
	
	@Override
	public void UpdateEndCancelJbProcessEquip(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateEndCancelJbProcessEquip", vo);
	}
	
	@Override
	public void UpdateEndCancelJbProcess(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateEndCancelJbProcess" , vo);
	}
	
	@Override
	public void UpdateLastEndJb(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateLastEndJb", vo);
	}
	
	@Override
	public void UpdateEndJbProcess(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateEndJbProcess", vo);
	}
	
	@Override
	public List<JoborderVO> ChkJbProcess(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".ChkJbProcess", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> ChkNextIdx(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".ChkNextIdx", vo);
		return result;
	}
	
	@Override
	public void UpdateNextJbProcess(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateNextJbProcess", vo);
	}
	
	@Override
	public void UpdateEndJbProcessResult(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateEndJbProcessResult", vo);
	}
	
	@Override
	public void UpdateJbInspection(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateJbInspection", vo);
	}
	
	@Override
	public List<JoborderVO> WorkerInspectionView(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".WorkerInspectionView", vo);
		return result;
	}
	
	@Override
	public void UpdateRestartJbEquip(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateRestartJbEquip", vo);
		
	}
	
	
	@Override
	public List<JoborderVO> SelectJbProcessReivseLast(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SelectJbProcessReivseLast", vo);
		return result;
	}
	
	@Override
	public void UpdateRestartJbProcess(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateRestartJbProcess", vo);
	}
	
	@Override
	public void DeleteJbEquip(JoborderVO vo) throws Exception {
		
		sqlsession.delete(namespace+".DeleteJbEquip", vo);
	}
	
	@Override
	public int SelectSubDvision(JoborderVO vo) throws Exception {
		
		int result = sqlsession.selectOne(namespace+".SelectSubDvision" , vo);
		return result;
	}
	
	@Override
	public void UpdateJoborderCode(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateJoborderCode", vo);
	}
	
	@Override
	public void DeleteJbProcessStopTime(JoborderVO vo) throws Exception {
		
		sqlsession.delete(namespace+".DeleteJbProcessStopTime", vo);
	}
	
	@Override	
	public void DeleteJobStopTime(JoborderVO vo) throws Exception {
	
		sqlsession.delete(namespace+".DeleteJobStopTime", vo);
	}
	
	@Override
	public void DeleteJbProcessRevise(JoborderVO vo) throws Exception {
		
		sqlsession.delete(namespace+".DeleteJbProcessRevise", vo);
	}
	
	@Override
	public void UpdateStopAssign(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateStopAssign", vo);
	}
	
	@Override
	public void RegisterJobStopTime(JoborderVO vo) throws Exception {
		
		sqlsession.insert(namespace+".RegisterJobStopTime", vo);
	}
	
	@Override
	public void UpdateJobCode(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateJobCode", vo);
		
	}
	
	@Override
	public List<JoborderVO> DetectActiveStart(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".DetectActiveStart", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> WorkerJobView1(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".WorkerJobView1", vo);
		return result;
	}
	
	@Override
	public void DeleteFirstCancelJbEquip(JoborderVO vo) throws Exception {
		
		sqlsession.delete(namespace+".DeleteFirstCancelJbEquip", vo);
	}
	
	@Override
	public void DeleteFirstCancelLog(JoborderVO vo) throws Exception {
		
		sqlsession.delete(namespace+".DeleteFirstCancelLog", vo);
	}
	
	@Override
	public void UpdateFirstCancelJoborder(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateFirstCancelJoborder", vo);
	}
	
	@Override
	public void DeleteFirstCancelJbPrcoessResult(JoborderVO vo) throws Exception {
		
		sqlsession.delete(namespace+".DeleteFirstCancelJbPrcoessResult", vo);
	}
	
	@Override
	public void UpdateFirstCancelJbProcess(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateFirstCancelJbProcess", vo);
	}
	
	@Override
	public void UpdateJobEquipStop(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateJobEquipStop", vo);
	}
	
	@Override
	public List<JoborderVO> SelectJoborderID(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SelectJoborderID", vo);
		return result;
	}
	
	@Override
	public void UpdateStopJbProcessResult(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateStopJbProcessResult", vo);
	}
	
	@Override
	public Date SelectStartTimeGet(JoborderVO vo) throws Exception {
	
		Date result = sqlsession.selectOne(namespace+".SelectStartTimeGet" , vo);
		return result;
	}
	
	@Override
	public void StartJbProcessResult(JoborderVO vo) throws Exception {
		
		sqlsession.insert(namespace+".StartJbProcessResult", vo);
	}
	
	@Override
	public void UpdateStartJoborder(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateStartJoborder", vo);
	}
	
	@Override
	public void UpdateStartJbProcess(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateStartJbProcess", vo);
	}
	
	@Override
	public void StartLogRegister(JoborderVO vo) throws Exception {
		
		sqlsession.insert(namespace+".StartLogRegister", vo);
	}
	
	@Override
	public List<JoborderVO> DetectActiveOn(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".DetectActiveOn", vo);
		return result;
	}
	
	@Override
	public void UpdateReceiveOn1(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateReceiveOn1", vo);
	}
	
	@Override
	public void UpdateReceiveCancel(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateReceiveCancel", vo);
	}
	
	@Override
	public void UpdateAssignOn1(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateAssignOn1", vo);
	}
	
	@Override
	public void UpdateAssignCancel(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateAssignCancel", vo);
	}
	
	@Override
	public void UpdateAssignWorker(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateAssignWorker", vo);
	}
	
	@Override
	public List<JoborderVO> AssignWorkerList(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".AssignWorkerList", vo);
		return result;
	}
	
	@Override
	public void UpdateJbContext(JoborderVO vo) throws Exception {
	
		sqlsession.update(namespace+".UpdateJbContext", vo);
	}
	
	@Override
	public List<JoborderVO> SelectPresetFile(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SelectPresetFile", vo);
		return result;
		
	}
	
	@Override
	public List<JoborderVO> SelectJbProcessUniquess(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SelectJbProcessUniquess", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> FindJbProcessId(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".FindJbProcessId", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> WorkerAllJbList(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".WorkerAllJbList");
		return result;
	}
	
	@Override
	public List<JoborderVO> WorkerPrcoessList(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".WorkerPrcoessList");
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectJoborderSubtitle(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SelectJoborderSubtitle", vo);
		return result;
		
	}
	
	@Override
	public List<JoborderVO> SelectJbProcessFile(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SelectJbProcessFile", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectJbList(JoborderVO vo) throws Exception {
		List<JoborderVO> resultlist = sqlsession.selectList(namespace+".SelectJbList", vo);
		return resultlist;
	}
	
	@Override
	public List<JoborderVO> SearchJbList1_1(JoborderVO vo) throws Exception {
		List<JoborderVO> resultlist = sqlsession.selectList(namespace+".SearchJbList1_1", vo);
		return resultlist;
	}
	
	@Override
	public List<JoborderVO> SearchJbList1_2(JoborderVO vo) throws Exception {
		List<JoborderVO> resultlist = sqlsession.selectList(namespace+".SearchJbList1_2", vo);
		return resultlist;
	}
	
	@Override
	public List<JoborderVO> SearchJbList2_1(JoborderVO vo) throws Exception {
		List<JoborderVO> resultlist = sqlsession.selectList(namespace+".SearchJbList2_1", vo);
		return resultlist;
	}
	
	@Override
	public List<JoborderVO> SearchJbList2_2(JoborderVO vo) throws Exception {
		List<JoborderVO> resultlist = sqlsession.selectList(namespace+".SearchJbList2_2", vo);
		return resultlist;
	}
	
	@Override
	public List<JoborderVO> SelectOneJoborder(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SelectOneJoborder", vo);
		return result;
	}
	
	@Override
	public int FindDetailJbId(JoborderVO vo) throws Exception {
		
		int result = sqlsession.selectOne(namespace+".FindDetailJbId", vo);
		return result;
	}
	
	@Override
	public int SelectJoborderDetailForm(JoborderVO vo) throws Exception {
		
		int result = sqlsession.selectOne(namespace+".SelectJoborderDetailForm", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectFindQRCode(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SelectFindQRCode", vo);
		return result;
	}
	
	@Override
	public String OneFindJBFileDirectory(JoborderVO vo) throws Exception {
		
		String result = sqlsession.selectOne(namespace+".OneFindJBFileDirectory", vo);
		return result;
	}
	
	@Override
	public void RegisterProcessResult(JoborderVO vo) throws Exception {
		
		sqlsession.insert(namespace+".RegisterProcessResult", vo);
	}
	
	@Override
	public void UpdateFocusOn1(JoborderVO vo) throws Exception {
	
		sqlsession.update(namespace+".UpdateFocusOn1", vo);
	}
	
	@Override	
	public void UpdateFocusOn2(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateFocusOn2", vo);
	}
	
	@Override
	public void UpdateJbProcessLobby1(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateJbProcessLobby1", vo);
	}
	
	@Override
	public void UpdateJbProcessLobby2(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateJbProcessLobby2", vo);
	}
	
	@Override
	public void DeleteAllJoborderDetail(JoborderVO vo) throws Exception {
		
		sqlsession.delete(namespace+".DeleteAllJoborderDetail" , vo);
	}
	
	@Override
	public void DeleteAllJoborderFile(JoborderVO vo) throws Exception {
		
		sqlsession.delete(namespace+".DeleteAllJoborderFile" , vo);
	}
	
	@Override
	public void DeleteAllJbProcess(JoborderVO vo) throws Exception {
		
		sqlsession.delete(namespace+".DeleteAllJbProcess", vo);
	}
	
	@Override
	public void DeleteJoborderFile(JoborderVO vo) throws Exception {
		
		sqlsession.delete(namespace+".DeleteJoborderFile", vo);
	}
	
	@Override
	public void DeleteJoborderQRCode(JoborderVO vo) throws Exception {
		
		sqlsession.delete(namespace+".DeleteJoborderQRCode", vo);
	}
	
	@Override
	public void RegisterJoborderDetail(JoborderVO vo) throws Exception {
		
		sqlsession.insert(namespace+".RegisterJoborderDetail", vo);
		
	}
	
	@Override
	public void RegisterJoborderFile(JoborderVO vo) throws Exception {
		
		sqlsession.insert(namespace+".RegisterJoborderFile", vo);
	}
	
	@Override
	public void RegisterJoborderUniquess(JoborderVO vo) throws Exception {
		
		sqlsession.insert(namespace+".RegisterJoborderUniquess", vo);
	}
	
	@Override
	public void RegisterJoborderEquipment(JoborderVO vo) throws Exception {
		
		sqlsession.insert(namespace+".RegisterJoborderEquipment", vo);
	}

	@Override
	public void UpdateJbProcessIndex(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateJbProcessIndex", vo);
	}
	
	@Override
	public void UpdateJbProcessAll(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateJbProcessAll", vo);
	}
	
	@Override
	public void RegisterQRCode(JoborderVO vo) throws Exception {
		
		sqlsession.insert(namespace+".RegisterQRCode", vo);
	}
	
	@Override
	public void UpdateJoborderFileRegister(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateJoborderFileRegister", vo);
	}
	
	@Override
	public void UpdateJoborderDetail(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateJoborderDetail", vo);
	}
	
	@Override
	public void UpdatePublishJoborder(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdatePublishJoborder", vo);
	}
	
	@Override
	public void CancelPublishJoborder(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".CancelPublishJoborder", vo);
	}
	
	@Override
	public void UpdateEmergencyJoborder(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateEmergencyJoborder", vo);
	}
	
	@Override
	public void UpdateJbLobbyStatus(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateJbLobbyStatus", vo);
	}
	
	@Override
	public void UpdateJBProcessFocus(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateJBProcessFocus", vo);
	}
	
	@Override
	public void UpdateJoborderEquipmentStart(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateJoborderEquipmentStart", vo);
	}
	
	@Override
	public void UpdateJoborderEquipmentEnd(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateJoborderEquipmentEnd",vo);
	}
	
	@Override
	public void DeleteJoborderDetail(JoborderVO vo) throws Exception {
		
		sqlsession.delete(namespace+".DeleteJoborderDetail", vo);
	}
	
	@Override
	public void DeleteJoborder(JoborderVO vo) throws Exception {
		
		sqlsession.delete(namespace+".DeleteJoborder", vo);
	}
	
	@Override
	public void RegisterJoborder(JoborderVO vo) throws Exception {
		
		sqlsession.insert(namespace+".RegisterJoborder", vo);
	}
	
	@Override
	public void DeleteJoborderProcess(JoborderVO vo) throws Exception {
		
		sqlsession.delete(namespace+".DeleteJoborderProcess", vo);
	}
	
	@Override
	public void RegisterJoborderProcess(JoborderVO vo) throws Exception {
		
		sqlsession.insert(namespace+".RegisterJoborderProcess", vo);
	}
	
	@Override
	public void UpdateJBProcessSelfInspection(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateJBProcessSelfInspection" , vo);
	}
	
	@Override
	public void UpdateJBProcessWorkTime(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateJBProcessWorkTime", vo);
	}
	
	@Override
	public void RegisterJoborderStopTime(JoborderVO vo) throws Exception {
		
		sqlsession.insert(namespace+".RegisterJoborderStopTime", vo);
	}
	
	@Override
	public void RegisterJbProcessRevise(JoborderVO vo) throws Exception {
		
		sqlsession.insert(namespace+".RegisterJbProcessRevise", vo);
	}
	
	@Override
	public void UpdateJbProcessRevise(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateJbProcessRevise", vo);
	}
	
	@Override
	public void RegisterProcessResultValue(JoborderVO vo) throws Exception {
		
		sqlsession.insert(namespace+".RegisterProcessResultValue", vo);
	}
	
	@Override
	public void ReigsterProcessWorkerFile(JoborderVO vo) throws Exception {
		
		sqlsession.insert(namespace+".ReigsterProcessWorkerFile", vo);
	}
	
	@Override
	public void DeleteProcessWorkerFile(JoborderVO vo) throws Exception {
		
		sqlsession.delete(namespace+".DeleteProcessWorkerFile", vo);
	}
	@Override
	public void DeleteAllJbUniquess(JoborderVO vo) throws Exception {
		
		sqlsession.delete(namespace+".DeleteAllJbUniquess", vo);
	}

	@Override
	public void DeleteJbUniquess(JoborderVO vo) throws Exception {
		
		sqlsession.delete(namespace+".DeleteJbUniquess", vo);
	}
	
	
	
	@Override
	public List<JoborderVO> FindWorkerFileDir(JoborderVO vo) throws Exception {
		
		List<JoborderVO> resultlist = sqlsession.selectList(namespace+".FindWorkerFileDir", vo);
		return resultlist;
	}
	
	@Override
	public void RegisterProcessStartResult(JoborderVO vo) throws Exception {
		
		sqlsession.insert(namespace+".RegisterProcessStartResult", vo);
	}
	
	@Override
	public void UpdateJBRestartTime(JoborderVO vo) throws Exception {
		
		sqlsession.update(namespace+".UpdateJBRestartTime", vo);
	}
	
	@Override
	public List<JoborderVO> SelectJoborderDetail(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SelectJoborderDetail");
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectJoborder(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SelectJoborder");
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectJbProcessIndexChk(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SelectJbProcessIndexChk", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> SelectJoborderIDProcess(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SelectJoborderIDProcess", vo);
		return result;
		
	}
	
	@Override	
	public List<JoborderVO> SelectJbProcessRevise(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".SelectJbProcessRevise", vo);
		return result;
		
	}
	
	@Override
	public int IdChkJob(JoborderVO vo) throws Exception {
		
		int result = sqlsession.selectOne(namespace+".IdChkJob", vo);
		return result;
	}
	
	@Override
	public List<JoborderVO> JbProcessUniquess(JoborderVO vo) throws Exception {
		
		List<JoborderVO> result = sqlsession.selectList(namespace+".JbProcessUniquess", vo);
		return result;
	}

	
}
