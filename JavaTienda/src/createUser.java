import javax.swing.JOptionPane;

public class createUser {
	private String firstName, lastName, username, password, repeatPassword;
	Archivo createUser = new Archivo();
	private boolean correct = false;

	public createUser(String firstName, String lastName, String username, String password, String repeatPassword) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.repeatPassword = repeatPassword;
		
		if(getPassword().equals(getRepeatPassword())) {
			createUser.escribirFichero(firstName,lastName,username,password);
			correct = true;
			setCorrect(correct);
		}
		
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
	

