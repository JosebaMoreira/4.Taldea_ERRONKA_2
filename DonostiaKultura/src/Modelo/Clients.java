package Modelo;

public class Clients extends Users {
	public Clients() {
	}

	public Clients(String dni,String name,String surname,String email, String password, String phoneNumber, String rol) {
		super(dni,name,surname,email,password,phoneNumber,rol);
	}

	@Override
	public String toString() {
		return "Clients [getDni()=" + getDni() + ", getName()=" + getName() + ", getSurname()=" + getSurname()
				+ ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword() + ", getPhoneNumber()="
				+ getPhoneNumber() + ", getRol()=" + getRol() + "]";
	}
	
	
}
