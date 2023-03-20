package io.bootify.spring_boot_arlindiii.Controller;

import io.bootify.spring_boot_arlindiii.user.User;
import io.bootify.spring_boot_arlindiii.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    //handler method to handle the list of students and return model and view
    @GetMapping
    public String listOfStudents(Model model)
    {
        model.addAttribute("users",userService.findAll());
        return "users";
    }


    @GetMapping("/new")
    public String createUserForm(Model model)
    {
        //create user object to hold user form data
        User user = new User();
        model.addAttribute("user",user);
        return "create_user";

    }

    @PostMapping
    public String saveUser(@ModelAttribute("user") User user)
    {
        userService.saveUserWithDefaultRole(user);
        return "redirect:/users";
    }


    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable Long id,Model model)
    {
        model.addAttribute("user",userService.get(id));
        return "edit_user";
    }


    @PostMapping("/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("user") User user,Model model)
    {
<<<<<<< HEAD
        //get user from database by id
=======
        //get student from database by id
>>>>>>> fb96a41cbe1c5dda5939dfa6b1aa1f5cb1c7fbe9
        User existingUser = userService.get(id);
        existingUser.setId(id);
        existingUser.setFirstname(user.getFirstname());
        existingUser.setLastname(user.getLastname());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());

        //save updated student object
        userService.saveUser(existingUser);

        return "redirect:/users";
    }



    @GetMapping("/{id}")
    public String deleteUser(@PathVariable Long id) throws Exception {
        userService.delete(id);
        return "redirect:/users";
    }

}
