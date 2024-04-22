package com.blog.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blog.payloads.APIResponse;
import com.blog.payloads.UserDTO;
import com.blog.services.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	//POST -> create User
     @PostMapping("/")
     public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO){
    	 UserDTO createdUserDTO=this.userService.createUser(userDTO);
    	 return new ResponseEntity<>(createdUserDTO,HttpStatus.CREATED);
     }
     
     //PUT --> update User
     @PutMapping("/{userId}")
     public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO,@PathVariable Integer userId){
    	 UserDTO updatedUser=this.userService.updateUser(userDTO, userId);
    	 return ResponseEntity.ok(updatedUser);
     }
     
     //DELETE --> delete User
     @DeleteMapping("/{userId}")
     public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer userId){
    	 this.userService.deleteUser(userId);
    	 return new ResponseEntity<APIResponse>(new APIResponse("User deleted successfully",true),HttpStatus.OK);
     }
     
     //GET --> get All Users
     @GetMapping("/")
     public ResponseEntity<List<UserDTO>> getAllUsers(){
    	 return ResponseEntity.ok(this.userService.getAllUsers());
     }
     
     //GET --> get User
     @GetMapping("/{userId}")
     public ResponseEntity<UserDTO> getSingleUser(@PathVariable Integer userId){
    	return ResponseEntity.ok(this.userService.getUserById(userId));
     }
}

/*
 * @Valid annotation used to enable bean validations applied on DTO
 * */
