package org.atras.ports.out;

import java.util.List;

import org.atras.data.User;

public interface UserRepository {

	List<User> findUsers();
	
	User findUsersById(Integer userId);

	User saveUser(User user);

	User deleteUserById(Integer userId);

}
