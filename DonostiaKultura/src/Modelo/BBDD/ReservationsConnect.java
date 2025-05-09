package Modelo.BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ReservationsConnect {
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
}
