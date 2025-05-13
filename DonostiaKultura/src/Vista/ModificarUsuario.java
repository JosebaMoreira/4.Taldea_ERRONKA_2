package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ModificarUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtApellido;
	private JTextField txtC;
	private JTextField txtRol;
	private JTextField txtNombre;
	private JTextField txtEmail;
	private JTextField txtNmeroTelfonico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarUsuario frame = new ModificarUsuario();
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
	public ModificarUsuario() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 935, 582);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MODIFICAR");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 45));
		lblNewLabel.setBounds(339, 44, 274, 52);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DNI:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(199, 131, 53, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(198, 224, 96, 30);
		contentPane.add(lblNewLabel_2);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Arial", Font.PLAIN, 16));
		txtApellido.setBounds(197, 251, 219, 30);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Contraseña:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(199, 316, 110, 19);
		contentPane.add(lblNewLabel_3);
		
		txtC = new JTextField();
		txtC.setFont(new Font("Arial", Font.PLAIN, 16));
		txtC.setBounds(199, 334, 215, 30);
		contentPane.add(txtC);
		txtC.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("ROL:");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(199, 388, 59, 20);
		contentPane.add(lblNewLabel_4);
		
		txtRol = new JTextField();
		txtRol.setFont(new Font("Arial", Font.PLAIN, 16));
		txtRol.setBounds(198, 406, 219, 30);
		contentPane.add(txtRol);
		txtRol.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Nombre:");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(517, 131, 96, 25);
		contentPane.add(lblNewLabel_5);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 16));
		txtNombre.setBounds(517, 156, 219, 30);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox.setBounds(197, 156, 219, 30);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_6 = new JLabel("Email:");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(517, 227, 59, 24);
		contentPane.add(lblNewLabel_6);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 16));
		txtEmail.setBounds(517, 251, 219, 30);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Número Teléfonico:");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(518, 316, 203, 19);
		contentPane.add(lblNewLabel_7);
		
		txtNmeroTelfonico = new JTextField();
		txtNmeroTelfonico.setFont(new Font("Arial", Font.PLAIN, 16));
		txtNmeroTelfonico.setBounds(517, 334, 219, 30);
		contentPane.add(txtNmeroTelfonico);
		txtNmeroTelfonico.setColumns(10);
		
		JButton btnNewButton = new JButton("MODIFICAR");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton.setBounds(517, 406, 219, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("VOLVER");
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(811, 505, 100, 30);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\1AW3-18\\Downloads\\donostiaKultura.png"));
		lblNewLabel_8.setBounds(10, 10, 85, 86);
		contentPane.add(lblNewLabel_8);
	}
}
