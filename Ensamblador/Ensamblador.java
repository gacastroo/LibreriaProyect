package Ensamblador;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import Ensamblador.Libros;
import Ensamblador.Cliente;

public class Ensamblador {
     public ArrayList<Cliente> clientes;
     public ArrayList<Libros> libros;
     public ArrayList<Archivos> archivos;
    public ArrayList<Ventas> ventas;



    public Ensamblador(List<Cliente> clientes, List<Libros> libros, List<Archivos> archivos, List<Ventas> ventas) {
        this.clientes = (ArrayList<Cliente>) clientes;
        this.libros = (ArrayList<Libros>) libros;
        this.archivos = (ArrayList<Archivos>) archivos;
        this.ventas = (ArrayList<Ventas>) ventas;
    }


    public void add(Cliente cliente)
    {
        this.clientes.add(cliente);
    }
    public void remove(Cliente cliente)
    {
        this.clientes.remove(cliente);
    }
    public List<Cliente> getClientes() {
        return Collections.unmodifiableList(this.clientes); // Return an unmodifiable copy of the list
    }

    public List<Libros> getLibros() {
        // Return an unmodifiable copy to prevent direct modification of the internal list
        return Collections.unmodifiableList(this.libros);
    }

    public List<Archivos> getArchivos() {
        // Return an unmodifiable copy to prevent direct modification of the internal list
        return Collections.unmodifiableList(this.archivos);
    }

    public List<Ventas> getVentas() {
        // Return an unmodifiable copy to prevent direct modification of the internal list
        return Collections.unmodifiableList(this.ventas);
    }
    public void agregarLibro(Libros libro)
    {
        this.libros.add(libro);
    }

    public void eliminarLibro(Libros libro){
        this.libros.remove(libro);
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
        for (Cliente clientes: clientes){
            if (Cliente.getNombre().equals(Nombre)){
                System.out.println("El cliente buscado es" + Cliente.nombre);
            }
        }

    }
    public static Object buscarLibroPorTitulo(String titulo, ArrayList<Libros> libros){
            for (Libros libro : libros) {
                if (Objects.equals(Libros.getTitulo(), titulo)) {
                    return libros;
                }
            }
            return null;
        }
    public void saveDataToFile(String filePath) throws IOException {
        // Create a serialization output stream
        ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(filePath)));

        // Write the list of clientes, libros, archivos, and ventas to the file
        outputStream.writeObject(clientes);
        outputStream.writeObject(libros);
        outputStream.writeObject(archivos);
        outputStream.writeObject(ventas);

        // Close the output stream
        outputStream.close();
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

    public void generarInforme(EnsambladorReportes reportes, Scanner sc) throws IllegalStateException {
        System.out.println("Elige una opcion para el reporte: ");
        System.out.println("Opcion 1: Generar reporte de clientes");
        System.out.println("Opcion 2: Generar reporte de libros");
        System.out.println("Opcion 3: Generar reporte de ventas");
        int o= sc.nextInt();

        switch (o) {
            case 1:
                reportes.generarReporteClientes();
                break;
            case 2:
                reportes.generarReporteLibros();
                break;
            case 3:
                reportes.generarReporteVentas();
                break;
            default:
                System.out.println("Opcion incorrecta");
        }
    }
}
