package Ensamblador.Clientess;

import Ensamblador.Ventass.Ventas;

import java.time.LocalDate;

public class ClienteRegular extends Cliente {
    int tipoCliente = 1;

    public ClienteRegular(String nombre, String direccion, String email, String numTelefono, LocalDate fechaRegistro) {
        super(nombre, direccion, email, numTelefono,fechaRegistro);
    }
    public static int VerificarBonificacionRegular(Ventas venta) {
        int DescuentoRegular =(int) (venta.getPrecio()*0.9);
        venta.setPrecio(venta.getPrecio()-DescuentoRegular);
        System.out.println("Descuentro de cliente regular aplicado exitosamente.");
        return (int) venta.getPrecio();
    }
}
