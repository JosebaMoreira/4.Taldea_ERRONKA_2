package Modelo;

/**
 * Esta clase es una clase heredada de la clase Users la cual recibe todos los datos de la clase Users.
 * @author 4.Taldea
 * @version 1.0
 * 
 */
public class Clients extends Users {
	
	/**
	 * Este constructor Clients se inicializa vacio.
	 */
	public Clients() {
	}
	
	/**
	 * Constructor de la clase Clients que permite inicializar una nueva instancia con los atributos heredados de Users que contiene.
	 * @param dni El dni del cliente.
	 * @param name El nombre del cliente.
	 * @param surname El apellido del cliente.
	 * @param email El email del cliente.
	 * @param password La contraseña del cliente.
	 * @param phoneNumber El número de teléfono del cliente.
	 * @param rol El rol del cliente.
	 */
	public Clients(String dni,String name,String surname,String email, String password, String phoneNumber, String rol) {
		super(dni,name,surname,email,password,phoneNumber,rol);
	}
	
	/**
	 * Este es el toString de la clase Clients.
	 */
	@Override
	public String toString() {
		return "Clients [getDni()=" + getDni() + ", getName()=" + getName() + ", getSurname()=" + getSurname()
				+ ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword() + ", getPhoneNumber()="
				+ getPhoneNumber() + ", getRol()=" + getRol() + "]";
	}
		
}
