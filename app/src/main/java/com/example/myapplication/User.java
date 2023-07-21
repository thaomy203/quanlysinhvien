package com.example.myapplication;

public class User {
    private int image;
    private String name;
    private String id;
    private String date;
    private String className;

    public User(int image, String name, String id, String date, String className) {
        this.image = image;
        this.name = name;
        this.id = id;
        this.date = date;
        this.className = className;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
