package Ensamblador.ArchivoTexto;

import Ensamblador.Libros;

import java.util.List;

public class ArchivoTextoLibroFisico extends ArchivoTexto{
    @Override
    void guardarLibros(List<Libros> libros) {
        super.guardarLibros(libros);
    }

    @Override
    public List<Libros> cargar() {
        return super.cargar();
    }
}
