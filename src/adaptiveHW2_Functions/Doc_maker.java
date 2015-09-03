package adaptiveHW2_Functions;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Doc_maker {

	public void maker(int item, StringBuffer cont, int itemSize, int z){
		
		String doc_name = "HW2_docs";
		
		if(z == 1) doc_name = "HW2_income_doc";
	
		String info = cont.toString();
	
		int itemNo = item;
	
		FileOutputStream os = null;
	
		BufferedWriter bw = null;
	
		try {
		
			os = new FileOutputStream("E:\\Documents\\Adaptive_HW2\\" + doc_name + "\\raw_docs\\raw" + itemNo + ".txt");
			
			bw = new BufferedWriter(new OutputStreamWriter(os));
		
			bw.write(info);
		
			bw.flush();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
		
			os.close();
		
			bw.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(itemNo == itemSize){
			
			System.out.println("Creation for raw documents complete.");
			
		}
	
	}
	
}