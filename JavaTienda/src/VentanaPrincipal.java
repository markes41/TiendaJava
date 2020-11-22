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
	private JTable tableCarrito;
	int cantTotal;
	double resultFinal;
	DefaultTableModel modeloCarrito;
	DefaultTableModel modelo;

	
	

	public VentanaPrincipal(String userType) {
		setResizable(false);
		setTitle("Stock de Articulos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 577);
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
		
		//PASAR DATOS DE ARTICULOS.TXT A LA TABLA ARTICULOS//
		pasarDatosDeArticulos();
		//////////////////////////////////////////////////////
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//deleteAllRows();
			}
		});
		btnEliminar.setBounds(223, 472, 88, 31);
		contentPane.add(btnEliminar);
		
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
		btnCantidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				agregarElementosToCarrito();
			}
			
		});
		btnCantidad.setBounds(20, 514, 88, 31);
		contentPane.add(btnCantidad);
		
		JLabel lblNewLabel_1 = new JLabel("Carrito de compras");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(385, 17, 177, 14);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(319, 73, 265, 388);
		contentPane.add(scrollPane_1);
		
		tableCarrito = new JTable();
		tableCarrito.setModel(new DefaultTableModel(
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
		scrollPane_1.setViewportView(tableCarrito);
		
		JButton btnBorrar = new JButton("BORRAR ");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				borrarFilaSeleccionadaCarrito();
			}
		});
		btnBorrar.setBounds(319, 472, 123, 31);
		contentPane.add(btnBorrar);
		
		JButton btnNewButton = new JButton("COMPRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				confirmarCompraCarrito();
				resetTableCarrito();
			}
		});
		btnNewButton.setBounds(462, 472, 123, 31);
		contentPane.add(btnNewButton);
		
		if (userType.equals("Cliente")) {
		btnEliminar.setVisible(false);
		btnAgregar.setVisible(false);
		btnEditar.setVisible(false);
		}
		
		

	}
	
	public void confirmarCompraCarrito() {
		for(int i = 0; i < tableCarrito.getRowCount(); i++) {
			resultFinal += (double) tableCarrito.getValueAt(i, 2);
		}
		
		JOptionPane.showMessageDialog(null, "¡Has realizado una compra por $"+resultFinal+"!",
				"Compra exitosa.", JOptionPane.WARNING_MESSAGE);
		resultFinal = 0;
	}
	
	public void resetTableCarrito() {
		modeloCarrito.setRowCount(0);
	}
	
	public void borrarFilaSeleccionadaCarrito() {
		modeloCarrito.removeRow(tableCarrito.getSelectedRow());
	}

	public void agregarElementosToCarrito(){
		modeloCarrito = (DefaultTableModel)tableCarrito.getModel();
		int fila = table.getSelectedRow();
		if(Integer.parseInt(textCantidad.getText()) > 0) {
			/////////////////////////////////////////////////////////////
			String nameProduct = (modelo.getValueAt(fila, 0)).toString();
			int cantProduct = Integer.parseInt(textCantidad.getText());
			String priceProduct = (modelo.getValueAt(fila, 4)).toString();
			
			////////////////////////PASAR VALORES A TABLA CARRITO//////////////////////////
			modeloCarrito.addRow(new Object[] {nameProduct, cantProduct, Double.parseDouble(priceProduct) * cantProduct});
		}else {
			JOptionPane.showMessageDialog(null, "Rellene el campo o ingrese una cantidad mayor a 0.",
					"Cantidad errónea", JOptionPane.WARNING_MESSAGE);
		}

		textCantidad.setText("");
		
	}

	public void pasarDatosDeArticulos() {
		modelo = (DefaultTableModel)table.getModel();
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
	}
}




