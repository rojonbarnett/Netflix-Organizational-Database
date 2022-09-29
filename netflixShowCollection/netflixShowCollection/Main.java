package netflixShowCollection;

//RoJon Barnett
//Code that manipulates a Netflix show collection
public class Main {

	public static void main(String[] args)
	{
		//Tests ShowInWeek Constructor
		ShowInWeek s1 = new ShowInWeek();
		System.out.println(s1);
		
		ShowInWeek s2 = new ShowInWeek("2022-09-04","Films(English)", "1","Me Time","N/A","5656000","2");
		
		System.out.println(s2);
		//Show Collect Construct
		ShowCollection myShows = new ShowCollection("RoJon's Shows", "netflixAllWeeksGlobalProcessed.txt" );
		
		//Tests add method
		myShows.addShow(s1);
		myShows.addShow(s2);
		
		System.out.println(myShows);
		
		
		//Tests Purge Method
		myShows.purge(s2);
		
		System.out.println(myShows);
		
		
		//Tests Unpurge Method
		myShows.unpurge(s2);
		
		System.out.println(myShows);
		
		ShowInWeek s3 = new ShowInWeek("2022-09-04","Films(English)", "2", "Love in the Villa", "N/A", "412200000","1");
		
		myShows.addShow(s3);
		
		System.out.println(myShows);
		
		
		//Tests suggestShow method
		System.out.println(myShows.suggestShow());
		
		ShowInWeek s4 = new ShowInWeek("2022-09-04","Films(Spanish)", "2", "Love in the Villa", "N/A", "412200000","1");
		myShows.addShow(s4);
		
		ShowInWeek s5 = new ShowInWeek("2022-09-04","Films(Spanish)", "2", "Love in the Yard", "N/A", "412200000","1");
		myShows.addShow(s5);
		
		ShowInWeek s6 = new ShowInWeek("2022-09-04","Films(Japanese)", "2", "Love in the Villa", "N/A", "412200000","1");
		myShows.addShow(s6);
		
		
		//Tests Predict Show
		System.out.println(myShows.predictShow(s4));
		
		ShowCollection myShows2 = new ShowCollection("RoJon's New Shows,", "netflixAllWeeksGlobalProcessed.txt" );
		
		ShowInWeek s7 = new ShowInWeek("2022-09-02","Films(Japanese)", "2", "Love in the Villa", "N/A", "412200000","1");
		myShows2.addShow(s7);
		
		ShowInWeek s8 = new ShowInWeek("2022-09-02","Films(Japanese)", "2", "Love in the Villa", "N/A", "412200000","1");
		myShows2.addShow(s8);
		
		ShowInWeek s9 = new ShowInWeek("2022-09-04","Films(Japanese)", "2", "Love in the Villa", "N/A", "412200000","1");
		myShows2.addShow(s9);
		
		ShowInWeek s10 = new ShowInWeek("2022-09-04","Films(English)", "2", "Love in the Villa", "N/A", "412200000","1");
		myShows2.addShow(s10);
		
		
		//System.out.println(myShows.predictFromCollect(myShows2));
		//TestGet Show
		System.out.println(myShows2.getShows("2022-09-04"));
		
		//Tests unique show creator
		
		System.out.println(myShows2.getShowsCat("Films(Japanese)"));
		
		
	}		 
		
}