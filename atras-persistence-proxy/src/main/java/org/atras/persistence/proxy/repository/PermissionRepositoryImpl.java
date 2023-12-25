package org.atras.persistence.proxy.repository;

import java.util.Optional;

import org.atras.permissions.ports.out.PermissionRepository;
import org.atras.persistence.repository.PermissionDBRepository;
import org.atras.persistence.exception.RoleNotFoundException;
import org.atras.persistence.model.PermissionDao;
import org.springframework.beans.factory.annotation.Autowired;

public class PermissionRepositoryImpl implements PermissionRepository{

	@Autowired
	private PermissionDBRepository permissionDBRepository;
	
	@Override
	public String findPermissions(Integer permissionId) {
		Optional<PermissionDao> permissionDao = permissionDBRepository.findById(permissionId);
		PermissionDao permissionDaoSaved;
		if (permissionDao.isPresent()) {
			permissionDaoSaved = permissionDao.orElse(null);
		} else {
			throw new RoleNotFoundException("Permission not found, for id: " + permissionId);
		}
		return permissionDaoSaved.getPermissionLevel();
	}
	
	protected PermissionDao findPermissionsById(Integer permissionId) {
		Optional<PermissionDao> permissionDao = permissionDBRepository.findById(permissionId);
		PermissionDao permissionDaoSaved;
		if (permissionDao.isPresent()) {
			permissionDaoSaved = permissionDao.orElse(null);
		} else {
			throw new RoleNotFoundException("Permission not found, for id: " + permissionId);
		}
		return permissionDaoSaved;
	}
}
