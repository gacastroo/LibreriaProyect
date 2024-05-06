package Ensamblador.TiposClientes;

import Ensamblador.Cliente;

import java.time.LocalDate;

public class ClienteVIP extends Cliente {
    public ClienteVIP(String nombre, String direccion, String email, LocalDate parse, int numTelefono) {
        super(nombre, direccion, email, numTelefono);
    }
    public static void accesoServicioPersonalizado() {
        // Asesoramiento personalizado
        System.out.println("Proporcionando acceso a asesoramiento personalizado para el cliente VIP.");

        // Envío prioritario
        System.out.println("Proporcionando acceso a envío prioritario para el cliente VIP.");

        // Ofertas exclusivas
        System.out.println("Proporcionando acceso a ofertas exclusivas para el cliente VIP.");

        // Servicio de atención al cliente preferencial
        System.out.println("Proporcionando acceso a servicio de atención al cliente preferencial para el cliente VIP.");

        // Invitaciones a eventos exclusivos
        System.out.println("Proporcionando acceso a eventos exclusivos para el cliente VIP.");
    }
    public static int VerificarBonificacionVIP(Ventas venta){ //Método aplicarDescuentoVIP renombrado a VerificarBonificacionVIP
        int DecuentoVIP =(int )(venta.getPrecio()*0.15);
        venta.setPrecio(venta.getPrecio()-DecuentoVIP);
        System.out.println("Descuento VIP aplicado exitosamente");
        return (int) venta.getPrecio();
    }
}