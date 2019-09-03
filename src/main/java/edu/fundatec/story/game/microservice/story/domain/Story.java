package edu.fundatec.story.game.microservice.story.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Document
public class Story {

    @Id
    private String id;

    @Setter
    @NotNull
    private String name;

    @NotNull
    private String creatorId;

    @Setter
    private String description;

    private List<String> acts;

    public Story(String name, String creatorId, String description) {
        this.name = name;
        this.creatorId = creatorId;
        this.description = description;
        this.acts = new ArrayList<>();
    }

    public List<String> getActs() {
        return Collections.unmodifiableList(acts);
    }

    public void addAct(String act) {
        acts.add(act);
    }

    public void removeAct(String act) {
        acts.remove(act);
    }
}
