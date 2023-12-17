package org.atras.services;

import org.atras.data.User;
import org.atras.ports.in.CreateUsersUseCase;
import org.atras.ports.out.UserRepository;

public class CreateUsersUseCaseImpl implements CreateUsersUseCase{

	private UserRepository dataService;
	
	// if there only one constructor no need to explicitly add @Autowire
	public CreateUsersUseCaseImpl(UserRepository dataService) {
		this.dataService = dataService;
	}

	@Override // if we performing multiple repository operations use @Transactional in service level
	public User saveUser(User user) {
		return dataService.saveUser(user);
	}

}
