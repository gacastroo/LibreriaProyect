package Ensamblador.Ventas;

import Ensamblador.ClienteVentas;
import Ensamblador.Libros;
import Ensamblador.Venta;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class VentaMayorista extends Venta {

    public VentaMayorista(Scanner sc, LocalDate fechaVenta, List<Libros> libroVendidos, ClienteVentas cliente) {
        super(sc, fechaVenta, libroVendidos, cliente);
    }
    public double obtenerDescuentoMayorista() {
        return VentaMayorista.DescuentoDeClienteMayorista(this);
    }
    public static double DescuentoDeClienteMayorista (Venta venta){
        venta.setDescuento(getPrecio());
        if((getPrecio()<300)&&(getPrecio()>=200)){
            venta.setDescuento(getPrecio()*0.1); //10% de descuento si su compra esta entre 200 y 300
        } else if((getPrecio()>=300)&(getPrecio()<500)){
            venta.setDescuento(getPrecio()*0.15); //15% de descuento si su compra esta entre 300 y 500
        }else if ((getPrecio()>=500)&(getPrecio()<800)){
            venta.setDescuento(getPrecio()*0.2); //20% de descuento si su compra esta entre 500 y 800
        } else{ venta.setDescuento(0);}
        System.out.println("Descuento mayorista aplicado exitosamente.");
        venta.setPrecio(getPrecio()- getDescuento());
        return getDescuento();
    }
}

