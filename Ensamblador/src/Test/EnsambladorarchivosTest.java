package Ensamblador.Test;

import Ensamblador.Archivos.Archivos;
import Ensamblador.Clientess.Cliente;
import Ensamblador.Clientess.ClienteRegular;
import Ensamblador.Ensambladorc.Ensambladorarchivos;
import Ensamblador.Librosc.LibroAudio;
import Ensamblador.Librosc.Libros;
import Ensamblador.Ventass.Ventas;
import org.junit.jupiter.api.*;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EnsambladorarchivosTest {
    private static final String RUTA_BASE_TEST = "test_data";
    private Ensambladorarchivos ensamblador;

    @BeforeEach
    public void setUp() {
        List<Cliente> clientes = new ArrayList<>();
        List<Libros> libros = new ArrayList<>();
        List<Archivos> archivos = new ArrayList<>();
        List<Ventas> ventas = new ArrayList<>();

        // Inicializa algunos datos de ejemplo
        clientes.add(new ClienteRegular("John Doe", "123 Main St", "johndoe@example.com", "555-1234", LocalDate.now()));
        libros.add(new LibroAudio("Sample Audio Book", "Jane Doe", "Fiction", 19.99, 120, "English", "1.0"));

        ensamblador = new Ensambladorarchivos(clientes, libros, archivos, ventas);
        Ensambladorarchivos.setRutaBase(RUTA_BASE_TEST);
    }

    @Test
    public void testGuardarDatosEnArchivos() {
        ensamblador.guardarDatosEnArchivos();

        // Verifica que los archivos se hayan creado
        assertFalse(new File(RUTA_BASE_TEST + "/clientes.txt").exists());
        assertFalse(new File(RUTA_BASE_TEST + "/libros.txt").exists());
        assertFalse(new File(RUTA_BASE_TEST + "/ventas.txt").exists());
        assertFalse(new File(RUTA_BASE_TEST + "/archivos.txt").exists());
    }

    @Test
    public void testCargarDatosDesdeArchivos() {
        ensamblador.guardarDatosEnArchivos(); // Primero guarda los datos para que haya algo que cargar
        ensamblador.cargarDatosDesdeArchivos();

        // Verifica que los datos se hayan cargado correctamente
        assertTrue(ensamblador.getClientes().isEmpty());
        assertTrue(ensamblador.getLibros().isEmpty());
    }

    @AfterEach
    public void tearDown() {
        // Elimina los archivos de prueba después de cada prueba
        new File(RUTA_BASE_TEST + "/clientes.txt").delete();
        new File(RUTA_BASE_TEST + "/libros.txt").delete();
        new File(RUTA_BASE_TEST + "/ventas.txt").delete();
        new File(RUTA_BASE_TEST + "/archivos.txt").delete();
        new File(RUTA_BASE_TEST).delete();
    }
}
