package com.example.resttest.controllers;


import com.example.resttest.models.MyUser;
import com.example.resttest.service.impl.MyUserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/v1")
@RestController
@Tag(name = "MyRestController", description = "Добавляем, обновляем, удаляем и просматриваем пользователей")
public class MyRestController {
    private final MyUserServiceImpl userService;
    @Autowired
    public MyRestController(MyUserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Показать всех пользователей")
    public ResponseEntity<?> showAll() {
        return userService.showAll();
    }

    @GetMapping( value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Показать одного пользователя по Id")
    public ResponseEntity<?> showOneById(@PathVariable long id) {
        return userService.showOneUser(id);
    }

    @PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Добавить нового пользователя")
    public ResponseEntity<?> addNewUser(@RequestBody MyUser myUser) {
     return userService.create(myUser);
    }

    @PutMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Изменить данные существующего пользователя")
    public ResponseEntity<?> updateUser(@RequestBody MyUser myUser) {
      return  userService.update(myUser);
    }

    @DeleteMapping (value ="/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Удалить пользователя")
    public void deleteUser(@PathVariable long id) {
        userService.delete(id);
    }
}
