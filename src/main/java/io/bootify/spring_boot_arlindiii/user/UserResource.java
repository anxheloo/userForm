//package io.bootify.spring_boot_arlindiii.user;
//
//import jakarta.validation.Valid;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
//public class UserResource {
//
//    @Autowired
//    private UserService userService;
//
//
//
//    @GetMapping
//    public ResponseEntity<List<User>> getAllUsers() {
//        return ResponseEntity.ok(userService.findAll());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUser(@PathVariable final Long id) {
//        return ResponseEntity.ok(userService.get(id));
//    }
//
////    @PostMapping
////    public ResponseEntity<User> createUser(@RequestBody @Valid final User user) {
////        return new ResponseEntity<User>(userService.saveUserWithDefaultRole(user), HttpStatus.CREATED);
////    }
//
//
//
////    @PutMapping("/{id}")
////    public ResponseEntity<Void> updateUser(@PathVariable final Long id,
////            @RequestBody @Valid final User user) {
////        userService.update(id, user);
////        return ResponseEntity.ok().build();
////    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable final Long id) throws Exception {
//        userService.delete(id);
//        return ResponseEntity.noContent().build();
//    }
//
//}
