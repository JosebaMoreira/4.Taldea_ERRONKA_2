package Controlador;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import Modelo.Admins;
import Modelo.Clients;
import Modelo.BBDD.*;

public class Coordinador {

	AdminsConnect ac = new AdminsConnect();
	Admins admin = new Admins();
	
	public Coordinador(AdminsConnect ac, Admins admin) {
		this.ac = ac;
		this.admin = admin;
	}
	public Coordinador() {
	}

	
}
