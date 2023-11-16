// Flight.java

class Flight {
	private String airline;
	private String source;
	private String departure;
	private int ticketNum;
	//private String flightNum;

	public Flight(String tSource, String tDeparture, String tAirline, int tTicketNum) {
		this.source = tSource;
		this.departure = tDeparture;
		this.airline = tAirline;
		this.ticketNum = tTicketNum;
	} // end constructor
	
	public int getTicketNum() {
		return ticketNum;
	} //end ticketNum getter

	public String getAirline() {
		return airline;
	} // end airline getter

	public void setAirline(String air) {
		this.airline = air;
	} // end airine setter
	
	public String getDeparture() {
		return departure;
	} // end departure getter
	
	public void setDeparture(String depart) {
		this.departure = depart;
	} // end departure setter
	
	public String getSource() {
		return source;
	} // end source getter

	public void setSource(String s) {
		this.source = s;
	} // end source setter

} // end class def
