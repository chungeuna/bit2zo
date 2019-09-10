import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class LottoTask {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��");
		String strDate = sdf.format(new Date());
		// Lotto Example
		
		        int[] sel = new int[6];    
		        // �ߺ������ʴ� �� ���
		        for (int i=0; i <sel.length; i++) {
		            sel[i] = (int)(Math.random()* 45+1);        // �ʱ� i�� ����
		            for (int j=0; j<i; j++) {                // sel[i]�� �Ҵ�� ���� sel[0]~sel[i-1] ������ �� �� �� ������ ���� �����Ѵٸ�
		                if (sel[i] == sel[j]) {                // i���� i-1 �Ͽ� �ٽ� ó��
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
					bw.write("�ζ�");
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
