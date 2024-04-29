package Ensamblador.TiposClientes;

import Ensamblador.Cliente;
import Ensamblador.Venta;

import java.time.LocalDate;

public class ClienteRegular extends Cliente {
    int tipoCliente = 1;

    public ClienteRegular(String nombre, String direccion, String email, LocalDate parse, int numTelefono) {
        super(nombre, direccion, email, numTelefono);
    }
    public static int VerificarBonificacionRegular(Venta venta) {
        int DescuentoRegular =(int) (venta.getPrecio()*0.9);
        venta.setPrecio(venta.getPrecio()-DescuentoRegular);
        System.out.println("Descuentro de cliente regular aplicado exitosamente.");
        return (int) venta.getPrecio();
    }
}
