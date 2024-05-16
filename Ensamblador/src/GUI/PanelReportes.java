package Ensamblador.GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelReportes extends JPanel {
    private JButton btnGenerarReporteVentas;
    private JButton btnGenerarReporteClientes;
    private JButton btnGenerarReporteLibros;
    private JButton btnCrearReporte; // Nuevo botón para crear un nuevo reporte
    private JTextArea areaTextoReporte;

    public PanelReportes() {
        // Configuración del panel
        setLayout(new BorderLayout());

        // Creación de los componentes
        btnGenerarReporteVentas = new JButton("Reporte de Ventas");
        btnGenerarReporteVentas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarReporteVentas();
            }
        });

        btnGenerarReporteClientes = new JButton("Reporte de Clientes");
        btnGenerarReporteClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarReporteClientes();
            }
        });

        btnGenerarReporteLibros = new JButton("Reporte de Libros");
        btnGenerarReporteLibros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarReporteLibros();
            }
        });

        btnCrearReporte = new JButton("Crear Reporte"); // Botón para crear un nuevo reporte
        btnCrearReporte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearNuevoReporte();
            }
        });

        areaTextoReporte = new JTextArea();

        // Agregar componentes al panel
        JPanel panelBotones = new JPanel(new GridLayout(1, 4, 5, 5)); // 1 fila, 4 columnas
        panelBotones.add(btnGenerarReporteVentas);
        panelBotones.add(btnGenerarReporteClientes);
        panelBotones.add(btnGenerarReporteLibros);
        panelBotones.add(btnCrearReporte); // Agregar el botón para crear un nuevo reporte

        add(panelBotones, BorderLayout.NORTH);
        add(new JScrollPane(areaTextoReporte), BorderLayout.CENTER);
    }

    public void generarReporteVentas() {
        // Implementar lógica para generar el reporte de ventas
        areaTextoReporte.setText("Reporte de Ventas:\n\n");
        // Aquí se llenaría el área de texto con el reporte de ventas
    }

    public void generarReporteClientes() {
        // Implementar lógica para generar el reporte de clientes
        areaTextoReporte.setText("Reporte de Clientes:\n\n");
        // Aquí se llenaría el área de texto con el reporte de clientes
    }

    public void generarReporteLibros() {
        // Implementar lógica para generar el reporte de libros
        areaTextoReporte.setText("Reporte de Libros:\n\n");
        // Aquí se llenaría el área de texto con el reporte de libros
    }

    public void crearNuevoReporte() {
        // Abrir un diálogo para crear un nuevo reporte
        String[] opciones = {"Reporte de Ventas", "Reporte de Clientes", "Reporte de Libros"};
        String seleccion = (String) JOptionPane.showInputDialog(null, "Selecciona el tipo de reporte:", "Crear Reporte", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        if (seleccion != null) {
            // Dependiendo de la selección, abrir el formulario correspondiente para llenar los datos del reporte
            switch (seleccion) {
                case "Reporte de Ventas":
                    abrirFormularioReporteVentas();
                    break;
                case "Reporte de Clientes":
                    abrirFormularioReporteClientes();
                    break;
                case "Reporte de Libros":
                    abrirFormularioReporteLibros();
                    break;
                default:
                    break;
            }
        }
    }

    public void abrirFormularioReporteVentas() {
        // Aquí abrirías el formulario para el reporte de ventas
        FormularioReporteVentas formulario = new FormularioReporteVentas((Frame) SwingUtilities.getWindowAncestor(this), "Reporte de Ventas");
        formulario.setVisible(true);
    }

    public void abrirFormularioReporteClientes() {
        // Aquí abrirías el formulario para el reporte de clientes
        FormularioReporteClientes formulario = new FormularioReporteClientes((Frame) SwingUtilities.getWindowAncestor(this), "Reporte de Clientes");
        formulario.setVisible(true);
    }

    public void abrirFormularioReporteLibros() {
        // Aquí abrirías el formulario para el reporte de libros
        FormularioReporteLibros formulario = new FormularioReporteLibros((Frame) SwingUtilities.getWindowAncestor(this), "Reporte de Libros");
        formulario.setVisible(true);
    }
}

