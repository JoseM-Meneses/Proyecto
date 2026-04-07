package com.teniscol.shoestore.model;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("");
        System.out.println("*****************************");
        System.out.println("****    BIENVENIDO A     ****");
        System.out.println("****    TenisCol Shop    ****");
        System.out.println("*****************************");
        System.out.println();

        System.out.print("Por favor ingrese su nombre: ");
        String nombre = leer.nextLine();
        System.out.print("Por favor ingrese su apellido: ");
        String apellido = leer.nextLine();
        String nombreCompleto = nombre + " " + apellido;

        System.out.println("\n======================");
        System.out.println("Gracias por visitar TenisCol Shop, " + nombreCompleto);
        System.out.println("Te damos la bienvenida a nuestro menú");

        //Llama el método menu de la clase tienda
        Tienda tienda = new Tienda();
        tienda.menuPrincipal();

        leer.close();
    }
}
