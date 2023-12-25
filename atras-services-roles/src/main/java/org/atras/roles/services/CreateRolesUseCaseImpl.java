package org.atras.roles.services;

import org.atras.core.data.Role;
import org.atras.roles.ports.in.CreateRolesUseCase;
import org.atras.roles.ports.out.RoleRepository;

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
