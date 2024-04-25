package Ensamblador;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Ensamblador {
     ArrayList<Cliente> clientes;
     ArrayList<Libros> libros;
     ArrayList<Archivos> archivos;
    ArrayList<Ventas> ventas;



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
            if (clientes.getNombre().equals(Nombre)){
                System.out.println(STR."El cliente buscado es\{clientes.getNombre()}");
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
    public void guardarDatosEnArchivo(Ensambladorarchivos archivo) {

    }
    public void cargarDatosDesdeArchivo(Ensambladorarchivos archivo) {

    }
    public void generarInforme() {
        //
    }


}
