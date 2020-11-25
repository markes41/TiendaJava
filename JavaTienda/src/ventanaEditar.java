import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ventanaEditar extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCode;
	private JTextField txtName;
	private JTextField txtCantidad;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JTextField txtPrice;

	public ventanaEditar(String data) {
		setTitle("Editar art\u00EDculo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(249, 248);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("EDITAR ART\u00CDCULO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 213, 27);
		contentPane.add(lblNewLabel);

		txtCode = new JTextField();
		txtCode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char validar = evt.getKeyChar();

				if (Character.isLetter(validar)) {
					getToolkit().beep();
					evt.consume();
					JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
				}
			}
		});
		txtCode.setBounds(88, 47, 118, 20);
		contentPane.add(txtCode);
		txtCode.setColumns(10);

		txtName = new JTextField();
		txtName.setBounds(88, 78, 118, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);

		txtCantidad = new JTextField();
		txtCantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char validar = evt.getKeyChar();

				if (Character.isLetter(validar)) {
					getToolkit().beep();
					evt.consume();
					JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
				}
			}
		});
		txtCantidad.setBounds(88, 109, 118, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(20, 49, 60, 14);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 81, 68, 14);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_4 = new JLabel("Cantidad");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(10, 112, 68, 14);
		contentPane.add(lblNewLabel_4);

		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(10, 171, 92, 32);
		contentPane.add(btnVolver);

		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtCode.getText().equals("") || txtName.getText().equals("") || txtCantidad.getText().equals("")
						|| txtPrice.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Completá todos los casilleros antes de darle a 'GUARDAR'.",
							"Datos sin rellenar", JOptionPane.WARNING_MESSAGE);
				} else if (!archivo.isNumeric(txtCode.getText()) || !archivo.isNumeric(txtCantidad.getText())
						|| !archivo.isNumeric(txtPrice.getText())) {

					JOptionPane.showMessageDialog(null, "Ingresaste un carácter que no es número, volvé a intentarlo.",
							"Carácter erróneo", JOptionPane.WARNING_MESSAGE);

				} else {

					String replaceWith = txtCode.getText() + " " + txtName.getText() + " " + txtPrice.getText() + " "
							+ txtCantidad.getText() + " ";
					replaceSelected(data, replaceWith);
					setVisible(false);
				}

			}
		});
		btnGuardar.setBounds(131, 171, 92, 32);
		contentPane.add(btnGuardar);

		JLabel lblNewLabel_4_1 = new JLabel("Precio");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4_1.setBounds(10, 143, 68, 14);
		contentPane.add(lblNewLabel_4_1);

		txtPrice = new JTextField();
		txtPrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char validar = evt.getKeyChar();

				if (Character.isLetter(validar)) {
					getToolkit().beep();
					evt.consume();
					JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
				}
			}
		});
		txtPrice.setColumns(10);
		txtPrice.setBounds(88, 140, 118, 20);
		contentPane.add(txtPrice);
	}

	public static void replaceSelected(String oldLine, String replaceWith) {
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

			inputStr = inputStr.replace(oldLine, replaceWith);

			FileOutputStream fileOut = new FileOutputStream("articulos.txt");
			fileOut.write(inputStr.getBytes());
			fileOut.close();

		} catch (Exception e) {
			System.out.println("No se ha podido leer el fichero correctamente.");
		}

	}
}
