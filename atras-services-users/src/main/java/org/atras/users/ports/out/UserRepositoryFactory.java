package org.atras.users.ports.out;

public interface UserRepositoryFactory {

	UserRepository getUserRepository(String name);
}
