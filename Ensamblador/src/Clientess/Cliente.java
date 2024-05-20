package Ensamblador.Clientess;

import Ensamblador.Ventass.Ventas;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Cliente implements Serializable {

    protected String nombre;
    protected String direccion;
    protected String email;
    protected LocalDate fechaRegistro;
    protected int idCliente;
    protected String numTelefono;
    protected int puntosFidelidad;
    protected int tipoCliente;

    public Cliente(String nombre, String direccion, String email, String numTelefono, LocalDate fechaRegistro) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.numTelefono = numTelefono;
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public int getPuntosFidelidad() {
        return puntosFidelidad;
    }

    public int getTipoCliente() {
        return tipoCliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setPuntosFidelidad(int puntosFidelidad) {
        this.puntosFidelidad = puntosFidelidad;
    }

    public void setTipoCliente(int tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public static Cliente buscarClientePorTelefono(String numTelefono, ArrayList<Cliente> listaClientes) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getNumTelefono().equals(numTelefono)) {
                return cliente;
            }
        }
        return null;
    }

    public static Cliente buscarClientePorNombre(String nombre, ArrayList<Cliente> listaClientes) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getNombre().equals(nombre)) {
                return cliente;
            }
        }
        return null;
    }

    public static Cliente clienteBuscadoPorDireccion(String direccion, ArrayList<Cliente> listaClientes) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getDireccion().equals(direccion)) {
                return cliente;
            }
        }
        return null;
    }

    public static void buscarClientePorID(Scanner sc, HashMap<Integer, Cliente> mapaClientes) {
        System.out.println("Ingrese el ID del cliente a buscar: ");
        int id = sc.nextInt();
        sc.nextLine();
        Cliente cliente = mapaClientes.get(id);
        if (cliente != null) {
            System.out.println("¡Cliente encontrado!");
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Direccion: " + cliente.getDireccion());
            System.out.println("Telefono: " + cliente.getNumTelefono());
            System.out.println("Fecha de registro: " + cliente.getFechaRegistro());
            System.out.println("Puntos de fidelidad: " + cliente.getPuntosFidelidad());
            sc.nextLine();
        } else {
            System.out.println("Cliente no encontrado");
        }
    }

    public static void GuardarPuntosFidelidad(Cliente cliente, int precioVenta) {
        cliente.setPuntosFidelidad(cliente.getPuntosFidelidad() + precioVenta);
    }

    public static void CanjearPuntosFidelidad(Cliente cliente, Ventas venta) {
        int PuntosCanjeables = cliente.getPuntosFidelidad();
        int PuntosNoCanjeados = cliente.getPuntosFidelidad() - PuntosCanjeables;
        cliente.setPuntosFidelidad(PuntosNoCanjeados);
        int Descuento = PuntosCanjeables / 20;
        venta.setPrecio(venta.getPrecio() - Descuento);
        System.out.println("Cantidad de puntos de fidelidad a canjear: " + PuntosCanjeables + " equivalentes a " + Descuento + " euros");
        System.out.println("¡Puntos de fidelidad canjeados exitosamente!");
    }

    public String getTelefono() {
        return getNumTelefono();
    }
}
