package model;

import java.io.Serializable;
import java.text.MessageFormat;


public class User implements Serializable{
	private static final long serialVersionUID = -2005838902055622982L;
	final private String login;
	private String email;
	private String hashPassword;

	public User(String email, String login, String hashPassword) {
		super();
		this.email = email;
		this.login = login;
		this.hashPassword = hashPassword;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return MessageFormat.format("User [email={0}, login={1}, hashPassword={2}]",
				email, login, hashPassword);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHashPassword() {
		return hashPassword;
	}
	public void setHashPassword(String hashPassword) {
		this.hashPassword = hashPassword;
	}
	public String getLogin() {
		return login;
	}
	
}
