package org.atras.services;

import org.atras.data.Role;
import org.atras.ports.in.CreateRolesUseCase;
import org.atras.ports.out.RoleRepository;

public class CreateRolesUseCaseImpl implements CreateRolesUseCase{

	private RoleRepository dataService;
	
	// if there only one constructor no need to explicitly add @Autowire
	public CreateRolesUseCaseImpl(RoleRepository dataService) {
		this.dataService = dataService;
	}

	@Override
	public Role saveRole(Role role) {
		return dataService.saveRole(role);
	}

}
