package com.example.shapecalculator.model;

public class BangunModel {
    String img;
    String nama;

    public BangunModel(String nama, String img) {
        this.img = img;
        this.nama = nama;
    }

    public String getImg() {
        return img;
    }

    public String getNama() {
        return nama;
    }
}
