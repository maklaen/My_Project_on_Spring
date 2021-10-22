package com.pet.service;

import com.pet.dto.PostDTO;
import com.pet.exception.PostNotFoundException;
import com.pet.model.Post;
import com.pet.model.User;
import com.pet.model.Video;
import com.pet.model.enums.Grenade_type;
import com.pet.model.enums.Maps;
import com.pet.repository.PostRepository;
import com.pet.repository.UserRepository;
import com.pet.repository.VideoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    public static final Logger LOG = LoggerFactory.getLogger(PostService.class);

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final VideoRepository videoRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository, VideoRepository videoRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.videoRepository = videoRepository;
    }


    public Post createPost(PostDTO postDTO, Principal principal) {
        User user = getUserByPrincipal(principal);
        Post post = new Post();
        post.setUser(user);
        post.setMap(Maps.values()[postDTO.getMap()].toString());
        post.setStart_pos(postDTO.getStart_pos());
        post.setDestination_pos(postDTO.getDestination_pos());
        post.setIsPetrikFishka(postDTO.getIsPetrikFishka());
        post.setTypeGrenade(Grenade_type.values()[postDTO.getType()].toString());
        post.setVideoUrl(postDTO.getVideoUrl());
        post.setTitle(postDTO.getTitle());
        post.setLikes(0);

        postRepository.save(post);
        LOG.info("Saving post {}", user.getEmail());
        return post;
    }

    public List<Post> getAllPostList() {
        return postRepository.findAll();
    }

    public Post getPostById(Long id, Principal principal) {
        User user = getUserByPrincipal(principal);
        return postRepository.findPostByIdAndUser(id, user)
                .orElseThrow(() -> new PostNotFoundException("Post cannot found for username: " + user.getUsername()));
    }

    public List<Post> getAllPostForUser(Principal principal) {
        User user = getUserByPrincipal(principal);
        return postRepository.findAllByUserOrderByCreatedDateDesc(user);
    }

    public Post likePost(Long postId, String username) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("Post not found "));
        Optional<String> userLiked = post.getLikedUsers()
                .stream()
                .filter(user -> user.equals(username)).findAny();

        if (userLiked.isPresent()) {
            post.setLikes(post.getLikes() - 1);
            post.getLikedUsers().remove(username);
        } else {
            post.setLikes(post.getLikes() + 1);
            post.getLikedUsers().add(username);
        }
        return postRepository.save(post);
    }

    public void deletePost(Long postId, Principal principal) {
        Post post = getPostById(postId, principal);
        Optional<Video> imageModel = videoRepository.findByPostId(post.getId());
        postRepository.delete(post);
        imageModel.ifPresent(videoRepository::delete);
    }

    private User getUserByPrincipal(Principal principal) {
        String username = principal.getName();
        return userRepository.findUsersByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found exception" + username));
    }

}
