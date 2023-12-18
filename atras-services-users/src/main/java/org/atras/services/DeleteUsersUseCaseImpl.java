package org.atras.services;

import org.atras.data.User;
import org.atras.ports.in.DeleteUsersUseCase;
import org.atras.ports.out.UserRepository;

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
