package org.atras.roles.services;

import java.util.List;

import org.atras.roles.ports.in.FindRolesUseCase;
import org.atras.roles.ports.out.RoleRepository;

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
