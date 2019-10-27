package com.example.mrwang.managevaccine.entity;

public class Share {
    private int image ;
    private String name = null;

    public Share( String name,int image) {
        this.image = image;
        this.name = name;
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
}
