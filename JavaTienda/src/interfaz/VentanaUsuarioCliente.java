package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaUsuarioCliente extends JFrame {
	
	public boolean usuario;
	private JPanel contentPane;
	VentanaPrincipal main = new VentanaPrincipal();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaUsuarioCliente frame = new VentanaUsuarioCliente();
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
	public VentanaUsuarioCliente() {
		setTitle("Elegir");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 202);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SOS USUARIO O CLIENTE?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(68, 11, 228, 60);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Cliente");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(true);
				setVisible(false);
				usuario = false;
			}
		});
		btnNewButton_1.setBounds(175, 82, 97, 41);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Usuario");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(true);
				setVisible(false);
				usuario = true;
			}
		});
		btnNewButton_1_1.setBounds(68, 82, 97, 41);
		contentPane.add(btnNewButton_1_1);
	}
}
