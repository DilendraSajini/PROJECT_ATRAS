package persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import persistence.model.UserDao;

@Repository
public interface UserDBRepository extends JpaRepository<UserDao, Integer> {

}
