package com.chirp.Chirp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chirp.Chirp.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{
	public List<Users> getByActiveTrue();
	public Users getByActiveFalseAndUsernameAndPassword(String username, String password);
	public Users getByActiveTrueAndUsernameAndPassword(String username, String password);
	public Users getByActiveTrueAndUsername(String username);
	public Users findByUsername(String username);
	public Users findByActiveTrueAndUsername(String username);
}
