package Modelo;

public abstract class Users {
	private String dni;
	private String password;
	
	public Users() {
	}
	
	public Users(String dni, String password) {
		this.dni = dni;
		this.password = password;
	}

	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getPassword() {
		return password;
	}
	public void setName(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "People [dni=" + dni + ", password=" + password + "]";
	}
}
