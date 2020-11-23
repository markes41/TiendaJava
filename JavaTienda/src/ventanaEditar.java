import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ventanaEditar {

	private JFrame frmEditarArticulo;
	private JTextField textCodigo;
	private JTextField textNombre;
	private JTextField textDesc;
	private JTextField textPrice;


	public ventanaEditar() {
		frmEditarArticulo = new JFrame();
		frmEditarArticulo.setTitle("Editar articulo");
		frmEditarArticulo.setBounds(100, 100, 335, 269);
		frmEditarArticulo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEditarArticulo.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(83, 50, 33, 16);
		frmEditarArticulo.getContentPane().add(lblNewLabel);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(54, 183, 92, 33);
		frmEditarArticulo.getContentPane().add(btnCancelar);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(181, 183, 86, 33);
		frmEditarArticulo.getContentPane().add(btnGuardar);

		textCodigo = new JTextField();
		textCodigo.setColumns(10);
		textCodigo.setAlignmentY(0.0f);
		textCodigo.setBounds(126, 49, 92, 18);
		frmEditarArticulo.getContentPane().add(textCodigo);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(79, 81, 37, 14);
		frmEditarArticulo.getContentPane().add(lblNewLabel_1);

		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(126, 78, 92, 20);
		frmEditarArticulo.getContentPane().add(textNombre);

		JLabel lblNewLabel_2 = new JLabel("Descripcion");
		lblNewLabel_2.setBounds(62, 112, 54, 14);
		frmEditarArticulo.getContentPane().add(lblNewLabel_2);

		textDesc = new JTextField();
		textDesc.setColumns(10);
		textDesc.setBounds(126, 109, 92, 20);
		frmEditarArticulo.getContentPane().add(textDesc);

		JLabel lblNewLabel_3 = new JLabel("Precio");
		lblNewLabel_3.setBounds(87, 143, 29, 14);
		frmEditarArticulo.getContentPane().add(lblNewLabel_3);

		textPrice = new JTextField();
		textPrice.setColumns(10);
		textPrice.setBounds(126, 140, 92, 20);
		frmEditarArticulo.getContentPane().add(textPrice);

		JLabel lblNewLabel_4 = new JLabel("Editar un articulo");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(10, 11, 299, 14);
		frmEditarArticulo.getContentPane().add(lblNewLabel_4);
	}
}

