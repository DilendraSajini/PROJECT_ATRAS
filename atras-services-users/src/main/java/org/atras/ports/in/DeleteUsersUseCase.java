package org.atras.ports.in;

import org.atras.data.User;

public interface DeleteUsersUseCase {

	User deleteUserById(Integer user);
}
