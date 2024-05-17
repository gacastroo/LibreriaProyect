package Ensamblador.Clientess;

import java.time.LocalDate;

public class ClienteInternacional extends Cliente {
    public ClienteInternacional(String nombre, String direccion, String email, String numTelefono, LocalDate fechaRegistro) {
        super(nombre, direccion, email,numTelefono,fechaRegistro);
    }
    //Método faltante: calcularCostoEnvioInternacional() que ha sido cambiado por CalcularEnvio() y se encuentra en la clase Tienda.
}
