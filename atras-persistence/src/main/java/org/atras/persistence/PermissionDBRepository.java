package org.atras.persistence;

import org.atras.persistence.model.PermissionDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionDBRepository extends JpaRepository<PermissionDao, Integer> {
}
