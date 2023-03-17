package io.bootify.spring_boot_arlindiii.Controller;

import io.bootify.spring_boot_arlindiii.Security.CustomUserDetailsService;
import io.bootify.spring_boot_arlindiii.user.User;
import io.bootify.spring_boot_arlindiii.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Controller
public class MainController {

    @Autowired
    UserService userService;


    @Autowired
    CustomUserDetailsService customUserDetailsService;


    @GetMapping("/login")
    public String login() {
        System.out.println("1-Step -> We are inside GetMapping(/login)");
        return "login";
    }


    @GetMapping("/")
    public String home() {
        return "index";
    }


    @GetMapping("/registration")
    public String showRegistrationForm(Model model)
    {
        User user = new User();
        model.addAttribute("user",user);
        System.out.println("2-Step -> We are inside GetMapping /registration printing Model model");
        System.out.println("3-Step -> We are inside GetMapping /registration printing User user");
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("user") User user) {
        userService.saveUserWithDefaultRole(user);
        System.out.print("9-Step -> We are printing user object inside PostMapping /registration " + user);
        return "redirect:/registration?success";
    }

    @GetMapping("/access-denied")
    public String showAccessDeniedPage()
    {
        return "access-denied";
    }



}
