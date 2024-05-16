package Ensamblador.ArchivoTexto;

import Ensamblador.Libros;

import java.util.List;

public class ArchivoTextoLibroElectronico extends ArchivoTexto{

    public ArchivoTextoLibroElectronico(String nombre, String extension, String ruta) {
        super(nombre, extension, ruta);
    }

    @Override
    void guardarLibros(List<Libros> libros) {
        super.guardarLibros(libros);
    }

    @Override
    public List<Libros>  cargar() {
        return   super.cargar();
    }
}
