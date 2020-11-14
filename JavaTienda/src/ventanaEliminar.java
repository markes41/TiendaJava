import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ventanaEliminar {

	private JFrame frmEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaEliminar window = new ventanaEliminar();
					window.frmEliminar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ventanaEliminar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEliminar = new JFrame();
		frmEliminar.setTitle("Eliminar");
		frmEliminar.setBounds(100, 100, 412, 210);
		frmEliminar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEliminar.getContentPane().setLayout(null);
			 
		
		JLabel lblNewLabel = new JLabel("ESTA SEGURO QUE DESEA ELIMINAR EL PRODUCTO?");
		lblNewLabel.setBounds(66, 11, 263, 83);
		frmEliminar.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("NO");
		btnNewButton.setBounds(76, 105, 89, 23);
		frmEliminar.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SI");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(240, 105, 89, 23);
		frmEliminar.getContentPane().add(btnNewButton_1);
	}

}
