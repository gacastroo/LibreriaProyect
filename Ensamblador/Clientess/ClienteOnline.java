package Ensamblador.Clientess;

import Ensamblador.Ventass.Ventas;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClienteOnline extends Cliente {

    public ClienteOnline(String nombre, String direccion, String email, int numTelefono, LocalDate fechaRegistro) {
        super(nombre, direccion, email);
    }


    // Método utilizado para realizar el seguimiento de un envío

    public static void seguimientoEnvio(Scanner sc, HashMap<Integer, Cliente> mapaClientes, HashMap<Ventas, Integer> mapaVentas) {
        System.out.println("Ingrese el ID de la venta a buscar: ");
        int idVenta = sc.nextInt();
        sc.nextLine();

        // Buscamos la venta en el mapa de ventas
        Ventas ventaEncontrada = null;
        for (Map.Entry<Ventas, Integer> entry : mapaVentas.entrySet()) {
            if (entry.getKey().getIdVentas() == idVenta) {
                ventaEncontrada = entry.getKey();
                break;
            }
        }

        if (ventaEncontrada != null) {
            //System.out.println(ventaEncontrada.ventaEncontrada(ventaEncontrada));
            System.out.println("""
                    ¿Desea consultar el estado del envio o cancelar un envío?\s
                    1. Consultar estado
                    2. Cancelar envío""");
            int x = sc.nextInt();
            if (x == 1) {
                //System.out.println(ventaEncontrada.obtenerEstadoEnvio(ventaEncontrada));
            }
            if (x == 2) {
                System.out.println("Cancelando el envío.");
                GestionarDevolucion(ventaEncontrada);
            }
        } else {  // Si la venta no se encuentra, se muestra un mensaje indicándolo
            System.out.println("Venta no encontrada.");
        }
    }

    public static void GestionarDevolucion(Ventas ventaEncontrada) {
        ventaEncontrada.setPrecio(0);
        ventaEncontrada.setFechaEntrega(null);
        System.out.println("Se ha devuelto el importe completo de la compra.");
    }
}



