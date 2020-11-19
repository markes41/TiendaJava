import javax.swing.JOptionPane;

public class createUser {
	private String firstName, lastName, username, password, repeatPassword;
	Archivo createUser = new Archivo();
	private boolean correct = false;
	browseRepeatUser browseUser = new browseRepeatUser(); 

	public createUser(String firstName, String lastName, String username, String password, String repeatPassword) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.repeatPassword = repeatPassword;
		
		createUser.escribirFichero(firstName,lastName,username,password);
		VentanaPrincipal test = new VentanaPrincipal(username);
	}
	
	public boolean checkPassword(String data1, String data2) {
		if(data1.equals(data2))
			return true;
		else
			return false;

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

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	
	
	}
	

