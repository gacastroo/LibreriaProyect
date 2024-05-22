package Ensamblador.GUI;

import Ensamblador.Ensambladorc.Ensamblador;
import Ensamblador.Archivos.Archivos;
import Ensamblador.Clientess.Cliente;
import Ensamblador.Ensambladorc.Ensambladorarchivos;
import Ensamblador.Librosc.Libros;
import Ensamblador.Ventass.Ventas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI {
    private JFrame ventanaPrincipal;
    private PanelLibros panelLibros;
    private PanelClientes panelClientes;
    private PanelVentas panelVentas;
    private PanelReportes panelReportes;
    private Ensamblador ensamblador;

    public GUI(Ensamblador ensamblador) {
        this.ensamblador = ensamblador;

        inicializarVentanaPrincipal();
        configurarComponentes();
        inicializarEventos();
        mostrarVentana();
    }

    public void inicializarVentanaPrincipal() {
        ventanaPrincipal = new JFrame("Gestión de Ventas de Libros");
        ventanaPrincipal.setSize(800, 600);
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setLayout(null);
    }

    public void configurarComponentes() {
        JButton btnLibros = new JButton("Gestión de Libros");
        btnLibros.setBounds(50, 50, 200, 50);
        ventanaPrincipal.add(btnLibros);

        JButton btnClientes = new JButton("Gestión de Clientes");
        btnClientes.setBounds(50, 120, 200, 50);
        ventanaPrincipal.add(btnClientes);

        JButton btnVentas = new JButton("Gestión de Ventas");
        btnVentas.setBounds(50, 190, 200, 50);
        ventanaPrincipal.add(btnVentas);

        JButton btnReportes = new JButton("Gestión de Reportes");
        btnReportes.setBounds(50, 260, 200, 50);
        ventanaPrincipal.add(btnReportes);

        panelLibros = new PanelLibros();
        panelLibros.setBounds(300, 50, 400, 500);
        ventanaPrincipal.add(panelLibros);
        panelLibros.setVisible(false);

        panelClientes = new PanelClientes();
        panelClientes.setBounds(300, 50, 400, 500);
        ventanaPrincipal.add(panelClientes);
        panelClientes.setVisible(false);

        panelVentas = new PanelVentas();
        panelVentas.setBounds(300, 50, 400, 500);
        ventanaPrincipal.add(panelVentas);
        panelVentas.setVisible(false);

        panelReportes = new PanelReportes();
        panelReportes.setBounds(300, 50, 400, 500);
        ventanaPrincipal.add(panelReportes);
        panelReportes.setVisible(false);
    }

    public void inicializarEventos() {
        JButton btnLibros = (JButton) ventanaPrincipal.getContentPane().getComponent(0);
        btnLibros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelLibros.setVisible(true);
                panelClientes.setVisible(false);
                panelVentas.setVisible(false);
                panelReportes.setVisible(false);
            }
        });

        JButton btnClientes = (JButton) ventanaPrincipal.getContentPane().getComponent(1);
        btnClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelLibros.setVisible(false);
                panelClientes.setVisible(true);
                panelVentas.setVisible(false);
                panelReportes.setVisible(false);
            }
        });

        JButton btnVentas = (JButton) ventanaPrincipal.getContentPane().getComponent(2);
        btnVentas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelLibros.setVisible(false);
                panelClientes.setVisible(false);
                panelVentas.setVisible(true);
                panelReportes.setVisible(false);
            }
        });

        JButton btnReportes = (JButton) ventanaPrincipal.getContentPane().getComponent(3);
        btnReportes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelLibros.setVisible(false);
                panelClientes.setVisible(false);
                panelVentas.setVisible(false);
                panelReportes.setVisible(true);
            }
        });
    }

    public void mostrarVentana() {
        ventanaPrincipal.setVisible(true);
    }

    public static void main(String[] args)
    {
        // Crear las listas necesarias
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Libros> libros = new ArrayList<>();
        ArrayList<Archivos> archivos = new ArrayList<>();
        ArrayList<Ventas> ventas = new ArrayList<>();
        // Inicializar la clase Ensamblador
        Ensamblador ensamblador = new Ensamblador(clientes, libros, archivos, ventas);
        Ensambladorarchivos ensambladorarchivos = new Ensambladorarchivos(clientes, libros, archivos, ventas);
        Ensambladorarchivos.setRutaBase("archivostxt");
        ensambladorarchivos.cargarDatosDesdeArchivos();
        GUI gui = new GUI(ensamblador);
        Runtime.getRuntime().addShutdownHook(new Thread(ensambladorarchivos::guardarDatosEnArchivos));

    }
}
