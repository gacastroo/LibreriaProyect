package Ensamblador.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class PanelVentas extends JPanel {
    private JTable tablaVentas;
    private DefaultTableModel modeloTabla;
    private JButton btnNuevaVenta;
    private JButton btnBuscarVenta;
    private JButton btnAnularVenta;
    private JTextField txtBusquedaVenta;

    public PanelVentas() {
        setLayout(new BorderLayout());

        // Inicializar la tabla de ventas
        modeloTabla = new DefaultTableModel(new String[]{"Nombre Libro", "Precio", "Cliente", "Tipo Venta", "Total"}, 0);
        tablaVentas = new JTable(modeloTabla);

        btnNuevaVenta = new JButton("Registrar Venta");
        btnBuscarVenta = new JButton("Buscar");
        btnAnularVenta = new JButton("Anular Venta");
        txtBusquedaVenta = new JTextField(20);

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnNuevaVenta);
        panelBotones.add(btnBuscarVenta);
        panelBotones.add(btnAnularVenta);

        JPanel panelBusqueda = new JPanel();
        panelBusqueda.add(new JLabel("Buscar:"));
        panelBusqueda.add(txtBusquedaVenta);

        add(new JScrollPane(tablaVentas), BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
        add(panelBusqueda, BorderLayout.NORTH);

        // ActionListener para el botón de nueva venta
        btnNuevaVenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarBotoneraTiposVenta();
            }
        });

        // ActionListener para el botón de búsqueda de venta
        btnBuscarVenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarVenta(txtBusquedaVenta.getText());
            }
        });

        // ActionListener para el botón de anular venta
        btnAnularVenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                anularVentaSeleccionada();
            }
        });
    }

    public void mostrarBotoneraTiposVenta() {
        JFrame frame = new JFrame("Seleccionar Tipo de Venta");
        frame.setLayout(new GridLayout(3, 1));

        JButton btnVentaMayorista = new JButton("Venta Mayorista");
        JButton btnVentaOnline = new JButton("Venta Online");
        JButton btnVentaPresencial = new JButton("Venta Presencial");

        btnVentaMayorista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarVenta("Venta Mayorista");
                frame.dispose();
            }
        });

        btnVentaOnline.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarVenta("Venta Online");
                frame.dispose();
            }
        });

        btnVentaPresencial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarVenta("Venta Presencial");
                frame.dispose();
            }
        });

        frame.add(btnVentaMayorista);
        frame.add(btnVentaOnline);
        frame.add(btnVentaPresencial);

        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void registrarVenta(String tipoVenta) {
        FormularioVenta formulario = new FormularioVenta(tipoVenta);
        // Lógica para registrar la venta en el sistema con los datos del formulario
    }

    public void buscarVenta(String criterio) {
        // Lógica para buscar venta en el historial
    }

    public void anularVentaSeleccionada() {
        int filaSeleccionada = tablaVentas.getSelectedRow();
        if (filaSeleccionada != -1) {
            // Lógica para anular la venta seleccionada en la tabla
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una venta para anular.");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Panel de Ventas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new PanelVentas());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
