package Ensamblador.GUI;

import Ensamblador.Clientess.ClienteInternacional;
import Ensamblador.Clientess.ClienteMayorista;
import Ensamblador.Clientess.ClienteOnline;
import Ensamblador.Clientess.ClienteRegular;
import Ensamblador.Librosc.LibroAudio;
import Ensamblador.Librosc.LibroElectronico;
import Ensamblador.Librosc.LibroFisico;
import Ensamblador.Librosc.LibroInfantil;
import Ensamblador.Ensambladorc.Ensamblador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.Properties;

public class FormularioAgregarCliente extends JDialog {
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtEmail;
    private JTextField txtFechaRegistro; // Debería ser un campo de fecha, pero por simplicidad se usa texto
    private JTextField txtPuntosFidelidad;
    private JButton btnAgregar;


    public FormularioAgregarCliente(Frame parent, String title, String tipoCliente) {
        super(parent, title, true); // El diálogo será modal y estará asociado al frame parent

        // Configurar el layout del diálogo
        setLayout(new GridLayout(8, 2, 5, 5)); // 8 filas, 2 columnas, espacios de 5px entre componentes

        // Crear los campos de texto y botones
        txtNombre = new JTextField();
        txtApellido = new JTextField();
        txtDireccion = new JTextField();
        txtTelefono = new JTextField();
        txtEmail = new JTextField();
        // Crear un modelo de fecha
        // Crear un panel de fecha con el modelo
        txtFechaRegistro = new JTextField();
        txtPuntosFidelidad = new JTextField();
        btnAgregar = new JButton("Agregar");

        // Agregar etiquetas y campos de texto al diálogo
        add(new JLabel("Nombre:"));
        add(txtNombre);
        add(new JLabel("Apellido:"));
        add(txtApellido);
        add(new JLabel("Dirección:"));
        add(txtDireccion);
        add(new JLabel("Teléfono:"));
        add(txtTelefono);
        add(new JLabel("Email:"));
        add(txtEmail);
        add(new JLabel("Fecha de Registro:"));
        add(txtFechaRegistro);
        add(new JLabel("Puntos de Fidelidad:"));
        add(txtPuntosFidelidad);

        add(new JLabel()); // Espacio en blanco para alinear el botón y que se vea mejor en la pantalla
        add(btnAgregar);

        setSize(300, 300);
        setLocationRelativeTo(parent); //

        // Configurar el ActionListener para el botón "Agregar"
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes obtener los valores de los campos de texto y realizar la acción de agregar el cliente
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                String direccion = txtDireccion.getText();
                String telefono = txtTelefono.getText();
                String email = txtEmail.getText();
                LocalDate fechaRegistro = LocalDate.parse(txtFechaRegistro.getText()); // Debería ser un campo de fecha
                int puntosFidelidad = Integer.parseInt(txtPuntosFidelidad.getText());
                // Dependiendo del tipo de libro, obtén los valores de los campos adicionales
                switch (tipoCliente) {
                    case "Cliente Internacional":
                        ClienteInternacional internacional = new ClienteInternacional(nombre,direccion,email,telefono,fechaRegistro);
                        break;
                    case "Cliente Mayorista":
                        ClienteMayorista mayorista = new ClienteMayorista(nombre,direccion,email,telefono,fechaRegistro);
                        break;
                    case "Cliente Online":
                        ClienteOnline online = new ClienteOnline(nombre,direccion,email,telefono,fechaRegistro);
                        break;
                    case "Cliente Regular":
                        ClienteRegular regular = new ClienteRegular(nombre,direccion,email,telefono,fechaRegistro);
                        break;
                    default:
                        break;
                }
                // Lógica para agregar el cliente utilizando estos valores
                // Por ahora, simplemente cerraremos el diálogo
                setVisible(false);
            }
        });
    }
}
