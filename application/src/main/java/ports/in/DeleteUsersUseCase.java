package ports.in;

import data.User;

public interface DeleteUsersUseCase {

	User deleteUserById(Integer user);
}
