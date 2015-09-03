package adaptiveHW2_Training;

import adaptiveHW2_Functions.RSSretrive;

public class Training_index {

	public static void main(String[] args) {
		
		//the url for the training rss source
		String RSSsource="http://halley.exp.sis.pitt.edu/comet/utils/_rss.jsp?v=bookmark&user_id=1818";
		
		//calls RSSretrive to get the information of the training rss source
		RSSretrive retrive = new RSSretrive();
		retrive.retrive(RSSsource, 0);
		
	}

}