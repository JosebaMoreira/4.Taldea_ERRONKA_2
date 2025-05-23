package Modelo;

/**
 * Esta clase proporciona metodos para acceder a los datos de una formación.
 * @author 4.Taldea
 * @version 1.0
 * 
 */
public class Formations {
	
	/**
	 * Enumeración que define la peculiaridad.
	 */
	public enum pecualirity{
		english,other
	};
	
	private int formationID;
	private String name;
	private String description;
	private pecualirity pecualirity;
	private String companyID;
	
	/**
	 * Este constructor Formations se inicializa vacio.
	 */
	public Formations() {
	}
	
	/**
	 * Constructor de la clase Formations que permite inicializar una nueva instancia con los atributos que contiene.
	 * @param formationID El ID de la formación.
	 * @param name El nombre de la formación.
	 * @param description La descripción de la formación.
	 * @param pecualirity La peculiaridad de la formación.
	 * @param companyID El ID de la compañia.
	 */
	public Formations(int formationID, String name, String description,pecualirity pecualirity,String companyID) {
		this.formationID = formationID;
		this.name = name;
		this.description = description;
		this.pecualirity = pecualirity;
		this.companyID = companyID;
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
	 * Recibe el nombre de la formación.
	 * @return El nombre de la formación.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Devuelve el nombre de la formación.
	 * @param name El nombre de la formación.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Recibe la descripción de la formación.
	 * @return La descripción de la formación.
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Devuelve la descripción de la formación.
	 * @param description La descripción de la formación.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Recibe la peculiaridad de la formación.
	 * @return La peculiaridad de la formación.
	 */
	public pecualirity getPecualirity() {
		return pecualirity;
	}
	
	/**
	 * Devuelve la peculiaridad de la formación.
	 * @param pecualirity La peculiaridad de la formación.
	 */
	public void setPecualirity(pecualirity pecualirity) {
		this.pecualirity = pecualirity;
	}
	
	/**
	 * Recibe el ID de la compañia.
	 * @return El ID de la compañia.
	 */
	public String getCompanyID() {
		return companyID;
	}
	
	/**
	 * Devuelve el ID de compañia.
	 * @param companyID El ID de compañia.
	 */
	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}
	
	/**
	 * Este es el toString de la clase Formations.
	 */
	@Override
	public String toString() {
		return "Formations [formationID=" + formationID + ", name=" + name + ", description=" + description
				+ ", pecualirity=" + pecualirity + ", companyID=" + companyID + "]";
	}
	
}
