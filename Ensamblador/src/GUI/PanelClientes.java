package Ensamblador.GUI;

import Ensamblador.Clientess.Cliente;
import Ensamblador.Ensambladorc.Ensamblador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        gbc.insets = new Insets(5, 5, 5, 5);

        JButton btnClienteRegular = new JButton("Cliente Regular");
        JButton btnClienteMayorista = new JButton("Cliente Mayorista");
        JButton btnClienteOnline = new JButton("Cliente Online");
        JButton btnClienteInternacional = new JButton("Cliente Internacional");
        btnCancelar = new JButton("Cancelar");

        btnClienteRegular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirFormularioClientes("Cliente Regular");
            }
        });

        btnClienteMayorista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirFormularioClientes("Cliente Mayorista");
            }
        });

        btnClienteOnline.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirFormularioClientes("Cliente Online");
            }
        });

        btnClienteInternacional.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirFormularioClientes("Cliente Internacional");
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelTiposClientes.setVisible(false);
            }
        });

        panelTiposClientes.add(btnClienteRegular, gbc);
        panelTiposClientes.add(btnClienteMayorista, gbc);
        panelTiposClientes.add(btnClienteOnline, gbc);
        panelTiposClientes.add(btnClienteInternacional, gbc);
        panelTiposClientes.add(btnCancelar, gbc);

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

        cargarDatosTabla();
    }

    public void mostrarBotoneraTiposClientes() {
        panelTiposClientes.setVisible(true);
    }

    public void abrirFormularioClientes(String tipoCliente) {
        FormularioAgregarCliente formulario = new FormularioAgregarCliente((Frame) SwingUtilities.getWindowAncestor(this), "Agregar Cliente", tipoCliente);
        formulario.setVisible(true);
        panelTiposClientes.setVisible(false);
        cargarDatosTabla();
    }

    public void buscarCliente(String criterio) {
        DefaultTableModel modelo = (DefaultTableModel) tablaClientes.getModel();
        modelo.setRowCount(0);

        for (Cliente cliente : Ensamblador.getClientes()) {
            if (cliente.getNombre().toLowerCase().contains(criterio.toLowerCase())) {
                modelo.addRow(new Object[]{cliente.getNombre(), cliente.getDireccion(), cliente.getEmail(), cliente.getTelefono()});
            }
        }
    }

    public void borrarClienteSeleccionado() {
        int filaSeleccionada = tablaClientes.getSelectedRow();
        if (filaSeleccionada != -1) {
            String nombreCliente = (String) tablaClientes.getValueAt(filaSeleccionada, 0);
            Cliente clienteAEliminar = null;

            for (Cliente cliente : Ensamblador.getClientes()) {
                if (cliente.getNombre().equals(nombreCliente)) {
                    clienteAEliminar = cliente;
                    break;
                }
            }

            if (clienteAEliminar != null) {
                Ensamblador.eliminarCliente(clienteAEliminar);
                cargarDatosTabla();
            }
        }
    }

    private void cargarDatosTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Dirección");
        modelo.addColumn("Email");
        modelo.addColumn("Teléfono");

        for (Cliente cliente : Ensamblador.getClientes()) {
            modelo.addRow(new Object[]{cliente.getNombre(), cliente.getDireccion(), cliente.getEmail(), cliente.getTelefono()});
        }

        tablaClientes.setModel(modelo);
    }

    public void setTablaClientes(JTable tablaClientes) {
        this.tablaClientes = tablaClientes;
    }

    public JTable getTablaClientes() {
        return tablaClientes;
    }
}
