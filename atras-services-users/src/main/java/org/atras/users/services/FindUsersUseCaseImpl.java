package org.atras.users.services;

import java.util.List;

import org.atras.core.data.User;
import org.atras.users.ports.in.FindUsersUseCase;
import org.atras.users.ports.out.UserRepository;

public class FindUsersUseCaseImpl implements FindUsersUseCase {

	private UserRepository dataService;

	public FindUsersUseCaseImpl(UserRepository dataService) {
		this.dataService = dataService;
		// here calls UserRepositoryFactory.getUserRepository("Special")
		//need to check bean context object hence factory method use new.
	}

	@Override
	public List<User> findUsers() {
		return dataService.findUsers();
	}

	@Override
	public User findUsersById(Integer userId) {
		return dataService.findUsersById(userId);
	}
}
