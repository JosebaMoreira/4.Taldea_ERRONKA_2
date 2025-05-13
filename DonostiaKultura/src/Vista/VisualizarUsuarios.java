package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class VisualizarUsuarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTable table;
	public DefaultTableModel tableModel;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizarUsuarios frame = new VisualizarUsuarios();
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
	public VisualizarUsuarios() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 935, 582);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VISUALIZAR");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 45));
		lblNewLabel.setBounds(339, 44, 274, 52);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DNI:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(144, 135, 46, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(376, 132, 78, 30);
		contentPane.add(lblNewLabel_2);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Arial", Font.PLAIN, 16));
		txtApellido.setBounds(464, 134, 158, 30);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		JButton btnNewButton = new JButton("BUSCAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton.setBounds(649, 132, 118, 30);
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
		
		txtDni = new JTextField();
		txtDni.setFont(new Font("Arial", Font.PLAIN, 16));
		txtDni.setBounds(195, 134, 158, 30);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(84, 182, 771, 240);
		contentPane.add(scrollPane);
		
		tableModel = new DefaultTableModel(new Object[] { "DNI", "Nombre", "Apellido", "Rol", "Mail", "Telefono", "Contraseña" },0);

		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		
		JButton btnNewButton_2 = new JButton("REALIZAR COPIA DE SEGURIDAD");
		btnNewButton_2.setBackground(new Color(192, 192, 192));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewButton_2.setBounds(325, 432, 274, 36);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("CARGAR COPIA DE SEGURIDAD");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBackground(new Color(192, 192, 192));
		btnNewButton_3.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewButton_3.setBounds(325, 486, 274, 36);
		contentPane.add(btnNewButton_3);
	}
}
