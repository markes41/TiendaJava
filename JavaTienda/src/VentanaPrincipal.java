import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	createArticulo articulo;
	private JTable table;
	Archivo test = new Archivo();
	ImageIcon carrito = new ImageIcon("carrito.png");
	private JTextField textCantidad;
	VentanaCarrito carro;
	
	

	public VentanaPrincipal(String userType) {
		setResizable(false);
		setTitle("Stock de Articulos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(363, 601);
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

		JButton btnAgregar = new JButton("NUEVO");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaArticulo art = new VentanaArticulo();
				art.setVisible(true);
			}
		});
		btnAgregar.setBounds(20, 472, 90, 31);
		contentPane.add(btnAgregar);



		JButton btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
				"Nombre", "Cantidad", "Descripci\u00F3n", "Codigo", "Precio"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Integer.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		DefaultTableModel modelo = (DefaultTableModel)table.getModel();
		test.buscarArticulos();
		String[] nombre = test.getNombre();
		String[] codigo = test.getCode();
		String[] desc = test.getDesc();
		String[] price = test.getPrice();
		String[] cantidad = test.getCantidad();
		
		for(int i = 0; i < nombre.length; i++) {
			if(nombre[i] == null) {
				break;
			}else {
				modelo.addRow(new Object[] {nombre[i],Integer.parseInt(cantidad[i]) ,desc[i], Integer.parseInt(codigo[i]), Double.parseDouble(price[i])});
			}
		}
		
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(table.getSelectedRow());
				System.out.println(table.getSelectedColumn());
				//deleteAllRows();
			}
		});
		btnEliminar.setBounds(223, 472, 88, 31);
		contentPane.add(btnEliminar);
		
		JLabel lblCarrito = new JLabel("");
		lblCarrito.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				carro.setVisible(true);
			}
		});
		lblCarrito.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarrito.setBounds(263, 17, 46, 45);
		lblCarrito.setIcon(carrito);
		contentPane.add(lblCarrito);
		
		textCantidad = new JTextField();
		textCantidad.addKeyListener(new KeyAdapter() {
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
		textCantidad.setBounds(120, 518, 189, 23);
		contentPane.add(textCantidad);
		textCantidad.setColumns(10);
		
		JButton btnCantidad = new JButton("AGREGAR");
		btnCantidad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int fila = table.getSelectedRow();
				String nombre = (modelo.getValueAt(fila, 0)).toString();
				String cantidad = textCantidad.getText();
				
				if(Integer.parseInt(textCantidad.getText()) > 0) {
					carro = new VentanaCarrito(nombre, cantidad, (modelo.getValueAt(fila, 4)));
				}else {
					JOptionPane.showMessageDialog(null, "Rellene el campo o ingrese una cantidad mayor a 0.",
							"Cantidad errónea", JOptionPane.WARNING_MESSAGE);
				}
				
				textCantidad.setText("");
			}
		});
		btnCantidad.setBounds(20, 514, 88, 31);
		contentPane.add(btnCantidad);
		
		if (userType.equals("Cliente")) {
		btnEliminar.setVisible(false);
		btnAgregar.setVisible(false);
		btnEditar.setVisible(false);
		}
		
		

	}
}




