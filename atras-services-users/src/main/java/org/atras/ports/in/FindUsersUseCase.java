package org.atras.ports.in;

import java.util.List;

import org.atras.data.User;

public interface FindUsersUseCase {

	List<User> findUsers();
	
	User findUsersById(Integer userId);
}
