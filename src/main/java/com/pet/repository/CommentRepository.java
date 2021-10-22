package com.pet.repository;

import com.pet.model.Comment;
import com.pet.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPost(Post post);

    Comment findByIdAndUserId(Long commentId, Long userId);
}