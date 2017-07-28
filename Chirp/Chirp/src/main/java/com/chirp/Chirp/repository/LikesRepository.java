package com.chirp.Chirp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chirp.Chirp.entity.Likes;

public interface LikesRepository extends JpaRepository<Likes, Integer>{

}
