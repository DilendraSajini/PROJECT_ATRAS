package org.atras.persistence.repository;

import java.util.Optional;

import org.atras.persistence.model.RoleDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDBRepository extends JpaRepository<RoleDao, Integer> {
	  Optional<RoleDao> getByRole(String role);
}
