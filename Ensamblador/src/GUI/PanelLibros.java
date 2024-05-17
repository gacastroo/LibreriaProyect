package Ensamblador.GUI;

import Ensamblador.Ensambladorc.Ensamblador;
import Ensamblador.Librosc.Libros;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PanelLibros extends JPanel {
    private JTable tablaLibros;
    private JButton btnAgregarLibro;
    private JButton btnBuscarLibro;
    private JButton btnBorrarLibro;
    private JButton btnCancelar;
    private JTextField txtBusqueda;
    private JPanel panelTiposLibro;

    public  PanelLibros() {
        ArrayList<Libros> libros = (ArrayList<Libros>) Ensamblador.getLibros();

        // Configuración del panel
        setLayout(new BorderLayout());

        // Creación de la tabla
        tablaLibros = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaLibros);

        // Llenar el modelo de tabla con los datos del ArrayList
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[]{"Titulo", "Autor", "Genero", "Precio"});
        for (Libros libro : libros) {
            Object[] fila = new Object[]{libro.getTitulo(), libro.getAutor(), libro.getGenero(),libro.getPrecio()};
            modelo.addRow(fila);
        }
        tablaLibros.setModel(modelo);

        // Creación de los botones
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

        // Crear la botonera para seleccionar el tipo de libro
        panelTiposLibro = new JPanel(new GridBagLayout());
        panelTiposLibro.setVisible(false);

        // Configurar restricciones para los botones en el GridBagLayout
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

        // Agregar ActionListener a los botones de tipos de libro
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

        // Agregar componentes al panel
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
        // Mostrar la botonera para seleccionar el tipo de libro
        panelTiposLibro.setVisible(true);
    }

    public void abrirFormularioLibro(String tipoLibro) {
        // Crear una instancia del formulario para agregar un libro
        FormularioAgregarLibro formulario = new FormularioAgregarLibro((Frame) SwingUtilities.getWindowAncestor(this), "Agregar Libro", tipoLibro);
        formulario.setVisible(true); // Mostrar el formulario
        panelTiposLibro.setVisible(false); // Ocultar la botonera después de abrir el formulario
    }

    public void buscarLibro(String criterio) {
        // Aquí implementarías la lógica para buscar un libro en el inventario según un criterio específico
    }

    public void borrarLibroSeleccionado() {
        // Aquí implementarías la lógica para borrar el libro seleccionado en la tabla

    }

    public void setTablaLibros(JTable tablaLibros) {
        this.tablaLibros = tablaLibros;
    }

    public JTable getTablaLibros() {
        return tablaLibros;
    }
}

