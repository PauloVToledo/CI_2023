package views;

import controller.carreraController;
import controller.estudianteController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class buscarEstudianteView extends JFrame{
    private JTextField nombreEstudianteTextField;
    private JComboBox carreraComboBox;
    private JButton cancelarButton;
    private JButton realizarBusquedaButton;
    private JPanel panel;

    public buscarEstudianteView(){
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Buscar estudiante");
        setContentPane(panel);
        setSize(600,450);
        setLocationRelativeTo(null);
        setResizable(false);
        actionListeners();
        jComboOpcionesInicializadas();
    }
    public void jComboOpcionesInicializadas(){
        ArrayList<String> nombreCarreras=new carreraController().obtenerNombresCarreras();
        for (int i = 0; i < nombreCarreras.size(); i++) {
            carreraComboBox.addItem(nombreCarreras.get(i));
        }
    }
    public void actionListeners(){
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new paginaPrincipalView();
                dispose();
            }
        });
        realizarBusquedaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre=nombreEstudianteTextField.getText();
                String nombreCarrera= Objects.requireNonNull(carreraComboBox.getSelectedItem()).toString();
                if(!nombre.isEmpty() && !nombreCarrera.isEmpty()){
                    estudianteController estudianteController=new estudianteController();
                    estudianteController.estudiantesEncontrados(nombre,nombreCarrera);
                }
            }
        });
    }
}
