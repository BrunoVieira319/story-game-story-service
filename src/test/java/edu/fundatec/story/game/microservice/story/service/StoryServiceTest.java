package edu.fundatec.story.game.microservice.story.service;

import edu.fundatec.story.game.microservice.story.repository.StoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class StoryServiceTest {

    @MockBean
    private StoryRepository storyRepository;

    private StoryService storyService;

    @Autowired
    @Before
    public void setup(StoryService storyService) {
        this.storyService = storyService;
    }

    @Test
    public void shouldSaveStory() {

    }

}
