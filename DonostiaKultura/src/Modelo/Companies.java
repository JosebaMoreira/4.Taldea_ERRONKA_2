package Modelo;

/**
 * Esta clase proporciona metodos para acceder a los datos de una compañia.
 * @author 4.Taldea
 * @version 1.0
 * 
 */
public class Companies {
	private String CIF;
	private String name;
	private String address;
	
	/**
	 * Este constructor Companies se inicializa vacio.
	 */
	public Companies() {
	}
	
	/**
	 * Constructor de la clase Companies que permite inicializar una nueva instancia con los atributos que contiene.
	 * @param CIF El CIF de la compañia.
	 * @param name El nombre de la compañia.
	 * @param address La dirección de la compañia.
	 */
	public Companies(String CIF, String name, String address) {
		this.CIF = CIF;
		this.name = name;
		this.address = address;
	}
	
	/**
	 * Recibe el CIF de la compañia.
	 * @return El CIF de la compañia.
	 */
	public String getCIF() {
		return CIF;
	}
	
	/**
	 * Devuelve el CIF de la compañia.
	 * @param CIF El CIF de la compañia.
	 */
	public void setCIF(String CIF) {
		this.CIF = CIF;
	}
	
	/**
	 * Recibe el nombre de la compañia.
	 * @return El nombre de la compañia.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Devuelve el nombre de la compañia.
	 * @param name El nombre de la compañia.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Recibe la dirección de la compañia.
	 * @return La dirección de la compañia.
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Devuelve la dirección de la compañia.
	 * @param address La dirección de la compañia.
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Este es el toString de la clase Companies.
	 */
	@Override
	public String toString() {
		return "Companies [CIF=" + CIF + ", name=" + name + ", address=" + address + "]";
	}
	
}
