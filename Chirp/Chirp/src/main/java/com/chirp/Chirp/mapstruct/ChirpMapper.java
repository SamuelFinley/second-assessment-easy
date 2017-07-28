package com.chirp.Chirp.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.chirp.Chirp.dto.GeneralChirpDto;
import com.chirp.Chirp.dto.ReplyDto;
import com.chirp.Chirp.dto.RepostDto;
import com.chirp.Chirp.dto.SimpleChirpDto;
import com.chirp.Chirp.dto.UserDto;
import com.chirp.Chirp.entity.Chirp;

@Mapper(componentModel = "spring")
public interface ChirpMapper {
	@Mappings({ 
		@Mapping(source = "userDto", target = "author"),
		@Mapping(source = "simpleChirp.posted", target = "posted"), 
		@Mapping(source = "simpleChirp.content", target = "content")
		})
	Chirp fromSimpleDto(SimpleChirpDto simpleChirp, UserDto userDto);
	
	@Mappings({ 
		@Mapping(source = "userDto", target = "author"),
		@Mapping(source = "repost.posted", target = "posted"), 
		@Mapping(source = "repost.repostOf", target = "repostOf")
		})
	Chirp fromRepostDto(RepostDto repost, UserDto userDto);
	
	@Mappings({ 
		@Mapping(source = "userDto", target = "author"),
		@Mapping(source = "reply.posted", target = "posted"), 
		@Mapping(source = "reply.content", target = "content"),
		@Mapping(source = "reply.replyTo", target = "reply")
		})
	Chirp fromReplyDto(ReplyDto reply, UserDto userDto);
	
	@Mappings({ 
		@Mapping(source = "author", target = "author"),
		@Mapping(source = "posted", target = "posted"), 
		@Mapping(source = "repostOf", target = "repostOf")
		})
	RepostDto toRepostDto(Chirp chirp);
	
	@Mappings({ 
		@Mapping(source = "author", target = "author"),
		@Mapping(source = "posted", target = "posted"), 
		@Mapping(source = "content", target = "content"),
		@Mapping(source = "repostOf", target = "repostOf"), 
		@Mapping(source = "reply", target = "reply")
		})
	GeneralChirpDto toGeneralChirpDto(Chirp chirp);
}


