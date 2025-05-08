package Modelo;

public class Admins extends Users{
	private String name;
	private String surname;
	private String email;
	private String phoneNumber;
	private String rol;
	
	public Admins() {
	}

	public Admins(String dni,String name,String surname,String email, String password, String phoneNumber, String rol) {
		super(dni,password);
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.rol = rol;
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
		return "Admins [name=" + name + ", surname=" + surname + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", rol=" + rol + "]";
	}
}
