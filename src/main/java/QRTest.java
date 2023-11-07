import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import com.google.gson.JsonObject;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRTest {

	public static void main(String args[]) {
		
		try {
			
			SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");
			
			Date time = new Date();
			
			String time1 = format1.format(time);
			
			String path = ("D:\\QR Test\\");
			
			String realpath = path+time1;
			
			File Folder = new File(realpath);
			
			Folder.mkdirs();
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("JOBORDER_ID", 3);
			
			String cv = obj.toString();
			
			File saveQR = new File(realpath+"\\"+time1+".png");
			
			
			

			
			// QR코드인식 시 링크 걸 URL 주소
			String codeurl = new String(cv.getBytes("UTF-8"), "ISO-8859-1");
			
			// QR코드 컬러
			int qrcodeColor = 0xFF2e4e96;
			
			// QR코드 배경색상값
			int backgroundColor = 0xFFFFFFFF;
			
			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			
			//QR Code의 Width, Height 값
			BitMatrix bitMatrix = qrCodeWriter.encode(codeurl, BarcodeFormat.QR_CODE, 200, 200);
			
			MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig(qrcodeColor, backgroundColor);
			
			BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix, matrixToImageConfig);
			
			// ImageIO를 사용한 바코드 파일 쓰기
			
			ImageIO.write(bufferedImage, "png", saveQR);
			
		} catch (Exception e) {
			
		}
		
	}
	
}
