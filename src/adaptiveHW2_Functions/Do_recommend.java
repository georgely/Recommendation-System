package adaptiveHW2_Functions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Do_recommend{
	
	public void recommend(int itemSize, String[] recom){
		
		int[] k = new int[itemSize];
		
		int[] f = new int[itemSize];
		
		for(int j = 0; j < itemSize; j++){
			
			k[j] = 0;
			
			f[j] = j + 1;
			
		}
		
		try {
			
			Scanner targetFile = new Scanner(new FileInputStream("E:\\Documents\\Adaptive_HW2\\HW2_docs\\user_profile.txt"));
			
			StringBuffer profile_buf = new StringBuffer();
			
			while(targetFile.hasNext()){
				
				String s = targetFile.next();
				
				profile_buf.append(s + " ");
				
			}
			
			String profile_str = profile_buf.toString();
			
			for(int i = 0; i < itemSize; i++){
				
				Scanner targetFile1 = new Scanner(new FileInputStream("E:\\Documents\\Adaptive_HW2\\HW2_income_doc\\keywords_docs\\keywords" + (i + 1) + ".txt"));
				
				while(targetFile1.hasNext()){
					
					String s1 = targetFile1.next();
					
					if(profile_str.indexOf(s1) > 0){
						
						k[i] = k[i] + 1;
						
					}
					
				}

			}
				
		} catch (FileNotFoundException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < k.length; i++){
			
			for (int j = 0; j < k.length; j++){
				
				int temp1, temp2;
				
				if (k[i] > k[j]){
					
					temp1 = k[j];
					
					temp2 = f[j];
					
					k[j] = k[i];
					
					f[j] = f[i];
					
					k[i] = temp1;
					
					f[i] = temp2;
				
				}
			
			}
		
		}
		
		String output_filename = "E:\\Documents\\Adaptive_HW2\\HW2_income_doc\\recommend.txt";
		
		try {
			
			FileOutputStream out = new FileOutputStream(output_filename);
			
			OutputStreamWriter ow = new OutputStreamWriter(out);
			
			for(int i = 0; i <itemSize; i++){
				
				try {
					
					ow.write("No." + (i + 1) + ":" + "\r\n" + recom[(f[i] - 1)] + "\r\n" + "\r\n");
	            	
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
		
		System.out.println("Recommendations are created.");
		
	}

}