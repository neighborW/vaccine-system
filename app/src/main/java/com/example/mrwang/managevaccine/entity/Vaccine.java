package com.example.mrwang.managevaccine.entity;

public class Vaccine {

    private  int imageView = 0;
   private String name;
   private String function;
   private String objectVaccine;
   private String standard;
   private String taboo;
   private String untowardEffect;

    public Vaccine(int imageView, String name, String function) {
        this.imageView = imageView;
        this.name = name;
        this.function = function;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getObjectVaccine() {
        return objectVaccine;
    }

    public void setObjectVaccine(String objectVaccine) {
        this.objectVaccine = objectVaccine;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getTaboo() {
        return taboo;
    }

    public void setTaboo(String taboo) {
        this.taboo = taboo;
    }

    public String getUntowardEffect() {
        return untowardEffect;
    }

    public void setUntowardEffect(String untowardEffect) {
        this.untowardEffect = untowardEffect;
    }
}
