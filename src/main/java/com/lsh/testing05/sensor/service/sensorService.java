package com.lsh.testing05.sensor.service;

import java.util.List;

import com.lsh.testing05.sensor.vo.sensorVO;

public interface sensorService {

	public void InsertMC01(sensorVO vo) throws Exception;
	
	public void InsertMC02(sensorVO vo) throws Exception;
	
	public void InsertMC03(sensorVO vo) throws Exception;

	public void InsertMC04(sensorVO vo) throws Exception;
	
	public void InsertMC05(sensorVO vo) throws Exception;
	
	public void InsertMC06(sensorVO vo) throws Exception;
	
	public void InsertMC07(sensorVO vo) throws Exception;
	
	public void InsertMC08(sensorVO vo) throws Exception;
	
	public void InsertMC09(sensorVO vo) throws Exception;

	public void InsertMC10(sensorVO vo) throws Exception;
	
	public void InsertMC11(sensorVO vo) throws Exception;
	
	public void InsertBM01(sensorVO vo) throws Exception;

	public void InsertBM02(sensorVO vo) throws Exception;
	
	public void InsertBS01(sensorVO vo) throws Exception;
	
	public void InsertBS02(sensorVO vo) throws Exception;

	public void InsertBS03(sensorVO vo) throws Exception;
	
	public void InsertBS04(sensorVO vo) throws Exception;
	
	public void InsertPR01(sensorVO vo) throws Exception;

	public void InsertPR02(sensorVO vo) throws Exception;
	
	public void InsertPR03(sensorVO vo) throws Exception;
	
	public void InsertPR05(sensorVO vo) throws Exception;

	public void InsertSPLW01(sensorVO vo) throws Exception;
	
	public void InsertSPPW02(sensorVO vo) throws Exception;
	
	public void InsertSPPW03(sensorVO vo) throws Exception;
	
	public void InsertSPPW05(sensorVO vo) throws Exception;

	public void InsertSPPW06(sensorVO vo) throws Exception;
	
	public void InsertSPPW07(sensorVO vo) throws Exception;
	
	public void InsertSPTW04(sensorVO vo) throws Exception;
	
	public void InsertSPWI01(sensorVO vo) throws Exception;

	public void InsertSPWI02(sensorVO vo) throws Exception;
	
	public void InsertSPWI03(sensorVO vo) throws Exception;
	
	public void InsertSPWI04(sensorVO vo) throws Exception;
	
	public void InsertSPWI06(sensorVO vo) throws Exception;

	public void InsertSPWI07(sensorVO vo) throws Exception;
	
	public void InsertSPWI08(sensorVO vo) throws Exception;
	
	public void InsertSPWO01(sensorVO vo) throws Exception;
	
	public void InsertSPWO03(sensorVO vo) throws Exception;

	public void InsertSPWO04(sensorVO vo) throws Exception;
	
	public void InsertSPWO05(sensorVO vo) throws Exception;
	
	public void InsertSPWO06(sensorVO vo) throws Exception;
	
	public List<sensorVO> TestSensor(sensorVO vo) throws Exception;
	
	
	//Index4 관평동 2층
	public void SP_WI_02_DELETE(sensorVO vo) throws Exception;
	
	public void SP_WI_04_DELETE(sensorVO vo) throws Exception;	
	
	public void SP_WI_01_DELETE(sensorVO vo) throws Exception;
	
	public void SP_WI_06_DELETE(sensorVO vo) throws Exception;
	
	public void SP_WO_01_DELETE(sensorVO vo) throws Exception;
	
	public void SP_WO_05_DELETE(sensorVO vo) throws Exception;
	
	public void SP_WO_04_DELETE(sensorVO vo) throws Exception;
	
	public void SP_WO_06_DELETE(sensorVO vo) throws Exception;
	
	public void SP_WI_07_DELETE(sensorVO vo) throws Exception;
	
	public void SP_WI_08_DELETE(sensorVO vo) throws Exception;
	
	public void SP_WO_03_DELETE(sensorVO vo) throws Exception;
	
	public void SP_WI_03_DELETE(sensorVO vo) throws Exception;
	
	public void TC_04_DELETE(sensorVO vo) throws Exception;
	
	public List<sensorVO> SP_WI_02_TIME_POWER_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> SP_WI_02_TIME_RUN_ON(sensorVO vo) throws Exception;

	public List<sensorVO> SP_WI_04_TIME_POWER_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> SP_WI_04_TIME_RUN_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> SP_WI_01_TIME_POWER_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> SP_WI_01_TIME_RUN_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> SP_WI_06_TIME_POWER_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> SP_WI_06_TIME_RUN_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> SP_WO_01_TIME_POWER_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> SP_WO_01_TIME_RUN_ON(sensorVO vo) throws Exception;

	public List<sensorVO> SP_WO_05_TIME_POWER_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> SP_WO_05_TIME_RUN_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> SP_WO_04_TIME_POWER_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> SP_WO_04_TIME_RUN_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> SP_WO_06_TIME_POWER_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> SP_WO_06_TIME_RUN_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> SP_WI_07_TIME_POWER_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> SP_WI_07_TIME_RUN_ON(sensorVO vo) throws Exception;

	public List<sensorVO> SP_WI_08_TIME_POWER_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> SP_WI_08_TIME_RUN_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> SP_WO_03_TIME_POWER_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> SP_WO_03_TIME_RUN_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> SP_WI_03_TIME_POWER_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> SP_WI_03_TIME_RUN_ON(sensorVO vo) throws Exception;
	
	//Index3 관평동 1층
	public void SP_LW_01_DELETE(sensorVO vo) throws Exception;
	
	public void SP_PW_02_DELETE(sensorVO vo) throws Exception;
	
	public void SP_PW_03_DELETE(sensorVO vo) throws Exception;
	
	public void SP_TW_04_DELETE(sensorVO vo) throws Exception;
	
	public void SP_PW_05_DELETE(sensorVO vo) throws Exception;
	
	public void SP_PW_06_DELETE(sensorVO vo) throws Exception;
	
	public void SP_PW_07_DELETE(sensorVO vo) throws Exception;
	
	public void TC_03_DELETE(sensorVO vo) throws Exception;
	
	public List<sensorVO> SP_LW_01_TIME_POWER_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> SP_LW_01_TIME_RUN_ON(sensorVO vo) throws Exception;

	public List<sensorVO> SP_PW_02_TIME_POWER_ON(sensorVO vo) throws Exception;

	public List<sensorVO> SP_PW_02_TIME_RUN_ON(sensorVO vo) throws Exception;

	public List<sensorVO> SP_PW_03_TIME_POWER_ON(sensorVO vo) throws Exception;

	public List<sensorVO> SP_PW_03_TIME_RUN_ON(sensorVO vo) throws Exception;

	public List<sensorVO> SP_TW_04_TIME_POWER_ON(sensorVO vo) throws Exception;

	public List<sensorVO> SP_TW_04_TIME_RUN_ON(sensorVO vo) throws Exception;

	public List<sensorVO> SP_PW_05_TIME_POWER_ON(sensorVO vo) throws Exception;

	public List<sensorVO> SP_PW_05_TIME_RUN_ON(sensorVO vo) throws Exception;

	public List<sensorVO> SP_PW_06_TIME_POWER_ON(sensorVO vo) throws Exception;

	public List<sensorVO> SP_PW_06_TIME_RUN_ON(sensorVO vo) throws Exception;	
	
	public List<sensorVO> SP_PW_07_TIME_POWER_ON(sensorVO vo) throws Exception;

	public List<sensorVO> SP_PW_07_TIME_RUN_ON(sensorVO vo) throws Exception;
	
	//Index2 관평동 프레스실
	public void PR_01_DELETE(sensorVO vo) throws Exception;
	
	public void PR_02_DELETE(sensorVO vo) throws Exception;
	
	public void PR_03_DELETE(sensorVO vo) throws Exception;

	public void BS_04_DELETE(sensorVO vo) throws Exception;

	public void PR_05_DELETE(sensorVO vo) throws Exception;

	public void TC_02_DELETE(sensorVO vo) throws Exception;	
	
	public List<sensorVO> PR_01_TIME_POWER_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> PR_01_TIME_RUN_ON(sensorVO vo) throws Exception;	
	
	public List<sensorVO> PR_02_TIME_POWER_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> PR_02_TIME_RUN_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> PR_03_TIME_POWER_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> PR_03_TIME_RUN_ON(sensorVO vo) throws Exception;	

	public List<sensorVO> BS_04_TIME_POWER_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> BS_04_TIME_RUN_ON(sensorVO vo) throws Exception;	
	
	public List<sensorVO> PR_05_TIME_POWER_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> PR_05_TIME_RUN_ON(sensorVO vo) throws Exception;	
	
	//Index1 문지동
	public void MC_01_DELETE(sensorVO vo) throws Exception;
	
	public void MC_02_DELETE(sensorVO vo) throws Exception;
	
	public void MC_03_DELETE(sensorVO vo) throws Exception;
	
	public void MC_04_DELETE(sensorVO vo) throws Exception;
	
	public void MC_05_DELETE(sensorVO vo) throws Exception;
	
	public void MC_06_DELETE(sensorVO vo) throws Exception;
	
	public void MC_07_DELETE(sensorVO vo) throws Exception;
	
	public void MC_08_DELETE(sensorVO vo) throws Exception;
	
	public void MC_09_DELETE(sensorVO vo) throws Exception;
	
	public void MC_10_DELETE(sensorVO vo) throws Exception;
	
	public void MC_11_DELETE(sensorVO vo) throws Exception;
	
	public void BM_01_DELETE(sensorVO vo) throws Exception;
	
	public void BM_02_DELETE(sensorVO vo) throws Exception;
	
	public void BS_01_DELETE(sensorVO vo) throws Exception;
	
	public void BS_02_DELETE(sensorVO vo) throws Exception;
	
	public void BS_03_DELETE(sensorVO vo) throws Exception;

	public void TC_01_DELETE(sensorVO vo) throws Exception;
	
	public List<sensorVO> MC_01_TIME_POWER_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> MC_01_TIME_RUN_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> MC_01_TIME_ALARM_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> MC_02_TIME_POWER_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> MC_02_TIME_RUN_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> MC_02_TIME_ALARM_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> MC_03_TIME_POWER_ON(sensorVO vo) throws Exception;

	public List<sensorVO> MC_03_TIME_RUN_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> MC_03_TIME_ALARM_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> MC_04_TIME_POWER_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> MC_04_TIME_RUN_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> MC_04_TIME_ALARM_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> MC_05_TIME_POWER_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> MC_05_TIME_RUN_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> MC_05_TIME_ALARM_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> MC_06_TIME_POWER_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> MC_06_TIME_RUN_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> MC_06_TIME_ALARM_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> MC_07_TIME_POWER_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> MC_07_TIME_RUN_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> MC_07_TIME_ALARM_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> MC_08_TIME_POWER_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> MC_08_TIME_RUN_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> MC_08_TIME_ALARM_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> MC_09_TIME_POWER_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> MC_09_TIME_RUN_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> MC_09_TIME_ALARM_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> MC_10_TIME_POWER_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> MC_10_TIME_RUN_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> MC_10_TIME_ALARM_ON(sensorVO vo) throws Exception;

	public List<sensorVO> MC_11_TIME_POWER_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> MC_11_TIME_RUN_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> MC_11_TIME_ALARM_ON(sensorVO vo) throws Exception;	
	
	public List<sensorVO> BM_01_TIME_POWER_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> BM_01_TIME_RUN_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> BM_02_TIME_POWER_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> BM_02_TIME_RUN_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> BS_01_TIME_POWER_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> BS_01_TIME_RUN_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> BS_02_TIME_POWER_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> BS_02_TIME_RUN_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> BS_03_TIME_POWER_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> BS_03_TIME_RUN_ON(sensorVO vo) throws Exception;
	
	public List<sensorVO> Select_INDEX1(sensorVO vo) throws Exception;
	
	public List<sensorVO> Select_INDEX2(sensorVO vo) throws Exception;
	
	public List<sensorVO> Select_INDEX3(sensorVO vo) throws Exception;
	
	public List<sensorVO> Select_INDEX4(sensorVO vo) throws Exception;
	
	public void InsertSensor(sensorVO vo) throws Exception;

}
