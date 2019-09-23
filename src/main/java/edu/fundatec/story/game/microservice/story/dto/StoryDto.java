package edu.fundatec.story.game.microservice.story.dto;

import lombok.Data;

@Data
public class StoryDto {

    private String title;
    private String creatorId;
    private String cover;
    private String description;
}
