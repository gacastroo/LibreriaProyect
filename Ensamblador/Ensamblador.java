package Ensamblador;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Ensamblador {
    Scanner sc = new Scanner(System.in);
    private ArrayList<Cliente> clientes;
    private ArrayList<Libros> libros;
    private ArrayList<Archivos> archivos;

    public Ensamblador(List<Cliente> clientes, List<Libros> libros, List<Archivos> archivos) {
        this.clientes = (ArrayList<Cliente>) clientes;
        this.libros = (ArrayList<Libros>) libros;
        this.archivos = (ArrayList<Archivos>) archivos;
    }


    public void add(Cliente cliente)
    {
        Cliente.add(cliente);
    }
    public static void remove(Cliente cliente)
    {
        Cliente.remove(cliente);
    }


    public void agregarLibro(Libros libro)
    {
        Libros.add(libro);
    }

    public void eliminarLibro(Libros libro){
        Libros.remove(libro);
    }
    public void agregarArchivo(Archivos archivo){
        Archivos.add(archivo);
    }
    public void eliminarArchivo(Archivos archivo){
        Archivos.remove(archivo);
    }
    public void buscarClientePorNombre(Scanner sc){
        System.out.println("Dame el nombre que quieres buscar: ");
        String Nombre=sc.nextLine();
        for (Cliente clientes: clientes){
            if (clientes.getNombre().equals(Nombre)){
                System.out.println("El cliente buscado es"+clientes.getNombre());
            }
        }

    }
    public Object buscarLibroPorTitulo(String titulo, ArrayList<Libros> listaLibros) {
            for (Libros libro : listaLibros) {
                if (Objects.equals(Libros.getTitulo(), titulo)) {
                    return libro;
                }
            }
            return null;
        }
    public void guardarDatosEnArchivo(Archivos archivo) {

    }
    public void cargarDatosDesdeArchivo(Archivos archivo) {

    }
    public void generarInforme() {
        this.archivos = new ArrayList<Archivos>();
    }
}
