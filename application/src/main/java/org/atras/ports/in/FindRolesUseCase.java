package org.atras.ports.in;

import java.util.List;

public interface FindRolesUseCase {

	List<String> findRoles();

	String findRolesById(Integer roleId);

}
