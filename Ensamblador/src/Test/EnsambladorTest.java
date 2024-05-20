/*package Ensamblador.Test;

import Ensamblador.Archivos.Archivos;
import Ensamblador.Clientess.Cliente;
import Ensamblador.Ensambladorc.Ensamblador;
import Ensamblador.Ensambladorc.EnsambladorReportes;
import Ensamblador.Librosc.Libros;
import Ensamblador.Ventass.Ventas;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import javax.management.ObjectName;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EnsambladorTest {

    @Test
    public void testAddCliente() {
        // Configurar escenario: crear objetos con datos de prueba
        String nombreCliente = "Juan Perez";
        String emailCliente = "juan.perez@ejemplo.com";
        String telefonoCliente = "1234567890";
        String direccionCliente = "FNKJOENKJOFDNK";
        LocalDate fechaRegistro = LocalDate.parse("2019-11-20");

        Cliente cliente = new Cliente(nombreCliente, direccionCliente, emailCliente, telefonoCliente, fechaRegistro);
        List<Cliente> clientes = new ArrayList<>();
        List<Libros> libros = new ArrayList<>();
        List<Archivos> archivos = new ArrayList<>();
        List<Ventas> ventas = new ArrayList<>();

        Ensamblador ensamblador = new Ensamblador(clientes, libros, archivos, ventas);

        // Ejecutar acción: agregar el cliente a la lista de clientes del ensamblador
        ensamblador.add(cliente);

        // Verificar resultado: verificar que el cliente se haya agregado correctamente a la lista
        assertEquals(1, ensamblador.getClientes().size());
        assertTrue(ensamblador.getClientes().get(0).equals(cliente));
    }

    @Test
    public void testRemoveCliente() {
        // Configure scenario: create objects with data
        String nombreCliente1 = "Juan Perez";
        String emailCliente1 = "juan.perez@ejemplo.com";
        String telefonoCliente1 = "1234567890";
        LocalDate fechaRegistroCliente1 = LocalDate.parse("2000-11-20");


        String nombreCliente2 = "Maria Lopez";
        String emailCliente2 = "maria.lopez@ejemplo.com";
        String telefonoCliente2 = "9876543210";
        String direccionCliente2 = "fnjjnfkdsnjkf";
        LocalDate fechaRegistroCliente2 = LocalDate.parse("2000-12-22");

        Cliente cliente1 = new Cliente(nombreCliente1, direccionCliente2, emailCliente1, telefonoCliente1, fechaRegistroCliente1);
        Cliente cliente2 = new Cliente(nombreCliente2, direccionCliente2, emailCliente2, telefonoCliente2, fechaRegistroCliente2);

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);

        List<Libros> libros = new ArrayList<>(); // Initialize other lists as needed
        List<Archivos> archivos = new ArrayList<>();
        List<Ventas> ventas = new ArrayList<>();

        Ensamblador ensamblador = new Ensamblador(clientes, libros, archivos, ventas);

        // Test case 1: Remove existing client
        ensamblador.remove(cliente1);

        // Verify result: cliente1 is removed
        assertEquals(1, ensamblador.getClientes().size());
        assertFalse(ensamblador.getClientes().contains(cliente1));
        assertTrue(ensamblador.getClientes().contains(cliente2));

        // Test case 2: Remove non-existent client

        // Verify result: list remains unchanged
        assertEquals(1, ensamblador.getClientes().size());
        assertTrue(ensamblador.getClientes().contains(cliente2));
    }

    @Test
    public void testAgregarLibro() {
        List<Cliente> clientes = new ArrayList<>();
        List<Archivos> archivos = new ArrayList<>();
        List<Ventas> ventas = new ArrayList<>();

        Ensamblador ensamblador = new Ensamblador(clientes, new ArrayList<>(), archivos, ventas); // Initialize empty libros list
        Libros libro1 = new Libros("Clean Code", "Robert C. Martin", "Programming", 35.99);
        // Test case: Add a book
        ensamblador.agregarLibro(libro1);

        // Verify result: book is added to the list with correct attributes
        assertEquals(1, ensamblador.getLibros().size());
        Libros libro = ensamblador.getLibros().get(0);
        assertEquals("Clean Code", libro.getTitulo());
        assertEquals("Robert C. Martin", libro.getAutor());
        assertEquals("Programming", libro.getGenero());
        assertEquals(35.99, libro.getPrecio(), 0.01); // Delta for floating-point comparison
    }

    @Test
    public void testEliminarLibro() {
        // Configure scenario: create objects with data
        String tituloLibro1 = "Clean Code";
        String autorLibro1 = "Robert C. Martin";
        String generoLibro1 = "Programming";
        double precioLibro1 = 35.99;

        String tituloLibro2 = "The Pragmatic Programmer";
        String autorLibro2 = "Andrew Hunt & David Thomas";
        String generoLibro2 = "Software Development";
        double precioLibro2 = 42.50;

        Libros libro1 = new Libros(tituloLibro1, autorLibro1, generoLibro1, precioLibro1);
        Libros libro2 = new Libros(tituloLibro2, autorLibro2, generoLibro2, precioLibro2);

        List<Cliente> clientes = new ArrayList<>();
        List<Archivos> archivos = new ArrayList<>();
        List<Ventas> ventas = new ArrayList<>();

        Ensamblador ensamblador = new Ensamblador(clientes, new ArrayList<>() {{
            add(libro1);
            add(libro2);
        }}, archivos, ventas); // Initialize libros list

        // Test case: Remove existing book
        ensamblador.eliminarLibro(libro1);

        // Verify result: libro1 is removed
        assertEquals(1, ensamblador.getLibros().size());
        assertFalse(ensamblador.getLibros().contains(libro1));
        assertTrue(ensamblador.getLibros().contains(libro2));

        // Test case: Remove non-existent book
        ensamblador.eliminarLibro(new Libros("Nuevo Libro", "Nuevo Autor", "Nuevo Género", 0.0));

        // Verify result: list remains unchanged
        assertEquals(1, ensamblador.getLibros().size());
        assertTrue(ensamblador.getLibros().contains(libro2));
    }

    @Test
    public void testAgregarArchivo() {
        // Configure scenario: create objects with data
        String nombreArchivo = "archivo1";
        String extensionArchivo = "TXT";
        String rutaArchivo = "/home/user/documents/archivo1.txt";
        String contenidoArchivo = "Contenido del archivo 1";

        Archivos archivo = new Archivos("archivo1", "TXT", "/home/user/documents/archivo1.txt");
        List<Cliente> clientes = new ArrayList<>();
        List<Libros> libros = new ArrayList<>();
        List<Ventas> ventas = new ArrayList<>();

        Ensamblador ensamblador = new Ensamblador(clientes, libros, new ArrayList<>(), ventas); // Initialize empty archivos list

        // Test case: Add an archivo
        ensamblador.agregarArchivo(archivo);

        // Verify result: archivo is added to the list
        assertEquals(1, ensamblador.getArchivos().size());
        Archivos archivoAgregado = ensamblador.getArchivos().get(0);
        assertEquals(nombreArchivo, archivoAgregado.getNombre());
        assertEquals(extensionArchivo, archivoAgregado.getExtension());
        assertEquals(rutaArchivo, archivoAgregado.getRuta());
    }


    @Test
    public void testEliminarArchivo() {

        Archivos archivo1 = new Archivos("nombre", "sp", "desktop");
        Archivos archivo2 = new Archivos("nombre", "sp", "desktop");

        List<Cliente> clientes = new ArrayList<>();
        List<Libros> libros = new ArrayList<>();
        List<Ventas> ventas = new ArrayList<>();

        Ensamblador ensamblador = new Ensamblador(clientes, libros, new ArrayList<>() {{
            add(archivo1);
            add(archivo2);
        }}, ventas); // Initialize archivos list

        // Test case: Remove existing archivo
        ensamblador.eliminarArchivo(archivo1);

        // Verify result: archivo1 is removed
        assertEquals(1, ensamblador.getArchivos().size());
        assertFalse(ensamblador.getArchivos().contains(archivo1));
        assertTrue(ensamblador.getArchivos().contains(archivo2));
        // Test case: Remove non-existent archivo
        ensamblador.eliminarArchivo((archivo1));

        // Verify result: list remains unchanged
        assertEquals(1, ensamblador.getArchivos().size());
        assertTrue(ensamblador.getArchivos().contains(archivo2));
    }

    @Test
    public void testBuscarLibroPorTitulo_ExistingBook() {
        // Create an ArrayList of Libros objects
        ArrayList<Libros> libros = new ArrayList<>();
        libros.add(new Libros("Clean Code", "Robert C. Martin", "Programming", 35.99));
        libros.add(new Libros("The Pragmatic Programmer", "Andrew Hunt & David Thomas", "Software Development", 42.50));
        String targetTitle = "The Pragmatic Programmer";
        ArrayList<Libros> result = Ensamblador.buscarLibroPorTitulo(targetTitle, libros);
        assertNotNull(result); // Verify a list is returned
        assertEquals(1, result.size()); // Verify only the matching book is returned
        assertEquals(targetTitle, result.get(0).getTitulo()); // Verify the returned book's title
    }


    @Test
    public void testBuscarLibroPorTitulo_NonexistentBook() {
        ArrayList<Libros> libros = new ArrayList<>();
        libros.add(new Libros("Clean Code", "Robert C. Martin", "Programming", 35.99));
        libros.add(new Libros("The Pragmatic Programmer", "Andrew Hunt & David Thomas", "Software Development", 42.50));
        String targetTitle = "Nonexistent Book";

        List<Libros> result = Ensamblador.buscarLibroPorTitulo(targetTitle, libros);

        assertTrue(result.isEmpty()); // Verify the list is empty
    }

    //Restante de test cargar y guardar archivo.
    //Restante de test GenerarInforme

}
*/







