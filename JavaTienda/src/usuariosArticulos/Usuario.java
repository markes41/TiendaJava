package usuariosArticulos;
import java.io.Serializable;

public class Usuario implements Serializable{

	private static final long serialVersionUID = -888159244032468800L;
	private String username;
	private String password;
	private String nickname;

	public Usuario(String username, String password, String nickname) {
		this.username = username;
		this.password = password;
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUsername() {
		return username;
	}

	@Override
	public String toString() {
		return "Usuario [username=" + username + ", password=" + password + ", nickname=" + nickname + "]";
	}
	
	public boolean isClave(String password) {
		return this.getPassword().equals(password);
	}
	

}
