package Ensamblador.ArchivoTexto;

import Ensamblador.Libros;
import Ensamblador.TipoLibros.LibroAudio;
import Ensamblador.TipoLibros.LibroElectronico;
import Ensamblador.TipoLibros.LibroFisico;
import Ensamblador.TipoLibros.LibroInfantil;
import Ensamblador.TiposClientes.*;
import Ensamblador.Ventas;
import Ensamblador.Cliente;
import Ensamblador.Archivos;
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
                                + "," + v.getFechaVenta().getYear() + "," + v.getFechaVenta().getMonthValue()+ "," + v.getFechaVenta().getDayOfMonth()+
                                "," + v.getFechaEntrega().getYear() + "," + v.getFechaEntrega().getMonthValue() +","+ v.getFechaVenta().getDayOfMonth();
                        bw.write(datos);
                    }
                    case "VentaMayorista" ->{
                        datos += "VentaMayorista,";
                        datos += v.getDescuento() + "," + v.getIdVenta() + "," + v.getPrecio()
                                + "," + v.getFechaVenta().getYear() + "," + v.getFechaVenta().getMonthValue()+ "," + v.getFechaVenta().getDayOfMonth()+
                                "," + v.getFechaEntrega().getYear() + "," + v.getFechaEntrega().getMonthValue() +","+ v.getFechaVenta().getDayOfMonth();
                        bw.write(datos);
                    }
                    case "VentaOnline" ->{
                        datos +="VentaOnline,";
                        datos += v.getDescuento() + "," + v.getIdVenta() + "," + v.getPrecio()
                                + "," + v.getFechaVenta().getYear() + "," + v.getFechaVenta().getMonthValue() + "," + v.getFechaVenta().getDayOfMonth()+
                                "," + v.getFechaEntrega().getYear() + "," + v.getFechaEntrega().getMonthValue() +","+ v.getFechaVenta().getDayOfMonth();
                        bw.write(datos);
                    }
                    case "VentaPresencial" -> {
                        datos += "VentaPresencial,";
                        datos += v.getDescuento() + "," + v.getIdVenta() + "," + v.getPrecio()
                                + "," + v.getFechaVenta().getYear() + "," + v.getFechaVenta().getMonthValue() + "," + v.getFechaVenta().getDayOfMonth();
                        bw.write(datos);
                        bw.newLine();
                        VentaPresencial vp = (VentaPresencial) v;
                        Vendedor vendedor = vp.getVendedor();
                        bw.write(vendedorToString(vendedor));
                    }
                }

                bw.newLine();
                escribirCliente(bw, v.getCliente());
                escribirLibros(bw, v.getLibrosVendidos());
                bw.newLine();
                bw.write("fin");

            }
            bw.close();
            fw.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public ArrayList<Ventas> cargar(){
        Scanner sc = new Scanner(System.in);
        File file = new File(super.getRuta());
        ArrayList<Ventas> ventas1 = new ArrayList<>();
        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            while (2+2 != 5){
                String atributo = br.readLine();
                if (atributo == null) break;
                String[] atributos = atributo.split(",");

                Vendedor vendedor = null;
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


                String libross = br.readLine();
                do{

                    librosVendidos.add(leerLibro(libross));
                    libross = br.readLine();
                }while (!libross.equals("fin"));
                //venta.setLibroVendidos(librosVendidos);






                switch (atributos[0]){
                    case "Venta" ->{
                        venta = new Ventas(sc,fechaDeVenta, librosVendidos,cliente);
                        venta.setFechaEntrega(LocalDate.of(Integer.parseInt(atributos[7]), Integer.parseInt(atributos[8]), Integer.parseInt(atributos[9])));
                    }
                    case "VentaMayorista" ->{
                        venta = new VentaMayorista(sc, fechaDeVenta,librosVendidos, cliente);
                        venta.setFechaEntrega(LocalDate.of(Integer.parseInt(atributos[7]), Integer.parseInt(atributos[8]), Integer.parseInt(atributos[9])));
                    }
                    case "VentaOnline" ->{
                        venta = new VentaOnline(sc,fechaDeVenta,librosVendidos, cliente);
                        venta.setFechaEntrega(LocalDate.of(Integer.parseInt(atributos[7]), Integer.parseInt(atributos[8]), Integer.parseInt(atributos[9])));
                    }
                    case"VentaPresencial" -> venta = new VentaPresencial(sc, fechaDeVenta, librosVendidos,cliente, vendedor);
                }

                ventas.setDescuento(Descuento);
                venta.setIdVenta(idVenta);
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
            switch (cliente.getClass().getSimpleName()) {

                case "ClienteInternacional" -> {
                    ClienteInternacional clienteInternacional = (ClienteInternacional) cliente;
                    bw.write("ClientesInternacional,");
                    String DatosClienteInternacinal =  cliente.getNombre()+ "," + cliente.getDireccion() + ","
                            +  cliente.getEmail() + "," + cliente.getFechaRegistro() + ","
                            + cliente.getNumTelefono();

                    bw.write(DatosClienteInternacinal);
                    bw.newLine();

                }
                case "ClienteMayorista" -> {
                    ClienteMayorista clienteMayorista = (ClienteMayorista) cliente;
                    bw.write("ClientesMayorista,");
                    String DatosClienteMayorista = cliente.getNombre() + "," +  cliente.getDireccion()
                            + "," + cliente.getEmail() + "," + cliente.getFechaRegistro() + ","
                            + cliente.getNumTelefono();
                    bw.write(DatosClienteMayorista);
                    bw.newLine();
                }
                case "ClienteOnline" -> {
                    ClienteOnline clienteOnline = (ClienteOnline) cliente;
                    bw.write("ClienteOnline,");
                    String DatosClientesOnline =  cliente.getNombre() + "," + cliente.getDireccion()
                            + "," + cliente.getEmail() + ","  + cliente.getFechaRegistro()
                            +  "," + cliente.getNumTelefono();
                    bw.write(DatosClientesOnline);
                    bw.newLine();

                }
                case "ClienteRegular" -> {
                    ClienteRegular clienteRegular = (ClienteRegular) cliente;
                    bw.write("ClienteRegular,");
                    String DatosClientesRegular = cliente.getNombre() + "," + cliente.getDireccion()
                            + "," + cliente.getEmail() + "," + cliente.getFechaRegistro()
                            +  "," + cliente.getNumTelefono();
                    bw.write(DatosClientesRegular);
                    bw.newLine();


                }
                case "ClienteVIP" -> {
                    ClienteVIP ClienteVip = (ClienteVIP) cliente;
                    bw.write("ClientesVip,");
                    String DatosClienteVip =  cliente.getNombre() + "," + cliente.getDireccion()
                            + "," + cliente.getEmail() + "," + cliente.getFechaRegistro()
                            +  "," + cliente.getNumTelefono();
                    bw.write(DatosClienteVip);
                    bw.newLine();
                }
            }
        }catch (Exception e){
            System.out.println(e);
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
                                libro.getPrecio() + "," + libroFisico.getUbicacion();

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

    private String vendedorToString(Vendedor vendedor){
        return vendedor.getNombre() + ","+ vendedor.getApellido()+ ","+
                vendedor.getDireccion() + "," + vendedor.getTelefono() + ","+
                vendedor.getEmail();
    }

    private Cliente leerCliente(BufferedReader br){
        Cliente cliente = null;
        try{
            String linea;

            linea = br.readLine();
            String[] datosCliente = linea.split(",");

            if (datosCliente.length >= 5) {
                String tipoCliente = datosCliente[0].trim();
                String nombre = datosCliente[1].trim();
                String direccion = datosCliente[2].trim();
                String email = datosCliente[3].trim();



                switch (tipoCliente) {
                    case "ClientesInternacional":

                        cliente = new ClienteInternacional(nombre, direccion, email, LocalDate.parse(datosCliente[4].trim()), Integer.parseInt(datosCliente[5].trim()));
                        // Realizar acciones específicas para clientes internacionales
                        break;
                    case "ClientesMayorista":
                        cliente = new ClienteMayorista(nombre, direccion, email, LocalDate.parse(datosCliente[4].trim()), Integer.parseInt(datosCliente[5].trim()));
                        // Realizar acciones específicas para clientes mayoristas

                        break;
                    case "ClientesOnline":
                        cliente = new ClienteOnline(nombre, direccion, email, LocalDate.parse(datosCliente[4].trim()), Integer.parseInt(datosCliente[5].trim()));
                        break;
                    case "ClientesRegular":
                        cliente = new ClienteRegular(nombre, direccion, email, LocalDate.parse(datosCliente[4].trim()), Integer.parseInt(datosCliente[5].trim()));
                        break;
                    case "ClientesVIP":
                        cliente = new ClienteVIP(nombre, direccion, email, LocalDate.parse(datosCliente[4].trim()), Integer.parseInt(datosCliente[5].trim()));
                        break;
                    default:
                        System.out.println("Tipo de cliente no reconocido: " + tipoCliente);
                }

            } else {
                System.out.println("La línea no tiene suficientes datos para crear un cliente: " + cliente);
            }
        }catch (IOException e) {
            System.out.println("archivo no encontrado IOException ");}

        return cliente;
    }

    private Libros leerLibro(String infoLibro){ ////////////////CORREGIR AQUÍ CUANDO REGRESE
        Libros libro = null;
        String[] datosLibro = infoLibro.split(",");
        if (datosLibro.length >= 5) {
            String tipoLibro = datosLibro[0].trim(); // Primer campo indica el tipo de libro
            String titulo = datosLibro[1].trim();
            String autor = datosLibro[2].trim();
            String genero = datosLibro[3].trim();
            double precio = Double.parseDouble(datosLibro[4].trim());

            switch (tipoLibro) {
                case "Audio":
                    int duracion = Integer.parseInt(datosLibro[5].trim());

                    String idioma = datosLibro[6].trim(); // Obtener el idioma del libro de la posición correcta
                    String tasa = datosLibro[7].trim();
                    libro = new LibroAudio(titulo, autor, genero, precio, duracion, idioma, tasa);

                    break;
                case "Infantil":
                    int edadRecomendada = Integer.parseInt(datosLibro[5].trim()); // Obtener la edad recomendada
                    boolean ilustraciones = Boolean.parseBoolean(datosLibro[6].trim()); // Obtener si tiene ilustraciones
                    int numIlustraciones = Integer.parseInt(datosLibro[7].trim()); // Obtener el número de ilustraciones
                    libro = new LibroInfantil(titulo, autor, genero, precio, edadRecomendada, ilustraciones, numIlustraciones);
                    break;
                case "Electronico":
                    String formato = datosLibro[5].trim(); // Obtener el formato del libro electrónico
                    libro = new LibroElectronico(titulo, autor, genero, precio, formato);

                    break;
                case "Fisico":
                    String ubicacion = datosLibro[5].trim(); // Obtener la ubicación física del libro
                    libro = new LibroFisico(titulo, autor, genero, precio, ubicacion);

                    break;
                default:
                    // Manejo de otros tipos de libros
                    System.out.println("tipo de libro no encontrado");
                    break;
            }

        } else {
            System.out.println("La línea no tiene suficientes datos para crear un libro: " + infoLibro);
        }
        return libro;
    }

}