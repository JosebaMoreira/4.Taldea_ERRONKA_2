package Modelo;

public class Reservations {
	private int reservationID;
	private String userID;
	private int sessionID;
	
	public Reservations() {
	}

	public Reservations(int reservationID, String userID, int sessionID) {
		this.reservationID = reservationID;
		this.userID = userID;
		this.sessionID = sessionID;
	}

	public int getReservationID() {
		return reservationID;
	}

	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getSessionID() {
		return sessionID;
	}

	public void setSessionID(int sessionID) {
		this.sessionID = sessionID;
	}
	
	
	
	
}
