import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class LottoTask {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		String strDate = sdf.format(new Date());
		// Lotto Example
		
		        int[] sel = new int[6];    
		        // 중복되지않는 값 출력
		        for (int i=0; i <sel.length; i++) {
		            sel[i] = (int)(Math.random()* 45+1);        // 초기 i값 설정
		            for (int j=0; j<i; j++) {                // sel[i]에 할당된 값과 sel[0]~sel[i-1] 까지의 값 비교 후 동일한 값이 존재한다면
		                if (sel[i] == sel[j]) {                // i값을 i-1 하여 다시 처리
		                    sel[i] = (int)(Math.random()* 6+1);
		                    i--;                                
		                }
		            }
		        }

		        FileWriter fw = null;
				try {
					fw = new FileWriter("Lotto2zo.txt");
				} catch (IOException e) {
					e.printStackTrace();
				}
		        BufferedWriter bw = new BufferedWriter(fw);
		       
		        try {
					bw.write("로또");
					bw.newLine();
			        bw.write(sel[0] +" "+ sel[1] +" "+ sel[2] +" "+ sel[3] +" "+ sel[4] +" "+ sel[5]);
			        bw.newLine();
			        bw.write(strDate);
			        bw.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
	}

}
