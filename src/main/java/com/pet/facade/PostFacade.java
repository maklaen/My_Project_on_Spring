package com.pet.facade;


import com.pet.dto.PostDTO;
import com.pet.model.Post;
import com.pet.model.enums.Grenade_type;
import com.pet.model.enums.Maps;
import org.springframework.stereotype.Component;

@Component
public class PostFacade {

    public PostDTO postToPostDTO(Post post) {
        PostDTO postDTO = new PostDTO();
        postDTO.setUsername(post.getUser().getUsername());
        postDTO.setId(post.getId());
        postDTO.setMap(Maps.valueOf(post.getMap()).ordinal());
        postDTO.setStart_pos(post.getStart_pos());
        postDTO.setDestination_pos(post.getDestination_pos());
        postDTO.setType(Grenade_type.valueOf(post.getTypeGrenade()).ordinal());
        postDTO.setIsPetrikFishka(post.getIsPetrikFishka());
        postDTO.setVideoUrl(post.getVideoUrl());
        postDTO.setLikes(post.getLikes());
        postDTO.setTitle(post.getTitle());
        postDTO.setUsersLiked(post.getLikedUsers());

        return postDTO;
    }
}
