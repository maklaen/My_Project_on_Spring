package com.pet.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CommentDTO {

    private Long id;
    @NotEmpty
    private String text;
    private String username;

}
