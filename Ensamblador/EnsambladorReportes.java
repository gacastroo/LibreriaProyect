package Ensamblador;
//subclase ensamblador :D

import java.util.List;

public class EnsambladorReportes extends Ensamblador {
    public EnsambladorReportes(List<ClienteVentas> clientes, List<Libros> libros, List<Archivos> archivos) {
        super(clientes, libros, archivos);
    }

    public String generarReporteClientes() {
        // Generar un reporte con información detallada sobre los clientes
        StringBuilder reporte = new StringBuilder();
        for (ClienteVentas cliente : clientes) {
            reporte.append("Nombre: ").append(cliente.getNombre()).append(", Email: ").append(cliente.getEmail()).append(", Teléfono: ").append(cliente.getNumTelefono()).append("\n");
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
        for (Venta venta : venta) {
            // Obtener el cliente de la venta actual
            ClienteVentas cliente = venta.getClientes().getFirst(); // Supongo que solo hay un cliente por venta
            // Obtener el libro de la venta actual
            Libros libro = venta.getLibrosVendidos().getFirst(); // Supongo que solo se vende un libro por venta
            // Agregar detalles de la venta al reporte
            reporte.append("Cliente: ").append(cliente.getNombre())
                    .append(", Libro: ").append(Libros.getTitulo())
                    .append(", Cantidad: ").append(venta.getLibrosVendidos().size()) // Aquí supongo que deseas mostrar la cantidad de libros vendidos
                    .append(", Total: ").append(venta.calcularTotal())
                    .append("\n");
        }
        return reporte.toString();
    }
}