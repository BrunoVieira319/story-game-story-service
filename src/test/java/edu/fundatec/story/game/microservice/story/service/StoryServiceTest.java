package edu.fundatec.story.game.microservice.story.service;

import edu.fundatec.story.game.microservice.story.domain.Story;
import edu.fundatec.story.game.microservice.story.dto.StoryDto;
import edu.fundatec.story.game.microservice.story.repository.StoryRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class StoryServiceTest {

    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private StoryService storyService;

//    @Autowired
//    @Before
//    public void setup(StoryService storyService, StoryRepository storyRepository) {
//        this.storyService = storyService;
//        this.storyRepository = storyRepository;
//    }

    @After
    public void dropDatabase() {
        storyRepository.deleteAll();
    }

    @Test
    public void shouldSaveStory() {
        StoryDto storyDto = createStoryDto();
        storyService.saveNewStory(storyDto);

        assertEquals(1, storyRepository.count());
    }

    @Test
    public void shouldFindStoriesByCreatorId() {
        populateDatabase();
        List<Story> stories = storyService.findStoriesByCreatorId("123456");
        assertEquals(10, stories.size());
    }

    @Test
    public void shouldFindStoriesByName() {
        populateDatabase();
        List<Story> storiesByName = storyService.findStoriesByName("My Story", 0);
        assertEquals(10, storiesByName.size());
    }

    private StoryDto createStoryDto() {
        StoryDto storyDto = new StoryDto();
        storyDto.setName("My Story");
        storyDto.setCreatorId("123456");
        storyDto.setDescription("A description");
        return storyDto;
    }

    private void populateDatabase() {
        IntStream.range(0, 10).forEach(i -> {
            storyRepository.save(new Story("My Story", "123456", "A description"));
        });
    }

}
