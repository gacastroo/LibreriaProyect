package Ensamblador.ArchivoClientes;

import Ensamblador.Archivos;
import Ensamblador.Cliente;
import Ensamblador.TiposClientes.*;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class ArchivoClientes extends Archivos {

    List <String> registro = new ArrayList<>();
    void guardarClientes(List<Cliente> clientes) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(super.getRuta()))){
            for (Cliente cliente : clientes) {
                switch (cliente.getClass().getSimpleName()) {

                    case "ClienteInternacional" -> {
                        ClienteInternacional clienteInternacional = (ClienteInternacional) cliente;
                        bw.write("ClientesInternacional,");
                        String DatosClienteInternacinal =  cliente.getNombre()+ "," + cliente.getDireccion() + ","
                                +  cliente.getEmail() + "," + cliente.getFechaRegistro() + ","
                                + cliente.getNumTelefono();

                        bw.write(DatosClienteInternacinal);
                        bw.newLine();

                        registro.add(clienteInternacional.toString());
                    }
                    case "ClienteMayorista" -> {
                        ClienteMayorista clienteMayorista = (ClienteMayorista) cliente;
                        bw.write("ClientesMayorista,");
                        String DatosClienteMayorista = cliente.getNombre() + "," +  cliente.getDireccion()
                                + "," + cliente.getEmail() + "," + cliente.getFechaRegistro() + ","
                                + cliente.getNumTelefono();
                        bw.write(DatosClienteMayorista);
                        bw.newLine();

                        registro.add(clienteMayorista.toString());
                    }
                    case "ClienteOnline" -> {
                        ClienteOnline clienteOnline = (ClienteOnline) cliente;
                        bw.write("ClienteOnline,");
                        String DatosClientesOnline =  cliente.getNombre() + "," + cliente.getDireccion()
                                + "," + cliente.getEmail() + ","  + cliente.getFechaRegistro()
                                +  "," + cliente.getNumTelefono();
                        bw.write(DatosClientesOnline);
                        bw.newLine();

                        registro.add(clienteOnline.toString());
                    }
                    case "ClienteRegular" -> {
                        ClienteRegular clienteRegular = (ClienteRegular) cliente;
                        bw.write("ClienteRegular,");
                        String DatosClientesRegular = cliente.getNombre() + "," + cliente.getDireccion()
                                + "," + cliente.getEmail() + "," + cliente.getFechaRegistro()
                                +  "," + cliente.getNumTelefono();
                        bw.write(DatosClientesRegular);
                        bw.newLine();

                        registro.add(clienteRegular.toString());

                    }
                    case "ClienteVIP" -> {
                        ClienteVIP ClienteVip = (ClienteVIP) cliente;
                        bw.write("ClientesVip,");
                        String DatosClienteVip =  cliente.getNombre() + "," + cliente.getDireccion()
                                + "," + cliente.getEmail() + "," + cliente.getFechaRegistro()
                                +  "," + cliente.getNumTelefono();
                        bw.write(DatosClienteVip);
                        bw.newLine();

                        registro.add(ClienteVip.toString());
                    }
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public List<Cliente> cargar() {
        List<Cliente> clientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(super.getRuta()))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datosCliente = linea.split(",");

                if (datosCliente.length >= 5) {
                    String tipoCliente = datosCliente[0].trim();
                    System.out.println(tipoCliente);
                    String nombre = datosCliente[1].trim();
                    String direccion = datosCliente[2].trim();
                    String email = datosCliente[3].trim();
                    String[] fecha = datosCliente[4].split("-");
                    int[]fecha2 = new int[3];
                    fecha2[0] = Integer.parseInt(fecha[0]);
                    fecha2[1] = Integer.parseInt(fecha[1]);
                    fecha2[2] = Integer.parseInt(fecha[2]);

                    LocalDate fechaX = LocalDate.of(fecha2[0], fecha2[1],fecha2[2]);

                    Cliente cliente;

                    switch (tipoCliente) {
                        case "ClientesInternacional":
                            cliente = new ClienteInternacional(nombre, direccion, email,Integer.parseInt(datosCliente[5].trim()), fechaX);
                            break;

                        case "ClientesMayorista":
                            cliente = new ClienteMayorista(nombre, direccion, email, Integer.parseInt(datosCliente[5].trim()), fechaX);
                            break;

                        case "ClientesOnline":
                            cliente = new ClienteOnline(nombre, direccion, email, Integer.parseInt(datosCliente[5].trim()), fechaX);
                            break;

                        case "ClientesRegular":
                            cliente = new ClienteRegular(nombre, direccion, email, Integer.parseInt(datosCliente[5].trim()), fechaX);
                            break;

                        case "ClientesVIP":
                            cliente = new ClienteVIP(nombre, direccion, email, LocalDate.parse(datosCliente[4].trim()), Integer.parseInt(datosCliente[5].trim()));
                            break;
                        default:
                            System.out.println("Tipo de cliente no reconocido: " + tipoCliente);
                            continue;
                    }
                    clientes.add(cliente);

                } else {
                    System.out.println("La línea no tiene suficientes datos para crear un cliente: " + clientes);
                }
            }
        } catch (IOException e) {
            System.out.println("archivo no encontrado IOException ");}

        return clientes;
    }
}