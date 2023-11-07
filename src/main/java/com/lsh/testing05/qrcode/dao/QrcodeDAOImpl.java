package com.lsh.testing05.qrcode.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.lsh.testing05.qrcode.vo.QrcodeVO;

@Repository
public class QrcodeDAOImpl implements QrcodeDAO {

	@Inject
	private SqlSession sqlsession;
	
	public static final String namespace = "mapper.qrcodeMapper";

	
	@Override
	public void CreateQrcode(QrcodeVO vo) throws Exception {
		sqlsession.insert(namespace+".CreateQrcode", vo);
	}

}
