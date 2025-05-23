package Modelo;

/**
 * Esta clase es una clase heredada de la clase Users la cual recibe todos los datos de la clase Users.
 * @author 4.Taldea
 * @version 1.0
 * 
 */
public class Admins extends Users{
	
	/**
	 * Este constructor Admins se inicializa vacio.
	 */
	public Admins() {
	}
	
	/**
	 * Constructor de la clase Admins que permite inicializar una nueva instancia con los atributos heredados de Users que contiene.
	 * @param dni El dni del admin.
	 * @param name El nombre del admin.
	 * @param surname El apellido del admin.
	 * @param email El email del admin.
	 * @param password La contraseña del admin.
	 * @param phoneNumber El número de teléfono del admin.
	 * @param rol El rol del admin.
	 */
	public Admins(String dni, String name, String surname, String email, String password, String phoneNumber,String rol) {
		super(dni,name,surname,email,password,phoneNumber,rol);
	}
	
	/**
	 * Este es el toString de la clase Admins.
	 */
	@Override
	public String toString() {
		return "Admins [getDni()=" + getDni() + ", getName()=" + getName() + ", getSurname()=" + getSurname()
				+ ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword() + ", getPhoneNumber()="
				+ getPhoneNumber() + ", getRol()=" + getRol() + "]";
	}
}