package adaptiveHW2_Functions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.gnu.stealthp.rsslib.RSSChannel;
import org.gnu.stealthp.rsslib.RSSException;
import org.gnu.stealthp.rsslib.RSSHandler;
import org.gnu.stealthp.rsslib.RSSItem;
import org.gnu.stealthp.rsslib.RSSParser;

public class RSSretrive {
	
	public void retrive(String RSSsource, int z){
	
		RSSHandler handler1 = new RSSHandler();
	
		try{
		
			RSSParser.parseXmlFile(new URL(RSSsource), handler1, false);
		
			getRSSInfo(handler1, z);
    
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RSSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public void getRSSInfo(RSSHandler handler2, int z){
               
		StringBuffer rssInfo = new StringBuffer();
           
		//gets info of the channel of the rss
		RSSChannel channel = handler2.getRSSChannel();

		//splits the feeds from the rss channel, represents them as items
		List channelItems = channel.getItems();
    
		int itemSize = channelItems.size();
		
		String[] recom = new String[itemSize];
    
		if(itemSize >= 1){
    	
			for (int i = 0; i < itemSize; i++){
        	
				int itemNo = i + 1;
            
				RSSItem item = (RSSItem)channelItems.get(i);
 
				String itemAuthor = item.getAuthor();

				String itemTitle = item.getTitle();

				String itemDescription = item.getDescription();
 
				String itemLink = item.getLink();
 
				String itemPubDate = item.getPubDate();
				
				rssInfo.append("Author: "+itemAuthor+"\r\n");
            
				rssInfo.append("Title: "+itemTitle+"\r\n");
            
				rssInfo.append("Desc: "+itemDescription+"\r\n");
            
				rssInfo.append("Link: "+itemLink+"\r\n");
            
				rssInfo.append("Published date: "+itemPubDate+"\r\n");
				
				if(z == 1){
					
					recom[i] = itemTitle + "\r\n" + itemDescription + "\r\n" + itemLink;
					
				}
				
				//calls doc_maker to make documents for the items
				Doc_maker doc_maker = new Doc_maker();
				
				doc_maker.maker(itemNo, rssInfo, itemSize, z);
				
				//calls del_stpwds_punc to process the titles and descriptions of the items
				Del_stpwds_punc delete_stpwds = new Del_stpwds_punc();
				
				delete_stpwds.delete(itemSize, itemNo, itemTitle, itemDescription, z, recom);
				
				//clears the bugger
				rssInfo.delete(0, rssInfo.length());
            
			}
			
		}
		
	}
           
}
