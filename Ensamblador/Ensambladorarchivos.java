package Ensamblador;

import java.util.List;

//subclase de ensamblador :D
public class Ensambladorarchivos extends Ensamblador {

    public Ensambladorarchivos(List<Cliente> clientes, List<Libros> libros, List<Archivos> archivos) {
        super(clientes, libros, archivos);
    }

    public String guardarDatosEnArchivo(String nombreArchivo, String datos) {
        guardarDatosEnArchivo(nombreArchivo,datos);
        return nombreArchivo + "Archivo Guardado";
    }

    public String cargarDatosDesdeArchivo(String nombreArchivo) {
        cargarDatosDesdeArchivo(nombreArchivo);
        return nombreArchivo + "Archivo Cargado";
    }

    //Metodo por tipo de Libro --> Archivo Pendiente
}
