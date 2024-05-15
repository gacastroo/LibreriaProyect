package Ensamblador.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
        txtFechaRegistro = new JTextField(); // Debería ser un campo de fecha, pero por simplicidad se usa texto
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
                String fechaRegistro = txtFechaRegistro.getText(); // Debería ser un campo de fecha
                int puntosFidelidad = Integer.parseInt(txtPuntosFidelidad.getText());

                // Lógica para agregar el cliente utilizando estos valores
                // Por ahora, simplemente cerraremos el diálogo
                setVisible(false);
            }
        });
    }
}
