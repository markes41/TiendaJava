import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Boton extends JFrame implements ActionListener{

	JButton boton;
	
	public Boton() {
		setLayout(null);
		boton = new JButton("PRUEBA");
		boton.setBounds(400, 300, 100, 150); //MEDIDAS BOT�N
		boton.addActionListener(this); //PARA REACCIONAR A UNA ACCI�N
		add(boton);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}