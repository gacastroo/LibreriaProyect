package Ensamblador;

import java.io.Serializable;

public class LibroInfantil extends Libros implements Serializable {
    //atributos adicionales
    int edadRecomendada;
    boolean ilustraciones = false;
    int numIlustraciones;

    public LibroInfantil(){}

    public LibroInfantil(int edadRecomendada, boolean ilustraciones, int numIlustraciones) {
        this.edadRecomendada = edadRecomendada;
        this.ilustraciones = ilustraciones;
        this.numIlustraciones = numIlustraciones;
    }

    public LibroInfantil(String titulo, String autor, String genero, double precio, int edadRecomendada, boolean ilustraciones, int numIlustraciones) {
        super(titulo, autor, genero, precio);
        this.edadRecomendada = edadRecomendada;
        this.ilustraciones = ilustraciones;
        this.numIlustraciones = numIlustraciones;
    }

    //métodos adicionales
    public int getEdadRecomendada() {return edadRecomendada;}
    public void setEdadRecomendada(int edadRecomendada) {this.edadRecomendada = edadRecomendada;}
    public boolean tieneIlustraciones() {
        return ilustraciones;
    }
    public void setIlustraciones(boolean ilustraciones) {
        this.ilustraciones = ilustraciones;
    }

    public int getNumIlustraciones() {
        return numIlustraciones;
    }

    public void setNumIlustraciones(int numIlustraciones) {
        this.numIlustraciones = numIlustraciones;
    }

    public void mostrarIlustraciones (int numIlustraciones){
        System.out.println("Este libro tiene " + numIlustraciones + " ilustraciones.");
    }
    public boolean verificarEdadApta (int edad){
        if (edadRecomendada <= edad){
            System.out.println("Tu edad es apta para la lectura de este libro");
            return true;
        }
        else{
            System.out.println("Lo siento, pero tu edad no es apta para la lectura de este libro");
            return false;
        }
    }

    @Override
    public String toString() {
        return "LibroInfantil{" +
                "edadRecomendada=" + edadRecomendada +
                ", ilustraciones=" + ilustraciones +
                ", numIlustraciones=" + numIlustraciones +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", precio=" + precio +
                "} " + super.toString();
    }
}
