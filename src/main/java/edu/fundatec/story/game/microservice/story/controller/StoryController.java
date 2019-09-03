package edu.fundatec.story.game.microservice.story.controller;

import edu.fundatec.story.game.microservice.story.domain.Story;
import edu.fundatec.story.game.microservice.story.dto.StoryDto;
import edu.fundatec.story.game.microservice.story.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1/stories")
public class StoryController {

    private StoryService storyService;

    @Autowired
    public StoryController(StoryService storyService) {
        this.storyService = storyService;
    }

    @PostMapping
    public ResponseEntity saveStory(@RequestBody StoryDto storyDto) {
        storyService.saveNewStory(storyDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{creatorId}")
    public ResponseEntity<List<Story>> getStoriesByCreatorId(@PathVariable String creatorId) {
        List<Story> stories = storyService.findStoriesByCreatorId(creatorId);
        return new ResponseEntity<>(stories, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Story>> getStoriesByName(@RequestParam String name, @RequestParam int page) {
        List<Story> stories = storyService.findStoriesByName(name, page);
        return new ResponseEntity<>(stories, HttpStatus.OK);
    }

    @PostMapping("/{id}/acts/{act}")
    public ResponseEntity addAct(@PathVariable String id, @PathVariable String act) {
        storyService.addAct(id, act);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}/acts/{act}")
    public ResponseEntity removeAct(@PathVariable String id, @PathVariable String act) {
        storyService.removeAct(id, act);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateName(@PathVariable String id, @RequestBody String name) {
        storyService.updateName(id, name);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateDescription(@PathVariable String id, @RequestBody String description) {
        storyService.updateDescription(id, description);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStory(@PathVariable String id) {
        storyService.deleteStory(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
