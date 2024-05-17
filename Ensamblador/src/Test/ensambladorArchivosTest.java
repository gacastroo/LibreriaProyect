package Ensamblador.Test;
import Ensamblador.Archivos.Archivos;
import Ensamblador.Ensambladorc.Ensambladorarchivos;
import Ensamblador.Librosc.LibroAudio;
import Ensamblador.Librosc.LibroElectronico;
import Ensamblador.Librosc.LibroInfantil;
import Ensamblador.Librosc.Libros;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ensambladorArchivosTest {
        @Test
        public void testGuardarYRecuperarDatosDesdeArchivo() {
            Ensambladorarchivos ensamblador = new Ensambladorarchivos(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
            String nombreArchivo = "test.txt";
            String datos = "test.txtArchivo Cargado";

            // Guardar datos en un archivo
            String mensajeGuardado = ensamblador.guardarDatosEnArchivo(nombreArchivo, datos);
            assertEquals(nombreArchivo + "Archivo Guardado", mensajeGuardado);

            // Cargar datos desde el archivo
            String mensajeCargado = ensamblador.cargarDatosDesdeArchivo(nombreArchivo);
            assertEquals(nombreArchivo + "Archivo Cargado", mensajeCargado);

            // Verificar que los datos recuperados sean correctos
            File archivo = new File(nombreArchivo);
            assertTrue(archivo.exists());
            archivo.delete(); // Limpiar después de la prueba
        }

    @Test
    public void testGuardarLibro() throws IOException {
        // Preparar datos de prueba
        Libros libro1 = new LibroAudio("Titulo1", "Autor1", "Genero1", 10.0, 120, "Español");
        Libros libro2 = new LibroInfantil("Titulo2", "Autor2", "Genero2", 15.0, 6, true, 20);

        Ensambladorarchivos ensamblador = new Ensambladorarchivos(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        // Ejecutar el método
        ensamblador.guardarLibro(libro1);
        ensamblador.guardarLibro(libro2);

        // Verificar si los libros se guardaron correctamente en el archivo
        // Aquí puedes añadir más aserciones para verificar los detalles de los libros guardados

        // Por ejemplo, puedes verificar si el archivo existe y su contenido
        File archivo = new File(Archivos.getRuta());
        assertTrue("El archivo debería existir", archivo.exists());

        // Puedes leer el contenido del archivo y verificar si coincide con los libros que has guardado
        List<String> lineas = Files.readAllLines(Paths.get(Archivos.getRuta()), StandardCharsets.UTF_8);
        assertEquals("Debería haber dos libros guardados", 2, lineas.size());

        // Verificar el contenido de cada línea
        assertEquals("La primera línea debe coincidir con los datos del primer libro", "Audio,Titulo1,Autor1,Genero1,10.0,120,Español", lineas.get(0));
        assertEquals("La segunda línea debe coincidir con los datos del segundo libro", "Infantil,Titulo2,Autor2,Genero2,15.0,6,true,20", lineas.get(1));
    }

        @Test
        public void testCargar() {
            // Crear un archivo de prueba con algunos datos
            String nombreArchivo = "test.txt";
            try {
                List<String> lineas = new ArrayList<>();
                lineas.add("Audio,Titulo1,Autor1,Genero1,10.0,120,Español");
                lineas.add("Infantil,Titulo2,Autor2,Genero2,15.0,6,true,20");
                File archivo = new File(nombreArchivo);
                java.nio.file.Files.write(archivo.toPath(), lineas);
            } catch (IOException e) {
                e.printStackTrace();
            }

            Ensambladorarchivos ensamblador = new Ensambladorarchivos(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

            // Ejecutar el método y verificar
            List<Libros> librosCargados = ensamblador.cargar();
            assertEquals(2, librosCargados.size());
            // Verificar más detalles de los libros cargados si es necesario

            // Limpiar después de la prueba
            File archivo = new File(nombreArchivo);
            archivo.delete();
        }
    }

