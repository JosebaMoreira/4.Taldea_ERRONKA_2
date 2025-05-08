package Modelo;

import java.sql.Date;
import java.sql.Time;

public class Sessions {
	private int sessionID;
	private Date day;
	private Time hour;
	private int capacity;
	private int formationID;
	
	public Sessions() {
	}

	public Sessions(int sessionID, Date day, Time hour, int capacity, int formationID) {
		this.sessionID = sessionID;
		this.day = day;
		this.hour = hour;
		this.capacity = capacity;
		this.formationID = formationID;
	}

	public int getSessionID() {
		return sessionID;
	}

	public void setSessionID(int sessionID) {
		this.sessionID = sessionID;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public Time getHour() {
		return hour;
	}

	public void setHour(Time hour) {
		this.hour = hour;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getFormationID() {
		return formationID;
	}

	public void setFormationID(int formationID) {
		this.formationID = formationID;
	}

	@Override
	public String toString() {
		return "Sessions [sessionID=" + sessionID + ", day=" + day + ", hour=" + hour + ", capacity=" + capacity
				+ ", formationID=" + formationID + "]";
	}
	
}
