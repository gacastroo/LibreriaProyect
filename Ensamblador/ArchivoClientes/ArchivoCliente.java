package Ensamblador.ArchivoClientes;

import Ensamblador.Archivos;
import Ensamblador.Cliente;
import Ensamblador.ClienteVentas;
import Ensamblador.TiposClientes.*;

import java.io.*;
import java.time.LocalDate;
import java.util.*;


public class ArchivoCliente extends Archivos {

    List <String> registro = new ArrayList<>();
    void guardarClientes(List<ClienteVentas> clientes, Cliente cliente) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(super.getRuta()))){
            for (ClienteVentas Cliente : clientes) {
                switch (cliente.getClass().getSimpleName()) {

                    case "ClienteInternacional" -> {
                        ClienteInternacional clienteInternacional = (ClienteInternacional) clientes;
                        bw.write("ClientesInternacional,");
                        String DatosClienteInternacinal =  cliente.getNombre()+ "," + cliente.getDireccion() + ","
                                +  cliente.getEmail() + "," + cliente.getFechaRegistro() + ","
                                + cliente.getNumTelefono();

                        bw.write(DatosClienteInternacinal);
                        bw.newLine();

                        registro.add(clienteInternacional.toString());
                    }
                    case "ClienteMayorista" -> {
                        ClienteMayorista clienteMayorista = (ClienteMayorista) clientes;
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
                        ClienteRegular clienteRegular = (ClienteRegular) clientes;
                        bw.write("ClienteRegular,");
                        String DatosClientesRegular = cliente.getNombre() + "," + cliente.getDireccion()
                                + "," + cliente.getEmail() + "," + cliente.getFechaRegistro()
                                +  "," + cliente.getNumTelefono();
                        bw.write(DatosClientesRegular);
                        bw.newLine();

                        registro.add(clienteRegular.toString());

                    }
                    case "ClienteVIP" -> {
                        ClienteVIP ClienteVip = (ClienteVIP) clientes;
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

    public List<ClienteVentas> cargar() {
        List<ClienteVentas> clientes = new ArrayList<>();
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

                    ClienteVentas Cliente;

                    switch (tipoCliente) {
                        case "ClientesInternacional":

                            Cliente = new ClienteInternacional(nombre, direccion, email, LocalDate.parse(datosCliente[4].trim()), Integer.parseInt(datosCliente[5].trim()));
                            // Realizar acciones específicas para clientes internacionales
                            //((ClienteInternacional) cliente).calcularCostoEnvioInternacional();
                            //((ClienteInternacional) cliente).gestionarAduanas();
                            break;
                        case "ClientesMayorista":
                            Cliente = new ClienteMayorista(nombre, direccion, email, LocalDate.parse(datosCliente[4].trim()), Integer.parseInt(datosCliente[5].trim()));
                            // Realizar acciones específicas para clientes mayoristas

                            break;
                        case "ClientesOnline":
                            Cliente = new ClienteOnline(nombre, direccion, email, LocalDate.parse(datosCliente[4].trim()), Integer.parseInt(datosCliente[5].trim()));
                            break;
                        case "ClientesRegular":
                            Cliente = new ClienteRegular(nombre, direccion, email, LocalDate.parse(datosCliente[4].trim()), Integer.parseInt(datosCliente[5].trim()));
                            break;
                        case "ClientesVIP":
                            Cliente = new ClienteVIP(nombre, direccion, email, LocalDate.parse(datosCliente[4].trim()), Integer.parseInt(datosCliente[5].trim()));
                            break;
                        default:
                            System.out.println("Tipo de cliente no reconocido: " + tipoCliente);
                            continue;
                    }

                } else {
                    System.out.println("La línea no tiene suficientes datos para crear un cliente: " + clientes);
                }
            }
        } catch (IOException e) {
            System.out.println("archivo no encontrado IOException ");}

        return clientes;
    }
}