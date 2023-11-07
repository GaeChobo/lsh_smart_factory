package com.lsh.testing05;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.lsh.testing05.qrcode.service.QrcodeService;
import com.lsh.testing05.qrcode.vo.QrcodeVO;

@RestController
public class QrcodeController {

	private static final Logger logger = LoggerFactory.getLogger(QrcodeController.class);
	
	@Inject
	QrcodeService service;
	
	@RequestMapping(value = "/CreateQrcode", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public void CreateQrcode(QrcodeVO vo) throws Exception {
	
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");
		
		Date time = new Date();
		
		String time1 = format1.format(time);
		
		//C로 디렉 변경
		
		String path = ("C:\\factory\\admin\\qrcode\\");
		
		String realpath = path+time1;
		
		File Folder = new File(realpath);
		
		Folder.mkdirs();
		
		//이 URL 부분을 어떻게 할지가 기능의 관건이고 해결점 [1]
		String codeurl = new String("http://www.naver.com".getBytes("UTF-8"), "ISO-8859-1");
		
		//QR Code 컬러
		int qrcodeColor = 0xFF000000;
		
		//QR Code 배경컬러
		int backgroundColor = 0xFFFFFFFF;
		
		QRCodeWriter qrcodewriter = new QRCodeWriter();
		
		//QR Code의 Width, Height 값
		BitMatrix bitMatrix = qrcodewriter.encode(codeurl, BarcodeFormat.QR_CODE, 200, 200);
		
		MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig(qrcodeColor, backgroundColor);

		BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix, matrixToImageConfig);
		
		//db 저장용
		String lastfile = realpath+"\\qrtest.png";

		//최종적으로 세이브되는 거 
		
		//초단위로 들어올 때 어떻게 해결하는 법이 중요 해결점 [2]
		File savefile = new File(realpath+"\\qrtest.png");
		
		
		ImageIO.write(bufferedImage, "png", savefile);

		vo.setQRCODE_DIRECTORY(lastfile);
		
		service.CreateQrcode(vo);
	}
	
}
