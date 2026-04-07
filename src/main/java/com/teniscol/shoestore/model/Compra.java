package com.teniscol.shoestore.model;

public class Compra {
    private String marca;
    private int talla;
    private int cantidad;

    public Compra(String marca, int talla, int cantidad) {
        this.marca = marca;
        this.talla = talla;
        this.cantidad = cantidad;
    }

    public String getMarca() {
        return marca;
    }

    public int getTalla() {
        return talla;
    }

    public int getCantidad() {
        return cantidad;
    }
}
