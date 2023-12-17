package ports.out;

import java.util.List;

import data.Role;

public interface RoleRepository {

	List<String> findRoles();

	String findRolesById(Integer roleId);

	data.Role saveRole(Role role);
}
