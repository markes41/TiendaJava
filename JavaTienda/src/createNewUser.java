import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class createNewUser extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textLastName;
	private JTextField textUsername;
	private JTextField textPass;
	private JTextField textRepeatPass;
	createUser user;
	ConectarUsuario login = new ConectarUsuario();
	browseRepeatUser browseUser = new browseRepeatUser();


	/**
	 * Create the frame.
	 */
	public createNewUser() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450,350);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPrimerNombre = new JLabel("Nombre");
		lblPrimerNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrimerNombre.setBounds(94, 30, 55, 31);
		contentPane.add(lblPrimerNombre);
		
		textName = new JTextField();
		textName.setBounds(25, 64, 190, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblApellido.setBounds(299, 37, 66, 17);
		contentPane.add(lblApellido);
		
		textLastName = new JTextField();
		textLastName.setBounds(223, 64, 201, 20);
		contentPane.add(textLastName);
		textLastName.setColumns(10);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario");
		lblNombreDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombreDeUsuario.setBounds(156, 86, 116, 31);
		contentPane.add(lblNombreDeUsuario);
		
		textUsername = new JTextField();
		textUsername.setBounds(63, 116, 323, 20);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblContrasea.setBounds(73, 147, 105, 31);
		contentPane.add(lblContrasea);
		
		JLabel lblRepearPass = new JLabel("Repetir contraseña");
		lblRepearPass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRepearPass.setBounds(258, 147, 128, 31);
		contentPane.add(lblRepearPass);
		
		textPass = new JTextField();
		textPass.setBounds(25, 189, 190, 20);
		contentPane.add(textPass);
		textPass.setColumns(10);
		
		textRepeatPass = new JTextField();
		textRepeatPass.setBounds(223, 189, 201, 20);
		contentPane.add(textRepeatPass);
		textRepeatPass.setColumns(10);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				browseUser.leerFichero(textUsername.getText());
				if(browseUser.isExiste() == true) {
					JOptionPane.showMessageDialog(null, "Usuario", "Error user", JOptionPane.WARNING_MESSAGE);
					browseUser.setExiste(false);
				}else if(!(textPass.getText().equals(textRepeatPass.getText()))){
					JOptionPane.showMessageDialog(null, "Password distintas", "Error Password", JOptionPane.WARNING_MESSAGE);
				}else {
					user = new createUser(textName.getText(), 
						textLastName.getText(), 
						textUsername.getText(), 
						textPass.getText(), 
						textRepeatPass.getText());
						setVisible(false);
						login.setVisible(true);
				}
				
				
				
			}
		});
		btnRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrarse.setBounds(268, 239, 118, 40);
		contentPane.add(btnRegistrarse);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.setBounds(63, 239, 118, 40);
		contentPane.add(btnVolver);
	}
}
