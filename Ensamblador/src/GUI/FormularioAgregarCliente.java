package Ensamblador.GUI;

import Ensamblador.Clientess.Cliente;
import Ensamblador.Ensambladorc.Ensamblador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class FormularioAgregarCliente extends JDialog {
    private JTextField txtNombre;
    private JTextField txtIdCliente;
    private JTextField txtDireccion;
    private JTextField txtNumTelefono;
    private JTextField txtPuntosFidelidad;
    private JButton btnGuardar;
    private JButton btnCancelar;

    public FormularioAgregarCliente(Frame owner, String title, String tipoCliente) {
        super(owner, title, true);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("ID Cliente:"));
        txtIdCliente = new JTextField();
        add(txtIdCliente);

        add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        add(txtDireccion);

        add(new JLabel("Número de Teléfono:"));
        txtNumTelefono = new JTextField();
        add(txtNumTelefono);

        add(new JLabel("Puntos de Fidelidad:"));
        txtPuntosFidelidad = new JTextField();
        add(txtPuntosFidelidad);

        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String idCliente = txtIdCliente.getText();
                String direccion = txtDireccion.getText();
                String numTelefono = txtNumTelefono.getText();

                int puntosFidelidad;
                try {
                    puntosFidelidad = Integer.parseInt(txtPuntosFidelidad.getText());
                } catch (NumberFormatException ex) {
                    // Manejar la excepción, por ejemplo mostrando un mensaje al usuario
                    JOptionPane.showMessageDialog(FormularioAgregarCliente.this, "Por favor ingresa un número válido para los puntos de fidelidad.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Salir del método para evitar que se cree un Cliente con datos incorrectos
                }

                Cliente nuevoCliente = new Cliente(nombre, direccion, "", numTelefono, LocalDate.now());
                nuevoCliente.setIdCliente(Integer.parseInt(idCliente));
                nuevoCliente.setPuntosFidelidad(puntosFidelidad);

                Ensamblador.agregarCliente(nuevoCliente);
                setVisible(false);
            }
        });
        add(btnGuardar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        add(btnCancelar);

        pack();
        setLocationRelativeTo(owner);
    }
}
