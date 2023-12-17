package persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import persistence.model.PermissionDao;

@Repository
public interface PermissionDBRepository extends JpaRepository<PermissionDao, Integer> {
}
