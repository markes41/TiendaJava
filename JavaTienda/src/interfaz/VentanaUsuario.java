package interfaz;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import leerEscribir.Archivo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class VentanaUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txtUser;
	public JTextField txtPass;
	Archivo testUser = new Archivo();
	String typeUser;

	public VentanaUsuario() {

		setTitle("Inicio de Sesion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(370, 175);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(35, 11, 47, 31);
		contentPane.add(lblUsuario);

		JLabel lblNewLabel = new JLabel("Contraseña");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 53, 72, 31);
		contentPane.add(lblNewLabel);

		txtUser = new JTextField();
		txtUser.setBounds(92, 16, 220, 24);
		contentPane.add(txtUser);
		txtUser.setColumns(10);

		txtPass = new JTextField();
		txtPass.setBounds(92, 58, 220, 24);
		contentPane.add(txtPass);

		JButton btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				testUser.leerFichero(txtUser.getText(), txtPass.getText());
				if (testUser.isExiste() == true) {
					testUser.buscarEmpleado(txtUser.getText());
					if (testUser.isEmptyEmployee() == true)
						typeUser = "Empleado";
					else
						typeUser = "Cliente";

					VentanaPrincipal main = new VentanaPrincipal(typeUser);
					setVisible(false);
					main.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "No se encontro el usuario y/o contraseña.",
							"Credenciales erroneas", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnConectar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConectar.setBounds(95, 93, 100, 37);
		contentPane.add(btnConectar);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaUsuarioNuevo register = new VentanaUsuarioNuevo();
				register.setVisible(true);
				setVisible(false);
			}
		});
		btnRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrarse.setBounds(205, 93, 100, 37);
		contentPane.add(btnRegistrarse);
	}

}
