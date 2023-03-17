package io.bootify.spring_boot_arlindiii.Security;

import io.bootify.spring_boot_arlindiii.user.User;
import io.bootify.spring_boot_arlindiii.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);
        if(user == null)
        {
            throw new UsernameNotFoundException("User Not Found!");
        }

//        System.out.println("We are inside Load User By UserName in CustomUserDetailsService printing userRepository.findByEmail(email) "+user);

        return new CustomUserDetails(user);
    }


//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Optional<User> user= userRepository.findByEmail(email);
//
//        user.orElseThrow(() -> new UsernameNotFoundException("Not found!"+ email));
//
//        return user.map(CustomUserDetails::new).get();
//
//
//    }


}
