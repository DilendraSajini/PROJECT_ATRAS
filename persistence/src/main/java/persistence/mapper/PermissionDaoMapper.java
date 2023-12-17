package persistence.mapper;

import persistence.model.PermissionDao;
import data.User;

public class PermissionDaoMapper {

	public static PermissionDao mapPermissiontoPermissionDao(String permission) {
		PermissionDao roleDao = new PermissionDao.PermissionDaoBuilder().setPermissionLevel(permission).build();
		return roleDao;
	}
	
	public static User mapPermissionDaotoPermission(PermissionDao permissionDao) {
		return null;
	}

}
