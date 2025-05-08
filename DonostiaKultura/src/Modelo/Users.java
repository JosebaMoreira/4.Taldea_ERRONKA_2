package Modelo;

public class Users extends People {
	private String email;
	private String password;
	private String phoneNumber;
	private String rol;
	
	public Users() {
	}

	public Users(String dni,String name,String surname,String email, String password, String phoneNumber, String rol) {
		super(dni,name,surname);
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.rol = rol;
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
		
}
