package edu.fundatec.story.game.microservice.story.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StoryTest {

    private Story story;

    @Before
    public void setup () {
        story = new Story("The Fairy Tale", "123456789", "Any description");
    }

    @Test
    public void shouldCreateStory() {
        assertEquals("The Fairy Tale", story.getName());
        assertEquals("123456789", story.getCreatorId());
        assertEquals("Any description", story.getDescription());
        assertEquals(0, story.getActs().size());
    }

    @Test
    public void shouldAddActOnStory() {
        story.addAct("123456");
        assertEquals(1, story.getActs().size());
        assertEquals("123456", story.getActs().get(0));
    }

    @Test
    public void shouldRemoveActOnStory() {
        story.addAct("123456");
        assertEquals(1, story.getActs().size());

        story.removeAct("123456");
        assertEquals(0, story.getActs().size());
    }
}
