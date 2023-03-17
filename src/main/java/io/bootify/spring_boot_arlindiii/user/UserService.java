package io.bootify.spring_boot_arlindiii.user;//package io.bootify.spring_boot_arlindiii.user;
//
//import io.bootify.spring_boot_arlindiii.form_model.FormModel;
//import io.bootify.spring_boot_arlindiii.form_model.FormModelRepository;
//import io.bootify.spring_boot_arlindiii.role.Role;
//import io.bootify.spring_boot_arlindiii.role.RoleRepository;
//import io.bootify.spring_boot_arlindiii.util.NotFoundException;
//import io.bootify.spring_boot_arlindiii.util.WebUtils;
//import jakarta.transaction.Transactional;
//import java.util.Collections;
//import java.util.List;
//import java.util.stream.Collectors;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//
//@Transactional
//@Service
//public class UserService {
//
//    private final UserRepository userRepository;
//    private final RoleRepository roleRepository;
//    private final FormModelRepository formModelRepository;
//
//    public UserService(final UserRepository userRepository, final RoleRepository roleRepository,
//            final FormModelRepository formModelRepository) {
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//        this.formModelRepository = formModelRepository;
//    }
//
//    public List<UserDTO> findAll() {
//        final List<User> users = userRepository.findAll(Sort.by("id"));
//        return users.stream()
//                .map((user) -> mapToDTO(user, new UserDTO()))
//                .toList();
//    }
//
//    public UserDTO get(final Long id) {
//        return userRepository.findById(id)
//                .map(user -> mapToDTO(user, new UserDTO()))
//                .orElseThrow(NotFoundException::new);
//    }
//
//    public Long create(final UserDTO userDTO) {
//        final User user = new User();
//        mapToEntity(userDTO, user);
//        return userRepository.save(user).getId();
//    }
//
//    public void update(final Long id, final UserDTO userDTO) {
//        final User user = userRepository.findById(id)
//                .orElseThrow(NotFoundException::new);
//        mapToEntity(userDTO, user);
//        userRepository.save(user);
//    }
//
//    public void delete(final Long id) {
//        userRepository.deleteById(id);
//    }
//
//    private UserDTO mapToDTO(final User user, final UserDTO userDTO) {
//        userDTO.setId(user.getId());
//        userDTO.setFirstname(user.getFirstname());
//        userDTO.setLastname(user.getLastname());
//        userDTO.setEmail(user.getEmail());
//        userDTO.setPassword(user.getPassword());
//        userDTO.setRoles(user.getRoles() == null ? null : user.getRoles().stream()
//                .map(role -> role.getId())
//                .toList());
//        return userDTO;
//    }
//
//    private User mapToEntity(final UserDTO userDTO, final User user) {
//        user.setFirstname(userDTO.getFirstname());
//        user.setLastname(userDTO.getLastname());
//        user.setEmail(userDTO.getEmail());
//        user.setPassword(userDTO.getPassword());
//        final List<Role> roles = roleRepository.findAllById(
//                userDTO.getRoles() == null ? Collections.emptyList() : userDTO.getRoles());
//        if (roles.size() != (userDTO.getRoles() == null ? 0 : userDTO.getRoles().size())) {
//            throw new NotFoundException("one of roles not found");
//        }
//        user.setRoles(roles.stream().collect(Collectors.toSet()));
//        return user;
//    }
//
//    public boolean emailExists(final String email) {
//        return userRepository.existsByEmailIgnoreCase(email);
//    }
//
//    public String getReferencedWarning(final Long id) {
//        final User user = userRepository.findById(id)
//                .orElseThrow(NotFoundException::new);
//        final FormModel userFormModel = formModelRepository.findFirstByUser(user);
//        if (userFormModel != null) {
//            return WebUtils.getMessage("user.formModel.user.referenced", userFormModel.getId());
//        }
//        return null;
//    }
//
//}

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
//        FormModel model = formModelRepository.findFirstByUser(user);

        if (user == null)
        {
            throw new NotFoundException("User with id: " + id +" not found!");
        }

        try {
            if (user.getRoles().stream().anyMatch(role -> role.getName().equals("Admin") || role.getName().equals("admin") || role.getName().equals("ROLE_Admin") )) {
                throw new IllegalArgumentException("You cannot delete an admin user.");

            } else {
//                formModelRepository.delete(model);
                userRepository.delete(user);
//                userRepository.deleteById(id);
            }

        } catch (Exception e)
        {
            System.out.println("\"You cannot delete an admin user.\"");
        }

    }





}

