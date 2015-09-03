package adaptiveHW2_Functions;

import java.io.*;

public class Keywords_maker {
	
	public void keywords(int itemNo, String[] keywords, int itemSize, int z, String[] recom){
		
		String doc_name = "HW2_docs";
		
		if(z == 1) doc_name = "HW2_income_doc";
		
		String output_filename = "E:\\Documents\\Adaptive_HW2\\" + doc_name + "\\keywords_docs\\keywords" + itemNo + ".txt";
		
		try {
		
		FileOutputStream out = new FileOutputStream(output_filename);
		
		OutputStreamWriter ow = new OutputStreamWriter(out);
		
		for(int i = 0; i < keywords.length; i++){
			
			try {
            	
				ow.write(keywords[i] + " ");
            	
				ow.flush();
		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(itemNo == itemSize){
			
			if(z == 0){
				
				User_profile urprf = new User_profile();
				
				urprf.make_profile(itemSize);
				
			}
			
			else{
				
				Do_recommend recommend = new Do_recommend();
				
				recommend.recommend(itemSize, recom);
				
			}
			
			System.out.println("Keywords creation complete.");
			
		}
			
	}

}
