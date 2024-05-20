package Ensamblador.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class FormularioReporteVentas extends JDialog {
    private JTextField txtCodigoVenta;
    private JTextField txtIDCliente;
    private JTextField txtLibros;
    private JButton btnAceptar;
    private JButton btnCancelar;
    private JSpinner spinnerFecha;

    public FormularioReporteVentas(Frame parent, String title) {
        super(parent, title, true);

        setLayout(new GridLayout(5, 2, 5, 5));

        txtCodigoVenta = new JTextField();
        txtIDCliente = new JTextField();
        txtLibros = new JTextField();

        // Crear el JSpinner para la fecha
        spinnerFecha = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinnerFecha, "dd/MM/yyyy");
        spinnerFecha.setEditor(dateEditor);
        spinnerFecha.setValue(new Date());

        btnAceptar = new JButton("Aceptar");
        btnCancelar = new JButton("Cancelar");

        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar el código para manejar la aceptación del formulario
                dispose();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        add(new JLabel("Venta:"));
        add(txtCodigoVenta);
        add(new JLabel("Cliente:"));
        add(txtIDCliente);
        add(new JLabel("Libros:"));
        add(txtLibros);
        add(new JLabel("Fecha:"));
        add(spinnerFecha);
        add(btnAceptar);
        add(btnCancelar);

        setSize(300, 200);
        setLocationRelativeTo(parent);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        FormularioReporteVentas dialog = new FormularioReporteVentas(frame, "Reporte de Ventas");
        dialog.setVisible(true);
        System.exit(0);
    }
}
