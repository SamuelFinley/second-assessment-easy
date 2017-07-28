package com.chirp.Chirp.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chirp.Chirp.dto.ComboDto;
import com.chirp.Chirp.dto.CredentialsDto;
import com.chirp.Chirp.dto.ProfileDto;
import com.chirp.Chirp.dto.UserDto;
import com.chirp.Chirp.service.UserService;

@RestController
@RequestMapping("users")
public class UsersController {
	
	private UserService userService;

	public UsersController(UserService userService) {
		this.userService = userService;
	}
	
	//doin chair stuff
	@GetMapping
	public List<UserDto> getAllUsers() {
		return userService.getAllActive();
	}
	//str1.toLowerCase().contains(str2.toLowerCase())

	@PostMapping
	public void createAccount(@RequestBody ComboDto comboDto, HttpServletResponse response) {
			
		if(userService.register(comboDto.getCredentialsDto(), comboDto.getProfileDto()))
			response.setStatus(HttpServletResponse.SC_CREATED);
		else
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	}
	
	@GetMapping("@{username}")
	public UserDto getUser(@PathVariable String username) {
		return userService.findByUser(username);
	}
	
	@PatchMapping("@{username}")
	public void updateProfile(@PathVariable String username, @RequestBody ComboDto comboDto) {
		userService.modProfile(username, comboDto.getCredentialsDto(), comboDto.getProfileDto());
	}
	
	@DeleteMapping("@{username}")
	public void deleteProfile(@PathVariable String username, CredentialsDto creds) {
		userService.hideProfile(username, creds);
	}
	
	@PostMapping("@{username}/follow")
	public void follow(@PathVariable String username, CredentialsDto creds) {
		userService.trail(username, creds);
	}
	
	@PostMapping("@{username}/unfollow")
	public void unfollow(@PathVariable String username, CredentialsDto creds) {
		userService.untrail(username, creds);
	}
	
}
