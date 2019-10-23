package com.car.microdemo.model;


public class Car {
    private int id;
    private String nom;
    private int price;

  public Car(){}

    public Car(int id, String nom, int price) {
        this.id = id;
        this.nom = nom;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", price=" + price +
                '}';
    }
}

