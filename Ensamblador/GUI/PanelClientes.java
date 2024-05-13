package Ensamblador.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelClientes extends JPanel {
    private JTable tablaClientes;
    private JButton btnAgregarCliente;
    private JButton btnBuscarCliente;
    private JButton btnBorrarCliente;
    private JButton btnCancelar;
    private JTextField txtBusqueda;
    private JPanel panelTiposClientes;

    public PanelClientes() {
        setLayout(new BorderLayout());

        tablaClientes = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaClientes);

        btnAgregarCliente = new JButton("Agregar Cliente");
        btnAgregarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarBotoneraTiposClientes();
            }
        });

        btnBuscarCliente = new JButton("Buscar Cliente");
        btnBuscarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String criterio = txtBusqueda.getText();
                buscarCliente(criterio);
            }
        });

        btnBorrarCliente = new JButton("Borrar");
        btnBorrarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                borrarClienteSeleccionado();
            }
        });

        txtBusqueda = new JTextField(20);

        panelTiposClientes = new JPanel(new GridBagLayout());
        panelTiposClientes.setVisible(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(5, 5, 5, 5); // Espacio entre los botones

        JButton btnClienteRegular = new JButton("Cliente Regular");
        JButton btnClienteVip = new JButton("Cliente VIP");
        JButton btnClienteMayorista = new JButton("Cliente Mayorista");
        JButton btnClienteOnline = new JButton("Cliente Online");
        JButton btnClienteInternacional = new JButton("Cliente Internacional");
        btnCancelar = new JButton("Cancelar");

        // Agregar ActionListener a los botones de tipos de Cliente inspirados en los de libros.
        btnClienteRegular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirFormularioClientes("Cliente Regular");
            }
        });

        btnClienteVip.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirFormularioClientes("Cliente VIP");
            }
        });

        btnClienteMayorista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirFormularioClientes("Cliente Mayorista");
            }
        });

        btnClienteOnline.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  abrirFormularioClientes("Cliente Online");
            }
        });
        btnClienteInternacional.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  abrirFormularioClientes("Cliente Internacional");
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelTiposClientes.setVisible(false); // Ocultar la botonera al cancelar
            }
        });

        panelTiposClientes.add(btnClienteRegular, gbc);
        panelTiposClientes.add(btnClienteVip, gbc);
        panelTiposClientes.add(btnClienteMayorista, gbc);
        panelTiposClientes.add(btnClienteOnline, gbc);
        panelTiposClientes.add(btnClienteInternacional, gbc);
        panelTiposClientes.add(btnCancelar, gbc);

        // Agregar componentes al panel
        JPanel panelSuperior = new JPanel();
        panelSuperior.add(new JLabel("Buscar:"));
        panelSuperior.add(txtBusqueda);
        panelSuperior.add(btnBuscarCliente);

        add(panelSuperior, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel();
        panelInferior.add(btnAgregarCliente);
        panelInferior.add(btnBorrarCliente);
        add(panelInferior, BorderLayout.SOUTH);

        add(panelTiposClientes, BorderLayout.EAST);
    }

    public void mostrarBotoneraTiposClientes() {
        // Mostrar la botonera para seleccionar el tipo deCliente que sea elegido
        panelTiposClientes.setVisible(true);
    }

    public void abrirFormularioClientes(String tipoCliente) {
        // Crear una instancia del formulario para agregar un tipo de cliente elegido
        FormularioAgregarCliente formulario = new FormularioAgregarCliente((Frame) SwingUtilities.getWindowAncestor(this), "Agregar Cliente", tipoCliente);
        formulario.setVisible(true);
        panelTiposClientes.setVisible(false);
    }

    public void buscarCliente(String criterio) {

    }

    public void borrarClienteSeleccionado() {

    }

    public void setTablaClientes(JTable tablaClientes) {
        this.tablaClientes = tablaClientes;
    }

    public JTable getTablaClientes() {
        return tablaClientes;
    }
}
