import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Archivo test = new Archivo();


	public VentanaPrincipal() {
		setResizable(false);
		setTitle("Stock de Articulos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(363,561);
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
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(309, 73, 17, 388);
		contentPane.add(scrollBar);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaArticulo art = new VentanaArticulo();
				art.setVisible(true);
			}
		});
		btnAgregar.setBounds(20, 472, 90, 31);
		contentPane.add(btnAgregar);
		
		JButton btnNewButton_2_2 = new JButton("ELIMINAR");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2_2.setBounds(223, 472, 88, 31);
		contentPane.add(btnNewButton_2_2);
		
		JButton btnNewButton_2 = new JButton("EDITAR");
		btnNewButton_2.setBounds(120, 472, 93, 31);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 301, 31);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nombre", "Descripcion", "Precio",
				
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 104, 301, 360);
		contentPane.add(panel);
		
		ConectarUsuario.
		
		if(test.isEmptyEmployee() == false) {
			btnNewButton_2.setVisible(false);
			btnNewButton_2_2.setVisible(false);
			
		}
	}
}
