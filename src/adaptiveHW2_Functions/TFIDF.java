package adaptiveHW2_Functions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;

public class TFIDF {
	
	public double compute_tfidf(String word, int docNo, int itemSize, int z){
		
		double TF = tf(word, docNo, z);
		
		double IDF = idf(word, itemSize, z);
		
		return(TF * IDF);
		
	}
	
	public double tf(String word1, int docNo1, int z){
		
		String doc_name = "HW2_docs";
		
		if(z == 1) doc_name = "HW2_income_doc";
		
		StringBuffer bf = new StringBuffer();
		
		float countwords = 0, countappears = 0;
		
		int firstappear = 0, lastappear = 0;
		
		try {
			
			Scanner targetFile = new Scanner(new FileInputStream("E:\\Documents\\Adaptive_HW2\\" + doc_name + "\\stem_docs\\stemming" + docNo1 + ".txt"));
			
			while(targetFile.hasNext()){
				
				String s = targetFile.next();
				
				bf.append(s + " ");
				
				countwords = countwords + 1;

			}	
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String bfstring = bf.toString();
		
		lastappear = bfstring.lastIndexOf(word1);
		
		while(firstappear < lastappear){
			
			firstappear = bfstring.indexOf(word1, firstappear) + 1; 
			
			countappears = countappears + 1;
			
		}
		
		return(countappears / countwords);
		
	}
	
	public double idf(String word2, int itemSize1, int z){
		
		String doc_name = "HW2_docs";
		
		if(z == 1) doc_name = "HW2_income_doc";
		
		double countAmoDoc = 0;
		
		for(int i = 1; i <= itemSize1; i++){
			
			StringBuffer bf = new StringBuffer();
			
			try {
				
				Scanner targetFile = new Scanner(new FileInputStream("E:\\Documents\\Adaptive_HW2\\" + doc_name + "\\stem_docs\\stemming" + i + ".txt"));
				
				while(targetFile.hasNext()){
					
					String s = targetFile.next();
					
					bf.append(s + " ");

				}	
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String bfstring = bf.toString();
			
			if(bfstring.contains(word2)) countAmoDoc = countAmoDoc + 1;
			
		}
		
		return(Math.log10(itemSize1 / countAmoDoc));
		
	}

}