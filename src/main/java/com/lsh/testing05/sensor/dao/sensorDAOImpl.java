package com.lsh.testing05.sensor.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.lsh.testing05.sensor.vo.sensorVO;

@Repository
public class sensorDAOImpl implements sensorDAO {

	@Inject
	private SqlSession sqlsession;
	
	public static final String namespace = "mapper.sensorMapper";

	@Override
	public void InsertMC01(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertMC01", vo);
	}
	
	@Override
	public void InsertMC02(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertMC02", vo);
	}
	
	@Override
	public void InsertMC03(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertMC03", vo);
	}

	@Override
	public void InsertMC04(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertMC04", vo);
	}
	
	@Override
	public void InsertMC05(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertMC05", vo);
	}
	
	@Override
	public void InsertMC06(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertMC06", vo);
	}
	
	@Override
	public void InsertMC07(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertMC07", vo);
	}
	
	@Override
	public void InsertMC08(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertMC08", vo);
	}
	
	@Override
	public void InsertMC09(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertMC09", vo);
	}

	@Override
	public void InsertMC10(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertMC10", vo);
	}
	
	@Override
	public void InsertMC11(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertMC11", vo);
	}
	
	@Override
	public void InsertBM01(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertBM01", vo);
	}

	@Override
	public void InsertBM02(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertBM02", vo);
	}
	
	@Override
	public void InsertBS01(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertBS01", vo);
	}
	
	@Override
	public void InsertBS02(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertBS02", vo);
	}

	@Override
	public void InsertBS03(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertBS03", vo);
	}
	
	@Override
	public void InsertBS04(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertBS04", vo);
	}
	
	@Override
	public void InsertPR01(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertPR01", vo);
	}

	@Override
	public void InsertPR02(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertPR02", vo);
	}
	
	@Override
	public void InsertPR03(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertPR03", vo);
	}
	
	@Override
	public void InsertPR05(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertPR05", vo);
	}

	@Override
	public void InsertSPLW01(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertSPLW01", vo);
	}
	
	@Override
	public void InsertSPPW02(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertSPPW02", vo);
	}
	
	@Override
	public void InsertSPPW03(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertSPPW03", vo);
	}
	
	@Override
	public void InsertSPPW05(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertSPPW05", vo);
	}

	@Override
	public void InsertSPPW06(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertSPPW06", vo);
	}
	
	@Override
	public void InsertSPPW07(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertSPPW07", vo);
	}
	
	@Override
	public void InsertSPTW04(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertSPTW04", vo);
	}
	
	@Override
	public void InsertSPWI01(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertSPWI01", vo);
	}

	@Override
	public void InsertSPWI02(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertSPWI02", vo);
	}
	
	@Override
	public void InsertSPWI03(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertSPWI03", vo);
	}
	
	@Override
	public void InsertSPWI04(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertSPWI04", vo);
	}
	
	@Override
	public void InsertSPWI06(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertSPWI06", vo);
	} 

	@Override
	public void InsertSPWI07(sensorVO vo) throws Exception  {
		
		sqlsession.insert(namespace+".InsertSPWI07", vo);
	}
	
	@Override
	public void InsertSPWI08(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertSPWI08", vo);
	}
	
	@Override
	public void InsertSPWO01(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertSPWO01", vo);
	}
	
	@Override
	public void InsertSPWO03(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertSPWO03", vo);
	}

	@Override
	public void InsertSPWO04(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertSPWO04", vo);
	}
	
	@Override
	public void InsertSPWO05(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertSPWO05", vo);
	}
	
	@Override
	public void InsertSPWO06(sensorVO vo) throws Exception {
		
		sqlsession.insert(namespace+".InsertSPWO06", vo);
	}
	
	@Override
	public List<sensorVO> TestSensor(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".TestSensor", vo);
		return result;
	}
	
	
	//Index4 관평동 2층

	@Override
	public void SP_WI_02_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".SP_WI_02_DELETE", vo);
	}
	
	@Override
	public void SP_WI_04_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".SP_WI_04_DELETE", vo);
	}
	
	@Override
	public void SP_WI_01_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".SP_WI_01_DELETE", vo);
	}
	
	@Override
	public void SP_WI_06_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".SP_WI_06_DELETE", vo);
	}
	
	@Override	
	public void SP_WO_01_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".SP_WO_01_DELETE", vo);
	}
	
	@Override
	public void SP_WO_05_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".SP_WO_05_DELETE", vo);
	}
	
	@Override
	public void SP_WO_04_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".SP_WO_04_DELETE", vo);
	}
	
	@Override
	public void SP_WO_06_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".SP_WO_06_DELETE", vo);
	}
	
	@Override
	public void SP_WI_07_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".SP_WI_07_DELETE", vo);
	}
	
	@Override
	public void SP_WI_08_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".SP_WI_08_DELETE", vo);
	}
	
	@Override
	public void SP_WO_03_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".SP_WO_03_DELETE", vo);
	}
	
	@Override
	public void SP_WI_03_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".SP_WI_03_DELETE", vo);
	}
	
	@Override
	public void TC_04_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".TC_04_DELETE", vo);
	}
	
	@Override
	public List<sensorVO> SP_WI_02_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_WI_02_TIME_POWER_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WI_02_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_WI_02_TIME_RUN_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WI_04_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_WI_04_TIME_POWER_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WI_04_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_WI_04_TIME_RUN_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WI_01_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_WI_01_TIME_POWER_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WI_01_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_WI_01_TIME_RUN_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WI_06_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_WI_06_TIME_POWER_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WI_06_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_WI_06_TIME_RUN_ON", vo);
		return result;
	}	
	
	@Override
	public List<sensorVO> SP_WO_01_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_WO_01_TIME_POWER_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WO_01_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_WO_01_TIME_RUN_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WO_05_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_WO_05_TIME_POWER_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WO_05_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_WO_05_TIME_RUN_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WO_04_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_WO_04_TIME_POWER_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WO_04_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_WO_04_TIME_RUN_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WO_06_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_WO_06_TIME_POWER_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WO_06_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_WO_06_TIME_RUN_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WI_07_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_WI_07_TIME_POWER_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WI_07_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_WI_07_TIME_RUN_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WI_08_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_WI_08_TIME_POWER_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WI_08_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_WI_08_TIME_RUN_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WO_03_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_WO_03_TIME_POWER_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WO_03_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_WO_03_TIME_RUN_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WI_03_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_WI_03_TIME_POWER_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_WI_03_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_WI_03_TIME_RUN_ON", vo);
		return result;
	}
	
	//INDEX3 관평동 1층
	
	@Override
	public void SP_LW_01_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".SP_LW_01_DELETE", vo);
	}
	
	@Override
	public void SP_PW_02_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".SP_PW_02_DELETE", vo);
	}
	
	@Override
	public void SP_PW_03_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".SP_PW_03_DELETE", vo);
	}
	
	@Override
	public void SP_TW_04_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".SP_TW_04_DELETE", vo);
	}
	
	@Override
	public void SP_PW_05_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".SP_PW_05_DELETE", vo);
	}
	
	@Override
	public void SP_PW_06_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".SP_PW_06_DELETE", vo);
	}
	
	@Override
	public void SP_PW_07_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".SP_PW_07_DELETE", vo);
	}
	
	@Override
	public void TC_03_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".TC_03_DELETE", vo);
	}
	
	@Override
	public List<sensorVO> SP_LW_01_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_LW_01_TIME_POWER_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> SP_LW_01_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_LW_01_TIME_RUN_ON", vo);
		return result;
	}

	@Override
	public List<sensorVO> SP_PW_02_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_PW_02_TIME_POWER_ON", vo);
		return result;
	}

	@Override
	public List<sensorVO> SP_PW_02_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_PW_02_TIME_RUN_ON", vo);
		return result;
	}

	@Override
	public List<sensorVO> SP_PW_03_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_PW_03_TIME_POWER_ON", vo);
		return result;
	}

	@Override
	public List<sensorVO> SP_PW_03_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_PW_03_TIME_RUN_ON", vo);
		return result;
	}

	@Override
	public List<sensorVO> SP_TW_04_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_TW_04_TIME_POWER_ON", vo);
		return result;
	}

	@Override
	public List<sensorVO> SP_TW_04_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_TW_04_TIME_RUN_ON", vo);
		return result;
	}

	@Override
	public List<sensorVO> SP_PW_05_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_PW_05_TIME_POWER_ON", vo);
		return result;
	}

	@Override
	public List<sensorVO> SP_PW_05_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_PW_05_TIME_RUN_ON", vo);
		return result;
	}

	@Override
	public List<sensorVO> SP_PW_06_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_PW_06_TIME_POWER_ON", vo);
		return result;
	}

	@Override
	public List<sensorVO> SP_PW_06_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_PW_06_TIME_RUN_ON", vo);
		return result;
	}	
	
	@Override
	public List<sensorVO> SP_PW_07_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_PW_07_TIME_POWER_ON", vo);
		return result;
	}

	@Override
	public List<sensorVO> SP_PW_07_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".SP_PW_07_TIME_RUN_ON", vo);
		return result;
	}
	
	//INDEX2 관평동 프레스실
	
	@Override
	public void PR_01_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".PR_01_DELETE", vo);
	}
	
	@Override
	public void PR_02_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".PR_02_DELETE", vo);
	}
	
	@Override
	public void PR_03_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".PR_03_DELETE", vo);
	}

	@Override
	public void BS_04_DELETE(sensorVO vo) throws Exception  {
		
		sqlsession.delete(namespace+".BS_04_DELETE", vo);
	}

	@Override
	public void PR_05_DELETE(sensorVO vo) throws Exception  {
		
		sqlsession.delete(namespace+".PR_05_DELETE", vo);
	}

	@Override
	public void TC_02_DELETE(sensorVO vo) throws Exception  {
		
		sqlsession.delete(namespace+".TC_02_DELETE", vo);
	}
	
	@Override
	public List<sensorVO> PR_01_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".PR_01_TIME_POWER_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> PR_01_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".PR_01_TIME_RUN_ON", vo);
		return result;
	}	
	
	@Override
	public List<sensorVO> PR_02_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".PR_02_TIME_POWER_ON", vo);
		return result;
	}
	@Override
	public List<sensorVO> PR_02_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".PR_02_TIME_RUN_ON", vo);
		return result;
	}
	@Override
	public List<sensorVO> PR_03_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".PR_03_TIME_POWER_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> PR_03_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".PR_03_TIME_RUN_ON", vo);
		return result;
	}	

	@Override
	public List<sensorVO> BS_04_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".BS_04_TIME_POWER_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> BS_04_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".BS_04_TIME_RUN_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> PR_05_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".PR_05_TIME_POWER_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> PR_05_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result = sqlsession.selectList(namespace+".PR_05_TIME_RUN_ON", vo);
		return result;
	}
	
	
	//INDEX1 문지동
	
	@Override
	public void MC_01_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".MC_01_DELETE", vo);
	}
	
	@Override
	public void MC_02_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".MC_02_DELETE", vo);
	}
	
	@Override
	public void MC_03_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".MC_03_DELETE", vo);
	}
	
	@Override
	public void MC_04_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".MC_04_DELETE", vo);
	}
	
	@Override
	public void MC_05_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".MC_05_DELETE", vo);
	}
	
	@Override
	public void MC_06_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".MC_06_DELETE", vo);
	}
	
	@Override
	public void MC_07_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".MC_07_DELETE", vo);
	}
	
	@Override
	public void MC_08_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".MC_08_DELETE", vo);
	}
	
	@Override
	public void MC_09_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".MC_09_DELETE", vo);
	}
	
	@Override
	public void MC_10_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".MC_10_DELETE", vo);
	}
	
	@Override
	public void MC_11_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".MC_11_DELETE", vo);
	}
	@Override
	public void BM_01_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".BM_01_DELETE", vo);
	}
	
	@Override
	public void BM_02_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".BM_02_DELETE", vo);
	}
	
	@Override
	public void BS_01_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".BS_01_DELETE", vo);
	}
	
	@Override
	public void BS_02_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".BS_02_DELETE", vo);
	}
	
	@Override
	public void BS_03_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".BS_03_DELETE", vo);
	}

	@Override
	public void TC_01_DELETE(sensorVO vo) throws Exception {
		
		sqlsession.delete(namespace+".TC_01_DELETE", vo);
	}
	
	@Override
	public List<sensorVO> MC_01_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".MC_01_TIME_POWER_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_01_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".MC_01_TIME_RUN_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_01_TIME_ALARM_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".MC_01_TIME_ALARM_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_02_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".MC_02_TIME_POWER_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_02_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".MC_02_TIME_RUN_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_02_TIME_ALARM_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".MC_02_TIME_ALARM_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_03_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".MC_03_TIME_POWER_ON", vo);
		return result;
	}

	@Override
	public List<sensorVO> MC_03_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".MC_03_TIME_RUN_ON", vo);
		return result;
	}
	@Override
	public List<sensorVO> MC_03_TIME_ALARM_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".MC_03_TIME_ALARM_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_04_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".MC_04_TIME_POWER_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_04_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".MC_04_TIME_RUN_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_04_TIME_ALARM_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".MC_04_TIME_ALARM_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_05_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".MC_05_TIME_POWER_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_05_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".MC_05_TIME_RUN_ON", vo);
		return result;
	}
	@Override
	public List<sensorVO> MC_05_TIME_ALARM_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".MC_05_TIME_ALARM_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_06_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".MC_06_TIME_POWER_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_06_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".MC_06_TIME_RUN_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_06_TIME_ALARM_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".MC_06_TIME_ALARM_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_07_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".MC_07_TIME_POWER_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_07_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".MC_07_TIME_RUN_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_07_TIME_ALARM_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".MC_07_TIME_ALARM_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_08_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".MC_08_TIME_POWER_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_08_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".MC_08_TIME_RUN_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_08_TIME_ALARM_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".MC_08_TIME_ALARM_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_09_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".MC_09_TIME_POWER_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_09_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".MC_09_TIME_RUN_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_09_TIME_ALARM_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".MC_09_TIME_ALARM_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_10_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".MC_10_TIME_POWER_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_10_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".MC_10_TIME_RUN_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_10_TIME_ALARM_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".MC_10_TIME_ALARM_ON", vo);
		return result;
	}

	@Override
	public List<sensorVO> MC_11_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".MC_11_TIME_POWER_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_11_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".MC_11_TIME_RUN_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> MC_11_TIME_ALARM_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".MC_11_TIME_ALARM_ON", vo);
		return result;
	}	
	
	@Override
	public List<sensorVO> BM_01_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".BM_01_TIME_POWER_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> BM_01_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".BM_01_TIME_RUN_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> BM_02_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".BM_02_TIME_POWER_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> BM_02_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".BM_02_TIME_RUN_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> BS_01_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".BS_01_TIME_POWER_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> BS_01_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".BS_01_TIME_RUN_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> BS_02_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".BS_02_TIME_POWER_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> BS_02_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".BS_02_TIME_RUN_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> BS_03_TIME_POWER_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".BS_03_TIME_POWER_ON", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> BS_03_TIME_RUN_ON(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".BS_03_TIME_RUN_ON", vo);
		return result;
	}
	
	
	
	
	@Override
	public List<sensorVO> Select_INDEX1(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".Select_INDEX1", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> Select_INDEX2(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".Select_INDEX2", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> Select_INDEX3(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".Select_INDEX3", vo);
		return result;
	}
	
	@Override
	public List<sensorVO> Select_INDEX4(sensorVO vo) throws Exception {
		
		List<sensorVO> result =  sqlsession.selectList(namespace+".Select_INDEX4", vo);
		return result;
	}
	
	
	@Override
	public void InsertSensor(sensorVO vo) throws Exception{
		sqlsession.insert(namespace+".InsertSensor", vo);
	}
}
