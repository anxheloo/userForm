package io.bootify.spring_boot_arlindiii;

import io.bootify.spring_boot_arlindiii.form_model.FormModel;
import io.bootify.spring_boot_arlindiii.form_model.FormModelRepository;
import io.bootify.spring_boot_arlindiii.role.Role;
import io.bootify.spring_boot_arlindiii.role.RoleRepository;
import io.bootify.spring_boot_arlindiii.role.RoleService;
import io.bootify.spring_boot_arlindiii.user.User;
import io.bootify.spring_boot_arlindiii.user.UserRepository;
import io.bootify.spring_boot_arlindiii.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.OffsetDateTime;
import java.util.Arrays;


@EnableWebSecurity
@SpringBootApplication
public class SpringBootArlindiiiApplication implements CommandLineRunner {


    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;


    @Autowired
    FormModelRepository formModelRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    public static void main(final String[] args) {
        SpringApplication.run(SpringBootArlindiiiApplication.class, args);}


        @Override
        public void run (String...args) throws Exception {

        System.out.println("WE ARE INSIDE run METHOD in SPRINGAPPLICATION CREATING ROLES AND USERS JUST FOR START");


//            Create Roles to test  the app
		Role role1 = new Role("User");
        role1.setDateCreated(OffsetDateTime.now());
		roleRepository.save(role1);

		Role role2 = new Role("Admin");
        role2.setDateCreated(OffsetDateTime.now());
		roleRepository.save(role2);


//            FormModel form1 = new FormModel("Whats your day?","How was your day","What is the day?","How many days?");
//            form1.setDateCreated(OffsetDateTime.now());
//            formModelRepository.save(form1);
//
//            FormModel form2 = new FormModel("Whats your day?","How was your day","What is the day?","How many days?");
//            form2.setDateCreated(OffsetDateTime.now());
//            formModelRepository.save(form2);


//            Create Admin role to test the app
		User admin = new User("Nixhi","Nixhi","nixhi@gmail.com", passwordEncoder.encode("nixhi123"));
        admin.setDateCreated(OffsetDateTime.now());
        admin.setRoles(Arrays.asList(role2));
		userRepository.save(admin);

		User user = new User("Noel","Ceno","noel@gmail.com", passwordEncoder.encode("noel123"));
        user.setDateCreated(OffsetDateTime.now());
        user.setRoles(Arrays.asList(role1));
//        user.addForms(form1);
//        user.addForms(form2);
		userRepository.save(user);


        FormModel form1 = new FormModel("Whats your day?","How was your day","What is the day?","How many days?");
        form1.setDateCreated(OffsetDateTime.now());
        form1.setLastUpdated(OffsetDateTime.now());
        form1.setUser(user);
        formModelRepository.save(form1);

        FormModel form2 = new FormModel("Whats your day?","How was your day","What is the day?","How many days?");
        form2.setDateCreated(OffsetDateTime.now());
        form2.setLastUpdated(OffsetDateTime.now());
        formModelRepository.save(form2);



        }

}
