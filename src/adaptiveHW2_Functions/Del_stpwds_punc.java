package adaptiveHW2_Functions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import org.tartarus.snowball.*;

public class Del_stpwds_punc {
	
	public void delete(int itemSize, int item, String title, String desc, int z, String[] recom){
		
		String doc_name = "HW2_docs";
		
		if(z == 1) doc_name = "HW2_income_doc";
		
		int itemNo = item;
		
		String[] stopWrds = {"a","able","about","above","abst","accordance","according","accordingly","across",
        		"act","actually","added","adj","affected","affecting","affects","after","afterwards","again",
        		"against","ago","ah","all","almost","alone","along","already","also","although","always","am","among",
        		"amongst","an","and","announce","another","any","anybody","anyhow","anymore","anyone","anything",
        		"anyway","anyways","anywhere","apparently","approximately","are","aren","arent","arise","around",
        		"as","aside","ask","asking","at","auth","available","away","awfully","b","back","be","became",
        		"because","become","becomes","becoming","been","before","beforehand","begin","beginning","beginnings",
        		"begins","behind","being","believe","below","beside","besides","between","beyond","biol","both",
        		"brief","briefly","but","by","c","ca","came","can","cannot","can't","cause","causes","certain",
        		"certainly","co","com","come","comes","contain","containing","contains","could","couldnt","d","date",
        		"did","didn't","different","do","does","doesn't","doing","done","don't","down","downwards","due",
        		"during","e","each","ed","edu","effect","eg","eight","eighty","either","else","elsewhere","enable","end",
        		"ending","enough","especially","et","et-al","etc","even","ever","every","everybody","everyone",
        		"everything","everywhere","ex","except","f","far","few","ff","fifth","first","five","fix","followed",
        		"following","follows","for","former","formerly","forth","found","four","from","further","furthermore",
        		"g","gave","get","gets","getting","give","given","gives","giving","go","goes","gone","got","gotten",
        		"h","had","happens","hardly","has","hasn't","have","haven't","having","he","hed","hence","her",
        		"here","hereafter","hereby","herein","heres","hereupon","hers","herself","hes","hi","hid","him",
        		"himself","his","hither","home","how","howbeit","however","hundred","i","id","ie","if","i'll","im",
        		"immediate","immediately","importance","important","in","inc","indeed","index","information",
        		"instead","into","invention","inward","is","isn't","it","itd","it'll","its","itself","i've","j",
        		"just","k","keep","keeps","kept","kg","km","know","known","knows","l","largely","last","lately",
        		"later","latter","latterly","least","less","lest","let","lets","like","liked","likely","line",
        		"little","'ll","look","looking","looks","ltd","m","made","mainly","make","makes","many","may",
        		"maybe","me","mean","means","meantime","meanwhile","merely","mg","might","million","miss","ml",
        		"more","moreover","most","mostly","mr","mrs","much","mug","must","my","myself","n","na","name",
        		"namely","nay","nd","near","nearly","necessarily","necessary","need","needs","neither","never",
        		"nevertheless","new","next","nine","ninety","no","nobody","non","none","nonetheless","noone","nor",
        		"normally","nos","not","noted","nothing","now","nowhere","o","obtain","obtained","obviously","of",
        		"off","often","oh","ok","okay","old","omitted","on","once","one","ones","only","onto","or","ord",
        		"other","others","otherwise","ought","our","ours","ourselves","out","outside","over","overall",
        		"owing","own","p","page","pages","part","particular","particularly","past","per","perhaps","placed",
        		"please","plus","pm","poorly","possible","possibly","potentially","pp","predominantly","present",
        		"previously","primarily","probably","promptly","proud","provides","put","q","que","quickly","quite",
        		"qv","r","ran","rather","rd","re","readily","really","recent","recently","ref","refs","regarding",
        		"regardless","regards","related","relatively","research","respectively","resulted","resulting",
        		"results","right","run","s","said","same","saw","say","saying","says","sec","section","see","seeing",
        		"seem","seemed","seeming","seems","seen","self","selves","sent","seven","several","shall","she",
        		"shed","she'll","shes","should","shouldn't","show","showed","shown","showns","shows","significant",
        		"significantly","similar","similarly","since","six","slightly","so","some","somebody","somehow",
        		"someone","somethan","something","sometime","sometimes","somewhat","somewhere","soon","sorry",
        		"specifically","specified","specify","specifying","still","stop","strongly","sub","substantially",
        		"successfully","such","sufficiently","suggest","sup","sure","t","take","taken","taking","tell",
        		"tends","th","than","thank","thanks","thanx","that","that'll","thats","that've","the","their",
        		"theirs","them","themselves","then","thence","there","thereafter","thereby","thered","therefore",
        		"therein","there'll","thereof","therere","theres","thereto","thereupon","there've","these","they",
        		"theyd","they'll","theyre","they've","think","this","those","thou","though","thoughh","thousand",
        		"throug","through","throughout","thru","thus","til","tip","to","together","too","took","toward",
        		"towards","tried","tries","truly","try","trying","ts","twice","two","u","un","under","unfortunately",
        		"unless","unlike","unlikely","until","unto","up","upon","ups","us","use","used","useful","usefully",
        		"usefulness","uses","using","usually","v","value","various","'ve","very","via","viz","vol","vols",
        		"vs","w","want","wants","was","wasn't","way","we","wed","welcome","we'll","went","were","weren't",
        		"we've","what","whatever","what'll","whats","when","whence","whenever","where","whereafter","whereas",
        		"whereby","wherein","wheres","whereupon","wherever","whether","which","while","whim","whither",
        		"who","whod","whoever","whole","who'll","whom","whomever","whos","whose","why","widely","will","willing",
        		"wish","with","within","without","won't","words","world","would","wouldn't","www","x","y","yes","yet",
        		"you","youd","you'll","your","youre","yours","yourself","yourselves","you've","z","zero"};
		
		try {
			
			Scanner fip1 = new Scanner(title);
			
			Scanner fip2 = new Scanner(desc);
			
			String output_filename = "E:\\Documents\\Adaptive_HW2\\" + doc_name + "\\stpws_free_docs\\stpws_free" + itemNo + ".txt";
	
			FileOutputStream out = new FileOutputStream(output_filename);
			
			OutputStreamWriter ow = new OutputStreamWriter(out);
			
			while(fip1.hasNext()){
    	
				int flag1 = 1;
        
				String s1 = fip1.next();
        
				s1 = s1.toLowerCase();
        
				for(int i = 0; i < stopWrds.length; i++){
        	
					if(s1.equals(stopWrds[i])) flag1 = 0;
            
					else{

						s1 = s1.replaceAll("\\pP", "");
						
						s1 = s1.replaceAll("\\pS", "");
						
						s1 = s1.replaceAll("\\pN", "");
            	
					}
            
				}
        
				if(flag1 != 0){

					try {
            	
						ow.write(s1 + " ");
            	
						ow.flush();
				
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            
				}
                                
			}
			
			try {
            	
				ow.write("\r\n");
    	
				ow.flush();
		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			while(fip2.hasNext()){
		    	
				int flag2 = 1;
        
				String s2 = fip2.next();
        
				s2 = s2.toLowerCase();
        
				for(int i = 0; i < stopWrds.length; i++){
        	
					if(s2.equals(stopWrds[i])) flag2 = 0;
            
					else{

						s2 = s2.replaceAll("\\pP", "");
						
						s2 = s2.replaceAll("\\pS", "");
						
						s2 = s2.replaceAll("\\pN", "");
            	
					}
            
				}
        
				if(flag2 != 0){
            
					try {
            	
						ow.write(s2 + " ");
            	
						ow.flush();
				
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            
				}
                                
			}
			
			//calls TestApp to stem the words
			TestApp stem = new TestApp();
			
			try {
				
				stem.stemming(itemSize, itemNo, output_filename, z, recom);
				
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		} catch (FileNotFoundException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(itemNo == itemSize){
			
			System.out.println("Deletion for stop words and punctuations complete.");
			
		}
		
	}

}
