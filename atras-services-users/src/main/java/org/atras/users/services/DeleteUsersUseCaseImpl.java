package org.atras.users.services;

import org.atras.core.data.User;
import org.atras.users.ports.in.DeleteUsersUseCase;
import org.atras.users.ports.out.UserRepository;

public class DeleteUsersUseCaseImpl implements DeleteUsersUseCase {

	private UserRepository dataService;
	
	public DeleteUsersUseCaseImpl(UserRepository dataService) {
		this.dataService = dataService;
	}
	
	@Override
	public User deleteUserById(Integer userId) {
		return dataService.deleteUserById(userId);
	}
}
