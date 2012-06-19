package root.impl;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import model.User;
import root.interfaces.UserManager;
import util.SaverLoaderUtil;

public class UserManagerImpl implements UserManager {
	private transient final static Logger LOGGER = Logger.getRootLogger();
	final private Map<String, User> customers = new HashMap<String, User>();
	final private LinkedHashMap<User, Date> loggedUsers = new LinkedHashMap<User, Date>();
	@Override
	public boolean register(String login, String password, String email) {
		if(!isRegistered(login)){
			User user = new User(email, login, hashForPassword(password));
			customers.put(login, user);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public User login(String login, String password) {
		User user = customers.get(login);
		if(user != null){
			if(hashForPassword(password).equals(user.getHashPassword())){
				loggedUsers.put(user, Calendar.getInstance().getTime());
				return user;
			}else{
//				LOGGER.error(hashForPassword(password) + "===" + user.getHashPassword());
				return null;
			}
		}else{
			return null;
		}
	}
	private static String hashForPassword(String pass){
		MessageDigest md = null;
		byte[] bytesOfMessage = null;
		try {
			bytesOfMessage = pass.getBytes("UTF-8");
			md = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
		}
		String s = new String(md.digest(bytesOfMessage));
		return s;
	}

	@Override
	public boolean logout(User user) {
		return loggedUsers.remove(user) != null;
	}

	@Override
	public boolean isLogged(String login) {
		for (Iterator<User> iterator = loggedUsers.keySet().iterator(); iterator.hasNext();) {
			 User user = iterator.next();
			if(user.getLogin().equals(login)){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isRegistered(String login) {
		return customers.containsKey(login);
	}
}
