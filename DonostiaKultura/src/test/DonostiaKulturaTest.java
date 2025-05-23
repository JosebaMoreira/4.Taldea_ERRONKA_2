package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

import Modelo.Admins;
import Modelo.Clients;
import Modelo.BBDD.AdminsConnect;
import Modelo.BBDD.ClientsConnect;

import org.junit.jupiter.api.Test;

/**
 * @author 4.Taldea
 * @version 1.0 
 * Clase que hace los test unitarios.
 */
class DonostiaKulturaTest {

	@Test
	/**
	 * Test unitario de getAdmins
	 * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
	 */
	void testgetAdmins() throws SQLException {
		AdminsConnect adm = new AdminsConnect();
		ArrayList<Admins> AdminList = adm.getAdmins();
		for (int i = 0; i < AdminList.size(); i++) {
			Admins ad = AdminList.get(i);
			assertEquals(ad,AdminList.get(i));
			System.out.println(ad);
			System.out.println(AdminList.get(i));
		}
	}

	@Test
	/**
	 * Test unitario de getClients
	 * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
	 */
	void testgetClients() throws SQLException {
		ClientsConnect cll = new ClientsConnect();
		ArrayList<Clients> clientList = cll.getClients();
		for (int i = 0; i < clientList.size(); i++) {
			Clients cli = clientList.get(i);
			assertEquals(cli,clientList.get(i));
			System.out.println(cli);
			System.out.println(clientList.get(i));
		}
	}

}
