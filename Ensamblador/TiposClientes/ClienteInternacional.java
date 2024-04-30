package Ensamblador.TiposClientes;

import Ensamblador.ClienteVentas;

import java.time.LocalDate;

public class ClienteInternacional extends ClienteVentas {
    public ClienteInternacional(String nombre, String direccion, String email, LocalDate parse, int numTelefono) {
        super(nombre, direccion, email, numTelefono);
    }
    //Método faltante: calcularCostoEnvioInternacional() que ha sido cambiado por CalcularEnvio() y se encuentra en la clase Tienda.
}
