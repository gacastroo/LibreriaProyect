package Ensamblador.TiposClientes;

import Ensamblador.ClienteVentas;
import Ensamblador.Venta;

import java.time.LocalDate;

public class ClienteRegular extends ClienteVentas {
    int tipoCliente = 1;

    public ClienteRegular(String nombre, String direccion, String email, LocalDate parse, int numTelefono) {
        super(nombre, direccion, email, parse, numTelefono);
    }
    public static void VerificarBonificacionRegular(Venta venta) {
        int DescuentoRegular =(int) (Venta.getPrecio()*0.9);
        venta.setPrecio(Venta.getPrecio()-DescuentoRegular);
        System.out.println("Descuentro de cliente regular aplicado exitosamente.");
    }
}
