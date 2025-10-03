
package com.admSystem.financialSystem.data;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

    public Optional<UserEntity> findByUsername(String username);

}
