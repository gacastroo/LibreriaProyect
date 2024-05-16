package Ensamblador.Clientess;

import java.time.LocalDate;

public class ClienteInternacional extends Cliente {
    public ClienteInternacional(String nombre, String direccion, String email, int numTelefono, LocalDate fechaRegistro) {
        super(nombre, direccion, email);
    }
    //Método faltante: calcularCostoEnvioInternacional() que ha sido cambiado por CalcularEnvio() y se encuentra en la clase Tienda.
}
