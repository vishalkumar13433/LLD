package org.lld.models;

public class User {
    private int id;
    private String name;
    private String email;

    private String imageURL;


    public User(int id, String name, String email, String imageURL) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.imageURL = imageURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
