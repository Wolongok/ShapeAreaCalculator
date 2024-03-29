package com.example.shapecalculator;

public class Perhitungan extends RumusPage{
    public double rumusPersegi(double sisi){
        return sisi * sisi;
    }
    public double rumusLingkaran(double jari){
        return jari*jari*22.0/7.0;
    }
    public double rumusSegitiga(double alas,double tinggi){
        return alas*tinggi/2;
    }
    public double rumusPersegiPanjang(double panjang,double lebar){
        return panjang*lebar;
    }
    public double rumusKubus(double rusuk){
        return rusuk*rusuk*6;
    }
    public double rumusKerucut(double jari,double tinggi){
        return 22.0/7.0*jari*(jari+(Math.sqrt(jari*jari+tinggi*tinggi)));
    }
    public double rumusTabung(double jari,double tinggi){
        return 22.0/7.0*jari*jari + jari * 22.0/7.0*tinggi;
    }
    public double rumusBola(double jari){
        return 4*22.0/7.0*jari*jari;
    }

}
