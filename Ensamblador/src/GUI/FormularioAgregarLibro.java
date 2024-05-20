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
    private JTextField txtFormato;
    private JTextField txtDuracion;
    private JTextField txtIdioma;
    private JTextField txtIlustraciones;
    private JTextField txtNumIlustraciones;
    private JTextField txtEdadRecomendada;
    private JButton btnAgregar;

    public FormularioAgregarLibro(Frame parent, String title, String tipoLibro) {
        super(parent, title, true);

        setLayout(new GridLayout(8, 2, 5, 5));

        txtTitulo = new JTextField();
        txtAutor = new JTextField();
        txtPrecio = new JTextField();
        txtGenero = new JTextField();
        txtTasa = new JTextField();
        btnAgregar = new JButton("Agregar");

        add(new JLabel("Título:"));
        add(txtTitulo);
        add(new JLabel("Autor:"));
        add(txtAutor);
        add(new JLabel("Género:"));
        add(txtGenero);
        add(new JLabel("Precio:"));
        add(txtPrecio);
        add(new JLabel("Tasa:"));
        add(txtTasa);

        switch (tipoLibro) {
            case "Libro Físico":
                add(new JLabel("Ubicación:"));
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
                txtIlustraciones = new JTextField();
                add(txtIlustraciones);
                add(new JLabel("Número de Ilustraciones:"));
                txtNumIlustraciones = new JTextField();
                add(txtNumIlustraciones);
                break;
            default:
                break;
        }

        add(new JLabel());
        add(btnAgregar);

        setSize(300, 300);
        setLocationRelativeTo(parent);

        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarLibro(tipoLibro);
            }
        });
    }

    private void agregarLibro(String tipoLibro) {
        String titulo = txtTitulo.getText();
        String autor = txtAutor.getText();
        String genero = txtGenero.getText();
        double precio = Double.parseDouble(txtPrecio.getText());

        switch (tipoLibro) {
            case "Libro Físico":
                String ubicacion = txtUbicacion.getText();
                LibroFisico fisico = new LibroFisico(titulo, autor, genero, precio, ubicacion);
                Ensamblador.agregarLibro(fisico);
                break;
            case "Libro Electrónico":
                String formato = txtFormato.getText();
                LibroElectronico electronico = new LibroElectronico(titulo, autor, genero, precio, formato);
                Ensamblador.agregarLibro(electronico);
                break;
            case "Libro de Audio":
                int duracion = Integer.parseInt(txtDuracion.getText());
                String idioma = txtIdioma.getText();
                String tasa = txtTasa.getText();
                LibroAudio audio = new LibroAudio(titulo, autor, genero, precio, duracion, idioma, tasa);
                Ensamblador.agregarLibro(audio);
                break;
            case "Libro Infantil":
                int edadRecomendada = Integer.parseInt(txtEdadRecomendada.getText());
                boolean ilustraciones = Boolean.parseBoolean(txtIlustraciones.getText());
                int numIlustraciones = Integer.parseInt(txtNumIlustraciones.getText());
                LibroInfantil infantil = new LibroInfantil(titulo, autor, genero, precio, edadRecomendada, ilustraciones, numIlustraciones);
                Ensamblador.agregarLibro(infantil);
                break;
            default:
                break;
        }

        setVisible(false);
    }
}
