package io.bootify.spring_boot_arlindiii.user;//package io.bootify.spring_boot_arlindiii.user;

import io.bootify.spring_boot_arlindiii.form_model.FormModel;
import io.bootify.spring_boot_arlindiii.form_model.FormModelRepository;
import io.bootify.spring_boot_arlindiii.role.Role;
import io.bootify.spring_boot_arlindiii.role.RoleRepository;
import io.bootify.spring_boot_arlindiii.util.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    FormModelRepository formModelRepository;



    public List<User> findAll() {
        List<User> users = userRepository.findAll(Sort.by("id"));
        return users;
    }



    public void saveUserWithDefaultRole(User user)
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        Role roleUser = roleRepository.findByName("User");

        user.addRoles(roleUser);

        if(user.getId()==null)
//        if(userRepository.findById(user.getId()).get() == null)
        {
            user.setDateCreated(OffsetDateTime.now());
        }
        user.setLastUpdated(OffsetDateTime.now());

        userRepository.save(user);
    }



    public void saveUser(User user)
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        if(user.getId()==null)
//        if(userRepository.findById(user.getId()).get() == null)
        {
            user.setDateCreated(OffsetDateTime.now());
        }
        user.setLastUpdated(OffsetDateTime.now());
        userRepository.save(user);

    }


    public User get(Long id)
    {
        return userRepository.findById(id).orElseThrow(NotFoundException::new);
    }


    public List<Role> getRoles()
    {
        return roleRepository.findAll();
    }

    public void delete(Long id) throws Exception {
        User user = userRepository.findById(id).get();

        try {
            if (user.getRoles().stream().anyMatch(role -> role.getName().equals("Admin") || role.getName().equals("admin") || role.getName().equals("ROLE_Admin") )) {
                throw new IllegalArgumentException("You cannot delete an admin user.");

            } else {

                userRepository.deleteById(id);
            }

        } catch (Exception e)
        {
            System.out.println("\"You cannot delete an admin user.\"");
        }

    }





}

