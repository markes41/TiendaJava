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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaArticulo extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textNombre;
	private JTextField textDescripcion;
	private JTextField textPrecio;
	createArticulo articulo;
	
	public VentanaArticulo() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JFrame ventana = new JFrame();
		ventana.setDefaultCloseOperation( HIDE_ON_CLOSE );

		
		setSize(335,314);
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
		
		JLabel lblDescripcion= new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDescripcion.setBounds(56, 134, 80, 31);
		contentPane.add(lblDescripcion);
		
		textDescripcion = new JTextField();
		textDescripcion.setBounds(139, 140, 105, 20);
		contentPane.add(textDescripcion);
		textDescripcion.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrecio.setBounds(81, 165, 55, 31);
		contentPane.add(lblPrecio);
		
		textPrecio = new JTextField();
		textPrecio.setBounds(139, 171, 105, 20);
		contentPane.add(textPrecio);
		textPrecio.setColumns(10);

		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCerrar.setBounds(31, 217, 105, 31);
		contentPane.add(btnCerrar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			private void limpiar() {
				textCodigo.setText("");
				textNombre.setText("");
				textDescripcion.setText("");
				textPrecio.setText("");
			}
			@Override		
			public void mouseClicked(MouseEvent arg0) {
					articulo = new createArticulo(
					textCodigo.getText(), 
					textNombre.getText(), 
					textDescripcion.getText(), 
					textPrecio.getText());
					
						if(textCodigo.getText() == null || textNombre.getText() == null || textDescripcion.getText() == null || textPrecio.getText().equals("")) 
						{ 

							JOptionPane.showMessageDialog(null, "ERROR LLENE TODOS LOS DATOS", "ERROR", JOptionPane.WARNING_MESSAGE);

							
						} else {
							JOptionPane.showMessageDialog(null, "LOS DATOS SE HAN GUARDADO", "GUARDADO", JOptionPane.INFORMATION_MESSAGE);								
						}
						
						limpiar();
			} 
			});

		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGuardar.setBounds(177, 217, 105, 31);
		contentPane.add(btnGuardar);
		
		JLabel lblNewLabel_4 = new JLabel("Agregar un articulo");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(94, 24, 150, 20);
		contentPane.add(lblNewLabel_4);
		

		

	}
}
