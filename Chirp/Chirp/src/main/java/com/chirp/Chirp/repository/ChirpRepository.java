package com.chirp.Chirp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chirp.Chirp.entity.Chirp;

public interface ChirpRepository extends JpaRepository<Chirp, Integer>{
	public List<Chirp> findByVisibleTrue();
//	public Chirp getByVisibleTrueAndUsernameAndPassword(String username, String password);
	public Chirp findByVisibleAndId(Integer id);
}
