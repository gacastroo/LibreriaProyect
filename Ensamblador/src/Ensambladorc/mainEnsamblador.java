package Ensamblador.Ensambladorc;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import Ensamblador.Archivos.Archivos;
import Ensamblador.Clientess.Cliente;
import Ensamblador.Ensambladorc.Ensamblador;
import Ensamblador.Ensambladorc.EnsambladorReportes;
import Ensamblador.Librosc.Libros;
import Ensamblador.Ventass.Ventas;


import static Ensamblador.Ensambladorc.Ensamblador.*;

public class mainEnsamblador {

        public static void main(String[] args) {
            // Crear algunos datos de prueba
            List<Cliente> clientes = new ArrayList<>();
            List<Libros> libros = new ArrayList<>();
            List<Archivos> archivos = new ArrayList<>();
            List<Ventas> ventas = new ArrayList<>();

            // Agregar clientes
            clientes.add(new Cliente("Juan", "Calle Principal 123", "juan@example.com", "123456789", LocalDate.of(2022, 5, 17)));
            clientes.add(new Cliente("María", "Avenida Central 456", "maria@example.com", "987654321", LocalDate.of(2022, 5, 18)));

            // Agregar libros
            libros.add(new Libros("El Quijote", "Miguel de Cervantes", "Novela", 20.0));
            libros.add(new Libros("Cien años de soledad", "Gabriel García Márquez", "Realismo mágico", 25.0));

            // Agregar ventas
            LinkedList<Libros> librosVendidos = new LinkedList<>();
            librosVendidos.add(libros.get(0));
            librosVendidos.add(libros.get(1));
            ventas.add(new Ventas(LocalDate.of(2022, 5, 17), librosVendidos, clientes.get(0)));

            // Crear un objeto EnsambladorReportes
            EnsambladorReportes ensambladorReportes = new EnsambladorReportes(clientes, libros, archivos, ventas);

            // Generar informes
            System.out.println("Reporte de Clientes:");
            System.out.println(ensambladorReportes.generarReporteClientes());

            System.out.println("Reporte de Libros:");
            System.out.println(ensambladorReportes.generarReporteLibros());

            System.out.println("Reporte de Ventas:");
            System.out.println(ensambladorReportes.generarReporteVentas());
        }
    }

