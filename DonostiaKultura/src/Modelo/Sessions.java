package Modelo;
import java.sql.Date;
import java.sql.Time;

/**
 * Esta clase proporciona metodos para acceder a los datos de una sesión.
 * @author 4.Taldea
 * @version 1.0
 * 
 */
public class Sessions {
	private int sessionID;
	private Date day;
	private Time hour;
	private int capacity;
	private int formationID;
	
	/**
	 * Este constructor Sessions se inicializa vacío.
	 */
	public Sessions() {
	}
	
	/**
	 * Constructor de la clase Sessions que permite inicializar una nueva instancia con los atributos que contiene.
	 * @param sessionID El ID de la sesión.
	 * @param day El día de la sesión.
	 * @param hour La hora de la sesión.
	 * @param capacity La capacidad de la sesión.
	 * @param formationID El ID de la formación.
	 */
	public Sessions(int sessionID, Date day, Time hour, int capacity, int formationID) {
		this.sessionID = sessionID;
		this.day = day;
		this.hour = hour;
		this.capacity = capacity;
		this.formationID = formationID;
	}
	
	/**
	 * Recibe el ID de la sesión.
	 * @return El ID de la sesión.
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
	 * Recibe el día de la sesión.
	 * @return El día de la sesión
	 */
	public Date getDay() {
		return day;
	}
	
	/**
	 * Devuelve el día de la sesión.
	 * @param day El día de la sesión.
	 */
	public void setDay(Date day) {
		this.day = day;
	}
	
	/**
	 * Recibe la hora de la sesión.
	 * @return La hora de la sesión.
	 */
	public Time getHour() {
		return hour;
	}
	
	/**
	 * Devuelve la hora de la sesión.
	 * @param hour La hora de la sesión.
	 */
	public void setHour(Time hour) {
		this.hour = hour;
	}
	
	/**
	 * Recibe la capacidad de la sesión.
	 * @return La capacidad de la sesión.
	 */
	public int getCapacity() {
		return capacity;
	}
	
	/**
	 * Devuelve la capacidad de la sesión.
	 * @param capacity La capacidad de la sesión.
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	/**
	 * Recibe el ID de la formación.
	 * @return El ID de la formación.
	 */
	public int getFormationID() {
		return formationID;
	}
	
	/**
	 * Devuelve el ID de la formación.
	 * @param formationID El ID de la formación.
	 */
	public void setFormationID(int formationID) {
		this.formationID = formationID;
	}
	
	/**
	 * Este es el toString de la clase Sessions.
	 */
	@Override
	public String toString() {
		return "Sessions [sessionID=" + sessionID + ", day=" + day + ", hour=" + hour + ", capacity=" + capacity
				+ ", formationID=" + formationID + "]";
	}
	
}
