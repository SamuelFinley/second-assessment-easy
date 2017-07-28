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
import org.springframework.web.bind.annotation.RestController;

import com.chirp.Chirp.dto.CredentialsDto;
import com.chirp.Chirp.dto.GeneralChirpDto;
import com.chirp.Chirp.dto.SimpleDto;
import com.chirp.Chirp.service.ChirpService;

@RestController
@RequestMapping("tweets")
public class ChirpController {
	
	private ChirpService chirpService;

	public ChirpController(ChirpService chirpService) {
		this.chirpService = chirpService;
	}
	
	//doin chair stuff
	@GetMapping
	public List<GeneralChirpDto> getAllChirps() {
		return chirpService.getAllVisible();
	}
	
	//super cool status code example
	@PostMapping
	public void makeChirp(@RequestBody SimpleDto simpleDto, HttpServletResponse response) {
		if(chirpService.checkCreds(simpleDto.getCredentialsDto())) {
			chirpService.chirping(simpleDto);
			response.setStatus(HttpServletResponse.SC_CREATED);
		} else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
	
	@GetMapping("@{id}")
	public GeneralChirpDto getChirp(@PathVariable Integer id, HttpServletResponse response) {
		if(chirpService.ChirpExists(id)) {
			response.setStatus(HttpServletResponse.SC_CREATED);
			return chirpService.findChirpById(id);
		} else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return chirpService.findChirpById(id);
		}
	}
	
	@DeleteMapping("@{id}")
	public void deleteProfile(@PathVariable Integer id, CredentialsDto creds, HttpServletResponse response) {
		if(chirpService.deleteCheck(id, creds)) {
			response.setStatus(HttpServletResponse.SC_CREATED);
			chirpService.deleteChirp(id, creds);
		} else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

		}
	}
	
	@PostMapping("@{id}/like")
	public void likeChirp(@PathVariable Integer id, @RequestBody CredentialsDto creds, HttpServletResponse response) {
		if(chirpService.deleteCheck(id, creds)) {
			response.setStatus(HttpServletResponse.SC_CREATED);
			chirpService.likes(id, creds);
		} else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
	
	@PostMapping("@{id}/reply")
	public void reply(@PathVariable Integer id, @RequestBody SimpleDto simpleDto, HttpServletResponse response) {
		if(chirpService.deleteCheck(id, simpleDto.getCredentialsDto())) {
			response.setStatus(HttpServletResponse.SC_CREATED);
			chirpService.replyTo(id, simpleDto);
		} else if(chirpService.checkContents(simpleDto)) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
	
	@PostMapping("@{id}/repost")
	public void reposting(@PathVariable Integer id, @RequestBody CredentialsDto creds, HttpServletResponse response) {
		chirpService.repost(id, creds);
	}
	
//	@GetMapping("@{id}/tags")
//	public void tags(@PathVariable Integer id, HttpServletResponse response) {
//		chirpService.findTags(id);
//	}
	
}
