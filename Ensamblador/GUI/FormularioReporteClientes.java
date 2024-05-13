package Ensamblador.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormularioReporteClientes extends JDialog {
    private JTextField txtIDCliente;
    private JTextField txtNombre;
    private JComboBox<String> comboTipoCliente;
    private JButton btnAceptar;
    private JButton btnCancelar;

    public FormularioReporteClientes(Frame parent, String title) {
        super(parent, title, true);

        setLayout(new GridLayout(5, 2, 5, 5));

        txtIDCliente = new JTextField();
        txtNombre = new JTextField();
        comboTipoCliente = new JComboBox<>();
        comboTipoCliente.addItem("ClienteRegular");
        comboTipoCliente.addItem("ClienteVip");
        comboTipoCliente.addItem("ClienteMayorista");
        comboTipoCliente.addItem("ClienteOnline");
        comboTipoCliente.addItem("ClienteInternacional");

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

        add(new JLabel("ID Cliente:"));
        add(txtIDCliente);
        add(new JLabel("Nombre:"));
        add(txtNombre);
        add(new JLabel("Tipo de Cliente:"));
        add(comboTipoCliente);
        add(btnAceptar);
        add(btnCancelar);

        setSize(300, 200);
        setLocationRelativeTo(parent);
    }
}
