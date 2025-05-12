package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setTitle("USUARIOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1004, 583);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnAnadir = new JButton("AÑADIR");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnadirUsuario frame = new AnadirUsuario();
				frame.setVisible(true);
			}
		});
		btnAnadir.setFont(new Font("Arial", Font.PLAIN, 30));
		btnAnadir.setBackground(new Color(192, 192, 192));
		contentPane.add(btnAnadir);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarUsuario frame = new EliminarUsuario();
				frame.setVisible(true);
			}
		});
		btnEliminar.setFont(new Font("Arial", Font.PLAIN, 30));
		btnEliminar.setBackground(new Color(192, 192, 192));
		contentPane.add(btnEliminar);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setFont(new Font("Arial", Font.PLAIN, 30));
		btnModificar.setBackground(new Color(192, 192, 192));
		contentPane.add(btnModificar);
		
		JButton btnVisualizar = new JButton("VISUALIZAR");
		btnVisualizar.setFont(new Font("Arial", Font.PLAIN, 30));
		btnVisualizar.setBackground(new Color(192, 192, 192));
		contentPane.add(btnVisualizar);
	}

}
