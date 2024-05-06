package Ensamblador.ArchivoTexto;

import Ensamblador.Archivos;
import Ensamblador.Libros;
import Ensamblador.Ventas;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/*
public class ArchivoVentas extends Archivo{
    List<String> registro = new ArrayList<>();

    void guardarVenta(List<Venta> ventas){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(super.getRuta()))){
            bw.write("transaccion,");
            String datos = Venta.getFecha()+","+Venta.getCliente()+","+Venta.getLibrosVendidos()+","+Venta.calcularTotal();

            bw.write(datos);
            bw.newLine();
            registro.add(datos);


        }catch (IOException e) {
            System.out.println("archivo no encontrado IOException ");
        }

    }
    public List<Venta> cargar(){
        List<Venta> ventas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(super.getRuta()))){
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datosVenta = linea.split(",");
                if (datosVenta.length >= 4) {
                    Date fecha = Date.valueOf(datosVenta[0].trim());
                    Cliente cliente = datosVenta[1].trim();
                    Libro librosVendidos = datosVenta[2].trim();
                    Double total = Double.valueOf(datosVenta[3].trim());

                    Venta Venta = new Venta(fecha, cliente, librosVendidos,total);
                    ventas.add(Venta);
                }else {
                    System.out.println("no hay mas ventas  ");
                }
            }

        }catch (IOException e) {
            System.out.println("archivo no encontrado IOException ");
        }
        return ventas ;
    }
}*/

public class ArchivoVentas extends Archivos {

    private List<String> registro = new ArrayList<>();
    private Object mapper;


    public void guardarVentas(List<Ventas> ventas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(super.getRuta()))) {
            bw.write("transaccion,");
            bw.write("fecha,cliente,librosVendidos,total,idVenta,descuento,precio,fechaEntrega\n");

            for (Ventas venta : ventas) {
                String datos = Ventas.getFechaVenta().toString() + "," + Ventas.getClientes().toString() + "," + Ventas.getLibrosVendidos().toString() + "," + Ventas.calcularTotal() + "," + Ventas.getIdVenta()+","+ Ventas.getDescuento()+","+ Ventas.getPrecio()+","+ Ventas.getFechaEntrega();
                bw.write(datos);
                bw.newLine();
                registro.add(datos);
            }

        } catch (IOException e) {
            System.out.println("Error al guardar ventas: " + e.getMessage());
        }
    }



    public List<Ventas> cargarVentas() {
        List<Ventas> ventas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(super.getRuta()))) {
            br.readLine();
            String linea;
            List <Libros> libroVendidos = new ArrayList<>();
            while ((linea = br.readLine()) != null) {
                String[] datosVenta = linea.split(",");
                if (datosVenta.length >= 8) {
                    LocalDate fechaVenta = LocalDate.parse(datosVenta[0].trim());
                    List<Cliente> clientes = mapper.datosVenta(datosVenta[1].trim());
                    String librosVendidos = datosVenta[2].trim();
                    Double total = Double.valueOf(datosVenta[3].trim());
                    int idVenta = Integer.parseInt(datosVenta[4].trim());
                    Double descuento = Double.valueOf(datosVenta[5].trim());
                    Double precio = Double.valueOf(datosVenta[6].trim());
                    String fechaEntregaString = datosVenta[7].trim();
                    LocalDate fechaEntrega = LocalDate.parse(fechaEntregaString);

                    //Venta venta= new Venta( fechaVenta,  clientes,  librosVendidos,  total, idVenta,descuento,precio,fechaEntrega);

                    Ventas ventas= new Ventas(fechaVenta,  libroVendidos,  clientes);
                    ventas.add(ventas);
                } else {
                    System.out.println("No hay mas ventas");
                }
            }

        } catch (IOException e) {
            System.out.println("Error al cargar ventas: " + e.getMessage());
        }
        return ventas;
    }

}

