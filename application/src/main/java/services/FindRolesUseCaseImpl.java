package services;

import java.util.List;
import ports.in.FindRolesUseCase;
import ports.out.RoleRepository;

public class FindRolesUseCaseImpl implements FindRolesUseCase{

	private RoleRepository dataService;

	public FindRolesUseCaseImpl(RoleRepository dataService) {
		this.dataService = dataService;
	}

	@Override
	public List<String> findRoles() {
		return dataService.findRoles();
	}
	
	@Override
	public String findRolesById(Integer roleId) {
		return dataService.findRolesById(roleId);
	}
}
