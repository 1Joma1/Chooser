package com.geektech.chooser;

import java.io.Serializable;

public class Task implements Serializable {
    public int id;
    public String title;
    public String description;

    public Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
}
