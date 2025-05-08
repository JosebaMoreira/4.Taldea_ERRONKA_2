package Modelo;

public abstract class People {
	private String dni;
	private String name;
	private String surname;
	
	public People() {
	}
	
	public People(String dni, String name, String surname) {
		this.dni = dni;
		this.name = name;
		this.surname = surname;
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
	@Override
	public String toString() {
		return "People [dni=" + dni + ", name=" + name + ", surname=" + surname + "]";
	}
	
	
}
