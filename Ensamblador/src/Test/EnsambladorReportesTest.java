package Ensamblador.Test;

import Ensamblador.Archivos.Archivos;
import Ensamblador.Clientess.Cliente;
import Ensamblador.Ensambladorc.EnsambladorReportes;
import Ensamblador.Librosc.Libros;
import Ensamblador.Ventass.Ventas;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnsambladorReportesTest {
    @Test
    public void testGenerarInformeClientes() {
        // Datos de prueba
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Juan ", "juan@example.com", "123456789","652225", LocalDate.parse("2000-11-05")));
        clientes.add(new Cliente("María ", "maria@example.com", "987654321","652225", LocalDate.parse("2000-11-05")));

        List<Libros> libros = new ArrayList<>();
        List<Archivos> archivos = new ArrayList<>();
        List<Ventas> ventas = new ArrayList<>();

        EnsambladorReportes reportes = new EnsambladorReportes(clientes, libros, archivos, ventas);

        // Llamar al método
        String resultado = EnsambladorReportes.generarInformeClientes(reportes);
        System.out.println(resultado);

        // Verificar que la salida no sea nula
        assertNotNull(resultado);
        // Verificar que la salida contiene información del cliente
        assertTrue(resultado.contains("Juan") && resultado.contains("juan@example.com") && resultado.contains("123456789")&& resultado.contains("652225")&& resultado.contains("2000-11-05"));
    }

    @Test
    public void testGenerarInformeLibros() {
        // Datos de prueba
        List<Cliente> clientes = new ArrayList<>();
        List<Libros> libros = new ArrayList<>();
        libros.add(new Libros("El Quijote", "Miguel de Cervantes", "novel",15));
        libros.add(new Libros("Cien años de soledad", "Gabriel García Márquez","novel", 30.0));

        List<Archivos> archivos = new ArrayList<>();
        List<Ventas> ventas = new ArrayList<>();

        EnsambladorReportes reportes = new EnsambladorReportes(clientes, libros, archivos, ventas);

        // Llamar al método
        String resultado = EnsambladorReportes.generarInformeLibros(reportes);

        // Verificar que la salida no sea nula
        assertNotNull(resultado);
        // Verificar que la salida contiene información de los libros
        assertTrue(resultado.contains("El Quijote") && resultado.contains("Miguel de Cervantes") && resultado.contains("15.0"));
        assertTrue(resultado.contains("Cien años de soledad") && resultado.contains("Gabriel García Márquez") && resultado.contains("30.0"));
    }

    @Test
    public void testGenerarInformeVentas() {
        // Datos de prueba
        List<Cliente> clientes = new ArrayList<>();
        List<Libros> libros = new ArrayList<>();
        List<Archivos> archivos = new ArrayList<>();

        List<Ventas> ventas = new ArrayList<>();
        Cliente cliente = new Cliente("Juan","patata", "juan@example.com", "123456789",LocalDate.parse("2000-11-20"));
        Libros libro = new Libros("El Quijote","patata", "Miguel de Cervantes", 25.0);
        ventas.add(new Ventas(LocalDate.parse("2000-11-20"), libros, cliente));

        EnsambladorReportes reportes = new EnsambladorReportes(clientes, libros, archivos, ventas);

        // Llamar al método
        String resultado = EnsambladorReportes.generarInformeVentas(reportes);
        System.out.println(resultado);

        // Verificar que la salida no sea nula
        assertNotNull(resultado);
        // Verificar que la salida contiene información de la venta
        assertTrue(resultado.contains("Juan") && resultado.contains("El Quijote") && resultado.contains("25.0"));
    }


}
