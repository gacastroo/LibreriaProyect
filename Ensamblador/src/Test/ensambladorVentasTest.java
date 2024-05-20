/*package Ensamblador.Test;

import Ensamblador.Archivos.Archivos;
import Ensamblador.Clientess.Cliente;
import Ensamblador.Ensambladorc.EnsambladorVentas;
import Ensamblador.Librosc.Libros;
import Ensamblador.Ventass.Ventas;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ensambladorVentasTest {
    @Test
    public void testBuscarVentaPorCliente() {
        // Datos de prueba
        Cliente cliente1 = new Cliente("Juan", "Calle Principal", "juan@example.com", "123456789", LocalDate.now());
        Cliente cliente2 = new Cliente("María", "Calle Secundaria", "maria@example.com", "987654321", LocalDate.now());
        String nombreCliente = "Juan";
        String nombreCliente2 = "María";

        List<Cliente> clientes = Arrays.asList(cliente1, cliente2);
        List<Libros> libros = new ArrayList<>();
        libros.add(new Libros("Libro1", "Autor1", "Genero1", 20.0));
        libros.add(new Libros("Libro2", "Autor2", "Genero2", 25.0));

        List<Archivos> archivos = new ArrayList<>();
        List<Ventas> ventas = new ArrayList<>();
        ventas.add(new Ventas(LocalDate.now(), libros, cliente1));

        // Llamada al método y verificación
        String resultado = EnsambladorVentas.BuscarVentaPorCliente(ventas, clientes,nombreCliente);
        assertEquals("Ventas para el cliente Juan:\n" + "Venta realizada el" + " " + LocalDate.now() + " para el cliente Juan", resultado);
        resultado = EnsambladorVentas.BuscarVentaPorCliente(ventas, List.of(cliente2),nombreCliente2);
        assertEquals("No se encontraron ventas para el cliente María", resultado);
    }
    @Test
    public void testBuscarVentasPorLibro() {
        // Datos de prueba
        Libros libro1 = new Libros("Libro1", "Autor1", "Genero1", 20.0);
        Libros libro2 = new Libros("Libro2", "Autor2", "Genero2", 25.0);
        List<Libros> libros = Arrays.asList(libro1, libro2);
        String nombreLibro = "Libro1";
        String nombreLibro2 = "Libro2";
        List<Cliente> clientes = new ArrayList<>();
        List<Archivos> archivos = new ArrayList<>();
        List<Ventas> ventas = new ArrayList<>();
        ventas.add(new Ventas(LocalDate.now(), List.of(libro1), new Cliente("Juan", "juan@example.com", "123456789", "Calle Principal", LocalDate.now())));

        // Llamada al método y verificación
        String resultado = EnsambladorVentas.BuscarVentasPorLibro(libros, ventas,nombreLibro);
        assertEquals(ventas.getFirst().toString(), resultado);

        resultado = EnsambladorVentas.BuscarVentasPorLibro(List.of(new Libros("Libro3", "Autor3", "Genero3", 30.0)), ventas,nombreLibro2);
        assertEquals( "El libro Libro2 no está registrado",resultado);
    }

    @Test
    public void testTotalVentas() {
        // Datos de prueba
        List<Cliente> clientes = new ArrayList<>();
        List<Libros> libros = Arrays.asList(
                new Libros("Libro1", "Autor1", "Genero1", 2),
                new Libros("Libro2", "Autor2", "Genero2", 2)
        );

        List<Ventas> ventas = Arrays.asList(
                new Ventas(LocalDate.now(), libros, new Cliente("Juan", "juan@example.com", "123456789", "Calle Principal", LocalDate.now())),
                new Ventas(LocalDate.now(), libros, new Cliente("María", "maria@example.com", "987654321", "Calle Secundaria", LocalDate.now()))
        );

        // Llamada al método y verificación
        String resultado = String.valueOf(EnsambladorVentas.TotalVentas(libros));
        assertEquals("El total de las ventas es: 4.0", resultado); // Hasta ahora, solo hemos creado ventas, no se ha calculado el total.
    }
}
*/