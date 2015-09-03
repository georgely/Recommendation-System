package adaptiveHW2_Functions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TFIDF_Prepare {
	
	public void prepare(int itemSize, int z, String[] recom){
		
		String doc_name = "HW2_docs";
		
		if(z == 1) doc_name = "HW2_income_doc";
		
		try {

			for(int i = 1; i <= itemSize; i++){
				
				Scanner targetFile = new Scanner(new FileInputStream("E:\\Documents\\Adaptive_HW2\\" + doc_name + "\\stem_docs\\stemming" + i + ".txt"));
				
				StringBuffer check = new StringBuffer();
				
				check.append(" ");
				
				String checkStr = "";
				
				String[] str = new String[9999];
				
				double[] vectors = new double[9999];
				
				int k = 0;
				
				while(targetFile.hasNext()){
				
					String s = targetFile.next();
					
					checkStr = check.toString();
					
					if(checkStr.indexOf(s) < 0){
						
						str[k] = s;
						
						check.append(s + " ");
						
						//calls tfidf to compute the vectors of each document
						TFIDF ti = new TFIDF();
						
						vectors[k] = ti.compute_tfidf(s, i, itemSize, z);
						
						k = k + 1;
						
					}
					
				}
				
				//calls sorter to sort the vectors
				Sorter sorter = new Sorter();
				
				sorter.sorter1(str, vectors, i, itemSize, z, recom);
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
