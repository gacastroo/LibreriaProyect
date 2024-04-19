package Ensamblador;

import java.io.*;

//subclase de ensamblador :D
public class Ensamblador_archivos extends Ensamblador {
    public void guardarDatosEnArchivo(String nombreArchivo, String datos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write(datos);
            System.out.println("Datos guardados correctamente en el archivo \"" + nombreArchivo + "\"");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en el archivo \"" + nombreArchivo + "\":");
            e.printStackTrace();
        }
    }

    public String cargarDatosDesdeArchivo(String nombreArchivo) {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea);
                contenido.append("\n");
            }
            System.out.println("Archivo \"" + nombreArchivo + "\" cargado correctamente");
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo \"" + nombreArchivo + "\":");
            e.printStackTrace();
        }
        return contenido.toString();
    }
}