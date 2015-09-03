package org.tartarus.snowball;

import java.io.Reader;
import java.io.Writer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.OutputStream;
import java.io.FileOutputStream;
import adaptiveHW2_Functions.TFIDF_Prepare;

public class TestApp{

    public void stemming(int itemSize, int itemNo, String dataDoc, int z, String[] recom) throws Throwable{
    	
    	String doc_name = "HW2_docs";
		
		if(z == 1) doc_name = "HW2_income_doc";

    	Class stemClass = Class.forName("org.tartarus.snowball.ext.englishStemmer");
	
    	SnowballStemmer stemmer = (SnowballStemmer) stemClass.newInstance();

    	Reader reader;
	
    	reader = new InputStreamReader(new FileInputStream(dataDoc));
	
    	reader = new BufferedReader(reader);

    	StringBuffer input = new StringBuffer();

    	OutputStream outstream;
      
    	outstream = new FileOutputStream("E:\\Documents\\Adaptive_HW2\\" + doc_name + "\\stem_docs\\stemming" + itemNo + ".txt");
    	
    	Writer output = new OutputStreamWriter(outstream);
	
    	output = new BufferedWriter(output);

    	int character;
	
    	while ((character = reader.read()) != -1){
		
    		char ch = (char) character;

    		if (Character.isWhitespace((char) ch)){
	    	
    			if (input.length() > 0){
			
    				stemmer.setCurrent(input.toString());

    				stemmer.stem();
		    
    				output.write(stemmer.getCurrent());
		    
    				output.write(" ");
		    
    				input.delete(0, input.length());
    			}
		
    		}
	    
    		else input.append(Character.toLowerCase(ch));
	    
    	}
	
    	output.flush();
    	
    	if(itemNo == itemSize){
    		
    		//calls tfidfPrepare to prepare for compute the vectors of each document
        	TFIDF_Prepare prepare = new TFIDF_Prepare();
        	
        	prepare.prepare(itemSize, z, recom);
        	
        	System.out.println("Stemming complete.");
    		
    	}
    	
    }
    
}
