package root.interfaces;

import java.io.Serializable;
import java.util.List;

import root.exceptions.RegisterException;
import model.User;

public interface UserManager extends Serializable{
	
	boolean register(String login, String password, String email) throws RegisterException;
	
	User login(String login, String password);
	
	boolean logout(User user);
	
	boolean isLogged(String login);
	
	boolean isRegistered(String login);
	
}
