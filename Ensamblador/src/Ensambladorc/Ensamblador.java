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

     protected static ArrayList<Cliente> clientes;
    protected static ArrayList<Libros> libros;
    protected static ArrayList<Archivos> archivos;
    protected static ArrayList<Ventas> ventas;



    public Ensamblador(List<Cliente> clientes, List<Libros> libros, List<Archivos> archivos, List<Ventas> ventas) {
        this.clientes = (ArrayList<Cliente>) clientes;
        this.libros = (ArrayList<Libros>) libros;
        this.archivos = (ArrayList<Archivos>) archivos;
        this.ventas = (ArrayList<Ventas>) ventas;
    }


    public  void add(Cliente cliente)
    {
        clientes.add(cliente);
    }
    public void remove(Cliente cliente)
    {
        this.clientes.remove(cliente);
    }
    public List<Cliente> getClientes() {
        return Collections.unmodifiableList(this.clientes); // Return an unmodifiable copy of the list
    }

    public static List<Libros> getLibros() {
        // Return an unmodifiable copy to prevent direct modification of the internal list
        return libros;
    }

    public List<Archivos> getArchivos() {
        // Return an unmodifiable copy to prevent direct modification of the internal list
        return archivos;
    }

    public List<Ventas> getVentas() {
        // Return an unmodifiable copy to prevent direct modification of the internal list
        return Collections.unmodifiableList(this.ventas);
    }

    public static void setClientes(ArrayList<Cliente> clientes) {
        Ensamblador.clientes = clientes;
    }

    public static void setLibros(ArrayList<Libros> libros) {
        Ensamblador.libros = libros;
    }

    public void setArchivos(ArrayList<Archivos> archivos) {
        this.archivos = archivos;
    }

    public void setVentas(ArrayList<Ventas> ventas) {
        this.ventas = ventas;
    }

    public static void agregarLibro(Libros libro)
    {
        libros.add(libro);
    }

    public void eliminarLibro(Libros libro){
        libros.remove(libro);
    }
    public void agregarArchivo(Archivos archivo){
        this.archivos.add(archivo);
    }
    public void eliminarArchivo(Archivos archivo){
        this.archivos.remove(archivo);
    }
    public void buscarClientePorNombre(Scanner sc){
        System.out.println("Dame el nombre que quieres buscar: ");
        String Nombre=sc.nextLine();
        for (Cliente cliente: clientes){
            if (cliente.getNombre().equals(Nombre)){
                System.out.println("El cliente buscado es" + cliente.getNombre());
            }
        }

    }

    public static ArrayList<Libros> buscarLibroPorTitulo(String titulo, ArrayList<Libros> libros){
        ArrayList<Libros> libros1 = new ArrayList<>();
            for (Libros libro : libros) {
                System.out.println(libro.getAutor());
                if (libro.getTitulo().equals(titulo)) {
                    libros1.add(libro);
                }
            }
        return libros1;
        }
    public void saveDataToFile(String filePath) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(filePath)))) {
            outputStream.writeObject(clientes);
            outputStream.writeObject(libros);
            outputStream.writeObject(archivos);
            outputStream.writeObject(ventas);
        }
    }

    @SuppressWarnings("unchecked") // Suppress warnings for unchecked casts
    public void loadDataFromFile(String filePath) throws IOException, ClassNotFoundException {
        // Create a serialization input stream
        ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(Paths.get(filePath)));

        // Read the lists of clientes, libros, archivos, and ventas from the file
        clientes = (ArrayList<Cliente>) inputStream.readObject();
        libros = (ArrayList<Libros>) inputStream.readObject();
        archivos = (ArrayList<Archivos>)inputStream.readObject();
        // Close the input stream
        inputStream.close();
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
