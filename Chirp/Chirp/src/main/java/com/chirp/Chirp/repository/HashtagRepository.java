package com.chirp.Chirp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chirp.Chirp.entity.Hashtag;

public interface HashtagRepository extends JpaRepository<Hashtag, Integer> {
	public List<Hashtag> findById(Integer id);
	public List<Integer> findByLabel(String label);
	public Hashtag findOneByLabel(String label);
	public Hashtag findOneById(Integer id);
}
