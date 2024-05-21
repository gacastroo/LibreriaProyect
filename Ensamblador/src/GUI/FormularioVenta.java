package Ensamblador.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class FormularioVenta extends JFrame {
    private List<Libro> libros = new ArrayList<>();
    private JTextField txtTitulo;
    private JTextField txtPrecio;
    private JTextField txtCliente;
    private JTextField txtVendedor;
    private JTextArea txtAreaLibros;
    private double totalPrecio = 0.0;

    public FormularioVenta(String tipoVenta) {
        super("Registrar Venta - " + tipoVenta);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(0, 2));

        JLabel lblTitulo = new JLabel("Título Libro:");
        txtTitulo = new JTextField(20);

        JLabel lblPrecio = new JLabel("Precio:");
        txtPrecio = new JTextField(20);

        JLabel lblCliente = new JLabel("Cliente:");
        txtCliente = new JTextField(20);

        add(lblTitulo);
        add(txtTitulo);
        add(lblPrecio);
        add(txtPrecio);
        add(lblCliente);
        add(txtCliente);

        if (tipoVenta.equals("Venta Presencial")) {
            JLabel lblVendedor = new JLabel("Vendedor:");
            txtVendedor = new JTextField(20);
            add(lblVendedor);
            add(txtVendedor);
        }

        JButton btnAgregarLibro = new JButton("Agregar Libro");
        btnAgregarLibro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarLibro();
            }
        });
        add(btnAgregarLibro);

        JScrollPane scrollPane = new JScrollPane();
        txtAreaLibros = new JTextArea();
        scrollPane.setViewportView(txtAreaLibros);
        scrollPane.setPreferredSize(new Dimension(400, 200));
        add(scrollPane);

        JButton btnGuardar = new JButton("Guardar");
        JButton btnCancelar = new JButton("Cancelar");

        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarTotal();
                dispose();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        add(btnGuardar);
        add(btnCancelar);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void agregarLibro() {
        String titulo = txtTitulo.getText();
        String precioStr = txtPrecio.getText();
        if (!titulo.isEmpty() && !precioStr.isEmpty()) {
            try {
                double precio = Double.parseDouble(precioStr);
                libros.add(new Libro(titulo, precio));
                txtAreaLibros.append("Título: " + titulo + ", Precio: $" + precio + "\n");
                totalPrecio += precio;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa un precio válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa el título y el precio del libro.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarTotal() {
        JOptionPane.showMessageDialog(this, "El total de la venta es: $" + totalPrecio, "Total de Venta", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new FormularioVenta("Venta Online");
    }
}

class Libro {
    private String titulo;
    private double precio;

    public Libro(String titulo, double precio) {
        this.titulo = titulo;
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecio() {
        return precio;
    }
}
