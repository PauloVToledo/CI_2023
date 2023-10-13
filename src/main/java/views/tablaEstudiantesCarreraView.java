package views;

import model.Estudiante;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class tablaEstudiantesCarreraView extends JFrame{
    private JTable table1;
    private JButton volverALaPaginaButton;
    private JButton realizarOtraBusquedaButton;
    private JPanel panel1;

    public tablaEstudiantesCarreraView(ArrayList<Estudiante>dataEstudiantes){
        setContentPane(panel1);
        setLocationRelativeTo(null); // Centramos la ventana en la pantalla
        setSize(450,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Registrar Clientes");
        actionListeners();
        crearTabla(dataEstudiantes);

    }
    public void actionListeners(){

    }
    public void crearTabla(ArrayList<Estudiante> estudiantes){
        Object[][] datos = new Object[estudiantes.size()][4];
        for (int i = 0; i <estudiantes.size(); i++) {
            Estudiante estudiante=estudiantes.get(i);
            datos[i][0]=estudiante.getRut();
            datos[i][1]=estudiante.getNombre();
            datos[i][2]=estudiante.getnMatricula();
            datos[i][3]=estudiante.getCarrera().getCodigoCarrera();

        }

        table1.setModel(new DefaultTableModel(
                datos,
                new String[]{"Rut","Nombre","N° Matricula","Codigo Carrera"}
        ));
    }

}

