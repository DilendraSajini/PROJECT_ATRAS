package org.atras.roles.ports.out;

import java.util.List;

import org.atras.core.data.Role;

public interface RoleRepository {

	List<String> findRoles();

	String findRolesById(Integer roleId);

	Role saveRole(Role role);

}
