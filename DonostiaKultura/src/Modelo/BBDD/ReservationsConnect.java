package Modelo.BBDD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Modelo.Reservations;

/**
 * Clase de reservas para conectar la base de datos y crear sus propias sentencias SQL.
 * @author 4.Taldea
 * @version 1.0
 * 
 */
public class ReservationsConnect {
	/**
	 * Metodo connection para conectar a la base de datos.
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
	 * Metodo en el que obtiene una lista de todas las reservas.
	 * @return Lista de reservas.
	 * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
	 */
	public ArrayList<Reservations> getReservations() throws SQLException {
		Connection con = conexion();
        Statement st = con.createStatement();
        String consulta = "SELECT * FROM reservations";
        ResultSet resultSet = (ResultSet)st.executeQuery(consulta);
        ArrayList<Reservations> reservList = new ArrayList<Reservations>();
        
        try {
            while(resultSet.next()) {
                Reservations res = new Reservations();
                res.setReservationID(resultSet.getInt("reservationID"));
                res.setUserID(resultSet.getString("userID"));
                res.setSessionID(resultSet.getInt("sessionID"));
                reservList.add(res);
            }
        }catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
    }
		return reservList;
	}
}
