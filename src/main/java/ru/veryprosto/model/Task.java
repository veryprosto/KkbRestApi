package ru.veryprosto.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Task {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false)
    private String header; //заголовок

    @DatabaseField(canBeNull = false)
    private String shortDescription; //короткое описание

    @DatabaseField(canBeNull = false)
    private String description; //описание

    public Task() {
    }

    public Task(int id, String header, String shortDescription, String description) {
        this.id = id;
        this.header = header;
        this.shortDescription = shortDescription;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
