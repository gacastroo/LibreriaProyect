package Ensamblador.Archivos.ArchivoClientes;

import Ensamblador.Archivos.Archivos;
import Ensamblador.Clientess.Cliente;
import Ensamblador.Clientess.*;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class ArchivoClientes extends Archivos {


    public ArchivoClientes(String nombre, String extension, String ruta) {
        super(nombre, extension, ruta);
    }

    public void guardarClientes(List<Cliente> clientes) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(super.getRuta()))){
            for (Cliente cliente : clientes) {
                String datosCliente = cliente.getClass().getSimpleName() +"," + cliente.getNombre() + "," +
                        cliente.getDireccion() + "," + cliente.getEmail() + "," +
                        cliente.getFechaRegistro().getDayOfMonth() + "," + cliente.getFechaRegistro().getMonthValue() + "," + cliente.getFechaRegistro().getYear() + "," +
                        cliente.getIdCliente() + "," + cliente.getNumTelefono() + "," + cliente.getPuntosFidelidad() + "," + cliente.getTipoCliente();


                bw.write(datosCliente);
                bw.newLine();

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

                if (datosCliente.length >= 7) {
                    String tipoCliente = datosCliente[0].trim();
                    String nombre = datosCliente[1].trim();
                    String direccion = datosCliente[2].trim();
                    String email = datosCliente[3].trim();
                    LocalDate fechaRegistro = LocalDate.of(Integer.parseInt(datosCliente[6]),
                            Integer.parseInt(datosCliente[5]),Integer.parseInt(datosCliente[4]));
                    int puntosFidelidad = Integer.parseInt(datosCliente[7]);
                    String numero = datosCliente[8];
                    int tipoClientenInt = Integer.parseInt(datosCliente[9]);

                    Cliente cliente;

                    switch (tipoCliente) {
                        case "Cliente" :
                            cliente = new Cliente(nombre,direccion,email,numero,fechaRegistro);
                            cliente.setTipoCliente(tipoClientenInt);
                            cliente.setPuntosFidelidad(puntosFidelidad);
                            break;
                        case "ClienteInternacional":
                            cliente = new ClienteInternacional(nombre,direccion,email,numero,fechaRegistro);
                            cliente.setTipoCliente(tipoClientenInt);
                            cliente.setPuntosFidelidad(puntosFidelidad);
                            break;

                        case "ClienteMayorista":
                            cliente = new ClienteMayorista(nombre,direccion,email,numero,fechaRegistro);
                            cliente.setTipoCliente(tipoClientenInt);
                            cliente.setPuntosFidelidad(puntosFidelidad);
                            break;

                        case "ClienteOnline":
                            cliente = new ClienteOnline(nombre,direccion,email,numero,fechaRegistro);
                            cliente.setTipoCliente(tipoClientenInt);
                            cliente.setPuntosFidelidad(puntosFidelidad);
                            break;

                        case "ClienteRegular":
                            cliente = new ClienteRegular(nombre,direccion,email,numero,fechaRegistro);
                            cliente.setTipoCliente(tipoClientenInt);
                            cliente.setPuntosFidelidad(puntosFidelidad);
                            break;

                        case "ClienteVIP":
                            cliente = new ClienteVIP(nombre,direccion,email,numero,fechaRegistro);
                            cliente.setTipoCliente(tipoClientenInt);
                            cliente.setPuntosFidelidad(puntosFidelidad);
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