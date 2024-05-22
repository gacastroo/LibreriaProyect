package Ensamblador.Ensambladorc;

import Ensamblador.Archivos.Archivos;
import Ensamblador.Archivos.ArchivoClientes.ArchivoClientes;
import Ensamblador.Archivos.ArchivoTexto.ArchivoTexto;
import Ensamblador.Clientess.Cliente;
import Ensamblador.Librosc.Libros;
import Ensamblador.Ventass.Ventas;

import java.io.*;
import java.util.List;

public class Ensambladorarchivos extends Ensamblador {
    private static String rutaBase = "datos"; // Directorio base para los archivos

    public Ensambladorarchivos(List<Cliente> clientes, List<Libros> libros, List<Archivos> archivos, List<Ventas> ventas) {
        super(clientes, libros, archivos, ventas);
    }

    public static void setRutaBase(String rutaBase) {
        Ensambladorarchivos.rutaBase = rutaBase;
    }

    public void guardarDatosEnArchivos() {
        String rutaClientes = rutaBase + "/clientes.txt";
        String rutaLibros = rutaBase + "/libros.txt";
        String rutaVentas = rutaBase + "/ventas.txt";
        String rutaArchivos = rutaBase + "/archivos.txt";

        // Guarda los clientes
        ArchivoClientes archivoClientes = new ArchivoClientes("clientes", "txt", rutaClientes);
        archivoClientes.guardarClientes(clientes);

        // Guarda los libros
        ArchivoTexto archivoLibros = new ArchivoTexto("libros", "txt", rutaLibros);
        archivoLibros.guardarLibros(libros);

        // Guarda las ventas
        Archivos archivoVentas = new Archivos("ventas", "txt", rutaVentas);
        archivoVentas.escribirArchivo(ventas.toArray());

        // Guarda los archivos
        Archivos archivoArchivos = new Archivos("archivos", "txt", rutaArchivos);
        archivoArchivos.escribirArchivo(archivos.toArray());
    }

    public void cargarDatosDesdeArchivos() {
        String rutaClientes = rutaBase + "/clientes.txt";
        String rutaLibros = rutaBase + "/libros.txt";
        String rutaVentas = rutaBase + "/ventas.txt";
        String rutaArchivos = rutaBase + "/archivos.txt";

        // Carga los clientes
        ArchivoClientes archivoClientes = new ArchivoClientes("clientes", "txt", rutaClientes);
        List<Cliente> clientesCargados = archivoClientes.cargar();
        clientes.clear();
        clientes.addAll(clientesCargados);

        // Carga los libros
        ArchivoTexto archivoLibros = new ArchivoTexto("libros", "txt", rutaLibros);
        List<Libros> librosCargados = archivoLibros.cargar();
        libros.clear();
        libros.addAll(librosCargados);

        // Carga las ventas
        Archivos archivoVentas = new Archivos("ventas", "txt", rutaVentas);
        List<Ventas> ventasCargadas = (List<Ventas>) (Object) archivoVentas.leerArchivo(new Ventas[0]);
        ventas.clear();
        ventas.addAll(ventasCargadas);

        // Carga los archivos
        Archivos archivoArchivos = new Archivos("archivos", "txt", rutaArchivos);
        List<Archivos> archivosCargados = (List<Archivos>) (Object) archivoArchivos.leerArchivo(new Archivos[0]);
        archivos.clear();
        archivos.addAll(archivosCargados);
    }
}
