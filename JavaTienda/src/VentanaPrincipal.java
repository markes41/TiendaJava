import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JTextField;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	public JTextField textoRelleno;

	public VentanaPrincipal() {
		setTitle("Stock de Articulos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Archivo file = new Archivo();
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					file.escribir(textoRelleno.getText());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(137, 140, 89, 23);
		contentPane.add(btnNewButton);
		
		textoRelleno = new JTextField();
		textoRelleno.setBounds(140, 109, 86, 20);
		contentPane.add(textoRelleno);
		textoRelleno.setColumns(10);
	}
	
	
	
}
