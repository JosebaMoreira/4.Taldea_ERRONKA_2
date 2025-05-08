package Modelo;

public class Companies {
	private String CIF;
	private String name;
	private String address;
	
	public Companies() {
	}

	public Companies(String CIF, String name, String address) {
		this.CIF = CIF;
		this.name = name;
		this.address = address;
	}

	public String getCIF() {
		return CIF;
	}

	public void setCIF(String CIF) {
		this.CIF = CIF;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Companies [CIF=" + CIF + ", name=" + name + ", address=" + address + "]";
	}
	
}
