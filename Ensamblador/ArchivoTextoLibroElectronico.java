package Ensamblador;

import Proyecto_Libreria.Libro;

import java.util.List;

public class ArchivoTextoLibroElectronico extends ArchivoTexto{

    @Override
    void guardarLibros(List<Libros> libros) {
        super.guardarLibros(libros);
    }

    @Override
    public List<Libros>  cargar() {
      return   super.cargar();
    }
}
