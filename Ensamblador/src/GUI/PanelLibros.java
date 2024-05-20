package Ensamblador.GUI;

import Ensamblador.Ensambladorc.Ensamblador;
import Ensamblador.Librosc.Libros;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class PanelLibros extends JPanel {
    private JTable tablaLibros;
    private JButton btnAgregarLibro;
    private JButton btnBuscarLibro;
    private JButton btnBorrarLibro;
    private JButton btnCancelar;
    private JTextField txtBusqueda;
    private JPanel panelTiposLibro;

    public PanelLibros() {
        setLayout(new BorderLayout());

        tablaLibros = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaLibros);

        actualizarTabla();

        btnAgregarLibro = new JButton("Agregar Libro");
        btnAgregarLibro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarBotoneraTiposLibro();
            }
        });

        btnBuscarLibro = new JButton("Buscar");
        btnBuscarLibro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String criterio = txtBusqueda.getText();
                buscarLibro(criterio);
            }
        });

        btnBorrarLibro = new JButton("Borrar");
        btnBorrarLibro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                borrarLibroSeleccionado();
            }
        });

        txtBusqueda = new JTextField(20);

        panelTiposLibro = new JPanel(new GridBagLayout());
        panelTiposLibro.setVisible(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(5, 5, 5, 5);

        JButton btnLibroFisico = new JButton("Libro Físico");
        JButton btnLibroElectronico = new JButton("Libro Electrónico");
        JButton btnLibroAudio = new JButton("Libro de Audio");
        JButton btnLibroInfantil = new JButton("Libro Infantil");
        btnCancelar = new JButton("Cancelar");

        btnLibroFisico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirFormularioLibro("Libro Físico");
            }
        });

        btnLibroElectronico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirFormularioLibro("Libro Electrónico");
            }
        });

        btnLibroAudio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirFormularioLibro("Libro de Audio");
            }
        });

        btnLibroInfantil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirFormularioLibro("Libro Infantil");
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelTiposLibro.setVisible(false);
            }
        });

        panelTiposLibro.add(btnLibroFisico, gbc);
        panelTiposLibro.add(btnLibroElectronico, gbc);
        panelTiposLibro.add(btnLibroAudio, gbc);
        panelTiposLibro.add(btnLibroInfantil, gbc);
        panelTiposLibro.add(btnCancelar, gbc);

        JPanel panelSuperior = new JPanel();
        panelSuperior.add(new JLabel("Buscar:"));
        panelSuperior.add(txtBusqueda);
        panelSuperior.add(btnBuscarLibro);

        add(panelSuperior, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel();
        panelInferior.add(btnAgregarLibro);
        panelInferior.add(btnBorrarLibro);
        add(panelInferior, BorderLayout.SOUTH);

        add(panelTiposLibro, BorderLayout.EAST);
    }

    public void mostrarBotoneraTiposLibro() {
        panelTiposLibro.setVisible(true);
    }

    public void abrirFormularioLibro(String tipoLibro) {
        FormularioAgregarLibro formulario = new FormularioAgregarLibro((Frame) SwingUtilities.getWindowAncestor(this), "Agregar Libro", tipoLibro);
        formulario.setVisible(true);
        panelTiposLibro.setVisible(false);
        actualizarTabla();
    }

    public void buscarLibro(String criterio) {
        List<Libros> libros = Ensamblador.getLibros();
        DefaultTableModel modelo = (DefaultTableModel) tablaLibros.getModel();
        modelo.setRowCount(0);

        for (Libros libro : libros) {
            if (libro.getTitulo().toLowerCase().contains(criterio.toLowerCase()) ||
                    libro.getAutor().toLowerCase().contains(criterio.toLowerCase()) ||
                    libro.getGenero().toLowerCase().contains(criterio.toLowerCase())) {
                Object[] fila = new Object[]{libro.getTitulo(), libro.getAutor(), libro.getGenero(), libro.getPrecio()};
                modelo.addRow(fila);
            }
        }
    }

    public void borrarLibroSeleccionado() {
        int filaSeleccionada = tablaLibros.getSelectedRow();
        if (filaSeleccionada != -1) {
            String titulo = (String) tablaLibros.getValueAt(filaSeleccionada, 0);
            List<Libros> libros = Ensamblador.getLibros();
            for (Libros libro : libros) {
                if (libro.getTitulo().equals(titulo)) {
                    Ensamblador.eliminarLibro(libro);
                    break;
                }
            }
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un libro para borrar.");
        }
    }

    public void actualizarTabla() {
        List<Libros> libros = Ensamblador.getLibros();
        DefaultTableModel modelo = (DefaultTableModel) tablaLibros.getModel();
        modelo.setColumnIdentifiers(new String[]{"Título", "Autor", "Género", "Precio"});
        modelo.setRowCount(0);
        for (Libros libro : libros) {
            Object[] fila = new Object[]{libro.getTitulo(), libro.getAutor(), libro.getGenero(), libro.getPrecio()};
            modelo.addRow(fila);
        }
    }
}
