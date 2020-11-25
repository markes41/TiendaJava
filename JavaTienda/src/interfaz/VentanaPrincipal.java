package interfaz;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import leerEscribir.Archivo;
import programa.Articulo;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButton;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Articulo articulo;
	private JTable table;
	Archivo test = new Archivo();
	ImageIcon carrito = new ImageIcon("carrito.png");
	private JTextField textCantidad;
	private JTable tableCarrito;
	int cantTotal;
	double resultFinal;
	DefaultTableModel modeloCarrito;
	DefaultTableModel modelo;
	VentanaEditar edit;
	int cantProduct;
	int fila;
	JRadioButton checkArticulos;
	JRadioButton checkCarrito;

	@SuppressWarnings("deprecation")
	public VentanaPrincipal(String userType) {
		setResizable(false);
		setTitle("Stock de Articulos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(598, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblListaDeArticulos = new JLabel("Lista de articulos");
		lblListaDeArticulos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeArticulos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListaDeArticulos.setBounds(20, 11, 289, 23);
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
				obtenerNombreObjetoModificar();
			}
		});
		btnEditar.setBounds(120, 472, 93, 31);
		contentPane.add(btnEditar);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(20, 34, 289, 14);
		lblNewLabel.setText(userType);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 73, 289, 388);
		contentPane.add(scrollPane);

		table = new JTable();

		table.setModel(
				new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Cantidad", "Codigo", "Precio"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		scrollPane.setViewportView(table);

		try {
			RemoveEmptyLines();
		} catch (IOException e2) {
			System.out.println("ADASDASDSA");
			e2.printStackTrace();
		}
		// PASAR DATOS DE ARTICULOS.TXT A LA TABLA ARTICULOS//
		pasarDatosDeArticulos();
		//////////////////////////////////////////////////////

		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				obtenerNombreObjetoEliminado();
			}
		});
		btnEliminar.setBounds(223, 472, 88, 31);
		contentPane.add(btnEliminar);

		textCantidad = new JTextField();
		textCantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char validar = evt.getKeyChar();

				if (Character.isLetter(validar)) {
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
		btnCantidad.setBounds(20, 514, 90, 31);
		contentPane.add(btnCantidad);

		JLabel lblNewLabel_1 = new JLabel("Carrito de compras");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(319, 15, 265, 14);
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
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableCarrito.getColumnModel().getColumn(0).setResizable(false);
		scrollPane_1.setViewportView(tableCarrito);
		

		JButton btnBorrar = new JButton("BORRAR ");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				obtenerNombreObjetoEliminado();
				borrarFilaSeleccionadaCarrito();
			}
		});
		btnBorrar.setBounds(319, 472, 123, 31);
		contentPane.add(btnBorrar);

		JButton btnComprar = new JButton("COMPRAR");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				confirmarCompraCarrito();
				restarCantidad(cantProduct, (int) modelo.getValueAt(fila, 1));

			}
		});
		btnComprar.setBounds(452, 472, 123, 31);
		contentPane.add(btnComprar);

		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Vera el nuevo valor en lo ultimo de su tabla pero por falta de personal en nuestras oficinas se le duplicaran sus articulos, para una mayor eficacia agregue sus articulos y reinicie el programa.",
						"ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
				ActualizarDatos();
				try {
					RemoveEmptyLines();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pasarDatosDeArticulos();

			}
		});
		btnNewButton.setBounds(319, 518, 100, 23);
		contentPane.add(btnNewButton);
		
		checkCarrito = new JRadioButton("Carrito");
		checkCarrito.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//DESACTIVA
				table.setEnabled(false);
				btnAgregar.setEnabled(false);
				btnEditar.setEnabled(false);
				btnEliminar.setEnabled(false);
				btnCantidad.setEnabled(false);
				textCantidad.setEnabled(false);
				checkArticulos.setSelected(false);
				
				//ACTIVA
				tableCarrito.setEnabled(true);
				btnComprar.setEnabled(true);
				btnBorrar.setEnabled(true);
				checkCarrito.setSelected(true);
			}
		});
		checkCarrito.setHorizontalAlignment(SwingConstants.CENTER);
		checkCarrito.setBounds(398, 46, 109, 23);
		checkCarrito.setSelected(false);
		contentPane.add(checkCarrito);
		
		checkArticulos = new JRadioButton("Lista Articulos");
		checkArticulos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				//DESACTIVA
				tableCarrito.setEnabled(false);
				btnComprar.setEnabled(false);
				btnBorrar.setEnabled(false);
				checkCarrito.setSelected(false);
				
				//ACTIVA
				table.setEnabled(true);
				btnAgregar.setEnabled(true);
				btnEditar.setEnabled(true);
				btnEliminar.setEnabled(true);
				btnCantidad.setEnabled(true);
				textCantidad.setEnabled(true);
			}
		});
		checkArticulos.setHorizontalAlignment(SwingConstants.CENTER);
		checkArticulos.setBounds(20, 46, 289, 23);
		
		contentPane.add(checkArticulos);
		tableCarrito.setEnabled(false);
		btnComprar.setEnabled(false);
		btnBorrar.setEnabled(false);
		

		if (userType.equals("Cliente")) {
			btnEliminar.setVisible(false);
			btnAgregar.setVisible(false);
			btnEditar.setVisible(false);
			btnCantidad.setBounds(20, 472, 88, 31);
			textCantidad.setBounds(120, 476, 189, 23);
		}
		
	}

	public void confirmarCompraCarrito() {
		for (int i = 0; i < tableCarrito.getRowCount(); i++) {
			resultFinal += (double) tableCarrito.getValueAt(i, 2);
		}

		if (tableCarrito.getRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "Antes de comprar, tenés que agregar algo al carrito.",
					"Compra no realizada.", JOptionPane.WARNING_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "¡Has realizado una compra por $" + resultFinal + "!",
					"Compra exitosa.", JOptionPane.WARNING_MESSAGE);
			resetTableCarrito();
		}
		resultFinal = 0;
	}

	public void resetTableCarrito() {
		modeloCarrito.setRowCount(0);
	}

	public void borrarFilaSeleccionadaCarrito() {
		if (tableCarrito.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null,
					"Tenés que seleccionar una fila, en la lista del carrito, la cual borrar.",
					"No hay fila seleccionada", JOptionPane.WARNING_MESSAGE);
		} else {
			modeloCarrito.removeRow(tableCarrito.getSelectedRow());
		}
	}

	public void agregarElementosToCarrito() {
		modeloCarrito = (DefaultTableModel) tableCarrito.getModel();
		fila = table.getSelectedRow();
		if (textCantidad.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Rellene el campo o ingrese una cantidad mayor a 0.",
					"Cantidad errónea", JOptionPane.WARNING_MESSAGE);
		} else if (!Archivo.isNumeric(textCantidad.getText())) {
			JOptionPane.showMessageDialog(null, "Ingresaste un carácter que no es número, volvé a intentarlo.",
					"Carácter erróneo", JOptionPane.WARNING_MESSAGE);
		}

		else if (Integer.parseInt(textCantidad.getText()) > 0) {
			/////////////////////////////////////////////////////////////
			String nameProduct = (modelo.getValueAt(fila, 0)).toString();
			cantProduct = Integer.parseInt(textCantidad.getText());
			String priceProduct = (modelo.getValueAt(fila, 3)).toString();

			//////////////////////// PASAR VALORES A TABLA CARRITO//////////////////////////
			modeloCarrito
					.addRow(new Object[] { nameProduct, cantProduct, Double.parseDouble(priceProduct) * cantProduct });
		} else {
			JOptionPane.showMessageDialog(null, "Rellene el campo o ingrese una cantidad mayor a 0.",
					"Cantidad errónea", JOptionPane.WARNING_MESSAGE);
		}

		textCantidad.setText("");

	}

	public void pasarDatosDeArticulos() {
		modelo = (DefaultTableModel) table.getModel();
		test.buscarArticulos();
		String[] nombre = test.getNombre();
		String[] codigo = test.getCode();
		String[] price = test.getPrice();
		String[] cantidad = test.getCantidad();

		for (int i = 0; i < nombre.length; i++) {
			if (nombre[i] == null) {

				break;
			} else {
				modelo.addRow(new Object[] { nombre[i], Integer.parseInt(cantidad[i]), Integer.parseInt(codigo[i]),
						Integer.parseInt(price[i]) });

			}

		}

	}

	public void ActualizarDatos() {

		modelo.setRowCount(0);

	}

	public void obtenerNombreObjetoEliminado() {
		if (table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null,
					"Tenés que seleccionar una fila, en la lista de artículos, la cual borrar.",
					"No hay fila seleccionada", JOptionPane.WARNING_MESSAGE);
		} else {
			String nombreBorrado = modelo.getValueAt(table.getSelectedRow(), 2).toString() + " "
					+ (String) modelo.getValueAt(table.getSelectedRow(), 0) + " "
					+ modelo.getValueAt(table.getSelectedRow(), 3).toString() + " "
					+ modelo.getValueAt(table.getSelectedRow(), 1).toString();
			modelo.removeRow(table.getSelectedRow());
			borrarLinea(nombreBorrado);

		}
	}

	public void obtenerNombreObjetoModificar() {
		int fila = table.getSelectedRow();
		modeloCarrito = (DefaultTableModel) tableCarrito.getModel();

		if (table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null,
					"Tenés que seleccionar una fila, en la lista del carrito, la cual editar.",
					"No hay fila seleccionada", JOptionPane.WARNING_MESSAGE);
		} else {
			String datos = modelo.getValueAt(fila, 2).toString() + " " + modelo.getValueAt(fila, 0).toString() + " "
					+ modelo.getValueAt(fila, 3).toString() + " " + modelo.getValueAt(fila, 1).toString() + " ";
			edit = new VentanaEditar(datos);
			edit.setVisible(true);

		}
	}

	public void restarCantidad(int cantidadElegida, int cantidadEnTabla) {
		try {
			// input the file content to the StringBuffer "input"
			BufferedReader file = new BufferedReader(new FileReader("articulos.txt"));
			String line;
			StringBuffer inputBuffer = new StringBuffer();

			while ((line = file.readLine()) != null) {
				inputBuffer.append(line);
				inputBuffer.append('\n');
			}
			String inputStr = inputBuffer.toString();

			file.close();
			int cantidadToPasar = cantidadEnTabla - cantidadElegida;

			inputStr = inputStr.replace(String.valueOf(cantidadEnTabla), String.valueOf(cantidadToPasar));

			FileOutputStream fileOut = new FileOutputStream("articulos.txt");
			fileOut.write(inputStr.getBytes());
			fileOut.close();

		} catch (Exception e) {
			System.out.println("No se ha podido leer el fichero correctamente.");
		}
	}

	public void borrarLinea(String lineaToBorrar) {
		try {
			BufferedReader file = new BufferedReader(new FileReader("articulos.txt"));
			String line;
			StringBuffer inputBuffer = new StringBuffer();

			while ((line = file.readLine()) != null) {
				inputBuffer.append(line);
				inputBuffer.append('\n');
			}
			String inputStr = inputBuffer.toString();

			file.close();

			inputStr = inputStr.replace(lineaToBorrar, "");

			FileOutputStream fileOut = new FileOutputStream("articulos.txt");
			fileOut.write(inputStr.getBytes());
			fileOut.close();

		} catch (Exception e) {
			System.out.println("No se ha podido leer el fichero correctamente.");
		}
	}

	public static void RemoveEmptyLines() throws IOException {
		File inputFile = new File("articulos.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		String inputFileReader;
		ArrayList<String> DataArray = new ArrayList<String>();
		while ((inputFileReader = reader.readLine()) != null) {
			if (inputFileReader.length() <= 1) {
				continue;
			}
			DataArray.add(inputFileReader);
		}
		reader.close();

		BufferedWriter bw = new BufferedWriter(new FileWriter("articulos.txt"));
		for (int i = 0; i < DataArray.size(); i++) {
			bw.write(DataArray.get(i));
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}

}
