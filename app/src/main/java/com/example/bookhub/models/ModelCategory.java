package com.example.bookhub.models;

public class ModelCategory {
    //make sure to use same spelling for model variables as in firebase

    String id, category, uid;
    long timestamp;

    //constructor empty required for firebase
    public ModelCategory() {

    }

    //parameterized constructor
    public ModelCategory(String id, String category, String uid, long timestamp) {
        this.id = id;
        this.category = category;
        this.uid = uid;
        this.timestamp = timestamp;
    }

    /*-----Getter/Setters-----*/
    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
