package interfaz;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import leerEscribir.Archivo;
import programa.Usuario;
import programa.AddUsuarios;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.SwingConstants;

public class VentanaUsuarioNuevo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombre;
	private JTextField contrasenia;
	Usuario usuario;
	VentanaLogin login = new VentanaLogin();
	Archivo archi = new Archivo();
	private JTextField nickname;

	public VentanaUsuarioNuevo() {
		setTitle("Registro de usuario");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(302, 298);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel lblPrimerNombre = new JLabel("Nombre");
		lblPrimerNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrimerNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrimerNombre.setBounds(10, 30, 266, 31);
		contentPane.add(lblPrimerNombre);

		nombre = new JTextField();
		nombre.setBounds(47, 59, 190, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);

		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario");
		lblNombreDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombreDeUsuario.setBounds(10, 86, 266, 31);
		contentPane.add(lblNombreDeUsuario);

		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblContrasea.setBounds(10, 148, 266, 31);
		contentPane.add(lblContrasea);

		contrasenia = new JTextField();
		contrasenia.setBounds(47, 179, 190, 20);
		contentPane.add(contrasenia);
		contrasenia.setColumns(10);
		
		nickname = new JTextField();
		nickname.setBounds(47, 117, 190, 20);
		contentPane.add(nickname);
		nickname.setColumns(10);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarUsuario();
			}
		});
		btnRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrarse.setBounds(160, 210, 118, 31);
		contentPane.add(btnRegistrarse);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaLogin().setVisible(true);
				this.setVisible(false);
				dispose();
			}

			private void setVisible(boolean b) {
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.setBounds(21, 210, 118, 31);
		contentPane.add(btnVolver);
		
		
	}
	
	public void cargarUsuario() {
		String rutaUsuarios = "usuarios.dat";

		Archivo archi = new Archivo();

		Scanner sc = new Scanner(System.in);
		AddUsuarios AddUsuarios;

		if (archi.createFile(rutaUsuarios)) {
			AddUsuarios = new AddUsuarios();
			archi.save(AddUsuarios, rutaUsuarios);
		} else {
			AddUsuarios = (AddUsuarios) archi.load(rutaUsuarios);
		}

		
		crearUsuario(AddUsuarios,rutaUsuarios);
	}
	
	public void crearUsuario(AddUsuarios usuario, String rutaUsuarios) {
			Archivo archi = new Archivo();
		

			String nombreUsuario = nombre.getText();
			String password = contrasenia.getText();
			String nick = nickname.getText();
			
			if(   usuario.addUsuarios(nick, password, nombreUsuario)     ) {
				JOptionPane.showMessageDialog(null,
						"El usuario "+nick+" se creó correctamente. Aprete 'ACEPTAR' para volver al menú de login",
						"Nuevo usuario creado", JOptionPane.WARNING_MESSAGE);
				archi.save(usuario, rutaUsuarios);
			}else {
				JOptionPane.showMessageDialog(null,
						"El usuario con el nickname "+nick+" ya existe. Volvé a intentarlo.",
						"Usuario ya existente.", JOptionPane.WARNING_MESSAGE);
			}	
		
	}
	}
