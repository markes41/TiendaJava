

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
	
	public int pasarInfo() {
			if(getPassword().equals(getRepeatPassword())) {
				createUser.escribirFichero(firstName,lastName,username,password);
				return 1;
			}else {
				return 0;
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
	}
	

