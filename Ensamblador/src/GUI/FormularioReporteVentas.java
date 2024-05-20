package Ensamblador.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FormularioReporteVentas extends JDialog {
    private JTextField txtCodigoVenta;
    private JTextField txtIDCliente;
    private JTextField txtLibros;
    private JFormattedTextField txtFecha;
    private JButton btnAceptar;
    private JButton btnCancelar;
    private String reporte;

    public FormularioReporteVentas(Frame parent, String title) {
        super(parent, title, true);

        setLayout(new GridLayout(6, 2, 5, 5));

        txtCodigoVenta = new JTextField();
        txtIDCliente = new JTextField();
        txtLibros = new JTextField();

        txtFecha = new JFormattedTextField(createFormatter());
        txtFecha.setValue(LocalDate.now());

        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reporte = obtenerDatosReporte();
                dispose();
            }
        });

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reporte = null;
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
        add(txtFecha);
        add(btnAceptar);
        add(btnCancelar);

        setSize(300, 200);
        setLocationRelativeTo(parent);
    }

    private String obtenerDatosReporte() {
        // Aquí obtienes los datos ingresados en el formulario y los formas como un reporte
        String codigoVenta = txtCodigoVenta.getText();
        String idCliente = txtIDCliente.getText();
        String libros = txtLibros.getText();

        String fecha = txtFecha.getText(); // Obtenemos la fecha en formato de texto

        // Formato del reporte
        String reporte = "Código de Venta: " + codigoVenta + "\n" +
                "ID del Cliente: " + idCliente + "\n" +
                "Libros: " + libros + "\n" +
                "Fecha: " + fecha;

        return reporte;
    }

    private static DateTimeFormatter createFormatter() {
        return DateTimeFormatter.ofPattern("yyyy/MM/dd");
    }

    public String getReporte() {
        return reporte;
    }
}
