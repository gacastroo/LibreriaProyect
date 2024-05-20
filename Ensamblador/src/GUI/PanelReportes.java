package Ensamblador.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PanelReportes extends JPanel {
    private JButton btnCrearReporte;
    private JButton btnBorrarReporte;
    private JTable tablaReportes;
    private DefaultTableModel modeloTablaReportes;

    private ArrayList<String> reportes;

    public PanelReportes() {
        setLayout(new BorderLayout());

        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 5, 5));

        btnCrearReporte = new JButton("Crear Reporte");
        btnCrearReporte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearNuevoReporte();
            }
        });
        panelBotones.add(btnCrearReporte);

        btnBorrarReporte = new JButton("Borrar Reporte");
        btnBorrarReporte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                borrarReporteSeleccionado();
            }
        });
        panelBotones.add(btnBorrarReporte);

        add(panelBotones, BorderLayout.NORTH);

        // Configurar la tabla de reportes
        tablaReportes = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaReportes);
        add(scrollPane, BorderLayout.CENTER);

        // Inicializar modelo de la tabla de reportes
        modeloTablaReportes = new DefaultTableModel(new Object[]{"Tipo de Reporte", "Dato Principal"}, 0);
        tablaReportes.setModel(modeloTablaReportes);

        // Inicializar lista de reportes
        reportes = new ArrayList<>();

        // Agregar evento de clic a la tabla de reportes
        tablaReportes.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int filaSeleccionada = tablaReportes.getSelectedRow();
                    if (filaSeleccionada != -1) {
                        String reporteCompleto = reportes.get(filaSeleccionada);
                        mostrarReporteCompleto(reporteCompleto);
                    }
                }
            }
        });
    }

    public void crearNuevoReporte() {
        String[] opciones = {"Reporte de Ventas", "Reporte de Clientes", "Reporte de Libros"};
        String seleccion = (String) JOptionPane.showInputDialog(null, "Selecciona el tipo de reporte:", "Crear Reporte", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        if (seleccion != null) {
            String nuevoReporte = null;
            String datoPrincipal = null;
            switch (seleccion) {
                case "Reporte de Ventas":
                    nuevoReporte = crearReporteVentas();
                    datoPrincipal = obtenerDatoPrincipal(nuevoReporte);
                    break;
                case "Reporte de Clientes":
                    nuevoReporte = crearReporteClientes();
                    datoPrincipal = obtenerDatoPrincipal(nuevoReporte);
                    break;
                case "Reporte de Libros":
                    nuevoReporte = crearReporteLibros();
                    datoPrincipal = obtenerDatoPrincipal(nuevoReporte);
                    break;
                default:
                    break;
            }
            if (nuevoReporte != null && !nuevoReporte.isEmpty()) {
                reportes.add(seleccion + ": " + nuevoReporte);
                modeloTablaReportes.addRow(new Object[]{seleccion, datoPrincipal});
            }
        }
    }

    public String obtenerDatoPrincipal(String reporte) {
        // Dividir el reporte en líneas y obtener el primer dato
        String[] lineas = reporte.split("\n");
        if (lineas.length > 0) {
            return lineas[0];
        } else {
            return "";
        }
    }

    public void borrarReporteSeleccionado() {
        int filaSeleccionada = tablaReportes.getSelectedRow();
        if (filaSeleccionada != -1) {
            reportes.remove(filaSeleccionada);
            modeloTablaReportes.removeRow(filaSeleccionada);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un reporte para borrar.", "Ningún reporte seleccionado", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void mostrarReporteCompleto(String reporteCompleto) {
        JTextArea areaTexto = new JTextArea(reporteCompleto);
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        scrollPane.setPreferredSize(new Dimension(400, 300));
        JOptionPane.showMessageDialog(this, scrollPane, "Reporte Completo", JOptionPane.PLAIN_MESSAGE);
    }

    public String crearReporteVentas() {
        FormularioReporteVentas formulario = new FormularioReporteVentas((Frame) SwingUtilities.getWindowAncestor(this), "Reporte de Ventas");
        formulario.setVisible(true);
        return formulario.getReporte();
    }

    public String crearReporteClientes() {
        FormularioReporteClientes formulario = new FormularioReporteClientes((Frame) SwingUtilities.getWindowAncestor(this), "Reporte de Clientes");
        formulario.setVisible(true);
        return formulario.getReporte();
    }

    public String crearReporteLibros() {
        FormularioReporteLibros formulario = new FormularioReporteLibros((Frame) SwingUtilities.getWindowAncestor(this), "Reporte de Libros");
        formulario.setVisible(true);
        return formulario.getReporte();
    }
}
