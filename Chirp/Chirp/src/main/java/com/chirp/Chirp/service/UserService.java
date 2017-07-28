package com.chirp.Chirp.service;

import java.sql.Timestamp;
import java.util.List;

import com.chirp.Chirp.dto.CredentialsDto;
import com.chirp.Chirp.dto.ProfileDto;
import com.chirp.Chirp.dto.UserDto;
import com.chirp.Chirp.entity.Follow;
import com.chirp.Chirp.entity.Users;
import com.chirp.Chirp.mapstruct.UserMapper;
import com.chirp.Chirp.repository.FollowRepository;
import com.chirp.Chirp.repository.UserRepository;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	private UserRepository userRepository;
	private UserMapper userMapper;
	private FollowRepository followRepo;

	public UserService(UserRepository userRepository, UserMapper userMapper, FollowRepository followRepo) {
		this.userRepository = userRepository;
		this.userMapper = userMapper;
		this.followRepo = followRepo;
	}

	public List<UserDto> getAllActive() {
		List<Users> results = userRepository.getByActiveTrue();
		return results.stream().map(userMapper::toDto).collect(Collectors.toList());
	}
	
	public boolean register(CredentialsDto creds, ProfileDto profile) {
		Users old = userRepository.getByActiveFalseAndUsernameAndPassword(creds.getUsername(), creds.getPassword());
		if (userRepository.getByActiveFalseAndUsernameAndPassword(creds.getUsername(), creds.getPassword()) != null) {
			old.setActive(true);
			userRepository.save(old);
			return true;			
		} else if (userRepository.findByUsername(creds.getUsername()) != null) {
			return false;
		} else {
			Long timestamp = System.currentTimeMillis();
			Users newbles = userMapper.fromDto(creds, profile);
			newbles.setJoined(timestamp);
			newbles.setActive(true);
			userRepository.save(newbles);
			return true;
		}
	}

	public UserDto findByUser(String username) {
		return userMapper.toDto(userRepository.findByUsername(username));
	}

	public void modProfile(String username, CredentialsDto creds, ProfileDto profile) {
		if (userRepository.getByActiveTrueAndUsernameAndPassword(username, creds.getPassword()) != null) {
			userRepository.save(userRepository.getByActiveTrueAndUsernameAndPassword(username, creds.getPassword()));
		}
	}
	
	public void hideProfile(String username, CredentialsDto creds) {
		Users user = userRepository.findByUsername(username);
		if (user.getPassword() == creds.getPassword() && user.getUsername() == creds.getUsername()) {
			user.setActive(false);
			userRepository.save(user);
		}
	}
	
	public void trail(String username, CredentialsDto creds) {
		Users user = userRepository.getByActiveTrueAndUsername(username);
		Users userBuddy = userRepository.getByActiveTrueAndUsernameAndPassword(creds.getUsername(), creds.getPassword());
		Long timestamp = System.currentTimeMillis();
		Follow follow = new Follow();
		follow.setTime(timestamp);
		follow.setIsFollowing(true);
		follow.setFollows(user.getId());
		follow.setFollowedBy(userBuddy.getId());
		followRepo.save(follow);
	}
	
	public void untrail(String username, CredentialsDto creds) {
		Users user = userRepository.getByActiveTrueAndUsername(username);
		Users userBuddy = userRepository.getByActiveTrueAndUsernameAndPassword(creds.getUsername(), creds.getPassword());
		Long timestamp = System.currentTimeMillis();
		Follow follow = new Follow();
		follow.setTime(timestamp);
		follow.setIsFollowing(true);
		follow.setFollows(user.getId());
		follow.setFollowedBy(userBuddy.getId());
		followRepo.save(follow);
	}
}
