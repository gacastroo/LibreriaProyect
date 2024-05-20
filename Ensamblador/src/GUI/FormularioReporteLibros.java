package Ensamblador.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormularioReporteLibros extends JDialog {
    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JComboBox<String> comboTipoLibro;
    private JButton btnAceptar;
    private JButton btnCancelar;

    public FormularioReporteLibros(Frame parent, String title) {
        super(parent, title, true);

        setLayout(new GridLayout(5, 2, 5, 5));

        txtTitulo = new JTextField();
        txtAutor = new JTextField();
        comboTipoLibro = new JComboBox<>();
        comboTipoLibro.addItem("LibroFisico");
        comboTipoLibro.addItem("LibroElectronico");
        comboTipoLibro.addItem("LibroDeAudio");
        comboTipoLibro.addItem("LibroInfantil");

        btnAceptar = new JButton("Aceptar");
        btnCancelar = new JButton("Cancelar");

        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        add(new JLabel("Título:"));
        add(txtTitulo);
        add(new JLabel("Autor:"));
        add(txtAutor);
        add(new JLabel("Tipo de Libro:"));
        add(comboTipoLibro);
        add(btnAceptar);
        add(btnCancelar);

        setSize(300, 200);
        setLocationRelativeTo(parent);
    }

    public String getReporte() {
        String titulo = txtTitulo.getText();
        String autor = txtAutor.getText();
        String tipoLibro = (String) comboTipoLibro.getSelectedItem();
        return "Título: " + titulo + "\nAutor: " + autor + "\nTipo de Libro: " + tipoLibro;
    }
}
