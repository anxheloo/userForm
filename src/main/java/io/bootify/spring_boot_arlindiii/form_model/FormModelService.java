package io.bootify.spring_boot_arlindiii.form_model;

import io.bootify.spring_boot_arlindiii.Security.CustomUserDetailsService;
import io.bootify.spring_boot_arlindiii.user.User;
import io.bootify.spring_boot_arlindiii.user.UserRepository;
import io.bootify.spring_boot_arlindiii.user.UserService;
import io.bootify.spring_boot_arlindiii.util.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.Optional;

@Service
public class FormModelService {


    @Autowired
    UserRepository userRepository;
    @Autowired
    FormModelRepository formModelRepository;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    public Iterable<FormModel> getAll() {
        return formModelRepository.findAll();
    }


    public Optional<FormModel> getById(Long id) {
        return formModelRepository.findById(id);
    }


    public FormModel save(FormModel formModel) {
        if (formModel.getId() == null) {
            formModel.setDateCreated(OffsetDateTime.now());
        }

        formModel.setLastUpdated(OffsetDateTime.now());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByEmail(auth.getName());

        formModel.setUser(user);
        return formModelRepository.save(formModel);
    }


    public void delete(FormModel formModel) {
        formModelRepository.delete(formModel);
    }

    public FormModel get(Long id)
    {
        return formModelRepository.findById(id).orElseThrow(NotFoundException::new);
    }
}
