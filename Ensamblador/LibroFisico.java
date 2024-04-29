package Ensamblador;

import java.io.Serializable;

//comentario prueba

public class LibroFisico extends Libros implements Serializable {

    private String ubicacion; //sala + estanteria + balda
    private int numeroCopias;

    public LibroFisico() {}

    public LibroFisico(String titulo, String autor, String genero, double precio, String ubicacion) {
        super(titulo, autor, genero, precio);
        this.ubicacion = ubicacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getNumeroCopias() {
        return numeroCopias;
    }

    public void setNumeroCopias(int numeroCopias) {
        this.numeroCopias = numeroCopias;
    }

    public int agregarCopias(int cantidad){
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad de copias a agregar es erronea");
        }
        else{
            return this.numeroCopias += cantidad;
        }
    }

    public int eliminarCopias(int cantidad){
        if(cantidad > numeroCopias){
            throw new IllegalArgumentException("El numero de copias a eliminar NO puede ser mayor que el numero de copias existentes");
        }
        else if(cantidad <= 0){
            throw new IllegalArgumentException("La cantidad de copias a eliminar es erronea");
        }
        else{
            return this.numeroCopias -= cantidad;
        }
    }

    @Override
    public String toString() {
        return "LibroFisico{" +
                "ubicacion='" + ubicacion + '\'' +
                ", numeroCopias=" + numeroCopias +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", precio=" + precio +
                '}';
    }
}
