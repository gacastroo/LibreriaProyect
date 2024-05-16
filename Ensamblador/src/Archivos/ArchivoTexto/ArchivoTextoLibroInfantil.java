package Ensamblador.Archivos.ArchivoTexto;

import Ensamblador.Librosc.Libros;
import java.util.List;

public class ArchivoTextoLibroInfantil extends ArchivoTexto {

    public ArchivoTextoLibroInfantil(String nombre, String extension, String ruta) {
        super(nombre, extension, ruta);
    }

    @Override
    void guardarLibros(List<Libros> libros) {
        super.guardarLibros(libros);
    }

    @Override
    public List<Libros> cargar() {
        List<Libros> libros = super.cargar(); // Llama al método cargar() de la superclase

        // Aquí puedes realizar cualquier procesamiento adicional necesario para los libros infantiles

        return libros;

    }
}
