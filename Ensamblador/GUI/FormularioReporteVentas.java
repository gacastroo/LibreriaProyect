package Ensamblador.GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.Calendar;

public class FormularioReporteVentas extends JDialog {
    private JTextField txtCodigoVenta;
    private JTextField txtIDCliente;
    private JButton btnAceptar;
    private JButton btnCancelar;
    private JSpinner spinnerFecha; // Declarar el JSpinner para la fecha

    public FormularioReporteVentas(Frame parent, String title) {
        super(parent, title, true);

        setLayout(new GridLayout(5, 2, 5, 5));

        txtCodigoVenta = new JTextField();
        txtIDCliente = new JTextField();

        // Crear el JSpinner para la fecha
        spinnerFecha = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinnerFecha, "dd/MM/yyyy");
        spinnerFecha.setEditor(dateEditor);
        spinnerFecha.setValue(new Date());

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

        add(new JLabel("Código de Venta:"));
        add(txtCodigoVenta);
        add(new JLabel("ID Cliente:"));
        add(txtIDCliente);
        add(new JLabel("Fecha:"));
        add(spinnerFecha); // Agregar el JSpinner al formulario
        add(btnAceptar);
        add(btnCancelar);

        setSize(300, 200);
        setLocationRelativeTo(parent);
    }
}

