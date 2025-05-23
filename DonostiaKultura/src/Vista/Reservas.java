package Vista;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTree;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Clase para gestionar reservas.
 * @author 4.Taldea
 * @version 1.0
 */
public class Reservas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTable table;
	
	/**
	 * Método que inicia la aplicación mostrando la ventana de reservas.
	 * @param args Argumentos de línea de comandos.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservas frame = new Reservas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Constructor de la clase Reservas.
	 */
	public Reservas() {
		setBackground(new Color(240, 240, 240));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\1AW3-13\\git\\DonostiaKultura\\DonostiaKultura\\DK.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 935, 582);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RESERVAS");
		lblNewLabel.setBounds(378, 36, 188, 79);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("CARGAR");
		btnNewButton.setBounds(402, 424, 116, 26);
		btnNewButton.addActionListener(new ActionListener() {
			
			/**
			 * Acción al hacer clic en "CARGAR".
			 * Llama al método que carga los datos desde un archivo XML y los muestra en la tabla.
			 * @param e Evento generado al hacer clic en el botón.
			 */
			public void actionPerformed(ActionEvent e) {
				Controlador.Coordinador.cargarXML(table);
			}
		});
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("GENERAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			/**
			 * Acción al hacer clic en "GENERAR".
			 * Llama al método que exporta los datos de la tabla a un archivo XML.
			 * @param e Evento generado al hacer clic en el botón.
			 */
			public void actionPerformed(ActionEvent e) {
				try {
					Controlador.Coordinador.exportaXML(btnNewButton_1);
				} catch (ParserConfigurationException | TransformerException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(402, 475, 116, 26);
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 91, 79);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\1aw3-1\\Downloads\\DK.png"));
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(96, 137, 724, 251);
		contentPane.add(scrollPane_1);
		
		DefaultTableModel tableModel = new DefaultTableModel(new Object[] { "ID Reserva", "ID Usuario", "ID Sesión" }, 0);
		table = new JTable(tableModel);
		table.setEnabled(false);
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane_1.setViewportView(table);
		Controlador.Coordinador.Reserva(tableModel);
	}
}
