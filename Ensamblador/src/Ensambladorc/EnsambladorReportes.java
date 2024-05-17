package Ensamblador.Ensambladorc;
//subclase ensamblador :D

import Ensamblador.Archivos.Archivos;
import Ensamblador.Clientess.Cliente;
import Ensamblador.Librosc.Libros;
import Ensamblador.Ventass.Ventas;

import java.time.LocalDate;
import java.util.List;

public class EnsambladorReportes extends Ensamblador {

    public EnsambladorReportes(List<Cliente> clientes, List<Libros> libros, List<Archivos> archivos, List <Ventas> ventas) {
        super(clientes, libros, archivos, ventas);
    }

    public String generarReporteClientes() {
        // Generar un reporte con información detallada sobre los clientes
        StringBuilder reporte = new StringBuilder();
        for (Cliente cliente : clientes) {
            reporte.append("Nombre: ").append(cliente.getNombre()).append("Direccion: ").append(cliente.getDireccion()).append(", Email: ").append(cliente.getEmail()).append(", Teléfono: ").append(cliente.getNumTelefono()).append(", Fecha Registro: ").append(cliente.getFechaRegistro()).append("\n");
        }
        return reporte.toString();
    }

    public String generarReporteLibros() {
        // Generar un reporte con información detallada sobre los libros disponibles
        StringBuilder reporte = new StringBuilder();
        for (Libros libro : libros) {
            reporte.append("Título: ").append(libro.getTitulo()).append(", Autor: ").append(libro.getAutor()).append(", Precio: ").append(libro.getPrecio()).append("\n");
        }
        return reporte.toString();
    }

    public String generarReporteVentas() {
        // Generar un reporte con información detallada sobre las ventas realizadas
        StringBuilder reporte = new StringBuilder();
        for (Ventas venta : ventas) {
            // Obtener el cliente de la venta actual
            LocalDate fecha = venta.getFechaVentas();
            // Obtener el libro de la venta actual
            Libros libro = venta.getLibrosVendidos().getFirst(); // Suponiendo que 'getLibrosVendidos()' devuelve una lista y queremos el primer libro vendido
            Cliente cliente = venta.getCliente();
            // Agregar detalles de la venta al reporte
            reporte.append("Fecha Registrada: ").append(fecha)
                    .append(", Libro Vendidos: ").append(libro)
                    .append(", Cliente: ").append(cliente)
                    .append("\n");
        }
        return reporte.toString();
    }


}