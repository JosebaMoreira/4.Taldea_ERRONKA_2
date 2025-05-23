package Modelo.BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTextField;

import Modelo.Admins;

/**
 * Clase de Admins para conectar la base de datos y crear sus propias sentencias SQL.
 * @author 4.Taldea
 * @version 1.0
 * 
 */
public class AdminsConnect {
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
	 * Metodo en el que obtiene una lista de todos los admins.
	 * 
	 * @return Lista de admins.
	 * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
	 */
	public static ArrayList<Admins> getAdmins() throws SQLException {
		Connection con = conexion();
		Statement st = con.createStatement();
		String consulta = "SELECT * FROM Users WHERE rol = 'admin'";
		ResultSet resultSet = (ResultSet) st.executeQuery(consulta);
		ArrayList<Admins> adminList = new ArrayList<Admins>();

		try {
			while (resultSet.next()) {
				Admins adm = new Admins();
				adm.setDni(resultSet.getString("DNI"));
				adm.setName(resultSet.getString("name"));
				adm.setSurname(resultSet.getString("surname"));
				adm.setEmail(resultSet.getString("email"));
				adm.setPassword(resultSet.getString("password"));
				adm.setPhoneNumber(resultSet.getString("phoneNumber"));
				adm.setRol(resultSet.getString("rol"));
				adminList.add(adm);
			}
		} catch (SQLException e) {
			System.out.println("Error al ejecutar la consulta: " + e.getMessage());
		}
		return adminList;
	}

	/**
	 * Metodo que inserta un nuevo usuario.
	 * 
	 * @param adm Un objeto Admin que contiene DNI,nombre,apellido,email,contraseña,teléfono y rol.
	 * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
	 */
	public void AnadirUsuario(Admins adm) throws SQLException {
		Connection con = conexion();
		Statement st = con.createStatement();
		String consulta = "INSERT into Users" + "(DNI,name,surname,email,password,phoneNumber,rol)" + "VALUES('"
				+ adm.getDni() + "','" + adm.getName() + "','" + adm.getSurname() + "','" + adm.getEmail() + "','"
				+ adm.getPassword() + "','" + adm.getPhoneNumber() + "','" + adm.getRol() + "');";
		st.execute(consulta);
		System.out.println("El usuario se ha creado correctamente");

		con.close();
	}

	/**
	 * Metodo que elimina un usuario.
	 * 
	 * @param adm Un objeto Admin que contiene DNI.
	 * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
	 */
	public void EliminarUsuario(Admins adm) throws SQLException {
		Connection con = conexion();
		Statement st = con.createStatement();
		System.out.println("paso3");
		System.out.println(adm.getDni());
		String consulta = "DELETE FROM Users WHERE DNI='" + adm.getDni() + "'";
		st.execute(consulta);
		System.out.println("El usuario se ha eliminado");
		con.close();
	}

	/**
	 * Metodo que modifica un usuario.
	 * 
	 * @param adm Un objeto Admin que contiene nombre,apellido,email,contraseña,teléfono y rol.
	 * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
	 */
	public void modificaUsuario(Admins adm) throws SQLException {
		System.out.println("paso joseba");
		Connection con = conexion();
		Statement st = con.createStatement();
		System.out.println("paso joseba");
		System.out.println(adm);
		String consulta = "UPDATE users SET name = '" + adm.getName() + "', " + "surname = '" + adm.getSurname() + "', "
				+ "email = '" + adm.getEmail() + "', " + "password = '" + adm.getPassword() + "', " + "phoneNumber = '"
				+ adm.getPhoneNumber() + "' " + "WHERE DNI = '" + adm.getDni() + "';";

		int filas = st.executeUpdate(consulta);

		if (filas > 0) {
			System.out.println("Admin modificado correctamente");
		} else {
			System.out.println("Error al modificar usuario en AdminsConnect");
		}

		con.close();
	}
}
