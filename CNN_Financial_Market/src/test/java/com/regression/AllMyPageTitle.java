package com.regression;

public enum AllMyPageTitle {
	

	MARKET("Stock Market Data - Dow Jones, Nasdaq, S&P 500 - CNNMoney"),
	TECH("Tech News - Latest Technology Headlines and Trends on CNN Business - CNN"),
	MEDIA("Media News - Latest Headlines on CNN Business - CNN"),
	SUCCESS("Careers - News for Entrepreneurs and Leaders on CNN Business - CNN"),
	PERSPECTIVES("Analysis – CNN Business - CNN"), 
	VIDEOS("Videos - CNN Business - CNN");
	
	private String title;

	public String getTitle() {
		return title;
	}

	private	AllMyPageTitle(String title){
		this.title =title;
		
		}
	
	
}