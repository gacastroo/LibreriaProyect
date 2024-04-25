package Ensamblador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Cliente {

    //Creación de las variables de la clase cliente.
    String nombre, direccion, email;
    LocalDate fechaRegistro;

    int idCliente, numTelefono, ventas, puntosFidelidad;

    public static void add(Cliente cliente) {
    }

    public static void remove(Cliente cliente) {
    }


    public int getTipoCliente() {
        return TipoCliente;
    }

    public void setTipoCliente(int tipoCliente) {
        TipoCliente = tipoCliente;
    }

    int TipoCliente;

    public int getPuntosFidelidad() {
        return puntosFidelidad;
    }

    public void setPuntosFidelidad(int puntosFidelidad) {
        this.puntosFidelidad = puntosFidelidad;
    }

    // atributo del grupo libros.
    double precio;

    //Constructor completo de la clase cliente.
    public Cliente(String nombre, String direccion, String email, LocalDate fechaRegistro, int numTelefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
        this.numTelefono = numTelefono;
    }


    //Getters y setters.
    public String getNombre() {
        return nombre;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getNumTelefono() {
        return numTelefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    } //Tipo fecha.

    public int getVentas(){
        return ventas;
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
    public void setVentas(int ventas) {
        this.ventas = ventas;
    }


    public void setNumTelefono(int numTelefono) {
        this.numTelefono = numTelefono;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }


    //Metodo para buscar cliente por su número de teléfono. Le pasamos por parametro el numero de teléfono, el
    //ArrayList que contiene los clientes.
    public static Cliente buscarClientePorTelefono(int numTelefono, ArrayList<Cliente> listaClientes) {
        //Recorremos el arreglo de clientes, y si el numero de telefono introducido por parametro es igual al
        //numero de telefono de alguno de los clientes, retornamos la informacion de dicho cliente.
        for (Cliente cliente : listaClientes) {
            if (cliente.getNumTelefono() == numTelefono) {
                return cliente;
            }
        }
        //Si no se encuentra ningun cliente, retornamos null.
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

    public static Cliente clienteBuscadoPorDireccion(String direccion, ArrayList<Cliente> listaClientes, HashMap<Integer, Cliente> mapaClientes) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getDireccion().equals(direccion)) {
                return cliente;
            }
        }
        return null;
    }

    public static void buscarClientePorID(Scanner sc, ArrayList<Cliente> listaClientes, HashMap<Integer, Cliente> mapaClientes) {
        System.out.println("Ingrese el ID del cliente a buscar: ");
        int id = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer del scanner después de leer un entero
        Cliente cliente = mapaClientes.get(id);
        if (cliente != null) {
            System.out.println("¡Cliente encontrado!");
            System.out.println(STR."Nombre: \{cliente.getNombre()} con el ID: \{cliente.getIdCliente()}");
            System.out.println(STR."Direccion: \{cliente.getDireccion()}");
            System.out.println(STR."Telefono: \{cliente.getNumTelefono()}");
            System.out.println(STR."Fecha de registro: \{cliente.getFechaRegistro()}");
            System.out.println(STR."Puntos de fidelidad: \{cliente.getPuntosFidelidad()}");
            sc.nextLine();
        } else {
            System.out.println("Cliente no encontrado");
        }
    }
}
