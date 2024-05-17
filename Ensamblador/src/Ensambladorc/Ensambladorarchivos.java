package Ensamblador.Ensambladorc;

import Ensamblador.Archivos.Archivos;
import Ensamblador.Clientess.Cliente;
import Ensamblador.Librosc.*;
import Ensamblador.Ventass.Ventas;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


//subclase de ensamblador :D
public class Ensambladorarchivos extends Ensamblador  {

    public Ensambladorarchivos(List<Cliente> clientes, List<Libros> libros, List<Archivos> archivos, List <Ventas> ventas) {
        super(clientes, libros, archivos, ventas);
    }



    public String guardarDatosEnArchivo(String nombreArchivo, String datos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            bw.write(datos);
            return nombreArchivo + "Archivo Guardado";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al guardar el archivo";
        }
    }

    public String cargarDatosDesdeArchivo(String nombreArchivo) {
        StringBuilder datos = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                datos.append(linea);
            }
            return datos.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al cargar el archivo";
        }
    }



    //Metodo por tipo de Libro --> Archivo Pendiente
    List <String> registro = new ArrayList<>();
    public void guardarLibros(List<Libros> libros) {
        List<String> registro = new ArrayList<>();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Archivos.getRuta()))) {
            for (Libros libro : libros) {
                // Determinar el tipo de libro y guardar en el archivo
                switch (libro.getClass().getSimpleName()) {
                    case "LibroAudio":
                        LibroAudio libroAudio = (LibroAudio) libro;
                        bw.write("Audio,");
                        String datosAudio = libro.getTitulo() + "," + libro.getAutor() + "," + libro.getGenero() + "," +
                                libro.getPrecio() + "," + libroAudio.getDuracion() + "," + libroAudio.getIdioma()+ "," + libroAudio.getTasa();

                        bw.write(datosAudio);
                        bw.newLine();
                        registro.add(libroAudio.toString());
                        break;

                    case "LibroInfantil":
                        LibroInfantil libroInfantil = (LibroInfantil) libro;
                        bw.write("Infantil,");
                        String datosInfantil = libro.getTitulo() + "," + libro.getAutor() + "," + libro.getGenero() + "," + libro.getPrecio() + "," +
                                libroInfantil.getEdadRecomendada() + "," + libroInfantil.tieneIlustraciones() + "," + libroInfantil.getNumIlustraciones();

                        bw.write(datosInfantil);
                        bw.newLine();
                        registro.add("Infantil," + datosInfantil);
                        break;

                    case "LibroElectronico":
                        bw.write("Electronico,");
                        LibroElectronico libroElectronico = (LibroElectronico) libro;
                        String datosElectronico = libro.getTitulo() + "," + libro.getAutor() + "," + libro.getGenero() + "," + libro.getPrecio() + "," +
                                libroElectronico.getFormato();

                        bw.write(datosElectronico);
                        bw.newLine();
                        registro.add("Electronico," + datosElectronico);
                        break;

                    case "LibroFisico":
                        LibroFisico libroFisico = (LibroFisico) libro;
                        bw.write("Fisico,");
                        String datosFisico = libro.getTitulo() + "," + libro.getAutor() + "," + libro.getGenero() + "," +
                                libro.getPrecio() + "," + libroFisico.getUbicacion() + "," + libroFisico.getNumeroCopias();

                        bw.write(datosFisico);
                        bw.newLine();
                        break;

                    default:
                        System.out.println("Tipo de libro no encontrado");
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al guardar en el archivo: " + e.getMessage());
        }
    }

    public void guardarLibro(Libros libro) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Archivos.getRuta()))) {

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

        } catch (IOException e) {
            System.out.println("archivo no encontrado IOException ");
        }
    }
    public List<Libros> cargar() {
        try (BufferedReader br = new BufferedReader(new FileReader(Archivos.getRuta()))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datosLibro = linea.split(",");


                if (datosLibro.length >= 5) {
                    String tipoLibro = datosLibro[0].trim(); // Primer campo indica el tipo de libro
                    String titulo = datosLibro[1].trim();
                    String autor = datosLibro[2].trim();
                    String genero = datosLibro[3].trim();
                    double precio = Double.parseDouble(datosLibro[4].trim());

                    Libros libro;
                    // Crear el tipo correcto de libro según el tipo registrado en el archivo
                    switch (tipoLibro) {
                        case "Audio":
                            int duracion = Integer.parseInt(datosLibro[5].trim());

                            String idioma = datosLibro[6].trim(); // Obtener el idioma del libro de la posición correcta
                            String tasa = datosLibro[7].trim();
                            libro = new LibroAudio(titulo, autor, genero, precio, duracion, idioma);
                            libros.add(libro);
                            break;
                        case "Infantil":
                            int edadRecomendada = Integer.parseInt(datosLibro[5].trim()); // Obtener la edad recomendada
                            boolean ilustraciones = Boolean.parseBoolean(datosLibro[6].trim()); // Obtener si tiene ilustraciones
                            int numIlustraciones = Integer.parseInt(datosLibro[7].trim()); // Obtener el número de ilustraciones
                            libro = new LibroInfantil(titulo, autor, genero, precio, edadRecomendada, ilustraciones, numIlustraciones);
                            libros.add(libro);
                            break;
                        case "Electronico":
                            String formato = datosLibro[5].trim(); // Obtener el formato del libro electrónico
                            libro = new LibroElectronico(titulo, autor, genero, precio, formato);
                            libros.add(libro);
                            break;
                        case "Fisico":
                            String ubicacion = datosLibro[5].trim(); // Obtener la ubicación física del libro
                            int numCopias = Integer.parseInt(datosLibro[6]);
                            libro = new LibroFisico(titulo, autor, genero, precio, ubicacion);
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
