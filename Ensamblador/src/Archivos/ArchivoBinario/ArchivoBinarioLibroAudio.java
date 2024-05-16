package Ensamblador.Archivos.ArchivoBinario;

import Ensamblador.Librosc.LibroAudio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ArchivoBinarioLibroAudio extends ArchivoBinario {
    public byte[] datos;

    public ArchivoBinarioLibroAudio(String nombre, String extension, String ruta) {
        super(nombre, extension, ruta);
    }

    public void GuardarLibros(List<LibroAudio> librosList){
        File file = new File(super.getRuta());
        try {
            if (!file.exists()) {
                System.out.println("no se encontró");
            }
            FileOutputStream FOS = new FileOutputStream(file);
            ObjectOutputStream OIS = new ObjectOutputStream(FOS);
            OIS.writeInt(librosList.size());

            for (LibroAudio lib : librosList){
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

        }catch (Exception e){
            e.printStackTrace();
        }
        for (byte b : datos){
            listaHaEntragar.add(b);
        }
        return listaHaEntragar;
    }
}
