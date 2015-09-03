package adaptiveHW2_Functions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class User_profile {
	
	public void make_profile(int itemSize){
		
		StringBuffer checked = new StringBuffer();
		
		checked.append("");
		
		String[] userkey = new String[9999];
		
		int[] userkeyvalue = new int[9999];
		
		int n = 0;
		
		for(int i = 1; i <= itemSize; i++){
			
			try {
				
				Scanner targetFile0 = new Scanner(new FileInputStream("E:\\Documents\\Adaptive_HW2\\HW2_docs\\keywords_docs\\keywords" + i + ".txt"));
				
				while(targetFile0.hasNext()){
					
					int m = 1;
					
					// picks up a word
					String s0 = targetFile0.next();
					
					//figures out whether it has been checked
					String check_str = checked.toString();
					
					if(check_str.indexOf(s0) < 0){ //if not found
						
						if(i == 1){
							
							Scanner targetFile = new Scanner(new FileInputStream("E:\\Documents\\Adaptive_HW2\\HW2_docs\\keywords_docs\\keywords1.txt"));
							
							StringBuffer content = new StringBuffer();
							
							content.append("");
							
							while(targetFile.hasNext()){
								
								String s1 = targetFile.next();
								
								content.append(s1 + " ");
								
							}
							
							String content_str = content.toString();
							
							if(content_str.indexOf(s0) > -1){
								
								m = m + 1;
								
							}
							
						}
						
						else{
						
							for(int j = 1; j < i; j++){
							
								Scanner targetFile = new Scanner(new FileInputStream("E:\\Documents\\Adaptive_HW2\\HW2_docs\\keywords_docs\\keywords" + j + ".txt"));
							
								StringBuffer content = new StringBuffer();
							
								content.append("");
								
								while(targetFile.hasNext()){
								
									String s1 = targetFile.next();
								
									content.append(s1 + " ");
								
								}
							
								String content_str = content.toString();
							
								if(content_str.indexOf(s0) > -1){
								
									m = m + 1;
								
								}
							
							}
						
							for(int j = i + 1; j <= itemSize; j++){
								
								Scanner targetFile = new Scanner(new FileInputStream("E:\\Documents\\Adaptive_HW2\\HW2_docs\\keywords_docs\\keywords" + j + ".txt"));
								
								StringBuffer content = new StringBuffer();
								
								content.append("");
								
								while(targetFile.hasNext()){
									
									String s1 = targetFile.next();
									
									content.append(s1 + " ");
									
								}
								
								String content_str = content.toString();
								
								if(content_str.indexOf(s0) > -1){
									
									m = m + 1;
									
								}
								
							}
							
						}
						
						userkey[n] = s0;
						
						userkeyvalue[n] = m;
						
						n = n + 1;
						
						checked.append(s0 + " ");
						
					}
	
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}
		
		//calls sorter
		Sorter sorter = new Sorter();
		
		sorter.sorter2(userkey, userkeyvalue);
	
	}

}
