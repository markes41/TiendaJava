import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class VentanaArticulo extends JFrame {

	private JFrame frmArticulos;
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
					VentanaArticulo window = new VentanaArticulo();
					window.frmArticulos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaArticulo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmArticulos = new JFrame();
		frmArticulos.setTitle("Articulos");
		frmArticulos.setBounds(100, 100, 499, 299);
		frmArticulos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmArticulos.getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(287, 225, 86, 23);
		frmArticulos.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Guardar");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setBounds(386, 225, 86, 23);
		frmArticulos.getContentPane().add(btnNewButton_1_1);
		
		textField = new JTextField();
		textField.setBounds(218, 64, 92, 18);
		textField.setColumns(10);
		textField.setAlignmentY(0.0f);
		frmArticulos.getContentPane().add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(171, 96, 37, 14);
		frmArticulos.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(218, 93, 92, 20);
		frmArticulos.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Descripcion");
		lblNewLabel_2.setBounds(154, 131, 54, 14);
		frmArticulos.getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(218, 128, 92, 20);
		frmArticulos.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Precio");
		lblNewLabel_3.setBounds(179, 162, 29, 14);
		frmArticulos.getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(218, 159, 92, 20);
		frmArticulos.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("A\u00F1adir un nuevo articulo");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(152, 11, 175, 14);
		frmArticulos.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(175, 66, 33, 16);
		frmArticulos.getContentPane().add(lblNewLabel);
	}
}
