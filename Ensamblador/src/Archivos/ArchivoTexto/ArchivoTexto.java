package Ensamblador.Archivos.ArchivoTexto;

import Ensamblador.Archivos.Archivos;
import Ensamblador.Librosc.*;

import java.io.*;
import java.util.*;
public class ArchivoTexto extends Archivos {
    List <String> registro = new ArrayList<>();

    public ArchivoTexto(String nombre, String extension, String ruta) {
        super(nombre, extension, ruta);
    }

    void guardarLibros(List<Libros> libros) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(super.getRuta()))) {
            for (Libros libro : libros) {
                // Determinar el tipo de libro y guardar en el archivo
                switch (libro.getClass().getSimpleName()) {
                    case "LibroAudio" -> {
                        LibroAudio libroAudio = (LibroAudio) libro;
                        bw.write("Audio,");
                        String datos = libro.getTitulo() + "," + libro.getAutor() + "," + libro.getGenero() + "," +
                                libro.getPrecio() + "," + libroAudio.getDuracion() + "," + libroAudio.getIdioma()+ "," + libroAudio.getTasa();


                        bw.write(datos);
                        bw.newLine();

                        registro.add(libroAudio.toString());


                    }
                    case "LibroInfantil" -> {
                        LibroInfantil libroInfantil = (LibroInfantil) libro;
                        bw.write("Infantil,");
                        String datos = libro.getTitulo() + "," + libro.getAutor() + "," + libro.getGenero() + "," + libro.getPrecio() + "," +
                                libroInfantil.getEdadRecomendada() + "," + libroInfantil.tieneIlustraciones() + "," + libroInfantil.getNumIlustraciones();

                        bw.write(datos);
                        bw.newLine(); // Nueva línea para el próximo libro

                        registro.add("Infantil," + datos);

                    }
                    case "LibroElectronico" -> {
                        bw.write("Electronico,");
                        LibroElectronico libroElectronico = (LibroElectronico) libro;
                        String datos = libro.getTitulo() + "," + libro.getAutor() + "," + libro.getGenero() + "," + libro.getPrecio() + "," +
                                libroElectronico.getFormato();

                        bw.write(datos);
                        registro.add("Electronico," + datos);


                    }
                    case "LibroFisico" -> {
                        LibroFisico libroFisico = (LibroFisico) libro;
                        bw.write("Fisico,");
                        String datos = libro.getTitulo() + "," + libro.getAutor() + "," + libro.getGenero() + "," +
                                libro.getPrecio() + "," + libroFisico.getUbicacion() + "," + libroFisico.getNumeroCopias();

                        bw.write(datos);
                        bw.newLine();


                    }
                    default ->
                            System.out.println("tipo de libro no encontrado"); // Puedes agregar más tipos de libros según sea necesario
                }

            }
        } catch (IOException e) {
            System.out.println("archivo no encontrado IOException ");
        }
    }
    public List<Libros> cargar() {
        List<Libros> libros = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(super.getRuta()))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datosLibro = linea.split(",");


                if (datosLibro.length >= 5) {
                    String tipoLibro = datosLibro[0].trim(); // Primer campo indica el tipo de libro
                    String titulo = datosLibro[1].trim();
                    String autor = datosLibro[2].trim();
                    String genero = datosLibro[3].trim();
                    double id = Double.parseDouble(datosLibro[4].trim());

                    Libros libro;
                    // Crear el tipo correcto de libro según el tipo registrado en el archivo
                    switch (tipoLibro) {
                        case "Audio":
                            int duracion = Integer.parseInt(datosLibro[5].trim());

                            String idioma = datosLibro[6].trim(); // Obtener el idioma del libro de la posición correcta
                            String tasa = datosLibro[7].trim();
                            libro = new LibroAudio(titulo, autor, genero, id, duracion, idioma);
                            libros.add(libro);
                            break;
                        case "Infantil":
                            int edadRecomendada = Integer.parseInt(datosLibro[5].trim()); // Obtener la edad recomendada
                            boolean ilustraciones = Boolean.parseBoolean(datosLibro[6].trim()); // Obtener si tiene ilustraciones
                            int numIlustraciones = Integer.parseInt(datosLibro[7].trim()); // Obtener el número de ilustraciones
                            libro = new LibroInfantil(titulo, autor, genero, id, edadRecomendada, ilustraciones, numIlustraciones);
                            libros.add(libro);
                            break;
                        case "Electronico":
                            String formato = datosLibro[5].trim(); // Obtener el formato del libro electrónico
                            libro = new LibroElectronico(titulo, autor, genero, id, formato);
                            libros.add(libro);
                            break;
                        case "Fisico":
                            String ubicacion = datosLibro[5].trim(); // Obtener la ubicación física del libro
                            int numCopias = Integer.parseInt(datosLibro[6]);
                            libro = new LibroFisico(titulo, autor, genero, id, ubicacion);
                            ((LibroFisico) libro).setNumeroCopias(numCopias);
                            libros.add(libro);

                            break;
                        default:
                            // Manejo de otros tipos de libros
                            System.out.println("tipo de libro no encontrado");
                            break;
                    }

                } else {
                    System.out.println("La línea no tiene suficientes datos para crear un libro: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("archivo no encontrado IOException ");
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir datos numéricos: " + e.getMessage());
        }

        return libros;
    }

}