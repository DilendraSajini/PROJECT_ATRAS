package org.atras.users.ports.in;

import org.atras.core.data.User;

public interface CreateUsersUseCase {
	User saveUser(User user);
}
