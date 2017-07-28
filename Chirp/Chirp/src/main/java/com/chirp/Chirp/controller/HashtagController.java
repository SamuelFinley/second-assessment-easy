package com.chirp.Chirp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chirp.Chirp.entity.Hashtag;
import com.chirp.Chirp.service.HashtagService;

@RestController
@RequestMapping("tags")
public class HashtagController {
	
	private HashtagService tagService;

	public HashtagController(HashtagService tagService) {
		this.tagService = tagService;
	}
	
//	@GetMapping
//	public List<Hashtag> getAllTags() {
//		return tagService.getAllHashes();
//	}
}
