package Modelo;

public abstract class Users {
	private String dni;
	private String name;
	private String surname;
	private String email;
	private String password;
	private String phoneNumber;
	private String rol;
	
	public Users() {
	}
	
	public Users(String dni, String name, String surname, String email, String password, String phoneNumber,String rol) {
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.rol = rol;
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Users [dni=" + dni + ", name=" + name + ", surname=" + surname + ", email=" + email + ", password="
				+ password + ", phoneNumber=" + phoneNumber + ", rol=" + rol + "]";
	}
}
