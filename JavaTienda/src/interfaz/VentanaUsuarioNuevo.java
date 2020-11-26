package interfaz;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import leerEscribir.Archivo;
import leerEscribir.BuscarUsuariosRepetidos;
import programa.Usuario;
import programa.AddUsuarios;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class VentanaUsuarioNuevo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombre;
	private JTextField nombreUsuario;
	private JTextField contrasenia;
	Usuario usuario;
	VentanaLogin login = new VentanaLogin();
	Archivo archi = new Archivo();
	BuscarUsuariosRepetidos usuarioRepetido = new BuscarUsuariosRepetidos();

	public VentanaUsuarioNuevo() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 350);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel lblPrimerNombre = new JLabel("Nombre");
		lblPrimerNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrimerNombre.setBounds(189, 30, 55, 31);
		contentPane.add(lblPrimerNombre);

		nombre = new JTextField();
		nombre.setBounds(124, 72, 190, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);

		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario");
		lblNombreDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombreDeUsuario.setBounds(156, 86, 116, 31);
		contentPane.add(lblNombreDeUsuario);

		nombreUsuario = new JTextField();
		nombreUsuario.setBounds(63, 116, 323, 20);
		contentPane.add(nombreUsuario);
		nombreUsuario.setColumns(10);

		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblContrasea.setBounds(167, 148, 105, 31);
		contentPane.add(lblContrasea);

		contrasenia = new JTextField();
		contrasenia.setBounds(124, 190, 190, 20);
		contentPane.add(contrasenia);
		contrasenia.setColumns(10);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrarse.setBounds(268, 239, 118, 40);
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
		btnVolver.setBounds(63, 239, 118, 40);
		contentPane.add(btnVolver);
	}
	
	}
