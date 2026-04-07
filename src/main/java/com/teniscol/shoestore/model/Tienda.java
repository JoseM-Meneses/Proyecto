package com.teniscol.shoestore.model;

import java.util.Map;
import java.util.Scanner;

public class Tienda {
    private Inventario inventario;
    private Scanner leer;

    public Tienda() {
        inventario = new Inventario();
        leer = new Scanner(System.in);
    }

    //Clase menu con bucle para mostrar constantemente el menu para que el cliente elija varias veces hasta que decida salir
    public void menuPrincipal() {
        int op;

        do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            op = leerEntero();

            switch (op) {
                case 1:
                    mostrarInventario();
                    break;
                case 2:
                    comprarTenis();
                    break;
                case 3:
                    salirMenu();
                    break;
                default:
                    System.out.println("Opción no válida, regresa al menú.");
            }
        } while (op != 3);
    }

    private void mostrarMenu() {
        System.out.println();
        System.out.println("======================");
        System.out.println("1. Conocer cuántos tenis hay disponibles");
        System.out.println("2. Comprar tenis");
        System.out.println("3. Realizar compras y salir del programa");
    }

    // Recorre el mapa del inventario y muestra cada marca con su cantidad
    private void mostrarInventario() {
        System.out.println("\n-----------------------------------------");
        System.out.println("Actualmente contamos con:");
        for (Map.Entry<String, Integer> entry : inventario.getStock().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("En total tenemos: " + inventario.totalTenis() + " tenis");
        System.out.println("-----------------------------------------");
    }

    private void comprarTenis() {
        System.out.println("\n--------------------------------------------");
        System.out.println("¿Qué tenis deseas comprar?");
        System.out.println("1: Nike\n2: Adidas\n3: Puma");
        System.out.print("Elige una opción: ");
        int opc = leerEntero();

        String marca = inventario.obtenerMarca(opc);
        if (marca == null) {
            System.out.println("Opción no válida, regresa al menú.");
            return;
        }

        System.out.print("¿Qué talla eres? (35-43): ");
        int talla = leerEntero();
        if (talla < 35 || talla > 43) {
            System.out.println("Lo sentimos, pero no tenemos tenis de esa talla.");
            return;
        }

        System.out.print("¿Cuántos tenis deseas comprar?: ");
        int cantidad = leerEntero();

        if (!inventario.verificarStock(marca, cantidad)) {
            System.out.println("No hay suficiente stock de " + marca + ". Solo hay " + inventario.getStock().get(marca) + " disponibles.");
            return;
        }

        inventario.vender(marca, cantidad, talla);
        System.out.println("\nHas agregado: " + cantidad + " tenis " + marca + " de talla " + talla);
        System.out.println("---------------------------------------------");
    }

    private void salirMenu() {
        System.out.println("\n==========================");
        System.out.println("Saliendo del programa...");
        System.out.println("\nCompras realizadas:");
        for (Compra compra : inventario.getCompras()) {
            System.out.println(compra.getCantidad() + " tenis " + compra.getMarca() + " de talla " + compra.getTalla());
        }
        System.out.println("Total de tenis restantes: " + inventario.totalTenis());
        System.out.println("\nHasta luego, vuelva pronto.");
        System.out.println("");
    }

    private int leerEntero() {
        while (!leer.hasNextInt()) {
            System.out.println("Por favor ingrese un número válido.");
            leer.next();
        }
        return leer.nextInt();
    }
}
