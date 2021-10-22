package com.pet.dto;

import com.pet.annotation.ValidVideoURL;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
public class PostDTO {

    private Long id;
    @NotEmpty
    private String title;
    @Max(6)
    @Min(0)
    private Integer map;
    @NotEmpty
    private String start_pos;
    private String destination_pos;
    private Boolean isPetrikFishka;
    @NotEmpty
    @ValidVideoURL
    private String videoUrl;
    private String username;
    private Integer likes;
    @Max(3)
    @Min(0)
    private Integer type;

    private Set<String> usersLiked;

}
