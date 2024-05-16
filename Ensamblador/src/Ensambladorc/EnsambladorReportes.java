package Ensamblador.Ensambladorc;
//subclase ensamblador :D

import Ensamblador.Archivos.Archivos;
import Ensamblador.Clientess.Cliente;
import Ensamblador.Librosc.Libros;
import Ensamblador.Ventass.Ventas;

import java.util.List;

public class EnsambladorReportes extends Ensamblador {

    public EnsambladorReportes(List<Cliente> clientes, List<Libros> libros, List<Archivos> archivos, List <Ventas> ventas) {
        super(clientes, libros, archivos, ventas);
    }

    public String generarReporteClientes() {
        // Generar un reporte con información detallada sobre los clientes
        StringBuilder reporte = new StringBuilder();
        for (Cliente cliente : clientes) {
            reporte.append("Nombre: ").append(Cliente.getNombre()).append(", Email: ").append(cliente.getEmail()).append(", Teléfono: ").append(cliente.getNumTelefono()).append("\n");
        }
        return reporte.toString();
    }

    public String generarReporteLibros() {
        // Generar un reporte con información detallada sobre los libros disponibles
        StringBuilder reporte = new StringBuilder();
        for (Libros libro : libros) {
            reporte.append("Título: ").append(Libros.getTitulo()).append(", Autor: ").append(libro.getAutor()).append(", Precio: ").append(libro.getPrecio()).append("\n");
        }
        return reporte.toString();
    }

    public String generarReporteVentas() {
        // Generar un reporte con información detallada sobre las ventas realizadas
        StringBuilder reporte = new StringBuilder();
        for (Ventas venta : ventas) { 
            // Obtener el cliente de la venta actual
            Cliente cliente = venta.getCliente(); 
            // Obtener el libro de la venta actual
            Libros libro = venta.getLibrosVendidos().get(0); // Suponiendo que 'getLibrosVendidos()' devuelve una lista y queremos el primer libro vendido
            // Agregar detalles de la venta al reporte
            reporte.append("Cliente: ").append(cliente.getNombre())
                    .append(", Libro: ").append(libro.getTitulo())
                    .append(", Cantidad: ").append(venta.getLibrosVendidos().size()) // Aquí supongo que deseas mostrar la cantidad de libros vendidos
                    .append(", Total: ").append(venta.calcularTotal())
                    .append("\n");
        }
        return reporte.toString();
    }
    // HOLA
}