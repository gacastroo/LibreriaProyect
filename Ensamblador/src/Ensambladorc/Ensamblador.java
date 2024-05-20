package Ensamblador.Ensambladorc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import Ensamblador.Archivos.Archivos;
import Ensamblador.Clientess.Cliente;
import Ensamblador.Librosc.Libros;
import Ensamblador.Ventass.Ventas;

public class Ensamblador implements Serializable {

    protected static ArrayList<Cliente> clientes = new ArrayList<>();
    protected static ArrayList<Libros> libros = new ArrayList<>();
    protected static ArrayList<Archivos> archivos = new ArrayList<>();
    protected static ArrayList<Ventas> ventas = new ArrayList<>();

    public Ensamblador(List<Cliente> clientes, List<Libros> libros, List<Archivos> archivos, List<Ventas> ventas) {
        this.clientes = new ArrayList<>(clientes);
        this.libros = new ArrayList<>(libros);
        this.archivos = new ArrayList<>(archivos);
        this.ventas = new ArrayList<>(ventas);
    }

    public static void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public static void eliminarCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public static List<Cliente> getClientes() {
        return Collections.unmodifiableList(clientes);
    }

    public static List<Libros> getLibros() {
        return Collections.unmodifiableList(libros);
    }

    public static void setClientes(ArrayList<Cliente> clientes) {
        Ensamblador.clientes = clientes;
    }

    public static void setLibros(ArrayList<Libros> libros) {
        Ensamblador.libros = libros;
    }

    public static void agregarLibro(Libros libro) {
        libros.add(libro);
    }

    public static void eliminarLibro(Libros libro) {
        libros.remove(libro);
    }

    public void agregarArchivo(Archivos archivo) {
        archivos.add(archivo);
    }

    public void eliminarArchivo(Archivos archivo) {
        archivos.remove(archivo);
    }

    public void saveDataToFile(String filePath) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(filePath)))) {
            outputStream.writeObject(clientes);
            outputStream.writeObject(libros);
            outputStream.writeObject(archivos);
            outputStream.writeObject(ventas);
        }
    }

    @SuppressWarnings("unchecked")
    public void loadDataFromFile(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(Paths.get(filePath)))) {
            clientes = (ArrayList<Cliente>) inputStream.readObject();
            libros = (ArrayList<Libros>) inputStream.readObject();
            archivos = (ArrayList<Archivos>) inputStream.readObject();
            ventas = (ArrayList<Ventas>) inputStream.readObject();
        }
    }

    public static String generarInformeClientes(EnsambladorReportes reportes) {
        System.out.println("Generando reporte de clientes:");
        return reportes.generarReporteClientes();
    }

    public static String generarInformeLibros(EnsambladorReportes reportes) {
        System.out.println("Generando reporte de libros:");
        return reportes.generarReporteLibros();
    }

    public static String generarInformeVentas(EnsambladorReportes reportes) {
        System.out.println("Generando reporte de ventas:");
        return reportes.generarReporteVentas();
    }
}
