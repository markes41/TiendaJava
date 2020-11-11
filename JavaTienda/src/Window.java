import javax.swing.*;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.JPanel;


public class Window extends JFrame{
	JPanel panel;
	
	public Window() {
		super("Stock de artículos");
		this.setSize(800,600);
		this.setLocationRelativeTo(null); //CENTRAMOS VENTANA
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //TERMINA EL PROGRAMA AL APRETAR LA X
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		colocarPanel();
		colocarTexto();
		//colocarBotones();
		//colocarChecks();
	}
	
	private void colocarPanel() {
		panel = new JPanel();
		this.getContentPane().add(panel);//SE AGREGA EL PANEL
	}
	
	private void colocarBotones() {
		JButton boton1 = new JButton("SALIR");
		boton1.setBounds(144, 200, 100, 100);
		panel.add(boton1);
	}
	
	private void colocarTexto() {
		JRadioButton check1 = new JRadioButton();
		
	}
}

