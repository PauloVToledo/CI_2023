package views;

import controller.carreraController;
import controller.estudianteController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class RegistrarEstudianteView extends JFrame{
    private JButton cancelarButton;
    private JButton registrarEstudianteButton;
    private JTextField nombreTextField;
    private JTextField rutTextField;
    private JTextField nMatriculaTextField;
    private JComboBox carreraComboBox;
    private JPanel panel;

    public RegistrarEstudianteView(){
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Bienvenido a el software de intranet con bd en Java");
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
        registrarEstudianteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rut=rutTextField.getText();
                String nombre=nombreTextField.getText();
                int nMatricula=Integer.parseInt(
                        !nMatriculaTextField.getText().matches("[0-9]+")?"0":nMatriculaTextField.getText()
                );
                String nombreCarrera= carreraComboBox.getSelectedItem().toString();
                System.out.println(rut+" "+nombre+" "+nMatricula+" "+nombreCarrera);

                if(!rut.isEmpty() && !nombreCarrera.isEmpty() && nMatricula!=0 && !nombreCarrera.isEmpty()){
                    estudianteController estudianteController=new estudianteController();
                    boolean result=estudianteController.registrarEstudiante(rut,nombre,nMatricula,nombreCarrera);
                    if(result){
                        JOptionPane.showMessageDialog(null,"Se registro exitosamente");
                    }else {
                        JOptionPane.showMessageDialog(null,"El estudiante ya ha sido registrado");
                    }
                }else{
                    JOptionPane.showMessageDialog(
                            null,
                            "Se requieren rellenar todos los campos");
                }
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new paginaPrincipalView();
                dispose();
            }
        });
    }
}
