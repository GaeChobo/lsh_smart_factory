package com.lsh.testing05.qrcode.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.lsh.testing05.qrcode.dao.QrcodeDAO;
import com.lsh.testing05.qrcode.vo.QrcodeVO;

@Service
public class QrcodeServiceImpl implements QrcodeService{

	@Inject
	QrcodeDAO dao;
	
	@Override
	public void CreateQrcode(QrcodeVO vo) throws Exception {
		
		dao.CreateQrcode(vo);
	}
}
