import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaArticulo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textNombre;
	private JTextField textPrecio;
	createArticulo articulo;
	VentanaPrincipal principal;
	private JTextField txtCantidad;
	
	public VentanaArticulo() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		JFrame ventana = new JFrame();
		ventana.setDefaultCloseOperation(HIDE_ON_CLOSE);

		setSize(335, 282);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPrimerNombre = new JLabel("Codigo");
		lblPrimerNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrimerNombre.setBounds(81, 68, 47, 31);
		contentPane.add(lblPrimerNombre);

		textCodigo = new JTextField();
		textCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char validar=evt.getKeyChar();
				
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					evt.consume();
					JOptionPane.showMessageDialog(rootPane, "Ingresar solo números");
			}
			}
		});
		textCodigo.setBounds(138, 74, 105, 20);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombre.setBounds(73, 110, 55, 17);
		contentPane.add(lblNombre);

		textNombre = new JTextField();
		textNombre.setBounds(138, 109, 105, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrecio.setBounds(82, 138, 55, 31);
		contentPane.add(lblPrecio);
		
		textPrecio = new JTextField();
		textPrecio.setBounds(140, 144, 105, 20);
		textPrecio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char validar=evt.getKeyChar();
				
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					evt.consume();
					JOptionPane.showMessageDialog(rootPane, "Ingresar solo números");
			}
			}
		});
		contentPane.add(textPrecio);
		textPrecio.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCantidad.setBounds(73, 169, 55, 31);
		contentPane.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(139, 175, 105, 20);
		txtCantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char validar=evt.getKeyChar();
				
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					evt.consume();
					JOptionPane.showMessageDialog(rootPane, "Ingresar solo números");
			}
			}
		});
		contentPane.add(txtCantidad);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCerrar.setBounds(32, 206, 105, 31);
		contentPane.add(btnCerrar);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			private void limpiar() {
				textCodigo.setText("");
				textNombre.setText("");
				textPrecio.setText("");
				txtCantidad.setText("");
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				articulo = new createArticulo(textCodigo.getText(), textNombre.getText(),
						textPrecio.getText(), txtCantidad.getText());

				if (textCodigo.getText() == null || textNombre.getText() == null
						|| textPrecio.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Llená todos los datos antes de crear un nuevo artículo", "Datos sin rellenar",
							JOptionPane.WARNING_MESSAGE);

				} else if(!Archivo.isNumeric(textCodigo.getText())) {
					
					JOptionPane.showMessageDialog(null, "Ingresaste un carácter que no es número, volvé a intentarlo.", "Carácter erróneo",
							JOptionPane.WARNING_MESSAGE);
				}
				
				else {
					JOptionPane.showMessageDialog(null, "Los datos se guardaron correctamente.", "Artículo guardado",
							JOptionPane.INFORMATION_MESSAGE);
				}
				limpiar();
			}
			
		});
		

		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGuardar.setBounds(178, 206, 105, 31);
		contentPane.add(btnGuardar);

		JLabel lblNewLabel_4 = new JLabel("Agregar un articulo");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(94, 24, 150, 20);
		contentPane.add(lblNewLabel_4);
		
		

	}
}
