package Ensamblador.GUI;


import Ensamblador.Ventass.Ventas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PanelVentas extends JPanel {
    private JTable tablaVentas;
    private DefaultTableModel modeloTabla;
    private JButton btnNuevaVenta;
    private JButton btnBuscarVenta;
    private JButton btnMostrarHistorial;
    private JTextField txtBusquedaVenta;
    private JPanel panelBotonesVentasEspeciales;
    private ArrayList<Ventas> historialVentas;

    public PanelVentas() {
        setLayout(new BorderLayout());
        historialVentas = new ArrayList<>();

        // Inicializar la tabla de ventas
        modeloTabla = new DefaultTableModel(new String[]{"Nombre Libro", "Cliente", "Total"}, 0);
        tablaVentas = new JTable(modeloTabla);

        btnNuevaVenta = new JButton("Registrar Venta");
        btnBuscarVenta = new JButton("Buscar Venta");
        btnMostrarHistorial = new JButton("Mostrar Historial");
        txtBusquedaVenta = new JTextField(20);
        panelBotonesVentasEspeciales = new JPanel(new GridLayout(2, 1));

        // Botones de venta especial
        JButton btnVentaOnline = new JButton("Venta Online");
        JButton btnVentaPresencial = new JButton("Venta Presencial");

        // Agregar ActionListener a los botones de venta especial
        btnVentaOnline.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para venta online
            }
        });

        btnVentaPresencial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para venta presencial
            }
        });

        btnNuevaVenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirFormularioRegistroVenta();
            }
        });

        btnMostrarHistorial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarHistorialVentas();
            }
        });


        panelBotonesVentasEspeciales.add(btnVentaOnline);
        panelBotonesVentasEspeciales.add(btnVentaPresencial);
        panelBotonesVentasEspeciales.setVisible(false);

        btnNuevaVenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarBotonesVentasEspeciales();
            }
        });

        btnBuscarVenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para buscar venta
            }
        });

        btnMostrarHistorial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarHistorialVentas();
            }
        });

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnNuevaVenta);
        panelBotones.add(btnBuscarVenta);
        panelBotones.add(btnMostrarHistorial);

        JPanel panelBusqueda = new JPanel();
        panelBusqueda.add(new JLabel("Buscar:"));
        panelBusqueda.add(txtBusquedaVenta);

        add(new JScrollPane(tablaVentas), BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
        add(panelBusqueda, BorderLayout.NORTH);
        add(panelBotonesVentasEspeciales, BorderLayout.EAST); // Mostrar los botones a la derecha
    }

    private void mostrarHistorialVentas() {
        // Lógica para mostrar el historial de ventas en la interfaz
    }

    private void mostrarBotonesVentasEspeciales() {
        panelBotonesVentasEspeciales.setVisible(true);
    }

    private void registrarNuevaVenta() {
        // Lógica para abrir el formulario de registro de nueva venta
    }



    private void abrirFormularioRegistroVenta() {
        JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Registro de Venta", true);
        dialog.setLayout(new BorderLayout());

        JPanel panelFormulario = new JPanel();
        panelFormulario.add(new JLabel("Nombre del Libro:"));
        JTextField txtNombreLibro = new JTextField(20);
        panelFormulario.add(txtNombreLibro);

        JButton btnConfirmarVenta = new JButton("Confirmar Venta");
        btnConfirmarVenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                dialog.dispose();
            }
        });
        panelFormulario.add(btnConfirmarVenta);


        dialog.add(panelFormulario, BorderLayout.CENTER);


        dialog.setSize(400, 200);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    }



