package io.bootify.spring_boot_arlindiii.role;

import io.bootify.spring_boot_arlindiii.user.UserRepository;
import io.bootify.spring_boot_arlindiii.util.NotFoundException;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class RoleService {

    @Autowired
    private  RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;



    public List<Role> findAll() {
        List<Role> roles = roleRepository.findAll(Sort.by("id"));
        return roles;
    }

    public Role get(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }


    public void update(Long id, @Valid Role role) {

//         Role role = new Role();
         role = roleRepository.findById(id)
                .orElseThrow(NotFoundException::new);

        if(role.getId()==null)
//        if(userRepository.findById(user.getId()).get() == null)
        {
            role.setDateCreated(OffsetDateTime.now());
        }

        role.setLastUpdated(OffsetDateTime.now());

        roleRepository.save(role);
    }

    public void delete(final Long id) {

        if (roleRepository.findById(id).get() == null)
        {
            throw new NotFoundException("Role with id: " + id + " not found!");
        }

        roleRepository.deleteById(id);
    }


    public boolean nameExists(final String name) {
        return roleRepository.existsByNameIgnoreCase(name);
    }


//    public void create(Role role) {
//
//    }

}
