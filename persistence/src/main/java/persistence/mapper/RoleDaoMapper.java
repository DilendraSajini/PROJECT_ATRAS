package persistence.mapper;

import java.util.List;

import persistence.model.PermissionDao;
import persistence.model.RoleDao;
import data.Role;

public class RoleDaoMapper {

	public static RoleDao mapRoletoRoleDao(String role) {
		RoleDao roleDao = new RoleDao.RoleDaoBuilder().setRole(role).build();
		return roleDao;
	}

	public static RoleDao mapRoletoRoleDao(Role role,List<PermissionDao> permissions) {
		RoleDao roleDao = new RoleDao.RoleDaoBuilder().setRole(role.getRole()).setPermissions(permissions).build();
		return roleDao;
	}

	public static String mapRoleDaotoRole(RoleDao roleDao) {
		return roleDao.getRole();
	}

}
