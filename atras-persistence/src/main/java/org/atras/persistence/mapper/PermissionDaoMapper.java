package org.atras.persistence.mapper;

import org.atras.core.data.User;
import org.atras.persistence.model.PermissionDao;

public class PermissionDaoMapper {

	public static PermissionDao mapPermissiontoPermissionDao(String permission) {
		PermissionDao roleDao = new PermissionDao.PermissionDaoBuilder().setPermissionLevel(permission).build();
		return roleDao;
	}
	
	public static User mapPermissionDaotoPermission(PermissionDao permissionDao) {
		return null;
	}

}
