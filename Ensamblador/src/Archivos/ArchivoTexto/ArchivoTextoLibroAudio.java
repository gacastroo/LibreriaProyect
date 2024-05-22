package Ensamblador.Archivos.ArchivoTexto;

import Ensamblador.Librosc.Libros;
import java.util.List;

public class ArchivoTextoLibroAudio extends ArchivoTexto{
    public ArchivoTextoLibroAudio(String nombre, String extension, String ruta) {
        super(nombre, extension, ruta);
    }

    @Override
    public void guardarLibros(List<Libros> libros) {
        super.guardarLibros(libros);
    }

    @Override
    public List<Libros>  cargar() {
        return super.cargar();
    }
}


