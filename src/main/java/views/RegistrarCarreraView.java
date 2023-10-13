package views;
import controller.carreraController;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarCarreraView extends JFrame {
    private JTextField nombreCarreraTextField;
    private JTextField codigoCarreraTextField;
    private JTextField cantidadSemestresTextField;
    private JButton cancelarButton;
    private JButton registrarCarreraButton;
    private JPanel panel;

    public RegistrarCarreraView(){
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Registar carrera");
        setContentPane(panel);
        setSize(600,450);
        setLocationRelativeTo(null);
        setResizable(false);
        actionListeners();
    }
    public void actionListeners(){
        registrarCarreraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreCarrera=nombreCarreraTextField.getText();
                String codigoCarrera=codigoCarreraTextField.getText();
                int cantidadSemestres=Integer.parseInt(
                        !cantidadSemestresTextField.getText().matches(
                                "[0-9]+")?"0":
                                cantidadSemestresTextField.getText()
                );
                if(!nombreCarrera.isEmpty() && !codigoCarrera.isEmpty()
                && cantidadSemestres!=0){
                    boolean results=new carreraController().registrarCarrera(
                            nombreCarrera,
                            codigoCarrera,
                            cantidadSemestres
                    );
                    if(results){
                        JOptionPane.showMessageDialog(null,
                                "La carrera fue correctamente agregada");
                    }else{
                        JOptionPane.showMessageDialog(null,
                                "El codigo de la carrera o la carrera ya fue regitrado");
                    }
                }else{
                    JOptionPane.showMessageDialog(
                            null,
                            "Ingrese todos los campos");
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
