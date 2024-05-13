package Ensamblador.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormularioAgregarLibro extends JDialog {
    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextField txtID;
    private JTextField txtCampoAdicional1; // Campo adicional para LibroFisico
    private JTextField txtCampoAdicional2; // Campo adicional para LibroElectronico
    private JTextField txtCampoAdicional3; // Campo adicional para LibroAudio
    private JTextField txtCampoAdicional4; // Campo adicional para LibroAudio (segundo campo)
    private JComboBox<String> cmbIlustraciones; // JComboBox para seleccionar si lleva ilustraciones o no
    private JButton btnAgregar;

    public FormularioAgregarLibro(Frame parent, String title, String tipoLibro) {
        super(parent, title, true); // El diálogo será modal y estará asociado al frame parent

        // Configurar el layout del diálogo
        setLayout(new GridLayout(7, 2, 5, 5)); // 7 filas, 2 columnas, espacios de 5px entre componentes

        // Crear los campos de texto y botones
        txtTitulo = new JTextField();
        txtAutor = new JTextField();
        txtID = new JTextField();
        btnAgregar = new JButton("Agregar");

        // Agregar etiquetas y campos de texto al diálogo
        add(new JLabel("Título:"));
        add(txtTitulo);
        add(new JLabel("Autor:"));
        add(txtAutor);
        add(new JLabel("ID:"));
        add(txtID);

        // Dependiendo del tipo de libro, agregamos campos adicionales específicos
        switch (tipoLibro) {
            case "Libro Físico":
                add(new JLabel("Ubicación:"));
                txtCampoAdicional1 = new JTextField();
                add(txtCampoAdicional1);
                break;
            case "Libro Electrónico":
                add(new JLabel("Formato:"));
                txtCampoAdicional2 = new JTextField();
                add(txtCampoAdicional2);
                break;
            case "Libro de Audio":
                add(new JLabel("Duración:"));
                txtCampoAdicional3 = new JTextField();
                add(txtCampoAdicional3);
                add(new JLabel("Idioma:"));
                txtCampoAdicional4 = new JTextField();
                add(txtCampoAdicional4);
                break;
            case "Libro Infantil":
                add(new JLabel("Edad Recomendada:"));
                txtCampoAdicional3 = new JTextField();
                add(txtCampoAdicional3);
                add(new JLabel("Ilustraciones:"));
                cmbIlustraciones = new JComboBox<>(new String[]{"Sí", "No"}); // Opciones de Sí y No para ilustraciones
                add(cmbIlustraciones);
                break;
            default:
                break;
        }

        // Agregar el botón "Agregar" al diálogo
        add(new JLabel()); // Espacio en blanco para alinear el botón
        add(btnAgregar);

        // Configurar el tamaño y la posición del diálogo
        setSize(300, 250);
        setLocationRelativeTo(parent); // Centrar el diálogo respecto al frame parent

        // Configurar el ActionListener para el botón "Agregar"
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes obtener los valores de los campos de texto y realizar la acción de agregar el libro
                String titulo = txtTitulo.getText();
                String autor = txtAutor.getText();
                String id = txtID.getText();
                // Dependiendo del tipo de libro, obtén los valores de los campos adicionales
                String campoAdicional1 = null;
                String campoAdicional2 = null;
                String campoAdicional3 = null;
                String campoAdicional4 = null;
                switch (tipoLibro) {
                    case "Libro Físico":
                        campoAdicional1 = txtCampoAdicional1.getText();
                        break;
                    case "Libro Electrónico":
                        campoAdicional2 = txtCampoAdicional2.getText();
                        break;
                    case "Libro de Audio":
                        campoAdicional3 = txtCampoAdicional3.getText();
                        campoAdicional4 = txtCampoAdicional4.getText();
                        break;
                    case "Libro Infantil":
                        campoAdicional3 = txtCampoAdicional3.getText();
                        campoAdicional4 = (String) cmbIlustraciones.getSelectedItem(); // Obtener la opción seleccionada
                        break;
                    default:
                        break;
                }
                // Luego, puedes realizar la lógica para agregar el libro utilizando estos valores
                // Por ahora, simplemente cerraremos el diálogo
                setVisible(false);
            }
        });
    }
}

