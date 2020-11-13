import java.io.IOException;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class createUser {
	private String firstName, lastName, username, password, repeatPassword;
	Archivo createUser = new Archivo();

	public createUser(String firstName, String lastName, String username, String password, String repeatPassword) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.repeatPassword = repeatPassword;
		pasarInfo();
	}
	
	public void pasarInfo() {
		createUser.escribirFichero(firstName, lastName, username, password);
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUsername() {
		return username;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}
	
	public String getPassword() {
		return password;
	}
	}
	

