import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class ConectarUsuario extends JFrame {

	private JPanel contentPane;
	public JTextField textField;
	public JPasswordField passwordField;

	public ConectarUsuario() {
		setTitle("Inicio de Sesi\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(370,175);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(35, 11, 47, 31);
		contentPane.add(lblUsuario);
		
		JLabel lblNewLabel = new JLabel("Contrase\u00F1a");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 53, 72, 31);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(92, 16, 220, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(92, 58, 220, 24);
		contentPane.add(passwordField);
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConectar.setBounds(95, 93, 100, 37);
		contentPane.add(btnConectar);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrarse.setBounds(205, 93, 100, 37);
		contentPane.add(btnRegistrarse);
	}
}
