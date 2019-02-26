package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Kindle;
import es.salesianos.model.User;

public interface Service {

	void createNewUserFromRequest(HttpServletRequest req);

	void insertOrupdateUser(User user);

	void insert(Kindle kindle);
	
	List<User> listAllUser();
	
	List<Kindle> listAllKindles();

	void delete(Integer id);

	void delete(String tablename, Integer id);

}
