package org.atras.users.ports.in;

import java.util.List;

import org.atras.core.data.User;

public interface FindUsersUseCase {

	List<User> findUsers();
	
	User findUsersById(Integer userId);
}
