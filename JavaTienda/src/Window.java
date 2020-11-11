import javax.swing.*;
import javax.swing.JPanel;


public class Window extends JFrame{
	JPanel panel;
	private String texto;
	
	public Window() {
		super("Stock de artículos");
		this.setSize(800,600);
		this.setLocationRelativeTo(null); //CENTRAMOS VENTANA
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //TERMINA EL PROGRAMA AL APRETAR LA X
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		colocarPanel();
		colocarCajaTexto();
		colocarBotones();	
	}
	
	private void colocarPanel() {
		panel = new JPanel();
		panel.setLayout(null); //Agregamos el setLayout en null para que nos tome el setBounds de los botones, labels, etc
		this.getContentPane().add(panel);//SE AGREGA EL PANEL
	}
	
	private void colocarBotones() {
		JButton boton1 = new JButton("AGREGAR");
		boton1.setBounds(300, 240, 100, 50);
		panel.add(boton1);
	}
	
	private void colocarCajaTexto() {
		JTextField cajaTexto = new JTextField();
		cajaTexto.setBounds(300, 200, 200, 30);
		texto = cajaTexto.getText();
		setTexto(texto);
		panel.add(cajaTexto);
		
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
}

