package services;

import data.User;
import ports.in.DeleteUsersUseCase;
import ports.out.UserRepository;

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
