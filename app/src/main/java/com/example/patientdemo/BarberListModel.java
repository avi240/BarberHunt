package com.example.patientdemo;

public class BarberListModel {

    String dr_name, exp, price, degree, place, img;

    BarberListModel() {

    }
    public BarberListModel(String dr_name, String exp, String price, String degree, String place, String img) {
        this.dr_name = dr_name;
        this.exp = exp;
        this.price = price;
        this.degree = degree;
        this.place = place;
        this.img = img;
    }

    public String getDr_name() {
        return dr_name;
    }

    public String getExp() {
        return exp;
    }

    public String getPrice() {
        return price;
    }

    public String getDegree() {
        return degree;
    }

    public String getPlace() {
        return place;
    }

    public String getImg() {
        return img;
    }
}
