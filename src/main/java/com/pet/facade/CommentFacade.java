package com.pet.facade;


import com.pet.dto.CommentDTO;
import com.pet.model.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentFacade {

    public CommentDTO commentToCommentDTO(Comment comment) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setUsername(comment.getUsername());
        commentDTO.setText(comment.getText());

        return commentDTO;
    }

}