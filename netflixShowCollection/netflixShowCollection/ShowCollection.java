package netflixShowCollection;

import java.util.ArrayList;



import java.util.Random;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.io.BufferedReader;
public class ShowCollection 
{
	private static final int MAX_SIZE = 100;
	private ArrayList <ShowInWeek> shows;
	private String className;
	private String fileName;
	
	public ShowCollection()
	{
		shows = new ArrayList<ShowInWeek>();
		className = " a class";
		fileName = null;
	}
	
	public ShowCollection(String cn, String fn)
	{
		this();
		className = cn;
		fileName = fn;
		readFile();
	}
	//Adds a show to the collection
	public void addShow(ShowInWeek s)
	{
		shows.add(s);
	}
	//Denotes specified show with a purge mark for intended voiding
	public void purge(ShowInWeek s)
	{
		s.setShowTitle(s.getShowTitle() + "(PURGED)");
		
				
	}
	//Gets rid of the purge mark
	public void unpurge(ShowInWeek s)
	{
		//Get (PURGE) string
		int start = s.getShowTitle().indexOf("(");
		int end = s.getShowTitle().lastIndexOf(")");
		String purgeMark = s.getShowTitle().substring(start,end+1);
		//Delete purge string from showTitle
		int begin = 0;
		int last = s.getShowTitle().lastIndexOf(purgeMark);
		
		s.setShowTitle(s.getShowTitle().substring(begin, last));
		
	}
	
	//Random Suggestion: Randomly suggest something to watch. 
	public ShowInWeek suggestShow()
	{
		
		Random rand = new Random();
		
		int index = rand.nextInt(shows.size());
		
		ShowInWeek toReturn = shows.get(index);
		
		return toReturn;
	}

	//Returns a random show of the same category
	public ShowInWeek predictShow(ShowInWeek s)
	{
		ShowInWeek toReturn = new ShowInWeek();
		while (!(toReturn.getCategory().equals(s.getCategory())) || (toReturn.equals(s)))
		{
			Random rand = new Random();
			
			int index = rand.nextInt(shows.size());
			
			toReturn = shows.get(index);
			
		}
			
		return toReturn;
		
	}

	//Returns a show of the same category of the last show the user watched
	public ShowInWeek predictFromCollect(ShowCollection s)
	{
		ShowInWeek toReturn = new ShowInWeek();
		
		int lastIndex = shows.size() - 1;
		boolean inCollection = true;	
		
		do
		{
			
		
			toReturn = predictShow(shows.get(lastIndex));
			for(ShowInWeek show: shows)
				if(!(toReturn.equals(show)))
					inCollection = false;
				else
					inCollection = true;
					break;
		}while(inCollection == true);
		return toReturn;		
	}
	//Generates list of shows based on date 	
	public ArrayList <ShowInWeek> getShows(String week)
	{
		ArrayList <ShowInWeek> toReturn = new ArrayList <ShowInWeek>();
		for (ShowInWeek show: shows)
		{
			if(week == show.getWeek())
			{
				toReturn.add(show);
			}
			
		}
		
		return toReturn;
	}
	//Generates list of shows based based on category
	public  ArrayList <ShowInWeek> getShowsCat(String category)
	{
		ArrayList <ShowInWeek> toReturn = new ArrayList <ShowInWeek>();
		for (ShowInWeek show: shows)
		{
			if(category == show.getCategory())
			{
				toReturn.add(show);
			}
			
		}
		
	 return toReturn;
		
	
	}
	
	
	
	public String toString()
	{
		String toReturn = className+"\n";
		
		for(ShowInWeek show : shows)
		{
			toReturn += show.toString()+"\n";
		}
		return toReturn;
	}
	
	private void readFile () {
        BufferedReader lineReader = null;
        try {
            FileReader fr = new FileReader(fileName);
            lineReader = new BufferedReader(fr);
            String line = null;
            while ((line = lineReader.readLine())!=null) {
                String week = line;
                String category = lineReader.readLine();
                String weeklyRank = lineReader.readLine();;
                String showTitle = lineReader.readLine();
                String seasonTitle = lineReader.readLine();
                String wklyHrsViewed = lineReader.readLine();
                String cummWksTopTen = lineReader.readLine();
                ShowInWeek temp = new ShowInWeek(week,category,weeklyRank,showTitle, seasonTitle, wklyHrsViewed,cummWksTopTen);
                addShow(temp);
            }

        } catch (Exception e) {
            System.err.println("there was a problem with the file reader, try different read type.");
            try {
                lineReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(fileName.substring(1))));
                String line = null;

            } catch (Exception e2) {
                System.err.println("there was a problem with the file reader, try again.  either no such file or format error");
            } finally {
                if (lineReader != null)
                    try {
                        lineReader.close();
                    } catch (IOException e2) {
                        System.err.println("could not close BufferedReader");
                    }
            }
        } finally {
            if (lineReader != null)
                try {
                    lineReader.close();
                } catch (IOException e) {
                    System.err.println("could not close BufferedReader");
                }
        }
    }
}
	