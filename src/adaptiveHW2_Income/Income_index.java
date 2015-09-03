package adaptiveHW2_Income;

import adaptiveHW2_Functions.RSSretrive;

public class Income_index {

public static void main(String[] args) {
		
		//the url for the imcoming rss source
		String RSSsource="http://halley.exp.sis.pitt.edu/comet/utils/_rss.jsp";
		
		//calls RSSretrive to get the information of the incoming rss source
		RSSretrive retrive = new RSSretrive();
		retrive.retrive(RSSsource, 1);
		
	}
	
}