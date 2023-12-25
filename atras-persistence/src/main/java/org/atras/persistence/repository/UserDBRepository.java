package org.atras.persistence.repository;

import org.atras.persistence.model.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDBRepository extends JpaRepository<UserDao, Integer> {

}
