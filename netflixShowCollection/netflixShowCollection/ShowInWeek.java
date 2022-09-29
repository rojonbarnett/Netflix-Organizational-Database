package netflixShowCollection;



public class ShowInWeek 
{
	private String week;
	private String category;
	private String weeklyRank;
	private String showTitle;
	private String seasonTitle;
	private String wklyHrsViewed;
	private String cummWksTopTen;
	

	public ShowInWeek()
	{
		 week = "week not set";
		 category = "category not set";
		 weeklyRank = "0" ;
		 showTitle = "show title not set";
		 seasonTitle = "season title not set";
		 wklyHrsViewed = "0";
		 cummWksTopTen = "0";
		 
	}
	
	public ShowInWeek(String w, String c, String wr, String sh, String se,String whv, String cwtt)
	{
		 week = w;
		 category = c;
		 weeklyRank = wr ;
		 showTitle = sh;
		 seasonTitle = se;
		 wklyHrsViewed = whv;
		 cummWksTopTen = cwtt;
		 
	}
	public ShowInWeek(String w, String sh)
	{
		 week = w;
		 category = "category not set";
		 weeklyRank = "0" ;
		 showTitle = sh;
		 seasonTitle = "season title not set";
		 wklyHrsViewed = "0";
		 cummWksTopTen = "0";
		 
	}


	public String getWeek() {
		return week;
	}


	public void setWeek(String week) {
		this.week = week;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getWeeklyRank() {
		return weeklyRank;
	}


	public void setWeeklyRank(String weeklyRank) {
		this.weeklyRank = weeklyRank;
	}


	public String getShowTitle() {
		return showTitle;
	}


	public void setShowTitle(String showTitle) {
		this.showTitle = showTitle;
	}


	public String getSeasonTitle() {
		return seasonTitle;
	}


	public void setSeasonTitle(String seasonTitle) {
		this.seasonTitle = seasonTitle;
	}
	
	public String getWklyHrsViewed() {
		return wklyHrsViewed;
	}


	public void setWklyHrsViewed(String wklyHrsViewed) {
		this.wklyHrsViewed = wklyHrsViewed;
	}


	public String getCummWksTopTen() {
		return cummWksTopTen;
	}


	public void setCummWksTopTen(String cummWksTopTen) {
		this.cummWksTopTen = cummWksTopTen;
	}
	
	public String toString()
	{
		return week +" " + category + " " + weeklyRank + " " + showTitle + " " + seasonTitle + " " + wklyHrsViewed+ " "+ cummWksTopTen;
		
	}
	
	public boolean equals(Object o)
	{
		ShowInWeek s = (ShowInWeek) o;
		String weekTitleCon = week + showTitle; 
		
		return weekTitleCon.equals(s.getWeek() + s.getShowTitle());
	}
	
}
