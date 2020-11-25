package Interfaz;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaEliminar {

	private JFrame frmEliminar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEliminar window = new VentanaEliminar();
					window.frmEliminar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaEliminar() {
		initialize();
	}

	private void initialize() {
		frmEliminar = new JFrame();
		frmEliminar.setTitle("Eliminar");
		frmEliminar.setBounds(100, 100, 355, 189);
		frmEliminar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEliminar.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("ESTA SEGURO QUE DESEA ELIMINAR EL PRODUCTO?");
		lblNewLabel.setBounds(37, 11, 263, 49);
		frmEliminar.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("NO");
		btnNewButton.setBounds(37, 71, 89, 23);
		frmEliminar.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("SI");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(211, 71, 89, 23);
		frmEliminar.getContentPane().add(btnNewButton_1);
	}

}
