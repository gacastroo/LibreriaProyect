package Ensamblador.Ventass;

import Ensamblador.Clientess.Cliente;
import Ensamblador.Librosc.Libros;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class VentaPresencial extends Ventas {

    Vendedor vendedor;

    public VentaPresencial(Scanner sc, LocalDate fechaVenta, List<Libros> libroVendidos, Cliente cliente, Vendedor vendedor) {
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

    public void GenerarFactura(Ventas venta, Cliente cliente){

        System.out.println("======= Factura =======");
        System.out.println("Fecha de venta: " + getFechaVentas());
        System.out.println("Nombre del cliente: " + cliente.getNombre());
        System.out.println("Nombre del vendedor: " + vendedor.getNombre());
        System.out.println("Libros vendidos con su precio:");
        for (Libros libro : getLibrosVendidos()) {
            System.out.println("- " + libro.getTitulo() + " | Precio: $" + libro.getPrecio());
        }
        double totalAPagar = venta.calcularTotal() - VentaMayorista.DescuentoDeClienteMayorista(venta);
        System.out.println("Total a pagar: $" + totalAPagar);
        System.out.println("=======================");
    }

}


