package com.teniscol.shoestore.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Inventario {
    private Map<String, Integer> stock;
    private List<Compra> compras;

    public Inventario() {
        stock = new LinkedHashMap<>();
        stock.put("Nike", 23);
        stock.put("Adidas", 45);
        stock.put("Puma", 30);
        compras = new ArrayList<>();
    }

    public Map<String, Integer> getStock() {
        return stock;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public String obtenerMarca(int op) {
        switch (op) {
            case 1: return "Nike";
            case 2: return "Adidas";
            case 3: return "Puma";
            default: return null;
        }
    }

    public boolean verificarStock(String marca, int cantidad) {
        return stock.containsKey(marca) && stock.get(marca) >= cantidad;
    }

    public void vender(String marca, int cantidad, int talla) {
        stock.put(marca, stock.get(marca) - cantidad);
        compras.add(new Compra(marca, talla, cantidad));
    }

    public int totalTenis() {
        int total = 0;
        for (int cantidad : stock.values()) {
            total += cantidad;
        }
        return total;
    }
}
