package Modelo;

public class Formations {
	public enum pecualirity{
		english,other
	};
	
	private int formationID;
	private String name;
	private String description;
	private pecualirity pecualirity;
	private String companyID;
	
	public Formations() {
	}

	public Formations(int formationID, String name, String description,pecualirity pecualirity,String companyID) {
		this.formationID = formationID;
		this.name = name;
		this.description = description;
		this.pecualirity = pecualirity;
		this.companyID = companyID;
	}

	public int getFormationID() {
		return formationID;
	}

	public void setFormationID(int formationID) {
		this.formationID = formationID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public pecualirity getPecualirity() {
		return pecualirity;
	}

	public void setPecualirity(pecualirity pecualirity) {
		this.pecualirity = pecualirity;
	}

	public String getCompanyID() {
		return companyID;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}
	
	
	
	
	
	
}
