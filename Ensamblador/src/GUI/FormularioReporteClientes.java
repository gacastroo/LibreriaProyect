package Ensamblador.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormularioReporteClientes extends JDialog {
    private JTextField txtNombre;
    private JTextField txtIDCliente;
    private JTextField txtNumTelefono;
    private JTextField txtDireccion;
    private JTextField txtPuntosFidelidad;
    private JButton btnAceptar;
    private JButton btnCancelar;

    public FormularioReporteClientes(Frame parent, String title) {
        super(parent, title, true);

        setLayout(new GridLayout(6, 2, 5, 5));

        txtNombre = new JTextField();
        txtIDCliente = new JTextField();
        txtNumTelefono = new JTextField();
        txtDireccion = new JTextField();
        txtPuntosFidelidad = new JTextField();

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

        add(new JLabel("Nombre:"));
        add(txtNombre);
        add(new JLabel("ID Cliente:"));
        add(txtIDCliente);
        add(new JLabel("Número de Teléfono:"));
        add(txtNumTelefono);
        add(new JLabel("Dirección:"));
        add(txtDireccion);
        add(new JLabel("Puntos de Fidelidad:"));
        add(txtPuntosFidelidad);
        add(btnAceptar);
        add(btnCancelar);

        setSize(300, 200);
        setLocationRelativeTo(parent);
    }

    public String getReporte() {
        String nombre = txtNombre.getText();
        String idCliente = txtIDCliente.getText();
        String numTelefono = txtNumTelefono.getText();
        String direccion = txtDireccion.getText();
        String puntosFidelidad = txtPuntosFidelidad.getText();
        return "Nombre: " + nombre + "\nID Cliente: " + idCliente + "\nNúmero de Teléfono: " + numTelefono + "\nDirección: " + direccion + "\nPuntos de Fidelidad: " + puntosFidelidad;
    }
}
