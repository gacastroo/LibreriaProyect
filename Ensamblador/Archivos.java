package Ensamblador;

import java.io.*;
import java.util.*;
public class Archivos {
    private String nombre;
    private String extension;
    private String ruta;

    public String getNombre() {
        return nombre;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getExtension() {
        return extension;
    }
    public String getRuta() {
        return ruta;
    }



    @Override
    public String toString() {
        return STR."Archivo{nombre='\{nombre}\{'\''}, extension='\{extension}\{'\''}, ruta='\{ruta}\{'\''}\{'}'}";
    }

    public  ArrayList <Object> leerArchivo(ArrayList<Archivos> archivos) {
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
        // Validar si el archivo existe
        File f;
        FileInputStream fe = null;
        ObjectInputStream objs = null;

        try {
            FileOutputStream fs = new FileOutputStream(f = new File(getRuta()));
            ObjectOutputStream cos = new ObjectOutputStream(fs);

            // Escribe el número total de animales
            for (Object obj : contenido) {
                if (obj == null) continue;
                cos.writeObject(obj);
            }

            if (cos != null) {
                cos.close();
                fs.close();
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }


}
