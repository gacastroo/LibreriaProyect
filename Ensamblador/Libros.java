package Ensamblador;

import java.io.Serializable;
import java.util.List;

public abstract class Libros  implements Serializable {

    protected static String titulo;
    protected String autor;
    protected String genero;
    protected double precio;

    public Libros(){}

    public Libros(String titulo, String autor, String genero, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.precio = precio;
    }

    public static String getTitulo() {return titulo;}

    public void setTitulo(String titulo) {this.titulo = titulo;}

    public String getAutor() {return autor;}

    public void setAutor(String autor) {this.autor = autor;}

    public String getGenero() {return genero;}

    public void setGenero(String genero) {this.genero = genero;}

    public double getPrecio() {return precio;}

    public void setPrecio(double precio) {this.precio = precio;}

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", precio=" + precio +
                '}';
    }

    //descuento se representa en por ciento
    public double calcularPrecioConDescuento(double descuento){
        return precio-(precio * descuento / 100);
    }

    public void buscarPorAutor(List<Libros> libros, String autor){
        libros.stream().filter(libro -> libro.getAutor().equalsIgnoreCase(autor)).forEach(System.out::println);
    }

    public void filtrarPorGenero(List<Libros> libros, String genero){
        libros.stream().filter(libro -> libro.getGenero().equalsIgnoreCase(genero)).forEach(System.out::println);
    }
}
