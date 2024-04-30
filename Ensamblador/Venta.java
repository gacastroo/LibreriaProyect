package Ensamblador;
import Ensamblador.TiposClientes.ClienteMayorista;
import Ensamblador.TiposClientes.ClienteRegular;
import Ensamblador.TiposClientes.ClienteVIP;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.*;


public class Venta {
    Scanner sc = new Scanner(System.in);
    static double descuento;
    static int idVenta;
    static double Precio;
    static LocalDate fechaVenta;
    static LocalDate FechaEntrega;
    static List<Libros> libroVendidos;
    static ClienteVentas cliente;

    public Venta(Scanner sc, LocalDate fechaVenta, List<Libros> libroVendidos, ClienteVentas cliente) {
        this.sc = sc;
        Venta.fechaVenta = fechaVenta;
        Venta.libroVendidos = libroVendidos;
        Venta.cliente = cliente;
    }

    public Venta() {

    }

    public void setIdVenta(int idVenta) {
        Venta.idVenta = idVenta;
    }

    public static int getIdVenta() {
        return idVenta;
    }

    public static double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        Venta.descuento = descuento;
    }

    public static double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        Venta.fechaVenta = fechaVenta;
    }

    public List<Libros> getLibroVendidos() {
        return libroVendidos;
    }

    public void setLibroVendidos(List<Libros> libroVendidos) {
        Venta.libroVendidos = libroVendidos;
    }

    public void setCliente(ClienteVentas cliente) { Venta.cliente = cliente; }

    public static LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public static List<Libros> getLibrosVendidos() {
        return libroVendidos;
    }

    public static ClienteVentas getCliente() { return cliente;}

    public static LocalDate getFechaEntrega() {return FechaEntrega;}

    public void setFechaEntrega(LocalDate fechaEntrega) {FechaEntrega = fechaEntrega;}

    public void mostrarCliente() {
        System.out.println(cliente.toString());
    }
    public void mostrarLibrosVendidos(){
        for (Libros libroVendidos : libroVendidos){
            System.out.println(libroVendidos.toString());
        }
    }
    public String obtenerDireccionCliente2(ClienteVentas clientes) {
        if (clientes != null) {
            return clientes.getDireccion(); // Devolver la dirección del cliente proporcionado
        } else {
            return "Cliente no disponible";
        }
    }


    public static double calcularTotal() {
        double total = 0;
        for (Libros libro : libroVendidos) {
            total += libro.getPrecio();
        }
        return total;
    }

    public void buscarClienteYMostrarDireccion(String nombreCliente) {
        if (cliente != null && cliente.getNombre().equalsIgnoreCase(nombreCliente)) {
            System.out.println("Dirección del cliente " + nombreCliente + ": " + cliente.getDireccion());
        } else {
            System.out.println("Cliente no encontrado");
        }
    }
    public static void GuardarVenta(Scanner sc, ArrayList<Venta> listaVentas, HashMap<Integer, ClienteVentas> mapaClientes, HashMap<Venta, Integer> mapaVentas) {
        Venta venta = new Venta();
        System.out.println("Ingrese el ID del cliente a buscar: ");
        int idCliente = sc.nextInt();
        sc.nextLine();
        ClienteVentas cliente = mapaClientes.get(idCliente);
        if (cliente != null) {
            int idVenta;
            Random random = new Random();
            do {
                idVenta = random.nextInt(10000);
            } while (mapaVentas.containsValue(idVenta));
            venta.setIdVenta(idVenta);
            mapaVentas.put(venta, idCliente);

            System.out.println("Venta guardada con idCliente de: " + cliente.getIdCliente() +
                    "\nIdVenta de: " + getIdVenta());

            System.out.println("Ingrese el precio de la venta : ");
            int precioVenta = sc.nextInt();
            sc.nextLine();
            venta.setPrecio(precioVenta);
            listaVentas.add(venta);

            System.out.println("""
                    Indique el tipo de Cliente:\s
                    1)Regular
                    2)Mayorista
                    3)Online
                    4)Internacional
                    5)VIP""");
            cliente.setTipoCliente(sc.nextInt());
            ClienteVentas.GuardarPuntosFidelidad(cliente,precioVenta);//Guarda puntos en funcion del precio total de la venta sin descuento
            Descuento(cliente,venta);
            System.out.println("El precio de la compra despues de descuentos pasa de "+precioVenta+" a "+ getPrecio());

            System.out.println("""
                    ¿Desea utilizar sus punto de Fidelidad?
                    1)SI
                    2)NO""");
            if ((sc.nextInt() == 1)&&(cliente.getPuntosFidelidad()>=200)) {
                ClienteVentas.CanjearPuntosFidelidad(cliente, venta);
                System.out.println("El nuevo precio de la venta es: " + getPrecio());
            } else {
                System.out.println("Punto de fidelidad no canjeados");
            }

            CalcularEnvio(sc,venta,cliente);
        } else {
            System.out.println("Cliente no encontrado");
        }

    }
    public static void Descuento(ClienteVentas cliente, Venta venta) {
        switch (cliente.getTipoCliente()){
            case 1 ->{
                ClienteRegular.VerificarBonificacionRegular(venta);
            }
            case 2 ->{
                ClienteMayorista.VerificarBonificacionMayorista(venta);
            }
            case 3 ->{
                //lo que sea
            }
            case 4 ->{}
            case 5 ->{
                ClienteVIP.VerificarBonificacionVIP(venta);
            }
        }
    }

    public static void CalcularEnvio(Scanner sc, Venta venta, ClienteVentas cliente){
        System.out.println("""
                Indique la region del envio:
                1)Africa
                2)America
                3)España
                4)Europa
                5)Oceania
                6)Asia""");
        switch (sc.nextInt()){
            case 1 ->{
                System.out.println("Envio calculado exitosamente" +
                        "\nCosto de envio: 5 euros");
                venta.setPrecio(getPrecio()+5);
                System.out.println("El nuevo precio de la venta es: " + getPrecio());
                LocalDate FechaEntrega= LocalDate.now().plusDays(3);
                venta.setFechaEntrega(FechaEntrega);
                System.out.println("La fecha de entrega esperada es: "+FechaEntrega);
                cliente.setTipoCliente(4);
            }
            case 2 ->{
                System.out.println("Envio calculado exitosamente" +
                        "\nCosto de envio: 4 euros");
                venta.setPrecio(getPrecio()+4);
                System.out.println("El nuevo precio de la venta es: " + getPrecio());
                LocalDate FechaEntrega= LocalDate.now().plusDays(4);
                venta.setFechaEntrega(FechaEntrega);
                System.out.println("La fecha de entrega esperada es: "+FechaEntrega);
                cliente.setTipoCliente(4);
            }
            case 3 ->{
                LocalDate FechaEntrega= LocalDate.now().plusDays(2);
                venta.setFechaEntrega(FechaEntrega);
                System.out.println("La fecha de entrega esperada es: "+FechaEntrega);
                venta.setPrecio(getPrecio());
            }
            case 4 ->{
                System.out.println("Envio calculado exitosamente" +
                        "\nCosto de envio: 2 euros");
                venta.setPrecio(getPrecio()+2);
                System.out.println("El nuevo precio de la venta es: " + getPrecio());
                LocalDate FechaEntrega= LocalDate.now().plusDays(3);
                venta.setFechaEntrega(FechaEntrega);
                System.out.println("La fecha de entrega esperada es: "+FechaEntrega);
                cliente.setTipoCliente(4);
            }
            case 5 ->{
                System.out.println("Envio calculado exitosamente" +
                        "\nCosto de envio: 10 euros");
                venta.setPrecio(getPrecio()+10);
                System.out.println("El nuevo precio de la venta es: " + getPrecio());
                LocalDate FechaEntrega= LocalDate.now().plusDays(10);
                venta.setFechaEntrega(FechaEntrega);
                System.out.println("La fecha de entrega esperada es: "+FechaEntrega);
                cliente.setTipoCliente(4);
            }
            case 6 ->{
                System.out.println("Envio calculado exitosamente" +
                        "\nCosto de envio: 6 euros");
                venta.setPrecio(getPrecio()+6);
                System.out.println("El nuevo precio de la venta es: " + getPrecio());
                LocalDate FechaEntrega= LocalDate.now().plusDays(6);
                venta.setFechaEntrega(FechaEntrega);
                System.out.println("La fecha de entrega esperada es: "+FechaEntrega);
                cliente.setTipoCliente(4);
            }
        }
    }


}