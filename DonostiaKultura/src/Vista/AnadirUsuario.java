package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class AnadirUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtApellido;
	private JTextField txtContrasea;
	private JTextField txtRol;
	private JTextField txtNombre;
	private JTextField txtEmail;
	private JTextField txtNmeroTelefnico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnadirUsuario frame = new AnadirUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AnadirUsuario() {
		setBackground(new Color(240, 240, 240));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\1AW3-13\\git\\DonostiaKultura\\DonostiaKultura\\DK.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 935, 583);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AÑADIR");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel.setBounds(407, 35, 217, 52);
		contentPane.add(lblNewLabel);
		
		txtDni = new JTextField();
		txtDni.setForeground(new Color(128, 128, 128));
		txtDni.setFont(new Font("Arial", Font.PLAIN, 16));
		txtDni.setText("DNI...");
		txtDni.setBounds(196, 109, 217, 34);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("DNI:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(196, 87, 45, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Apellido:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(196, 174, 78, 24);
		contentPane.add(lblNewLabel_1_1);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Arial", Font.PLAIN, 16));
		txtApellido.setForeground(new Color(128, 128, 128));
		txtApellido.setText("Apellido...");
		txtApellido.setColumns(10);
		txtApellido.setBounds(196, 197, 217, 34);
		contentPane.add(txtApellido);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Contraseña:");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(196, 266, 110, 24);
		contentPane.add(lblNewLabel_1_1_1);
		
		txtContrasea = new JTextField();
		txtContrasea.setText("Contraseña...");
		txtContrasea.setForeground(new Color(128, 128, 128));
		txtContrasea.setFont(new Font("Arial", Font.PLAIN, 16));
		txtContrasea.setColumns(10);
		txtContrasea.setBounds(196, 292, 217, 34);
		contentPane.add(txtContrasea);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("ROL:");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(196, 358, 56, 24);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		txtRol = new JTextField();
		txtRol.setForeground(new Color(128, 128, 128));
		txtRol.setFont(new Font("Arial", Font.PLAIN, 16));
		txtRol.setText("ROL...");
		txtRol.setColumns(10);
		txtRol.setBounds(196, 380, 217, 34);
		contentPane.add(txtRol);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nombre:");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(533, 87, 78, 24);
		contentPane.add(lblNewLabel_1_2);
		
		txtNombre = new JTextField();
		txtNombre.setForeground(new Color(128, 128, 128));
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 16));
		txtNombre.setText("Nombre...");
		txtNombre.setColumns(10);
		txtNombre.setBounds(533, 109, 217, 34);
		contentPane.add(txtNombre);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Email:");
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_2_1.setBounds(533, 174, 78, 24);
		contentPane.add(lblNewLabel_1_2_1);
		
		txtEmail = new JTextField();
		txtEmail.setForeground(new Color(128, 128, 128));
		txtEmail.setText("Email...");
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(533, 197, 217, 34);
		contentPane.add(txtEmail);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Número Telefónico:");
		lblNewLabel_1_2_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_2_1_1.setBounds(533, 266, 176, 24);
		contentPane.add(lblNewLabel_1_2_1_1);
		
		txtNmeroTelefnico = new JTextField();
		txtNmeroTelefnico.setForeground(new Color(128, 128, 128));
		txtNmeroTelefnico.setFont(new Font("Arial", Font.PLAIN, 16));
		txtNmeroTelefnico.setText("Número Telefónico...");
		txtNmeroTelefnico.setColumns(10);
		txtNmeroTelefnico.setBounds(533, 292, 217, 34);
		contentPane.add(txtNmeroTelefnico);
		
		JButton btnNewButton = new JButton("AÑADIR");
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton.setBounds(533, 380, 217, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("VOLVER");
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(811, 505, 100, 30);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\1AW3-13\\git\\DonostiaKultura\\DonostiaKultura\\DK.png"));
		lblNewLabel_2.setBounds(0, 0, 78, 77);
		contentPane.add(lblNewLabel_2);
	}
}
