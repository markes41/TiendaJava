import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

public class VentanaArticuloFinal {

	private JFrame frame;
	private JTable table;
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
					VentanaArticuloFinal window = new VentanaArticuloFinal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaArticuloFinal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 709, 536);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Codigo", "Nombre", "Descripcion", "Precio"
			}
		));
		table.setBounds(10, 80, 379, 160);
		frame.getContentPane().add(table);
		
		JLabel lblListaDeArticulos = new JLabel("Lista de articulos");
		lblListaDeArticulos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeArticulos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListaDeArticulos.setBounds(255, 23, 133, 23);
		frame.getContentPane().add(lblListaDeArticulos);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setText("<dynamic>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(255, 55, 123, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(481, 330, 88, 31);
		frame.getContentPane().add(btnEliminar);
		
		JButton btnEditar = new JButton("EDITAR");
		btnEditar.setBounds(481, 277, 93, 31);
		frame.getContentPane().add(btnEditar);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.setBounds(481, 235, 90, 31);
		frame.getContentPane().add(btnAgregar);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(481, 121, 105, 20);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(481, 86, 105, 20);
		frame.getContentPane().add(textField_1);
		
		JLabel lblPrimerNombre = new JLabel("Codigo");
		lblPrimerNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrimerNombre.setBounds(424, 80, 47, 31);
		frame.getContentPane().add(lblPrimerNombre);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombre.setBounds(416, 122, 55, 17);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDescripcion.setBounds(399, 146, 80, 31);
		frame.getContentPane().add(lblDescripcion);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(482, 152, 105, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(482, 183, 105, 20);
		frame.getContentPane().add(textField_3);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrecio.setBounds(424, 177, 55, 31);
		frame.getContentPane().add(lblPrecio);
	}
}
