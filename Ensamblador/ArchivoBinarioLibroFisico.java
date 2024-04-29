package Ensamblador;

import Ensamblador.ArchivoBinario;
import libros.LibroFisico;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ArchivoBinarioLibroFisico extends ArchivoBinario {
    public byte[] datos;

    public void GuardarLibros(List<LibroFisico> librosList){
        File file = new File(super.getRuta());
        try {
            if (!file.exists()) {
                System.out.println("no se encontró");
            }
            FileOutputStream FOS = new FileOutputStream(file);
            ObjectOutputStream OIS = new ObjectOutputStream(FOS);
            OIS.writeInt(librosList.size());

            for (LibroFisico lib : librosList){
                OIS.writeObject(lib);
            }

            FOS.close();
            OIS.close();

            
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Byte> cargarLibros(){
        List<Byte> listaHaEntragar = new ArrayList<Byte>();

        File file = new File(super.getRuta());
        if (file.exists())System.out.println("existe");
        try{
            FileInputStream fis = new FileInputStream(file);
            datos = fis.readAllBytes();

            /*
            File file = new File(System.getProperty("user.dir") + "\\src\\archivozzzz\\ArchivoFisicoBinario.txt");


            sacar objetos del array
            try{
                ByteArrayInputStream bites = new ByteArrayInputStream(datos);
                ObjectInputStream oaa = new ObjectInputStream(bites);
                System.out.println(oaa.readInt());
                System.out.println(oaa.readObject());
            }catch (Exception e){
                e.printStackTrace();
            }*/
            /*
            int x = ois.readInt();
            for (int i = 0; i < x; i++){
                Object objeto = (Object) ois.readObject();
                if (objeto == null) break;

                System.out.println(objeto);
            }*/
        }catch (Exception e){
            e.printStackTrace();
        }
        for (byte b : datos){
            listaHaEntragar.add(b);
        }
        return listaHaEntragar;
    }

}
