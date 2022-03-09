package com.codegym.model;

public class Part {
    protected int id;
    protected int storyID;
    protected int episode;
    protected String name;

    public Part() {
    }

    public Part(int id, int storyID, int episode, String name) {
        this.id = id;
        this.storyID = storyID;
        this.episode = episode;
        this.name = name;
    }

    public Part(int storyID, int episode, String name) {
        this.storyID = storyID;
        this.episode = episode;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStoryID() {
        return storyID;
    }

    public void setStoryID(int storyID) {
        this.storyID = storyID;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
