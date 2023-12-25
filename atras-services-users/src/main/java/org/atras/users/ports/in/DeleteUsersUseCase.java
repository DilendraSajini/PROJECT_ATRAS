package org.atras.users.ports.in;

import org.atras.core.data.User;

public interface DeleteUsersUseCase {

	User deleteUserById(Integer user);
}
