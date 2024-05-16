package Ensamblador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//subclase ensamblador :D
public class EnsambladorVentas extends Ensamblador {

    public EnsambladorVentas(List<Cliente> clientes, List<Libros> libros, List<Archivos> archivos, List<Ventas> ventas) {
        super(clientes, libros, archivos, ventas);
    }

    public void add(Ventas ventas) {
        this.ventas.add(ventas);
    }

    public static Ventas agregarVenta(Scanner sc, LocalDate fechaVenta, List<Libros> librosVendidos, Cliente clientes) {
        return new Ventas(sc, fechaVenta, librosVendidos, clientes);
    }

    public static String BuscarVentaPorCliente(List<Ventas> ventas, List<Cliente> clientes) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Qué cliente quieres buscar?");
        String nombreCliente = scanner.nextLine().trim();

        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombreCliente)) {
                StringBuilder resultado = new StringBuilder("\nVentas para el cliente " + nombreCliente + ":");
                boolean ventasEncontradas = false;
                for (Ventas venta : ventas) {
                    if (venta.getCliente().equals(cliente)) {
                        resultado.append("\n").append(venta); // Suponiendo que la clase Ventas tiene un método toString() adecuado
                        ventasEncontradas = true;
                    }
                }
                if (ventasEncontradas) {
                    return resultado.toString();
                } else {
                    return "No se encontraron ventas para el cliente " + nombreCliente;
                }
            }
        }
        return "El cliente " + nombreCliente + " no está registrado";
    }
        public static Ventas BuscarVentasPorLibro(List<Libros> libros, List<Ventas> ventas) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("¿Qué libro quieres consultar?");
            String nombreLibro = scanner.nextLine().trim();

            for (Libros libro : libros) {
                if (libro.getTitulo().equalsIgnoreCase(nombreLibro)) {
                    System.out.println("\nVentas para el libro \"" + nombreLibro + "\":");
                    for (Ventas venta : ventas) {
                        if (venta.getLibrosVendidos().equals(libro)) {
                            return venta;
                        }
                    }
                    return null; // No se encontraron ventas para el libro
                }
            }
            return null; // El libro no está registrado
        }


        public static String TotalVentas (List < Ventas > Ventas) {
            double TotalVentas = 0.0;
            for (Ventas venta : Ventas) {
                TotalVentas += venta.calcularTotal();
            }
            String V = "El total de las ventas es: " + TotalVentas;
            return V;
        }
    }
