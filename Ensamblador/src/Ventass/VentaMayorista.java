package Ensamblador.Ventass;

import Ensamblador.Librosc.Libros;
import Ensamblador.Clientess.Cliente;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class VentaMayorista extends Ventas {

    public VentaMayorista(LocalDate fechaVenta, List<Libros> libroVendidos, Cliente cliente) {
        super(fechaVenta, libroVendidos, cliente);
    }
    public double obtenerDescuentoMayorista() {
        return VentaMayorista.DescuentoDeClienteMayorista(this);
    }
    public static double DescuentoDeClienteMayorista(Ventas venta){
        venta.setDescuento(venta.getPrecio());
        if((venta.getPrecio()<300)&&(venta.getPrecio()>=200)){
            venta.setDescuento(venta.getPrecio()*0.1); //10% de descuento si su compra esta entre 200 y 300
        } else if((venta.getPrecio()>=300)&(venta.getPrecio()<500)){
            venta.setDescuento(venta.getPrecio()*0.15); //15% de descuento si su compra esta entre 300 y 500
        }else if ((venta.getPrecio()>=500)&(venta.getPrecio()<800)){
            venta.setDescuento(venta.getPrecio()*0.2); //20% de descuento si su compra esta entre 500 y 800
        } else{ venta.setDescuento(0);}
        System.out.println("Descuento mayorista aplicado exitosamente.");
        venta.setPrecio(venta.getPrecio()-venta.getDescuento());
        return venta.getDescuento();
    }
}

