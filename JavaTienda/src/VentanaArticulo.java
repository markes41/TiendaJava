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

public class VentanaArticulo {

	private JFrame frmArticulos;
	private JTextField txtRegerg;

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
		frmArticulos.setBounds(100, 100, 579, 443);
		frmArticulos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmArticulos.getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Codigo de articulo");
		lblNewLabel.setToolTipText("");
		
		txtRegerg = new JTextField();
		txtRegerg.setText("regerg");
		txtRegerg.setAlignmentY(Component.TOP_ALIGNMENT);
		txtRegerg.setColumns(10);
		
		JButton btnNewButton = new JButton("Guardar");
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtRegerg, GroupLayout.PREFERRED_SIZE, 563, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 563, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(363, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton)
					.addGap(36))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(37)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtRegerg, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addGap(208)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
	}
}
