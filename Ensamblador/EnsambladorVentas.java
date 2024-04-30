package Ensamblador;

import java.time.LocalDate;
import java.util.List;

//subclase ensamblador :D
public class EnsambladorVentas extends Ensamblador {

    public EnsambladorVentas(List<ClienteVentas> clientes, List<Libros> libros, List<Archivos> archivos, List<Venta> ventas) {
        super(clientes, libros, archivos);
    }

    public static void add(Venta ventas) {
    }

    public static Venta agregarVenta(LocalDate fechaVenta,List<Libros> librosVendidos , List<ClienteVentas> clientes) {
        return new Venta();
    }

    public static Venta BuscarVentaPorCliente(List<Venta> Ventas, List<ClienteVentas> Clientes) {
        return null;
    }

    public static Venta BuscarVentasPorLibro(List<Libros> libros) {
        System.out.println("Que libro quieres consultar?");
        return null;
    }

    public static String TotalVentas(List<Venta> Ventas) {
        double TotalVentas = 0.0;
        for (Venta ventas : Ventas) {
            TotalVentas += Venta.calcularTotal();
        }
        String V ="El total de las ventas es: " + TotalVentas;
        return V;
    }
}
