package Ensamblador;

import java.time.LocalDate;
import java.util.List;

//subclase ensamblador :D
public class EnsambladorVentas extends Ensamblador{
    private List<Ventas> ventas;

    public EnsambladorVentas(List<Cliente> clientes, List<Libros> libros, List<Archivos> archivos, List<Ventas> ventas) {
        super(clientes, libros, archivos);
        this.ventas = ventas;
    }

    public static void add(Ventas ventas){
    }

    public static Ventas agregarVenta(LocalDate fechaVenta, List<Libros> librosVendidos, List<Cliente> clientes) {
        return new Ventas(fechaVenta, librosVendidos, clientes);
    }

    public static Ventas BuscarVentaPorCliente(List<Ventas>Ventas,List<Cliente>Clientes){
        return null;
    }

    public static Ventas BuscarVentasPorLibro(List<Libros> libros){
      System.out.println("Que libro quieres consultar?");
      return null;
    }

    public static Ventas TotalVentas(List<Ventas>Ventas){
            double TotalVentas=0.0;
            for (Ventas ventas:Ventas){
                TotalVentas+=Ventas.get(double);
            };
        System.out.println("El total de las ventas es: " + TotalVentas);
        //Está mal hecho, hay que arreglarlo
    }
}
