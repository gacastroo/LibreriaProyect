package Ensamblador;

import java.io.*;
import java.util.*;
public class Archivos implements Serializable {
    private String nombre;
    private String extension;
    private static String ruta;

    public String getNombre() {
        return nombre;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getExtension() {
        return extension;
    }
    public static String getRuta() {
        return ruta;
    }

    public Archivos(String nombre, String extension, String ruta) {
        this.nombre = nombre;
        this.extension = extension;
        this.ruta = ruta;
    }

    @Override
    public String toString() {
        String s = "Arhivo nombre:" + nombre + "," +"extension = " + extension + ","+ "ruta = " + ruta;
        return s;
    }

    public  ArrayList <Object> leerArchivo(Object[] archivos) {
        File f;
        FileInputStream fe = null;
        ObjectInputStream objs = null;

        ArrayList<Object> devolverContenido = new ArrayList<>();
        try{
            f = new  File(getRuta());

            if (f.exists()){
                fe = new FileInputStream(f);
                objs = new ObjectInputStream(fe);

                while (objs.readObject()!=null){
                    devolverContenido.add((Object) objs);
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return devolverContenido;
    }


    public void escribirArchivo(Object[] contenido) {
        File f = null;

        try {
            FileOutputStream fs = new FileOutputStream(f = new File(getRuta()));
            ObjectOutputStream cos = new ObjectOutputStream(fs);

      
            for (Object obj : contenido) {
                if (obj == null) continue;
                cos.writeObject(obj);
            }

            if (cos != null) {
                cos.close();
            }

            if (fs != null) {
                fs.close();
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }

 

}
