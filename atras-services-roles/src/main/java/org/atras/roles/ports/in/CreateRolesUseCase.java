package org.atras.roles.ports.in;

import org.atras.core.data.Role;

public interface CreateRolesUseCase {
	Role saveRole(Role role);
}
