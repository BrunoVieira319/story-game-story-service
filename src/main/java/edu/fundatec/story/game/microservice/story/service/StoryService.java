package edu.fundatec.story.game.microservice.story.service;

import edu.fundatec.story.game.microservice.story.domain.Story;
import edu.fundatec.story.game.microservice.story.dto.StoryDto;
import edu.fundatec.story.game.microservice.story.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoryService {

    private StoryRepository storyRepository;

    @Autowired
    public StoryService(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    public void saveNewStory(StoryDto dto) {
        Story story = new Story(dto.getTitle(), dto.getCreatorId(), dto.getCover(), dto.getDescription());
        storyRepository.save(story);
    }

    public List<Story> findMostPopularStories(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return storyRepository.findAll(pageable).getContent();
    }

    public List<Story> findStoriesByCreatorId(String creatorId) {
        return storyRepository.findAllByCreatorId(creatorId);
    }

    public List<Story> findStoriesByName(String name, int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return storyRepository.findAllByTitleContains(name, pageable);
    }

    public void addAct(String id, String act) {
        Optional<Story> optionalStory = storyRepository.findById(id);
        Story story = optionalStory.orElseThrow(() -> new IllegalArgumentException("Story not found"));
        story.addAct(act);
        storyRepository.save(story);
    }

    public void removeAct(String id, String act) {
        Optional<Story> optionalStory = storyRepository.findById(id);
        Story story = optionalStory.orElseThrow(() -> new IllegalArgumentException("Story not found"));
        story.removeAct(act);
        storyRepository.save(story);
    }

    public void updateName(String id, String name) {
        Optional<Story> optionalStory = storyRepository.findById(id);
        Story story = optionalStory.orElseThrow(() -> new IllegalArgumentException("Story not found"));
        story.setTitle(name);
        storyRepository.save(story);
    }

    public void updateDescription(String id, String description) {
        Optional<Story> optionalStory = storyRepository.findById(id);
        Story story = optionalStory.orElseThrow(() -> new IllegalArgumentException("Story not found"));
        story.setDescription(description);
        storyRepository.save(story);
    }

    public void deleteStory(String id) {
        storyRepository.deleteById(id);
    }
}
