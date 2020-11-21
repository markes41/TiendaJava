import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	createArticulo articulo;
	private JTable table;
	

	public VentanaPrincipal(String userType) {
		setResizable(false);
		setTitle("Stock de Articulos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(363, 561);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblListaDeArticulos = new JLabel("Lista de articulos");
		lblListaDeArticulos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeArticulos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListaDeArticulos.setBounds(99, 11, 133, 23);
		contentPane.add(lblListaDeArticulos);

		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaArticulo art = new VentanaArticulo();
				art.setVisible(true);
			}
		});
		btnAgregar.setBounds(20, 472, 90, 31);
		contentPane.add(btnAgregar);

		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminar.setBounds(223, 472, 88, 31);
		contentPane.add(btnEliminar);

		JButton btnEditar = new JButton("EDITAR");
		btnEditar.setBounds(120, 472, 93, 31);
		contentPane.add(btnEditar);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(109, 34, 123, 14);
		lblNewLabel.setText(userType);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 73, 289, 388);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Descripci\u00F3n", "Codigo", "Precio"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modelo = (DefaultTableModel)table.getModel();
				modelo.addRow(new Object[] {"asd", "asd1", 15, 15.25});
				
			}
		});
		btnNewButton.setBounds(120, 498, 89, 23);
		contentPane.add(btnNewButton);
		
		
		
		if (userType.equals("Cliente")) {
		btnEliminar.setVisible(false);
		btnAgregar.setVisible(false);
		btnEditar.setVisible(false);
		}
		
		
		

	}
}
