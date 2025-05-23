package Vista;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Vista.Menu;
import javax.swing.JPasswordField;

/**
 * Clase de la ventana de inicio de sesión.
 * @author 4.Taldea
 * @version 1.0
 * 
 */
public class InicioSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldDNI;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	JTextField btnReservas;
	JTextField btnMenu;
	private JPasswordField passwordFieldContraseña;
	
	/**
	 * Método que inicia la aplicación e inicia la ventana inicio de sesión.
	 * @param args Argumentos de línea de comandos
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSesion frame = new InicioSesion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Constructor de la clase InicioSesion.
	 */
	public InicioSesion() {
		setBackground(new Color(240, 240, 240));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\1AW3-13\\git\\DonostiaKultura\\DonostiaKultura\\DK.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1016, 583);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel dni = new JLabel("DNI:");
		dni.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dni.setBounds(390, 228, 56, 13);
		contentPane.add(dni);
		
		
		textFieldDNI = new JTextField();
		textFieldDNI.setBounds(390, 251, 171, 19);
		contentPane.add(textFieldDNI);
		textFieldDNI.setColumns(10);
		
		JLabel contrasenia = new JLabel("Contraseña:");
		contrasenia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contrasenia.setBounds(390, 296, 171, 13);
		contentPane.add(contrasenia);
		
		lblNewLabel = new JLabel("INICIAR SESIÓN");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(343, 79, 272, 50);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("INICIAR SESIÓN");
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(390, 375, 171, 34);
		contentPane.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\1AW3-18\\4.Taldea_ERRONKA_2\\DonostiaKultura\\DK.png\""));
		lblNewLabel_1.setBounds(0, 0, 85, 86);
		contentPane.add(lblNewLabel_1);
		
		passwordFieldContraseña = new JPasswordField();
		passwordFieldContraseña.setBounds(390, 325, 166, 19);
		contentPane.add(passwordFieldContraseña);
				
		
		btnNewButton.addActionListener(new ActionListener() {
			
			/**
			 * Acción al hacer clic en "INICIAR SESIÓN". 
			 * Llama al coordinador para autenticar al usuario.
			 * @param e Evento generado al hacer clic en el botón.
			 */
	            @Override
	            public void actionPerformed(ActionEvent e) {
	    			try {
						Controlador.Coordinador.IniciarSesion(btnNewButton, textFieldDNI, passwordFieldContraseña);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            }
	        });
	}
	
	}
