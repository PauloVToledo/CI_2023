package views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class paginaPrincipalView extends JFrame{
    private JButton registrarCarreraButton;
    private JButton registrarEstudianteButton;
    private JButton buscarEstudianteButton;
    private JButton salirButton;
    private JPanel panel;

    public paginaPrincipalView(){
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Bienvenido a el software de intranet con bd en Java");
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
                new RegistrarCarreraView();
                dispose();
            }
        });
        registrarEstudianteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistrarEstudianteView();
                dispose();
            }
        });
        buscarEstudianteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new buscarEstudianteView();
                dispose();
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
