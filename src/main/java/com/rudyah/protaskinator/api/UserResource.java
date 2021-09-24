package com.rudyah.protaskinator.api;

import com.rudyah.protaskinator.domain.AppUser;
import com.rudyah.protaskinator.domain.Role;
import com.rudyah.protaskinator.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserResource {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getUsers(@RequestParam(value = "p", required = false) Integer pageNum,
                                                  @RequestParam(value = "size", required = false) Integer pageSize){
        if(pageNum == null) pageNum = 0;
        if(pageSize == null) pageSize = 12;
        return ResponseEntity.ok().body(userService.getUsers(pageNum, pageSize).getContent());
    }

    @PostMapping("/user/save")
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user){
        String uriString = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString();
        URI uri = URI.create(uriString);
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        String uriString = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString();
        URI uri = URI.create(uriString);
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addToUser(@RequestBody RoleToUserForm form){
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

}

@Data
class RoleToUserForm {
    private String username;
    private String roleName;
}
