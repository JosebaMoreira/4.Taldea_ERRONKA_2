package Modelo.BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTextField;

import Modelo.Clients;

/**
 * Clase de Clients para conectar la base de datos y crear sus propias sentencias SQL.
 * @author 4.Taldea
 * @version 1.0
 *        
 */
public class ClientsConnect {

	/**
	 * Metodo connection para conectar a la base de datos.
	 * 
	 * @return La conexion.
	 */
	private static Connection conexion() {
		String url = "jdbc:mysql://localhost:3306/donostiakultura";
		String username = "root";
		String password = "";
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Datu basera konektatuta");
		} catch (SQLException e) {
			System.out.println("Errorea konektatzen ");
		}
		return connection;
	}

	/**
	 * Metodo en el que obtiene una lista de todos los clients.
	 * 
	 * @return Lista de clients.
	 * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
	 */
	public static ArrayList<Clients> getClients() throws SQLException {
		Connection con = conexion();
		Statement st = con.createStatement();
		String consulta = "SELECT * FROM Users WHERE rol = 'user'";
		ResultSet resultSet = (ResultSet) st.executeQuery(consulta);
		ArrayList<Clients> clientList = new ArrayList<Clients>();

		try {
			while (resultSet.next()) {
				Clients cli = new Clients();
				cli.setDni(resultSet.getString("DNI"));
				cli.setName(resultSet.getString("name"));
				cli.setSurname(resultSet.getString("surname"));
				cli.setEmail(resultSet.getString("email"));
				cli.setPassword(resultSet.getString("password"));
				cli.setPhoneNumber(resultSet.getString("phoneNumber"));
				cli.setRol(resultSet.getString("rol"));
				clientList.add(cli);
			}
		} catch (SQLException e) {
			System.out.println("Error al ejecutar la consulta: " + e.getMessage());
		}
		return clientList;
	}

	/**
	 * Metodo que inserta un nuevo usuario.
	 * 
	 * @param cli Un objeto Clients que contiene DNI,nombre,apellido,email,contraseña,teléfono y rol.
	 * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
	 */
	public void AnadirUsuario(Clients cli) throws SQLException {
		Connection con = conexion();
		Statement st = con.createStatement();
		String consulta = "INSERT into Users" + "(DNI,name,surname,email,password,phoneNumber,rol)" + "VALUES('"
				+ cli.getDni() + "','" + cli.getName() + "','" + cli.getSurname() + "','" + cli.getEmail() + "','"
				+ cli.getPassword() + "','" + cli.getPhoneNumber() + "','" + cli.getRol() + "');";
		st.execute(consulta);
		System.out.println("El usuario se ha creado correctamente");

		con.close();
	}

	/**
	 * Metodo que elimina un usuario.
	 * 
	 * @param cli Un objeto Clients que contiene DNI.
	 * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
	 */
	public void EliminarUsuario(Clients cli) throws SQLException {
		Connection con = conexion();
		Statement st = con.createStatement();
		String consulta = "DELETE FROM Users WHERE DNI='" + cli.getDni() + "'";
		st.execute(consulta);
		System.out.println("El usuario se ha eliminado");
		con.close();
	}

	/**
	 * Metodo que modifica un usuario.
	 * 
	 * @param cli Un objeto Clients que contiene nombre,apellido,email,contraseña,teléfono y rol.
	 * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
	 */
	public void modificaUsuario(Clients cli) throws SQLException {
		System.out.println("paso joseba");
		System.out.println(cli);
		Connection conn = conexion();
		Statement st = conn.createStatement();
		String consulta = "UPDATE users SET " + "name = '" + cli.getName() + "', " + "surname = '" + cli.getSurname()
				+ "', " + "email = '" + cli.getEmail() + "', " + "password = '" + cli.getPassword() + "', "
				+ "phoneNumber = '" + cli.getPhoneNumber() + "', " + "rol = '" + cli.getRol() + "' " + "WHERE DNI = '"
				+ cli.getDni() + "';";
		st.execute(consulta);
		System.out.println("El usuario se ha modificado");
		conn.close();
	}
}
