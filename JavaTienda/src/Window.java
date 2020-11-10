import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.JPanel;

public class Window extends JFrame{
	
	public Window() {
		super("Stock de artículos");
		this.setSize(800,600);
		this.setLocationRelativeTo(null); //CENTRAMOS VENTANA
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //TERMINA EL PROGRAMA AL APRETAR LA X
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		JPanel panel = new JPanel();
		this.getContentPane().add(panel);//SE AGREGA EL PANEL
		
	}
}

