package adaptiveHW2_Functions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Sorter{
	
    public void sorter1(String[] str, double[] vectors, int itemNo, int itemSize, int z, String[] recom){
    	
    	String doc_name = "HW2_docs";
		
		if(z == 1) doc_name = "HW2_income_doc";
    	
    	String[] str2 = new String[50];
    	
    	String output_filename = "E:\\Documents\\Adaptive_HW2\\" + doc_name + "\\vectorsort_docs\\sort" + itemNo + ".txt";
		
    	try{
    	
    		FileOutputStream out = new FileOutputStream(output_filename);
		
    		OutputStreamWriter ow = new OutputStreamWriter(out); 
        
    		for (int i = 0; i < vectors.length; i++){
    		
    			for (int j = 0; j < vectors.length; j++){
    				
    				double dou_temp;
    				
    				String str_temp;
    				
    				if (vectors[i] > vectors[j]){
					
    					dou_temp = vectors[j];
    					
    					str_temp = str[j];
					
    					vectors[j] = vectors[i];
    					
    					str[j] = str[i];
					
    					vectors[i] = dou_temp;
    					
    					str[i] = str_temp;
    					
    				}
    				
    			}
    			
    		}
    		
    		for (int i = 0; i < 50; i++) {
			
    			try {

    				str2[i] = str[i];
				
    				ow.write(str2[i] +  " " +vectors[i] + "\r\n");
	        	
    				ow.flush();
		
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			
    		}
    		
    		//calls keywords_maker to make key words for each docs
    		Keywords_maker maker = new Keywords_maker();
    		
    		maker.keywords(itemNo, str2, itemSize, z, recom);
        
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	if(itemNo == itemSize){
			
			System.out.println("Words sorting complete.");
			
		}
        
    }
    
    public void sorter2(String[] str, int[] vectors) {
        
    	String output_filename = "E:\\Documents\\Adaptive_HW2\\HW2_docs\\user_profile.txt";
		
    	try {
    		
    		FileOutputStream out = new FileOutputStream(output_filename);
		
    		OutputStreamWriter ow = new OutputStreamWriter(out); 
        
    		for (int i = 0; i < vectors.length; i++) {
    			
    			for (int j = 0; j < vectors.length; j++) {
    				
    				int int_temp;
    				
    				String str_temp;
    				
    				if (vectors[i] > vectors[j]) {
					
    					int_temp = vectors[j];
    					
    					str_temp = str[j];
					
    					vectors[j] = vectors[i];
    					
    					str[j] = str[i];
					
    					vectors[i] = int_temp;
    					
    					str[i] = str_temp;
    					
    				}
    				
    			}
    			
    		}
    		
    		for (int i = 0; i < 50; i++) {
			
    			try {
				
    				ow.write(str[i] + " ");
	        	
    				ow.flush();
		
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
			
    		}
        
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	System.out.println("User profile is created.");
        
    }
    
}
