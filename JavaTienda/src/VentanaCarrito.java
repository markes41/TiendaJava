import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaCarrito extends JFrame {

	private JPanel contentPane;
	private JTable table;


	public VentanaCarrito(String nombre, String cantidad, Object precio) {
		setTitle("Carrito de compras");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(265, 340);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CARRITO DE COMPRA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 229, 26);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 48, 208, 197);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Cantidad", "Total"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		DefaultTableModel modelo = (DefaultTableModel)table.getModel();
		
		JButton btnNewButton = new JButton("VOLVER");
		btnNewButton.setBounds(10, 256, 89, 23);
		contentPane.add(btnNewButton);
		
		String test = precio.toString();
		double test1 = Double.parseDouble(test);
		int cantidadParse = Integer.parseInt(cantidad);
		modelo.addRow(new Object[] {nombre, cantidadParse, test1 * cantidadParse});
		
		JButton btnNewButton_1 = new JButton("COMPRAR");
		btnNewButton_1.setBounds(150, 256, 89, 23);
		contentPane.add(btnNewButton_1);
		
	}
}
