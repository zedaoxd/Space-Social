package api.space.controllers;

import api.space.dtos.UserInsertDTO;
import api.space.services.UserService;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import api.space.dtos.UserDTO;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Page<UserDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(userService.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<UserDTO> save(@RequestBody UserInsertDTO dto) {
        UserDTO userDto = userService.save(dto);
        URI uri = URI.create("/users/" + userDto.getId());
        return ResponseEntity.created(uri).body(userDto);
    }

}
