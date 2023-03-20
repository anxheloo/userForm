package io.bootify.spring_boot_arlindiii.role;

import io.bootify.spring_boot_arlindiii.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface RoleRepository extends JpaRepository<Role,Long> {

    @Query("select r from Role r where r.name=?1")
    public Role findByName(String name);

    public boolean existsByNameIgnoreCase(String name);
}
