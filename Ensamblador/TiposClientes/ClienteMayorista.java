package Ensamblador.TiposClientes;

import Ensamblador.ClienteVentas;
import Ensamblador.Venta;

import java.time.LocalDate;

public class ClienteMayorista extends ClienteVentas {
    public ClienteMayorista(String nombre, String direccion, String email, LocalDate parse, int numTelefono) {
        super(nombre, direccion, email,parse, numTelefono);
    }
    public static void gestionarPedidoMayorista() {
        // Simulando algunas operaciones de gestión de pedidos para un cliente mayorista
        System.out.println("Gestionando pedido para cliente mayorista...");
        System.out.println("Verificando inventario...");
        System.out.println("Generando orden de compra en grandes cantidades...");
        System.out.println("Asignando fecha de entrega preferida...");
        System.out.println("Confirmando pedido con el cliente mayorista...");
        System.out.println("Pedido gestionado exitosamente para el cliente mayorista.");
    }
    public static int VerificarBonificacionMayorista(Venta venta){
        int DescuentoMayorista= (int) Venta.getPrecio();
        if((Venta.getPrecio()<300)&&(Venta.getPrecio()>=200)){
            DescuentoMayorista= (int) (Venta.getPrecio()*0.1);//10% de descuento si su compra esta entre 200 y 300
        } else if((Venta.getPrecio()>=300)&(Venta.getPrecio()<500)){
            DescuentoMayorista= (int) (Venta.getPrecio()*0.15);//15% de descuento si su compra esta entre 300 y 500
        }else if ((Venta.getPrecio()>=500)&(Venta.getPrecio()<800)){
            DescuentoMayorista= (int) (Venta.getPrecio()*0.2);//20% de descuento si su compra esta entre 500 y 800
        } else{ DescuentoMayorista=0;}
        System.out.println("Descuento mayorista aplicado exitosamente.");
        venta.setPrecio(Venta.getPrecio()-DescuentoMayorista);
        return (int) Venta.getPrecio();
    }
}
