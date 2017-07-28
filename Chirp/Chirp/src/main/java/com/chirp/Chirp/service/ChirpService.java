package com.chirp.Chirp.service;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.chirp.Chirp.dto.CredentialsDto;
import com.chirp.Chirp.dto.GeneralChirpDto;
import com.chirp.Chirp.dto.ReplyDto;
import com.chirp.Chirp.dto.RepostDto;
import com.chirp.Chirp.dto.SimpleChirpDto;
import com.chirp.Chirp.dto.SimpleDto;
import com.chirp.Chirp.dto.UserDto;
import com.chirp.Chirp.entity.Chirp;
import com.chirp.Chirp.entity.Hashtag;
import com.chirp.Chirp.entity.InReplyTo;
import com.chirp.Chirp.entity.Likes;
import com.chirp.Chirp.entity.RepostOf;
import com.chirp.Chirp.entity.Users;
import com.chirp.Chirp.mapstruct.ChirpMapper;
import com.chirp.Chirp.mapstruct.UserMapper;
import com.chirp.Chirp.repository.ChirpRepository;
import com.chirp.Chirp.repository.HashtagRepository;
import com.chirp.Chirp.repository.LikesRepository;
import com.chirp.Chirp.repository.ReplyRepository;
import com.chirp.Chirp.repository.RepostRepository;
import com.chirp.Chirp.repository.UserRepository;

public class ChirpService {
	private HashtagRepository tagRepo;
	private RepostRepository repostRepo;
	private ReplyRepository replyRepo;
	private LikesRepository likesRepo;
	private UserRepository userRepo;
	private UserMapper userMapper;
	private ChirpRepository chirpRepo;
	private ChirpMapper chirpMapper;

	public ChirpService(HashtagRepository tagRepo, RepostRepository repostRepo, ReplyRepository replyRepo, LikesRepository likesRepo, ChirpRepository chirpRepo, ChirpMapper chirpMapper, UserRepository userRepo, UserMapper userMapper) {
		this.userRepo = userRepo;
		this.tagRepo = tagRepo;
		this.repostRepo = repostRepo;
		this.replyRepo = replyRepo;
		this.userMapper = userMapper;
		this.chirpRepo = chirpRepo;
		this.chirpMapper = chirpMapper;
		this.likesRepo = likesRepo;
	}

	public boolean checkCreds(CredentialsDto creds) {
		if (userRepo.getByActiveTrueAndUsernameAndPassword(creds.getUsername(), creds.getPassword()) == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean ChirpExists(Integer id) {
		if (chirpRepo.findByVisibleAndId(id) == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean deleteCheck(Integer id, CredentialsDto creds) {
		String name =chirpRepo.findByVisibleAndId(id).getAuthor().getUsername();
		if (chirpRepo.findByVisibleAndId(id) == null || name != creds.getUsername() || userRepo.findByActiveTrueAndUsername(name).getPassword() != creds.getPassword()) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean checkContents(SimpleDto simpleDto) {
		if (simpleDto.getContent() == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Set<String> tagChecker(String content) {
		Set<String> tags = new HashSet<String>();
		if (content.contains("#")) {
		String[] toCheck = content.split(" ");
		for (String x : toCheck) {
			if (x.contains("#")) {
				tags.add(x);
			}
		}
		}
		return tags;
	}
	
	public List<GeneralChirpDto> getAllVisible() {
		List<Chirp> results = chirpRepo.getByVisibleTrue();
		return results.stream().map(chirpMapper::toGeneralChirpDto).collect(Collectors.toList());
	}
	
	public void chirping(SimpleDto simpleDto) {	
		Set<String> tags = tagChecker(simpleDto.getContent());
		String username = simpleDto.getCredentialsDto().getUsername();
		String password = simpleDto.getCredentialsDto().getPassword();
		Users user = userRepo.getByActiveTrueAndUsernameAndPassword(username, password);
		UserDto userDto = userMapper.toDto(user);
		Long timestamp = System.currentTimeMillis();
		SimpleChirpDto littleChirp = new SimpleChirpDto(userDto, timestamp, simpleDto.getContent(), true);
		Chirp chirp = chirpMapper.fromSimpleDto(littleChirp);
		for (String label : tags) {
			Hashtag tag = new Hashtag(label, timestamp, chirp.getId());
			tag.setLabel(label);
			tag.setTweet(chirp.getId());
			tag.setTimestamp(timestamp);
			tagRepo.save(tag);
		}
		chirpRepo.save(chirp);
	}
	
	public GeneralChirpDto findChirpById(Integer id) {
		return chirpMapper.toGeneralChirpDto(chirpRepo.findByVisibleAndId(id));
	}

	public void deleteChirp(Integer id, CredentialsDto creds) {
		Chirp noMore = chirpRepo.findByVisibleAndId(id);
		noMore.setVisible(false);
		chirpRepo.save(noMore);
	}

	public void likes(Integer id, CredentialsDto creds) {
		String username = creds.getUsername();
		String password = creds.getPassword();
		//Chirp chirps = chirpRepo.findByVisibleAndId(id);
		Users user = userRepo.getByActiveTrueAndUsernameAndPassword(username, password);
		Likes like = new Likes(user.getId(), id);
		likesRepo.save(like);
	}

	public void replyTo(Integer id, SimpleDto simpleDto) {
		String username = simpleDto.getCredentialsDto().getUsername();
		String password = simpleDto.getCredentialsDto().getPassword();
		Users user = userRepo.getByActiveTrueAndUsernameAndPassword(username, password);
		UserDto userDto = userMapper.toDto(user);
		Chirp first = chirpRepo.findByVisibleAndId(id);
		Long timestamp = System.currentTimeMillis();
		ReplyDto reply = new ReplyDto(userDto, timestamp, simpleDto.getContent(), chirpMapper.toGeneralChirpDto(first));
		Chirp theReply = chirpMapper.fromReplyDto(reply);
		chirpRepo.save(theReply);
		InReplyTo replyRelation = new InReplyTo(id, theReply.getId());
		replyRepo.save(replyRelation);
	}

	public void repost(Integer id, CredentialsDto creds) {
		String username = creds.getUsername();
		String password = creds.getPassword();
		Users user = userRepo.getByActiveTrueAndUsernameAndPassword(username, password);
		UserDto userDto = userMapper.toDto(user);
		Chirp first = chirpRepo.findByVisibleAndId(id);
		Long timestamp = System.currentTimeMillis();
		RepostDto repost = new RepostDto(userDto, timestamp, chirpMapper.toGeneralChirpDto(first));
		Chirp theRepost = chirpMapper.fromRepostDto(repost);
		chirpRepo.save(theRepost);
		RepostOf repostRelation = new RepostOf(id, theRepost.getId());
		repostRepo.save(repostRelation);
	
	}

//	public List<Hashtag> findTags(Integer id) {
//		// TODO Auto-generated method stub
//		
//	}
	
	
}
