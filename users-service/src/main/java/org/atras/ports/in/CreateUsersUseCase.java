package org.atras.ports.in;

import org.atras.data.User;

public interface CreateUsersUseCase {
	User saveUser(User user);
}
