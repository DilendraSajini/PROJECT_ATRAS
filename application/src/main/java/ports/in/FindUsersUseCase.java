package ports.in;

import java.util.List;

import data.User;

public interface FindUsersUseCase {

	List<User> findUsers();
	
	User findUsersById(Integer userId);
}
