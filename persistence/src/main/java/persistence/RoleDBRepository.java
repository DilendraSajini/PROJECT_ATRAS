package persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import persistence.model.RoleDao;

@Repository
public interface RoleDBRepository extends JpaRepository<RoleDao, Integer> {
	  Optional<RoleDao> getByRole(String role);
}
