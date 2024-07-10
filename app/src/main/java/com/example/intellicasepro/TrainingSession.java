package com.example.intellicasepro;

public class TrainingSession {
    private String date;
    private String title;
    private String instructor;
    private String location;

    public TrainingSession(String date, String title, String instructor, String location) {
        this.date = date;
        this.title = title;
        this.instructor = instructor;
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getLocation() {
        return location;
    }
}
