package Modelo.BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTextField;

import Modelo.Admins;
import Modelo.Users;

/**
 * Clase de Users para conectar la base de datos y crear sus propias sentencias SQL.
 * @author 4.Taldea
 * @version 1.0
 * 
 */
public class UsersConnect {
	/**
	 * Metodo connection para conectar a la base de datos.
	 * 
	 * @return La conexion.
	 */
	public static Connection conexion() {
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
	
	/**
	 * Método para visualizar los usuarios segun el filtro que metas
	 * 
	 * @param txtApellido Celda de apellido
	 * @param txtDni Celda de dni
	 * @return usersList
	 * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
	 */
    public ArrayList<Users> buscarUsuarios(JTextField txtApellido,JTextField txtDni) throws SQLException{
        Connection con = conexion();
        Statement st = con.createStatement();
        String consulta = "SELECT * FROM users WHERE surname like '%"+ txtApellido.getText() + "%' and dni like '%"+txtDni.getText()+"%' ;";
        ResultSet resultSet = st.executeQuery(consulta);
        
        ArrayList<Users> usersList = new ArrayList<Users>();
        
        try {
            while(resultSet.next()) {
                Admins ad = new Admins();
                ad.setDni(resultSet.getString("dni"));
                ad.setName(resultSet.getString("name"));
                ad.setSurname(resultSet.getString("surname"));
                ad.setEmail(resultSet.getString("email"));
                ad.setPassword(resultSet.getString("password"));
                ad.setPhoneNumber(resultSet.getString("phoneNumber"));
                ad.setRol(resultSet.getString("rol"));
                
                usersList.add(ad);
            }
        } catch (SQLException e) {
            System.out.println("Error al añadir admin");
        }
        return usersList;
}
    /**
     * Método para buscar todos los usuarios 
     * @return usersList
	 * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     */
    public ArrayList<Users> buscarUsuariosTodos() throws SQLException{
        Connection con = conexion();
        Statement st = con.createStatement();
        String consulta = "SELECT * FROM users;";
        ResultSet resultSet = st.executeQuery(consulta);
        
        ArrayList<Users> usersList = new ArrayList<Users>();
        
        try {
            while(resultSet.next()) {
                Admins ad = new Admins();
                ad.setDni(resultSet.getString("dni"));
                ad.setName(resultSet.getString("name"));
                ad.setSurname(resultSet.getString("surname"));
                ad.setEmail(resultSet.getString("email"));
                ad.setPassword(resultSet.getString("password"));
                ad.setPhoneNumber(resultSet.getString("phoneNumber"));
                ad.setRol(resultSet.getString("rol"));
                
                usersList.add(ad);
            }
        } catch (SQLException e) {
            System.out.println("Error al añadir admin");
        }
        return usersList;
}
}