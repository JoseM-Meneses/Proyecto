package com.teniscol.shoestore.services;

public class Compra {

    private int id;
    private String marca;
    private String modelo;
    private int talla;
    private int cantidad;
    private String fecha;

    public Compra() {
    }

    public Compra(int id, String marca, String modelo, int talla, int cantidad, String fecha) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.talla = talla;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
