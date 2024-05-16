package Ensamblador.Test;

import Ensamblador.Archivos.Archivos;
import Ensamblador.Clientess.Cliente;
import Ensamblador.Ensambladorc.Ensamblador;
import Ensamblador.Librosc.Libros;
import Ensamblador.Ventass.Ventas;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EnsambladorTest {

    @Test
    public void testAddCliente() {
        // Configurar escenario: crear objetos con datos de prueba
        String nombreCliente = "Juan Perez";
        String emailCliente = "juan.perez@ejemplo.com";
        String telefonoCliente = "1234567890";

        Cliente cliente = new Cliente(nombreCliente, emailCliente, telefonoCliente);
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

    String nombreCliente2 = "Maria Lopez";
    String emailCliente2 = "maria.lopez@ejemplo.com";
    String telefonoCliente2 = "9876543210";

    Cliente cliente1 = new Cliente(nombreCliente1, emailCliente1, telefonoCliente1);
    Cliente cliente2 = new Cliente(nombreCliente2, emailCliente2, telefonoCliente2);

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
    ensamblador.remove(new Cliente("Nuevo Cliente", "nuevo@ejemplo.com", "1112223333"));

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
    Libros libro1 = new Libros ("Clean Code", "Robert C. Martin", "Programming", 35.99);
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

    Ensamblador ensamblador = new Ensamblador(clientes, new ArrayList<>() {{ add(libro1); add(libro2); }}, archivos, ventas); // Initialize libros list

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

            Archivos archivo = new Archivos("archivo1","TXT","/home/user/documents/archivo1.txt");
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

            Archivos archivo1 = new Archivos("nombre","sp","desktop");
            Archivos archivo2 = new Archivos("nombre","sp","desktop");

            List<Cliente> clientes = new ArrayList<>();
            List<Libros> libros = new ArrayList<>();
            List<Ventas> ventas = new ArrayList<>();

            Ensamblador ensamblador = new Ensamblador(clientes, libros, new ArrayList<>() {{ add(archivo1); add(archivo2); }}, ventas); // Initialize archivos list

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
        List<Libros> libros = new ArrayList<>();
        libros.add(new Libros("Clean Code", "Robert C. Martin", "Programming", 35.99));
        libros.add(new Libros("The Pragmatic Programmer", "Andrew Hunt & David Thomas", "Software Development", 42.50));

        String targetTitle = "Clean Code";
        //List<Libros> result = Ensamblador.buscarLibroPorTitulo(targetTitle, libros);

        //assertNotNull(result); // Verify a list is returned
        //assertEquals(1, result.size()); // Verify only the matching book is returned
        //assertEquals(targetTitle, result.get(0).getTitulo()); // Verify the returned book's title
    }

    @Test
    public void testBuscarLibroPorTitulo_NonexistentBook() {
        List<Libros> libros = new ArrayList<>();
        libros.add(new Libros("Clean Code", "Robert C. Martin", "Programming", 35.99));
        libros.add(new Libros("The Pragmatic Programmer", "Andrew Hunt & David Thomas", "Software Development", 42.50));

        String targetTitle = "Nonexistent Book";
        //List<Libros> result = Ensamblador.buscarLibroPorTitulo(targetTitle, libros);

        //assertNull(result); // Verify null is returned for a non-existent book
    }

//    @Test
//    public void testSaveAndLoadData() throws IOException, ClassNotFoundException {
//        // Sample data for clientes, libros, archivos, and ventas
//        List<Cliente> clientes = new ArrayList<>();
//        Scanner sc = new Scanner(System.in);
//        clientes.add(new Cliente("John Doe","ven","gmail.com"));
//        List<Libros> libros = new ArrayList<>();
//        libros.add(new Libros("Clean Code", "Robert C. Martin", "Programming", 35.99));
//        List<Archivos> archivos = new ArrayList<>();
//        archivos.add(new Archivos("archivo1.txt", "TXT", "/path/to/file"));
//        List<Ventas> ventas = new ArrayList<>();
//        ventas.add(new Ventas(sc, LocalDate.now(),libros,clientes.get(0)));
//
//        Ensamblador ensamblador = new Ensamblador(clientes, libros, archivos, ventas);
//
//        // Temporary file for testing
//        String tempFilePath = createTempFile();
//
//        // Save data to file
//        ensamblador.saveDataToFile(tempFilePath);
//
//        // Load data from file (create a new Ensamblador instance)
//        Ensamblador loadedEnsamblador = new Ensamblador(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
//        loadedEnsamblador.loadDataFromFile(tempFilePath);
//
//        // Verify loaded data
//        assertEquals(clientes.size(), loadedEnsamblador.getClientes().size());
//        assertEquals(libros.size(), loadedEnsamblador.getLibros().size());
//        assertEquals(archivos.size(), loadedEnsamblador.getArchivos().size());
//        assertEquals(ventas.size(), loadedEnsamblador.getVentas().size());
//
//        // Compare individual elements (optional, depending on your data)
//        assertEquals(clientes.get(0).getNombre(), loadedEnsamblador.getClientes().get(0).getNombre());
//        assertEquals(libros.get(0).getTitulo(), loadedEnsamblador.getLibros().get(0).getTitulo());
//        // ... compare other elements
//
//        // Delete temporary file (optional)
//        deleteTempFile(tempFilePath);
//    }
//
//    // Helper methods to create and delete temporary file (implementation details may vary)
//    private String createTempFile() throws IOException {
//        File tempFile = File.createTempFile("ensamblador_test", ".data");
//        return tempFile.getAbsolutePath();
//    }
//    private void deleteTempFile(String filePath) {
//        File tempFile = new File(filePath);
//        tempFile.delete();
//    }


}








