package interfaz;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import leerEscribir.Archivo;
import leerEscribir.Parametros;
import programa.AddUsuarios;
import programa.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
public class VentanaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txtUser;
	public JTextField txtPass;
	Archivo testUser = new Archivo();
	VentanaUsuarioCliente client = new VentanaUsuarioCliente();

	public VentanaLogin() {

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
				cargarDatosUsuarios();
				
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

	
	public void cargarDatosUsuarios() {
		String rutaUsuarios = "usuarios.dat";

		Archivo archi = new Archivo();
		AddUsuarios AddUsuarios;

		if (archi.createFile(rutaUsuarios)) {
			AddUsuarios = new AddUsuarios();
			archi.save(AddUsuarios, rutaUsuarios);
		} else {
			AddUsuarios = (AddUsuarios) archi.load(rutaUsuarios);
		}


		Parametros.getInstance().setUsuarioLogueado(ingresar(AddUsuarios));
	}
	
	public Usuario ingresar(AddUsuarios usuario) {
		
		if(!usuario.existeUsuario(txtUser.getText())) {
			JOptionPane.showMessageDialog(null,
					"El nombre de usuario que ingresaste no coincide con ninguna cuenta.",
					"Usuario incorrecto.", JOptionPane.WARNING_MESSAGE);
			txtUser.setText("");
			return null;
		}
		
		Usuario u = usuario.getUsuario(txtUser.getText());
		
		
		if(u.isClave(txtPass.getText())) {
			client.setVisible(true);
			setVisible(false);
			return u;
		}else {
			JOptionPane.showMessageDialog(null,
					"La contraseña que ingresaste es incorrecta.",
					"Contraseña incorrecta.", JOptionPane.WARNING_MESSAGE);
		return null;
		}
		
		
		
	}
}
