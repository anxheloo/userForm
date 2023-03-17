package io.bootify.spring_boot_arlindiii.user;

import io.bootify.spring_boot_arlindiii.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmailIgnoreCase(String email);

    User findFirstByRoles(String rolename);

    @Query("Select u from User u where u.email=?1")
    User findByEmail(String email);

}
