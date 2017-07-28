package com.chirp.Chirp.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.chirp.Chirp.dto.GeneralChirpDto;
import com.chirp.Chirp.entity.Chirp;
import com.chirp.Chirp.entity.Hashtag;
import com.chirp.Chirp.mapstruct.ChirpMapper;
import com.chirp.Chirp.mapstruct.UserMapper;
import com.chirp.Chirp.repository.ChirpRepository;
import com.chirp.Chirp.repository.HashtagRepository;
import com.chirp.Chirp.repository.LikesRepository;
import com.chirp.Chirp.repository.ReplyRepository;
import com.chirp.Chirp.repository.RepostRepository;
import com.chirp.Chirp.repository.UserRepository;

public class HashtagService {
	private ChirpMapper chirpMapper;
	private HashtagRepository tagRepo;

	public HashtagService(HashtagRepository tagRepo, RepostRepository repostRepo, ReplyRepository replyRepo, LikesRepository likesRepo, ChirpRepository chirpRepo, ChirpMapper chirpMapper, UserRepository userRepo, UserMapper userMapper) {
		this.tagRepo = tagRepo;
		this.chirpMapper = chirpMapper;
	}
	
//	public List<Hashtag> getAllHashes() {
//		List<Hashtag> results = tagRepo.findAll();
//		Long time
//		for (Hashtag tag : results) {
//			if (tag.)
//			tag.getLabel()
//		}
//		results.stream().map(chirpMapper::toGeneralChirpDto).collect(Collectors.toList())
//		if (tagRepo.findByLabel(label) == null) {
//			tag.setFirstUsed(timestamp);
//		} else {
//			Integer i = Collections.max(tagRepo.findByLabel(label));
//			tagRepo.findOneById(i).getTimestamp();
//			
//		}
//		return results.stream().map(chirpMapper::toGeneralChirpDto).collect(Collectors.toList());
}
