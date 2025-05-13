package Modelo;

public class Admins extends Users{
	
	public Admins() {
	}
	
	public Admins(String dni, String name, String surname, String email, String password, String phoneNumber,String rol) {
		super(dni,name,surname,email,password,phoneNumber,rol);
	}

	@Override
	public String toString() {
		return "Admins [getDni()=" + getDni() + ", getName()=" + getName() + ", getSurname()=" + getSurname()
				+ ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword() + ", getPhoneNumber()="
				+ getPhoneNumber() + ", getRol()=" + getRol() + "]";
	}
}
