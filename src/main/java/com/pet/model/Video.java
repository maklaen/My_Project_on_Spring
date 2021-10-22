package com.pet.model;

import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, updatable = false)
    private String videoUrl;
    @JsonIgnore
    private Long userId;
    @JsonIgnore
    private Long postId;

    public Video() {
    }


}
