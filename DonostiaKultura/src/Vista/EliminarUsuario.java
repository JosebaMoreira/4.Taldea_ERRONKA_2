package Vista;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Admins;
import Modelo.Clients;
import Modelo.BBDD.AdminsConnect;
import Modelo.BBDD.ClientsConnect;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
/**
 * Clase para la ventana de eliminar un usuario.
 * @author 4.Taldea
 * @version 1.0
 * 
 */
public class EliminarUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Método que inicia la ventana para eliminar un usuario.
	 * @param args Argumentos de línea de comandos.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarUsuario frame = new EliminarUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Constructor de la clase EliminarUsuario.
	 */
	public EliminarUsuario() {
		setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\1AW3-13\\git\\DonostiaKultura\\DonostiaKultura\\DK.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 935, 583);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ELIMINAR");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel.setBounds(407, 35, 217, 52);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("DNI:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(341, 123, 96, 19);
		contentPane.add(lblNewLabel_1);

		JComboBox comboBoxEliminar = new JComboBox();
		comboBoxEliminar.setBackground(new Color(192, 192, 192));
		comboBoxEliminar.setBounds(341, 149, 217, 35);
		contentPane.add(comboBoxEliminar);

		Controlador.Coordinador.VisualizarEliminarUsuario(comboBoxEliminar);

		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			/**
			 * Acción que elimina el usuario seleccionado en el comboBox.
			 * Llama al método del coordinador para eliminar un usuario.
			 * @param e Evento de acción generado al hacer clic en el botón.
			 */
			public void actionPerformed(ActionEvent e) {
				Controlador.Coordinador.EliminarUsuario(comboBoxEliminar, btnEliminar);
			}
		});
		btnEliminar.setFont(new Font("Arial", Font.PLAIN, 16));
		btnEliminar.setBackground(new Color(192, 192, 192));
		btnEliminar.setBounds(341, 210, 217, 35);
		contentPane.add(btnEliminar);

		JButton btnNewButton_1 = new JButton("VOLVER");
		btnNewButton_1.addActionListener(new ActionListener() {
			/**
			 * Cierra la ventana actual al pulsar "VOLVER".
			 * @param e Evento de acción generado al hacer clic en el botón "VOLVER".
			 */
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(811, 505, 100, 30);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\1AW3-13\\git\\DonostiaKultura\\DonostiaKultura\\DK.png"));
		lblNewLabel_2.setBounds(0, 0, 86, 75);
		contentPane.add(lblNewLabel_2);
	}
}
