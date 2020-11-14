import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;

public class ventanaEditar {

	private JFrame frmEditarArticulo;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaEditar window = new ventanaEditar();
					window.frmEditarArticulo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ventanaEditar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEditarArticulo = new JFrame();
		frmEditarArticulo.setTitle("Editar articulo");
		frmEditarArticulo.setBounds(100, 100, 340, 310);
		frmEditarArticulo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEditarArticulo.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(83, 50, 33, 16);
		frmEditarArticulo.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(54, 183, 92, 33);
		frmEditarArticulo.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Guardar");
		btnNewButton_1_1.setBounds(181, 183, 86, 33);
		frmEditarArticulo.getContentPane().add(btnNewButton_1_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setAlignmentY(0.0f);
		textField.setBounds(126, 49, 92, 18);
		frmEditarArticulo.getContentPane().add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(79, 81, 37, 14);
		frmEditarArticulo.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(126, 78, 92, 20);
		frmEditarArticulo.getContentPane().add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("Descripcion");
		lblNewLabel_2.setBounds(62, 112, 54, 14);
		frmEditarArticulo.getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(126, 109, 92, 20);
		frmEditarArticulo.getContentPane().add(textField_2);
		
		JLabel lblNewLabel_3 = new JLabel("Precio");
		lblNewLabel_3.setBounds(87, 143, 29, 14);
		frmEditarArticulo.getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(126, 140, 92, 20);
		frmEditarArticulo.getContentPane().add(textField_3);
		
		JLabel lblNewLabel_4 = new JLabel("Editar un articulo");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(90, 11, 128, 14);
		frmEditarArticulo.getContentPane().add(lblNewLabel_4);
	}
}
