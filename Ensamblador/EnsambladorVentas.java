package Ensamblador;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


//subclase ensamblador :D
public class EnsambladorVentas extends Ensamblador {

    public EnsambladorVentas(List<Cliente> clientes, List<Libros> libros, List<Archivos> archivos, List<Ventas> ventas) {
        super(clientes, libros, archivos);
    }

    public static void add(Ventas ventas) {

    }

    public static Ventas agregarVenta(Scanner sc, LocalDate fechaVenta, List<Libros> librosVendidos , Cliente clientes) {
        return new Ventas(sc,fechaVenta,librosVendidos,clientes);
    }

    public static Ventas BuscarVentaPorCliente(List<Ventas> Ventas, List<Cliente> Clientes) {
        return null;
    }

    public static Ventas BuscarVentasPorLibro(List<Libros> libros) {
        System.out.println("Que libro quieres consultar?");
        return null;
    }

    public static String TotalVentas(List<Ventas> Ventas) {
        double TotalVentas = 0.0;
        for (Ventas venta : Ventas) {
            TotalVentas += venta.calcularTotal();
        }
        String V ="El total de las ventas es: " + TotalVentas;
        return V;
    }
}
