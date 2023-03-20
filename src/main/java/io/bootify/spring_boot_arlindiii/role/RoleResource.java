package io.bootify.spring_boot_arlindiii.role;

import jakarta.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/roles", produces = MediaType.APPLICATION_JSON_VALUE)
public class RoleResource {

    @Autowired
    private RoleService roleService;


    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok(roleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRole(@PathVariable final Long id) {
        return ResponseEntity.ok(roleService.get(id));
    }

//    @PostMapping
//    public ResponseEntity<Long> createRole(@RequestBody @Valid final Role role) {
//        return new ResponseEntity<>(roleService.create(role), HttpStatus.CREATED);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRole(@PathVariable final Long id,
            @RequestBody @Valid  Role role) {
        roleService.update(id, role);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable final Long id) {
        roleService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
