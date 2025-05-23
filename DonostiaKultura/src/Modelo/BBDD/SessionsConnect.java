package Modelo.BBDD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Modelo.Sessions;

/**
 * Clase de sesiones para conectar la base de datos y crear sus propias sentencias SQL.
 * @author 4.Taldea
 * @version 1.0
 * 
 */
public class SessionsConnect {
	
	/**
	 * Metodo connection para conectar a la base de datos.
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
		}catch(SQLException e) {
			System.out.println("Errorea konektatzen " );
		}
		return connection;
	}
	
	/**
	 * Metodo en el que obtiene una lista de todas las sesiones.
	 * @return Lista de sesiones.
	 * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
	 */
	public ArrayList<Sessions> getSessions() throws SQLException {
		Connection con = conexion();
        Statement st = con.createStatement();
        String consulta = "SELECT * FROM sessions";
        ResultSet resultSet = (ResultSet)st.executeQuery(consulta);
        ArrayList<Sessions> sessionsList = new ArrayList<Sessions>();
        
        try {
            while(resultSet.next()) {
                Sessions ses = new Sessions();
                ses.setSessionID(resultSet.getInt("sessionID"));
                ses.setDay(resultSet.getDate("day"));
                ses.setHour(resultSet.getTime("hour"));
                ses.setCapacity(resultSet.getInt("capacity"));
                ses.setFormationID(resultSet.getInt("formationID"));
                sessionsList.add(ses);
            }
        }catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
    }
		return sessionsList;
	}
}
