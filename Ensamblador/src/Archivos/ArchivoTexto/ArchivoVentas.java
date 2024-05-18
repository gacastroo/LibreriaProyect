package Ensamblador.Archivos.ArchivoTexto;

import Ensamblador.Librosc.Libros;
import Ensamblador.Librosc.LibroAudio;
import Ensamblador.Librosc.LibroElectronico;
import Ensamblador.Librosc.LibroFisico;
import Ensamblador.Librosc.LibroInfantil;
import Ensamblador.Clientess.*;
import Ensamblador.Ventass.Ventas;
import Ensamblador.Clientess.Cliente;
import Ensamblador.Archivos.Archivos;
import Ensamblador.Ventass.Vendedor;
import Ensamblador.Ventass.VentaMayorista;
import Ensamblador.Ventass.VentaOnline;
import Ensamblador.Ventass.VentaPresencial;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArchivoVentas extends Archivos{
    ArrayList<Ventas> ventas = new ArrayList<>();

    public ArchivoVentas(String nombre, String extension, String ruta) {
        super(nombre, extension, ruta);
    }

    public void guardar(List<Ventas> ventasGuardar){
        File file = new File(super.getRuta());
        try{
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);


            for (Ventas  v: ventasGuardar) {
                String datos = "";

                switch (v.getClass().getSimpleName()){
                    case "Venta"->{
                        datos += "Venta,";
                        datos += v.getDescuento() + "," + v.getIdVentas() + "," + v.getPrecio()
                                + "," + v.getFechaVentas().getYear() + "," + v.getFechaVentas().getMonthValue()+ "," + v.getFechaVentas().getDayOfMonth()+
                                "," + v.getFechaEntrega().getYear() + "," + v.getFechaEntrega().getMonthValue() +","+ v.getFechaEntrega().getDayOfMonth();
                        bw.write(datos);
                    }
                    case "VentaMayorista" ->{
                        datos += "VentaMayorista,";
                        datos += v.getDescuento() + "," + v.getIdVentas() + "," + v.getPrecio()
                                + "," + v.getFechaVentas().getYear() + "," + v.getFechaVentas().getMonthValue()+ "," + v.getFechaVentas().getDayOfMonth()+
                                "," + v.getFechaEntrega().getYear() + "," + v.getFechaEntrega().getMonthValue() +","+ v.getFechaEntrega().getDayOfMonth();
                        bw.write(datos);
                    }
                    case "VentaOnline" ->{
                        datos +="VentaOnline,";
                        datos += v.getDescuento() + "," + v.getIdVentas() + "," + v.getPrecio()
                                + "," + v.getFechaVentas().getYear() + "," + v.getFechaVentas().getMonthValue()+ "," + v.getFechaVentas().getDayOfMonth()+
                                "," + v.getFechaEntrega().getYear() + "," + v.getFechaEntrega().getMonthValue() +","+ v.getFechaEntrega().getDayOfMonth();
                        bw.write(datos);
                    }
                    case "VentaPresencial" -> {
                        datos += "VentaPresencial,";
                        datos += v.getDescuento() + "," + v.getIdVentas() + "," + v.getPrecio()
                                + "," + v.getFechaVentas().getYear() + "," + v.getFechaVentas().getMonthValue()+ "," + v.getFechaVentas().getDayOfMonth();
                        bw.write(datos);
                        bw.newLine();
                        VentaPresencial vp = (VentaPresencial) v;
                        Vendedor vendedor = vp.getVendedor();
                        bw.write(vendedor.getNombre() + "," +vendedor.getApellido() + "," + vendedor.getDireccion() +
                                "," + vendedor.getTelefono() + "," + vendedor.getEmail());
                    }
                }

                bw.newLine();
                escribirCliente(bw, v.getCliente());
                escribirLibros(bw, v.getLibrosVendidos());
                bw.write("fin");
                bw.newLine();

            }
            bw.close();
            fw.close();

        }catch (IOException e){
            System.out.println("error en el metodo guardar clase AchivoVentas, culpa : Jaime");
        }
    }
    public ArrayList<Ventas> cargar(){
        Scanner sc = new Scanner(System.in);
        File file = new File(super.getRuta());
        ArrayList<Ventas> ventas1 = new ArrayList<>();
        Vendedor vendedor = null;
        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            while (2+2 != 5){
                String atributo = br.readLine();
                if (atributo == null) break;
                String[] atributos = atributo.split(",");


                Ventas venta = new Ventas();
                double Descuento = Double.parseDouble(atributos[1]);
                int idVenta = (Integer.parseInt(atributos[2]));
                double Precio = (Double.parseDouble(atributos[3]));
                LocalDate fechaDeVenta = LocalDate.of(Integer.parseInt(atributos[4]), Integer.parseInt(atributos[5]), Integer.parseInt(atributos[6]));
                if (atributos[0].equals("VentaPresencial")){
                    String[] vendedorAtrib = br.readLine().split(",");
                    vendedor = new Vendedor(vendedorAtrib[0], vendedorAtrib[1], vendedorAtrib[2], vendedorAtrib[3],vendedorAtrib[4]);
                }




                Cliente cliente = leerCliente(br);
                List<Libros> librosVendidos = new ArrayList<>();



                while (true) {
                    String libross = br.readLine();
                    if (libross.equals("fin")) break;
                    System.out.println(libross);
                    librosVendidos.add(leerLibro(libross));

                }
                venta.setLibroVendidos(librosVendidos);






                switch (atributos[0]){
                    case "Venta" ->{
                        venta = new Ventas(fechaDeVenta, librosVendidos,cliente);
                        venta.setFechaEntrega(LocalDate.of(Integer.parseInt(atributos[7]), Integer.parseInt(atributos[8]), Integer.parseInt(atributos[9])));
                    }
                    case "VentaMayorista" ->{
                        venta = new VentaMayorista(fechaDeVenta,librosVendidos, cliente);
                        venta.setFechaEntrega(LocalDate.of(Integer.parseInt(atributos[7]), Integer.parseInt(atributos[8]), Integer.parseInt(atributos[9])));
                    }
                    case "VentaOnline" ->{
                        venta = new VentaOnline(fechaDeVenta,librosVendidos, cliente);
                        venta.setFechaEntrega(LocalDate.of(Integer.parseInt(atributos[7]), Integer.parseInt(atributos[8]), Integer.parseInt(atributos[9])));
                    }
                    case"VentaPresencial" -> venta = new VentaPresencial(fechaDeVenta, librosVendidos,cliente, vendedor);
                }
                venta.setDescuento(Descuento);
                venta.setIdVentas(idVenta);
                venta.setPrecio(Precio);
                ventas1.add(venta);
            }
            ventas = ventas1;
        }catch (IOException e){
            System.out.println("hubo un error IOException");
        }
        return ventas1;
    }







    private void escribirCliente(BufferedWriter bw, Cliente cliente){
        try{
            String datosCliente = cliente.getClass().getSimpleName() +"," + cliente.getNombre() + "," +
                    cliente.getDireccion() + "," + cliente.getEmail() + "," +
                    cliente.getFechaRegistro().getDayOfMonth() + "," + cliente.getFechaRegistro().getMonthValue() + "," + cliente.getFechaRegistro().getYear() + "," +
                    cliente.getIdCliente() + "," + cliente.getNumTelefono() + "," + cliente.getPuntosFidelidad() + "," + cliente.getTipoCliente();


            bw.write(datosCliente);
            bw.newLine();
        }catch (Exception e){
            System.out.println("Error en Archivo ventas, metodo: escribirCliente");
        }
    }

    private void escribirLibros(BufferedWriter bw, List<Libros> libros){
        try{
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


                    }
                    case "LibroInfantil" -> {
                        LibroInfantil libroInfantil = (LibroInfantil) libro;
                        bw.write("Infantil,");
                        String datos = libro.getTitulo() + "," + libro.getAutor() + "," + libro.getGenero() + "," + libro.getPrecio() + "," +
                                libroInfantil.getEdadRecomendada() + "," + libroInfantil.tieneIlustraciones() + "," + libroInfantil.getNumIlustraciones();

                        bw.write(datos);
                        bw.newLine(); // Nueva línea para el próximo libro

                    }
                    case "LibroElectronico" -> {
                        bw.write("Electronico,");
                        LibroElectronico libroElectronico = (LibroElectronico) libro;
                        String datos = libro.getTitulo() + "," + libro.getAutor() + "," + libro.getGenero() + "," + libro.getPrecio() + "," +
                                libroElectronico.getFormato();
                        bw.write(datos);

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


    //LISTO
    private Cliente leerCliente(BufferedReader br){
        String linea = "";
        try {
            linea = br.readLine();
        }catch (IOException e){
            System.out.println("linea no encontrada");
        }

        String[] datosCliente = linea.split(",");

        if (datosCliente.length >= 7) {
            String tipoCliente = datosCliente[0].trim();
            String nombre = datosCliente[1].trim();
            String direccion = datosCliente[2].trim();
            String email = datosCliente[3].trim();
            LocalDate fechaRegistro = LocalDate.of(Integer.parseInt(datosCliente[6]),
                    Integer.parseInt(datosCliente[5]),Integer.parseInt(datosCliente[4]));
            int idCliente = Integer.parseInt(datosCliente[7]);
            String numero = datosCliente[8];
            int puntosFidelidad = Integer.parseInt(datosCliente[9]);
            int tipoClientenInt = Integer.parseInt(datosCliente[10]);

            Cliente cliente;

            switch (tipoCliente) {
                case "Cliente" :
                    cliente = new Cliente(nombre,direccion,email,numero,fechaRegistro);
                    cliente.setTipoCliente(tipoClientenInt);
                    cliente.setPuntosFidelidad(puntosFidelidad);
                    cliente.setIdCliente(idCliente);
                    return cliente;
                case "ClienteInternacional":
                    cliente = new ClienteInternacional(nombre,direccion,email,numero,fechaRegistro);
                    cliente.setTipoCliente(tipoClientenInt);
                    cliente.setPuntosFidelidad(puntosFidelidad);
                    cliente.setIdCliente(idCliente);
                    return cliente;

                case "ClienteMayorista":
                    cliente = new ClienteMayorista(nombre,direccion,email,numero,fechaRegistro);
                    cliente.setTipoCliente(tipoClientenInt);
                    cliente.setPuntosFidelidad(puntosFidelidad);
                    cliente.setIdCliente(idCliente);
                    return cliente;

                case "ClienteOnline":
                    cliente = new ClienteOnline(nombre,direccion,email,numero,fechaRegistro);
                    cliente.setTipoCliente(tipoClientenInt);
                    cliente.setPuntosFidelidad(puntosFidelidad);
                    cliente.setIdCliente(idCliente);
                    return cliente;

                case "ClienteRegular":
                    cliente = new ClienteRegular(nombre,direccion,email,numero,fechaRegistro);
                    cliente.setTipoCliente(tipoClientenInt);
                    cliente.setPuntosFidelidad(puntosFidelidad);
                    cliente.setIdCliente(idCliente);
                    return cliente;

                case "ClienteVIP":
                    cliente = new ClienteVIP(nombre,direccion,email,numero,fechaRegistro);
                    cliente.setTipoCliente(tipoClientenInt);
                    cliente.setPuntosFidelidad(puntosFidelidad);
                    cliente.setIdCliente(idCliente);
                    return cliente;

                default:
                    System.out.println("Tipo de cliente no reconocido: " + tipoCliente);
                    break;
            }


        } else {
            System.out.println("La línea no tiene suficientes datos para crear un cliente: " + linea);
        }
        return null;
    }

    private Libros leerLibro(String infoLibro) { ////////////////CORREGIR AQUÍ CUANDO REGRESE
        String[] datosLibro = infoLibro.split(",");
        if (datosLibro.length >= 2) {
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
                    libro = new LibroAudio(titulo, autor, genero, precio, duracion, idioma,tasa);
                    return libro;
                case "Infantil":
                    int edadRecomendada = Integer.parseInt(datosLibro[5].trim()); // Obtener la edad recomendada
                    boolean ilustraciones = Boolean.parseBoolean(datosLibro[6].trim()); // Obtener si tiene ilustraciones
                    int numIlustraciones = Integer.parseInt(datosLibro[7].trim()); // Obtener el número de ilustraciones
                    libro = new LibroInfantil(titulo, autor, genero, precio, edadRecomendada, ilustraciones, numIlustraciones);

                    return libro;
                case "Electronico":
                    String formato = datosLibro[5].trim(); // Obtener el formato del libro electrónico
                    libro = new LibroElectronico(titulo, autor, genero, precio, formato);

                    return libro;
                case "Fisico":
                    String ubicacion = datosLibro[5].trim(); // Obtener la ubicación física del libro
                    int numCopias = Integer.parseInt(datosLibro[6]);
                    libro = new LibroFisico(titulo, autor, genero, precio, ubicacion);
                    ((LibroFisico) libro).setNumeroCopias(numCopias);


                    return libro;
                default:
                    // Manejo de otros tipos de libros
                    System.out.println("tipo de libro no encontrado");
                    break;
            }

        } else {
            System.out.println("La línea no tiene suficientes datos para crear un libro: " + infoLibro);
        }
        return null;
    }
}