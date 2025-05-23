package Modelo;

/**
 * Esta clase proporciona metodos para acceder a los datos de una reserva.
 * @author 4.Taldea
 * @version 1.0
 * 
 */
public class Reservations {
	private int reservationID;
	private String userID;
	private int sessionID;
	
	/**
	 * Este constructor Reservations se inicializa vacío.
	 */
	public Reservations() {
	}
	
	/**
	 * Constructor de la clase Reservations que permite inicializar una nueva instancia con los atributos que contiene.
	 * @param reservationID El ID de la reserva.
	 * @param userID El ID del usuario.
	 * @param sessionID El ID de la sesión.
	 */
	public Reservations(int reservationID, String userID, int sessionID) {
		this.reservationID = reservationID;
		this.userID = userID;
		this.sessionID = sessionID;
	}
	
	/**
	 * Recibe el ID de la reserva.
	 * @return El ID de la reserva.
	 */
	public int getReservationID() {
		return reservationID;
	}
	
	/**
	 * Devuelve el ID de la reserva.
	 * @param reservationID El ID de la reserva.
	 */
	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}
	
	/**
	 * Recibe el ID del usuario.
	 * @return El ID del usuario.
	 */
	public String getUserID() {
		return userID;
	}
	
	/**
	 * Devuelve el ID del usuario.
	 * @param userID El ID del usuario.
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	/**
	 * Recibe el ID de la sesión.
	 * @return El de la sesión.
	 */
	public int getSessionID() {
		return sessionID;
	}
	
	/**
	 * Devuelve el ID de la sesión.
	 * @param sessionID El ID de la sesión.
	 */
	public void setSessionID(int sessionID) {
		this.sessionID = sessionID;
	}
	
	/**
	 * Este es el toString de la clase Reservations.
	 */
	@Override
	public String toString() {
		return "Reservations [reservationID=" + reservationID + ", userID=" + userID + ", sessionID=" + sessionID + "]";
	}
	
}
