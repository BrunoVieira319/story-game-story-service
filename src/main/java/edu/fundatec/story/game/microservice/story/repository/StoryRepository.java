package edu.fundatec.story.game.microservice.story.repository;

import edu.fundatec.story.game.microservice.story.domain.Story;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StoryRepository extends MongoRepository<Story, String> {

    List<Story> findAllByCreatorId(String creatorId);
    List<Story> findAllByNameContains(String name, Pageable pageable);
}
