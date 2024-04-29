package Ensamblador;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Ensamblador {
     ArrayList<Cliente> clientes;
     ArrayList<Libros> libros;
     ArrayList<Archivos> archivos;
    ArrayList<Ventas> venta;



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
                System.out.println("El cliente buscado es" + clientes.getNombre());
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
    public void guardarDatosEnArchivo(Archivos archivos) {
        Object[] Archivo = new Object[0];
        new Archivos().escribirArchivo(Archivo);
        //Modificar
    }
    public void cargarDatosDesdeArchivo(Ensambladorarchivos archivo) {
        //Modificar
    }
    public void generarInforme(EnsambladorReportes reportes, Scanner scanner) throws IllegalStateException {
        System.out.println("Elige una opcion para el reporte: ");
        System.out.println("Opcion 1: Generar reporte de clientes");
        System.out.println("Opcion 2: Generar reporte de libros");
        System.out.println("Opcion 3: Generar reporte de ventas");
        int o= scanner.nextInt();

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
