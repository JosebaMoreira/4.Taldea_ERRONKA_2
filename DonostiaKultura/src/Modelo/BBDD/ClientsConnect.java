package Modelo.BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Modelo.Clients;

public class ClientsConnect {
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
	public static ArrayList<Clients>getClients()throws SQLException{
		Connection con = conexion();
		Statement st = con.createStatement();
		String consulta = "SELECT * FROM Clients";
		ResultSet resultSet = (ResultSet)st.executeQuery(consulta);
		ArrayList<Clients> clientList = new ArrayList<Clients>();
		
		try {
			while(resultSet.next()) {
				Clients cli = new Clients();
				cli.setDni(resultSet.getString("DNI"));
				cli.setName(resultSet.getString("name"));
				cli.setSurname(resultSet.getString("surname"));
				cli.setEmail(resultSet.getString("email"));
				cli.setPassword(resultSet.getString("password"));
				cli.setPhoneNumber(resultSet.getString("phoneNumber"));
				cli.setRol(resultSet.getString("rol"));
				
			}
		}catch (SQLException e) {
	        System.out.println("Error al ejecutar la consulta: " + e.getMessage());
	}
		return clientList;
}
	public void AnadirUsuario(Clients cli)throws SQLException{
		Connection con = conexion();
		Statement st = con.createStatement();
		String consulta = "INSERT into Clients"
				+"(DNI,name,surname,email,password,phoneNumber,rol)"
				+"VALUES('"+cli.getDni()+"','"+cli.getName()+"','"+cli.getSurname()+"','"+cli.getEmail()+"','"+cli.getPassword()+"','"+cli.getPhoneNumber()+"','"+cli.getRol()+"');";
		st.execute(consulta);
		System.out.println("El usuario se ha creado correctamente");
		
		con.close();
	}
	
	public void EliminarUsuario(Clients cli) throws SQLException {
		Connection con = conexion();
		Statement st = con.createStatement();
		String consulta= "DELETE FROM Clients WHERE DNI='"+cli.getDni()+"'";
        st.execute(consulta);
        System.out.println("El usuario se ha eliminado");
		con.close();
	}
}
