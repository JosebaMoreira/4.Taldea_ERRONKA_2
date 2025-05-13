package Modelo.BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Modelo.Admins;

public class AdminsConnect {
	private static Connection conexion() {
		String url = "jdbc:mysql://localhost:3306/donostiakultura";
		String username = "root";
		String password = "";
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(url, username, password);
            System.out.println("Datu basera konektatuta");
		}catch(SQLException e) {
			System.out.println("Errorea konektatzen " );
		}
		return connection;
	}
	public static ArrayList<Admins>getAdmins()throws SQLException{
		Connection con = conexion();
		Statement st = con.createStatement();
		String consulta = "SELECT * FROM Admins";
		ResultSet resultSet = (ResultSet)st.executeQuery(consulta);
		ArrayList<Admins> adminList = new ArrayList<Admins>();
		
		try {
			while(resultSet.next()) {
				Admins ad = new Admins();
				ad.setDni(resultSet.getString("DNI"));
				ad.setName(resultSet.getString("name"));
				ad.setSurname(resultSet.getString("surname"));
				ad.setEmail(resultSet.getString("email"));
				ad.setPassword(resultSet.getString("password"));
				ad.setPhoneNumber(resultSet.getString("phoneNumber"));
				ad.setRol(resultSet.getString("rol"));
				
			}
		}catch (SQLException e) {
	        System.out.println("Error al ejecutar la consulta: " + e.getMessage());
	}
		return adminList;
}
	public void AnadirUsuario(Admins ad)throws SQLException{
		Connection con = conexion();
		Statement st = con.createStatement();
		String consulta = "INSERT into Admins"
				+"(DNI,name,surname,email,password,phoneNumber,rol)"
				+"VALUES('"+ad.getDni()+"','"+ad.getName()+"','"+ad.getSurname()+"','"+ad.getEmail()+"','"+ad.getPassword()+"','"+ad.getPhoneNumber()+"','"+ad.getRol()+"');";
		st.execute(consulta);
		System.out.println("El usuario se ha creado correctamente");
		
		con.close();
	}
	
	public void EliminarUsuario(Admins ad) throws SQLException {
		Connection con = conexion();
		Statement st = con.createStatement();
		String consulta= "DELETE FROM Admins WHERE DNI='"+ad.getDni()+"'";
        st.execute(consulta);
        System.out.println("El usuario se ha eliminado");
		con.close();
	}
}
