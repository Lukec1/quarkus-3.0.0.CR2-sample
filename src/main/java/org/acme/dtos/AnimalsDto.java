package org.acme.dtos;

import java.util.List;
import org.acme.model.Cat;
import org.acme.model.Dog;
import org.acme.model.Dolphin;
import org.acme.model.Rat;

public class AnimalsDto {
    private List<Dog> dogs;
    private List<Cat> cats;
    private List<Rat> rats;
    private List<Dolphin> dolphins;

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

    public List<Cat> getCats() {
        return cats;
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }

    public List<Rat> getRats() {
        return rats;
    }

    public void setRats(List<Rat> rats) {
        this.rats = rats;
    }

    public List<Dolphin> getDolphins() {
        return dolphins;
    }

    public void setDolphins(List<Dolphin> dolphins) {
        this.dolphins = dolphins;
    }
}
