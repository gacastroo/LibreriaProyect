package Ensamblador.Ventas;

import Ensamblador.ClienteVentas;
import Ensamblador.Libros;
import Ensamblador.Vendedor;
import Ensamblador.Venta;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class VentaPresencial extends Venta {

    Vendedor vendedor;

    public VentaPresencial(Scanner sc, LocalDate fechaVenta, List<Libros> libroVendidos, ClienteVentas cliente, Vendedor vendedor) {
        super(sc, fechaVenta, libroVendidos, cliente);
        this.vendedor = vendedor;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }
    public void mostrarNombreVendedor() {
        System.out.println("El nombre del vendedor es " + vendedor.getNombre());
    }
    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
        System.out.println("El vendedor ha sido introducido con éxito");
    }

    public void GenerarFactura(Venta venta){

        System.out.println("======= Factura =======");
        System.out.println("Fecha de venta: " + getFechaVenta());
        System.out.println("Nombre del cliente: " + ClienteVentas.getNombre());
        System.out.println("Nombre del vendedor: " + vendedor.getNombre());
        System.out.println("Libros vendidos con su precio:");
        for (Libros libro : getLibrosVendidos()) {
            System.out.println("- " + Libros.getTitulo() + " | Precio: $" + libro.getPrecio());
        }
        double totalAPagar = calcularTotal() - VentaMayorista.DescuentoDeClienteMayorista(venta);
        System.out.println("Total a pagar: $" + totalAPagar);
        System.out.println("=======================");
    }

}


