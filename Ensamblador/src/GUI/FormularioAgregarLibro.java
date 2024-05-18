package Ensamblador.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Ensamblador.Librosc.*;
import Ensamblador.Ensambladorc.Ensamblador;


public class FormularioAgregarLibro extends JDialog {
    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextField txtGenero;
    private JTextField txtPrecio;
    private JTextField txtUbicacion;
    private JTextField txtTasa;
    private JTextField txtFormato; // Campo adicional para LibroElectronico
    private JTextField txtDuracion; // Campo adicional para LibroAudio
    private JTextField txtIdioma; // Campo adicional para LibroAudio (segundo campo)
    private JTextField txtIlustraciones; // Campo adicional para LibroAudio (segundo campo)
    private JTextField txtNumIlustraciones; // Campo adicional para LibroAudio (segundo campo)
    private JTextField txtEdadRecomendada; // Campo adicional para LibroAudio (segundo campo)
    private JButton btnAgregar;
    

    public FormularioAgregarLibro(Frame parent, String title, String tipoLibro) {
        super(parent, title, true); // El diálogo será modal y estará asociado al frame parent

        // Configurar el layout del diálogo
        setLayout(new GridLayout(7, 2, 5, 5)); // 7 filas, 2 columnas, espacios de 5px entre componentes

        // Crear los campos de texto y botones
        txtTitulo = new JTextField();
        txtAutor = new JTextField();
        txtPrecio = new JTextField();
        txtGenero = new JTextField();
        txtTasa = new JTextField();
        btnAgregar = new JButton("Agregar");

        // Agregar etiquetas y campos de texto al diálogo
        add(new JLabel("Título:"));
        add(txtTitulo);
        add(new JLabel("Autor:"));
        add(txtAutor);
        add(new JLabel("Genero: "));
        add(txtGenero);
        add(new JLabel("Precio: "));
        add(txtPrecio);
        add(new JLabel("Tasa: "));
        add(txtTasa);
        

        // Dependiendo del tipo de libro, agregamos campos adicionales específicos
        switch (tipoLibro) {
            case "Libro Físico":
                add(new JLabel("Ubicacion:"));
                txtUbicacion = new JTextField();
                add(txtUbicacion);
                break;
            case "Libro Electrónico":
                add(new JLabel("Formato:"));
                txtFormato = new JTextField();
                add(txtFormato);
                break;
            case "Libro de Audio":
                add(new JLabel("Duración:"));
                txtDuracion = new JTextField();
                add(txtDuracion);
                add(new JLabel("Idioma:"));
                txtIdioma = new JTextField();
                add(txtIdioma);
                break;
            case "Libro Infantil":
                add(new JLabel("Edad Recomendada:"));
                txtEdadRecomendada = new JTextField();
                add(txtEdadRecomendada);
                add(new JLabel("Ilustraciones:"));
                txtIlustraciones = new JTextField(); // Opciones de Sí y No para ilustraciones
                add(txtIlustraciones);
                txtNumIlustraciones = new JTextField(); // Opciones de Sí y No para ilustraciones
                add(txtNumIlustraciones);
                break;
            default:
                break;
        }

        // Agregar el botón "Agregar" al diálogo
        add(new JLabel()); // Espacio en blanco para alinear el botón
        add(btnAgregar);

        // Configurar el tamaño y la posición del diálogo
        setSize(300, 250);
        setLocationRelativeTo(parent); // Centrar el diálogo respecto al frame parent

        // Configurar el ActionListener para el botón "Agregar"
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes obtener los valores de los campos de texto y realizar la acción de agregar el libro
                String titulo = txtTitulo.getText();
                String autor = txtAutor.getText();
                String genero = txtGenero.getText();
                double precio = Double.parseDouble(txtPrecio.getText());
                // Dependiendo del tipo de libro, obtén los valores de los campos adicionales
                switch (tipoLibro) {
                    case "Libro Físico":
                        String ubicacion = txtUbicacion.getText();
                        LibroFisico fisico = new LibroFisico(titulo,autor,genero, precio, ubicacion);
                        Ensamblador.agregarLibro(fisico);
                        break;
                    case "Libro Electrónico":
                        String formato = txtFormato.getText();
                        LibroElectronico electronico = new LibroElectronico(titulo,autor,genero,precio,formato);
                        Ensamblador.agregarLibro(electronico);
                        break;
                    case "Libro de Audio":
                        int duracion = Integer.parseInt(txtDuracion.getText());
                        String idioma =  txtIdioma.getText();
                        String tasa =  txtTasa.getText();
                        LibroAudio audio = new LibroAudio(titulo,autor,genero,precio,duracion,idioma,tasa);
                        Ensamblador.agregarLibro(audio);
                        break;
                    case "Libro Infantil":
                        int edadRecomendada = Integer.parseInt(txtEdadRecomendada.getText());
                        boolean ilustraciones = Boolean.parseBoolean(txtIlustraciones.getText());
                        int numIlustraciones = Integer.parseInt(txtNumIlustraciones.getText());
                        LibroInfantil infantil = new LibroInfantil(titulo,autor,genero,precio,edadRecomendada,ilustraciones,numIlustraciones);
                        Ensamblador.agregarLibro(infantil);
                        break;
                    default:
                        break;
                }
                setVisible(false);
            }

        });
    }
}

