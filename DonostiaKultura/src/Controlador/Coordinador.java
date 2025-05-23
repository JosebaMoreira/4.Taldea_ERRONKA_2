package Controlador;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import Modelo.Admins;
import Modelo.Clients;
import Modelo.Reservations;
import Modelo.Users;
import Modelo.BBDD.AdminsConnect;
import Modelo.BBDD.ClientsConnect;
import Modelo.BBDD.ReservationsConnect;
import Modelo.BBDD.UsersConnect;
import Vista.Menu;
import Vista.Reservas;
import logs.FormatoHTML;

/**
  * Clase que coordina todas las ventanas.
 * @author 4.Taldea
 * @version 1.0 
 */
public class Coordinador{
	private static final Logger logger = Logger.getLogger("donostiaLogger");
	private static final Logger logger1 = Logger.getLogger("donostiaErroresLogger");
	private static final LogManager logManager = LogManager.getLogManager();
	static {
		try {
			LogManager.getLogManager().reset();
			// fichero para actividad
			FileHandler fileHandler = new FileHandler("Donostia.html", true);
			fileHandler.setFormatter(new FormatoHTML());
			logger.addHandler(fileHandler);
			logger.setLevel(Level.ALL);
			// fichero para errores
			FileHandler fileHandler1 = new FileHandler("DonostiaErrores.html", true);
			fileHandler1.setFormatter(new FormatoHTML());
			logger1.addHandler(fileHandler1);
			logger1.setLevel(Level.ALL);

		} catch (IOException e) {
			System.err.println("Error al configurar los logs");

		}
	}
	AdminsConnect ac = new AdminsConnect();
	Admins admin = new Admins();
	Clients cliente = new Clients();

	/**
	 * Constructor de la clase Coordinador que inicializa una nueva instancia con
	 * los atributos.
	 * 
	 * @param paramAc      El AdminConnect.
	 * @param paramAdmin   El objeto de Admins.
	 * @param paramCliente El objeto de Clients.
	 */
	public Coordinador(AdminsConnect paramAc, Admins paramAdmin, Clients paramCliente) {
		this.ac = paramAc;
		this.admin = paramAdmin;
		this.cliente = paramCliente;
	}

	/**
	 * Este constructor Coordinador se inicializa vacio.
	 */
	public Coordinador() {
	}

	/**
	 * Metodo para visualizar todos los datos.
	 * 
	 * @param tableModel Modelo de tabla.
	 */
	public static void visualizarDatos(DefaultTableModel tableModel) {

		AdminsConnect amc = new AdminsConnect();
		ClientsConnect cll = new ClientsConnect();

		try {
			ArrayList<Admins> adminList = amc.getAdmins(); // tiene que tener el mismo nombre de la clase adminsConnect
			ArrayList<Clients> clientList = cll.getClients();

			tableModel.setRowCount(0);

			for (Admins adm : adminList) {
				tableModel.addRow(new Object[] { adm.getDni(), adm.getName(), adm.getSurname(), adm.getEmail(),
						adm.getPassword(), adm.getPhoneNumber(), adm.getRol() });
			}
			for (Clients clt : clientList) {
				tableModel.addRow(new Object[] { clt.getDni(), clt.getName(), clt.getSurname(), clt.getEmail(),
						clt.getPassword(), clt.getPhoneNumber(), clt.getRol() });
			}
			System.out.println("Se han visualizado correctamente");
			logger.log(Level.INFO, "Se ha visualizado los usuarios correctamente");
	        JOptionPane.showMessageDialog(null, "Usuarios visualizados correctamente.");

		} catch (SQLException e) {
			System.err.println("Error al visualizar los datos");
			logger1.log(Level.WARNING, "Error al visualizar los datos");
			JOptionPane.showMessageDialog(null, "Error al visualizar los datos.");
			e.printStackTrace();
		}

	}

	/**
	 * Metodo para añadir nuevos usuarios.
	 * 
	 * @param txtDni            Celda de Dni.
	 * @param txtNombre         Celda de nombre.
	 * @param txtApellido       Celda de apellido.
	 * @param txtEmail          Celda de email.
	 * @param txtContrasea      Celda de contraseña
	 * @param txtNmeroTelefnico Celda de número teléfonico.
	 * @param comboBox          ComboBox.
	 * @param btnNewButton      Botón.
	 */
	public static void anadirUsuarios(JTextField txtDni, JTextField txtNombre, JTextField txtApellido,
			JTextField txtEmail, JTextField txtContrasea, JTextField txtNmeroTelefnico, JComboBox comboBox,
			JButton btnNewButton) {
		AdminsConnect adm = new AdminsConnect();
		ClientsConnect cll = new ClientsConnect();

		String dni = txtDni.getText();
		String name = txtNombre.getText();
		String surname = txtApellido.getText();
		String email = txtEmail.getText();
		String password = txtContrasea.getText();
		String phoneNumber = txtNmeroTelefnico.getText();
		String rol = (String) comboBox.getSelectedItem();

		try {
			if (rol.equalsIgnoreCase("admin")) {
				Admins ad = new Admins(dni, name, surname, email, password, phoneNumber, rol);
				adm.AnadirUsuario(ad);
			} else if (rol.equalsIgnoreCase("user")) {
				Clients cli = new Clients(dni, name, surname, email, password, phoneNumber, rol);
				cll.AnadirUsuario(cli);
			}
			System.out.println("Se ha añadido correctamente");
			JOptionPane.showMessageDialog(btnNewButton, "Usuario añadido correctamente");
			logger.log(Level.INFO, "Se ha añadido el usuario correctamente");
		} catch (SQLException e1) {
			System.err.println("Error al añadir los datos");
			JOptionPane.showMessageDialog(null, "No se pudo añadir al usuario correctamente", "ERROR_MESSAGE",
					JOptionPane.ERROR_MESSAGE);
			logger1.log(Level.WARNING, "Error al añadir datos");
			e1.printStackTrace();
		}
	}

	/**
	 * Método para modificar nuevos usuarios.
	 * 
	 * @param comboBoxModificar ComboBox de modificar.
	 * @param txtNombre         Celda de nombre.
	 * @param txtApellido       Celda de apellido.
	 * @param txtEmail          Celda de email.
	 * @param txtContrasea      Celda de contraseña.
	 * @param txtNmeroTelefnico Celda de número teléfonico.
	 * @param comboBoxROL       ComboBox de rol.
	 */
	public static void modificarUsuarios(JComboBox comboBoxModificar, JTextField txtNombre, JTextField txtApellido,
			JTextField txtEmail, JTextField txtContrasea, JTextField txtNmeroTelefnico, JComboBox comboBoxROL) {
		AdminsConnect adm = new AdminsConnect();
		ClientsConnect cll = new ClientsConnect();
		String dni = (String) comboBoxModificar.getSelectedItem();
		System.out.println("DNI seleccionado: " + dni);

		String name = txtNombre.getText();
		String surname = txtApellido.getText();
		String email = txtEmail.getText();
		String password = txtContrasea.getText();
		String phoneNumber = txtNmeroTelefnico.getText();
		String rol = (String) comboBoxROL.getSelectedItem();

		boolean encontrado = false;
		boolean modificado = false;

	    try {
	        ArrayList<Admins> adminList = adm.getAdmins();
	        for (int i = 0; i < adminList.size(); i++) {
	            if (dni.equalsIgnoreCase(adminList.get(i).getDni())) {
	                if (rol.equalsIgnoreCase("admin")) {
	                    Admins ad = new Admins(dni, name, surname, email, password, phoneNumber, rol);
	                    adm.modificaUsuario(ad);
	                    System.out.println("Usuario modificado correctamente");
	                    logger.log(Level.INFO, "Usuario modificado correctamente");
	                    JOptionPane.showMessageDialog(comboBoxModificar, "Usuario modificado correctamente.");
	                    modificado = true;
	                } else {
	                    JOptionPane.showMessageDialog(comboBoxModificar, "Error: Rol inválido para un administrador.");
	                }
	                encontrado = true;
	                break;
	            }
	        }

	        ArrayList<Clients> clientList = cll.getClients();
	        for (int i = 0; i < clientList.size(); i++) {
	            if (dni.equalsIgnoreCase(clientList.get(i).getDni())) {
	                if (rol.equalsIgnoreCase("user")) {
	                    Clients cli = new Clients(dni, name, surname, email, password, phoneNumber, rol);
	                    cll.modificaUsuario(cli);
	                    System.out.println("Usuario modificado correctamente");
	                    logger.log(Level.INFO, "Usuario modificado correctamente");
	                    JOptionPane.showMessageDialog(comboBoxModificar, "Usuario modificado correctamente.");
	                    modificado = true;
	                } else {
	                    JOptionPane.showMessageDialog(comboBoxModificar, "Error: Rol inválido para un cliente.");
	                }
	                encontrado = true;
	                break;
	            }
	        }

	        if (!encontrado) {
	            System.out.println("No se encontró ningún usuario con el DNI: " + dni);
	            logger.log(Level.WARNING, "No se encontró ningún usuario con el DNI: " + dni);
	            JOptionPane.showMessageDialog(comboBoxModificar, "No se encontró ningún usuario con el DNI ingresado.");
	        }

	    } catch (SQLException e) {
	        System.err.println("Error al modificar los datos");
	        logger.log(Level.WARNING, "Error al modificar los datos");
	        JOptionPane.showMessageDialog(comboBoxModificar, "Error al modificar los datos.");
	        e.printStackTrace();
	    }
	}

	/**
	 * Método para modificar nuevos usuarios.
	 * 
	 * @param comboBoxEliminar ComboBox de Eliminar.
	 * @param btnEliminar      Boton de eliminar.
	 */
	public static void EliminarUsuario(JComboBox comboBoxEliminar, JButton btnEliminar) {
		AdminsConnect amc = new AdminsConnect();
		ClientsConnect cll = new ClientsConnect();

		String dni = (String) comboBoxEliminar.getSelectedItem();
		System.out.println(dni);

		if (dni != null && dni != "") {

			try {
				for (int i = 0; i < amc.getAdmins().size(); i++) {
					System.out.println(amc.getAdmins().get(i));
					boolean enlista = true;
					if (dni.equalsIgnoreCase(amc.getAdmins().get(i).getDni())) {
						Admins adm = new Admins();
						adm.setDni(dni);
						amc.EliminarUsuario(adm);
						JOptionPane.showMessageDialog(btnEliminar, "Se pudo eliminar al usuario correctamente");
						logger.log(Level.INFO, "Se pudo eliminar al usuario correctamente");
					} else if (enlista != true) {
						JOptionPane.showMessageDialog(null, "No se pudo eliminar al usuario", "ERROR_MESSAGE",
								JOptionPane.ERROR_MESSAGE);
						logger1.log(Level.WARNING, "Error al eliminar el usuario");
					}
				}
				for (int i = 0; i < cll.getClients().size(); i++) {
					boolean enlista = true;
					if (dni.equalsIgnoreCase(cll.getClients().get(i).getDni())) {
						Clients cli = new Clients();
						cli.setDni(dni);
						cll.EliminarUsuario(cli);
						JOptionPane.showMessageDialog(btnEliminar, "Se pudo eliminar al usuario correctamente");
						logger.log(Level.INFO, "Se pudo eliminar al usuario correctamente");
					} else if (enlista != true) {
						JOptionPane.showMessageDialog(null, "No se pudo eliminar al usuario", "ERROR_MESSAGE",
								JOptionPane.ERROR_MESSAGE);
						logger1.log(Level.WARNING, "Error al eliminar el usuario");
					}
				}
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "No se pudo eliminar al usuario correctamente", "ERROR_MESSAGE",
						JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}
	}

	/**
	 * Método para visualizar los Dnis en el comboBox de Eliminar.
	 * 
	 * @param comboBoxEliminar ComboBox de eliminar.
	 */
	public static void VisualizarEliminarUsuario(JComboBox comboBoxEliminar) {
		AdminsConnect amc = new AdminsConnect();
		ClientsConnect cll = new ClientsConnect();
		try {
			comboBoxEliminar.removeAllItems();
			for (int i = 0; i < amc.getAdmins().size(); i++) {
				comboBoxEliminar.addItem(amc.getAdmins().get(i).getDni());
			}
			for (int i = 0; i < cll.getClients().size(); i++) {
				comboBoxEliminar.addItem(cll.getClients().get(i).getDni());
			}
			System.out.println("Dni visualizado correctamente");
			logger.log(Level.INFO, "Dni visualizado correctamente");
		} catch (SQLException e1) {
			System.err.println("Error al visualizar el comboBox");
			JOptionPane.showMessageDialog(comboBoxEliminar, Level.WARNING, "Error al visualizar el comboBox", 0);
			logger1.log(Level.WARNING, "Error al visualizar el comboBox");
			e1.printStackTrace();
		}
	}

	/**
	 * Método para buscar datos según su filtro.
	 * 
	 * @param tablemodel        Modelo de tabla.
	 * @param table             Tabla.
	 * @param textFieldBuscador Celda para buscar.
	 */
	public static void buscarDatos(DefaultTableModel tablemodel, JTable table, JTextField textFieldBuscador) {
		DefaultTableModel ob = (DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(ob);
		table.setRowSorter(obj);
		obj.setRowFilter(RowFilter.regexFilter(textFieldBuscador.getText()));
	}

	/**
	 * Método para iniciar sesión.
	 * 
	 * @param btnNewButton            Botón.
	 * @param textFieldDNI            Celda para dni.
	 * @param passwordFieldContraseña Celda de contraseña.
	 * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
	 */
	public static void IniciarSesion(JButton btnNewButton, JTextField textFieldDNI,
			JPasswordField passwordFieldContraseña) throws SQLException {

			ClientsConnect usr = new ClientsConnect();
			AdminsConnect adm = new AdminsConnect();
			ArrayList<Clients> clientsList = ClientsConnect.getClients();
			ArrayList<Admins> adminList = AdminsConnect.getAdmins();

			boolean enlista = false;
			for (int i = 0; i < clientsList.size(); i++) {
			if (clientsList.get(i).getDni().equalsIgnoreCase(textFieldDNI.getText())
			&& clientsList.get(i).getPassword()
			.equalsIgnoreCase(String.valueOf(passwordFieldContraseña.getPassword()))
			&& clientsList.get(i).getRol().equalsIgnoreCase("user")) {
			System.out.println(textFieldDNI.getText());
			enlista = true;
			JOptionPane.showMessageDialog(null, "Inicio de sesión de usuario correcto");
			Reservas ventana = new Reservas();
			ventana.setVisible(true);

			if (enlista == false) {
			JOptionPane.showMessageDialog(null, "DNI o contraseña incorrectos", "ERROR_MESSAGE",
			JOptionPane.ERROR_MESSAGE);

			}
			}
			}

			for (int b = 0; b < adminList.size(); b++) {

			if (adminList.get(b).getDni().equalsIgnoreCase(textFieldDNI.getText())
			&& adminList.get(b).getPassword()
			.equalsIgnoreCase(String.valueOf(passwordFieldContraseña.getPassword()))
			&& adminList.get(b).getRol().equalsIgnoreCase("admin")) {
			enlista = true;
			Menu ventana = new Menu();
			ventana.setVisible(true);
			JOptionPane.showMessageDialog(null, "Inicio de sesión de administrador correcto");

			}

			}
			if (enlista == false) {

			JOptionPane.showMessageDialog(null, "DNI o contraseña incorrectos", "ERROR_MESSAGE",
			JOptionPane.ERROR_MESSAGE);

			}

			}

	/**
	 * Método para rellenar con dnis el comboBox de modificar.
	 * 
	 * @param comboBoxModificar ComboBox de modificar.
	 */
	public static void ModificaUsuario(JComboBox comboBoxModificar) {
		AdminsConnect amc = new AdminsConnect();
		ClientsConnect clc = new ClientsConnect();

		try {
			comboBoxModificar.removeAllItems();
			for (int i = 0; i < amc.getAdmins().size(); i++) {
				comboBoxModificar.addItem(amc.getAdmins().get(i).getDni());
			}
			for (int i = 0; i < clc.getClients().size(); i++) {
				comboBoxModificar.addItem(clc.getClients().get(i).getDni());
			}
		} catch (SQLException e1) {
			System.err.println("Error al modificar los datos");
			logger1.log(Level.WARNING, "Error al modificar los datos");
			e1.printStackTrace();
		}

	}

	/**
	 * Metodo para visualizar reservas.
	 * 
	 * @param tableModel Modelo de tabla.
	 */
	public static void Reserva(DefaultTableModel tableModel) {

		ReservationsConnect rec = new ReservationsConnect();

		try {
			ArrayList<Modelo.Reservations> reservations = rec.getReservations();

			tableModel.setRowCount(0);
			for (Reservations Reservations : reservations) {
				tableModel.addRow(new Object[] { Reservations.getReservationID(), Reservations.getUserID(),
						Reservations.getSessionID() });
			}

			System.out.println("Se han visualizado los datos correctamente");
			logger.log(Level.INFO, "Se han visualizado los datos correctamente");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger1.log(Level.WARNING, "Error al visualizar reservas");
			e.printStackTrace();
		}

	}

	/**
	 * Método para cargar un XML.
	 * 
	 * @param tablexml Tabla de XML.
	 */
	public static void cargarXML(JTable table) {
        try {
            DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            Document doc = builder.parse(new File(exploradorArchivos()));
             org.w3c.dom.Element root = doc.getDocumentElement();
            NodeList reservList = root.getElementsByTagName("reserva");
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            for (int i = 0; i < reservList.getLength(); i++) {
                Node reserva = reservList.item(i);
                String reservationID = Contenido(reserva, "reservationID");
                String userID = Contenido(reserva, "userID");
                String sessionID = Contenido(reserva, "sessionID");
                model.addRow(new Object[] { reservationID, userID, sessionID });
            }
            JOptionPane.showMessageDialog(null, "XML cargado correctamente");
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "XML cargado incorrectamente", "ERROR_MESSAGE",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

	/**
	 * Método para el explorador de archivos.
	 * 
	 * @return Filepath.
	 */
	public static String exploradorArchivos() {
		String filepath = "";
		JFileChooser selector = new JFileChooser();
		selector.setCurrentDirectory(new File("."));
		int result = selector.showOpenDialog(selector);
		if (result == JFileChooser.APPROVE_OPTION) {

			File selectedFile = selector.getSelectedFile();

			filepath = selectedFile.getAbsolutePath();
		}
		return filepath;
	}

	/**
	 * Método para el contenido.
	 * 
	 * @param record  Atributo de elemento principal.
	 * @param tagName nombre de la etiqueta.
	 * @return contenido.
	 */
	private static String Contenido(Node record, String tagName) {
		NodeList list = ((org.w3c.dom.Element) record).getElementsByTagName(tagName);
		if (list.getLength() > 0) {
			return list.item(0).getTextContent().trim();
		}
		return "";
	}

	/**
	 * Método para exportar un XML.
	 * 
	 * @param btnNewButton_1 Botón.
	 * @throws ParserConfigurationException Si hay un error al configurar el analizador XML.
	 * @throws TransformerException Si hay un error al transformar el documento XML.
	 * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
	 */
	public static void exportaXML(JButton btnNewButton_1)
			throws ParserConfigurationException, TransformerException, SQLException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		ReservationsConnect conexion = new ReservationsConnect();
		Connection con = conexion.conexion();

		Statement st = con.createStatement();
		String consulta = "SELECT * FROM reservations";
		ResultSet rs = st.executeQuery(consulta);

		Document document = builder.newDocument();

		Element root = document.createElement("reservas");
		document.appendChild(root);

		while (rs.next()) {
			Element reserva = document.createElement("reserva");
			root.appendChild(reserva);
			Element reservationID = document.createElement("reservationID");
			reservationID.appendChild(document.createTextNode(rs.getString("reservationID")));
			Element userID = document.createElement("userID");
			userID.appendChild(document.createTextNode(rs.getString("userID")));
			Element sessionID = document.createElement("sessionID");
			sessionID.appendChild(document.createTextNode(rs.getString("sessionID")));

			reserva.appendChild(reservationID);
			reserva.appendChild(userID);
			reserva.appendChild(sessionID);
		}

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		DOMSource source = new DOMSource(document);

		StreamResult result = new StreamResult(exploradorArchivos());
		transformer.transform(source, result);
		JOptionPane.showMessageDialog(btnNewButton_1, "XML generado correctamente");

		System.out.println("Se ha creado el fichero XML.");
		logger.log(Level.INFO, "Se ha creado el fichero XML.");
	}

	/**
	 * Método para visualizar los datos segun los filtros en
	 * 
	 * @param tableModel  modelo de tabla
	 * @param txtDni      celda del dni
	 * @param txtApellido celda del apellido
	 */
	public static void visualizarDatos(DefaultTableModel tableModel, JTextField txtDni, JTextField txtApellido) {

		UsersConnect amc = new UsersConnect();

		try {
			ArrayList<Users> usersList = amc.buscarUsuarios(txtDni, txtApellido); // tiene que tener el mismo nombre de
																					// la clase adminsConnect

			tableModel.setRowCount(0);

			for (Users adm : usersList) {
				tableModel.addRow(new Object[] { adm.getDni(), adm.getName(), adm.getSurname(), adm.getEmail(),
						adm.getPassword(), adm.getPhoneNumber(), adm.getRol() });
			}

			System.out.println("Se han visualizado correctamente");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Método para realizar una copia de seguridad
	 * 
	 * @param copia boton para realizar la copia de seguridad
	 * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
	 */
	public static void realizarFicheroBinario(JButton copia) throws SQLException {

		File archivo = new File(exploradorArchivos());
		UsersConnect amc = new UsersConnect();
		ArrayList<Users> usersList = amc.buscarUsuariosTodos();
		try {
			FileOutputStream fos = new FileOutputStream(archivo);
			ObjectOutputStream escribir = new ObjectOutputStream(fos);

			for (int i = 0; i < usersList.size(); i++) {
				escribir.writeObject(usersList);

			}
			escribir.close();
			fos.close();

		} catch (Exception e) {
			System.out.println("Error al escribir en el archivo. " + e.getMessage());
		}
	}

	/**
	 * Método para cargar la copia de seguridad
	 * 
	 * @param tableModel modelo de tabla
	 * @throws IOException Si ocurre un error durante la lectura del archivo.
	 * @throws ClassNotFoundException Si la clase `Users` no se encuentra durante la deserialización.
	 */
	public static void cargarFicheroBinario(DefaultTableModel tableModel) throws IOException, ClassNotFoundException {

		File archivo = new File(exploradorArchivos());
		try {
			FileInputStream fis = new FileInputStream(archivo);
			ObjectInputStream leer;

			while (fis.available() > 0) {
				leer = new ObjectInputStream(fis);

				ArrayList<Users> Empleado = (ArrayList<Users>) leer.readObject();
				System.out.println(Empleado);

				tableModel.setRowCount(0);
				for (int i = 0; i < Empleado.size(); i++) {
					tableModel.addRow(new Object[] { Empleado.get(i).getDni(), Empleado.get(i).getName(),
							Empleado.get(i).getSurname(), Empleado.get(i).getEmail(), Empleado.get(i).getPassword(),
							Empleado.get(i).getPhoneNumber(), Empleado.get(i).getRol() });
				}
			}

		} catch (Exception e) {
			System.out.println("Se han mostrado con exito los datos ");

		}

	}
/**
 * Méotodo para realizar un explorador de archivos para la copia de seguridad
 * 
 * @return filepath
 */
	public static String exploradorArchivosBinario() {
		String filepath = "";
		FileNameExtensionFilter filter = new FileNameExtensionFilter("DAT File", "dat");
		JFileChooser selector = new JFileChooser();

		selector.setFileFilter(filter);
		selector.setSelectedFile(new File("*.dat"));
		selector.setCurrentDirectory(new File("./src/backUpUsuarios/"));

		int result = selector.showOpenDialog(selector);
		if (result == JFileChooser.APPROVE_OPTION) {

			File selectedFile = selector.getSelectedFile();

			filepath = selectedFile.getAbsolutePath();
		}
		return filepath;
	}
}
