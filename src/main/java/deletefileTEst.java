import java.io.File;

public class deletefileTEst {
	
	public static void main(String[] args) {
		
		File file = new File("D:\\2020-12-07_17-21-07");
		
		
		//파일 존재여부 확인
		if(file.exists()) {
			
			//파일이 디렉토리인지 확인
			if(file.isDirectory()) {
				
				File[] files = file.listFiles();
				
				for(int i = 0; i < files.length; i++) {
					if(files[i].delete()) {
						
					}else {
						
					}
				}
				
				if(file.delete()) {
					
				}else {
					
				}
			}
		}else {
			System.out.println("파일이 존재하지 않음");
		}
		
	}
}
