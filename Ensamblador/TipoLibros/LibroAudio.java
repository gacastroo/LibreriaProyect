package Ensamblador.TipoLibros;

import Ensamblador.Libros;

import java.io.Serializable;
import java.util.Scanner;

public class LibroAudio extends Libros implements Serializable {
    private int duracion;
    private String idioma;
    private String tasa;

    public LibroAudio() {
    }

    public LibroAudio(int duracion, String idioma, String tasa) {
        this.duracion = duracion;
        this.idioma = idioma;
        this.tasa = tasa;
    }

    public LibroAudio(String titulo, String autor, String genero, double precio, int duracion, String idioma, String tasa) {
        super(titulo, autor, genero, precio);
        this.duracion = duracion;
        this.idioma = idioma;
        this.tasa = tasa;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getTasa() {
        return tasa;
    }

    public void setTasa(String tasa) {
        this.tasa = tasa;
    }

    public double calcularTasaBitsAlta() {
        return duracion * 0.8;
    }

    public double calcularTasaBitsBaja() {
        return duracion * 1.2;
    }

    public double calcularTasaBits() {
        if (tasa.equalsIgnoreCase("alta")) {
            return calcularTasaBitsAlta();
        } else if (tasa.equalsIgnoreCase("baja")) {
            return calcularTasaBitsBaja();
        }
        return -1;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", idioma='" + idioma + '\'' +
                ", duracion normal=" + duracion +
                ", duracion real=" + calcularTasaBits();
    }
}
