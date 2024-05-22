package Ensamblador.Ensambladorc;

import Ensamblador.Archivos.Archivos;
import Ensamblador.Clientess.Cliente;
import Ensamblador.Librosc.Libros;
import Ensamblador.Ventass.Ventas;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


//subclase ensamblador :D
public class EnsambladorVentas extends Ensamblador {

    public EnsambladorVentas(List<Cliente> clientes, List<Libros> libros, List<Archivos> archivos, List<Ventas> ventas) {
        super(clientes, libros, archivos, ventas);
    }

    public void add(Ventas ventas) {
        add(ventas);
    }

    //ESTE METODO VA EN EL GUI
    public static String BuscarVentaPorClienteScanner(List<Ventas> ventas, List<Cliente> clientes) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Qué cliente quieres buscar?");
        String nombreCliente = scanner.nextLine().trim();
        return BuscarVentaPorCliente(ventas, clientes, nombreCliente);
    }

    public static String BuscarVentaPorCliente(List<Ventas> ventas, List<Cliente> clientes, String nombreCliente) {
        StringBuilder resultado = new StringBuilder();
        boolean clienteEncontrado = false;

        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombreCliente)) {
                clienteEncontrado = true;
                boolean ventaEncontrada = false;
                resultado.append("Ventas para el cliente ").append(nombreCliente).append(":\n");
                for (Ventas venta : ventas) {
                    if (venta.getCliente().equals(cliente)) {
                        resultado.append(venta);
                        ventaEncontrada = true;
                    }
                }
                if (!ventaEncontrada) {
                    resultado.append("No se encontraron ventas para el cliente ").append(cliente.getNombre());
                }
                break; // Rompe el bucle ya que hemos encontrado el cliente
            }
        }
        if (!clienteEncontrado) {
            resultado.append("El cliente ").append(nombreCliente).append(" no está registrado");
        }
        return resultado.toString();
    }

    ////LAS DE SCANNER ES LA FUNCION PARA IMPLEMENTAR EN EL GUI
    public static String BuscarVentaPorLibroScanner(List<Ventas> ventas, List<Cliente> clientes) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Qué libro quieres consultar?");
        String nombreLibro = scanner.nextLine().trim();
        return BuscarVentaPorCliente(ventas, clientes, nombreLibro);
    }

    public static String BuscarVentasPorLibro(List<Libros> libros, List<Ventas> ventas, String nombreLibro) {
        StringBuilder resultado = new StringBuilder();
        boolean libroEncontrado = false;
        boolean ventaEncontrada = false;

        for (Libros libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(nombreLibro)) {
                libroEncontrado = true;
                for (Ventas venta : ventas) {
                    if (venta.getLibrosVendidos().stream().anyMatch(l -> l.equals(libro))) {
                        resultado.append(venta);
                        ventaEncontrada = true;
                    }
                }
                if (!ventaEncontrada) {
                    resultado.append("No se encontraron ventas para el libro ").append(nombreLibro);
                }
                break; // Rompe el bucle ya que hemos encontrado el libro
            }
        }
        if (!libroEncontrado) {
            resultado.append("El libro ").append(nombreLibro).append(" no está registrado");
        }
        return resultado.toString();
    }


    public static String TotalVentas(List<Libros> libros) {
        double sumaPrecios = 0.0;
        for (Libros libro : libros) {
            sumaPrecios += libro.getPrecio();
        }
        return "El total de las ventas es: " + sumaPrecios;
    }
}
