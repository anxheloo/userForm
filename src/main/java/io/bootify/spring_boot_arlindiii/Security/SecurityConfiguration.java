package io.bootify.spring_boot_arlindiii.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {


    @Bean
    public UserDetailsService userDetailsService() {
        System.out.println("We are inside userDetailsService in security");
        return new CustomUserDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        System.out.println("We are inside PasswordEncoder in security");
        return new BCryptPasswordEncoder();
    }


//    @Bean
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//
//        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
//    }


//    Responisble for authentication
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        //It keeps information about authentication Manager
//        System.out.println("We are inside AuthenticationManager in security");
        return authenticationConfiguration.getAuthenticationManager();
    }

    //Responsible for user details and encoding passwords
    @Bean
    public AuthenticationProvider authenticationProvider()
    {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
//        System.out.println("We are inside AuthenticationProvider in security");
        return authProvider;
    }



        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

            http.authorizeHttpRequests()
                    .requestMatchers("/registration/**","/login").permitAll()
                    .requestMatchers("/users/**").hasRole("Admin")
                    .requestMatchers("/forms/**").hasAnyRole("User","Admin")
                    .anyRequest()
                    .authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/login")
                    .and()
                    .logout().logoutSuccessUrl("/login").permitAll()
                    .and().exceptionHandling().accessDeniedPage("/access-denied");

            return http.build();

        }



}
