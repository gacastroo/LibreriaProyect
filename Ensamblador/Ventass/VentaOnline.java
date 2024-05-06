package Ensamblador.Ventass;

import Ensamblador.Cliente;
import Ensamblador.Libros;
import Ensamblador.Ventas;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class VentaOnline extends Ventas {

    public VentaOnline(Scanner sc, LocalDate fechaVenta, List<Libros> libroVendidos, Cliente cliente) {
        super(sc, fechaVenta, libroVendidos, cliente);
    }

    public void BuscarClienteYMostrarDireccion(String nombreCliente, Cliente cliente) {
        if (cliente != null && cliente.getNombre().equalsIgnoreCase(nombreCliente)) {
            System.out.println("Dirección del cliente " + nombreCliente + ": " + cliente.getDireccion());
        } else {
            System.out.println("Cliente no encontrado o nulo");
        }
    }

    public void setDireccionEnvioCliente(String nuevaDireccionEnvio, Cliente cliente) {
        if (cliente != null) {
            cliente.setDireccion(nuevaDireccionEnvio);
            System.out.println("Dirección de envío del cliente " + cliente.getNombre() + " actualizada correctamente.");
        } else {
            System.out.println("Cliente no encontrado");
        }
    }

    public void calcularCostoDeEnvio(Cliente cliente) {
        // Este método calculará el costo de envío dependiendo del país del cliente que tengamos en esta venta
        double costoEnvio;

        if (cliente != null) {
            String direccionCliente = cliente.getDireccion().toLowerCase();

            if (direccionCliente.contains("españa")) {
                costoEnvio = 5.0;
            } else if (direccionCliente.contains("italia") || direccionCliente.contains("alemania") ||
                    direccionCliente.contains("francia") || direccionCliente.contains("portugal")) {
                costoEnvio = 10.0;
            } else {
                costoEnvio = 15.0;
            }

            System.out.println("El costo de envío para " + cliente.getNombre() + " es: " + costoEnvio + "€");
        } else {
            System.out.println("Cliente no encontrado");
        }
    }
}
