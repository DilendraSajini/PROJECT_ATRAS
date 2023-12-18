package org.atras.ports.out;

import java.util.List;

import org.atras.data.Role;

public interface RoleRepository {

	List<String> findRoles();

	String findRolesById(Integer roleId);

	org.atras.data.Role saveRole(Role role);
}
