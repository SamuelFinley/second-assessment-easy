package com.chirp.Chirp.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.chirp.Chirp.dto.CredentialsDto;
import com.chirp.Chirp.dto.ProfileDto;
import com.chirp.Chirp.dto.UserDto;
import com.chirp.Chirp.entity.Users;

@Mapper(componentModel = "spring")
public interface UserMapper {
	@Mappings({ 
		@Mapping(source = "credentials.username", target = "username"),
		@Mapping(source = "credentials.password", target = "password"), 
		@Mapping(source = "profile.firstName", target = "profile.firstName"),
		@Mapping(source = "profile.lastName", target = "profile.lastName"),
		@Mapping(source = "profile.email", target = "profile.email"),
		@Mapping(source = "profile.phone", target = "profile.phone")
		})
	Users fromDto(CredentialsDto credentials, ProfileDto profile);
	
	//UserAbrv abrvFromDto(CredentialsDto credentials, ProfileDto profile);
	
	@Mappings({ 
		@Mapping(source = "username", target = "username"),
		@Mapping(source = "profile", target = "profile"), 
		@Mapping(source = "joined", target = "joined")
		})
	UserDto toDto(Users user);
}
