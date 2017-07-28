package com.chirp.Chirp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chirp.Chirp.entity.InReplyTo;


public interface ReplyRepository extends JpaRepository<InReplyTo, Integer>{

}
