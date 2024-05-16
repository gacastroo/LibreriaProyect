package Ensamblador.TipoLibros;

import Ensamblador.Libros;

import java.io.Serializable;

public class LibroElectronico extends Libros implements Serializable {
    String formato;

    public LibroElectronico() {
        super("El Señor de los Anillos", "J.R.R. Tolkien","novela", 12.5);
    }

    public LibroElectronico(String formato) {
        super("El Señor de los Anillos", "J.R.R. Tolkien","novela", 3);
        this.formato = formato;
    }

    public LibroElectronico(String titulo, String autor, String genero, double precio, String formato) {
        super(titulo, autor, genero, precio);
        this.formato = formato;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public boolean verificarCompatibilidadDispositivo(String dispositivo) {
        switch (dispositivo.toLowerCase()) {
            case "ebook":
                if (formato.equalsIgnoreCase("pdf") || formato.equalsIgnoreCase("epub") || formato.equalsIgnoreCase("txt")) {
                    return true;
                }
                break;
            case "movil", "tablet":
                if (formato.equalsIgnoreCase("pdf") || formato.equalsIgnoreCase("txt")) {
                    return true;
                }
                break;
            default:
                System.out.println("Dispositivo no reconocido");
                break;
        }
        return false;
    }


    public void convertirAFormato(String formatoNuevo) {
        if (formatoNuevo == formato) {
            System.out.println("ha elejido el mismo formato");
        } else System.out.println("su libro ha sido convertido correctamente a: " + formatoNuevo);
        formato = formatoNuevo;
    }
}

