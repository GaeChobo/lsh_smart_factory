package com.lsh.testing05.sensor.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.lsh.testing05.sensor.dao.sensorDAO;
import com.lsh.testing05.sensor.vo.sensorVO;

@Service
public class sensorServiceImpl implements sensorService {

	@Inject
	sensorDAO dao;
	
	@Override
	public void InsertMC01(sensorVO vo) throws Exception {
		
		dao.InsertMC01(vo);
	}
	
	@Override
	public void InsertMC02(sensorVO vo) throws Exception {
		
		dao.InsertMC02(vo);
	}
	
	@Override
	public void InsertMC03(sensorVO vo) throws Exception {
		
		dao.InsertMC03(vo);
	}

	@Override
	public void InsertMC04(sensorVO vo) throws Exception {
		
		dao.InsertMC04(vo);
	}
	
	@Override
	public void InsertMC05(sensorVO vo) throws Exception {
		
		dao.InsertMC05(vo);
	}
	
	@Override
	public void InsertMC06(sensorVO vo) throws Exception {
		
		dao.InsertMC06(vo);
	}
	
	@Override
	public void InsertMC07(sensorVO vo) throws Exception {
		
		dao.InsertMC07(vo);
	}
	
	@Override
	public void InsertMC08(sensorVO vo) throws Exception {
		
		dao.InsertMC08(vo);
	}
	
	@Override
	public void InsertMC09(sensorVO vo) throws Exception {
		
		dao.InsertMC09(vo);
	}

	@Override
	public void InsertMC10(sensorVO vo) throws Exception {
		
		dao.InsertMC10(vo);
	}
	
	@Override
	public void InsertMC11(sensorVO vo) throws Exception {
		
		dao.InsertMC11(vo);
	}
	
	@Override
	public void InsertBM01(sensorVO vo) throws Exception {
		
		dao.InsertBM01(vo);
	}

	@Override
	public void InsertBM02(sensorVO vo) throws Exception {
		
		dao.InsertBM02(vo);
	}
	
	@Override
	public void InsertBS01(sensorVO vo) throws Exception {
		
		dao.InsertBS01(vo);
	}
	
	@Override
	public void InsertBS02(sensorVO vo) throws Exception {
		
		dao.InsertBS02(vo);
	}

	@Override
	public void InsertBS03(sensorVO vo) throws Exception {
		
		dao.InsertBS03(vo);
	}
	
	@Override
	public void InsertBS04(sensorVO vo) throws Exception {
		
		dao.InsertBS04(vo);
	}
	
	@Override
	public void InsertPR01(sensorVO vo) throws Exception {
		
		dao.InsertPR01(vo);
	}

	@Override
	public void InsertPR02(sensorVO vo) throws Exception {
		
		dao.InsertPR02(vo);
	}
	
	@Override
	public void InsertPR03(sensorVO vo) throws Exception {
		
		dao.InsertPR03(vo);
	}
	
	@Override
	public void InsertPR05(sensorVO vo) throws Exception {
		
		dao.InsertPR05(vo);
	}

	@Override
	public void InsertSPLW01(sensorVO vo) throws Exception {
		
		dao.InsertSPLW01(vo);
	}
	
	@Override
	public void InsertSPPW02(sensorVO vo) throws Exception {
		
		dao.InsertSPPW02(vo);
	}
	
	@Override
	public void InsertSPPW03(sensorVO vo) throws Exception {
		
		dao.InsertSPPW03(vo);
	}
	
	@Override
	public void InsertSPPW05(sensorVO vo) throws Exception {
		
		dao.InsertSPPW05(vo);
	}

	@Override
	public void InsertSPPW06(sensorVO vo) throws Exception {
		
		dao.InsertSPPW06(vo);
	}
	
	@Override
	public void InsertSPPW07(sensorVO vo) throws Exception {
		
		dao.InsertSPPW07(vo);
	}
	
	@Override
	public void InsertSPTW04(sensorVO vo) throws Exception {
		
		dao.InsertSPTW04(vo);
	}
	
	@Override
	public void InsertSPWI01(sensorVO vo) throws Exception {
		
		dao.InsertSPWI01(vo);
	}

	@Override
	public void InsertSPWI02(sensorVO vo) throws Exception {
		
		dao.InsertSPWI02(vo);
	}
	
	@Override
	public void InsertSPWI03(sensorVO vo) throws Exception {
		
		dao.InsertSPWI03(vo);
	}
	
	@Override
	public void InsertSPWI04(sensorVO vo) throws Exception {
		
		dao.InsertSPWI04(vo);
	}
	
	@Override
	public void InsertSPWI06(sensorVO vo) throws Exception {
		
		dao.InsertSPWI06(vo);
	} 

	@Override
	public void InsertSPWI07(sensorVO vo) throws Exception  {
		
		dao.InsertSPWI07(vo);
	}
	
	@Override
	public void InsertSPWI08(sensorVO vo) throws Exception {
		
		dao.InsertSPWI08(vo);
	}
	
	@Override
	public void InsertSPWO01(sensorVO vo) throws Exception {
		
		dao.InsertSPWO01(vo);
	}
	
	@Override
	public void InsertSPWO03(sensorVO vo) throws Exception {
		
		dao.InsertSPWO03(vo);
	}

	@Override
	public void InsertSPWO04(sensorVO vo) throws Exception {
		
		dao.InsertSPWO04(vo);
	}
	
	@Override
	public void InsertSPWO05(sensorVO vo) throws Exception {
		
		dao.InsertSPWO05(vo);
	}
	
	@Override
	public void InsertSPWO06(sensorVO vo) throws Exception {
		
		dao.InsertSPWO06(vo);
	}
	
	
	@Override
	public List<sensorVO> TestSensor(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.TestSensor(vo);
		return result;
	}
	
	
	//Index4 관평동 2층
	
	
	
	@Override
	public void SP_WI_02_DELETE(sensorVO vo) throws Exception {
		
		dao.SP_WI_02_DELETE(vo);
	}
	
	@Override
	public void SP_WI_04_DELETE(sensorVO vo) throws Exception {
		
		dao.SP_WI_04_DELETE(vo);
	}
	
	@Override
	public void SP_WI_01_DELETE(sensorVO vo) throws Exception {
		
		dao.SP_WI_01_DELETE(vo);
	}
	
	@Override
	public void SP_WI_06_DELETE(sensorVO vo) throws Exception {
		
		dao.SP_WI_06_DELETE(vo);
	}
	
	@Override
	public void SP_WO_01_DELETE(sensorVO vo) throws Exception {
		
		dao.SP_WO_01_DELETE(vo);
	}
	
	@Override
	public void SP_WO_05_DELETE(sensorVO vo) throws Exception {
		
		dao.SP_WO_05_DELETE(vo);
	}
	
	@Override
	public void SP_WO_04_DELETE(sensorVO vo) throws Exception {
		
		dao.SP_WO_04_DELETE(vo);
	}
	
	@Override
	public void SP_WO_06_DELETE(sensorVO vo) throws Exception {
		
		dao.SP_WO_06_DELETE(vo);
	}
	
	@Override
	public void SP_WI_07_DELETE(sensorVO vo) throws Exception {
		
		dao.SP_WI_07_DELETE(vo);
	}
	
	@Override
	public void SP_WI_08_DELETE(sensorVO vo) throws Exception {
		
		dao.SP_WI_08_DELETE(vo);
	}
	
	@Override
	public void SP_WO_03_DELETE(sensorVO vo) throws Exception {
		
		dao.SP_WO_03_DELETE(vo);
	}
	
	@Override
	public void SP_WI_03_DELETE(sensorVO vo) throws Exception {
		
		dao.SP_WI_03_DELETE(vo);
	}
	
	@Override
	public void TC_04_DELETE(sensorVO vo) throws Exception {
		
		dao.TC_04_DELETE(vo);
	}
	
	@Override
	public List<sensorVO> SP_WI_02_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_WI_02_TIME_POWER_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WI_02_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_WI_02_TIME_RUN_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WI_04_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_WI_04_TIME_POWER_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WI_04_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_WI_04_TIME_RUN_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WI_01_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_WI_01_TIME_POWER_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WI_01_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_WI_01_TIME_RUN_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WI_06_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_WI_06_TIME_POWER_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WI_06_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_WI_06_TIME_RUN_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WO_01_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_WO_01_TIME_POWER_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WO_01_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_WO_01_TIME_RUN_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WO_05_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_WO_05_TIME_POWER_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WO_05_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_WO_05_TIME_RUN_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WO_04_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_WO_04_TIME_POWER_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WO_04_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_WO_04_TIME_RUN_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WO_06_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_WO_06_TIME_POWER_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WO_06_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_WO_06_TIME_RUN_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WI_07_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_WI_07_TIME_POWER_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WI_07_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_WI_07_TIME_RUN_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WI_08_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_WI_08_TIME_POWER_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WI_08_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_WI_08_TIME_RUN_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WO_03_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_WO_03_TIME_POWER_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WO_03_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_WO_03_TIME_RUN_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WI_03_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_WI_03_TIME_POWER_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WI_03_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_WI_03_TIME_RUN_ON(vo);
		return result;
	}
	
	//Index3 관평동 1층
	
	@Override
	public void SP_LW_01_DELETE(sensorVO vo) throws Exception {
		
		dao.SP_LW_01_DELETE(vo);
	}
	
	@Override
	public void SP_PW_02_DELETE(sensorVO vo) throws Exception {
		
		dao.SP_PW_02_DELETE(vo);
	}
	
	@Override
	public void SP_PW_03_DELETE(sensorVO vo) throws Exception {
		
		dao.SP_PW_03_DELETE(vo);
	}
	
	@Override
	public void SP_TW_04_DELETE(sensorVO vo) throws Exception {
		
		dao.SP_TW_04_DELETE(vo);
	}
	
	@Override
	public void SP_PW_05_DELETE(sensorVO vo) throws Exception {
		
		dao.SP_PW_05_DELETE(vo);
	}
	
	@Override
	public void SP_PW_06_DELETE(sensorVO vo) throws Exception {
		
		dao.SP_PW_06_DELETE(vo);
	}
	
	@Override
	public void SP_PW_07_DELETE(sensorVO vo) throws Exception {
		
		dao.SP_PW_07_DELETE(vo);
	}
	
	@Override
	public void TC_03_DELETE(sensorVO vo) throws Exception {
		
		dao.TC_03_DELETE(vo);
	}
	
	@Override
	public List<sensorVO> SP_LW_01_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_LW_01_TIME_POWER_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_LW_01_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_LW_01_TIME_RUN_ON(vo);
		return result;
	}
	@Override
	public List<sensorVO> SP_PW_02_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_PW_02_TIME_POWER_ON(vo);
		return result;
	}

	@Override
	public List<sensorVO> SP_PW_02_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_PW_02_TIME_RUN_ON(vo);
		return result;
	}

	@Override
	public List<sensorVO> SP_PW_03_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_PW_03_TIME_POWER_ON(vo);
		return result;
	}
	@Override
	public List<sensorVO> SP_PW_03_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_PW_03_TIME_RUN_ON(vo);
		return result;
	}

	@Override
	public List<sensorVO> SP_TW_04_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_TW_04_TIME_POWER_ON(vo);
		return result;
	}

	@Override
	public List<sensorVO> SP_TW_04_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_TW_04_TIME_RUN_ON(vo);
		return result;
	}

	@Override
	public List<sensorVO> SP_PW_05_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_PW_05_TIME_POWER_ON(vo);
		return result;
	}

	@Override
	public List<sensorVO> SP_PW_05_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_PW_05_TIME_RUN_ON(vo);
		return result;
	}

	@Override
	public List<sensorVO> SP_PW_06_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_PW_06_TIME_POWER_ON(vo);
		return result;
	}

	@Override
	public List<sensorVO> SP_PW_06_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_PW_06_TIME_RUN_ON(vo);
		return result;
	}	
	
	@Override
	public List<sensorVO> SP_PW_07_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_PW_07_TIME_POWER_ON(vo);
		return result;
	}

	@Override
	public List<sensorVO> SP_PW_07_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.SP_PW_07_TIME_RUN_ON(vo);
		return result;
	}
	
	//Index2 관평동 프레스실
	
	@Override
	public void PR_01_DELETE(sensorVO vo) throws Exception {
		
		dao.PR_01_DELETE(vo);
	}
	
	@Override
	public void PR_02_DELETE(sensorVO vo) throws Exception{
		
		dao.PR_02_DELETE(vo);
	}
	
	@Override
	public void PR_03_DELETE(sensorVO vo) throws Exception{
		
		dao.PR_03_DELETE(vo);
	}
	
	@Override
	public void BS_04_DELETE(sensorVO vo) throws Exception{
		
		dao.BS_04_DELETE(vo);
	}
	
	@Override
	public void PR_05_DELETE(sensorVO vo) throws Exception{
		
		dao.PR_05_DELETE(vo);
	}
	
	@Override
	public void TC_02_DELETE(sensorVO vo) throws Exception{
		
		dao.TC_02_DELETE(vo);
	}
	
	@Override
	public List<sensorVO> PR_01_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.PR_01_TIME_POWER_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> PR_01_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.PR_01_TIME_RUN_ON(vo);
		return result;
	}
	@Override
	public List<sensorVO> PR_02_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.PR_02_TIME_POWER_ON(vo);
		return result;
	}
	@Override
	public List<sensorVO> PR_02_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.PR_02_TIME_RUN_ON(vo);
		return result;
	}
	@Override
	public List<sensorVO> PR_03_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.PR_03_TIME_POWER_ON(vo);
		return result;
	}
	@Override
	public List<sensorVO> PR_03_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.PR_03_TIME_RUN_ON(vo);
		return result;
	}
	@Override
	public List<sensorVO> BS_04_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.BS_04_TIME_POWER_ON(vo);
		return result;
	}
	@Override
	public List<sensorVO> BS_04_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.BS_04_TIME_RUN_ON(vo);
		return result;
	}
	@Override
	public List<sensorVO> PR_05_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.PR_05_TIME_POWER_ON(vo);
		return result;
	}
	@Override
	public List<sensorVO> PR_05_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.PR_05_TIME_RUN_ON(vo);
		return result;
	}
	
	//INDEX1 문지동
	
	@Override
	public void MC_01_DELETE(sensorVO vo) throws Exception {
		
		dao.MC_01_DELETE(vo);
	}
	
	@Override
	public void MC_02_DELETE(sensorVO vo) throws Exception {
		
		dao.MC_02_DELETE(vo);
	}
	
	@Override
	public void MC_03_DELETE(sensorVO vo) throws Exception {
		
		dao.MC_03_DELETE(vo);
	}
	
	@Override
	public void MC_04_DELETE(sensorVO vo) throws Exception {
		
		dao.MC_04_DELETE(vo);
	}
	
	@Override
	public void MC_05_DELETE(sensorVO vo) throws Exception {
		
		dao.MC_05_DELETE(vo);
	}
	
	@Override
	public void MC_06_DELETE(sensorVO vo) throws Exception {
		
		dao.MC_06_DELETE(vo);
	}
	
	@Override
	public void MC_07_DELETE(sensorVO vo) throws Exception {
		
		dao.MC_07_DELETE(vo);
	}
	
	@Override
	public void MC_08_DELETE(sensorVO vo) throws Exception {
		
		dao.MC_08_DELETE(vo);
	}
	
	@Override
	public void MC_09_DELETE(sensorVO vo) throws Exception {
		
		dao.MC_09_DELETE(vo);
	}
	
	@Override
	public void MC_10_DELETE(sensorVO vo) throws Exception {
		
		dao.MC_10_DELETE(vo);
	}
	
	@Override
	public void MC_11_DELETE(sensorVO vo) throws Exception {
		
		dao.MC_11_DELETE(vo);
	}
	
	@Override
	public void BM_01_DELETE(sensorVO vo) throws Exception {
		
		dao.BM_01_DELETE(vo);
	}
	
	@Override
	public void BM_02_DELETE(sensorVO vo) throws Exception {
		
		dao.BM_02_DELETE(vo);
	}
	
	@Override
	public void BS_01_DELETE(sensorVO vo) throws Exception {
		
		dao.BS_01_DELETE(vo);
	}
	
	@Override
	public void BS_02_DELETE(sensorVO vo) throws Exception {
		
		dao.BS_02_DELETE(vo);
	}
	
	@Override
	public void BS_03_DELETE(sensorVO vo) throws Exception {
		
		dao.BS_03_DELETE(vo);
	}

	@Override
	public void TC_01_DELETE(sensorVO vo) throws Exception {
		
		dao.TC_01_DELETE(vo);
	}
	
	@Override
	public List<sensorVO> MC_01_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.MC_01_TIME_POWER_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_01_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.MC_01_TIME_RUN_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_01_TIME_ALARM_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.MC_01_TIME_ALARM_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_02_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.MC_02_TIME_POWER_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_02_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.MC_02_TIME_RUN_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_02_TIME_ALARM_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.MC_02_TIME_ALARM_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_03_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.MC_03_TIME_POWER_ON(vo);
		return result;
	}

	@Override
	public List<sensorVO> MC_03_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.MC_03_TIME_RUN_ON(vo);
		return result;
	}
	@Override
	public List<sensorVO> MC_03_TIME_ALARM_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.MC_03_TIME_ALARM_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_04_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.MC_04_TIME_POWER_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_04_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.MC_04_TIME_RUN_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_04_TIME_ALARM_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.MC_04_TIME_ALARM_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_05_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.MC_05_TIME_POWER_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_05_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.MC_05_TIME_RUN_ON(vo);
		return result;
	}
	@Override
	public List<sensorVO> MC_05_TIME_ALARM_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.MC_05_TIME_ALARM_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_06_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.MC_06_TIME_POWER_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_06_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.MC_06_TIME_RUN_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_06_TIME_ALARM_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.MC_06_TIME_ALARM_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_07_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.MC_07_TIME_POWER_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_07_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.MC_07_TIME_RUN_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_07_TIME_ALARM_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.MC_07_TIME_ALARM_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_08_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.MC_08_TIME_POWER_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_08_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.MC_08_TIME_RUN_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_08_TIME_ALARM_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.MC_08_TIME_ALARM_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_09_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.MC_09_TIME_POWER_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_09_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.MC_09_TIME_RUN_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_09_TIME_ALARM_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.MC_09_TIME_ALARM_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_10_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.MC_10_TIME_POWER_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_10_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.MC_10_TIME_RUN_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_10_TIME_ALARM_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.MC_10_TIME_ALARM_ON(vo);
		return result;
	}

	@Override
	public List<sensorVO> MC_11_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.MC_11_TIME_POWER_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_11_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.MC_11_TIME_RUN_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_11_TIME_ALARM_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.MC_11_TIME_ALARM_ON(vo);
		return result;
	}	
	
	@Override
	public List<sensorVO> BM_01_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.BM_01_TIME_POWER_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> BM_01_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.BM_01_TIME_RUN_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> BM_02_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.BM_02_TIME_POWER_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> BM_02_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.BM_02_TIME_RUN_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> BS_01_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.BS_01_TIME_POWER_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> BS_01_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.BS_01_TIME_RUN_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> BS_02_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.BS_02_TIME_POWER_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> BS_02_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.BS_02_TIME_RUN_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> BS_03_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.BS_03_TIME_POWER_ON(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> BS_03_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  dao.BS_03_TIME_RUN_ON(vo);
		return result;
	}
	
	
	@Override
	public List<sensorVO> Select_INDEX1(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.Select_INDEX1(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> Select_INDEX2(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.Select_INDEX2(vo);
		return result;
	}

	@Override
	public List<sensorVO> Select_INDEX3(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.Select_INDEX3(vo);
		return result;
	}
	
	@Override
	public List<sensorVO> Select_INDEX4(sensorVO vo) throws Exception {
		
		List<sensorVO> result = dao.Select_INDEX4(vo);
		return result;
	}
	
	@Override
	public void InsertSensor(sensorVO vo) throws Exception {
		
		dao.InsertSensor(vo);
	}
	
}
