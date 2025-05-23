package Modelo;

import java.io.Serializable;

/**
 * Esta clase es una clase abstracta la cual proporciona metodos para acceder a los datos de un usuario.
 * @author 4.Taldea
 * @version 1.0
 * 
 */
public abstract class Users implements Serializable {
	private String dni;
	private String name;
	private String surname;
	private String email;
	private String password;
	private String phoneNumber;
	private String rol;
	
	/**
	 * Este constructor Users se inicializa vacio.
	 */
	public Users() {
	}
	
	/**
	 * Constructor de la clase Users que permite inicializar una nueva instancia con los atributos que contiene.
	 * @param dni El dni del user.
	 * @param name El nombre del user.
	 * @param surname El apellido del user.
	 * @param email El email del user.
	 * @param password La contraseña del user.
	 * @param phoneNumber El número de teléfono del user.
	 * @param rol El rol del user.
	 */
	public Users(String dni, String name, String surname, String email, String password, String phoneNumber,String rol) {
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.rol = rol;
	}
	
	/**
	 * Recibe el dni del user.
	 * @return El dni del user.
	 */
	public String getDni() {
		return dni;
	}
	
	/**
	 * Devuelve el dni del user.
	 * @param dni El dni del user.
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	/**
	 * Recibe el nombre del user.
	 * @return El nombre del user. 
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Devuelve el nombre del user.
	 * @param name El nombre del user.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Recibe el apellido del user.
	 * @return El apellido del user.
	 */
	public String getSurname() {
		return surname;
	}
	
	/**
	 * Devuelve el apellido del user.
	 * @param surname El apellido del user.
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	/**
	 * Recibe el email del user.
	 * @return El email del user.
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Devuelve el email del user.
	 * @param email El email del user.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Recibe la contraseña del user.
	 * @return La contraseña del user.
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Devuelve la contraseña del user.
	 * @param password La contraseña del user.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Recibe el número de teléfono del user.
	 * @return El número de teléfono del user.
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * Devuelve el número de teléfono del user.
	 * @param phoneNumber El número de teléfono del user.
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * Recibe el rol del user.
	 * @return El rol del user.
	 */
	public String getRol() {
		return rol;
	}
	
	/**
	 * Devuelve el rol del user.
	 * @param rol El rol del user.
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	/**
	 * Este es el toString de la clase Users.
	 */
	@Override
	public String toString() {
		return "Users [dni=" + dni + ", name=" + name + ", surname=" + surname + ", email=" + email + ", password="
				+ password + ", phoneNumber=" + phoneNumber + ", rol=" + rol + "]";
	}
}
